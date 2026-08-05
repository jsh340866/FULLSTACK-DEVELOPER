# 8. 종목명 필터링 — `endsWith`와 `contains`를 법령 근거에 따라 구분

## 문제 상황

`DartCompanyCollector.collectKrxStockInfo()`가 KRX 상장종목 목록에서 `Company`로 저장할 대상을 추릴 때, 리츠·스팩 종목을 걸러내야 했다. 리츠(부동산 임대수익 배당 투자회사)와 스팩(인수합병 목적 페이퍼컴퍼니)은 PER·PBR·ROE 같은 일반 기업 재무지표로 스크리닝하는 의미가 없는 종목이기 때문이다.

단순히 종목명에 "리츠"가 `contains`되는지로만 걸러내면, "메리츠", "블리츠"처럼 리츠와 무관한 종목까지 오탐으로 걸러지는 문제가 있었다.

## 적용된 해결책

```java
// DartCompanyCollector.isExcludedStock()
// 리츠: 부동산투자회사법상 상호 끝에 "리츠" 의무 표기 → endsWith로 오탐 방지 (메리츠, 블리츠 등 제외)
// 스팩/기업인수목적: 자본시장법상 상호에 반드시 포함 → contains로 충분
private boolean isExcludedStock(String corpName) {
    return corpName.endsWith("리츠")
            || corpName.contains("스팩")
            || corpName.contains("기업인수목적");
}
```

법령이 상호 표기 규칙을 어떻게 강제하는지에 따라 매칭 방식을 다르게 선택했다([DartCompanyCollector.java:348-355](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java#L348-L355)).

- **리츠**: 부동산투자회사법상 상호 **끝**에 "리츠"를 붙이도록 의무화돼 있다. 그래서 `corpName.endsWith("리츠")`로 처리하면, "OO리츠"만 걸리고 "메리츠"("리츠"가 끝이 아님)는 걸리지 않는다.
- **스팩 / 기업인수목적**: 자본시장법상 상호 **어디에든** "스팩"(또는 정식 명칭 "기업인수목적")이 반드시 포함돼야 한다. 위치 제약이 없으므로 `contains`만으로 충분하고, 오탐 위험도 낮다.

## 결론

| 종목 유형 | 법령 근거 | 상호 표기 규칙 | 매칭 방식 |
|---|---|---|---|
| 리츠 | 부동산투자회사법 | 상호 끝에 "리츠" 고정 | `endsWith("리츠")` |
| 스팩 / 기업인수목적 | 자본시장법 | 상호 어디든 포함 | `contains(...)` |

두 매칭 방식을 임의로 고른 게 아니라, 각 법령이 상호 표기를 어떻게 강제하는지에 근거해서 선택했다. `contains`로 전부 통일했다면 "메리츠"·"블리츠" 같은 무관한 종목이 부당하게 스크리닝 대상에서 빠지는 오탐이 생겼을 것이다.

## 관련 코드

- [DartCompanyCollector.java](../../../valuepick/src/main/java/com/example/demo/domain/service/DartCompanyCollector.java) — `isExcludedStock()`, `collectKrxStockInfo()`에서 호출되는 지점
