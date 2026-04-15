# [2월] 프로젝트 설계 및 Git 실무
<details>
  <summary></summary>
  
## 1. UI/UX 및 화면 설계
• **요구사항 정의**: 회원/비회원/관리자 기능 및 예외 처리(인증 실패 등) 설계
• **FlowChart**: draw.io를 활용한 로그인/회원가입 비즈니스 로직 시각화
• **스타일 가이드**: Figma 기반 브랜드 컬러, Inter 폰트, 1920x1080 해상도 설정
• **레이아웃**: 헤더, 메인, 상세 페이지, 결제 프로세스 간소화 설계

## 2. Git 형상 관리
• **기초**: `git init`(저장소 초기화), `git add/commit`(버전 기록)
• **브랜치 전략**: `dev` 브랜치 생성 및 `switch/checkout`을 통한 작업 분리
• **병합(Merge)**: Fast-Forward 및 non-Fast-Forward 방식 차이 학습
• **조회**: `git log --oneline`으로 커밋 히스토리 간결하게 확인

## 3. 주요 프로젝트
• **도서 관리**: CRUD 기반 대여/조회/수정/반납 프로세스 설계
• **요기요 벤치마킹**: PC/Chrome 최적화 및 사용자 편의성 중심의 UI 구성
</details>

# [3월] 자바스크립트 심화 및 외부 라이브러리 활용
<details>
  <summary></summary>
  
## 1. 노드(DOM) 조작 및 CRUD
• **요소 선택**: `getElementById`, `querySelector`, `querySelectorAll`을 활용한 정밀한 요소 접근.
• **유사 배열 처리**: `Array.from()`을 사용해 `NodeList`를 진짜 배열로 변환하여 배열 함수(`forEach` 등) 사용 가능.
• **동적 노드 생성**: `createElement`로 요소를 만들고 `appendChild`로 화면에 붙이는 CRUD의 기초 학습.
• **Form 접근**: `document.forms`나 `name` 속성을 이용해 사용자 입력값에 빠르게 접근하는 방법.

## 2. 비동기 처리와 Swiper 슬라이더
• **동기 vs 비동기**: `setTimeout` 등을 통해 자바스크립트의 실행 순서와 비동기 개념(Sync & Async) 이해.
• **Swiper.js**: 
  - 기본 슬라이드뿐만 아니라 세로형 공지사항, 멀티 슬라이더(4개씩 보기 등) 구현.
  - `autoplay`, `loop`, `pagination`, `navigation` 옵션을 통한 사용자 경험 향상.

## 3. 고급 라이브러리를 활용한 성능 최적화 및 시각화
• **Lodash**: `_.throttle`을 사용하여 스크롤 이벤트 발생 횟수를 제한, 브라우저 성능 최적화.
• **ScrollMagic & GSAP**: 스크롤 위치에 따라 요소가 나타나거나 애니메이션이 시작되는 동적 효과 구현.
• **Chart.js**: 공공데이터(범죄 발생 건수 등)를 활용하여 막대그래프 등 데이터 시각화.
• **QRCODE**: `qrcode.js`를 이용해 웹 주소를 QR 코드로 변환하고 삽입.

## 4. 지도 서비스 및 부트스트랩(Bootstrap)
• **Leaflet & Geocoder**: 
  - 지도 생성 및 마커 표시.
  - 지오코더를 통해 '주소'와 '좌표' 사이를 변환하는 비동기 요청(`fetch`) 처리.
• **Bootstrap 5**:
  - `Card`, `Nav & Tabs`, `Modal` 등 이미 만들어진 UI 컴포넌트를 활용한 빠른 레이아웃 구축.
  - 클래스 기반의 편리한 스타일링 적용.
</details>
