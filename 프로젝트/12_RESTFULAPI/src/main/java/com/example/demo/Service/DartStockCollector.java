package com.example.demo.Service;

import com.example.demo.Entity.Company;
import com.example.demo.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DartStockCollector {

    // Company 데이터 조회/저장용 Repository
    private final CompanyRepository companyRepository;

    @Value("${dart.api.key}")
    private String apiKey;

    // DART 주식수 API URL
    private static final String BASE_URL =
            "https://opendart.fss.or.kr/api/stockTotqySttus.json";

    // 보고서코드: 11011 = 사업보고서 (연간)
    private static final String REPRT_CODE = "11011";

    @Transactional
    public void collectStockCount(String bsnsYear) {

        // DB에서 상장된 전체 기업 조회
        List<Company> companies = companyRepository.findAll();

        // HTTP 요청 객체
        RestTemplate restTemplate = new RestTemplate();

        // 성공/실패 카운트
        int successCount = 0;
        int failCount = 0;

        for (Company company : companies) {

            try {

                // DART API 요청 URL 조합
                String url = BASE_URL
                        + "?crtfc_key=" + apiKey
                        + "&corp_code=" + company.getCorpCode()
                        + "&bsns_year=" + bsnsYear
                        + "&reprt_code=" + REPRT_CODE;

                // API 호출 후 Map으로 응답 받기
                Map<String, Object> response =
                        restTemplate.getForObject(url, Map.class);

                // 응답 자체가 null이면 스킵
                if (response == null) {
                    log.warn("[{}] 응답 없음", company.getCorpCode());
                    failCount++;
                    continue;
                }

                // DART API 상태코드 확인 ("000" = 정상)
                String status = (String) response.get("status");

                // 정상 응답이 아니면 스킵 (데이터 없는 기업 존재)
                if (!"000".equals(status)) {
                    log.debug("[{}] 데이터 없음 - status: {}", company.getCorpCode(), status);
                    failCount++;
                    continue;
                }

                // 응답 list 꺼내기
                List<Map<String, Object>> list =
                        (List<Map<String, Object>>) response.get("list");

                // list가 없거나 비어있으면 스킵
                if (list == null || list.isEmpty()) {
                    failCount++;
                    continue;
                }

                // 첫 번째 항목 사용
                Map<String, Object> item = list.get(0);

                // 총발행주식수 문자열 추출
                String istcTotqyStr = (String) item.get("istc_totqy");

                // 유통주식수 문자열 추출
                String distbStockCoStr = (String) item.get("distb_stock_co");

                // 총발행주식수: null, 공백, "-" 가 아닌 경우만 파싱
                if (istcTotqyStr != null
                        && !istcTotqyStr.isBlank()
                        && !istcTotqyStr.equals("-")) {

                    // 콤마 제거 후 Long 변환 후 저장
                    long istcTotqy = Long.parseLong(
                            istcTotqyStr.replace(",", "").trim()
                    );
                    company.setIstcTotqy(istcTotqy);
                }

                // 유통주식수: null, 공백, "-" 가 아닌 경우만 파싱
                if (distbStockCoStr != null
                        && !distbStockCoStr.isBlank()
                        && !distbStockCoStr.equals("-")) {

                    // 콤마 제거 후 Long 변환 후 저장
                    long distbStockCo = Long.parseLong(
                            distbStockCoStr.replace(",", "").trim()
                    );
                    company.setDistbStockCo(distbStockCo);
                }

                // @Transactional + dirty checking으로 자동 update (saveAll 불필요)
                successCount++;

            } catch (Exception e) {
                log.warn("[{}] 주식수 수집 실패 - {}", company.getCorpCode(), e.getMessage());
                failCount++;
            }
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }

        // 최종 결과 로그
        log.info("주식수 수집 완료 - 성공: {}건, 실패/없음: {}건", successCount, failCount);
    }
}