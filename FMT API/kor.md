# FMP API 전체 문서 (한국어)

> 출처: https://site.financialmodelingprep.com/developer/docs
> 수집: **263개 API** — 링크 텍스트에 **"API"** 포함된 모든 `<a>` 링크
> Base URL: `https://financialmodelingprep.com/stable/`
> 번역: APIs 1–50 (한국어 번역본)

## 인증

모든 요청에 API 키 필요: `?apikey=YOUR_API_KEY` 또는 헤더 `apikey: YOUR_API_KEY`

## API 목록 (263개 엔드포인트)
### 1. 1 Hour Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-1-hour

**Summary:**

FMP 1시간 간격 주식 차트 API를 통해 시간별 주가 움직임을 추적하세요. 각 시간대의 시가, 고가, 저가, 종가 등 핵심 주가 및 거래량 데이터에 접근하여 장중 추세를 정밀하게 분석할 수 있습니다.

**About:**

FMP 1시간 간격 주식 차트 API는 시간별 주가 움직임을 모니터링하고자 하는 트레이더 및 투자자에게 최적화되어 있습니다. 매 시간 핵심 가격 지표를 제공함으로써, 장중 주가 추세를 명확하고 종합적으로 파악할 수 있습니다. 주요 기능은 다음과 같습니다:

Hourly Price Data: 매 시간 업데이트되는 시가, 고가, 저가, 종가에 접근하여 거래일 전반에 걸친 주가 흐름을 놓치지 않습니다.
Volume Tracking: 시간별 거래량 데이터를 통해 하루 중 특정 시간대의 시장 활동과 유동성을 파악합니다.
Broader Timeframe Analysis: 중장기 장중 추세에 집중하는 트레이더에게 적합하며, 보다 넓은 시간 범위에서 가격 움직임을 시각화하는 데 도움을 줍니다.
Historical Data: 과거 시간별 데이터를 조회하여 이전 가격 흐름을 분석하고 시간에 따른 추세를 파악합니다.
Ideal for Trend and Pattern Recognition: 이 데이터를 활용하여 시간별 구간에서 지지선, 저항선, 추세 반전 등 핵심 패턴을 식별합니다.

Example Use Case
스윙 트레이더가 1시간 간격 주식 차트 API를 활용하여 하루 동안 애플 주식의 시간별 성과를 추적하고, 관찰된 추세와 거래량 변화를 바탕으로 합리적인 매수 및 매도 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1hour?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 15:30:00",
		"open": 232.29,
		"low": 232.01,
		"high": 233.13,
		"close": 232.37,
		"volume": 15079381
	}
]
```

---

### 2. 1 Min Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-1-min

**Summary:**

FMP 1분 간격 주식 차트 API를 통해 정밀한 장중 주가 및 거래량 데이터에 접근하세요. 1분 단위로 실시간 또는 과거 주가 데이터를 조회할 수 있으며, 각 분당 시가, 고가, 저가, 종가 및 거래량 등 핵심 정보를 제공합니다.

**About:**

FMP 1분 간격 주식 차트 API는 기술적 분석, 고빈도 거래, 또는 알고리즘 전략을 위해 세밀한 장중 주가 데이터가 필요한 트레이더, 분석가, 투자자를 위해 설계되었습니다. 이 API로 다음이 가능합니다:

Detailed Intraday Data: 1분 단위로 시가, 고가, 저가, 종가를 포함한 주가 데이터와 각 분의 거래량을 확인합니다.
Real-Time and Historical Data: 실시간 분 단위 데이터에 접근하거나, 특정 날짜 범위를 지정하여 과거 데이터를 조회함으로써 장기 분석이 가능합니다.
Customization with Date Parameters: "from" 및 "to" 파라미터를 설정하여 30년 이상의 과거 데이터를 포함한 원하는 기간의 데이터를 손쉽게 가져올 수 있습니다.
Intraday Charting: 단기 주가 움직임에 대한 심층적인 인사이트를 제공하는 세밀한 장중 차트 구축에 최적입니다.
Perfect for Day Traders: 데이트레이더 또는 알고리즘 트레이더에게 단기 추세, 변동, 거래 기회를 포착하는 데 필요한 정밀도를 제공합니다.

Example Use Case
데이트레이더가 1분 간격 주식 차트 API를 활용하여 거래일 내내 애플 주가 움직임을 추적하고, 실시간 가격 변화와 거래량 급등을 기반으로 적시에 매수 및 매도 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1min?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 15:59:00",
		"open": 233.01,
		"low": 232.72,
		"high": 233.13,
		"close": 232.79,
		"volume": 720121
	}
]
```

---

### 3. 1-Hour Interval Commodities Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-intraday-1-hour

**Summary:**

FMP 1시간 간격 원자재 차트 API를 통해 시간별 가격 움직임과 추세를 모니터링하세요. 이 API는 시간별 데이터를 제공하여 거래일 전반에 걸친 가격 변동을 상세히 파악하고, 중기 트레이딩 전략 및 시장 분석을 지원합니다.

**About:**

FMP 1시간 간격 원자재 차트 API는 원자재의 1시간 단위 가격 데이터(시가, 고가, 저가, 종가 및 거래량 포함)에 대한 접근을 제공합니다. 이 데이터는 시간별 추세를 추적해야 하는 트레이더와 분석가에게 이상적이며, 단기 및 일별 가격 분석 사이의 균형을 제공합니다. 시간별 구간에 집중함으로써 분 단위 노이즈를 피하면서 의미 있는 장중 움직임을 포착할 수 있습니다.

Hourly Trend Monitoring: 시간별 업데이트로 원자재의 가격 움직임과 추세를 추적하여 하루 동안의 시장 방향성을 보다 명확하게 파악합니다.
Detailed Pricing Information: 특정 시간대의 시장 활동을 이해하기 위해 각 시간의 시가, 고가, 저가, 종가 및 거래량을 조회합니다.
Mid-Term Strategy Support: 시간별 데이터를 활용하여 장중 추세를 파악하고, 트레이더가 보다 정보에 입각한 결정을 내리며 중기 전략을 정교화하는 데 도움을 줍니다.

이 API는 거래일 전반에 걸친 가격 추세를 모니터링하고자 하는 트레이더, 투자자, 분석가에게 유용한 도구로, 전략적 거래를 위한 실행 가능한 인사이트를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1hour?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 11:30:00",
		"open": 3378.4,
		"low": 3373.1,
		"high": 3378.8,
		"close": 3374.4,
		"volume": 7108
	}
]
```

---

### 4. 1-Hour Interval Cryptocurrency Data API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-intraday-1-hour

**Summary:**

1시간 간격 암호화폐 데이터 API를 통해 암호화폐의 상세한 1시간 단위 장중 가격 데이터에 접근하세요. 시간별 가격 움직임을 추적하여 시장 추세에 대한 인사이트를 얻고, 하루 종일 정보에 기반한 거래 결정을 내릴 수 있습니다.

**About:**

1시간 간격 암호화폐 데이터 API는 암호화폐 가격에 대한 핵심 시간별 업데이트를 제공하여 시장 변동을 세밀하게 파악할 수 있게 해줍니다:

Hourly Price Updates: 매 시간 업데이트되는 시가, 고가, 저가, 종가(OHLC) 및 거래량을 포함한 암호화폐 가격 데이터를 수신합니다.
Comprehensive Market Monitoring: 시간별 데이터를 활용하여 시장 추세를 모니터링하고, 가격 모멘텀을 추적하며, 잠재적인 거래 기회를 식별합니다.
Effective for Trend Analysis: 시간별 구간을 활용하여 장중 가격 패턴을 관찰하고, 데이트레이딩, 스윙 트레이딩, 또는 장기 분석에 더 나은 결정을 내릴 수 있습니다.

이 API는 거래일 동안 가격이 어떻게 변화하는지 면밀히 파악하고자 하는 트레이더와 투자자에게 이상적이며, 빠르게 변화하는 시장에서 신속하게 대응할 수 있도록 지원합니다.

Example Use Case
스윙 트레이더가 1시간 간격 암호화폐 데이터 API를 활용하여 이더리움 가격을 모니터링합니다. 시간별 추세를 분석하여 잠재적인 브레이크아웃이나 풀백을 포착하고 포지션을 적절히 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1hour?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:00:00",
		"open": 119189.36,
		"low": 118768.68,
		"high": 119272.88,
		"close": 118797.03,
		"volume": 1493617925.6888888
	}
]
```

---

### 5. 1-Hour Interval Forex Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-intraday-1-hour

**Summary:**

1시간 외환 간격 차트 API를 통해 거래일 전반에 걸친 외환 가격 움직임을 추적하세요. 이 도구는 통화 쌍에 대한 시간별 장중 데이터를 제공하여 추세와 시장 변화를 상세히 파악할 수 있습니다.

**About:**

1시간 외환 간격 차트 API는 1시간 단위로 포괄적인 OHLC(시가, 고가, 저가, 종가) 가격 및 거래량 데이터를 제공합니다. 다음이 필요한 외환 트레이더 및 분석가에게 필수적인 도구입니다:

Monitor Intraday Market Activity: 거래일 전반에 걸쳐 1시간 단위로 가격 변화를 추적하여 추세나 반전을 더 쉽게 포착합니다.
Analyze Long-Term Intraday Patterns: 1시간 데이터를 활용하여 거래일 동안 통화 쌍의 광범위한 움직임에 대한 인사이트를 얻습니다.
Support Swing Trading Strategies: 시간별 업데이트를 통해 중기 전략으로 운영하는 트레이더에게 최적이며, 더 큰 시장 추세에 반응할 수 있습니다.

적극적으로 거래하거나 시장 분석을 수행하는 경우, 1시간 외환 간격 차트 API는 변화하는 시장 상황을 바탕으로 정보에 입각한 결정을 내리는 데 필요한 데이터를 제공합니다.

Example Use Case
스윙 트레이딩 전략을 최적화하려는 외환 분석가가 1시간 외환 간격 차트 API를 사용하여 USD/JPY 통화 쌍의 가격 움직임을 추적합니다. 시간별 변화를 모니터링하여 가격 통합 구간을 식별하고 그에 맞게 거래를 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1hour?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:00:00",
		"open": 1.17639,
		"low": 1.17571,
		"high": 1.1773,
		"close": 1.17578,
		"volume": 4909
	}
]
```

---


### 6. 1-Hour Interval Index Price API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-intraday-1-hour

**Summary:**

Intraday 1-Hour Price Data API를 사용하여 주식 인덱스의 1시간 간격 장중 데이터에 액세스하세요. 이 API는 시간 단위 간격 내에서 상세한 가격 변동과 거래량을 제공하며, 거래일 동안의 중기 시장 트렌드를 추적하는 데 이상적입니다.

**About:**

FMP Intraday 1-Hour Price Data API는 주식 인덱스의 시간별 가격 데이터를 제공하여 분석가와 트레이더가 하루 동안의 시장 트렌드와 가격 변동을 추적할 수 있게 합니다. 각 시간대별 시가, 고가, 저가, 종가를 제공하며, 중기 장중 성과를 모니터링하는 데 적합합니다. 주요 기능은 다음과 같습니다:

Hourly Interval Data: 거래일 전반에 걸쳐 1시간 간격으로 주식 인덱스의 시가, 고가, 저가, 종가를 조회합니다.
Track Medium-Term Movements: 분 단위의 변동보다는 시간 단위 창 내의 트렌드를 관찰하고자 하는 트레이더와 분석가에게 최적입니다.
Volume Data: 시간별 거래량을 분석하여 시장 활동 및 유동성에 대한 인사이트를 얻습니다.
Intraday Trading Support: 과도한 세분화 없이 상세 데이터가 필요한 스윙 트레이더 및 중기 전략에 이상적입니다.

이 API는 시간 단위 간격 내에서 시장 행동을 평가하여 거래 결정에 반영해야 하는 트레이더, 분석가, 포트폴리오 매니저에게 특히 유용합니다.

Example Use Case
Intraday 1-Hour Price Data API를 활용하는 스윙 트레이더는 S&P 500 인덱스(^GSPC)를 모니터링하여 여러 거래 시간대에 걸친 가격 변동을 관찰합니다. 시간별 업데이트를 통해 분 단위 변동을 추적하지 않고도 새롭게 나타나는 트렌드를 파악하고 포지션을 조정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1hour?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Access 1-hour interval intraday data for stock indexes using the Intraday 1-Hour Price Data API. This API provides detailed price movements and volume within hourly intervals, making it ideal for tracking medium-term market trends during the trading day. | The FMP Intraday 1-Hour Price Data API delivers hourly price data for stock indexes, allowing analysts and traders to track market trends and price movements throughout the day. With open, high, low, and close prices for each hour, this API is suited for those monitoring medium-term intraday performance. Key features include: | This API is particularly useful for traders, analysts, and portfolio managers who need to assess market behavior within hourly intervals to inform their trading decisions. |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 15:30:00",
		"open": 21.62,
		"low": 21.02,
		"high": 21.62,
		"close": 21.03,
		"volume": 0
	}
]
```

---

### 7. 1-Minute Interval Commodities Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-intraday-1-min

**Summary:**

FMP 1-Minute Interval Commodities Chart API를 사용하여 원자재의 단기 가격 변동을 추적하세요. 이 API는 1분 간격의 상세 데이터를 제공하여 장중 시장 변화를 정밀하게 모니터링할 수 있습니다.

**About:**

FMP 1-Minute Interval Commodities Chart API는 원자재에 대한 분 단위 가격 데이터(시가, 고가, 저가, 종가 및 거래량 포함)를 제공합니다. 이 API는 가격 변동을 모니터링하고 속도와 정확성으로 시장 트렌드에 대응하기 위해 고도로 세분화된 데이터가 필요한 데이 트레이더, 분석가 및 시장 참여자에게 이상적입니다.

Intraday Data: 원자재의 최신 가격 데이터에 액세스하여 단기 가격 변동을 더 쉽게 추적합니다.
Detailed Price Information: 시장 트렌드의 정밀한 분석을 위해 거래량과 함께 시가, 고가, 저가, 종가를 확인합니다.
Fast Decision-Making: 1분 간격 데이터는 장중 거래에서 빠른 의사결정을 지원하며, 시장 기회가 발생하는 즉시 행동할 수 있게 합니다.

이 API는 빠르게 움직이는 원자재 시장에서 가격 변화를 파악해야 하는 활발한 트레이더와 투자자에게 유용한 리소스입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1min?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Track short-term price movements for commodities with the FMP 1-Minute Interval Commodities Chart API. This API provides detailed 1-minute interval data, enabling precise monitoring of intraday market changes. | The FMP 1-Minute Interval Commodities Chart API delivers minute-by-minute price data for commodities, including open, high, low, and close prices, as well as trading volume. This API is ideal for day traders, analysts, and market participants who require highly granular data to monitor price fluctuations and respond to market trends with speed and accuracy. | This API is a valuable resource for active traders and investors who need to stay on top of price changes in the fast-moving commodities market. |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:18:00",
		"open": 3374.5,
		"low": 3373.7,
		"high": 3374.5,
		"close": 3374,
		"volume": 123
	}
]
```

---

### 8. 1-Minute Interval Cryptocurrency Data API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-intraday-1-min

**Summary:**

1-Minute Cryptocurrency Intraday Data API를 사용하여 암호화폐의 실시간 1분 간격 가격 데이터를 확인하세요. 단기 가격 변동과 거래량을 모니터링하여 시장 움직임을 실시간으로 파악하세요.

**About:**

1-Minute Cryptocurrency Intraday Data API는 암호화폐 가격 변동에 대한 정밀하고 실시간적인 업데이트를 제공하며, 다음 내용을 포함합니다:

1-Minute Price Intervals: 시가, 고가, 저가, 종가(OHLC) 값을 포함한 1분 간격의 암호화폐 가격 데이터를 조회합니다.
Real-Time Volume Information: 매 분의 상세한 거래량 데이터에 액세스하여 시장 활동에 대한 신속한 인사이트를 얻습니다.
Track Short-Term Price Movements: 암호화폐 가격의 단기 트렌드를 분석하여 시장 기회를 포착하거나 트렌드를 조기에 식별합니다.

이 API는 빠르게 움직이는 암호화폐 시장을 추적하기 위해 신속하고 실행 가능한 데이터가 필요한 데이 트레이더, 분석가 및 알고리즘 트레이더에게 필수적입니다.

Example Use Case
데이 트레이더는 1-Minute Cryptocurrency Intraday Data API를 사용하여 실시간 가격 변동과 거래량 급등을 모니터링하고, 새롭게 나타나는 시장 트렌드나 브레이크아웃을 기반으로 신속한 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1min?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Get real-time, 1-minute interval price data for cryptocurrencies with the 1-Minute Cryptocurrency Intraday Data API. Monitor short-term price fluctuations and trading volume to stay updated on market movements. | The 1-Minute Cryptocurrency Intraday Data API offers precise, real-time updates on cryptocurrency price movements, including: | This API is vital for day traders, analysts, and algorithmic traders who need fast, actionable data to track the fast-moving cryptocurrency markets. |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:29:00",
		"open": 118797.96,
		"low": 118760.42,
		"high": 118818.11,
		"close": 118784.04,
		"volume": 52293740.08888889
	}
]
```

---

### 9. 1-Minute Interval Forex Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-intraday-1-min

**Summary:**

1-Minute Forex Interval Chart API를 사용하여 실시간 1분 간격 장중 외환 데이터에 액세스하세요. 통화쌍 변동에 대한 정밀하고 최신의 인사이트를 위해 단기 가격 변동을 추적하세요.

**About:**

1-Minute Forex Interval Chart API는 고빈도 장중 데이터를 제공하며, 매분마다 통화쌍 가격 변화에 대한 상세한 뷰를 제공합니다. 실시간 시가, 고가, 저가, 종가(OHLC) 및 거래량 데이터를 통해 이 API는 다음에 이상적입니다:

Scalping and Day Trading: 빠른 진입 및 청산 시점에 집중하는 트레이더는 고도로 역동적인 시장 상황에서 분 단위 데이터를 활용할 수 있습니다.
High-Frequency Monitoring: 변동성이 높은 시장 세션에서 단기 외환 가격 변동을 면밀히 모니터링하여 기회를 포착하거나 리스크를 관리합니다.
Short-Term Strategy Execution: 급속한 트레이딩 전략과 기술적 분석을 적용하여 단기 트렌드를 포착하고 리스크를 최소화합니다.

이 API를 사용함으로써 트레이더는 빠르게 움직이는 외환 시장에서 시의적절하고 정보에 기반한 결정을 내릴 수 있으며, 고빈도 트레이더와 단기 전략을 구사하는 이들에게 필수적입니다.

Example Use Case
데이 트레이더는 1-Minute Forex Interval Chart API를 사용하여 EUR/USD 통화쌍의 가격 변동을 추적합니다. 매분의 시가, 고가, 저가, 종가를 모니터링함으로써 스캘핑 전략을 실행하고 단일 거래 세션 내에서 수익 기회를 최적화합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1min?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Access real-time 1-minute intraday forex data with the 1-Minute Forex Interval Chart API. Track short-term price movements for precise, up-to-the-minute insights on currency pair fluctuations. | The 1-Minute Forex Interval Chart API provides high-frequency intraday data, offering a detailed view of currency pair price changes every minute. With real-time open, high, low, close (OHLC) prices and volume data, this API is ideal for: | By using this API, traders can make timely and informed decisions in fast-moving forex markets, making it essential for high-frequency traders and those employing short-term strategies. |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:29:00",
		"open": 1.17582,
		"low": 1.17582,
		"high": 1.17599,
		"close": 1.17598,
		"volume": 184
	}
]
```

---

### 10. 1-Minute Interval Index Price API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-intraday-1-min

**Summary:**

Intraday 1-Minute Price Data API를 사용하여 주식 인덱스의 1분 간격 장중 데이터를 조회하세요. 이 API는 세분화된 가격 정보를 제공하여 매분 단위의 단기 가격 변동과 거래량을 추적하는 데 도움을 줍니다.

**About:**

FMP Intraday 1-Minute Price Data API는 주식 인덱스에 대한 고빈도 가격 데이터를 제공하며, 분 단위로 시장 변동에 대한 인사이트를 제공합니다. 이러한 세부 수준은 신속한 의사결정을 위해 실시간 시장 인사이트가 필요한 활발한 트레이더와 분석가에게 이상적입니다. 주요 기능은 다음과 같습니다:

Granular Price Data: 거래일의 매분에 대한 시가, 고가, 저가, 종가에 액세스합니다.
Minute-by-Minute Tracking: 실시간으로 단기 가격 변동과 트렌드를 모니터링합니다.
Volume Information: 매분의 거래량을 분석하여 시장 유동성과 활동 수준에 대한 인사이트를 얻습니다.
Supports Intraday Trading: 상세한 장중 데이터에 의존하는 데이 트레이더 및 고빈도 거래 전략에 최적입니다.

이 API는 급격한 가격 변동을 추적하고 시의적절한 거래 결정을 내리기 위해 실시간 데이터가 필요한 데이 트레이더, 퀀트, 금융 분석가에게 특히 유용합니다.

Example Use Case
단기 주식 인덱스 거래를 전문으로 하는 데이 트레이더는 Intraday 1-Minute Price Data API를 사용하여 S&P 500 인덱스(^GSPC)의 실시간 가격 변화를 추적합니다. 분 단위 데이터에 액세스하여 가격 변동에 즉각 반응하고 거래 전략을 실시간으로 조정함으로써, 최대 수익성을 위한 진입 및 청산 시점을 최적화합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/1min?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Retrieve 1-minute interval intraday data for stock indexes using the Intraday 1-Minute Price Data API. This API provides granular price information, helping users track short-term price movements and trading volume within each minute. | The FMP Intraday 1-Minute Price Data API delivers high-frequency price data for stock indexes, offering insights into market fluctuations on a minute-by-minute basis. This level of detail is ideal for active traders and analysts who require real-time market insights for rapid decision-making. Key features include: | This API is particularly useful for day traders, quants, and financial analysts who need real-time data to track rapid price movements and make timely trading decisions. |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 15:59:00",
		"open": 21.1,
		"low": 21.02,
		"high": 21.1,
		"close": 21.03,
		"volume": 0
	}
]
```

---

### 11. 15 Min Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-15-min

**Summary:**

FMP 15분 간격 주식 차트 API를 통해 주식 가격 및 거래량 데이터에 접근하세요. 시가, 고가, 저가, 종가 및 거래량을 포함한 상세한 주식 데이터를 15분 간격으로 조회할 수 있습니다. 이 API는 장중 차트 생성 및 거래일 내 중기 가격 추세 분석에 최적화되어 있습니다.

**About:**

FMP 15분 간격 주식 차트 API는 거래일 전반에 걸친 주식 가격 움직임을 균형 있게 파악할 수 있도록 설계되었습니다. 15분 간격으로 핵심 데이터를 제공함으로써, 간결하면서도 효과적인 형태로 주식 동향을 모니터링해야 하는 트레이더와 투자자에게 중기적 인사이트를 제공합니다. 주요 기능은 다음과 같습니다:

Medium-Term Price Analysis: 매 분을 분석하지 않고도 장중 추세를 파악해야 하는 트레이더에게 적합한, 15분 간격의 가격 변동을 모니터링합니다.
Comprehensive Data Points: 시가, 고가, 저가, 종가 및 거래량 등 핵심 지표에 접근하여 상세한 장중 차트를 생성합니다.
Flexible Intraday Monitoring: 거래일 전반에 걸쳐 주식 성과를 추적해야 하는 트레이더와 투자자에게 적합하며, 가격 움직임과 추세를 보다 쉽게 파악할 수 있습니다.
Historical Data Access: 과거 15분 간격 데이터를 조회하여 과거 거래 세션에 대한 심층 분석을 수행하고 반복적인 패턴을 식별합니다.
Efficient Data Retrieval: 빠르게 변화하는 데이터(1분 간격 등)와 더 긴 장중 데이터 사이의 균형을 원하는 사람들에게 이상적이며, 보다 스마트한 의사결정을 지원합니다.

Example Use Case
스윙 트레이더는 15분 간격 주식 차트 API를 활용하여 거래일 내내 애플 주식을 모니터링하고, 중기 가격 움직임을 분석하여 큰 변동을 기반으로 전략적인 매수·매도 시점을 결정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/15min?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 15:45:00",
		"open": 232.25,
		"low": 232.18,
		"high": 233.13,
		"close": 232.79,
		"volume": 2535629
	}
]
```

---

### 12. 30 Min Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-30-min

**Summary:**

FMP 30분 간격 주식 차트 API를 통해 주식 가격 및 거래량 데이터에 접근하세요. 시가, 고가, 저가, 종가 및 거래량을 포함한 필수 주식 데이터를 30분 간격으로 조회할 수 있습니다. 이 API는 장중 차트 생성 및 보다 전략적인 거래 결정을 위한 중기 가격 움직임 추적에 적합합니다.

**About:**

FMP 30분 간격 주식 차트 API는 거래일의 매 분을 모니터링하지 않고 중기 가격 인사이트를 원하는 트레이더와 투자자를 위해 설계되었습니다. 30분 간격으로 핵심 주식 지표를 제공하여 시간 경과에 따른 주식 성과를 균형 있게 파악할 수 있습니다. 주요 기능은 다음과 같습니다:

Efficient Medium-Term Analysis: 30분 간격으로 주식 가격 변동을 모니터링하여, 더 작은 시간 단위의 노이즈 없이 가격 움직임을 명확하게 파악합니다.
Detailed Price Metrics: 시가, 고가, 저가, 종가 및 거래량 등 중요한 데이터 포인트에 접근하여 종합적인 장중 차트를 구성합니다.
Ideal for Intraday Strategies: 이 API는 중기 가격 움직임과 거래량 패턴에 의존하는 매매 전략을 지원하며, 데이 트레이더와 투자자에게 이상적입니다.
Historical Data Availability: 30분 간격 과거 데이터를 조회하여 과거 거래 세션의 추세와 패턴을 분석합니다.
Optimized for Trend Tracking: 30분 간격으로 데이터를 제공하여, 거래일 중 핵심 추세를 파악하려는 사람들에게 효율적인 솔루션을 제공합니다.

Example Use Case
데이 트레이더는 30분 간격 주식 차트 API를 사용하여 하루 거래일 동안 애플 주식의 성과를 모니터링하고, 중요한 가격 패턴과 거래량 변화를 파악하여 계산된 매수·매도 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/30min?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 15:30:00",
		"open": 232.29,
		"low": 232.01,
		"high": 233.13,
		"close": 232.79,
		"volume": 3476320
	}
]
```

---

### 13. 4 Hour Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-4-hour

**Summary:**

FMP 4시간 간격 주식 차트 API를 통해 장중 장기 구간에 걸친 주식 가격 움직임을 분석하세요. 4시간 간격의 핵심 주식 가격 및 거래량 데이터에 접근하여, 더 긴 장중 추세를 추적하고 광범위한 시장 움직임을 이해하는 데 최적화되어 있습니다.

**About:**

FMP 4시간 간격 주식 차트 API는 트레이더와 투자자에게 더 긴 장중 시간대에 걸친 필수 데이터 포인트를 제공하여 종합적인 추세 분석을 가능하게 합니다. 1시간보다 긴 단위로 가격 움직임을 추적하되 여전히 거래일 내에서 분석하려는 사용자에게 이상적입니다. 주요 기능은 다음과 같습니다:

4-Hour Price Intervals: 4시간마다 업데이트되는 시가, 고가, 저가, 종가에 접근하여 장중 시장 추세를 더욱 명확하게 파악합니다.
Volume Data: 각 4시간 구간의 거래량을 추적하여 시장 활동을 이해합니다.
Ideal for Medium-Term Intraday Analysis: 더 긴 간격은 주식 움직임의 심층 분석을 가능하게 하며, 거래일 내 패턴과 추세를 파악하는 데 도움을 줍니다.
Historical Data: 과거 4시간 가격 데이터를 조회하여 추세를 연구하고 보다 광범위한 가격 움직임 모델을 구성합니다.
Intraday Market Strategy Support: 거래 세션 내 더 넓은 가격 움직임과 변화를 활용하는 매매 전략 개발에 데이터를 활용합니다.

Example Use Case
포지션 트레이더는 4시간 간격 주식 차트 API를 사용하여 애플 주식의 장중 장기 성과를 모니터링하고, 단기 변동에 휘둘리지 않으면서 보다 큰 추세와 가격 변화를 감지할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/4hour?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 12:30:00",
		"open": 231.79,
		"low": 231.37,
		"high": 233.13,
		"close": 232.37,
		"volume": 23781913
	}
]
```

---

### 14. 5 Min Interval Stock Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/intraday-5-min

**Summary:**

FMP 5분 간격 주식 차트 API를 통해 주식 가격 및 거래량 데이터에 접근하세요. 각 5분 구간의 시가, 고가, 저가, 종가 및 거래량을 포함한 상세한 주식 데이터를 5분 간격으로 조회할 수 있습니다. 이 API는 단기 거래 분석 및 장중 차트 구성에 적합합니다.

**About:**

FMP 5분 간격 주식 차트 API는 5분 간격으로 가치 있는 주식 데이터를 제공하여 장중 시장 활동에 대한 더 나은 인사이트를 가능하게 합니다. 단기 가격 움직임을 추적하기 위해 빠르고 정확한 데이터가 필요한 투자자와 트레이더를 위해 설계되었습니다. 주요 기능은 다음과 같습니다:

Short-Term Price Analysis: 5분 간격 데이터로 단기간의 주식 가격 움직임을 추적하여, 장중 트레이더에게 이상적인 솔루션을 제공합니다.
Precise Trading Data: 각 5분 구간의 시가, 고가, 저가, 종가 및 거래량을 조회하여 패턴과 추세를 파악합니다.
Intraday Charting: 모든 주식 심볼에 대해 상세한 장중 차트를 구성하여 단기 가격 추세의 향상된 시각화를 가능하게 합니다.
Historical Data Access: API를 사용하여 과거 5분 간격 데이터를 조회하고, 가격 분석 및 추세 파악의 범위를 넓힙니다.

Efficient for Active Traders: 이 API는 정보에 기반한 거래 결정을 내리기 위해 빠르고 신뢰할 수 있는 데이터가 필요한 데이 트레이더와 적극적인 투자자에게 적합합니다.

Example Use Case
데이 트레이더는 5분 간격 주식 차트 API를 활용하여 거래일 내내 애플 주식을 모니터링하고, 단기 추세를 파악하여 가격 변동에 기반한 적시 거래 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/5min?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| nonadjusted | boolean | false |

**Sample Response:**

```json
[
	{
		"date": "2025-02-04 15:55:00",
		"open": 232.87,
		"low": 232.72,
		"high": 233.13,
		"close": 232.79,
		"volume": 1555040
	}
]
```

---

### 15. 5-Minute Interval Commodities Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-intraday-5-min

**Summary:**

FMP 5분 간격 상품 차트 API를 통해 단기 가격 움직임을 모니터링하세요. 이 API는 상세한 5분 간격 데이터를 제공하여 사용자가 보다 전략적인 거래 및 투자 결정을 위한 단기 가격 추세를 추적할 수 있도록 합니다.

**About:**

FMP 5분 간격 상품 차트 API는 5분 간격으로 가격 데이터를 제공하여 세밀함과 광범위한 추세 분석 사이의 균형을 제공합니다. 상품에 대한 시가, 고가, 저가, 종가 및 거래량을 포함합니다. 이 API는 단기 시장 활동을 추적하면서도 1분 데이터보다 약간 더 넓은 시각을 선호하는 트레이더와 투자자에게 이상적입니다.

Short-Term Trend Analysis: 5분 간격 데이터에 접근하여 가격 움직임을 모니터링하고 상품 시장의 단기 추세를 파악합니다.
Detailed Pricing Information: 각 5분 간격의 시가, 고가, 저가, 종가 및 거래량을 포함한 상세한 가격 데이터를 조회합니다.
Strategic Trading: 5분 간격 데이터를 활용하여 패턴과 가격 움직임을 포착하고, 트레이더가 전략을 정교화하여 보다 정보에 기반한 결정을 내리도록 지원합니다.

이 API는 거래 니즈와 상품 시장 움직임에 대한 약간 더 장기적인 관점을 균형 있게 조율하려는 트레이더에게 적합합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/5min?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:15:00",
		"open": 3374,
		"low": 3374,
		"high": 3374.8,
		"close": 3374.4,
		"volume": 193
	}
]
```

---

### 16. 5-Minute Interval Cryptocurrency Data API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-intraday-5-min

**Summary:**

5분 간격 암호화폐 데이터 API를 통해 단기 가격 추세를 분석하세요. 암호화폐의 실시간 당일 가격 데이터를 이용하여 급격한 시장 움직임을 모니터링하고 거래 전략을 최적화하세요.

**About:**

5분 간격 암호화폐 데이터 API는 암호화폐에 대한 세부적인 당일 데이터를 제공하며, 다음을 포함합니다:

Short-Term Price Movements: 5분 간격으로 가격을 추적하여 거래일 전반에 걸친 암호화폐 성과에 대한 세밀한 인사이트를 제공합니다.
Real-Time Market Analysis: 당일 시장 변동을 포착하기 위해 시가, 고가, 저가, 종가(OHLC) 및 거래량에 대한 실시간 업데이트에 접근하세요.
Support for Technical Analysis: 5분 간격 데이터를 활용하여 지지선 및 저항선 파악, 단기 추세 포착, 데이트레이딩 전략 실행 등 고급 기술적 분석을 수행하세요.

이 API는 빠르게 변화하는 가격 변동을 즉각적으로 파악하고 단기 시장 변동을 활용해야 하는 활동적인 트레이더, 분석가, 투자자에게 필수적인 도구입니다.

Example Use Case
한 데이트레이더가 5분 간격 암호화폐 데이터 API를 사용하여 하루 동안 비트코인의 가격 움직임을 추적합니다. 단기 가격 추세를 분석함으로써 트레이더는 거래의 최적 진입 및 청산 시점을 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/5min?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Analyze short-term price trends with the 5-Minute Interval Cryptocurrency Data API. Access real-time, intraday price data for cryptocurrencies to monitor rapid market movements and optimize trading strategies. | The 5-Minute Interval Cryptocurrency Data API provides detailed intraday data for cryptocurrencies, including: | This API is essential for active traders, analysts, and investors who need to stay informed of fast-moving price changes and capitalize on short-term market fluctuations. |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:25:00",
		"open": 118988.32,
		"low": 118797.03,
		"high": 118997.22,
		"close": 118797.03,
		"volume": 208601161.95555556
	}
]
```

---

### 17. 5-Minute Interval Forex Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-intraday-5-min

**Summary:**

5분 외환 간격 차트 API를 통해 단기 외환 추세를 추적하세요. 세부적인 5분 당일 데이터에 접근하여 통화 쌍의 가격 움직임과 시장 상황을 실시간에 가깝게 모니터링하세요.

**About:**

5분 외환 간격 차트 API는 5분 간격의 핵심 가격 데이터를 제공하여 단기 추세에 집중하는 트레이더와 분석가에게 이상적입니다. 각 5분 구간의 시가, 고가, 저가, 종가(OHLC) 및 거래량 데이터를 통해 이 API는 다음을 지원합니다:

Intraday Trading Strategies: 단기 시간대 내에서 가격 추세를 포착하고 합리적인 결정을 내리려는 트레이더에게 최적입니다.
Monitoring Currency Pair Volatility: 주요 거래 세션 동안 가격 움직임을 면밀히 추적하여 환율 변동을 활용하세요.
Near-Term Trend Analysis: 이 API를 기술적 분석에 활용하여 5분 단위로 발생하는 패턴이나 돌파구를 포착하세요.

이 API는 시장 상황을 빠르게 이해하고 반응하려는 외환 트레이더와 단기 통화 쌍 움직임을 추적하려는 분석가 모두에게 유용한 도구입니다.

Example Use Case
EUR/USD 쌍을 모니터링하는 외환 트레이더가 5분 외환 간격 차트 API를 사용하여 변동성이 높은 시기의 가격 변동을 분석합니다. 5분 간격을 추적함으로써 트레이더는 거래 진입 또는 청산 시점에 대한 합리적인 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/5min?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Track short-term forex trends with the 5-Minute Forex Interval Chart API. Access detailed 5-minute intraday data to monitor currency pair price movements and market conditions in near real-time. | The 5-Minute Forex Interval Chart API offers critical price data at 5-minute intervals, making it ideal for traders and analysts focused on short-term trends. With open, high, low, close (OHLC) prices and volume data for each 5-minute period, this API supports: | This API is a valuable tool for forex traders aiming to understand and react to market conditions quickly, as well as for analysts seeking to track short-term currency pair movements. |

**Sample Response:**

```json
[
	{
		"date": "2025-07-24 12:25:00",
		"open": 1.17612,
		"low": 1.17571,
		"high": 1.17613,
		"close": 1.17578,
		"volume": 873
	}
]
```

---

### 18. 5-Minute Interval Index Price API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-intraday-5-min

**Summary:**

당일 5분 가격 데이터 API를 사용하여 주식 지수의 5분 간격 당일 가격 데이터를 조회하세요. 이 API는 5분 단위 창 내의 가격 움직임과 거래량에 대한 핵심 인사이트를 제공하며, 단기 데이터가 필요한 트레이더에게 이상적입니다.

**About:**

FMP 당일 5분 가격 데이터 API는 활성 거래 시간 중 5분마다 업데이트되는 주식 지수의 실시간 가격 및 거래량 데이터를 제공합니다. 이 API는 가격 변동을 추적하고 시의적절한 결정을 내리기 위해 세부적인 단기 데이터가 필요한 트레이더와 분석가를 위해 설계되었습니다. 주요 기능은 다음과 같습니다:

5-Minute Interval Data: 거래일 전반에 걸쳐 각 5분 구간의 시가, 고가, 저가, 종가에 접근하세요.
Real-Time Tracking: 실시간에 가깝게 가격 변화와 시장 추세를 최신 상태로 파악하세요.
Volume Data: 5분 간격으로 거래량을 분석하여 시장 활동도와 유동성을 측정하세요.
Supports Short-Term Trading: 전략 수립에 잦은 업데이트가 필요한 단기 및 스윙 트레이더에게 이상적입니다.

이 API는 가격 움직임을 면밀히 모니터링하고 단기 변동을 기반으로 거래를 실행해야 하는 데이트레이더, 퀀트, 금융 전문가에게 완벽한 도구입니다.

Example Use Case
S&P 500 지수(^GSPC)를 모니터링하는 스윙 트레이더가 당일 5분 가격 데이터 API를 사용하여 거래일 동안의 가격 움직임을 추적합니다. 5분 간격을 분석함으로써 단기 시장 변화에 신속하게 반응하고 최대 수익을 위한 전략을 최적화하여 거래 타이밍을 더욱 정확하게 맞출 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-chart/5min?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the 1-Hour Forex Interval Chart API provide? | The API provides OHLC (open, high, low, close) prices and trading volume for forex currency pairs at 1-hour intervals. | What timeframes are available for historical candlestick data in the API? |
| API | FMP | Stock Screener |
| Retrieve 5-minute interval intraday price data for stock indexes using the Intraday 5-Minute Price Data API. This API provides crucial insights into price movements and trading volume within 5-minute windows, ideal for traders who require short-term data. | The FMP Intraday 5-Minute Price Data API offers real-time price and volume data for stock indexes, updated every 5 minutes during active market hours. This API is designed for traders and analysts who need detailed, short-term data to track price fluctuations and make timely decisions. Key features include: | This API is perfect for day traders, quants, and financial professionals who need to monitor price movements closely and execute trades based on short-term fluctuations. |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 15:55:00",
		"open": 21.26,
		"low": 21.02,
		"high": 21.3,
		"close": 21.03,
		"volume": 0
	}
]
```

---

### 19. Acquisition Ownership API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/acquisition-ownership

**Summary:**

인수 소유권 API를 사용하여 인수 과정에서 주식 소유권 변화를 추적하세요. 이 API는 합병, 인수, 또는 실질적 소유권 변경이 기업의 주식 소유 구조에 미치는 영향에 대한 상세한 정보를 제공합니다.

**About:**

FMP 인수 소유권 API는 인수, 합병 또는 기타 주요 기업 이벤트 과정에서 발생하는 주식 소유권 변화에 대한 포괄적인 데이터를 제공합니다. 기업 지배구조와 주주 영향력에 대한 이러한 변화의 영향을 이해하는 데 도움이 되도록, 법인 간 지배권 및 소유권이 이전되거나 공유되는 방식에 대한 인사이트를 제공합니다. 주요 기능은 다음과 같습니다:

Ownership Changes: 공유 또는 단독 의결권 및 처분권을 포함한 실질적 소유권 변화를 추적하세요.
Acquisition and Merger Data: 기업 주식 소유권에 영향을 미치는 합병, 인수 또는 매수에 대한 세부 정보를 확인하세요.
Detailed Reporting Information: CIK, 명칭, 소유 비율을 포함한 보고 법인에 대한 데이터에 접근하세요.
Filing Dates and SEC Links: 인수 또는 소유권 변경과 관련된 공식 SEC 제출 문서 링크 및 중요 날짜를 확인하세요.

이 API는 기업 인수나 합병 과정에서 소유 구조가 어떻게 변화하는지 추적해야 하는 투자자, 재무 분석가, 연구자에게 이상적입니다.

Example Use Case
한 기관 투자자가 인수 소유권 API를 사용하여 Apple(AAPL)과 관련된 최근 합병의 영향을 모니터링합니다. 현재 7억 5,500만 주를 보유한 National Indemnity Company가 보고한 실질적 소유권 변화를 검토함으로써, 투자자는 이것이 회사 내 의결권과 지배력에 어떤 영향을 미치는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/acquisition-of-beneficial-ownership?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 2000 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the Insider Trade Statistics API provide? | The API provides statistical data on insider trading activity, including total acquisitions, dispositions, the acquired-to-disposed ratio, and the average size of transactions. | Can I access insider trade statistics for any company? |
| API | FMP | Stock Screener |
| Track changes in stock ownership during acquisitions using the Acquisition Ownership API. This API provides detailed information on how mergers, takeovers, or beneficial ownership changes impact the stock ownership structure of a company. | The FMP Acquisition Ownership API provides comprehensive data on changes in stock ownership during acquisitions, mergers, or other significant corporate events. It offers insight into how control and ownership are transferred or shared between entities, helping analysts and investors understand the impact of these changes on corporate governance and shareholder influence. Key features include: | This API is ideal for investors, financial analysts, and researchers who need to track how ownership structures shift during corporate acquisitions or mergers. |

**Sample Response:**

```json
[
	{
		"cik": "0000320193",
		"symbol": "AAPL",
		"filingDate": "2024-02-14",
		"acceptedDate": "2024-02-14",
		"cusip": "037833100",
		"nameOfReportingPerson": "Redwood Fire & Casualty Insurance Company",
		"citizenshipOrPlaceOfOrganization": "State of Nebraska",
		"soleVotingPower": "0",
		"sharedVotingPower": "2676000",
		"soleDispositivePower": "0",
		"sharedDispositivePower": "2676000",
		"amountBeneficiallyOwned": "2676000",
		"percentOfClass": "0.1",
		"typeOfReportingPerson": "IC, CO",
		"url": "https://www.sec.gov/Archives/edgar/data/320193/000119312524036431/d751537dsc13ga.htm"
	}
]
```

---

### 20. Actively Trading List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/actively-trading-list

**Summary:**

FMP 활성 거래 목록 API를 통해 현재 거래 중인 모든 기업 및 금융 상품을 조회하세요. 이 엔드포인트를 사용하면 공개 거래소에서 현재 거래 중인 증권을 필터링하고 표시하여 실시간 시장 활동에 접근할 수 있습니다.

**About:**

FMP 활성 거래 목록 API는 공개 거래소에서 활발히 거래되는 모든 기업 및 금융 상품에 대한 포괄적인 보기를 제공합니다. 이 API는 다음에 필수적입니다:

Real-Time Market Monitoring: 글로벌 거래소에서 현재 거래 중인 기업 및 금융 상품 목록을 최신 상태로 유지하세요.
Investment Opportunities: 현재 시장 움직임을 활용할 활성 증권을 빠르게 파악하여 트레이더와 투자자가 합리적인 결정을 내릴 수 있도록 지원합니다.
Customizable Filtering: 거래소, 산업 또는 지역을 기준으로 증권을 필터링하여 자신의 거래 또는 투자 전략과 관련된 정확한 상품을 찾을 수 있습니다.

이 API는 빠르게 움직이는 금융 시장에서 결정을 이끌어 내기 위해 활성 거래 증권에 대한 실시간 데이터가 필요한 투자자, 트레이더, 분석가에게 매우 유용한 도구입니다.

Example Use Case
한 데이트레이더가 활성 거래 목록 API를 사용하여 NASDAQ 거래소에서 현재 거래 중인 주식 목록을 조회하며, 하루 동안 잠재적 거래를 위한 고유동성 증권에 집중할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/actively-trading-list
```

**Sample Response:**

```json
[
	{
		"symbol": "6898.HK",
		"name": "China Aluminum Cans Holdings Limited"
	}
]
```

---

### 21. Aftermarket Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/aftermarket-quote

**Summary:**

FMP Aftermarket Quote API를 통해 실시간 시간외 주식 시세에 접근하세요. 정규 거래 시간 외에 매수·매도 호가, 거래량 및 기타 관련 데이터를 추적할 수 있습니다.

**About:**

FMP Aftermarket Stock Quote API는 정규 시장 시간 외에 거래되는 주식에 대한 종합적인 시세를 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

Tracking Aftermarket Stock Movers: 주식 시장이 마감된 후 실시간 매수·매도 호가, 거래량 및 기타 핵심 지표를 확인합니다.
Strategic Analysis: 시간외 주식 시세를 활용하여 정규 거래 시간 이후의 시장 심리와 주가 성과에 대한 인사이트를 얻고, 다음 거래 세션을 위한 더 나은 의사결정을 지원합니다.
Efficient Market Monitoring: 다음날 거래 전략에 영향을 줄 수 있는 가격 움직임과 추세를 지속적으로 파악합니다.

Aftermarket Stock Price API를 통해 투자자들은 장 마감 후 가격 움직임, 매수·매도 스프레드, 거래량을 효율적으로 모니터링하여 시장의 잠재적 변화에 선제적으로 대응할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/aftermarket-quote?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |
| Access real-time aftermarket stock quotes with the FMP Aftermarket Quote API. Track bid and ask prices, volume, and other relevant data outside of regular trading hours. | The FMP Aftermarket Stock Quote API provides comprehensive quotes for stocks traded outside of normal market hours. This API is essential for: | With the Aftermarket Stock Price API, investors can efficiently monitor post-market movements, bid-ask spreads, and trading volumes to stay ahead of potential shifts in the market. |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"bidSize": 1,
		"bidPrice": 232.45,
		"askSize": 3,
		"askPrice": 232.64,
		"volume": 41647042,
		"timestamp": 1738715334311
	}
]
```

---

### 22. Aftermarket Trade API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/aftermarket-trade

**Summary:**

FMP Aftermarket Trade API를 통해 정규 시장 시간 이후에 발생하는 실시간 거래 활동을 추적하세요. 장 마감 후 세션에서 체결된 거래의 가격, 수량, 타임스탬프 등 핵심 정보에 접근할 수 있습니다.

**About:**

FMP Aftermarket Trade API는 투자자들이 표준 시장 시간 외에 이루어진 거래를 모니터링할 수 있도록 하며, 장 마감 후 거래 활동에 대한 인사이트를 제공합니다. 이 API는 다음과 같은 용도에 적합합니다:

After-Hours Monitoring: 시간외 세션의 주가 및 거래 활동을 파악하여 주요 거래 시간 외의 가격 움직임을 추적합니다.
Investor Insights: 시간외 거래에서 다음 거래 세션에 앞서 유용한 정보를 제공할 수 있는 추세나 패턴을 파악합니다.
Enhanced Trading Strategies: 시간외 데이터를 활용하여 다음 날의 거래 전략을 조정하거나, 야간 시장 활동을 바탕으로 더욱 정보에 기반한 의사결정을 내립니다.

이 API는 사용자들이 장 마감 후 기간을 가시화하고, 전통적인 거래 시간 외의 시장 활동을 보다 포괄적으로 추적할 수 있도록 지원합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/aftermarket-trade?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |
| Track real-time trading activity occurring after regular market hours with the FMP Aftermarket Trade API. Access key details such as trade prices, sizes, and timestamps for trades executed during the post-market session. | The FMP Aftermarket Trade API allows investors to monitor trades made outside of standard market hours, offering insights into post-market trading activity. This API is ideal for: | This API helps users gain visibility into the post-market period, enabling more comprehensive tracking of market activity outside traditional trading hours. |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 232.53,
		"tradeSize": 132,
		"timestamp": 1738715334311
	}
]
```

---

### 23. All Commodities Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-commodities-quotes

**Summary:**

FMP Batch Commodities Quotes API를 통해 여러 원자재의 시세를 한 번에 조회하세요. 다양한 원자재의 가격 변동, 거래량 및 기타 핵심 지표를 즉시 추적할 수 있습니다.

**About:**

FMP Batch Commodities Quotes API는 사용자가 단일 요청으로 다양한 원자재의 실시간 가격 데이터를 가져올 수 있도록 합니다. 이 API는 여러 원자재를 동시에 모니터링하고, 시장 정보를 바탕으로 신속하고 정보에 기반한 의사결정이 필요한 투자자, 트레이더, 분석가를 위해 설계되었습니다.

Batch Quotes: 단일 API 호출로 여러 원자재의 시세를 가져와 광범위한 자산 추적 과정을 간소화합니다.
Updates: 최신 가격 정보를 실시간으로 제공받아 항상 최신 시장 데이터를 기반으로 작업할 수 있습니다.
Market Metrics: 가격 변동 및 거래량 등 추가 지표에 접근하여 시장 움직임에 맥락을 부여합니다.

이 API는 각 자산을 개별적으로 조회하지 않고도 원자재 가격에 효율적으로 접근해야 하는 전문가들에게 필수적입니다.

DCUSD(현재 가격: $22.29, 변동: -0.2, 거래량: 284)와 같은 원자재의 최신 가격을 이 API를 통해 동시에 조회하여 시장 데이터를 빠르게 분석하고 비교할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-commodity-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What timezone does the quote API for stocks and forex use? | The timezone for the quote API is aligned with the timezone of the exchange that the symbol trades on. | What information does the Forex Quote API provide? |
| API | FMP | Stock Screener |
| Access quotes for multiple commodities at once with the FMP Batch Commodities Quotes API. Instantly track price changes, volume, and other key metrics for a broad range of commodities. | The FMP Batch Commodities Quotes API allows users to retrieve live price data for a wide selection of commodities in one request. This API is designed for investors, traders, and analysts who need to monitor several commodities simultaneously and make quick, informed decisions based on market information. | This API is essential for professionals who need efficient access to commodity prices without having to query each asset individually. |

**Sample Response:**

```json
[
	{
		"symbol": "DCUSD",
		"price": 17.18,
		"change": -0.21,
		"volume": 284
	}
]
```

---

### 24. All Cryptocurrencies Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-cryptocurrency-quotes

**Summary:**

FMP Real-Time Cryptocurrency Batch Quotes API를 통해 다양한 암호화폐의 실시간 가격 데이터에 접근하세요. 단일 요청으로 디지털 자산의 실시간 가격, 시장 변동, 거래량 업데이트를 받을 수 있습니다.

**About:**

FMP Real-Time Cryptocurrency Batch Quotes API는 여러 암호화폐 가격을 동시에 추적해야 하는 투자자, 트레이더, 금융 분석가를 위해 설계되었습니다. 이 API는 다음을 제공합니다:

Real-Time Cryptocurrency Prices: 단일 배치 요청으로 다양한 디지털 자산의 현재 가격을 조회합니다.
Market Movement Tracking: 빠르게 변화하는 암호화폐 시장의 트렌드를 선도하기 위해 가격 변동을 지속적으로 파악합니다.
Volume Data: 유동성과 시장 활동을 가늠하기 위한 거래량 정보에 접근합니다.

이 API는 하나의 편리한 응답으로 다양한 암호화폐의 가격과 거래량에 빠르고 실시간으로 접근해야 하는 사용자에게 이상적입니다.

Example Use Case

포트폴리오 매니저는 Real-Time Cryptocurrency Batch Quotes API를 활용하여 여러 암호화폐의 가격과 시장 활동을 실시간으로 모니터링함으로써, 디지털 자산 포트폴리오 전반에 걸쳐 신속하고 정보에 기반한 의사결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-crypto-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What timezone does the quote API for stocks and forex use? | The timezone for the quote API is aligned with the timezone of the exchange that the symbol trades on. | What information does the Forex Quote API provide? |
| API | FMP | Stock Screener |
| Access live price data for a wide range of cryptocurrencies with the FMP Real-Time Cryptocurrency Batch Quotes API. Get real-time updates on prices, market changes, and trading volumes for digital assets in a single request. | The FMP Real-Time Cryptocurrency Batch Quotes API is designed for investors, traders, and financial analysts who need to track multiple cryptocurrency prices simultaneously. This API provides: | This API is ideal for users who need quick, real-time access to prices and trading volumes for a variety of cryptocurrencies in one convenient response. |

**Sample Response:**

```json
[
	{
		"symbol": "00USD",
		"price": 0.01755108,
		"change": 0.00035108,
		"volume": 3719492.41
	}
]
```

---

### 25. All Exchange Market Hours API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-exchange-market-hours

**Summary:**

모든 거래소의 시장 운영 시간을 확인하세요. 각 시장이 언제 활성화되는지 파악할 수 있습니다.

**About:**

모든 거래소의 시장 운영 시간을 확인하세요. 각 시장이 언제 활성화되는지 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/all-exchange-market-hours
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| timestamp | string | 1769527402 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What data does the Global Exchange Market Hours API provide? | The API provides the opening and closing times for stock exchanges, along with their time zones and whether the market is currently open. | Can I retrieve trading hours for multiple exchanges? |
| API | FMP | Stock Screener |
| View the market hours for all exchanges. Check when different markets are active. | View the market hours for all exchanges. Check when different markets are active. | Endpoint: |

**Sample Response:**

```json
[
	{
		"exchange": "ASX",
		"name": "Australian Securities Exchange",
		"openingHour": "10:00 AM +10:00",
		"closingHour": "04:00 PM +10:00",
		"timezone": "Australia/Sydney",
		"isMarketOpen": true
	}
]
```

---

### 26. All Index Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-index-quotes

**Summary:**

All Index Quotes API는 주요 시장 벤치마크부터 틈새 지수까지 다양한 주가 지수에 대한 실시간 시세를 제공합니다. 이 API를 통해 사용자는 단일 요청으로 여러 지수에 걸친 시장 성과를 추적하여 금융 시장 전반에 대한 폭넓은 시각을 얻을 수 있습니다.

**About:**

All Index Quotes API는 주요 지수와 소규모 지수 모두에 대한 실시간 데이터를 포함하여 사용 가능한 모든 주가 지수의 최신 시세를 조회할 수 있게 해줍니다. 이 API는 여러 번의 요청 없이 다양한 지수에 걸친 시장 움직임을 빠르게 파악해야 하는 트레이더, 애널리스트, 투자자에게 이상적입니다. 주요 기능은 다음과 같습니다:

Real-Time Data: 주가 지수에 대한 실시간 시세를 제공하여 사용자가 시장 변화에 신속하게 대응할 수 있도록 돕습니다.
Broad Market Coverage: S&P 500, 다우존스, NASDAQ 등 주요 지수와 더불어 특수 지역 지수 데이터에 접근할 수 있습니다.
Simplified Data Retrieval: 단일 API 호출로 여러 지수의 시세를 조회하여 시장 분석을 위한 데이터 수집을 간소화합니다.

이 API는 글로벌 주요 벤치마크부터 소규모 지역 특화 지수까지 주가 지수 동향에 대한 종합적인 시각을 원하는 사용자를 위해 설계되었습니다.

Example Use Case
글로벌 시장 성과를 추적하는 금융 애널리스트는 All Index Quotes API를 활용하여 S&P 500, FTSE 100, 닛케이 225 등 여러 주가 지수의 실시간 시세를 한 번의 요청으로 조회함으로써 현재 시장 트렌드에 대한 전체적인 시각을 확보할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-index-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

---

### 27. All Industry Classification API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-industry-classification

**Summary:**

FMP All Industry Classification API를 통해 모든 섹터에 걸친 기업들의 종합적인 산업 분류 데이터에 접근하세요. SIC 코드, 산업 명칭, 사업 연락처 정보 등 핵심 세부 사항을 조회할 수 있습니다.

**About:**

FMP All Industry Classification API는 산업 섹터별로 분류된 기업들에 대한 완전한 개요를 제공합니다. 사용자가 조회할 수 있는 정보는 다음과 같습니다:

Full Industry Classification Data: 모든 산업에 걸쳐 SIC 코드, 산업 명칭, 사업 주소 등 기업에 대한 상세 정보에 접근할 수 있습니다.
Comprehensive Company Information: 기업명, CIK 번호, SIC 코드, 전화번호, 주소 등 다양한 산업에 걸쳐 기업을 식별하고 분석하는 데 도움이 되는 관련 세부 정보를 조회합니다.
Cross-Industry Analysis: 이 API를 활용하여 특정 산업 내 기업 또는 여러 섹터에 걸친 기업을 연구하여 완전한 산업 개요를 파악합니다.

이 API는 광범위한 산업 분류 및 사업 데이터를 필요로 하는 투자자, 애널리스트, 시장 조사자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/all-industry-classification
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "0Q16.L",
		"name": "BANK OF AMERICA CORP /DE/",
		"cik": "0000070858",
		"sicCode": "6021",
		"industryTitle": "NATIONAL COMMERCIAL BANKS",
		"businessAddress": "['BANK OF AMERICA CORPORATE CENTER', 'CHARLOTTE NC 28255']",
		"phoneNumber": "7043868486"
	}
]
```

---

### 28. All Insider Transaction Types API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-transaction-types

**Summary:**

All Insider Transaction Types API를 통해 내부자 거래 유형의 포괄적인 목록에 접근하세요. 이 API는 매수, 매도 및 내부자 거래와 관련된 기타 기업 행위를 포함한 다양한 거래 행위에 대한 세부 정보를 제공합니다.

**About:**

FMP All Insider Transaction Types API는 사용자가 기업 내부자들이 수행한 모든 유형의 거래를 조회할 수 있게 해줍니다. 여기에는 매수, 매도 및 옵션 행사나 증여와 같이 내부자가 취할 수 있는 기타 행위가 포함됩니다. 이 API를 통해 사용자는 내부자들이 신고하는 다양한 거래 유형과 기업 성과에 대한 시사점을 종합적으로 이해할 수 있습니다. 주요 기능은 다음과 같습니다:

Comprehensive Transaction Coverage: 매수, 매도, 옵션 행사 등을 포함한 모든 유형의 내부자 거래를 조회합니다.
Transaction Classifications: 해당 거래가 취득인지, 처분인지, 또는 그 외의 거래인지 분류를 파악합니다.
Real-Time Insights: 최신 내부자 행위와 회사에 대한 잠재적 영향을 지속적으로 업데이트하여 확인합니다.
Corporate Action Types: 증여나 주식 부여 등 덜 일반적인 내부자 거래에 대한 세부 정보에 접근합니다.

이 API는 다양한 내부자 거래 행위를 추적하여 보다 정보에 기반한 투자 결정을 내려야 하는 투자자, 애널리스트, 연구자에게 적합합니다.

Example Use Case
시장 애널리스트가 All Insider Transaction Types API를 활용하여 기업 내부자들의 최근 거래 전체 목록을 조회합니다. 매수, 매도, 행사된 주식 옵션을 검토함으로써 애널리스트는 기업 심리에 대한 통찰을 얻고 보다 정보에 기반한 거래 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/insider-trading-transaction-type
```

**Sample Response:**

```json
[
	{
		"transactionType": "A-Award"
	}
]
```

---

### 29. All Shares Float API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-shares-float

**Summary:**

FMP All Shares Float API를 통해 모든 가용 기업의 종합적인 유통 주식 데이터에 접근하세요. 광범위한 기업에 걸쳐 유동성을 분석하기 위한 자유 유통 주식, 유통 주식 수, 발행 주식 수 등 핵심 정보를 조회할 수 있습니다.

**About:**

FMP All Shares Float API는 거래 가능한 주식에 대한 통찰을 제공함으로써 상장 기업의 유동성에 관한 유용한 데이터를 제공합니다. 이 API는 기업의 시장 활동을 이해하고자 하는 투자자, 애널리스트, 금융 전문가에게 필수적입니다. 주요 기능은 다음과 같습니다:

Free Float Data: 내부자, 임직원, 대주주가 보유한 주식을 제외하고 공개 거래에 사용 가능한 주식 수를 파악합니다.
Float Shares & Outstanding Shares: 시장에서 유통 중이면서 발행된 주식의 총 수를 조회하여 기업의 전체 시장 노출도를 분석합니다.
Comparative Liquidity Analysis: 여러 기업에 걸쳐 자유 유통 주식과 발행 주식에 접근함으로써 유동성을 비교하고, 시장 안정성을 판단하며, 투자 잠재력을 평가할 수 있습니다.

이 API는 공개 시장에서 주식을 매수하거나 매도하는 용이성을 평가하기 위한 핵심 리소스로, 기업 주식 가용성과 시장 행동에 대한 상세한 그림을 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/shares-float-all?page=0&limit=1000
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| limit | number | 1000 |
| page | number | 0 |

**Sample Response:**

```json
[
	{
		"symbol": "020Y.L",
		"date": "2026-04-07 11:36:45",
		"freeFloat": 0,
		"floatShares": 0,
		"outstandingShares": 84818244
	}
]
```

---

### 30. senate-trading-by-name API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/senate-trading-by-name

**About:**

이름으로 상원의원 거래 내역을 조회하는 엔드포인트입니다.

Endpoint:

https://financialmodelingprep.com/stable/senate-trades-by-name?name=Jerry

**Endpoint:**

```
https://financialmodelingprep.com/stable/senate-trades-by-name?name=Jerry
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | Jerry |

**Sample Response:**

```json
[
	{
		"symbol": "GOOG",
		"disclosureDate": "2025-10-27",
		"transactionDate": "2025-09-23",
		"firstName": "Jerry",
		"lastName": "Moran",
		"office": "Jerry Moran",
		"district": "KS",
		"owner": "Spouse",
		"assetDescription": "Alphabet Cl C",
		"assetType": "Stock",
		"type": "Sale (Partial)",
		"amount": "$1,001 - $15,000",
		"capitalGainsOver200USD": "False",
		"comment": "--",
		"link": "https://efdsearch.senate.gov/search/view/ptr/b83b6502-520b-4403-9777-60f6c2d93bc1/"
	}
]
```

---


### 31. house-trading-by-name API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/house-trading-by-name

**About:**

Endpoint:

https://financialmodelingprep.com/stable/house-trades-by-name?name=James

**Endpoint:**

```
https://financialmodelingprep.com/stable/house-trades-by-name?name=James
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | James |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "KD",
		"disclosureDate": "2026-01-26",
		"transactionDate": "2025-12-31",
		"firstName": "James French",
		"lastName": "Hill",
		"office": "James French Hill",
		"district": "AR02",
		"owner": "",
		"assetDescription": "Kyndryl Holdings Inc",
		"assetType": "Stock",
		"type": "Sale",
		"amount": "$1,001 - $15,000",
		"capitalGainsOver200USD": "False",
		"comment": "",
		"link": "https://disclosures-clerk.house.gov/public_disc/ptr-pdfs/2026/20033661.pdf"
	}
]
```

---

### 32. As Reported Balance Statements API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/as-reported-balance-statements

**Summary:**

As Reported Balance Statements API를 통해 기업이 공식 제출한 원본 재무 보고서 기준의 대차대조표에 접근하세요. 공식 공시 파일에서 직접 자산, 부채, 자본에 대한 상세한 재무 데이터를 확인할 수 있습니다.

**About:**

As Reported Balance Statements API는 기업이 보고한 그대로의 조정되지 않은 대차대조표 데이터를 제공합니다. 다음을 포함한 기업의 재무 상태에 대한 통찰을 제공합니다:

Asset Overview: 보고된 현금, 매출채권, 재고 및 장기 자산을 확인합니다.
Liability Breakdown: 유동부채, 비유동부채, 이연수익 등에 접근합니다.
Equity Insights: 이익잉여금 및 주식 세부 정보를 포함한 주주 자본을 분석합니다.

이 API는 정확한 재무 평가를 위해 조정되지 않은 원본 대차대조표 데이터를 원하는 애널리스트와 투자자에게 이상적입니다.

Example Use Case
투자 애널리스트는 As Reported Balance Statements API를 활용하여 Apple의 2010년 1분기 자산-부채 구조를 평가함으로써, 어떠한 조정도 없이 해당 기간의 재무 상태를 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement-as-reported?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | annualquarter |
| The As Reported Balance Statements API offers unadjusted balance sheet data as reported by companies. It provides insight into a company's financial position, including: | This API is ideal for analysts and investors who want raw, as-reported balance sheet data to perform accurate financial assessments. | Example Use Case
An investment analyst can use the As Reported Balance Statements API to evaluate Apple's asset-liability structure for Q1 2010, helping to understand the company's financial position during that period without any adjustments. |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| Has FMP standardized line item names across financial statements? | Yes, FMP has standardized line item names across companies in our Statements APIs to ensure consistency and make it easier to automate analyses at scale.

If you prefer to access the data exactly as reported by each company, we recommend using our As Reported APIs instead. | In the Financial Statements API, why does the "filing date" match the "date" for international symbols? |
| API | FMP | Stock Screener |
| Access balance sheets as reported by the company with the As Reported Balance Statements API. View detailed financial data on assets, liabilities, and equity directly from official filings. | The As Reported Balance Statements API offers unadjusted balance sheet data as reported by companies. It provides insight into a company's financial position, including: | This API is ideal for analysts and investors who want raw, as-reported balance sheet data to perform accurate financial assessments. |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2024,
		"period": "FY",
		"reportedCurrency": null,
		"date": "2024-09-27",
		"data": {
			"cashandcashequivalentsatcarryingvalue": 29943000000,
			"marketablesecuritiescurrent": 35228000000,
			"accountsreceivablenetcurrent": 33410000000,
			"nontradereceivablescurrent": 32833000000,
			"inventorynet": 7286000000,
			"otherassetscurrent": 14287000000,
			"assetscurrent": 152987000000,
			"marketablesecuritiesnoncurrent": 91479000000,
			"propertyplantandequipmentnet": 45680000000,
			"otherassetsnoncurrent": 74834000000,
			"assetsnoncurrent": 211993000000,
			"assets": 364980000000,
			"accountspayablecurrent": 68960000000,
			"otherliabilitiescurrent": 78304000000,
			"contractwithcustomerliabilitycurrent": 8249000000,
			"commercialpaper": 10000000000,
			"longtermdebtcurrent": 10912000000,
			"liabilitiescurrent": 176392000000,
			"longtermdebtnoncurrent": 85750000000,
			"otherliabilitiesnoncurrent": 45888000000,
			"liabilitiesnoncurrent": 131638000000,
			"liabilities": 308030000000,
			"commonstocksharesoutstanding": 15116786000,
			"commonstocksharesissued": 15116786000,
			"commonstocksincludingadditionalpaidincapital": 83276000000,
			"retainedearningsaccumulateddeficit": -19154000000,
			"accumulatedothercomprehensiveincomelossnetoftax": -7172000000,
			"stockholdersequity": 56950000000,
			"liabilitiesandstockholdersequity": 364980000000,
			"commonstockparorstatedvaluepershare": 0.00001,
			"commonstocksharesauthorized":
```

---

### 33. As Reported Cashflow Statements API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/as-reported-cashflow-statements

**Summary:**

As Reported Cash Flow Statements API를 통해 기업이 공식 보고서에 제출한 그대로의 현금흐름표를 확인하세요. 공식 보고서에서 직접 영업, 투자, 재무 활동과 관련된 기업의 현금 흐름을 분석할 수 있습니다.

**About:**

As Reported Cash Flow Statements API는 기업이 보고한 그대로의 조정되지 않은 현금흐름 데이터에 대한 접근을 제공합니다. 다음을 포함합니다:

Operational Cash Flows: 일상적인 사업 활동에서 창출되거나 사용된 현금을 분석합니다.
Investment Cash Flows: 자산, 인수, 유가증권 투자와 관련된 현금 이동에 접근합니다.
Financing Cash Flows: 자본, 부채 발행 및 배당금 지급에 따른 현금을 확인합니다.

이 API는 공식 공시 파일을 기반으로 기업의 현금 흐름 관리를 명확히 이해하고자 하는 사용자에게 이상적입니다.

Example Use Case
재무 애널리스트는 이 API를 활용하여 Apple의 2010년 1분기 현금흐름 추이를 추적함으로써, 기업이 영업 및 투자를 위한 현금을 얼마나 효과적으로 관리하고 있는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement-as-reported?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | annualquarter |
| The As Reported Cash Flow Statements API provides access to unadjusted cash flow data as reported by companies. This includes: | This API is ideal for users looking for a clear understanding of a company's cash flow management based on official filings. | Example Use Case
A financial analyst can use this API to track Apple's cash flow trends during Q1 2010, helping assess how effectively the company is managing its cash for operations and investments. |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| Has FMP standardized line item names across financial statements? | Yes, FMP has standardized line item names across companies in our Statements APIs to ensure consistency and make it easier to automate analyses at scale.

If you prefer to access the data exactly as reported by each company, we recommend using our As Reported APIs instead. | In the Financial Statements API, why does the "filing date" match the "date" for international symbols? |
| API | FMP | Stock Screener |
| View cash flow statements as reported by the company with the As Reported Cash Flow Statements API. Analyze a company's cash flows related to operations, investments, and financing directly from official reports. | The As Reported Cash Flow Statements API provides access to unadjusted cash flow data as reported by companies. This includes: | This API is ideal for users looking for a clear understanding of a company's cash flow management based on official filings. |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2024,
		"period": "FY",
		"reportedCurrency": null,
		"date": "2024-09-27",
		"data": {
			"cashcashequivalentsrestrictedcashandrestrictedcashequivalents": 29943000000,
			"netincomeloss": 93736000000,
			"depreciationdepletionandamortization": 11445000000,
			"sharebasedcompensation": 11688000000,
			"othernoncashincomeexpense": 2266000000,
			"increasedecreaseinaccountsreceivable": 3788000000,
			"increasedecreaseinotherreceivables": 1356000000,
			"increasedecreaseininventories": 1046000000,
			"increasedecreaseinotheroperatingassets": 11731000000,
			"increasedecreaseinaccountspayable": 6020000000,
			"increasedecreaseinotheroperatingliabilities": 15552000000,
			"netcashprovidedbyusedinoperatingactivities": 118254000000,
			"paymentstoacquireavailableforsalesecuritiesdebt": 48656000000,
			"proceedsfrommaturitiesprepaymentsandcallsofavailableforsalesecurities": 51211000000,
			"proceedsfromsaleofavailableforsalesecuritiesdebt": 11135000000,
			"paymentstoacquirepropertyplantandequipment": 9447000000,
			"paymentsforproceedsfromotherinvestingactivities": 1308000000,
			"netcashprovidedbyusedininvestingactivities": 2935000000,
			"paymentsrelatedtotaxwithholdingforsharebasedcompensation": 5600000000,
			"paymentsofdividends": 15234000000,
			"paymentsforrepurchaseofcommonstock": 94949000000,
			"repaymentsoflongtermdebt": 9958000000,
			"proceedsfromrepaymentsofcommercialpaper": 3960000000,
			"proceedsfrompaymentsforotherfinancinga
```

---

### 34. As Reported Financial Statements API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/as-reported-financial-statements

**Summary:**

FMP As Reported Financial Statements API를 통해 기업이 보고한 그대로의 종합 재무제표를 조회하세요. 손익계산서, 대차대조표, 현금흐름표 전반에 걸친 원본 형태의 완전한 데이터에 접근하여 상세 분석을 수행할 수 있습니다.

**About:**

As Reported Financial Statements API는 기업 공시 파일에서 직접 원본의 조정되지 않은 재무제표를 사용자에게 제공합니다. 이 API는 다음에 이상적입니다:

Detailed Financial Audits: 기업이 보고한 그대로의 손익계산서, 대차대조표, 현금흐름표에 접근하여 컴플라이언스와 정확성을 보장합니다.
Investment Analysis: 보고된 수치를 분석하여 시간에 따른 기업의 재무 성과를 평가하고 업계 동종 기업들과 비교합니다.
Historical Data Tracking: 과거 재무 데이터를 조회하여 추세를 파악하고, 성장 기회를 발굴하거나 잠재적 위험 신호를 식별합니다.
Compliance and Reporting: 감사, 컴플라이언스 또는 규제 보고를 위해 원시 데이터를 활용하여 기록이 기업의 공개 공시와 일치하도록 보장합니다.

이 API를 통해 투자자, 감사인, 애널리스트는 더 높은 정확도와 통찰력을 위해 상장 기업이 제출한 원본 재무 데이터를 심층적으로 분석할 수 있습니다.

Example Use Case
감사인은 As Reported Financial Statements API를 사용하여 SEC에 보고된 그대로의 Apple 과거 재무 데이터(대차대조표, 손익계산서, 현금흐름표 포함)를 조회할 수 있습니다. 이 원시 데이터는 투자 분석의 정확성을 검증하거나 재무 보고 기준 준수 여부를 확인하는 데 활용될 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-statement-full-as-reported?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

---

### 35. As Reported Income Statements API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/as-reported-income-statements

**Summary:**

As Reported Income Statements API를 통해 기업이 보고한 그대로의 손익계산서를 조회하세요. 매출, 비용, 순이익을 포함한 원시 재무 데이터에 공식 기업 공시 파일에서 직접 접근할 수 있습니다.

**About:**

As Reported Income Statements API는 공식 재무제표에 보고된 그대로의 기업 재무 성과를 명확하고 직접적으로 제공합니다. 이 API는 다음에 유용합니다:

Direct Financial Insights: 조정 없이 기업이 보고한 그대로의 손익계산서 데이터에 접근합니다.
Comprehensive Expense Tracking: 매출, 매출원가, 영업비용의 상세한 분류를 확인합니다.
In-Depth Analysis: 원시 데이터를 활용하여 자체적인 계산을 수행하고 공식 수치를 기반으로 모델을 구축합니다.

이 API를 통해 투자자와 애널리스트는 수익성과 운영 효율성 평가를 위해 가장 정확한 기업 제공 재무 정보를 활용할 수 있습니다.

Example Use Case
재무 애널리스트는 As Reported Income Statements API를 활용하여 Apple의 분기별 손익계산서에 접근함으로써, 어떠한 조정도 없이 서로 다른 회계 기간의 영업이익과 순이익을 비교할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement-as-reported?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | annualquarter |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2024,
		"period": "FY",
		"reportedCurrency": null,
		"date": "2024-09-27",
		"data": {
			"revenuefromcontractwithcustomerexcludingassessedtax": 391035000000,
			"costofgoodsandservicessold": 210352000000,
			"grossprofit": 180683000000,
			"researchanddevelopmentexpense": 31370000000,
			"sellinggeneralandadministrativeexpense": 26097000000,
			"operatingexpenses": 57467000000,
			"operatingincomeloss": 123216000000,
			"nonoperatingincomeexpense": 269000000,
			"incomelossfromcontinuingoperationsbeforeincometaxesextraordinaryitemsnoncontrollinginterest": 123485000000,
			"incometaxexpensebenefit": 29749000000,
			"netincomeloss": 93736000000,
			"earningspersharebasic": 6.11,
			"earningspersharediluted": 6.08,
			"weightedaveragenumberofsharesoutstandingbasic": 15343783000,
			"weightedaveragenumberofdilutedsharesoutstanding": 15408095000,
			"othercomprehensiveincomelossforeigncurrencytransactionandtranslationadjustmentnetoftax": 395000000,
			"othercomprehensiveincomelossderivativeinstrumentgainlossbeforereclassificationaftertax": -832000000,
			"othercomprehensiveincomelossderivativeinstrumentgainlossreclassificationaftertax": 1337000000,
			"othercomprehensiveincomelossderivativeinstrumentgainlossafterreclassificationandtax": -2169000000,
			"othercomprehensiveincomeunrealizedholdinggainlossonsecuritiesarisingduringperiodnetoftax": 5850000000,
			"othercomprehensiveincomelossreclassificationadjustmentfromaociforsaleofsecurities
```

---


### 36. Available Countries API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/available-countries

**Summary:**

FMP Available Countries API를 사용하여 주식 심볼이 제공되는 국가의 포괄적인 목록에 접근하세요. 이 API를 통해 사용자는 기업의 본국 또는 해당 증권이 주로 거래되는 시장을 기준으로 주식 심볼을 필터링하고 분석할 수 있습니다.

**About:**

FMP Available Countries API는 사용자에게 국가 기반 데이터에 대한 상세한 접근권을 제공하며, 다음 작업을 가능하게 합니다:

Filter by Country of Origin: 기업이 본사를 둔 국가를 기준으로 주식 심볼을 조회합니다.
Analyze Market Data by Country: 보다 지역화된 시장 조사를 위해 특정 국가의 주식 거래소 및 증권에 집중합니다.
Country-Based Comparisons: 글로벌 투자 전략 수립을 위해 서로 다른 국가의 기업 및 증권을 비교합니다.

이 API는 심층 분석을 위해 특정 국가나 시장에 집중하려는 투자자, 애널리스트, 연구자에게 적합합니다.

Example Use Case
한 투자자가 Available Countries API를 사용하여 영국에서 거래되는 기업에 집중함으로써, 국제 투자 기회를 위한 영국 상장 증권의 상세 분석을 수행할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/available-countries
```

**Sample Response:**

```json
[
	{
		"country": "FK"
	}
]
```

---

### 37. Available Exchanges API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/available-exchanges

**Summary:**

FMP Available Exchanges API를 사용하여 지원되는 주식 거래소의 전체 목록에 접근하세요. 이 API는 전 세계 주식 거래소에 대한 포괄적인 개요를 제공하여, 사용자가 증권이 거래되는 곳을 파악하고 추가 분석을 위해 특정 거래소를 기준으로 데이터를 필터링할 수 있도록 합니다.

**About:**

FMP Available Exchanges API는 사용자에게 지원되는 모든 주식 거래소의 상세 목록을 제공하며, 증권이 거래되는 곳을 이해하려는 투자자, 트레이더, 연구자에게 유용한 정보를 제공합니다. 주요 기능은 다음과 같습니다:

Global Exchange List: NYSE, NASDAQ 등 주요 주식 거래소를 포함하여 전 세계에서 지원되는 거래소의 전체 목록을 조회합니다.
Exchange Name and Short Name: 쉬운 식별과 필터링을 위해 거래소 전체 이름과 단축 코드를 모두 제공합니다.
Data Filtering by Exchange: 이 목록을 활용하여 특정 거래소를 기준으로 추가 쿼리를 필터링함으로써, 필요에 맞는 집중적이고 정확한 데이터 조회를 보장합니다.

이 API는 주식 거래소 정보를 기반으로 금융 데이터를 정리하거나 필터링하려는 사람에게 필수적입니다.

Example Use Case
한 금융 애널리스트가 Available Exchanges API를 사용하여 거래소별로 주가 데이터를 필터링하는 맞춤형 대시보드를 구축함으로써, 특정 시장과 관련된 증권을 추적할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/available-exchanges
```

**Sample Response:**

```json
[
	{
		"exchange": "AMEX",
		"name": "New York Stock Exchange Arca",
		"countryName": "United States of America",
		"countryCode": "US",
		"symbolSuffix": "N/A",
		"delay": "Real-time"
	}
]
```

---

### 38. Available Industries API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/available-industries

**Summary:**

FMP Available Industries API를 사용하여 주식 심볼이 제공되는 산업의 포괄적인 목록에 접근하세요. 이 API는 사용자가 보다 집중적인 조사와 분석을 위해 산업을 기준으로 기업을 필터링하고 분류하는 데 도움을 줍니다.

**About:**

FMP Available Industries API는 산업 분류에 대한 상세한 접근권을 제공하여 사용자가 다음 작업을 할 수 있도록 합니다:

Categorize Companies by Their Industry: 자동차, 제약, 철강 등 특정 산업을 기준으로 기업을 분류합니다.
Filter Data for Precision: 산업 필터를 사용하여 쿼리를 세분화함으로써 관련 데이터만 조회할 수 있습니다.
Industry-Based Comparisons: 심층 분석 및 경쟁력 벤치마킹을 위해 동일 산업 내 기업들을 비교합니다.

이 API는 표적 조사 및 인사이트 도출을 위해 특정 섹터나 산업에 집중하려는 투자자, 애널리스트, 산업 연구자에게 이상적입니다.

Example Use Case
한 금융 애널리스트가 Available Industries API를 사용하여 철강 산업 내 기업들을 필터링함으로써, 해당 산업 내 경쟁사와 시장 트렌드에 대한 보다 세분화된 분석을 수행할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/available-industries
```

**Sample Response:**

```json
[
	{
		"industry": "Steel"
	}
]
```

---

### 39. Available Sectors API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/available-sectors

**Summary:**

FMP Available Sectors API를 사용하여 산업 섹터의 전체 목록에 접근하세요. 이 API는 사용자가 해당 섹터를 기준으로 기업을 분류하고 필터링하여, 다양한 산업에 걸쳐 심층 분석과 보다 집중적인 쿼리를 수행할 수 있도록 합니다.

**About:**

FMP Available Sectors API는 사용자에게 광범위한 산업 섹터에 대한 접근권을 제공하여 다음을 더 쉽게 수행할 수 있도록 합니다:

Categorize companies by their sector: 기술, 헬스케어, 소비재 등 특정 산업이나 섹터 내 기업을 분석합니다.
Filter data: 섹터 필터를 사용하여 쿼리를 세분화하고 표적 분석에 필요한 관련 데이터를 조회합니다.
Sector-based comparisons: 동종 업체 분석 및 벤치마킹을 위해 동일 섹터 내 기업들을 비교합니다.

이 API는 섹터 기반 트렌드를 분석하거나 특정 산업 내에서 운영되는 기업에 집중하려는 투자자, 애널리스트, 연구자에게 이상적입니다.

Example Use Case
한 투자 회사가 Available Sectors API를 사용하여 기술 섹터 내 기업만을 필터링하고 분석함으로써, 해당 시장 세그먼트의 성장 트렌드나 잠재적 투자 기회를 추적할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/available-sectors
```

**Sample Response:**

```json
[
	{
		"sector": "Basic Materials"
	}
]
```

---

### 40. Available Transcript Symbols API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/available-transcript-symbols

**Summary:**

FMP Available Earnings Transcript Symbols API를 사용하여 실적 발표 컨퍼런스 콜 트랜스크립트가 제공되는 주식 심볼의 전체 목록에 접근하세요. 어떤 기업의 실적 트랜스크립트가 존재하는지, 그리고 상세한 재무 분석을 위해 얼마나 많은 트랜스크립트에 접근할 수 있는지에 대한 정보를 조회하세요.

**About:**

FMP Available Earnings Transcript Symbols API는 사용자에게 실적 발표 컨퍼런스 콜 트랜스크립트가 제공되는 기업의 포괄적인 목록을 제공합니다. 이 API는 시간 경과에 따른 기업의 실적 논의 및 성과를 추적하려는 애널리스트, 투자자, 연구자를 위해 설계되었으며, 다음을 포함합니다:

Earnings Transcript Availability: 검토 가능한 실적 발표 컨퍼런스 콜 트랜스크립트가 있는 기업 목록을 조회합니다.
Number of Available Transcripts: 각 기업별로 제공되는 트랜스크립트의 총 수를 확인하여, 사용자가 여러 기간에 걸친 트렌드를 분석할 수 있습니다.
Quick Access to Relevant Symbols: 실적 발표 컨퍼런스 콜을 통해 인사이트를 제공하는 기업을 손쉽게 파악하여 조사 및 성과 분석을 용이하게 합니다.

이 API는 어떤 기업에 실적 트랜스크립트가 있는지 파악하는 과정을 간소화하여, 재무 관련 논의에 더 쉽게 접근하고 분석할 수 있도록 합니다.

Example Use Case
한 리서치 애널리스트가 Available Earnings Transcript Symbols API를 사용하여 다수의 실적 트랜스크립트를 보유한 기업 목록을 작성함으로써, 더 나은 트렌드 분석을 위해 가장 많은 과거 데이터를 보유한 기업에 집중할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earnings-transcript-list
```

**Sample Response:**

```json
[
	{
		"symbol": "MCUJF",
		"companyName": "Medicure Inc.",
		"noOfTranscripts": "16"
	}
]
```

---


### 41. Average Directional Index API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/average-directional-index

**Summary:**

0~100 척도로 추세 강도를 측정하는 지표로, 평활화된 방향성 움직임에서 도출되며 추세 시장과 횡보 시장을 구분하는 데 사용됩니다.

**About:**

ADX는 선택한 기간 동안 +DI와 -DI 방향성 지표 간 절대 차이를 평활화한 평균값입니다. 25 이상의 수치는 일반적으로 추세가 형성되고 있음을 나타내고, 40 이상은 강한 추세를 나타냅니다. 반면 20 미만의 지속적인 수치는 횡보 시장을 시사합니다. 이 지표는 강도만 나타내며, 방향은 +DI / -DI 쌍을 통해 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/adx?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"adx": 19.958386928035946
	}
]
```

---

### 42. Balance Sheet Statement API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/balance-sheet-statement

**Summary:**

Balance Sheet Data API를 통해 상장 기업의 상세한 재무상태표에 접근하세요. 자산, 부채, 주주 자본을 분석하여 기업의 재무 건전성에 대한 통찰을 얻을 수 있습니다.

**About:**

Balance Sheet Data API는 투자자, 애널리스트, 금융 전문가들이 기업의 상세한 재무상태표 정보를 조회할 수 있도록 합니다. 이 API는 다음 용도에 필수적입니다:

Comprehensive Financial Analysis: 자산, 부채, 주주 자본의 핵심 데이터를 조회하여 기업의 재무 구조와 지급 능력을 상세히 평가할 수 있습니다.
Evaluating Company Health: 단기 및 장기 자산, 부채, 주주 자본 포지션을 통해 기업의 유동성과 레버리지를 파악합니다.
Supporting Investment Decisions: 재무상태표를 활용해 동일 산업 또는 섹터 내 기업들을 비교하고, 기업의 재무 안정성을 바탕으로 합리적인 투자 결정을 내릴 수 있습니다.

이 API는 실시간 및 과거 재무상태표 데이터를 제공하며, 다양한 기간에 걸친 기업의 재무 건전성 스냅샷을 제공합니다. 기업의 재무 성과를 분석하거나 실사를 수행할 때, 이 데이터를 통해 핵심 재무 지표를 손쉽게 평가할 수 있습니다.

Example Use Case
잠재적 주식 매수를 검토 중인 투자자가 Balance Sheet Data API를 활용하여 해당 기업의 자산과 부채를 평가합니다. 보유 현금, 부채 의무, 총 자본을 검토하여 기업의 재무적 안정성을 확인합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2024-09-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2024-11-01",
		"acceptedDate": "2024-11-01 06:01:36",
		"fiscalYear": "2024",
		"period": "FY",
		"cashAndCashEquivalents": 29943000000,
		"shortTermInvestments": 35228000000,
		"cashAndShortTermInvestments": 65171000000,
		"netReceivables": 66243000000,
		"accountsReceivables": 33410000000,
		"otherReceivables": 32833000000,
		"inventory": 7286000000,
		"prepaids": 0,
		"otherCurrentAssets": 14287000000,
		"totalCurrentAssets": 152987000000,
		"propertyPlantEquipmentNet": 45680000000,
		"goodwill": 0,
		"intangibleAssets": 0,
		"goodwillAndIntangibleAssets": 0,
		"longTermInvestments": 91479000000,
		"taxAssets": 19499000000,
		"otherNonCurrentAssets": 55335000000,
		"totalNonCurrentAssets": 211993000000,
		"otherAssets": 0,
		"totalAssets": 364980000000,
		"totalPayables": 95561000000,
		"accountPayables": 68960000000,
		"otherPayables": 26601000000,
		"accruedExpenses": 0,
		"shortTermDebt": 20879000000,
		"capitalLeaseObligationsCurrent": 1632000000,
		"taxPayables": 26601000000,
		"deferredRevenue": 8249000000,
		"otherCurrentLiabilities": 50071000000,
		"totalCurrentLiabilities": 176392000000,
		"longTermDebt": 85750000000,
		"deferredRevenueNonCurrent": 10798000000,
		"deferredTaxLiabilitiesNonCurrent": 0,
		"otherNonCurrentLiabilities": 35090000000,
		"totalNonCurrentLiabilities": 131638000000,
		"otherLiabilities": 0,
		"capitalLeaseObligations": 1243
```

---

### 43. Balance Sheet Statement Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/balance-sheet-statement-bulk

**Summary:**

Bulk Balance Sheet Statement API는 여러 기업의 재무상태표 데이터에 포괄적으로 접근할 수 있게 해줍니다. 총 자산, 부채, 자본 등 핵심 수치를 조회하여 재무 포지션을 분석할 수 있습니다. 대규모로 다양한 기업의 재무 건전성과 안정성을 비교하는 데 이상적입니다.

**About:**

이 API는 다음을 위한 강력한 도구입니다:

Financial Analysis: 재무상태표 데이터를 조회하여 자산, 부채, 자본을 평가하고, 여러 기업의 재무 건전성을 분석합니다.
Bulk Data Retrieval: 단일 요청으로 광범위한 기업들의 상세한 재무 포지션을 확보하여 비교 분석 및 포트폴리오 평가를 수행합니다.
Corporate Health Assessment: 총 부채, 현금 및 현금성 자산, 순수취채권, 주주 자본 등의 지표를 분석하여 기업 재무상태표의 견고성을 파악합니다.
Historical Tracking: 재무상태표 데이터를 활용해 기업의 재무 포지션 변화를 시간 순으로 추적하고, 재무 상황의 추세와 변화를 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2025-03-31",
		"symbol": "MTLRP.ME",
		"reportedCurrency": "RUB",
		"cik": "0000000000",
		"filingDate": "2025-05-31",
		"acceptedDate": "2025-03-31 07:00:00",
		"fiscalYear": "2025",
		"period": "Q1",
		"cashAndCashEquivalents": "1985000",
		"shortTermInvestments": "0",
		"cashAndShortTermInvestments": "1985000",
		"netReceivables": "9666577000",
		"accountsReceivables": "9666577000",
		"otherReceivables": "0",
		"inventory": "4520000",
		"prepaids": "0",
		"otherCurrentAssets": "27293000",
		"totalCurrentAssets": "9700830000",
		"propertyPlantEquipmentNet": "194000",
		"goodwill": "0",
		"intangibleAssets": "5665000",
		"goodwillAndIntangibleAssets": "5665000",
		"longTermInvestments": "237373355000",
		"taxAssets": "791813000",
		"otherNonCurrentAssets": "0",
		"totalNonCurrentAssets": "238171027000",
		"otherAssets": "0",
		"totalAssets": "247871857000",
		"totalPayables": "3861497000",
		"accountPayables": "3861497000",
		"otherPayables": "0",
		"accruedExpenses": "0",
		"shortTermDebt": "4842848000",
		"capitalLeaseObligationsCurrent": "0",
		"taxPayables": "2484576000",
		"deferredRevenue": "0",
		"otherCurrentLiabilities": "146647000",
		"totalCurrentLiabilities": "8851455000",
		"longTermDebt": "178923999000",
		"capitalLeaseObligationsNonCurrent": "0",
		"deferredRevenueNonCurrent": "0",
		"deferredTaxLiabilitiesNonCurrent": "737391000",
		"otherNonCurrentLiabilities": "52574304000",
		"totalNonCurrentLiabilities": "232235780000",
		"otherLiabilities
```

---

### 44. Balance Sheet Statement Growth API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/balance-sheet-statement-growth

**Summary:**

Balance Sheet Statement Growth API를 통해 핵심 재무상태표 항목들의 시간에 따른 성장을 분석하세요. 자산, 부채, 자본의 변화를 추적하여 기업의 재무적 진화를 파악할 수 있습니다.

**About:**

Balance Sheet Statement Growth API는 핵심 재무상태표 구성 요소에 대한 전년 대비 성장 지표를 제공합니다. 이 API는 다음에 적합합니다:

Asset Growth Analysis: 현금, 재고, 장기 투자 등 자산의 변화를 추적하여 기업 자원이 확대되고 있는지 축소되고 있는지를 평가합니다.
Liability Growth Monitoring: 미지급금과 부채를 포함한 단기 및 장기 부채의 변화 추이를 파악합니다.
Equity Growth Tracking: 주주 자본, 이익잉여금, 총 자본의 변동을 모니터링하여 기업의 재무 건전성에 대한 통찰을 얻습니다.

이 API는 재무 애널리스트와 투자자들이 재무상태표 항목의 변화를 분석함으로써 기업의 안정성과 성장을 평가하는 데 도움을 줍니다.

Example Use Case
투자자는 Balance Sheet Statement Growth API를 활용하여 Apple의 현금 보유량과 부채 수준이 지난 한 해 동안 어떻게 변화했는지 분석하고, 기업의 유동성과 재무 건전성을 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement-growth?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"growthCashAndCashEquivalents": -0.0007341898882029034,
		"growthShortTermInvestments": 0.11516302627413738,
		"growthCashAndShortTermInvestments": 0.058744212492892536,
		"growthNetReceivables": 0.08621792243994425,
		"growthInventory": 0.15084504817564365,
		"growthOtherCurrentAssets": -0.02776454576386526,
		"growthTotalCurrentAssets": 0.06562138667929733,
		"growthPropertyPlantEquipmentNet": -0.15992349565984992,
		"growthGoodwill": 0,
		"growthIntangibleAssets": 0,
		"growthGoodwillAndIntangibleAssets": 0,
		"growthLongTermInvestments": -0.09015953214513049,
		"growthTaxAssets": 0.09225857046829487,
		"growthOtherNonCurrentAssets": 0.5266933370120016,
		"growthTotalNonCurrentAssets": 0.014238076328719674,
		"growthOtherAssets": 0,
		"growthTotalAssets": 0.035160515396374756,
		"growthAccountPayables": 0.1014039066617687,
		"growthShortTermDebt": 0.32087050041121024,
		"growthTaxPayables": 2.01632838190271,
		"growthDeferredRevenue": 0.023322168465450935,
		"growthOtherCurrentLiabilities": -0.1254584832500786,
		"growthTotalCurrentLiabilities": 0.21391802240757563,
		"growthLongTermDebt": -0.10003043628845205,
		"growthDeferredRevenueNonCurrent": 0,
		"growthDeferredTaxLiabilitiesNonCurrent": 0,
		"growthOtherNonCurrentLiabilities": -0.09048495373370312,
		"growthTotalNonCurrentLiabilities": -0.09295867814151548,
		"growthOtherLiabilities": 0,
		"growt
```

---

### 45. Balance Sheet Statement Growth Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/balance-sheet-statement-growth-bulk

**Summary:**

Balance Sheet Growth Bulk API를 통해 여러 기업의 재무상태표 성장 데이터를 조회하고, 재무 포지션이 시간에 따라 어떻게 변화했는지를 상세히 분석할 수 있습니다.

**About:**

이 API는 다음을 위해 설계되었습니다:

Trend Analysis: 현금 및 단기 투자, 수취채권, 총 부채, 자본 등 재무 지표의 성장 또는 감소 추이를 추적합니다.
Comparative Insights: 다양한 기간에 걸쳐 여러 기업의 재무 포지션 변화를 분석하여 추세, 리스크, 기회를 포착합니다.
Long-Term Financial Health Assessment: 기업 재무상태표의 변화 과정을 평가하여 장기적인 재무 안정성에 대한 심층적인 통찰을 제공합니다.

이 API는 자산, 부채, 자본의 발전 상황을 추적하고 기업의 재무 궤적에 대한 통찰을 제공하는 데 필수적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement-growth-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"date": "2025-03-31",
		"fiscalYear": "2025",
		"period": "Q1",
		"reportedCurrency": "CNY",
		"growthCashAndCashEquivalents": "0.09574482145872953",
		"growthShortTermInvestments": "0",
		"growthCashAndShortTermInvestments": "0.09574482145872953",
		"growthNetReceivables": "0",
		"growthInventory": "0",
		"growthOtherCurrentAssets": "0",
		"growthTotalCurrentAssets": "0.09574482145872953",
		"growthPropertyPlantEquipmentNet": "-0.06373337231398918",
		"growthGoodwill": "0",
		"growthIntangibleAssets": "-0.03270278935556268",
		"growthGoodwillAndIntangibleAssets": "-0.01477618426770969",
		"growthLongTermInvestments": "-0.0774117797082201",
		"growthTaxAssets": "0",
		"growthOtherNonCurrentAssets": "0.07678934705504345",
		"growthTotalNonCurrentAssets": "-0.01112505367669385",
		"growthOtherAssets": "0.001488576544346165",
		"growthTotalAssets": "0.001488576544346165",
		"growthAccountPayables": "0",
		"growthShortTermDebt": "0",
		"growthTaxPayables": "-0.0279424216765453",
		"growthDeferredRevenue": "0",
		"growthOtherCurrentLiabilities": "0.12022416350749959",
		"growthTotalCurrentLiabilities": "0",
		"growthLongTermDebt": "0",
		"growthDeferredRevenueNonCurrent": "0",
		"growthDeferredTaxLiabilitiesNonCurrent": "0",
		"growthOtherNonCurrentLiabilities": "0",
		"growthTotalNonCurrentLiabilities": "0",
		"growthOtherLiabilities": "-0.0005084911577141635",
		"growthTotalLiabilities": "-0.0005084911577141635",
		"growthPreferredStock": "0",
		"
```

---

### 46. Balance Sheet Statements TTM API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/balance-sheet-statements-ttm

**About:**

이 API는 최근 12개월(TTM) 기준의 재무상태표(Balance Sheet) 데이터를 제공합니다. 특정 종목 심볼을 입력하면 현금 및 현금성 자산, 단기 투자, 매출채권, 재고, 총자산, 총부채, 자기자본 등 핵심 재무 항목을 조회할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/balance-sheet-statement-ttm?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |

**Sample Response:**

```json
[
	{
		"date": "2024-12-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2025-01-31",
		"acceptedDate": "2025-01-31 06:01:27",
		"fiscalYear": "2025",
		"period": "Q1",
		"cashAndCashEquivalents": 30299000000,
		"shortTermInvestments": 23476000000,
		"cashAndShortTermInvestments": 53775000000,
		"netReceivables": 59306000000,
		"accountsReceivables": 29639000000,
		"otherReceivables": 29667000000,
		"inventory": 6911000000,
		"prepaids": 0,
		"otherCurrentAssets": 13248000000,
		"totalCurrentAssets": 133240000000,
		"propertyPlantEquipmentNet": 46069000000,
		"goodwill": 0,
		"intangibleAssets": 0,
		"goodwillAndIntangibleAssets": 0,
		"longTermInvestments": 87593000000,
		"taxAssets": 0,
		"otherNonCurrentAssets": 77183000000,
		"totalNonCurrentAssets": 210845000000,
		"otherAssets": 0,
		"totalAssets": 344085000000,
		"totalPayables": 61910000000,
		"accountPayables": 61910000000,
		"otherPayables": 0,
		"accruedExpenses": 0,
		"shortTermDebt": 12843000000,
		"capitalLeaseObligationsCurrent": 0,
		"taxPayables": 0,
		"deferredRevenue": 8461000000,
		"otherCurrentLiabilities": 61151000000,
		"totalCurrentLiabilities": 144365000000,
		"longTermDebt": 83956000000,
		"deferredRevenueNonCurrent": 0,
		"deferredTaxLiabilitiesNonCurrent": 0,
		"otherNonCurrentLiabilities": 49006000000,
		"totalNonCurrentLiabilities": 132962000000,
		"otherLiabilities": 0,
		"capitalLeaseObligations": 0,
		"totalLiabilities": 277327000000,
		"treasurySto
```

---

### 47. Batch Aftermarket Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/batch-aftermarket-quote

**Summary:**

FMP Batch Aftermarket Quote API를 통해 여러 종목의 실시간 장후(애프터마켓) 호가 데이터를 조회하세요. 장 마감 후 거래 시간 동안 여러 기업의 매수/매도 호가, 거래량 및 기타 관련 데이터에 접근할 수 있습니다.

**About:**

FMP Batch Aftermarket Quote API를 사용하면 여러 종목의 장후 거래 활동을 한 번에 효율적으로 추적할 수 있습니다. 이 API는 다음과 같은 용도에 적합합니다:

Monitoring Multiple Stocks: 여러 종목의 매수/매도 호가, 거래량 및 주요 장후 데이터를 동시에 조회하여 장 마감 후 가격 움직임을 종합적으로 파악할 수 있습니다.
Post-Market Strategy: 배치 데이터를 활용해 주식 성과를 분석하고, 다음 거래 세션에 영향을 미칠 수 있는 장후 트렌드를 기반으로 전략을 수립합니다.
Streamlined Data Access: 포트폴리오 또는 관심 종목 목록 전반의 장후 거래 환경을 단일 요청으로 추적합니다.

Batch Aftermarket Quote API는 정규 시장 시간 외에 여러 종목의 실시간 데이터를 제공함으로써 투자자가 더 빠르고 정확한 의사결정을 내릴 수 있도록 지원합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-aftermarket-quote?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"bidSize": 1,
		"bidPrice": 232.45,
		"askSize": 3,
		"askPrice": 232.64,
		"volume": 41647042,
		"timestamp": 1738715334311
	}
]
```

---

### 48. Batch Aftermarket Trade API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/batch-aftermarket-trade

**Summary:**

FMP Batch Aftermarket Trade API를 통해 여러 종목의 실시간 장후 거래 데이터를 조회하세요. 여러 기업의 장 마감 후 체결 가격, 거래량, 타임스탬프를 동시에 추적할 수 있습니다.

**About:**

FMP Batch Aftermarket Trade API는 단일 요청으로 여러 종목의 상세한 장후 거래 데이터를 제공합니다. 이 API는 다음과 같은 용도에 적합합니다:

Monitoring Multiple Stocks: 여러 기업의 장 마감 후 체결 내역을 실시간으로 파악하여 정규 시간 외 가격 변동과 거래 활동을 추적합니다.
Efficient Data Access: 종목별로 데이터를 개별 조회하는 대신, 이 API를 통해 여러 종목의 장후 거래 정보를 한 번에 접근합니다.
Enhanced Investment Decisions: 장후 세션의 실시간 데이터를 활용해 여러 종목에 걸친 트렌드나 패턴을 분석하고 다음 거래일을 준비합니다.

이 API를 통해 투자자는 여러 종목의 장후 활동을 효율적으로 추적하여 보다 포괄적인 분석과 전략 조정이 가능합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-aftermarket-trade?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 232.53,
		"tradeSize": 132,
		"timestamp": 1738715334311
	}
]
```

---

### 49. Batch Forex Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/all-forex-quotes

**Summary:**

Batch Forex Quotes API를 통해 여러 외환 통화쌍의 실시간 호가에 손쉽게 접근하세요. 글로벌 환율 동향을 파악하고 다양한 시장 전반의 가격 변화를 모니터링합니다.

**About:**

Batch Forex Quotes API를 사용하면 단일 요청으로 다수의 통화쌍에 대한 실시간 외환 호가를 조회할 수 있어, 여러 외환 쌍을 동시에 모니터링하는 과정이 간소화됩니다.

Track Global Exchange Rates: 전 세계 다양한 통화쌍의 실시간 가격을 조회합니다.
Bulk Data Retrieval: 가격, 변동폭, 거래량을 포함한 여러 통화쌍의 실시간 외환 호가를 한 번에 수신합니다.
Ideal for High-Frequency Traders: 여러 통화쌍을 빠르고 효율적으로 모니터링해야 하는 트레이더 및 애널리스트에게 최적화되어 있습니다.

이 API는 글로벌 외환 시장을 추적하는 과정을 간소화하여 환율과 가격 변동을 실시간으로 쉽게 파악할 수 있도록 합니다.

Example Use Case
한 외환 트레이더가 Batch Forex Quotes API를 활용해 50개의 서로 다른 통화쌍 호가를 한 번에 조회하여, 글로벌 통화들의 실시간 가격 움직임과 거래량을 모니터링합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-forex-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "AEDAUD",
		"price": 0.41372,
		"change": 0.00153892,
		"volume": 0
	}
]
```

---

### 50. Batch Market Cap API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/batch-market-cap

**Summary:**

FMP Batch Market Capitalization API를 통해 단일 요청으로 여러 기업의 시가총액 데이터를 조회하세요. 이 API를 사용하면 다양한 기업의 시장 규모를 동시에 비교하여 기업 가치 평가 분석을 효율화할 수 있습니다.

**About:**

FMP Batch Market Capitalization API는 하나의 배치 요청으로 여러 기업의 시가총액 데이터를 빠르고 효율적으로 수집할 수 있는 방법을 제공합니다. 주요 특징은 다음과 같습니다:

Multiple Companies in One Request: 단일 API 호출로 다수 기업의 시가총액을 조회하여 시간과 노력을 절약합니다.
Compare Market Sizes: 여러 기업의 시가총액을 분석하고 비교하여 상대적 규모와 시장 내 위상을 평가합니다.
Real-Time and Historical Market Caps: 현재 및 과거 시가총액 데이터에 모두 접근하여 시간에 따른 성과 변화를 추적합니다.

이 API는 여러 기업을 동시에 비교해야 하는 투자자, 애널리스트, 포트폴리오 매니저에게 적합하며, 투자 기회와 시장 트렌드를 빠르게 파악하는 데 도움을 줍니다.

Example Use Case
테크 대기업을 조사하는 한 애널리스트가 Batch Market Capitalization API를 활용해 Apple, Microsoft, Google의 시가총액 데이터를 한 번에 조회합니다. 이를 통해 세 기업의 시장 규모를 빠르게 비교하고 업계 내 각사의 위치를 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/market-capitalization-batch?symbols=AAPL,MSFT,GOOG
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL,MSFT,GOOG |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-10-24",
		"marketCap": 3900351299800
	}
]
```

---



### 51. Biggest Stock Gainers API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/biggest-gainers

**Summary:**

주식 상승폭 상위 API를 활용하여 가격이 가장 크게 오른 주식을 추적하세요. 큰 폭의 가격 급등으로 시장을 선도하는 기업들을 파악하고 잠재적인 성장 기회를 포착하세요.

**About:**

FMP 주식 상승폭 상위 API는 주요 증권 거래소 전반에서 가장 큰 폭의 가격 상승을 경험하고 있는 주식에 대한 실시간 데이터를 제공합니다. 이 API를 통해 사용자는 최고 성과 주식을 추적할 수 있으며, 트레이더와 투자자가 모멘텀과 단기 또는 장기 투자 기회를 식별하는 데 도움을 줍니다. 주요 기능은 다음과 같습니다:

Top Gainers List: 가격 상승폭이 가장 큰 주식의 실시간 목록에 접근합니다.
Real-Time Price & Percentage Changes: 각 주식의 현재 가격, 총 가격 변동, 그리고 변동률을 추적합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 특정 거래소의 주식 상승 상위 종목을 확인합니다.
Company Information: 상위 기업에 대한 주요 정보(이름, 심볼, 가격 변동 정보 포함)를 확인합니다.

이 API는 빠르게 움직이는 주식과 시장 선도 종목을 활용하고자 하는 단기 트레이더, 스윙 트레이더, 투자자에게 최적입니다.

Example Use Case
한 트레이더가 주식 상승폭 상위 API를 활용해 NASDAQ에서 가격 상승폭이 가장 큰 주식을 탐색합니다. 27.69%의 가격 상승을 기록한 CBL International Limited (BANL)를 발견한 후, 트레이더는 해당 모멘텀을 활용하여 이 주식을 거래 전략에 편입할지 결정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/biggest-gainers
```

**Sample Response:**

```json
[
	{
		"symbol": "LTRY",
		"price": 0.5876,
		"name": "Lottery.com Inc.",
		"change": 0.2756,
		"changesPercentage": 88.3333,
		"exchange": "NASDAQ"
	}
]
```

---

### 52. Biggest Stock Losers API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/biggest-losers

**Summary:**

주식 하락폭 상위 API를 활용하여 가격이 가장 크게 떨어진 주식 데이터에 접근하세요. 큰 폭의 하락을 경험하는 기업들을 파악하고 시장에서 가장 빠르게 떨어지는 주식을 추적하세요.

**About:**

FMP 주식 하락폭 상위 API는 다양한 거래소에서 가장 큰 폭의 가격 하락을 기록한 주식에 대한 실시간 데이터를 제공합니다. 이 API를 통해 사용자는 부진한 기업을 식별하고 주가의 급격한 하락을 추적하여 잠재적인 단기 기회나 위험에 대한 통찰을 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

Top Decliners List: 주요 거래소에서 가격 하락폭이 가장 큰 주식의 실시간 목록에 접근합니다.
Real-Time Price Changes: 각 주식의 현재 가격 데이터, 총 가격 변동, 그리고 하락률을 추적합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 거래소별 주식 하락 상위 종목을 확인합니다.
Company Information: 기업 이름, 심볼, 거래소 등 핵심 정보를 확인합니다.

이 API는 잠재적인 트레이딩 또는 투자 전략 수립을 위해 주식 시장의 주요 하락 움직임을 추적하려는 트레이더, 애널리스트, 투자자에게 이상적입니다.

Example Use Case
한 트레이더가 주식 하락폭 상위 API를 활용해 NASDAQ에서 빠르게 하락하는 주식을 식별합니다. iSun, Inc. (ISUN)에서 31.33%의 급락을 발견한 후, 트레이더는 해당 주식을 공매도할지, 또는 반등을 노린 매수 전략을 검토할지 판단할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/biggest-losers
```

**Sample Response:**

```json
[
	{
		"symbol": "IDEX",
		"price": 0.0021,
		"name": "Ideanomics, Inc.",
		"change": -0.0029,
		"changesPercentage": -58,
		"exchange": "NASDAQ"
	}
]
```

---

### 53. Cash Flow Statement API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cashflow-statement

**Summary:**

현금흐름표 API를 활용하여 기업의 현금흐름 활동에 대한 인사이트를 얻으세요. 영업, 투자, 재무 활동에서 창출·사용된 현금을 분석하여 사업의 재무 건전성과 지속 가능성을 평가하세요.

**About:**

현금흐름표 API는 기업의 현금흐름에 대한 상세한 뷰를 제공하여, 투자자와 애널리스트가 기업이 현금을 어떻게 창출하고 소비하는지 이해하는 데 필수적인 데이터를 제공합니다. 이 API는 다음에 활용됩니다:

Assessing Financial Health: 기업의 핵심 영업 활동을 통한 현금 창출 능력과 투자·재무 활동에 대한 의존도를 평가합니다.
Understanding Cash Management: 영업, 투자, 재무 활동에서의 현금 유입·유출을 추적하여 기업이 현금 자원을 얼마나 잘 관리하는지 파악합니다.
Free Cash Flow Analysis: 잉여현금흐름을 분석하여 자본적 지출 후 기업에 남은 현금을 파악함으로써 재무 유연성을 보다 명확하게 확인합니다.

이 API는 실시간 및 과거 현금흐름 데이터를 제공하여, 기업의 현금 관리 방식을 종합적으로 파악할 수 있게 해주며, 이는 투자 결정, 재무 모델링, 신용 분석에 필수적입니다.

Example Use Case
한 재무 애널리스트가 현금흐름표 API를 활용하여 기업의 영업 현금흐름과 잉여현금흐름을 평가하고, 해당 기업이 운영을 유지하고 성장에 투자하며 주주에게 가치를 환원할 수 있는지를 판단합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"date": "2024-09-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2024-11-01",
		"acceptedDate": "2024-11-01 06:01:36",
		"fiscalYear": "2024",
		"period": "FY",
		"netIncome": 93736000000,
		"depreciationAndAmortization": 11445000000,
		"deferredIncomeTax": 0,
		"stockBasedCompensation": 11688000000,
		"changeInWorkingCapital": 3651000000,
		"accountsReceivables": -5144000000,
		"inventory": -1046000000,
		"accountsPayables": 6020000000,
		"otherWorkingCapital": 3821000000,
		"otherNonCashItems": -2266000000,
		"netCashProvidedByOperatingActivities": 118254000000,
		"investmentsInPropertyPlantAndEquipment": -9447000000,
		"acquisitionsNet": 0,
		"purchasesOfInvestments": -48656000000,
		"salesMaturitiesOfInvestments": 62346000000,
		"otherInvestingActivities": -1308000000,
		"netCashProvidedByInvestingActivities": 2935000000,
		"netDebtIssuance": -5998000000,
		"longTermNetDebtIssuance": -9958000000,
		"shortTermNetDebtIssuance": 3960000000,
		"netStockIssuance": -94949000000,
		"netCommonStockIssuance": -94949000000,
		"commonStockIssuance": 0,
		"commonStockRepurchased": -94949000000,
		"netPreferredStockIssuance": 0,
		"netDividendsPaid": -15234000000,
		"commonDividendsPaid": -15234000000,
		"preferredDividendsPaid": 0,
		"otherFinancingActivities": -5802000000,
		"netCashProvidedByFinancingActivities": -121983000000,
		"effectOfForexChangesOnCash": 0,
		"netChangeInCash": -794000000,
		"cashAtEndOfPeriod": 29943000000,
```

---

### 54. Cash Flow Statement Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cash-flow-statement-bulk

**Summary:**

현금흐름표 대량 조회 API는 다양한 기업의 상세한 현금흐름 보고서에 접근할 수 있게 해줍니다. 이 API를 통해 사용자는 대량의 현금흐름표 데이터를 조회하여 기업의 영업, 투자, 재무 활동을 시간에 따라 분석할 수 있습니다.

**About:**

이 API는 다음에 필수적입니다:

Tracking Cash Movements: 기업이 영업, 투자, 재무 활동에서 현금을 어떻게 창출하고 사용하는지 파악합니다.
Free Cash Flow Analysis: 자본적 지출을 고려한 후 기업의 현금 창출 능력을 평가하기 위해 잉여현금흐름을 분석합니다.
Comparative Analysis: 여러 기업의 데이터를 한 번에 접근하여 현금흐름 추세를 비교하고, 현금 관리가 강한 기업과 약한 기업을 식별합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"date": "2025-03-31",
		"symbol": "000001.SZ",
		"reportedCurrency": "CNY",
		"cik": "0000000000",
		"filingDate": "2025-03-31",
		"acceptedDate": "2025-03-31 00:00:00",
		"fiscalYear": "2025",
		"period": "Q1",
		"netIncome": "0",
		"depreciationAndAmortization": "0",
		"deferredIncomeTax": "0",
		"stockBasedCompensation": "0",
		"changeInWorkingCapital": "0",
		"accountsReceivables": "0",
		"inventory": "0",
		"accountsPayables": "0",
		"otherWorkingCapital": "0",
		"otherNonCashItems": "162946000000",
		"netCashProvidedByOperatingActivities": "162946000000",
		"investmentsInPropertyPlantAndEquipment": "-338000000",
		"acquisitionsNet": "0",
		"purchasesOfInvestments": "-227916000000",
		"salesMaturitiesOfInvestments": "253172000000",
		"otherInvestingActivities": "25000000",
		"netCashProvidedByInvestingActivities": "24943000000",
		"netDebtIssuance": "0",
		"longTermNetDebtIssuance": "0",
		"shortTermNetDebtIssuance": "0",
		"netStockIssuance": "0",
		"netCommonStockIssuance": "0",
		"commonStockIssuance": "0",
		"commonStockRepurchased": "0",
		"netPreferredStockIssuance": "0",
		"netDividendsPaid": "-2538000000",
		"commonDividendsPaid": "-2538000000",
		"preferredDividendsPaid": "0",
		"otherFinancingActivities": "-155860000000",
		"netCashProvidedByFinancingActivities": "-158398000000",
		"effectOfForexChangesOnCash": "-130000000",
		"netChangeInCash": "29361000000",
		"cashAtEndOfPeriod": "286307000000",
		"cashAtBeginningOfPeriod": "256946000000",
		"operatin
```

---

### 55. Cash Flow Statement Growth Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cash-flow-statement-growth-bulk

**Summary:**

현금흐름표 성장률 대량 조회 API를 사용하면 현금흐름표의 대량 성장 데이터를 조회하여 시간에 따른 현금흐름 변화를 추적할 수 있습니다. 이 API는 여러 기업의 현금흐름 성장 추세를 동시에 분석하는 데 이상적입니다.

**About:**

이 API는 다음을 지원합니다:

Track Growth Trends: 영업 현금흐름, 자본적 지출, 잉여현금흐름 등 주요 현금흐름 지표의 변화를 시간에 따라 모니터링합니다.
Compare Company Performance: 여러 기업의 현금흐름 활동 성장률을 빠르게 분석하여 고성장 기업이나 현금흐름이 감소하는 기업을 쉽게 식별합니다.
Understand Financial Health: 기업이 영업 개선, 또는 투자·재무 활동의 변화를 통해 현금흐름을 어떻게 관리하고 있는지 평가합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement-growth-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"date": "2025-03-31",
		"fiscalYear": "2025",
		"period": "Q1",
		"reportedCurrency": "CNY",
		"growthNetIncome": "0",
		"growthDepreciationAndAmortization": "0",
		"growthDeferredIncomeTax": "0",
		"growthStockBasedCompensation": "0",
		"growthChangeInWorkingCapital": "0",
		"growthAccountsReceivables": "0",
		"growthInventory": "0",
		"growthAccountsPayables": "0",
		"growthOtherWorkingCapital": "0",
		"growthOtherNonCashItems": "3.2072823819457614",
		"growthNetCashProvidedByOperatingActivites": "3.2072823819457614",
		"growthInvestmentsInPropertyPlantAndEquipment": "0.7332280978689818",
		"growthAcquisitionsNet": "0",
		"growthPurchasesOfInvestments": "-0.12254537395030414",
		"growthSalesMaturitiesOfInvestments": "0.3847853673478318",
		"growthOtherInvestingActivites": "-0.8417721518987342",
		"growthNetCashUsedForInvestingActivites": "2.1699343339587243",
		"growthDebtRepayment": "1",
		"growthCommonStockIssued": "0",
		"growthCommonStockRepurchased": "0",
		"growthDividendsPaid": "0.6798284344644885",
		"growthOtherFinancingActivites": "-1.7077146619443309",
		"growthNetCashUsedProvidedByFinancingActivities": "-3.2122934677858628",
		"growthEffectOfForexChangesOnCash": "-1.0731570061902083",
		"growthNetChangeInCash": "2.348938711752274",
		"growthCashAtEndOfPeriod": "0.11426914604625096",
		"growthCashAtBeginningOfPeriod": "-0.07809495106059301",
		"growthOperatingCashFlow": "3.2072823819457614",
		"growthCapitalExpenditure": "0.7332280
```

---


### 56. Cashflow Statement Growth API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cashflow-statement-growth

**Summary:**

FMP 현금흐름표 성장 API를 사용하여 기업의 현금흐름 성장률을 측정하세요. 시간이 지남에 따라 기업의 현금흐름이 얼마나 빠르게 증가하거나 감소하는지 파악할 수 있습니다.

**About:**

FMP 현금흐름표 성장 API는 기업의 재무 건전성을 평가하는 데 필수적인 지표인 현금흐름 성장률에 대한 핵심 인사이트를 제공합니다. 이 API는 다음 목적에 매우 유용합니다:

Financial Performance Evaluation: 기업의 현금흐름이 성장하는 속도를 분석합니다. 양의 성장률은 기업이 사용하는 것보다 더 많은 현금을 창출하고 있음을 나타내며, 이는 강한 재무 건전성과 운영 효율성의 신호일 수 있습니다.

Investment Decision-Making: 현금흐름 성장 데이터를 활용하여 강력한 현금 창출 능력을 보유한 기업을 식별합니다. 지속적으로 양의 현금흐름 성장을 보이는 기업은 일반적으로 더 안정적이며 좋은 투자 기회를 나타낼 수 있습니다.

Risk Assessment: 음의 현금흐름 성장률은 기업이 창출하는 것보다 더 많은 현금을 사용하고 있음을 나타내는 위험 신호일 수 있습니다. 이 정보는 기업 주식에 투자하거나 보유를 지속하는 것과 관련된 위험을 평가하는 데 활용할 수 있습니다.

Example Use Case: 투자자 분석 — 투자자는 현금흐름 성장 API를 사용하여 제조 기업의 재무 건전성을 평가할 수 있습니다. 지난 5년간의 현금흐름 성장을 살펴보고, 기업이 지속적으로 양의 성장을 보인다면 해당 기업에 대한 투자를 늘리기로 결정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement-growth?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"growthNetIncome": -0.033599670086086914,
		"growthDepreciationAndAmortization": -0.006424168764649709,
		"growthDeferredIncomeTax": 0,
		"growthStockBasedCompensation": 0.07892550540016616,
		"growthChangeInWorkingCapital": 1.555116314429071,
		"growthAccountsReceivables": -2.0473933649289098,
		"growthInventory": 0.3535228677379481,
		"growthAccountsPayables": 4.1868713605082055,
		"growthOtherWorkingCapital": 2.4402563136072373,
		"growthOtherNonCashItems": -0.017512348450830714,
		"growthNetCashProvidedByOperatingActivites": 0.06975566069312394,
		"growthInvestmentsInPropertyPlantAndEquipment": 0.13796879277306323,
		"growthAcquisitionsNet": 0,
		"growthPurchasesOfInvestments": -0.6486294175448107,
		"growthSalesMaturitiesOfInvestments": 0.3698202750801951,
		"growthOtherInvestingActivites": 0.02169035153328347,
		"growthNetCashUsedForInvestingActivites": -0.2078272604588394,
		"growthDebtRepayment": -0.012662502110417018,
		"growthCommonStockIssued": 0,
		"growthCommonStockRepurchased": -0.2243584784010316,
		"growthDividendsPaid": -0.013910149750415973,
		"growthOtherFinancingActivites": 0.03493013972055888,
		"growthNetCashUsedProvidedByFinancingActivities": -0.12439163778482412,
		"growthEffectOfForexChangesOnCash": 0,
		"growthNetChangeInCash": -1.1378472222222222,
		"growthCashAtEndOfPeriod": -0.02583205908188828,
		"growthCashAtBeginningOfPeriod
```

---

### 57. Cashflow Statements TTM API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cashflow-statements-ttm

**About:**

TTM(Trailing Twelve Months, 최근 12개월) 기준의 현금흐름표 데이터를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cash-flow-statement-ttm?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |

**Sample Response:**

```json
[
	{
		"date": "2024-12-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2025-01-31",
		"acceptedDate": "2025-01-31 06:01:27",
		"fiscalYear": "2025",
		"period": "Q1",
		"netIncome": 96150000000,
		"depreciationAndAmortization": 11677000000,
		"deferredIncomeTax": 0,
		"stockBasedCompensation": 11977000000,
		"changeInWorkingCapital": -8224000000,
		"accountsReceivables": -9505000000,
		"inventory": -694000000,
		"accountsPayables": 3891000000,
		"otherWorkingCapital": -1916000000,
		"otherNonCashItems": -3286000000,
		"netCashProvidedByOperatingActivities": 108294000000,
		"investmentsInPropertyPlantAndEquipment": -9995000000,
		"acquisitionsNet": 0,
		"purchasesOfInvestments": -45000000000,
		"salesMaturitiesOfInvestments": 67422000000,
		"otherInvestingActivities": -1627000000,
		"netCashProvidedByInvestingActivities": 10800000000,
		"netDebtIssuance": -10967000000,
		"longTermNetDebtIssuance": -10967000000,
		"shortTermNetDebtIssuance": 0,
		"netStockIssuance": -98416000000,
		"netCommonStockIssuance": -98416000000,
		"commonStockIssuance": 0,
		"commonStockRepurchased": -98416000000,
		"netPreferredStockIssuance": 0,
		"netDividendsPaid": -15265000000,
		"commonDividendsPaid": -15265000000,
		"preferredDividendsPaid": 0,
		"otherFinancingActivities": -6121000000,
		"netCashProvidedByFinancingActivities": -130769000000,
		"effectOfForexChangesOnCash": 0,
		"netChangeInCash": -11675000000,
		"cashAtEndOfPeriod": 30299000000,
		
```

---

### 58. CIK List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cik-list

**Summary:**

FMP CIK 목록 API를 통해 SEC에 등록된 기관의 CIK(Central Index Key) 번호를 포함한 종합 데이터베이스에 접근하세요. 이 엔드포인트는 규정 준수, 금융 거래, 투자 조사를 위해 CIK 번호에 빠르게 접근해야 하는 기업, 금융 전문가, 개인에게 필수적인 도구입니다.

**About:**

FMP CIK 목록 API는 SEC에 등록된 기관에 할당된 CIK 번호의 방대하고 검색 가능한 데이터베이스를 제공합니다. CIK 번호는 많은 규제 신고 및 금융 거래에 필요한 고유 식별자로, 다음과 같은 목적에 매우 중요합니다:

Investment Research: CIK와 연결된 13F 신고서를 통해 기관 투자 패턴에 대한 인사이트를 얻어 주식 보유 현황과 시장 심리를 파악합니다.

Regulatory Compliance: CIK 번호를 손쉽게 조회하여 SEC 규정 및 보고 요건을 준수합니다.

Portfolio Management: 주요 기관 투자자의 CIK 번호를 추적하여 포트폴리오 관리 및 시장 분석 역량을 강화합니다.

이 API는 투자 분석가, 포트폴리오 매니저, 컴플라이언스 담당자를 포함한 금융 업계 종사자 누구에게나 소중한 자원으로, 많은 SEC 신고서의 기반이 되는 CIK 번호에 대한 접근을 제공합니다.

Example Use Case: 포트폴리오 매니저는 CIK 목록 API를 사용하여 최근 13F 신고서에서 기관 투자자의 CIK 번호를 조회하고, 해당 투자자의 주식 보유 현황을 분석하여 포트폴리오 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cik-list?page=0&limit=1000
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 1000 |

**Sample Response:**

```json
[
	{
		"cik": "0002036063",
		"companyName": "LUZ Capital Partners, LLC"
	}
]
```

---

### 59. Commodities List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-list

**Summary:**

에너지, 금속, 농산물 등 다양한 섹터에 걸쳐 추적되는 광범위한 상품 목록에 접근하세요. FMP 상품 목록 API는 거래 가능한 상품에 대한 필수 데이터를 제공하여 투자자가 시장 옵션을 탐색할 수 있도록 합니다.

**About:**

FMP 상품 목록 API는 거래 가능한 상품의 상세 목록에 접근할 수 있는 기능을 제공합니다. 에너지 선물, 귀금속, 농산물 등을 추적하는 경우, 이 API는 심볼, 거래 월, 관련 통화를 포함한 종합적인 데이터를 제공합니다. 주요 기능은 다음과 같습니다:

Wide Commodity Coverage: 에너지(원유, 천연가스), 금속(금, 은), 농업(옥수수, 밀) 등 다양한 섹터에 걸친 모든 이용 가능한 상품을 조회합니다. 이 다양한 커버리지를 통해 다양한 시장을 쉽게 찾고 분석할 수 있습니다.

Market Insights: 거래 월 및 통화 데이터를 통해 투자자와 분석가가 글로벌 시장 트렌드와 상품 섹터 내 가격 구조를 더 잘 이해할 수 있습니다.

Data: 상품에 대한 최신 정보를 지속적으로 업데이트하여 시기적절하고 정보에 기반한 투자 결정을 내릴 수 있습니다.

Example Use Case: 예를 들어, 사용자는 "30 Day Fed Fund Futures" 상품에 대한 정보(심볼, 거래 월, 관련 통화 등)를 조회하여 거래 및 헤징 목적으로 특정 상품을 추적할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/commodities-list
```

**Sample Response:**

```json
[
	{
		"symbol": "HEUSX",
		"name": "Lean Hogs Futures",
		"exchange": null,
		"tradeMonth": "Dec",
		"currency": "USX"
	}
]
```

---

### 60. Commodities Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-quote

**Summary:**

FMP 글로벌 상품 API를 통해 전 세계에서 거래되는 모든 상품의 가격 호가에 접근하세요. 종합적인 가격 데이터로 시장 움직임을 추적하고 투자 기회를 발굴하세요.

**About:**

FMP 글로벌 상품 API는 전 세계 거래소에서 거래되는 모든 상품의 가격 호가 전체 목록을 제공합니다. 이 API는 다음을 원하는 투자자와 트레이더에게 필수적인 도구입니다:

Commodity Prices: 현재 가격, 고가, 저가, 시가 등 상품 가격 호가에 접근합니다.

Track Market Movements: 시간에 따른 상품 가격 변동을 추적하여 트렌드를 포착하고 정보에 기반한 결정을 내립니다.

Identify Investment Opportunities: 상세한 상품 가격 데이터를 활용하여 글로벌 시장에서의 잠재적 투자 기회를 발굴합니다.

이 상품 API는 글로벌 가격에 대한 전체적인 뷰를 제공하여 사용자가 시장 상황을 파악하고 데이터 기반의 투자 결정을 내릴 수 있도록 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |

**Sample Response:**

```json
[
	{
		"symbol": "GCUSD",
		"name": "Gold Futures",
		"price": 3375.3,
		"changePercentage": -0.65635,
		"change": -22.3,
		"volume": 170936,
		"dayLow": 3355.2,
		"dayHigh": 3401.1,
		"yearHigh": 3509.9,
		"yearLow": 2354.6,
		"marketCap": null,
		"priceAvg50": 3358.706,
		"priceAvg200": 3054.501,
		"exchange": "COMMODITY",
		"open": 3398.6,
		"previousClose": 3397.6,
		"timestamp": 1753372205
	}
]
```

---


### 61. Commodities Quote Short API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-quote-short

**Summary:**

FMP 원자재 빠른 시세 API를 통해 원자재에 대한 빠르고 정확한 시세를 확인하세요. 다양한 원자재의 현재 가격, 최근 변동, 거래량에 즉시 접근할 수 있습니다.

**About:**

FMP 원자재 빠른 시세 API는 원자재의 핵심 정보를 간결하고 효율적으로 조회하는 방법을 제공합니다. 최신 가격, 최근 시장 변동, 거래량 등 어떤 정보를 찾든, 이 API는 빠른 분석과 의사결정에 필요한 핵심 데이터를 제공합니다.

Instant Price Updates: 다양한 원자재의 가격 데이터를 수신하여 항상 최신 시장 상황을 파악하세요.
Market Change Tracking: 가격 변동을 지속적으로 모니터링하여 시장 움직임에 신속하게 대응하세요.
Volume Insights: 최신 거래량 데이터에 접근하여 시장 활동 수준과 유동성을 파악하세요.

이 API는 복잡한 심층 보고서 없이 핵심 시장 데이터에 빠르게 접근해야 하는 투자자, 트레이더, 금융 분석가에게 이상적입니다.
예시: 이 API를 사용하면 금(심볼: GCUSD)의 현재 가격을 즉시 조회하고, 가격 변동(-7.2)을 확인하며, 거래량(69,930)을 추적하여 시장 성과를 한눈에 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote-short?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |

**Sample Response:**

```json
[
	{
		"symbol": "GCUSD",
		"price": 3375.3,
		"change": -22.3,
		"volume": 170936
	}
]
```

---

### 62. Company Employee Count API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/employee-count

**Summary:**

직원 수, 보고 기간, 제출 날짜 등 기업의 인력 정보를 상세히 조회하세요. FMP 기업 직원 수 API는 추가 검증 및 심층 조사를 위한 공식 SEC 문서 직접 링크도 제공합니다.

**About:**

FMP 기업 직원 수 API는 기업의 인력 규모에 관한 핵심 데이터에 접근할 수 있게 해줍니다. 이 API는 기업 운영, 인력 채용 동향, 인력 관리를 파악해야 하는 애널리스트, 투자자, HR 전문가에게 특히 유용합니다. 주요 기능은 다음과 같습니다:

Employee Count: 가장 최근 공시 데이터를 기반으로 기업의 총 직원 수를 손쉽게 조회하세요.
Period of Report: 보고 기간에 접근하여 직원 수가 보고된 시점의 기간을 파악하세요.
Filing Date and Form Type: 공시 날짜 및 문서 유형(예: 10-K)을 확인하여 인력 데이터가 언제, 어디서 공개되었는지 파악하세요.
Direct SEC Links: 투명성 확보 및 추가 세부 정보를 위해 공식 SEC 원본 문서에 접근하세요.

이 API는 기업 규모, 생산성, 인력 동향을 분석하는 분들에게 이상적이며, 직원 수를 통해 기업 운영 현황을 명확하게 파악할 수 있습니다.

Example Use Case
주식 애널리스트는 기업 직원 수 API를 사용하여 Apple Inc.의 연도별 인력 성장을 평가하고, 이를 회사의 매출 및 수익성 변화와 비교할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/employee-count?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"acceptanceTime": "2025-10-31 06:01:26",
		"periodOfReport": "2025-09-27",
		"companyName": "Apple Inc.",
		"formType": "10-K",
		"filingDate": "2025-10-31",
		"employeeCount": 166000,
		"source": "https://www.sec.gov/Archives/edgar/data/320193/000032019325000079/0000320193-25-000079-index.htm"
	}
]
```

---

### 63. Company Executives API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/company-executives

**Summary:**

FMP 기업 임원 API를 통해 기업 임원에 대한 상세 정보를 조회하세요. 이 API는 임원의 이름, 직책, 보수, 성별 및 출생 연도 등의 인구통계학적 정보를 포함한 핵심 데이터를 제공합니다.

**About:**

FMP 기업 임원 API는 기업의 리더십 팀에 대한 종합적인 정보를 제공하며, 기업의 구조와 리더십을 평가해야 하는 투자자, 연구자, 애널리스트에게 이상적입니다. 이 API는 다음과 같은 용도로 활용할 수 있습니다:

Executive Profiles: 임원 이름, 기업 내 역할, 보수 데이터 등 세부 정보에 접근하세요.
Demographic Data: 성별 및 출생 연도 등 추가적인 인구통계학적 인사이트를 확인하세요.
Compensation Analysis: 임원 보수를 분석하세요. 이는 기업의 우선순위와 리더십 가치를 나타내는 핵심 지표가 될 수 있습니다.

이 API는 기업 리더십에 대한 명확한 개요를 제공하여, 누가 경영을 담당하고 있으며 그들이 얼마나 보상받고 있는지를 파악하는 데 도움을 줍니다.

Example Use Case
대규모 투자를 결정하기 전에 기업의 리더십을 평가하려는 투자자는 기업 임원 API를 사용하여 최고 경영진의 배경과 보수를 검토함으로써, 리더십이 기업 성과에 미칠 영향을 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/key-executives?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"title": "Senior Vice President of Worldwide Marketing",
		"name": "Greg Joswiak",
		"pay": null,
		"currencyPay": "USD",
		"gender": "male",
		"yearBorn": null,
		"titleSince": null,
		"active": true
	}
]
```

---

### 64. Company Historical Employee Count API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-employee-count

**Summary:**

특정 보고 기간을 기준으로 기업의 과거 직원 수 데이터에 접근하세요. FMP 기업 과거 직원 수 API는 시간 경과에 따른 기업 인력 변화를 파악할 수 있는 인사이트를 제공하여, 성장 추세 및 운영 변화를 분석할 수 있게 합니다.

**About:**

FMP 기업 과거 직원 수 API는 다양한 보고 기간에 걸쳐 기업의 인력 동향을 추적해야 하는 사용자를 위해 설계되었습니다. 이 데이터는 장기적인 성장, 인력 변화, 인력 규모와 재무 성과 간의 관계를 분석하는 데 특히 유용합니다. 주요 기능은 다음과 같습니다:

Historical Employee Count: 여러 기간의 인력 규모를 조회하여 성장 또는 감소 추세를 분석하세요.
Report Periods: 연간 또는 분기별 재무 보고서와 연계된 직원 데이터의 특정 기간에 대한 인사이트를 얻으세요.
Filing Date and Form Type: 직원 데이터가 보고된 시점과 해당 SEC 양식 유형(예: 10-K)을 파악하세요.
Direct SEC Links: 심층 조사 및 투명성 확보를 위해 원본 SEC 공시 문서에 접근하세요.

이 API는 인력 변화를 추적하고 기업 운영에 미치는 영향을 평가하려는 HR 애널리스트, 투자자, 비즈니스 전략가에게 이상적입니다.

Example Use Case
재무 애널리스트는 기업 과거 직원 수 API를 사용하여 Apple Inc.의 5년간 직원 수를 비교함으로써, 인력 변화가 매출 성장 및 시장 확장과 어떻게 상관관계를 갖는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-employee-count?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"acceptanceTime": "2025-10-31 06:01:26",
		"periodOfReport": "2025-09-27",
		"companyName": "Apple Inc.",
		"formType": "10-K",
		"filingDate": "2025-10-31",
		"employeeCount": 166000,
		"source": "https://www.sec.gov/Archives/edgar/data/320193/000032019325000079/0000320193-25-000079-index.htm"
	}
]
```

---

### 65. Company Market Cap API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/market-cap

**Summary:**

FMP 기업 시가총액 API를 사용하여 특정 날짜의 기업 시가총액을 조회하세요. 이 API는 주식 시장에서 기업의 규모와 가치를 평가하는 데 필요한 핵심 데이터를 제공하여, 기업의 전반적인 시장 위치를 파악할 수 있게 합니다.

**About:**

FMP 기업 시가총액 API는 선택한 날짜의 기업 시가총액에 대한 정확한 데이터를 제공하며, 투자자, 애널리스트, 금융 전문가에게 없어서는 안 될 도구입니다. 주요 기능은 다음과 같습니다:

Market Capitalization on Specific Dates: 기업의 정확한 시가총액 데이터를 조회하여 시간 경과에 따른 변화를 추적하세요.
Company Valuation Analysis: 시가총액을 기반으로 주식 시장 내 기업의 규모와 가치를 분석하세요.
Historical and Real-Time Capabilities: 더 나은 의사결정을 위해 과거 및 실시간 시가총액 데이터 모두에 접근하세요.

이 API는 기업 규모를 빠르게 평가하고 시장 내 위치를 측정해야 하는 투자자, 포트폴리오 매니저, 애널리스트에게 이상적입니다.

Example Use Case
Apple Inc.의 시장 성과를 추적하는 투자자는 기업 시가총액 API를 사용하여 특정 날짜의 시가총액을 조회함으로써, Apple의 가치 평가 추세를 파악하고 경쟁사와 비교할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/market-capitalization?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-10-24",
		"marketCap": 3900351299800
	}
]
```

---


### 66. Company Name Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-name

**Summary:**

FMP Name Search API를 사용하여 다양한 거래소에 상장된 주식 증권 및 ETF의 티커 심볼, 회사명, 거래소 정보를 검색하세요. 이 엔드포인트는 회사명이나 자산명의 전체 또는 일부는 알지만 심볼 식별자를 모를 때 티커 심볼을 조회하는 데 유용합니다.

**About:**

FMP Name Search API는 회사 및 ETF의 티커 심볼과 거래소 정보를 손쉽게 찾을 수 있는 방법을 제공합니다. 회사명이나 자산명은 알지만 심볼 식별자를 모를 때 티커 심볼을 조회하는 데 유용한 엔드포인트입니다.

Key Features of the Name Search API

Simple Company Name Lookup: 회사명이나 자산명을 입력하면 해당 티커 심볼, 회사명, 거래소 정보를 조회할 수 있습니다.
Equity Securities and ETFs: 주요 거래소에 상장된 다양한 주식 증권 및 상장지수펀드(ETF) 검색을 지원합니다.
Accurate and Up-to-Date Data: 실시간으로 정확한 검색 결과를 제공하여 항상 최신 정보로 작업할 수 있습니다.

How Investors and Analysts Can Benefit

Quick Symbol Lookup: 회사명은 알지만 심볼을 모를 때 티커 심볼을 빠르게 조회할 수 있습니다.
Broad Market Coverage: 국내외 여러 거래소에 걸쳐 검색하여 다양한 시장 정보를 파악할 수 있습니다.
Streamlined Workflow: 올바른 심볼을 신속하게 파악하여 분석이나 매매 실행을 위한 리서치 및 투자 의사결정을 향상시킵니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-name?query=AA
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| query* | string | AA |
| limit | number | 50 |
| exchange | string | NASDAQ |

**Sample Response:**

```json
[
	{
		"symbol": "AAGUSD",
		"name": "AAG USD",
		"currency": "USD",
		"exchangeFullName": "CCC",
		"exchange": "CRYPTO"
	}
]
```

---

### 67. Company Notes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/company-notes

**Summary:**

FMP Company Notes API를 사용하여 기업 발행 노트에 대한 상세 정보를 조회하세요. CIK 번호, 주식 심볼, 노트 제목, 노트가 상장된 거래소 등 핵심 데이터에 접근할 수 있습니다.

**About:**

FMP Company Notes API는 상장 기업이 발행한 노트에 대한 중요한 정보를 제공합니다. 이 API는 기업 부채 상품을 추적하는 투자자, 애널리스트, 금융 전문가에게 특히 유용합니다. 주요 기능은 다음과 같습니다:

CIK and Stock Symbol Lookup: 기업의 중앙 인덱스 키(CIK) 및 주식 심볼로 노트를 식별합니다.
Note Title and Terms: 이자율, 만기일 등 구체적인 조건을 포함한 기업 발행 노트의 상세 제목을 확인할 수 있습니다.
Exchange Information: 해당 노트가 거래되는 거래소(NASDAQ, NYSE 등)를 파악하여 시장 활동을 추적할 수 있습니다.

Company Notes API는 기업 부채 상품을 모니터링하고 기업의 재무적 약정을 이해하는 데 필수적인 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/company-notes?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"cik": "0000320193",
		"symbol": "AAPL",
		"title": "0.000% Notes due 2025",
		"exchange": "NASDAQ"
	}
]
```

---

### 68. Company Profile Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/profile-bulk

**Summary:**

FMP Profile Bulk API를 사용하면 여러 회사의 종합적인 프로필 데이터를 한 번에 조회할 수 있습니다. 단일 요청으로 회사 세부정보, 주가, 시가총액, 섹터, 업종 등 필수 정보에 접근하세요.

**About:**

FMP Profile Bulk API는 글로벌 주식 거래소에 상장된 기업들의 상세 프로필을 제공합니다. 이 API는 다음이 필요한 사용자에게 이상적입니다:

Retrieve Comprehensive Data: 주가, 시가총액, 업종 분류 등을 포함한 회사 프로필 데이터에 접근합니다.
Bulk Data Requests: 하나의 API 호출로 여러 기업의 회사 세부정보를 조회하여 데이터 수집 효율을 높입니다.
Analyze Company Information: 이 데이터를 활용하여 회사 운영, 경영진, 재무 현황, 업종 섹터에 대한 인사이트를 얻습니다.

이 API는 다양한 조직의 광범위한 회사 프로필 데이터가 필요한 금융 애널리스트, 데이터 과학자 및 관련 전문가에게 매우 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/profile-bulk?part=0
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| part* | string | 0 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 271.36,
		"marketCap": 4009711150080,
		"beta": 1.107,
		"lastDividend": 1.03,
		"range": "169.21-288.62",
		"change": -0.83,
		"changePercentage": -0.30493,
		"volume": 44494594,
		"averageVolume": 48811139,
		"companyName": "Apple Inc.",
		"currency": "USD",
		"cik": "0000320193",
		"isin": "US0378331005",
		"cusip": "037833100",
		"exchangeFullName": "NASDAQ Global Select",
		"exchange": "NASDAQ",
		"industry": "Consumer Electronics",
		"website": "https://www.apple.com",
		"description": "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. The company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, and HomePod. It also provides AppleCare support and cloud services; and operates various platforms, including the App Store that allow customers to discover and download applications and digital content, such as books, music, video, games, and podcasts, as well as advertising services include third-party licensing arrangements and its own advertising platforms. In addition, the company offers various subscription-based services, such as Apple Arcade, a game subscription service; Apple Fitness+, a personalized fitness service; Apple Music, which offers users a curated listening experience with on-demand radio stat
```

---

### 69. Company Profile by CIK API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/profile-cik

**Summary:**

FMP Company Profile by CIK API를 사용하여 CIK(중앙 인덱스 키)로 상세 회사 프로필 데이터를 조회하세요. 고유한 CIK 식별자를 통해 회사를 검색하고 주가, 시가총액, 업종 등 전체 회사 데이터에 접근할 수 있습니다.

**About:**

FMP Company Profile by CIK API는 CIK 코드를 사용하여 기업을 조회하려는 사용자에게 포괄적인 회사 정보를 제공합니다. 컴플라이언스 담당자, 애널리스트, 투자자에게 이상적이며, CIK 번호를 기반으로 핵심 회사 세부정보에 접근할 수 있습니다. 주요 기능은 다음과 같습니다:

Company Lookup by CIK: 중앙 인덱스 키를 사용하여 빠르고 정확하게 기업을 조회합니다.
Stock Price & Market Cap: 요청한 기업의 최신 주가와 시가총액 데이터를 확인합니다.
Comprehensive Financial Data: 기업 성과 평가를 위해 베타, 배당 수익률, 거래 범위 등 필수 재무 지표에 접근합니다.
Global Identifiers: CIK, ISIN, CUSIP 등 주요 식별자를 조회하여 플랫폼 간 기업 추적을 간소화합니다.
Company Information: 기업의 사업 운영, CEO, 섹터, 연락처 정보 등 심층 세부정보를 확인합니다.
IPO & Industry Data: 기업의 업종, 섹터, IPO 정보를 조회하여 시장 포지션을 더 잘 이해합니다.

Example Use Case
규제 검토를 수행하는 컴플라이언스 담당자는 Company Profile by CIK API를 사용하여 Apple Inc.의 고유 CIK 번호로 종합적인 데이터를 신속하게 조회함으로써 여러 데이터베이스 간 교차 참조의 정확성을 보장할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/profile-cik?cik=320193
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 320193 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 262.82,
		"marketCap": 3900351299800,
		"beta": 1.109,
		"lastDividend": 1.04,
		"range": "169.21-265.29",
		"change": 3.24,
		"changePercentage": 1.24817,
		"volume": 36725325,
		"averageVolume": 47424558,
		"companyName": "Apple Inc.",
		"currency": "USD",
		"cik": "0000320193",
		"isin": "US0378331005",
		"cusip": "037833100",
		"exchangeFullName": "NASDAQ Global Select",
		"exchange": "NASDAQ",
		"industry": "Consumer Electronics",
		"website": "https://www.apple.com",
		"description": "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. The company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, and HomePod. It also provides AppleCare support and cloud services; and operates various platforms, including the App Store that allow customers to discov...",
		"ceo": "Timothy D. Cook",
		"sector": "Technology",
		"country": "US",
		"fullTimeEmployees": "164000",
		"phone": "(408) 996-1010",
		"address": "One Apple Park Way",
		"city": "Cupertino",
		"state": "CA",
		"zip": "95014",
		"image": "https://images.financialmodelingprep.com/symbol/AAPL.png",
		"ipoDate": "1980-12-12",
		"defaultImage": false,
		"isEtf": false,
		"isActivelyTrading": true,
		"isAdr": false,
		"isFund": false
	}
]
```

---

### 70. Company Profile Data API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/profile-symbol

**Summary:**

FMP Company Profile Data API를 사용하여 상세한 회사 프로필 데이터에 접근하세요. 특정 주식 심볼에 대한 시가총액, 주가, 업종 등 핵심 재무 및 운영 정보를 제공합니다.

**About:**

FMP Company Profile Data API는 기업의 재무 현황과 운영 세부정보에 대한 포괄적인 인사이트를 제공합니다. 기업의 핵심 재무 지표와 사업 정보를 심층적으로 파악해야 하는 애널리스트, 트레이더, 투자자에게 이상적입니다. 주요 기능은 다음과 같습니다:

Stock Price and Market Cap: 요청한 심볼의 최신 주가와 시가총액을 확인합니다.
Company Details: 회사명, 설명, CEO, 업종 분류 등의 정보에 접근합니다.
Financial Metrics: 배당 수익률, 주식 베타, 거래 범위 등 주요 재무 지표를 추적하여 성과와 변동성을 평가합니다.
Global Identifiers: CIK, ISIN, CUSIP 등 글로벌 금융 식별자를 조회하여 플랫폼 간 정확한 추적을 보장합니다.
Contact Information: 직접 참조를 위해 회사 주소, 전화번호, 웹사이트 등 연락처 정보를 확인합니다.
IPO Data: 회사의 IPO 날짜, 섹터, 현재 거래 활성 여부를 파악합니다.

Example Use Case
잠재적 기술주 투자를 조사하는 투자자는 Company Profile Data API를 사용하여 Apple Inc.의 현재 재무 건전성을 검토하고, 성과를 평가하며, 주가 범위와 시가총액 등 핵심 지표를 분석하여 매수 또는 매도 결정에 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/profile?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 262.82,
		"marketCap": 3900351299800,
		"beta": 1.109,
		"lastDividend": 1.04,
		"range": "169.21-265.29",
		"change": 3.24,
		"changePercentage": 1.24817,
		"volume": 36725325,
		"averageVolume": 47424558,
		"companyName": "Apple Inc.",
		"currency": "USD",
		"cik": "0000320193",
		"isin": "US0378331005",
		"cusip": "037833100",
		"exchangeFullName": "NASDAQ Global Select",
		"exchange": "NASDAQ",
		"industry": "Consumer Electronics",
		"website": "https://www.apple.com",
		"description": "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. The company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, and HomePod. It also provides AppleCare support and cloud services; and operates various platforms, including the App Store that allow customers to discov...",
		"ceo": "Timothy D. Cook",
		"sector": "Technology",
		"country": "US",
		"fullTimeEmployees": "164000",
		"phone": "(408) 996-1010",
		"address": "One Apple Park Way",
		"city": "Cupertino",
		"state": "CA",
		"zip": "95014",
		"image": "https://images.financialmodelingprep.com/symbol/AAPL.png",
		"ipoDate": "1980-12-12",
		"defaultImage": false,
		"isEtf": false,
		"isActivelyTrading": true,
		"isAdr": false,
		"isFund": false
	}
]
```

---


### 71. Company Share Float & Liquidity API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/shares-float

**Summary:**

FMP 기업 주식 유통량 및 유동성 API를 통해 주식의 유동성과 변동성을 파악하세요. 모든 기업의 공개 유통 주식 수를 조회하여 합리적인 투자 결정을 내릴 수 있습니다.

**About:**

FMP 기업 주식 유통량 및 유동성 API는 특정 기업의 공개 유통 주식 수(즉, 기업의 유통 주식)에 관한 핵심 데이터를 제공합니다. 이 엔드포인트는 투자자들에게 다음과 같은 도움을 줍니다:

Float Data: 거래 가능한 주식 수를 파악하여 해당 주식의 유동성에 직접적인 영향을 미치는 정보를 제공합니다.
변동성 평가: 기업의 유통 주식 규모가 주가 변동성에 미치는 영향을 이해할 수 있으며, 유통 주식 수가 적을수록 일반적으로 변동성이 높아집니다.
합리적인 의사 결정: 유통 주식 데이터를 활용하여 대규모 또는 소규모 유통 주식을 보유한 기업을 식별하고, 해당 기업 투자의 잠재적 위험과 수익을 평가할 수 있습니다.

예를 들어, 유통 주식 수가 많은 기업은 주식 유동성이 높고 가격 변동성이 낮은 경향이 있는 반면, 유통 주식 수가 적은 기업은 낮은 유동성으로 인해 주가 변동이 클 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/shares-float?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2026-04-07 07:43:00",
		"freeFloat": 99.77245934530808,
		"floatShares": 14664480994,
		"outstandingShares": 14697924749,
		"source": "https://www.sec.gov/Archives/edgar/data/320193/000032019326000006/aapl-20251227.htm"
	}
]
```

---

### 72. Company Symbols List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/company-symbols-list

**Summary:**

FMP 기업 심볼 목록 API를 통해 금융 심볼의 포괄적인 목록을 손쉽게 조회하세요. 전 세계 다양한 거래소에서 거래되는 광범위한 주식 심볼 및 기타 금융 상품에 접근하여 이용 가능한 모든 증권을 탐색할 수 있습니다.

**About:**

FMP 기업 심볼 목록 API는 상장 기업 및 금융 상품의 전체 심볼 목록을 빠르게 조회해야 하는 투자자, 트레이더, 금융 분석가에게 유용한 리소스입니다. 이 API는 다음과 같은 용도로 활용됩니다:

종합 심볼 조회: 주식, ETF 및 전 세계 거래소의 기타 금융 상품을 포함한 방대한 주식 심볼 데이터베이스에 접근할 수 있습니다.
다중 시장 커버리지: 전 세계 주요 증권 거래소의 다양한 심볼을 탐색하여 합리적인 거래 결정을 위한 필수 데이터를 확보할 수 있습니다.
정확한 기업 정보: 각 심볼에는 기업명 등 관련 세부 정보가 포함되어 있어 목록의 각 금융 상품에 대한 맥락을 파악할 수 있습니다.

이 API는 여러 시장에 걸쳐 주식 심볼 또는 금융 상품의 전체 목록을 빠르고 쉽게 조회해야 하는 분들에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/stock-list
```

**Sample Response:**

```json
[
	{
		"symbol": "6898.HK",
		"companyName": "China Aluminum Cans Holdings Limited"
	}
]
```

---

### 73. COT Analysis By Dates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cot-report-analysis

**Summary:**

FMP COT 보고서 분석 API를 통해 시장 심리에 대한 심층적인 인사이트를 확보하세요. 특정 날짜 범위의 트레이더 포지션 보고서(COT)를 분석하여 다양한 섹터에 걸친 시장 역학, 심리 및 잠재적 반전 신호를 평가할 수 있습니다.

**About:**

FMP COT 보고서 분석 API는 트레이더, 분석가, 시장 전략가가 시간 경과에 따른 매수 및 매도 포지션을 해석하고 심리 트렌드 및 잠재적 시장 변화를 추적할 수 있도록 설계되었습니다. 이 API에는 다음이 포함됩니다:

COT Report: 매수 및 매도 포지션을 기반으로 강세 또는 약세 심리를 분석하여 현재 시장 상황을 파악할 수 있습니다.
순 포지션 변화: 순 포지션의 변화를 추적하여 심리가 더욱 강세 또는 약세로 변화하고 있는지 이해할 수 있습니다.
과거 심리 비교: 현재 시장 심리를 이전 기간과 비교하여 시장의 트렌드 또는 잠재적 반전 시점을 감지할 수 있습니다.

이 API는 다양한 시장에서 트레이더들의 포지션 현황과 심리 변화 흐름에 대한 상세한 인사이트를 제공함으로써 시장 참여자들이 합리적인 결정을 내릴 수 있도록 지원합니다.

Example Use Case
원자재 트레이더는 COT 보고서 분석 API를 활용하여 브렌트 원유 트레이더들의 순 포지션 변화를 추적함으로써 에너지 시장의 강세 심리를 평가하고, 이를 바탕으로 거래 전략을 정교하게 다듬을 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/commitment-of-traders-analysis
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"symbol": "B6",
		"date": "2024-02-27 00:00:00",
		"name": "British Pound (B6)",
		"sector": "CURRENCIES",
		"exchange": "BRITISH POUND - CHICAGO MERCANTILE EXCHANGE",
		"currentLongMarketSituation": 66.85,
		"currentShortMarketSituation": 33.15,
		"marketSituation": "Bullish",
		"previousLongMarketSituation": 67.97,
		"previousShortMarketSituation": 32.03,
		"previousMarketSituation": "Bullish",
		"netPostion": 46358,
		"previousNetPosition": 46312,
		"changeInNetPosition": 0.1,
		"marketSentiment": "Increasing Bullish",
		"reversalTrend": false
	}
]
```

---

### 74. COT Report API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cot-report

**Summary:**

FMP COT 보고서 API를 통해 포괄적인 트레이더 포지션 보고서(COT)에 접근하세요. 이 API는 다양한 섹터에 걸친 매수 및 매도 포지션에 관한 상세 정보를 제공하여 시장 심리를 평가하고 원자재, 지수, 금융 상품의 포지션을 추적할 수 있도록 합니다.

**About:**

FMP COT 보고서 API는 시장 참여자들의 포지션을 평가하고자 하는 트레이더, 분석가, 시장 관찰자를 위해 설계되었습니다. 주요 기능은 다음과 같습니다:

COT Report: 상업적 및 비상업적 트레이더의 포지션을 파악하여 특정 시장의 현재 심리에 대한 인사이트를 제공합니다.
섹터별 분석: 소프트 원자재, 에너지, 금융 등 다양한 섹터에 걸친 트레이더 포지션을 분석하여 시장 트렌드에 대한 전체적인 시각을 확보할 수 있습니다.
매수 및 매도 포지션: 매수, 매도, 스프레드 포지션에 관한 상세 데이터를 제공하여 시장 방향에 관한 합리적인 결정을 지원합니다.

이 API는 다양한 시장 참여자들의 포지션을 관찰함으로써 시장 역학에 대한 깊은 이해를 원하는 모든 분들에게 적합합니다.

Example Use Case
원자재 트레이더는 COT 보고서 API를 활용하여 코코아 시장의 미결제약정 및 트레이더 포지션을 분석하고, 매수 및 매도 포지션의 트렌드를 파악하여 거래 전략을 정교하게 다듬을 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/commitment-of-traders-report
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol | string | AAPL |
| from | date | 2024-01-01 |
| to | date | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"symbol": "KC",
		"date": "2024-02-27 00:00:00",
		"name": "Coffee (KC)",
		"sector": "SOFTS",
		"marketAndExchangeNames": "COFFEE C - ICE FUTURES U.S.",
		"cftcContractMarketCode": "083731",
		"cftcMarketCode": "ICUS",
		"cftcRegionCode": "1",
		"cftcCommodityCode": "83",
		"openInterestAll": 209453,
		"noncommPositionsLongAll": 75330,
		"noncommPositionsShortAll": 23630,
		"noncommPositionsSpreadAll": 47072,
		"commPositionsLongAll": 79690,
		"commPositionsShortAll": 132114,
		"totReptPositionsLongAll": 202092,
		"totReptPositionsShortAll": 202816,
		"nonreptPositionsLongAll": 7361,
		"nonreptPositionsShortAll": 6637,
		"openInterestOld": 179986,
		"noncommPositionsLongOld": 75483,
		"noncommPositionsShortOld": 35395,
		"noncommPositionsSpreadOld": 27067,
		"commPositionsLongOld": 70693,
		"commPositionsShortOld": 111666,
		"totReptPositionsLongOld": 173243,
		"totReptPositionsShortOld": 174128,
		"nonreptPositionsLongOld": 6743,
		"nonreptPositionsShortOld": 5858,
		"openInterestOther": 29467,
		"noncommPositionsLongOther": 18754,
		"noncommPositionsShortOther": 7142,
		"noncommPositionsSpreadOther": 1098,
		"commPositionsLongOther": 8997,
		"commPositionsShortOther": 20448,
		"totReptPositionsLongOther": 28849,
		"totReptPositionsShortOther": 28688,
		"nonreptPositionsLongOther": 618,
		"nonreptPositionsShortOther": 779,
		"changeInOpenInterestAll": 2957,
		"changeInNoncommLongAll": -3545,
		"changeInNoncommShortAll": 618,
		"changeInNoncommSpeadAll": 1575,
		"chan
```

---

### 75. COT Report List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cot-report-list

**Summary:**

FMP COT 보고서 목록 API를 통해 원자재 또는 선물 계약별로 이용 가능한 트레이더 포지션 보고서(COT)의 포괄적인 목록에 접근하세요. 이 API는 다양한 시장 세그먼트에 대한 개요를 제공하여 광범위한 원자재 및 금융 상품에 대한 COT 보고서를 조회하고 탐색할 수 있도록 합니다.

**About:**

COT 보고서 목록 API는 특정 시장에 대해 이용 가능한 전체 COT 보고서 목록에 접근하려는 트레이더, 분석가, 연구자에게 이상적입니다. 이 API에는 다음이 포함됩니다:

종합 시장 커버리지: 에너지부터 농산물까지 다양한 원자재에 걸쳐 이용 가능한 모든 COT 보고서 목록을 조회할 수 있습니다.
손쉬운 시장 세분화: 트레이더 포지션 보고서에서 분석 가능한 시장 및 선물 계약을 식별할 수 있습니다.
심볼 식별: 각 원자재 또는 계약과 연관된 심볼을 쉽게 찾아 효율적인 쿼리와 심층 분석을 수행할 수 있습니다.

이 API는 이용 가능한 COT 보고서의 종류와 대상 시장 세그먼트를 신속하게 파악하는 데 유용하며, 보다 집중적이고 효과적인 시장 조사를 가능하게 합니다.

Example Use Case
천연가스 시장의 심리를 평가하려는 트레이더는 COT 보고서 목록 API를 활용하여 관련 선물 계약을 식별하고, 해당 COT 보고서에서 상세 심리 데이터를 추출할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/commitment-of-traders-list
```

**Sample Response:**

```json
[
	{
		"symbol": "NG",
		"name": "Natural Gas (NG)"
	}
]
```

---


### 76. Crowdfunding By CIK API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/crowdfunding-by-cik

**Summary:**

FMP Crowdfunding By CIK API를 사용하여 특정 기업이 진행한 모든 크라우드펀딩 캠페인에 대한 상세 정보를 확인하세요.

**About:**

FMP Crowdfunding By CIK API는 기업의 Central Index Key(CIK)를 기준으로 해당 기업이 진행한 크라우드펀딩 캠페인 목록을 종합적으로 제공합니다. 이 엔드포인트는 다음과 같은 용도로 투자자 및 분석가에게 매우 유용합니다:

Identify Company-Specific Campaigns: 투자 관심 기업이 시작한 모든 크라우드펀딩 캠페인을 파악합니다.
Track Crowdfunding Activity Over Time: 특정 기업의 크라우드펀딩 활동을 모니터링하여 자금 조달 노력의 추세, 성장 및 변화를 식별합니다.
Spot Investment Opportunities: 크라우드펀딩 캠페인 데이터를 활용하여 기업의 크라우드펀딩 전략을 기반으로 잠재적인 투자 기회를 발굴합니다.

이 API는 특정 기업의 크라우드펀딩 활동을 바탕으로 정보에 근거한 의사결정을 내리고자 하는 분들에게 필수적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/crowdfunding-offerings?cik=0001916078
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001916078 |

**Sample Response:**

```json
[
	{
		"cik": "0001916078",
		"companyName": "OYO Fitness, Inc",
		"date": "12-31-2021",
		"filingDate": "2022-07-21 00:00:00",
		"acceptedDate": "2022-07-21 17:28:54",
		"formType": "C-U",
		"formSignification": "Progress Update",
		"nameOfIssuer": "OYO Fitness, Inc",
		"legalStatusForm": "Corporation",
		"jurisdictionOrganization": "DE",
		"issuerStreet": "374 N. 750TH RD",
		"issuerCity": "OVERBROOK",
		"issuerStateOrCountry": "KS",
		"issuerZipCode": "66524",
		"issuerWebsite": "https://www.oyofitness.com/",
		"intermediaryCompanyName": "StartEngine Capital, LLC",
		"intermediaryCommissionCik": "0001665160",
		"intermediaryCommissionFileNumber": "007-00007",
		"compensationAmount": "7 - 13 percent",
		"financialInterest": "Two percent (2%) of securities of the total amount of investments raised in the offering, along the same terms as investors.",
		"securityOfferedType": "Other",
		"securityOfferedOtherDescription": "Non-Voting Common Stock",
		"numberOfSecurityOffered": 5000,
		"offeringPrice": 2,
		"offeringAmount": 10000,
		"overSubscriptionAccepted": "Y",
		"overSubscriptionAllocationType": "Other",
		"maximumOfferingAmount": 1070000,
		"offeringDeadlineDate": "07-19-2022",
		"currentNumberOfEmployees": 5,
		"totalAssetMostRecentFiscalYear": 497717,
		"totalAssetPriorFiscalYear": 248472,
		"cashAndCashEquiValentMostRecentFiscalYear": 150142,
		"cashAndCashEquiValentPriorFiscalYear": 54571,
		"accountsReceivableMostRecentFiscalYear": 0,
		"accountsReceivablePriorFisca
```

---

### 77. Crowdfunding Campaign Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/crowdfunding-search

**Summary:**

FMP Crowdfunding Campaign Search API를 사용하여 기업명, 캠페인명 또는 플랫폼으로 크라우드펀딩 캠페인을 검색하세요. 크라우드펀딩 활동을 추적하고 분석하기 위한 상세 정보를 확인할 수 있습니다.

**About:**

FMP Crowdfunding Campaign Search API는 기업명, 캠페인명 또는 플랫폼을 기준으로 크라우드펀딩 캠페인을 검색할 수 있도록 해줍니다. 이 API는 다음과 같은 용도로 투자자 및 분석가에게 유용한 도구입니다:

Find Specific Campaigns: 모금액, 후원자 수, 투자 마감일 등 특정 크라우드펀딩 캠페인 정보에 신속하게 접근합니다.
Track Company Activity: 특정 기업의 크라우드펀딩 활동을 모니터링하여 시간에 따른 추세나 패턴을 파악합니다.
Identify Investment Opportunities: 크라우드펀딩 데이터를 활용하여 최근 및 진행 중인 캠페인을 기반으로 잠재적인 투자 기회를 발굴합니다.

이 API는 크라우드펀딩 캠페인에 대한 종합적인 세부 정보를 제공하여 최신 정보를 바탕으로 정보에 근거한 의사결정을 내릴 수 있도록 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/crowdfunding-offerings-search?name=enotap
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | enotap |

**Sample Response:**

```json
[
	{
		"cik": "0001912939",
		"name": "Enotap LLC",
		"date": null
	}
]
```

---

### 78. Crypto News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/crypto-news

**Summary:**

FMP Crypto News API를 사용하여 최신 암호화폐 뉴스를 확인하세요. 다양한 출처의 기사 목록을 헤드라인, 요약, 게시 URL과 함께 제공합니다.

**About:**

Crypto News API는 주요 시장 이벤트 및 트렌드를 포함한 암호화폐 최신 뉴스를 제공합니다. 이 API는 다음과 같은 용도로 필수적입니다:

Real-Time Updates: 비트코인, 이더리움 등 주요 암호화폐에 대한 최신 뉴스를 실시간으로 수신합니다.
Market Sentiment Analysis: 암호화폐 시장 심리 및 가격 움직임에 영향을 미칠 수 있는 뉴스와 보고서를 팔로우합니다.
Cryptocurrency Trends: 업계 동향, 신기술, 규제 업데이트에 대한 최신 정보를 유지합니다.

이 API는 빠르게 변화하는 암호화폐 투자 및 트레이딩 세계에 관여하는 모든 분에게 필수적인 도구입니다.

Example Use Case

암호화폐 트레이더가 Crypto News API를 사용하여 비트코인과 이더리움에 관한 일일 뉴스를 추적함으로써 시장 트렌드를 한발 앞서 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/crypto-latest?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"publishedDate": "2025-02-03 23:32:19",
		"publisher": "Coingape",
		"title": "Crypto Prices Today Feb 4: BTC & Altcoins Recover Amid Pause On Trump's Tariffs",
		"image": "https://images.financialmodelingprep.com/news/crypto-prices-today-feb-4-btc-altcoins-recover-amid-20250203.webp",
		"site": "coingape.com",
		"text": "Crypto prices today have shown signs of recovery as U.S. President Donald Trump's newly announced import tariffs on Canada and Mexico were paused for 30 days. Bitcoin (BTC) price regained its value, hitting a $102K high amid broader market recovery.",
		"url": "https://coingape.com/crypto-prices-today-feb-4-btc-altcoins-recover-amid-pause-on-trumps-tariffs/"
	}
]
```

---

### 79. Cryptocurrency List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-list

**Summary:**

FMP Cryptocurrencies Overview API를 사용하여 전 세계 거래소에서 거래되는 모든 암호화폐의 종합 목록에 접근하세요. 각 암호화폐에 대한 상세 정보를 통해 투자 전략을 수립하세요.

**About:**

FMP Cryptocurrencies Overview API는 글로벌 거래소에서 활발히 거래되는 모든 암호화폐에 대한 상세 정보를 제공합니다. 이 API는 다음과 같은 용도로 필수적입니다:

Cryptocurrency Identification: 심볼, 명칭, 페어링된 법정화폐 등 거래 중인 모든 암호화폐 목록에 접근합니다. 이 데이터는 투자자가 다양한 암호화폐를 식별하고 시장 내 존재를 파악하는 데 도움이 됩니다.
Exchange Details: API는 거래소 명칭 및 약식 식별자를 포함한 해당 암호화폐가 상장된 거래소 정보도 제공합니다. 이를 통해 각 암호화폐가 어디서 거래되는지 추적할 수 있습니다.
Informed Decision-Making: 이 API가 제공하는 상세 데이터를 활용하여 암호화폐 성과를 추적하고, 시장 트렌드를 모니터링하며, 정보에 근거한 투자 결정을 내립니다.

Example

Market Analysis: 암호화폐 트레이더가 Cryptocurrencies Overview API를 사용하여 다양한 거래소에서 USD와 페어링된 모든 암호화폐 목록을 정리할 수 있습니다. 이 데이터를 분석함으로써 인기를 얻고 있는 암호화폐와 투자 기회를 제공할 수 있는 암호화폐를 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/cryptocurrency-list
```

**Sample Response:**

```json
[
	{
		"symbol": "ALIENUSD",
		"name": "Alien Inu USD",
		"exchange": "CCC",
		"icoDate": "2021-11-22",
		"circulatingSupply": 0,
		"totalSupply": null
	}
]
```

---

### 80. Cryptocurrency Quote Short API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-quote-short

**Summary:**

FMP Cryptocurrency Quick Quote API를 사용하여 실시간 암호화폐 시세를 확인하세요. 다양한 디지털 자산의 현재 가격, 변동폭, 거래량에 대한 간결한 개요를 제공합니다.

**About:**

FMP Cryptocurrency Quick Quote API는 암호화폐 시장에 대한 최신 정보가 필요한 트레이더, 투자자, 분석가를 위해 필수 암호화폐 가격 데이터에 즉시 접근할 수 있도록 설계되었습니다:

Real-Time Crypto Prices: 비트코인, 이더리움 등 인기 암호화폐의 최신 가격을 조회합니다.
Market Changes: 시장 변동 상황을 파악하기 위해 실시간 가격 변동을 확인합니다.
Trading Volume: 특정 암호화폐의 시장 활동 및 유동성을 평가하기 위한 거래량 데이터에 접근합니다.

이 API는 암호화폐 가격을 모니터링하고 실시간 시장 데이터를 기반으로 정보에 근거한 결정을 내리는 빠르고 효과적인 방법을 제공합니다.

Example Use Case

데이트레이더가 Cryptocurrency Quick Quote API를 사용하여 비트코인 가격을 추적하고 가격 및 거래량의 실시간 변화를 모니터링함으로써 변동성이 큰 시장에서 빠른 매매 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote-short?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"price": 118741.16,
		"change": -37.93,
		"volume": 75302985728
	}
]
```

---


### 81. CUSIP API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-cusip

**Summary:**

FMP CUSIP API를 사용하여 CUSIP 번호로 금융 증권 정보를 손쉽게 검색하고 조회할 수 있습니다. CUSIP에 연결된 회사명, 주식 심볼, 시가총액 등 핵심 정보를 확인하세요.

**About:**

FMP CUSIP API는 특정 CUSIP 번호(위원회 통일 증권 식별 절차)에 연결된 포괄적인 금융 정보를 신속하게 조회할 수 있도록 합니다. 이 9자리 영숫자 코드는 금융 증권을 고유하게 식별하며, 투자자, 트레이더, 분석가에게 필수적인 도구입니다.

CUSIP API의 주요 기능:

Accurate Identification: 특정 CUSIP 번호와 연결된 주식 심볼 및 회사명을 정확하게 찾아 증권을 명확하게 식별합니다.
Comprehensive Data: CUSIP 및 주식 심볼 정보와 함께 시가총액 등 관련 금융 세부 정보를 조회합니다.
Versatility: 주식, 채권, 뮤추얼 펀드 등 다양한 유형의 증권을 지원하며, 여러 금융 시장에 걸쳐 폭넓은 검색 기능을 제공합니다.

이 API는 CUSIP을 기준으로 증권을 효율적으로 식별하고 분석해야 하는 금융 전문가에게 유용한 리소스입니다.

트레이더는 CUSIP API를 사용하여 주식 심볼 "AAPL"을 검색하는 것만으로 Apple Inc.의 CUSIP 번호와 시가총액을 즉시 확인할 수 있어, 거래 체결 전 조사 과정을 간소화할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-cusip?cusip=037833100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cusip* | string | 037833100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL.NE",
		"companyName": "Apple Inc.",
		"cusip": "037833100",
		"marketCap": 5156676087644.16
	}
]
```

---

### 82. Custom DCF Advanced API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/custom-dcf-advanced

**Summary:**

FMP Custom DCF Advanced API를 사용하여 맞춤형 현금흐름할인(DCF) 분석을 실행하세요. 세부적인 입력값을 통해 가정과 변수를 세밀하게 조정하여 기업에 대한 보다 개인화되고 정밀한 가치평가를 제공합니다.

**About:**

Custom DCF Advanced API는 자체적인 예측과 가정을 기반으로 DCF 분석을 커스터마이징하고자 하는 금융 분석가와 투자자를 위해 설계되었습니다. 이 API는 매출 성장률, EBITDA, 자본 지출, 위험 요소 등 핵심 변수를 수정하는 유연성을 제공하여 맞춤형 기업 가치평가를 달성할 수 있습니다. 주요 기능은 다음과 같습니다:

Customizable Inputs: 자신의 전망 및 예측에 맞게 매출, EBITDA, 자본 지출 등 핵심 재무 지표를 조정합니다.
Advanced Financial Assumptions: 무위험 금리, 시장 위험 프리미엄, 세율, WACC 등의 요소를 수정하여 보다 정확한 가치평가를 생성합니다.
Comprehensive Output: 커스텀 입력값을 기반으로 자기자본 가치, 잉여 현금흐름, 터미널 가치, 주당 자기자본 가치 등 상세한 결과를 제공합니다.

이 API는 자신의 투자 전략이나 가치평가 가정을 반영하기 위해 DCF 모델을 커스터마이징하려는 전문 분석가 또는 고급 사용자에게 이상적입니다.

주식 분석가는 Custom DCF Advanced API를 사용하여 Apple의 재무 예측을 조정하거나, 다른 시장 위험 프리미엄을 입력하거나, 장기 성장률을 수정할 수 있습니다. 이러한 맞춤형 입력값을 통해 분석가는 기업에 대한 독자적인 가치평가 모델을 만들고 보다 informed된 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/custom-discounted-cash-flow?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| revenueGrowthPct | number | 0.1094119804597946 |
| ebitdaPct | number | 0.31273548388 |
| depreciationAndAmortizationPct | number | 0.0345531631720999 |
| cashAndShortTermInvestmentsPct | number | 0.2344222126801843 |
| receivablesPct | number | 0.1533770531229388 |
| inventoriesPct | number | 0.0155245674227653 |
| payablePct | number | 0.1614868903169657 |
| ebitPct | number | 0.2781823207138459 |
| capitalExpenditurePct | number | 0.0306025847141713 |
| operatingCashFlowPct | number | 0.2886333485760204 |
| sellingGeneralAndAdministrativeExpensesPct | number | 0.0662854095187211 |
| taxRate | number | 0.14919579658453103 |
| longTermGrowthRate | number | 4 |
| costOfDebt | number | 3.64 |
| costOfEquity | number | 9.51168 |
| marketRiskPremium | number | 4.72 |
| beta | number | 1.244 |
| riskFreeRate | number | 3.64 |

**Sample Response:**

```json
[
	{
		"year": "2030",
		"symbol": "AAPL",
		"revenue": 529528728806,
		"revenuePercentage": 4.09,
		"ebitda": 191125428209,
		"ebitdaPercentage": 36.09,
		"ebit": 177353356628,
		"ebitPercentage": 33.49,
		"depreciation": 15508463644,
		"depreciationPercentage": 2.93,
		"totalCash": 79685715467,
		"totalCashPercentage": 15.05,
		"receivables": 114078294622,
		"receivablesPercentage": 21.54,
		"inventories": 8411056160,
		"inventoriesPercentage": 1.59,
		"payable": 101862682518,
		"payablePercentage": 19.24,
		"capitalExpenditure": -14907445037,
		"capitalExpenditurePercentage": -2.82,
		"price": 262.82,
		"beta": 1.109,
		"dilutedSharesOutstanding": 15004697000,
		"costofDebt": 3.92,
		"taxRate": 15.61,
		"afterTaxCostOfDebt": 3.31,
		"riskFreeRate": 3.92,
		"marketRiskPremium": 4.72,
		"costOfEquity": 9.15,
		"totalDebt": 112377000000,
		"totalEquity": 3943534465540,
		"totalCapital": 4055911465540,
		"debtWeighting": 2.77,
		"equityWeighting": 97.23,
		"wacc": 8.99,
		"taxRateCash": 16785417,
		"ebiat": 147583856418,
		"ufcf": 145836268225,
		"sumPvUfcf": 505377678906,
		"longTermGrowthRate": 4,
		"terminalValue": 3038731862013,
		"presentTerminalValue": 1975763045693,
		"enterpriseValue": 2481140724600,
		"netDebt": 76443000000,
		"equityValue": 2404697724600,
		"equityValuePerShare": 160.26,
		"freeCashFlowT1": 151669718954
	}
]
```

---

### 83. Custom DCF Levered API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/custom-dcf-levered

**Summary:**

FMP Custom DCF Advanced API를 사용하여 맞춤형 현금흐름할인(DCF) 분석을 실행하세요. 세부적인 입력값을 통해 가정과 변수를 세밀하게 조정하여 기업에 대한 보다 개인화되고 정밀한 가치평가를 제공합니다.

**About:**

Custom DCF Advanced API는 자체적인 예측과 가정을 기반으로 DCF 분석을 커스터마이징하고자 하는 금융 분석가와 투자자를 위해 설계되었습니다. 이 API는 매출 성장률, EBITDA, 자본 지출, 위험 요소 등 핵심 변수를 수정하는 유연성을 제공하여 맞춤형 기업 가치평가를 달성할 수 있습니다. 주요 기능은 다음과 같습니다:

Customizable Inputs: 자신의 전망 및 예측에 맞게 매출, EBITDA, 자본 지출 등 핵심 재무 지표를 조정합니다.
Advanced Financial Assumptions: 무위험 금리, 시장 위험 프리미엄, 세율, WACC 등의 요소를 수정하여 보다 정확한 가치평가를 생성합니다.
Comprehensive Output: 커스텀 입력값을 기반으로 자기자본 가치, 잉여 현금흐름, 터미널 가치, 주당 자기자본 가치 등 상세한 결과를 제공합니다.

이 API는 자신의 투자 전략이나 가치평가 가정을 반영하기 위해 DCF 모델을 커스터마이징하려는 전문 분석가 또는 고급 사용자에게 이상적입니다.

주식 분석가는 Custom DCF Advanced API를 사용하여 Apple의 재무 예측을 조정하거나, 다른 시장 위험 프리미엄을 입력하거나, 장기 성장률을 수정할 수 있습니다. 이러한 맞춤형 입력값을 통해 분석가는 기업에 대한 독자적인 가치평가 모델을 만들고 보다 informed된 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/custom-levered-discounted-cash-flow?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| revenueGrowthPct | number | 0.1094119804597946 |
| ebitdaPct | number | 0.31273548388 |
| depreciationAndAmortizationPct | number | 0.0345531631720999 |
| cashAndShortTermInvestmentsPct | number | 0.2344222126801843 |
| receivablesPct | number | 0.1533770531229388 |
| inventoriesPct | number | 0.0155245674227653 |
| payablePct | number | 0.1614868903169657 |
| ebitPct | number | 0.2781823207138459 |
| capitalExpenditurePct | number | 0.0306025847141713 |
| operatingCashFlowPct | number | 0.2886333485760204 |
| sellingGeneralAndAdministrativeExpensesPct | number | 0.0662854095187211 |
| taxRate | number | 0.14919579658453103 |
| longTermGrowthRate | number | 4 |
| costOfDebt | number | 3.64 |
| costOfEquity | number | 9.51168 |
| marketRiskPremium | number | 4.72 |
| beta | number | 1.244 |
| riskFreeRate | number | 3.64 |

**Sample Response:**

```json
[
	{
		"year": "2030",
		"symbol": "AAPL",
		"revenue": 529528728806,
		"revenuePercentage": 4.09,
		"capitalExpenditure": -14907445037,
		"capitalExpenditurePercentage": -2.82,
		"price": 262.82,
		"beta": 1.109,
		"dilutedSharesOutstanding": 15004697000,
		"costofDebt": 3.92,
		"taxRate": 15.61,
		"afterTaxCostOfDebt": 3.31,
		"riskFreeRate": 3.92,
		"marketRiskPremium": 4.72,
		"costOfEquity": 9.15,
		"totalDebt": 112377000000,
		"totalEquity": 3943534465540,
		"totalCapital": 4055911465540,
		"debtWeighting": 2.77,
		"equityWeighting": 97.23,
		"wacc": 8.99,
		"operatingCashFlow": 153867620418,
		"pvLfcf": 90350972645,
		"sumPvLfcf": 492288755830,
		"longTermGrowthRate": 4,
		"freeCashFlow": 138960175381,
		"terminalValue": 2895457471723,
		"presentTerminalValue": 1882606999493,
		"enterpriseValue": 2374895755323,
		"netDebt": 76443000000,
		"equityValue": 2298452755323,
		"equityValuePerShare": 153.18,
		"freeCashFlowT1": 144518582396,
		"operatingCashFlowPercentage": 29.06
	}
]
```

---

### 84. DCF Valuation API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dcf-advanced

**Summary:**

FMP 현금흐름할인 가치평가 API를 사용하여 기업의 내재 가치를 추정하세요. 예상 미래 현금흐름과 할인율을 기반으로 DCF 가치평가를 산출합니다.

**About:**

FMP 현금흐름할인(DCF) 가치평가 API는 투자자에게 투자 가치를 추정하는 강력한 도구를 제공합니다. DCF는 기업의 예상 미래 현금흐름의 현재 가치를 계산하는 널리 사용되는 가치평가 방법입니다. 이 API를 통해 다음을 수행할 수 있습니다:

Calculate DCF Valuation: 기업의 예상 미래 현금흐름과 적절한 할인율을 입력하여 DCF 가치평가를 손쉽게 계산합니다.
Assess Investment Opportunities: DCF를 사용하여 다양한 투자의 내재 가치를 비교함으로써 저평가 또는 고평가된 자산을 식별합니다.
Evaluate Investment Risk: 현금흐름이나 할인율 변화에 대한 DCF 가치평가의 민감도를 파악하여 투자 위험도를 분석합니다.

FMP 현금흐름할인 가치평가 API는 DCF 계산 과정을 단순화하여, 사용자가 필요한 재무 데이터를 입력하고 가치평가 결과를 신속하게 얻을 수 있도록 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/discounted-cash-flow?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2026-04-08",
		"dcf": 159.36622443786206,
		"Stock Price": 258.25
	}
]
```

---

### 85. DCF Valuations Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dcf-bulk

**Summary:**

FMP DCF 대량 조회 API를 통해 한 번의 요청으로 여러 심볼의 현금흐름할인(DCF) 가치평가를 빠르게 조회할 수 있습니다. 상장된 모든 기업의 내재가치 대비 가격 차이 및 비율 차이를 확인하세요.

**About:**

DCF 대량 조회 API는 광범위한 심볼에 걸쳐 DCF 가치평가를 편리하게 수집하는 방법을 제공하여, 투자자와 분석가가 다음을 수행할 수 있도록 합니다:

Retrieve DCF Valuations in Bulk: 단일 API 호출로 여러 주식의 현금흐름할인 가치평가를 조회하여 시간을 절약하고 데이터 조회 효율성을 향상합니다.
Analyze Price Movements: DCF 퍼센트 차이 데이터를 사용하여 기업 가치평가를 기반으로 한 잠재적 가격 움직임을 평가합니다.
Informed Decision-Making: 다양한 기업의 DCF 값을 비교하여 대량 DCF 데이터를 활용한 전략적 투자 결정을 내립니다.

이 API는 대규모 포트폴리오 매니저, 금융 분석가, 다수 기업의 가치평가를 평가해야 하는 데이터 과학자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/dcf-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "000002.SZ",
		"date": "2025-07-09",
		"dcf": "179.6654688379575",
		"Stock Price": "6.54"
	}
]
```

---


### 86. Delisted Companies API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/delisted-companies

**Summary:**

FMP 상장폐지 기업 API로 최신 정보를 유지하세요. 미국 거래소에서 상장폐지된 기업의 종합 목록에 접근하여 위험한 종목 거래를 피하고 잠재적인 재무 위험 기업을 식별하세요.

**About:**

FMP 상장폐지 기업 API는 미국 주식 거래소에서 퇴출된 기업에 대한 유용한 정보를 제공합니다. 이 API는 다음과 같은 목적의 투자자에게 필수적입니다:

Avoid Trading in Delisted Stocks: 상장폐지된 종목을 식별하여 해당 증권 거래로 인한 잠재적 손실을 방지합니다.
Understand Reasons for Delisting: 재정적 어려움, 거래소 규정 미준수, 인수합병 등 기업 상장폐지로 이어지는 다양한 요인을 파악합니다.
Identify Financial Troubles: 상장폐지 기업 목록을 잠재적인 재정 불안정이나 기업 내 기타 근본적인 문제의 지표로 활용합니다.

이 API는 미국 거래소에서 더 이상 공개 거래되지 않는 기업에 대한 적시 정보를 제공함으로써 투자자가 정보에 기반한 결정을 내릴 수 있도록 돕습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/delisted-companies?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "5CV.DE",
		"companyName": "CureVac N.V.",
		"exchange": "XETRA",
		"ipoDate": "2020-08-25",
		"delistedDate": "2026-12-05"
	}
]
```

---

### 87. Dividend Adjusted Price Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-price-eod-dividend-adjusted

**Summary:**

FMP 배당 조정 주가 차트 API를 사용하여 배당 조정이 반영된 주식 성과를 분석하세요. 배당금 지급을 반영한 일별 종가 및 거래량 데이터에 접근하여 시간 경과에 따른 주가 추세를 보다 포괄적으로 파악하세요.

**About:**

FMP 배당 조정 주가 차트 API는 배당금이 조정된 일별 종가(EOD) 데이터를 제공하여 트레이더, 애널리스트, 투자자가 배당금 지급 효과를 반영한 주식 성과를 이해할 수 있도록 돕습니다. 이를 통해 특히 정기적인 배당금을 지급하는 기업의 주가 변동을 보다 정확하게 분석할 수 있습니다. 주요 기능은 다음과 같습니다:

Dividend-Adjusted Prices: 실제 주식 가치를 반영하여 배당금 지급이 조정된 과거 주가(시가, 고가, 저가, 종가)에 접근합니다.
Volume Data: 일별 거래량을 조회하여 가격 움직임과 함께 시장 활동을 평가합니다.
Accurate Performance Analysis: 배당 조정 데이터를 활용하여 배당금의 영향을 반영한 시간 경과에 따른 주식 성과를 평가합니다.
Enhanced Historical Insights: 배당금 효과를 포함하여 주식 성장과 성과에 대한 보다 명확한 그림을 원하는 장기 투자자에게 이상적입니다.

이 API는 총수익을 이해하는 데 유용한 도구로, 배당금 영향을 통합함으로써 주식의 과거 성과를 더 쉽게 파악할 수 있게 해줍니다.

Example Use Case
Apple 주식의 과거 성장을 추적하는 투자자는 배당 조정 주가 차트 API를 사용하여 시간 경과에 따른 주가 변동을 분석할 때 배당금 지급의 영향을 반영할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/dividend-adjusted?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-04",
		"adjOpen": 227.2,
		"adjHigh": 233.13,
		"adjLow": 226.65,
		"adjClose": 232.8,
		"volume": 44489128
	}
]
```

---

### 88. Dividends Calendar API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dividends-calendar

**Summary:**

배당 이벤트 캘린더 API로 다가오는 배당 일정을 놓치지 마세요. 기록일, 지급일, 선언일, 배당 수익률 등 모든 주식의 배당 관련 날짜 일정을 종합적으로 확인하세요.

**About:**

배당 이벤트 캘린더 API는 다가오는 배당 이벤트에 대한 시장 전반의 뷰를 제공합니다. 투자자, 재무 애널리스트, 포트폴리오 매니저에게 이상적인 이 API는 다음을 지원합니다:

Comprehensive Dividend Calendar: 다양한 주식의 배당 기록일, 지급일, 선언일 등 예정된 배당 내역을 확인합니다.
Dividend Yield Tracking: 배당 수익률을 분석하여 각 주식의 잠재적 수익을 평가합니다.
Payment Frequency Details: 배당이 분기별, 연간 또는 기타 주기로 지급되는지 확인하여 향후 투자를 계획합니다.
Efficient Market Monitoring: 시장 전반의 배당 이벤트를 추적하여 기회와 추세를 포착합니다.

이 API를 통해 투자자는 배당 이벤트를 선제적으로 파악하고 수익 전략을 최적화할 수 있습니다.

Example Use Case
포트폴리오 매니저는 배당 이벤트 캘린더 API를 사용하여 포트폴리오 내 모든 주식의 예정된 배당금 지급을 추적함으로써 중요한 배당 이벤트나 지급일을 놓치지 않을 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/dividends-calendar
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| page | number | 0 |

**Sample Response:**

```json
[
	{
		"symbol": "1D0.SI",
		"date": "2025-02-04",
		"recordDate": "",
		"paymentDate": "",
		"declarationDate": "",
		"adjDividend": 0.01,
		"dividend": 0.01,
		"yield": 6.25,
		"frequency": "Semi-Annual"
	}
]
```

---

### 89. Dividends Company API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dividends-company

**Summary:**

FMP 기업 배당 API로 예정된 배당금 지급 정보를 항상 파악하세요. 이 API는 기록일, 지급일, 선언일 등 개별 주식 종목의 필수 배당 데이터를 제공합니다.

**About:**

FMP 기업 배당 API는 특정 주식의 배당 정보를 종합적으로 제공합니다. 배당 중심 투자자를 위해 설계된 이 API는 다음을 제공합니다:

Dividend Schedule Overview: 기록일, 지급일, 선언일 등 예정된 배당 세부 정보에 접근하여 배당금 지급에 관한 적시 정보를 확인합니다.
Dividend Amount: 배당금 및 조정 배당금 금액을 조회하여 예상 지급액을 파악합니다.
Yield Data: 주식의 배당 수익률을 추적하여 배당 중심 포트폴리오의 투자 수익률을 더 잘 평가합니다.
Payment Frequency: 배당금 지급 빈도(예: 분기별, 연간)를 파악하여 주식의 지급 일정에 맞는 투자 전략을 수립합니다.

배당 금액, 조정 배당금, 수익률, 지급 빈도 등 상세한 배당 정보를 통해 투자자는 배당 일정에 맞게 효과적으로 계획을 세울 수 있습니다. 이 API는 수익 창출 투자에 관한 정보에 기반한 결정을 내리기 위해 최신 정보가 필요한 배당 투자자에게 최적입니다.

Example Use Case
배당 투자자는 기업 배당 API를 사용하여 Apple의 예정된 배당금 지급을 모니터링하고, 배당금을 받기 위해 기록일까지 해당 주식을 보유하고 있는지 확인할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/dividends?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-10",
		"recordDate": "2025-02-10",
		"paymentDate": "2025-02-13",
		"declarationDate": "2025-01-30",
		"adjDividend": 0.25,
		"dividend": 0.25,
		"yield": 0.42955326460481097,
		"frequency": "Quarterly"
	}
]
```

---

### 90. Double Exponential Moving Average API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/double-exponential-moving-average

**Summary:**

2·EMA − EMA(EMA)로 정의되는, 표준 EMA보다 가격을 더 밀접하게 추종하도록 설계된 빠르고 지연이 줄어든 이동평균입니다.

**About:**

DEMA는 EMA의 EMA를 EMA의 두 배에서 빼는 방식으로, 단일 지수 평활화에 내재된 지연을 상당 부분 상쇄합니다. 그 결과 강한 추세 중에는 가격에 밀착하고 반전 시점에서는 더 일찍 방향을 바꾸는 곡선이 만들어지며, 트레이더들은 이를 EMA 크로스오버, MACD 스타일 히스토그램, 또는 브레이크아웃 시스템의 추세 필터와 함께 활용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/dema?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"dema": 255.93918344492874
	}
]
```

---


### 91. Dow Jones API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dow-jones

**Summary:**

Dow Jones API를 사용하여 다우존스 산업평균지수 데이터에 접근하세요. 현재 값을 추적하고, 트렌드를 분석하며, 이 중요한 주가지수를 구성하는 기업들에 대한 상세 정보를 확인할 수 있습니다.

**About:**

FMP 다우존스 산업평균지수 API는 이 상징적인 지수를 구성하는 기업들에 대한 포괄적인 정보를 제공합니다. 이 API는 회사명, 심볼, 섹터, 하위 섹터, 본사 위치, 설립일 등 핵심 세부 정보를 제공하여 투자자와 애널리스트가 가장 널리 추종되는 주가지수 중 하나의 성과를 모니터링할 수 있도록 합니다. 주요 기능은 다음과 같습니다:

Detailed Company Information: 섹터, 하위 섹터, 지리적 위치를 포함한 다우존스 구성 기업들의 핵심 세부 정보에 접근합니다.
Track Real-Time Trends: 다우존스 산업평균지수의 현재 움직임과 트렌드를 추적합니다.
Sector Breakdown: 더 깊은 인사이트를 위해 지수가 어떻게 다양한 섹터 및 하위 섹터로 구분되는지 분석합니다.
Historical Additions: 기업이 처음 다우존스에 편입된 시점을 확인하여 지수 변경에 대한 맥락을 파악합니다.

이 API는 다우존스 산업평균지수에 대한 정확하고 최신의 정보가 필요한 금융 전문가, 포트폴리오 매니저, 애널리스트에게 이상적입니다.

Example Use Case
다우존스 산업평균지수를 추적하는 포트폴리오 매니저가 Dow Jones API를 사용하여 아마존(AMZN)과 같이 새로 편입된 기업에 대한 상세 데이터에 접근합니다. 섹터 및 하위 섹터 분류를 분석함으로써, 매니저는 지수 변경이 자신의 투자 전략에 미치는 영향을 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/dowjones-constituent
```

**Sample Response:**

```json
[
	{
		"symbol": "NVDA",
		"name": "Nvidia",
		"sector": "Technology",
		"subSector": "Semiconductors",
		"headQuarter": "Santa Clara, CA",
		"dateFirstAdded": "2024-11-08",
		"cik": "0001045810",
		"founded": "1993-04-05"
	}
]
```

---

### 92. Earnings Calendar API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/earnings-calendar

**Summary:**

FMP 실적 발표 캘린더 API를 통해 예정된 실적 발표와 과거 실적 발표 정보를 신속하게 파악하세요. 공개 상장 기업의 발표 날짜, 예상 주당순이익(EPS), 실제 EPS 등 핵심 데이터에 접근할 수 있습니다.

**About:**

FMP 실적 발표 캘린더 API는 공개 상장 기업의 실적 발표 현황을 지속적으로 파악해야 하는 투자자, 트레이더, 금융 애널리스트를 위한 필수 도구입니다. 이 API는 다음 용도에 유용합니다:

Tracking Earnings Announcements: 발표 날짜, 예상 EPS, 실제 EPS(가용 시)를 포함한 예정된 실적 발표와 과거 실적 발표의 종합 목록에 접근합니다.
Informed Decision-Making: 실적 발표는 기업의 재무 성과와 미래 전망에 대한 중요한 인사이트를 제공합니다. 이 데이터를 활용하여 합리적인 트레이딩 및 투자 결정을 내립니다.
Market Analysis: 다양한 기업의 실적 성과를 시간 흐름에 따라 분석하여 트렌드를 파악하고, 산업 간 성과를 비교하며, 주가에 미치는 잠재적 영향을 평가합니다.

이 API는 실적 발표를 모니터링하고 이 정보를 투자 전략 수립에 활용해야 하는 모든 사람에게 강력한 리소스입니다.

Example Use Case
트레이딩 전략: 트레이더가 실적 발표 캘린더 API를 사용하여 주요 기술 기업들의 실적 발표를 추적할 수 있습니다. 예상 EPS와 실제 EPS를 사전에 파악함으로써, 트레이더는 시장이 실적 결과에 반응하는 방식에 기반한 합리적인 거래를 준비할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earnings-calendar
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| page | number | 0 |

**Sample Response:**

```json
[
	{
		"symbol": "KEC.NS",
		"date": "2024-11-04",
		"epsActual": 3.32,
		"epsEstimated": 4.97,
		"revenueActual": 51133100000,
		"revenueEstimated": 44687400000,
		"lastUpdated": "2024-12-08"
	}
]
```

---

### 93. Earnings Report API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/earnings-company

**Summary:**

FMP 실적 보고서 API를 통해 심층적인 실적 정보를 조회하세요. 특정 주식 심볼에 대한 핵심 재무 데이터(실적 보고 날짜, EPS 추정치, 매출 전망 등)에 접근하여 기업 성과를 지속적으로 파악할 수 있습니다.

**About:**

실적 보고서 API는 공개 상장 기업의 실적 발표에 대한 상세한 인사이트를 제공합니다. 합리적인 트레이딩 및 투자 결정을 내리기 위해 실적 보고서를 면밀히 모니터링해야 하는 투자자와 애널리스트를 위해 설계되었으며, 다음 기능을 포함합니다:

Earnings Report Timing: 장 마감 후(amc) 또는 장 시작 전(bmo) 보고서 발표 여부를 포함하여 특정 기업의 실적 발표를 추적합니다.
EPS and Revenue Estimates: 실적 발표 전에 예상 주당순이익(EPS) 및 매출 데이터에 접근하여 시장 기대치를 파악합니다.
Performance Tracking: 실제 실적이 발표된 후 추정치와 얼마나 일치하는지 확인하여 기업 성과 트렌드를 파악하는 데 도움을 줍니다.
Market Reaction Insights: 실적 데이터를 활용하여 기업이 실적 기대치를 상회 또는 하회했는지에 따른 잠재적인 주가 움직임을 예측합니다.

이 API는 기업 실적 현황을 파악하고 실적 보고서가 주가에 미칠 수 있는 영향을 모니터링하려는 분들에게 이상적입니다.

Example Use Case
금융 애널리스트가 실적 보고서 API를 사용하여 애플의 다음 실적 발표를 추적하고, EPS 및 매출 추정치를 검토하여 실적 발표 이후 주가가 어떻게 반응할지 예측할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earnings?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-10-29",
		"epsActual": null,
		"epsEstimated": null,
		"revenueActual": null,
		"revenueEstimated": null,
		"lastUpdated": "2025-02-04"
	}
]
```

---

### 94. Earnings Surprises Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/earnings-surprises-bulk

**Summary:**

실적 서프라이즈 벌크 API를 통해 연간 실적 서프라이즈 데이터를 대량으로 조회하여, 어떤 기업이 실적 추정치를 상회, 하회, 또는 충족했는지 빠르게 분석할 수 있습니다. 이 API는 여러 기업의 실제 대비 예상 주당순이익(EPS)을 한 번에 제공하여 투자자와 애널리스트에게 유용한 인사이트를 제공합니다.

**About:**

실적 서프라이즈 벌크 API는 다음을 원하는 분들에게 필수적인 도구입니다:

Identify Performance Trends: 기업이 실적 추정치를 지속적으로 상회 또는 하회하는지 추적합니다.
Investment Opportunities: 실적 기대치를 초과하거나 추정치 미달로 하락 추세에 있는 기업에서 잠재적인 투자 기회를 발굴합니다.
Analyze Market Sentiment: 기업의 실적 성과가 시장 기대치와 어떻게 비교되는지 분석하여 투자자 신뢰도를 가늠합니다.
Strategic Forecasting: 과거 데이터를 활용하여 재무 예측 모델을 고도화하거나 데이터 기반 투자 결정을 내립니다.

이 벌크 API를 통해 여러 기업의 실적 서프라이즈 데이터를 손쉽게 조회하여, 다양한 산업 또는 섹터 전반의 트렌드를 파악하는 과정을 간소화할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earnings-surprises-bulk?year=2026
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |

**Sample Response:**

```json
[
	{
		"symbol": "AMKYF",
		"date": "2025-07-09",
		"epsActual": "0.3631",
		"epsEstimated": "0.3615",
		"lastUpdated": "2025-07-09"
	}
]
```

---

### 95. Earnings Transcript API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-transcripts

**Summary:**

FMP 실적 발표 컨퍼런스 콜 전문 API를 통해 기업의 실적 콜 전체 대화록에 접근하세요. 경영진의 커뮤니케이션을 분석하여 기업의 재무 성과, 미래 계획, 전반적인 전략을 파악할 수 있습니다.

**About:**

FMP 실적 발표 컨퍼런스 콜 전문 API는 기업의 실적 콜 텍스트 대화록에 대한 완전한 접근 권한을 제공합니다. 이 API는 다음 용도에 필수적입니다:

In-Depth Financial Analysis: 실적 콜에서 임원들이 발언하는 내용을 검토하여 기업의 재무 성과에 대한 귀중한 인사이트를 얻습니다. 대화록은 표준 재무 보고서에서 확인할 수 없는 맥락과 세부 정보를 제공할 수 있습니다.
Strategic Planning: 경영진으로부터 직접 기업의 미래 계획과 전략적 방향을 파악합니다. 기업의 우선순위와 과제를 이해하면 투자자가 합리적인 결정을 내리는 데 도움이 됩니다.
Risk Identification: 대화록을 활용하여 실적 보고서에서 즉시 드러나지 않을 수 있는 잠재적 위험 신호나 우려 사항을 파악합니다. 여기에는 경영진의 어조, 애널리스트 질문에 대한 답변, 또는 운영상 또는 재무적 어려움에 대한 언급 등이 포함될 수 있습니다.

Example Use Case
투자자 인사이트: 투자자가 실적 발표 컨퍼런스 콜 전문 API를 사용하여 소매 기업의 가장 최근 실적 콜을 검토할 수 있습니다. 대화록을 분석함으로써, 투자자는 시장 트렌드에 대한 기업의 대응, 향후 분기에 대한 경영진의 전망, 그리고 논의된 잠재적 위험 요소를 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earning-call-transcript?symbol=AAPL&year=2020&quarter=3
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| year* | string | 2020 |
| quarter* | string | 3 |
| limit | number | 1 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"period": "Q3",
		"year": 2020,
		"date": "2020-07-30",
		"content": "Operator: Good day, everyone. Welcome to the Apple Incorporated Third Quarter Fiscal Year 2020 Earnings Conference Call. Today's call is being recorded. At this time, for opening remarks and introductions, I would like to turn things over to Mr. Tejas Gala, Senior Manager, Corporate Finance and Investor Relations. Please go ahead, sir.\nTejas Gala: Thank you. Good afternoon and thank you for joining us. Speaking first today is Apple's CEO, Tim Cook; and he'll be followed by CFO, Luca Maestri. Aft..."
	}
]
```

---


### 96. Earnings Transcript List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/earnings-transcript-list

**Summary:**

FMP 실적 발표 전문 목록 API를 통해 기업들의 이용 가능한 실적 발표 전문에 접근하세요. 실적 전문이 존재하는 기업 목록과 각 기업별 이용 가능한 전문 수를 조회할 수 있습니다.

**About:**

FMP 실적 발표 전문 목록 API는 다양한 기업의 실적 발표 전문 이용 가능 여부에 관한 핵심 데이터를 제공합니다. 이 API는 시간에 따른 실적 성과를 추적하고자 하는 재무 분석가, 투자자, 연구자에게 적합합니다.

Identify Available Transcripts: 실적 전문이 존재하는 기업 목록과 각 기업별 이용 가능한 전문 수를 빠르게 확인할 수 있습니다.
Support Earnings Analysis: 전문 수를 활용하여 실적 발표 데이터를 추가 분석하고 기업 실적에 대한 인사이트를 얻을 수 있습니다.
Track Historical Data: 여러 전문이 있는 기업을 발견하여 다양한 분기 또는 연도에 걸친 실적 발표를 추적할 수 있습니다.

Example Use Case
여러 분기에 걸쳐 기업의 실적 성과를 분석하고자 하는 투자자는 실적 발표 전문 목록 API를 사용하여 여러 실적 발표 전문이 있는 기업을 식별하고, 심층적인 재무 분석을 위한 필요 문서를 조회할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earnings-transcript-list
```

**Sample Response:**

```json
[
	{
		"symbol": "MCUJF",
		"companyName": "Medicure Inc.",
		"noOfTranscripts": "16"
	}
]
```

---

### 97. Economic Data Releases Calendar API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/economics-calendar

**Summary:**

FMP 경제 데이터 발표 캘린더 API로 항상 최신 정보를 확인하세요. 예정된 경제 데이터 발표 일정을 종합적으로 제공하여 시장 영향에 대비하고 합리적인 투자 결정을 내릴 수 있도록 지원합니다.

**About:**

FMP 경제 데이터 발표 캘린더 API는 예정된 경제 데이터 발표의 상세 일정을 제공합니다. 이 도구는 다음을 원하는 투자자에게 필수적입니다:

Stay Updated on Economic Events: 주요 경제 데이터 발표의 날짜와 세부 정보를 나열하는 캘린더에 접근할 수 있습니다.
Prepare for Market Reactions: 예정된 경제 지표 및 보고서에 대한 최신 정보를 파악하여 시장 움직임을 예측할 수 있습니다.
Make Informed Investment Decisions: 최신 경제 데이터를 활용하여 투자 전략과 결정을 안내받을 수 있습니다.

이 API는 중요한 경제 데이터 발표를 모니터링하여 시장 트렌드를 앞서 파악해야 하는 트레이더, 분석가, 투자자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/economic-calendar
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| country | string | US |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 23:50:00",
		"country": "JP",
		"event": "Foreign Bond Investment (Apr/04)",
		"currency": "JPY",
		"previous": -945.4,
		"estimate": null,
		"actual": -2462.4,
		"change": -1516.9,
		"impact": "Low",
		"changePercentage": -160.434,
		"unit": null
	}
]
```

---

### 98. Economics Indicators API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/economics-indicators

**Summary:**

FMP 경제 지표 API를 통해 GDP, 실업률, 인플레이션 등 주요 지표에 대한 실시간 및 과거 경제 데이터에 접근하세요. 이 데이터를 활용하여 경제 성과를 측정하고 성장 트렌드를 파악할 수 있습니다.

**About:**

FMP 경제 지표 API는 GDP, 실업률, 인플레이션을 포함한 광범위한 경제 지표에 대한 실시간 및 과거 데이터에 포괄적으로 접근할 수 있도록 합니다. 이러한 지표는 다음을 위한 필수 도구입니다:

Economic Performance Tracking: GDP, 실업률, 인플레이션과 같은 경제 지표는 경제 전반의 건전성을 한눈에 파악하게 해줍니다. 시간에 따라 이러한 지표를 추적함으로써 투자자와 분석가는 경제 성과를 평가하고 미래 경제 상황을 예측할 수 있습니다.
Trend Identification: 경제 성장의 트렌드를 식별하는 것은 합리적인 투자 결정을 내리는 데 매우 중요합니다. 경제 지표 API를 통해 사용자는 과거 데이터를 분석하고 경제 확장 또는 수축을 나타내는 패턴을 탐지할 수 있습니다.
Informed Investment Decisions: 경제 데이터는 합리적인 투자 결정을 내리는 데 핵심 요소입니다. 현재 경제 상태와 그 방향을 이해함으로써 투자자는 포트폴리오를 경제 사이클에 더 잘 맞출 수 있습니다.

Example Investor Use Case
투자자는 경제 지표 API를 사용하여 지난 10년간의 GDP 성장률을 모니터링할 수 있습니다. 이 데이터를 분석함으로써 투자자는 강한 경제 성장 시기를 파악하고 그에 맞게 투자 전략을 조정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/economic-indicators?name=GDP
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | GDPrealGDPnominalPotentialGDPrealGDPPerCapitafederalFundsCPIinflationRateinflationretailSalesconsumerSentimentdurableGoodsunemploymentRatetotalNonfarmPayrollinitialClaimsindustrialProductionTotalIndexnewPrivatelyOwnedHousingUnitsStartedTotalUnitstotalVehicleSalesretailMoneyFundssmoothedUSRecessionProbabilities3MonthOr90DayRatesAndYieldsCertificatesOfDepositcommercialBankInterestRateOnCreditCardPlansAllAccounts30YearFixedRateMortgageAverage15YearFixedRateMortgageAveragetradeBalanceGoodsAndServices |
| from | date | 2025-04-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"name": "GDP",
		"date": "2025-10-01",
		"value": 31442.483
	}
]
```

---

### 99. Enterprise Values API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/enterprise-values

**Summary:**

기업 가치(Enterprise Values) API를 통해 기업의 기업가치를 확인하세요. 이 지표는 자기자본(시가총액)과 부채를 결합하여 기업의 총 시장 가치에 대한 포괄적인 시각을 제공하며, 기업의 실질 가치를 더 잘 이해할 수 있게 합니다.

**About:**

기업 가치 API는 기업의 가치를 평가하는 데 도움이 되는 주요 재무 데이터를 제공합니다:

Market Capitalization: 현재 주가를 기준으로 한 모든 발행 주식의 총 가치입니다.
Debt & Cash: 총 부채를 포함하고 현금 및 현금성 자산을 차감하여 기업의 재무 상태를 완전히 파악합니다.
Comprehensive Valuation: 기업 가치는 자기자본과 부채를 모두 포함하므로, 잠재적 인수, 합병, 매각 평가 시 선호되는 지표입니다.

이 API는 기업의 전반적인 시장 위치를 고려한 완전한 가치 평가가 필요한 분석가, 투자자, 재무 전문가에게 이상적입니다.

Example Use Case
재무 분석가가 기업 가치 API를 활용하여 Apple의 총 시장 가치를 평가할 때, 부채를 포함하고 현금 보유량을 차감하여 좋은 인수 대상인지 여부를 판단합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/enterprise-values?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"stockPrice": 227.79,
		"numberOfShares": 15343783000,
		"marketCapitalization": 3495160329570,
		"minusCashAndCashEquivalents": 29943000000,
		"addTotalDebt": 106629000000,
		"enterpriseValue": 3571846329570
	}
]
```

---

### 100. Eod Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/eod-bulk

**Summary:**

EOD Bulk API를 통해 여러 종목의 종가(End-of-Day) 주가 데이터를 일괄로 조회할 수 있습니다. 이 API는 다수 기업의 가치 평가가 필요한 재무 분석가, 트레이더, 투자자에게 이상적입니다.

**About:**

EOD Bulk API는 다음을 제공합니다:

Historical Stock Prices: 특정 날짜의 여러 종목에 대한 종가 주가 데이터에 접근할 수 있습니다.
Open, High, Low, Close Prices: 각 종목의 시가, 고가, 저가, 종가를 포함한 상세한 가격 데이터를 조회할 수 있습니다.
Volume and Adjusted Close: 거래량과 수정 종가를 가져와 주식 성과와 거래 활동을 분석할 수 있습니다.
Historical Data Analysis: 과거 주가를 활용하여 기술적 분석, 백테스팅, 트렌드 예측을 수행할 수 있습니다.

이 API는 광범위한 기업의 주가를 분석해야 하는 사용자를 위해 설계되었으며, 대량 데이터 조회를 위한 효율적인 솔루션입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/eod-bulk?date=2024-10-22
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date* | string | 2024-10-22 |

**Sample Response:**

```json
[
	{
		"symbol": "EGS745W1C011.CA",
		"date": "2024-10-22",
		"open": "2.67",
		"low": "2.7",
		"high": "2.9",
		"close": "2.93",
		"adjClose": "2.93",
		"volume": "920904"
	}
]
```

---



### 101. Equity Offering By CIK API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/equity-offering-by-cik

**Summary:**

FMP Company Equity Offerings by CIK API를 사용하여 특정 기업이 발표한 주식 공모에 관한 상세 정보에 접근하세요. 공모 활동을 추적하고 잠재적인 투자 기회를 발굴하세요.

**About:**

FMP Company Equity Offerings by CIK API는 중앙 인덱스 키(CIK)로 식별되는 특정 기업이 발표한 모든 주식 공모의 종합 목록을 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

기업별 공모 식별: CIK 검색을 통해 관심 있는 기업이 발표한 주식 공모를 빠르게 찾고 추적합니다.
시간에 따른 공모 활동 추적: 특정 기업의 주식 공모 이력을 모니터링하여 자금 조달 활동과 전략적 움직임에 대한 인사이트를 얻습니다.
투자 기회 발굴: 주식 공모 데이터를 활용하여 잠재적 투자 기회를 식별하고, 기업의 공모 활동이 주가와 시장 지위에 미치는 영향을 파악합니다.

투자자들은 이 API를 활용하여 팔로우하는 기업들의 주식 공모 활동 정보를 실시간으로 파악함으로써 더욱 정보에 기반한 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/fundraising?cik=0001547416
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001547416 |

**Sample Response:**

```json
[
	{
		"cik": "0001547416",
		"companyName": "NJOY INC",
		"date": "2014-02-28",
		"filingDate": "2014-02-28 00:00:00",
		"acceptedDate": "2014-02-28 16:00:25",
		"formType": "D",
		"formSignification": "Notice of Exempt Offering of Securities",
		"entityName": "NJOY INC",
		"issuerStreet": "15211 N. KIERLAND BLVD., SUITE 200",
		"issuerCity": "SCOTTSDALE",
		"issuerStateOrCountry": "AZ",
		"issuerStateOrCountryDescription": "ARIZONA",
		"issuerZipCode": "85254",
		"issuerPhoneNumber": "480-397-2300",
		"jurisdictionOfIncorporation": "DELAWARE",
		"entityType": "Corporation",
		"incorporatedWithinFiveYears": null,
		"yearOfIncorporation": "",
		"relatedPersonFirstName": "CRAIG",
		"relatedPersonLastName": "WEISS",
		"relatedPersonStreet": "c/o NJOY, INC.",
		"relatedPersonCity": "SCOTTSDALE",
		"relatedPersonStateOrCountry": "AZ",
		"relatedPersonStateOrCountryDescription": "ARIZONA",
		"relatedPersonZipCode": "85254",
		"relatedPersonRelationship": "Executive Officer, Director",
		"industryGroupType": "Other",
		"revenueRange": "Decline to Disclose",
		"federalExemptionsExclusions": "06b",
		"isAmendment": false,
		"dateOfFirstSale": "2014-02-14",
		"durationOfOfferingIsMoreThanYear": false,
		"securitiesOfferedAreOfEquityType": true,
		"isBusinessCombinationTransaction": false,
		"minimumInvestmentAccepted": 0,
		"totalOfferingAmount": 71999990,
		"totalAmountSold": 71999990,
		"totalAmountRemaining": 0,
		"hasNonAccreditedInvestors": false,
		"totalNumberAlreadyInvested": 
```

---

### 102. Equity Offering Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/equity-offering-search

**Summary:**

FMP Equity Offering Search API를 사용하여 회사명 또는 주식 심볼로 주식 공모를 손쉽게 검색하세요. 최근 주식 발행에 관한 상세 정보에 접근하여 기업 자금 조달 활동을 파악하세요.

**About:**

FMP Equity Offering Search API를 통해 사용자는 최근 주식 발행 내역 및 신청 날짜를 포함한 관련 주식 공모 데이터를 빠르게 검색할 수 있습니다. 이 API는 다음과 같은 목적이 있는 투자자, 애널리스트, 컴플라이언스 담당자에게 필수적입니다:

기업 주식 공모 추적: 회사명 또는 티커 심볼로 검색하여 최근 주식 공모를 확인합니다.
발행 데이터 분석: 공모일, 회사명, CIK(중앙 인덱스 키) 번호 등 핵심 정보에 접근하여 최근 주식 발행에 대한 종합적인 시각을 확보합니다.
시장 동향 파악: API를 사용하여 자금 조달 활동을 모니터링하고, 주식 공모의 영향을 평가하며, 정보에 기반한 투자 결정을 내립니다.

이 API는 다양한 섹터에 걸친 기업들의 신규 주식 발행을 빠르게 검색할 수 있는 효율적인 방법을 제공하여 시장 이벤트를 앞서 파악할 수 있도록 합니다.

Example Use Case
투자자는 Equity Offering Search API를 사용하여 신규 주식을 발행하는 기업을 파악하고, 해당 주식 공모가 자신의 포트폴리오나 잠재적 투자에 미치는 영향을 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/fundraising-search?name=NJOY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | NJOY |

**Sample Response:**

```json
[
	{
		"cik": "0001547416",
		"name": "NJOY INC",
		"date": "2014-02-28 16:00:25"
	}
]
```

---

### 103. Equity Offering Updates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-equity-offering

**Summary:**

FMP Equity Offering Updates API를 통해 최신 주식 공모 정보를 실시간으로 파악하세요. 기업이 발행하는 신규 주식을 추적하고 면제 공모 및 수정 사항에 대한 인사이트를 얻으세요.

**About:**

FMP Equity Offering Updates API는 회사 정보, 공모 금액, 규제 신고서를 포함하여 새로 발행된 주식 증권에 관한 상세 정보를 제공합니다. 이 API는 다음과 같은 필요가 있는 투자자, 애널리스트, 시장 조사자에게 중요한 도구입니다:

신규 주식 발행 모니터링: 신규 주식을 발행하는 기업을 추적하고 최근 주식 공모 현황을 파악합니다.
공모 세부 사항 분석: 신청 날짜, 양식 유형, 산업 분류, 최소 투자 금액 등 주요 데이터에 접근합니다.
컴플라이언스 유지: 06b, 3C, 3C.1 등의 규정에 따른 면제 공모 정보를 통해 주식 발행의 법적 상태를 평가합니다.

이 API는 최신 주식 발행 현황을 지속적으로 파악하여 중요한 공모나 수정 사항을 놓치지 않도록 도와주는 매우 유용한 도구입니다.

Example Use Case
기관 투자자는 Equity Offering Updates API를 활용하여 다양한 섹터에 걸친 기업들의 새로운 주식 공모를 추적함으로써 신규 투자 기회를 발굴할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/fundraising-latest?page=0&limit=10
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 10 |
| cik | string | 0002013736 |

**Sample Response:**

```json
[
	{
		"cik": "0002103666",
		"companyName": "Evolution Ventures Minerva Fund, LP - B4",
		"date": "2026-04-08",
		"filingDate": "2026-04-08 00:00:00",
		"acceptedDate": "2026-04-08 17:30:42",
		"formType": "D/A",
		"formSignification": "Notice of Exempt Offering of Securities Amendement",
		"entityName": "Evolution Ventures Minerva Fund, LP - B4",
		"issuerStreet": "2006 196TH ST SW",
		"issuerCity": "LYNNWOOD",
		"issuerStateOrCountry": "WA",
		"issuerStateOrCountryDescription": "WASHINGTON",
		"issuerZipCode": "98036",
		"issuerPhoneNumber": "206.801.6359",
		"jurisdictionOfIncorporation": "DELAWARE",
		"entityType": "Limited Partnership",
		"incorporatedWithinFiveYears": true,
		"yearOfIncorporation": "2025",
		"relatedPersonFirstName": "N/A",
		"relatedPersonLastName": "Fund GP, LLC",
		"relatedPersonStreet": "301 North Market Street, Suite 1414",
		"relatedPersonCity": "Wilmington",
		"relatedPersonStateOrCountry": "DE",
		"relatedPersonStateOrCountryDescription": "DELAWARE",
		"relatedPersonZipCode": "19801",
		"relatedPersonRelationship": "Director",
		"industryGroupType": "Pooled Investment Fund",
		"revenueRange": "Decline to Disclose",
		"federalExemptionsExclusions": "06b, 3C, 3C.1",
		"isAmendment": true,
		"dateOfFirstSale": "2026-01-01",
		"durationOfOfferingIsMoreThanYear": false,
		"securitiesOfferedAreOfEquityType": null,
		"isBusinessCombinationTransaction": false,
		"minimumInvestmentAccepted": 10000,
		"totalOfferingAmount": 186842,
		"totalAmountSold": 1
```

---

### 104. ESG Benchmark Comparison API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/esg-benchmark

**Summary:**

FMP ESG Benchmark Comparison API를 통해 기업 및 펀드의 ESG 성과를 평가하세요. 산업 내 ESG 선도 기업과 낙후 기업을 비교하여 정보에 기반한 책임 있는 투자 결정을 내리세요.

**About:**

FMP ESG Benchmark Comparison API를 통해 투자자와 애널리스트는 기업 및 펀드의 환경(Environmental), 사회(Social), 지배구조(Governance) 성과를 동종 업계 대비로 비교할 수 있습니다. 이 강력한 도구는 다음을 가능하게 합니다:

ESG 선도 기업 식별: 업계 동종 기업과 비교하여 ESG 성과가 우수한 기업 및 펀드를 찾습니다.
ESG 낙후 기업 발굴: ESG 성과가 뒤처지는 기업을 식별하여 투자 배분에 관한 정보에 기반한 결정을 내립니다.
ESG 개선 현황 모니터링: ESG 등급에서 큰 진전을 보이는 기업을 추적하여 긍정적인 변화와 잠재적 투자 기회를 포착합니다.

Example Use Cases

투자자의 경우: ESG 등급 상위 10% 기업을 필터링하여 지속 가능한 실천 분야의 업계 선도 기업에 집중합니다.
애널리스트의 경우: 지난 1년간 ESG 등급이 크게 상승한 기업을 검색하여 ESG 성과에서 두드러진 개선을 보이는 기업을 식별합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/esg-benchmark
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year | string | 2023 |

**Sample Response:**

```json
[
	{
		"fiscalYear": 2023,
		"sector": "APPAREL RETAIL",
		"environmentalScore": 61.36,
		"socialScore": 67.44,
		"governanceScore": 68.1,
		"ESGScore": 65.63
	}
]
```

---

### 105. ESG Investment Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/esg-search

**Summary:**

FMP ESG Investment Search API를 통해 투자를 본인의 가치관에 맞게 조정하세요. 환경(Environmental), 사회(Social), 지배구조(Governance) 점수, 성과, 논란 사항, 사업 참여 기준을 바탕으로 기업 및 펀드를 검색하세요.

**About:**

FMP ESG Investment Search API는 투자자가 환경(Environmental), 사회(Social), 지배구조(Governance) 가치관에 부합하는 기업 및 펀드를 찾을 수 있도록 설계되었습니다. 이 강력한 도구를 통해 다음을 할 수 있습니다:

ESG Scores: 투자 기준에 맞는 높은 ESG 등급을 가진 기업 및 펀드를 식별합니다.
Evaluate Performance: ESG 성과를 기반으로 투자를 필터링하여 본인의 가치관과 재무 목표에 부합하는지 확인합니다.
Assess Controversies: 논란 점수를 기준으로 필터링하여 중대한 ESG 논란에 연루된 기업 투자를 회피합니다.
Apply Business Involvement Screens: ESG 원칙에 부합하는 특정 사업 활동이나 섹터를 기준으로 기업 및 펀드를 스크리닝합니다.

Examples Use Cases

지속 가능성에 초점을 둔 투자자라면 강력한 환경 및 사회 실천을 보장하기 위해 ESG 점수 80점 이상의 기업을 검색할 수 있습니다.
환경적 영향을 우려하는 투자자라면 잠재적 리스크를 피하기 위해 ESG 논란 점수가 낮은 기업을 검색할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/esg-disclosures?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"date": "2024-12-28",
		"acceptedDate": "2025-01-30",
		"symbol": "AAPL",
		"cik": "0000320193",
		"companyName": "Apple Inc.",
		"formType": "8-K",
		"environmentalScore": 52.52,
		"socialScore": 45.18,
		"governanceScore": 60.74,
		"ESGScore": 52.81,
		"url": "https://www.sec.gov/Archives/edgar/data/320193/000032019325000007/0000320193-25-000007-index.htm"
	}
]
```

---


### 106. ESG Ratings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/esg-ratings

**Summary:**

FMP ESG Ratings API를 통해 기업과 펀드의 포괄적인 ESG 등급에 접근하세요. 환경(Environmental), 사회(Social), 지배구조(Governance) 성과 데이터를 기반으로 정보에 입각한 투자 결정을 내릴 수 있습니다.

**About:**

FMP ESG Ratings API는 기업과 펀드에 대한 상세한 ESG 등급을 제공하여, 투자자와 애널리스트가 투자의 지속 가능성과 윤리적 영향을 평가할 수 있도록 돕습니다. 이 API는 다음 용도에 필수적입니다:

ESG 성과 평가: 기업 지속 가능성 보고서, ESG 리서치 기관, 정부 기관으로부터 수집된 데이터를 바탕으로 기업 또는 펀드의 환경·사회·지배구조 기준 성과를 반영하는 ESG 등급에 접근합니다.
정보에 입각한 투자 결정: ESG 등급을 활용하여 윤리적·지속 가능 목표에 부합하는 기업과 펀드를 식별하고, 투자가 긍정적인 사회적·환경적 성과를 지원하도록 합니다.
ESG 점수 기반 필터링: 높은 ESG 등급 또는 낮은 ESG 논란 점수를 가진 기업을 필터링하도록 검색을 맞춤화하여, 특정 ESG 기준을 충족하는 기업에 집중할 수 있습니다.

이 API는 투자 전략에서 ESG 요소를 우선시하는 사회적으로 의식 있는 투자자, 금융 애널리스트, 자산 운용사에게 유용한 도구입니다.

Example Use Cases

높은 ESG 성과: 강력한 ESG 관행을 가진 기업에 관심 있는 투자자는 ESG 등급 80 이상의 기업을 필터링하여 투자가 자신의 가치관에 부합하도록 할 수 있습니다.
낮은 ESG 논란: 포트폴리오의 환경적 리스크를 최소화하려는 애널리스트는 낮은 ESG 논란 점수를 가진 기업을 필터링하여 환경적·사회적 영향과 관련된 문제가 적은 기업을 선별할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/esg-ratings?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"companyName": "Apple Inc.",
		"industry": "CONSUMER ELECTRONICS",
		"fiscalYear": 2024,
		"ESGRiskRating": "B",
		"industryRank": "4 out of 5"
	}
]
```

---

### 107. ETF & Fund Country Allocation API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/country-weighting

**Summary:**

FMP ETF & Fund Country Allocation API를 통해 ETF와 뮤추얼 펀드가 각 국가에 자산을 어떻게 배분하는지 파악하세요. 다양한 지역에 할당된 자산 비율에 대한 상세 정보를 제공하여 정보에 입각한 투자 결정을 내릴 수 있습니다.

**About:**

FMP ETF & Fund Country Allocation API는 ETF와 뮤추얼 펀드가 국가별로 자산을 어떻게 배분하는지 상세하게 분석하여 제공합니다. 이 데이터는 다음을 목표로 하는 투자자에게 필수적입니다:

지리적 익스포저 평가: 자산이 전 세계에 어떻게 분산되어 있는지 파악하여 다양한 펀드와 관련된 지리적 리스크와 기회에 대한 인사이트를 제공합니다.
국가별 투자 기회 식별: 미국, 중국 또는 신흥 시장처럼 강력한 경제 성장 잠재력을 보이는 국가에 대한 비중이 높은 펀드를 평가합니다.
포트폴리오 분산: 국가별 배분 데이터를 활용하여 국제 시장 전반에 걸쳐 투자를 균형 있게 구성하고 특정 지역에의 집중 리스크를 줄입니다.

예를 들어, 미국에 자산을 집중 배분하는 펀드에 투자하려는 경우 이 API를 통해 미국 보유 비중이 높은 ETF나 뮤추얼 펀드를 찾을 수 있습니다. 반대로 국제 시장으로 분산투자를 원한다면 해외 경제에 대한 비중이 높은 펀드를 찾는 데에도 활용할 수 있습니다.

Example Use Case
국제 분산투자를 통해 리스크를 최소화하려는 투자자는 ETF & Fund Country Allocation API를 사용하여 신흥 시장이나 아시아, 유럽 등 특정 지역에 강한 익스포저를 가진 펀드를 식별할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf/country-weightings?symbol=SPY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | SPY |

**Sample Response:**

```json
[
	{
		"country": "United States",
		"weightPercentage": "97.29%"
	}
]
```

---

### 108. ETF & Fund Holdings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/holdings

**Summary:**

FMP ETF & Fund Holdings API를 사용하여 ETF와 뮤추얼 펀드 내에 보유된 자산의 상세 내역을 확인하세요. 포트폴리오 내 특정 증권과 그 비중에 대한 실시간 데이터에 접근하여 자산 구성과 펀드 전략에 대한 인사이트를 얻을 수 있습니다.

**About:**

FMP ETF & Fund Holdings API는 ETF와 뮤추얼 펀드를 구성하는 기초 자산에 대한 포괄적인 정보를 제공합니다. 이 API는 다음이 필요한 투자자와 애널리스트에게 매우 중요합니다:

상세 포트폴리오 인사이트: ETF 또는 뮤추얼 펀드 내에 보유된 특정 자산에 대한 가시성을 확보하세요. 자산명, 심볼, ISIN, 시장 가치, 비중 등의 정보가 포함됩니다. 이를 통해 투자자는 펀드의 특정 주식, 섹터 또는 시장에 대한 익스포저를 파악할 수 있습니다.
실시간 업데이트: 펀드 보유 종목에 대한 최신 정보를 확인하세요. API는 실시간 업데이트를 제공하여 항상 가장 최신의 펀드 구성 데이터에 접근할 수 있습니다.
투자 전략 분석: 보유 데이터를 활용하여 다양한 ETF와 뮤추얼 펀드의 투자 전략을 평가하세요. 증권과 각각의 비중을 분석하여 잠재적 리스크와 기회에 대한 정보에 입각한 결정을 내릴 수 있습니다.

예를 들어, SPY ETF에 관심 있는 투자자는 이 API를 통해 Apple Inc.(AAPL)의 보유 주식 수, 시장 가치, 펀드 내 비중을 확인하여 기술 섹터에 대한 익스포저를 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf/holdings?symbol=SPY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | SPY |

**Sample Response:**

```json
[
	{
		"symbol": "SPY",
		"asset": "AAPL",
		"name": "APPLE INC",
		"isin": "US0378331005",
		"securityCusip": "037833100",
		"sharesNumber": 188106081,
		"weightPercentage": 7.137,
		"marketValue": 44744793487.47,
		"updatedAt": "2025-01-16 05:01:09",
		"updated": "2025-02-04 19:02:31"
	}
]
```

---

### 109. ETF & Mutual Fund Information API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/information

**Summary:**

FMP ETF & Mutual Fund Information API를 통해 ETF와 뮤추얼 펀드에 대한 포괄적인 데이터에 접근하세요. 티커 심볼, 펀드명, 보수율, 운용 자산 규모 등 핵심 세부 정보를 조회할 수 있습니다.

**About:**

FMP ETF & Mutual Fund Information API는 ETF와 뮤추얼 펀드의 재무적·구조적 정보를 상세하게 제공합니다. 이 API를 통해 투자자는 다음을 수행할 수 있습니다:

펀드 비교: 티커 심볼, 펀드명, 보수율, 운용 자산 규모 등 핵심 지표를 검토하여 다양한 ETF와 뮤추얼 펀드를 비교하고 가장 비용 효율적이고 적합한 투자 옵션을 선택합니다.
투자 기회 식별: 상세 데이터를 활용하여 특정 투자 전략, 리스크 허용 범위, 재무 목표에 부합하는 ETF와 뮤추얼 펀드를 발굴합니다.
투자 목표 이해: 다양한 ETF와 뮤추얼 펀드의 목적과 전략에 대해 파악하여 자산 유형, 섹터 익스포저, 보수율을 기준으로 포트폴리오 편입 적합성을 평가합니다.

예를 들어, 투자자는 이 API를 통해 다양한 ETF와 뮤추얼 펀드의 보수율을 비교하거나, 운용 자산 규모가 큰 펀드를 찾거나, 섹터 비중을 분석하여 투자가 시장 전망과 일치하는지 확인할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf/info?symbol=SPY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | SPY |

**Sample Response:**

```json
[
	{
		"symbol": "SPY",
		"name": "SPDR S&P 500 ETF Trust",
		"description": "The Trust seeks to achieve its investment objective by holding a portfolio of the common stocks that are included in the index (the "Portfolio"), with the weight of each stock in the Portfolio substantially corresponding to the weight of such stock in the index.",
		"isin": "US78462F1030",
		"assetClass": "Equity",
		"securityCusip": "78462F103",
		"domicile": "US",
		"website": "https://www.ssga.com/us/en/institutional/etfs/spdr-sp-500-etf-trust-spy",
		"etfCompany": "SPDR",
		"expenseRatio": 0.0945,
		"assetsUnderManagement": 633120180000,
		"avgVolume": 46396400,
		"inceptionDate": "1993-01-22",
		"nav": 603.64,
		"navCurrency": "USD",
		"holdingsCount": 503,
		"updatedAt": "2024-12-03T20:32:48.873Z",
		"sectorsList": [
			{
				"industry": "Basic Materials",
				"exposure": 1.97
			},
			{
				"industry": "Communication Services",
				"exposure": 8.87
			},
			{
				"industry": "Consumer Cyclical",
				"exposure": 9.84
			}
		]
	}
]
```

---

### 110. ETF Asset Exposure API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/etf-asset-exposure

**Summary:**

FMP ETF Asset Exposure API를 통해 특정 주식을 보유한 ETF를 확인하세요. ETF 내 자산에 대한 시장 가치, 보유 주식 수, 비중 등의 상세 정보에 접근할 수 있습니다.

**About:**

FMP ETF Asset Exposure API는 다양한 ETF 내 개별 주식의 익스포저에 대한 상세 데이터를 제공합니다. 이 API는 다음 용도에 필수적입니다:

ETF 보유 종목 식별: 특정 주식을 보유한 ETF를 파악하고, 시장 가치, 보유 주식 수, ETF 내 비중 등의 세부 정보를 확인합니다.
자산 익스포저 분석: 특정 자산의 ETF 내 익스포저를 분석하는 데 데이터를 활용하여 특정 주식이 얼마나 광범위하게 보유되어 있는지와 다양한 펀드 내에서의 중요도를 파악합니다.
정보에 입각한 투자 결정: 투자자는 이 정보를 활용하여 다수의 ETF에 걸친 주식의 인기도와 비중을 평가하고, 시장 내 해당 주식의 대표성을 기반으로 매수 또는 매도 결정을 내릴 수 있습니다.

이 API는 특정 자산에 대한 시장 전반의 심리를 이해하는 데 있어 주식과 ETF 간의 관계를 탐색하려는 투자자에게 유용한 리소스입니다.

Example Use Cases
ETF 리서치: Apple Inc.(AAPL)에 관심 있는 투자자는 ETF Asset Exposure API를 사용하여 AAPL 주식을 보유한 모든 ETF를 찾을 수 있습니다. 이후 각 ETF 내 AAPL의 비중을 분석하여 해당 주식에 가장 많이 투자된 펀드를 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf/asset-exposure?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "ZECP",
		"asset": "AAPL",
		"sharesNumber": 5482,
		"weightPercentage": 5.86,
		"marketValue": 0
	}
]
```

---


### 111. ETF Holder Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/etf-holder-bulk

**Summary:**

ETF Holder Bulk API는 사용자가 상장지수펀드(ETF)가 보유한 자산 및 주식에 대한 상세 정보를 빠르게 조회할 수 있도록 합니다. 이 API는 ETF 내 각 자산의 비중과 보유 종목에 관한 핵심 재무 정보를 제공합니다.

**About:**

ETF Holder Bulk API를 통해 사용자는 다음 정보에 접근할 수 있습니다:

Comprehensive Asset Lists: ETF가 보유한 개별 주식, 채권 및 기타 증권을 포함한 모든 자산 목록을 조회합니다.

Share Information: ETF가 각 자산에 대해 보유한 주식 수를 확인하여 보유 구성 분포를 파악합니다.
Weight Percentage: ETF 내 각 자산의 비중 비율을 분석하여 전체 ETF 가치에 대한 기여도를 이해합니다.
Market Value: ETF가 보유한 각 자산의 최신 시장 가치를 조회하여 ETF 구성에 대한 완전한 그림을 얻습니다.
ISIN and CUSIP Identifiers: ISIN 또는 CUSIP 식별자로 자산을 식별하여 보다 정밀한 추적과 리서치를 수행합니다.

ETF Holder Bulk API는 ETF 구성, 자산 배분, 잠재적 리스크 또는 기회를 분석해야 하는 금융 애널리스트, 기관 투자자, 포트폴리오 매니저에게 필수적인 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf-holder-bulk?part=1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| part* | string | 1 |

**Sample Response:**

```json
[
	{
		"symbol": "EXCH.AS",
		"name": "SAMSUNG ELECTRO MECHANICS LTD",
		"sharesNumber": "15514",
		"asset": "009150.KS",
		"weightPercentage": "0.09611",
		"cusip": "",
		"isin": "KR7009150004",
		"marketValue": "1553142.49",
		"lastUpdated\"": "2024-09-06\""
	}
]
```

---

### 112. ETF Price Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-etf-quotes

**Summary:**

FMP ETF Price Quotes API를 통해 상장지수펀드(ETF)의 실시간 가격 시세를 조회하세요. 다양한 ETF의 현재 가격, 성과 변동 및 핵심 데이터를 추적할 수 있습니다.

**About:**

FMP ETF Price Quotes API를 통해 투자자는 ETF의 실시간 가격 정보와 성과 업데이트에 접근할 수 있습니다. 이 API는 다음을 원하는 분들에게 필수적입니다:

Monitor ETF Performance: 다양한 ETF의 최신 가격과 성과 지표를 지속적으로 확인합니다.
Evaluate Investment Opportunities: 실시간 가격 데이터를 활용하여 ETF의 가치를 평가하고 합리적인 투자 결정을 내립니다.
Compare ETFs: 여러 ETF의 성과를 쉽게 추적하고 비교하여 포트폴리오 전략을 최적화합니다.

이 API는 ETF 투자와 관련하여 데이터 기반의 의사결정을 내리고자 하는 투자자와 애널리스트에게 포괄적인 정보를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-etf-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "GULF",
		"price": 16.335,
		"change": 0.13,
		"volume": 3032
	}
]
```

---

### 113. ETF Sector Weighting API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/sector-weighting

**Summary:**

FMP ETF Sector Weighting API는 ETF 자산 중 각 섹터에 투자된 비율을 상세히 제공합니다. 예를 들어, 기술 섹터의 성장이 기대되는 투자자는 해당 섹터에 높은 비중을 둔 ETF에 투자하고자 할 수 있습니다.

**About:**

FMP ETF Sector Allocation API는 ETF 자산이 다양한 섹터에 걸쳐 어떻게 분배되는지에 관한 핵심 정보를 제공합니다. 이 API는 특히 다음을 원하는 투자자에게 유용합니다:

Analyze Sector Exposure: 기술, 헬스케어, 필수 소비재 등 섹터 전반에 걸쳐 ETF 자산이 어떻게 배분되는지 파악하여 리스크 프로필을 이해합니다.
Identify Sector-Focused ETFs: 투자 전략에 부합하는 섹터에 높은 비중을 둔 ETF를 찾습니다. 예를 들어, 기술 섹터의 강한 성장이 예상된다면 해당 섹터 비중이 높은 ETF를 선택할 수 있습니다.
Diversify Portfolios: 섹터 비중 데이터를 활용하여 현재 비중이 낮은 섹터에 노출된 ETF를 선택함으로써 포트폴리오를 다각화하고 전반적인 리스크를 균형 있게 조정합니다.

예를 들어, 기술주에 이미 상당한 비중을 보유한 투자자는 헬스케어나 필수 소비재에 상당한 비중을 둔 ETF를 찾아 투자를 다각화하고 섹터 특화 리스크를 완화할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf/sector-weightings?symbol=SPY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | SPY |

**Sample Response:**

```json
[
	{
		"symbol": "SPY",
		"sector": "Basic Materials",
		"weightPercentage": 1.97
	}
]
```

---

### 114. ETF Symbol Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/etfs-list

**Summary:**

FMP ETF Symbol Search API를 사용하여 상장지수펀드(ETF)의 티커 심볼과 회사명을 빠르게 검색하세요. 이 도구는 이름이나 티커로 특정 ETF를 식별하는 과정을 간소화합니다.

**About:**

FMP ETF Symbol Search API를 통해 사용자는 다양한 상장지수펀드(ETF)의 티커 심볼과 이름을 효율적으로 찾을 수 있습니다. 이 API는 다음에 필수적입니다:

Simple ETF Lookup: 최소한의 노력으로 ETF 심볼과 회사명 데이터베이스에 접근합니다. 회사명이나 일부 명칭으로 검색하면 관련 ETF 심볼을 빠르게 찾을 수 있습니다.
Fast, Accurate Data: API는 최신 정보를 제공하여 여러 거래소에 걸친 최신 ETF 심볼과 이름을 확인할 수 있습니다.
Focus on ETFs: 이 API는 ETF 관련 검색에 특화되어 있어, 이 시장 부문에 집중하는 투자자, 트레이더, 애널리스트에게 귀중한 리소스입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/etf-list
```

**Sample Response:**

```json
[
	{
		"symbol": "GULF",
		"name": "WisdomTree Middle East Dividend Fund"
	}
]
```

---

### 115. Exchange Stock Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-exchange-quotes

**Summary:**

FMP Exchange Stock Quotes API를 통해 특정 거래소에 상장된 모든 주식의 실시간 시세를 조회하세요. 전체 거래소에 걸친 가격 변동과 거래 활동을 추적할 수 있습니다.

**About:**

FMP Exchange Stock Quotes API를 통해 사용자는 특정 거래소에서 거래되는 모든 주식의 실시간 시세에 접근할 수 있습니다. 이 API는 다음에 필수적입니다:

Comprehensive Exchange Monitoring: 특정 거래소에 상장된 모든 주식을 추적하여 시장 활동 전반에 대한 완전한 시각을 제공합니다.
Real-Time Trading Data: 모든 주식의 최신 가격 시세, 거래량 및 변동 정보에 접근하여 거래 트렌드를 모니터링합니다.
Portfolio Management: 동일 거래소 내 여러 주식의 성과를 비교하여 정보에 기반한 투자 결정을 내립니다.

이 API는 특정 거래소의 거래 활동과 주식 성과에 대한 개요가 필요한 투자자, 애널리스트, 트레이더에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-exchange-quote?exchange=NASDAQ
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| exchange* | string | NASDAQ |
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "AAACX",
		"price": 6.38,
		"change": 0,
		"volume": 0
	}
]
```

---


### 116. Exchange Variants API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-exchange-variants

**Summary:**

FMP Exchange Variants API를 사용하여 특정 주식 심볼이 상장된 모든 공개 거래소를 검색하세요. 이 API를 통해 특정 유가증권이 활발하게 거래되는 모든 거래소를 빠르게 파악할 수 있습니다.

**About:**

FMP Exchange Variants API는 특정 주식이 전 세계 여러 거래소에 상장된 위치에 대한 핵심 데이터를 제공하는 강력한 도구입니다. 이 API는 다음 용도에 적합합니다:

Multi-Exchange Search: 특정 주식이 상장된 모든 공개 거래소를 손쉽게 파악하여 기업의 전 세계 거래 활동을 완전히 이해할 수 있습니다.
Detailed Stock Information: 주식이 상장된 거래소뿐만 아니라 가격, 시가총액, 거래량, 베타 등 핵심 재무 데이터도 함께 제공하여 주식에 대한 심층적인 분석이 가능합니다.
Broad Market Coverage: 주요 국제 거래소를 지원하여 다양한 지역에 상장된 유가증권을 추적하기 용이합니다.

이 API는 유가증권이 거래되는 글로벌 현황을 파악해야 하는 투자자, 트레이더, 애널리스트에게 유용한 리소스입니다.

예시 활용 사례: Apple Inc.(AAPL)을 찾는 트레이더는 Exchange Variants API를 사용하여 Apple 주식이 거래되는 거래소 목록과 함께 시가총액, 가격 범위, 평균 거래량 등 핵심 재무 데이터를 조회할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-exchange-variants?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 262.82,
		"beta": 1.109,
		"volAvg": 47424558,
		"mktCap": 3900351299800,
		"lastDiv": 1.04,
		"range": "169.21-288.62",
		"changes": 3.24,
		"companyName": "Apple Inc.",
		"currency": "USD",
		"cik": "0000320193",
		"isin": "US0378331005",
		"cusip": "037833100",
		"exchange": "NASDAQ Global Select",
		"exchangeShortName": "NASDAQ",
		"industry": "Consumer Electronics",
		"website": "https://www.apple.com",
		"description": "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide. The company offers iPhone, a line of smartphones; Mac, a line of personal computers; iPad, a line of multi-purpose tablets; and wearables, home, and accessories comprising AirPods, Apple TV, Apple Watch, Beats products, and HomePod. It also provides AppleCare support and cloud services; and operates various platforms, including the App Store that allow customers to discov...",
		"ceo": "Timothy D. Cook",
		"sector": "Technology",
		"country": "US",
		"fullTimeEmployees": "164000",
		"phone": "(408) 996-1010",
		"address": "One Apple Park Way",
		"city": "Cupertino",
		"state": "CA",
		"zip": "95014",
		"dcfDiff": 105.92261,
		"dcf": 152.32738976131944,
		"image": "https://images.financialmodelingprep.com/symbol/AAPL.png",
		"ipoDate": "1980-12-12",
		"defaultImage": false,
		"isEtf": false,
		"isActivelyTrading": true,
		"isAdr": false,
		"isFund": false
	}
]
```

---

### 117. Executive Compensation API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/executive-compensation

**Summary:**

FMP Executive Compensation API를 통해 기업 임원의 포괄적인 보상 데이터를 조회하세요. 이 API는 급여, 주식 보상, 총 보수 및 기타 관련 재무 데이터와 함께 공시 세부 정보 및 공식 문서 링크를 제공합니다.

**About:**

FMP Executive Compensation API는 상장 기업의 임원 보상에 대한 완전한 개요를 투자자, 애널리스트, 연구자에게 제공하기 위해 설계되었습니다. 이 API는 다음 용도에 유용합니다:

Executive Salary & Benefits: 연봉, 주식 보상, 보너스, 인센티브 플랜 데이터를 조회합니다.
Comprehensive Compensation Breakdown: 기본급과 추가 보상 또는 인센티브를 포함한 총 보수에 대한 상세 보고서에 접근합니다.
Filing Information: 보상 패키지의 심층 분석을 위한 주요 공시 날짜 및 SEC 공시 직접 링크가 포함됩니다.

이 API는 기업 임원이 어떻게 보상받는지에 대한 귀중한 인사이트를 제공하여, 리더십 인센티브를 이해하고 기업 거버넌스를 평가하는 데 도움을 줍니다.

예시 활용 사례: 보상 애널리스트는 Executive Compensation API를 사용하여 여러 기업의 CEO 보수를 비교하고, 급여·주식 보상·성과 인센티브 등 다양한 보상 형태가 임원 행동 및 기업 성과에 미치는 영향을 분석할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/governance-executive-compensation?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"cik": "0000320193",
		"symbol": "AAPL",
		"companyName": "Apple Inc.",
		"filingDate": "2026-01-08",
		"acceptedDate": "2026-01-08 16:31:36",
		"nameAndPosition": "Tim Cook Chief Executive Officer",
		"year": 2025,
		"salary": 3000000,
		"bonus": 0,
		"stockAward": 57535293,
		"optionAward": 0,
		"incentivePlanCompensation": 12000000,
		"allOtherCompensation": 1759518,
		"total": 74294811,
		"link": "https://www.sec.gov/Archives/edgar/data/320193/000130817926000008/0001308179-26-000008-index.htm"
	}
]
```

---

### 118. Executive Compensation Benchmark API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/executive-compensation-benchmark

**Summary:**

FMP Executive Compensation Benchmark API를 통해 다양한 산업 전반의 평균 임원 보상 데이터에 접근하세요. 이 API는 산업별 임원 보수를 비교하고 보상 트렌드 및 벤치마크를 이해하는 데 필수적인 인사이트를 제공합니다.

**About:**

FMP Executive Compensation Benchmark API는 기업, 애널리스트, 보상 컨설턴트가 산업 전반에 걸쳐 임원 보수를 비교 평가할 수 있도록 설계되었습니다. 다음 용도에 적합합니다:

Industry Benchmarking: 특정 산업 내 평균 임원 보수를 평가하여 시장 기준 금액을 파악합니다.
Compensation Trends: 다양한 섹터 간 임원 보수 차이를 파악하여 연봉 협상이나 조직 계획에 유용한 인사이트를 얻습니다.
Competitive Analysis: 산업별 보상 데이터를 비교하여 우수 인재 유치 경쟁력을 유지합니다.

이 API는 임원 보수를 업계 표준에 맞추고자 하는 HR 전문가, 보상 애널리스트, 비즈니스 리더에게 유용한 리소스입니다.

예시 활용 사례: HR 전문가는 Executive Compensation Benchmark API를 사용하여 기술 섹터와 소비재 섹터의 임원 평균 보수를 비교함으로써, 자사 리더십 팀에 적합한 경쟁력 있는 연봉 패키지를 산정하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/executive-compensation-benchmark
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year | string | 2024 |

**Sample Response:**

```json
[
	{
		"industryTitle": "ABRASIVE, ASBESTOS & MISC NONMETALLIC MINERAL PRODS",
		"year": 2024,
		"averageCompensation": 784407.5555555555
	}
]
```

---

### 119. Exponential Moving Average API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/exponential-moving-average

**Summary:**

과거 가격에 지수적으로 감소하는 가중치를 적용하는 이동 평균으로, 단순 SMA보다 최근 가격 변동에 더 민감하게 반응합니다.

**About:**

EMA는 가장 최근 종가에 가장 높은 가중치를 부여하고, 평활 계수 2 / (N + 1)을 사용하여 과거 데이터를 기하급수적으로 감쇠시킵니다. SMA보다 새로운 정보에 빠르게 반응하기 때문에 단기 크로스오버 시스템 및 모멘텀 전략에 선호되지만, 변동성이 큰 시장에서는 휩쏘(whipsaw)에 더 민감하다는 단점이 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/ema?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"ema": 254.84409682340092
	}
]
```

---

### 120. Filings Extract API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/filings-extract

**Summary:**

SEC Filings Extract API를 사용하면 공식 SEC 공시에서 상세 데이터를 직접 추출할 수 있습니다. 이 API는 회사 주식, 증권 세부 정보, 공시 링크 등 핵심 정보에 접근할 수 있어 기업 공시 분석을 보다 용이하게 합니다.

**About:**

SEC Filings Extract API는 SEC 공시에서 상세 정보를 효율적으로 조회할 수 있는 방법을 제공합니다. 공식 기업 보고서를 분석하고 소유 구조, 증권 세부 정보 및 기타 중요 데이터에 대한 인사이트를 얻어야 하는 투자자, 애널리스트, 금융 전문가에게 적합합니다.
이 API는 다음 용도에 최적화되어 있습니다:

SEC Filings Analysis: SEC 공시에서 보유 주식 수, 평가액, 증권 세부 정보 등 핵심 정보를 추출합니다.
Ownership Tracking: 제출된 보고서에 접근하여 시간 경과에 따른 기업 소유권 변동을 모니터링합니다.
Filing Comparison: 서로 다른 공시 기간의 상세 데이터를 비교하여 트렌드 및 변동 사항을 추적합니다.

이 API는 복잡한 SEC 공시 데이터에 구조화되고 간편하게 접근하는 방법을 제공하여, 시간을 절약하고 분석에 집중할 수 있도록 도와줍니다.

예시 활용 사례: 한 투자 회사는 SEC Filings Extract API를 사용하여 분기별 13F 공시에서 데이터를 추출함으로써 특정 기업의 소유권 변동을 추적합니다. 이를 통해 트렌드를 파악하고 투자 전략을 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/extract?cik=0001388838&year=2023&quarter=3
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001388838 |
| year* | string | 2023 |
| quarter* | string | 3 |

**Sample Response:**

```json
[
	{
		"date": "2023-09-30",
		"filingDate": "2023-11-13",
		"acceptedDate": "2023-11-13",
		"cik": "0001388838",
		"securityCusip": "674215207",
		"symbol": "CHRD",
		"nameOfIssuer": "CHORD ENERGY CORPORATION",
		"shares": 13280,
		"titleOfClass": "COM NEW",
		"sharesType": "SH",
		"putCallShare": "",
		"value": 2152290,
		"link": "https://www.sec.gov/Archives/edgar/data/1388838/000117266123003760/0001172661-23-003760-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/1388838/000117266123003760/infotable.xml"
	}
]
```

---


### 121. Filings Extract With Analytics By Holder API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/filings-extract-with-analytics-by-holder

**Summary:**

Filings Extract With Analytics By Holder API는 기관 투자자 공시(13F 등)에 대한 분석적 분류를 제공합니다. 이 API는 주요 기관 보유자들의 주식 이동, 투자 전략, 포트폴리오 변화에 대한 인사이트를 제공하여 그들의 투자 행동을 이해하고 주식 소유권의 중요한 변화를 추적하는 데 도움을 줍니다.

**About:**

Filings Extract With Analytics By Holder API를 통해 사용자는 기관 투자자들의 공시에서 상세한 분석 데이터를 추출할 수 있습니다. 보유 주식 수, 주식 비중 및 시가 변화, 소유 비율 등 기관 투자 전략에 대한 분석적 시각을 제공하는 다양한 중요 지표를 확인할 수 있습니다.

Institutional Investor Analysis: 뱅가드(Vanguard)와 같은 대형 기관 보유자들의 주식 포지션 및 시가 변화를 포함한 행동을 추적합니다.
Portfolio Movement Monitoring: 주식 이동 및 보유 기간 데이터를 분석하여 기관이 주식을 얼마나 오래 보유했는지, 언제 포지션을 늘리거나 줄였는지 확인합니다.
Investment Strategy Insights: 비중, 시가, 소유 비율의 변화를 살펴봄으로써 투자 전략을 파악합니다.

이 API는 기관들이 포트폴리오를 어떻게 운용하는지에 대한 세밀한 인사이트를 제공하여, 투자자와 애널리스트가 더 깊은 투자 분석을 수행할 수 있도록 데이터를 제공합니다.

Example Use Case
투자 애널리스트는 Filings Extract With Analytics By Holder API를 사용하여 뱅가드 그룹(Vanguard Group)의 애플(Apple Inc.) 주식 활동을 모니터링할 수 있습니다. 뱅가드가 보유한 주식 수량, 비중이나 시가의 변화, 그리고 포트폴리오에 해당 주식이 처음 추가된 시점을 확인할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/extract-analytics/holder?symbol=AAPL&year=2023&quarter=3&page=0&limit=10
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| year* | string | 2023 |
| quarter* | string | 3 |
| page | number | 0 |
| limit | number | 10 |

**Sample Response:**

```json
[
	{
		"date": "2023-09-30",
		"cik": "0000102909",
		"filingDate": "2023-12-18",
		"investorName": "VANGUARD GROUP INC",
		"symbol": "AAPL",
		"securityName": "APPLE INC",
		"typeOfSecurity": "COM",
		"securityCusip": "037833100",
		"sharesType": "SH",
		"putCallShare": "Share",
		"investmentDiscretion": "SOLE",
		"industryTitle": "ELECTRONIC COMPUTERS",
		"weight": 5.4673,
		"lastWeight": 5.996,
		"changeInWeight": -0.5287,
		"changeInWeightPercentage": -8.8175,
		"marketValue": 222572509140,
		"lastMarketValue": 252876459509,
		"changeInMarketValue": -30303950369,
		"changeInMarketValuePercentage": -11.9837,
		"sharesNumber": 1299997133,
		"lastSharesNumber": 1303688506,
		"changeInSharesNumber": -3691373,
		"changeInSharesNumberPercentage": -0.2831,
		"quarterEndPrice": 171.21,
		"avgPricePaid": 95.86,
		"isNew": false,
		"isSoldOut": false,
		"ownership": 8.3336,
		"lastOwnership": 8.305,
		"changeInOwnership": 0.0286,
		"changeInOwnershipPercentage": 0.3445,
		"holdingPeriod": 42,
		"firstAdded": "2013-06-30",
		"performance": -29671950396,
		"performancePercentage": -11.7338,
		"lastPerformance": 38078179274,
		"changeInPerformance": -67750129670,
		"isCountedForPerformance": true
	}
]
```

---

### 122. Financial Estimates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-estimates

**Summary:**

FMP Financial Estimates API를 통해 주식 종목에 대한 애널리스트 재무 추정치를 조회할 수 있습니다. 투자 결정에 도움이 되도록 업계 애널리스트들이 예측한 매출, 주당순이익(EPS) 등 핵심 재무 지표의 예상치를 확인할 수 있습니다.

**About:**

FMP Financial Estimates API는 기업의 예상 실적을 더 깊이 이해하고자 하는 투자자에게 매우 유용한 리소스입니다. 주요 금융 애널리스트들의 예측을 수집하여 다음과 같은 핵심 인사이트를 제공합니다:

Revenue Projections: 기업의 미래 매출 추정치를 제공하여 예상 성장 추세를 파악할 수 있습니다.
Earnings Per Share (EPS) Forecasts: 기업의 미래 수익에 대한 애널리스트 예측치를 제공하며, 수익성 평가에 매우 중요합니다.
Consensus Metrics: 여러 애널리스트의 컨센서스 추정치를 확인하여 시장 기대치에 대한 종합적인 전망을 제공합니다.
Investment Planning: 이 추정치를 활용하여 기업의 예상 실적을 벤치마킹하고, 잠재적으로 고평가 또는 저평가된 주식을 식별하며 투자 전략을 정교화할 수 있습니다.

Financial Estimates API는 시장 예측을 기반으로 보다 정확한 재무 모델을 구축하거나 합리적인 투자 결정을 내리고자 하는 투자자, 트레이더, 금융 애널리스트에게 이상적인 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/analyst-estimates?symbol=AAPL&period=annual&page=0&limit=10
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| period* | string | annualquarter |
| page | number | 0 |
| limit | number | 10 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2029-09-28",
		"revenueLow": 483092500000,
		"revenueHigh": 483093500000,
		"revenueAvg": 483093000000,
		"ebitdaLow": 155952166036,
		"ebitdaHigh": 155952488856,
		"ebitdaAvg": 155952327446,
		"ebitLow": 140628295747,
		"ebitHigh": 140628586847,
		"ebitAvg": 140628441297,
		"netIncomeLow": 139446957701,
		"netIncomeHigh": 157185372990,
		"netIncomeAvg": 149150359609,
		"sgaExpenseLow": 31694652812,
		"sgaExpenseHigh": 31694718420,
		"sgaExpenseAvg": 31694685616,
		"epsAvg": 9.68,
		"epsHigh": 10.20148,
		"epsLow": 9.05024,
		"numAnalystsRevenue": 16,
		"numAnalystsEps": 6
	}
]
```

---

### 123. Financial Ratios API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/metrics-ratios

**Summary:**

Financial Ratios API를 사용하여 기업의 재무 성과를 분석할 수 있습니다. 이 API는 수익성, 유동성, 효율성 비율을 상세히 제공하여 다양한 지표를 통해 기업의 운영 및 재무 건전성을 평가할 수 있습니다.

**About:**

Financial Ratios API는 투자자, 애널리스트, 연구자가 기업 성과를 평가하는 데 도움이 되는 핵심 비율을 제공합니다. 매출총이익률, 순이익률과 같은 수익성 지표, 유동비율과 당좌비율 같은 유동성 지표, 자산회전율과 재고회전율과 같은 효율성 지표를 포함합니다. 이 API는 기업의 재무 건전성과 운영 효율성에 대한 종합적인 시각을 제공합니다.

Profitability Ratios: 순이익률 및 자기자본이익률(ROE)과 같은 지표를 통해 기업의 수익 창출 능력에 대한 인사이트를 얻을 수 있습니다.
Liquidity Ratios: 유동비율 및 당좌비율을 사용하여 기업이 단기 부채를 얼마나 잘 이행할 수 있는지 파악합니다.
Efficiency Ratios: 자산회전율 및 재고회전율과 같은 지표로 기업이 자산을 얼마나 효과적으로 활용하는지 평가합니다.
Debt Ratios: 부채비율 및 이자보상비율과 같은 비율을 통해 기업의 레버리지 및 부채 관리를 평가합니다.

이 API는 재무 비율을 분석하고 기업의 재무 성과를 기반으로 합리적인 의사 결정을 내리고자 하는 투자자와 애널리스트에게 필수적인 도구입니다.

Example Use Case
포트폴리오 매니저는 Financial Ratios API를 사용하여 동일 업종 내 기업들 간의 유동성 비율을 비교함으로써, 재무적으로 더 안정적이고 운영 효율성이 높은 기업을 식별하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ratios?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"grossProfitMargin": 0.4620634981523393,
		"ebitMargin": 0.31510222870075566,
		"ebitdaMargin": 0.3443707085043538,
		"operatingProfitMargin": 0.31510222870075566,
		"pretaxProfitMargin": 0.3157901466620635,
		"continuousOperationsProfitMargin": 0.23971255769943867,
		"netProfitMargin": 0.23971255769943867,
		"bottomLineProfitMargin": 0.23971255769943867,
		"receivablesTurnover": 5.903038811648023,
		"payablesTurnover": 3.0503480278422272,
		"inventoryTurnover": 28.870710952511665,
		"fixedAssetTurnover": 8.560310858143607,
		"assetTurnover": 1.0713874732862074,
		"currentRatio": 0.8673125765340832,
		"quickRatio": 0.8260068483831466,
		"solvencyRatio": 0.3414634938155374,
		"cashRatio": 0.16975259648963673,
		"priceToEarningsRatio": 37.287278415656736,
		"priceToEarningsGrowthRatio": -45.93792700808932,
		"forwardPriceToEarningsGrowthRatio": -45.93792700808932,
		"priceToBookRatio": 61.37243774486391,
		"priceToSalesRatio": 8.93822887866815,
		"priceToFreeCashFlowRatio": 32.12256867269569,
		"priceToOperatingCashFlowRatio": 29.55638142954995,
		"debtToAssetsRatio": 0.29215025480848267,
		"debtToEquityRatio": 1.872326602282704,
		"debtToCapitalRatio": 0.6518501763673821,
		"longTermDebtToCapitalRatio": 0.6009110021023125,
		"financialLeverageRatio": 6.408779631255487,
		"workingCapitalTurnoverRatio": -31.099932397502684,
		"operatingCashFlowRatio": 0.67040
```

---

### 124. Financial Ratios TTM API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/metrics-ratios-ttm

**Summary:**

TTM Ratios API를 통해 최근 12개월(TTM, Trailing Twelve Months) 재무 비율에 접근할 수 있습니다. 이 API는 수익성, 유동성, 효율성 비율을 포함한 지난 1년간의 핵심 성과 지표를 제공합니다.

**About:**

TTM Ratios API는 기업의 재무 성과에 대한 종합적인 시각을 제공하여 투자자, 애널리스트, 의사결정자에게 필수적인 도구입니다. 이 API는 다음 용도에 적합합니다:

Profitability Analysis: 매출총이익률, 순이익률, EBITDA 마진과 같은 지표를 통해 기업이 얼마나 효율적으로 수익을 창출하는지 파악합니다.
Liquidity Assessment: 유동비율 및 당좌비율과 같은 비율을 통해 기업의 단기 부채 이행 능력을 평가합니다.
Efficiency Insight: 자산회전율 및 재고회전율 등 핵심 효율성 비율을 통해 기업이 자산과 부채를 얼마나 잘 관리하는지 살펴봅니다.
Leverage Evaluation: 부채비율 및 재무 레버리지 비율과 같은 지표를 통해 기업의 부채 수준과 레버리지를 평가합니다.

이 API는 기업 성과의 핵심 영역에 걸친 인사이트를 제공하며, 지난 12개월의 추세를 분석하여 사용자가 더 합리적인 의사 결정을 내릴 수 있도록 지원합니다.

Example Use Case
투자자는 TTM Ratios API를 사용하여 애플(Apple)의 유동성 및 수익성 비율을 분석하고, 최근 12개월 재무 성과를 기반으로 해당 기업에 투자할지 여부를 결정하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ratios-ttm?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"grossProfitMarginTTM": 0.46518849807964424,
		"ebitMarginTTM": 0.3175535678188801,
		"ebitdaMarginTTM": 0.34705882352941175,
		"operatingProfitMarginTTM": 0.3175535678188801,
		"pretaxProfitMarginTTM": 0.31773296947645036,
		"continuousOperationsProfitMarginTTM": 0.24295027289266222,
		"netProfitMarginTTM": 0.24295027289266222,
		"bottomLineProfitMarginTTM": 0.24295027289266222,
		"receivablesTurnoverTTM": 6.673186524129093,
		"payablesTurnoverTTM": 3.4187853335486995,
		"inventoryTurnoverTTM": 30.626103313558097,
		"fixedAssetTurnoverTTM": 8.590592372311098,
		"assetTurnoverTTM": 1.1501809145995903,
		"currentRatioTTM": 0.9229383853427077,
		"quickRatioTTM": 0.8750666712845911,
		"solvencyRatioTTM": 0.3888081578786054,
		"cashRatioTTM": 0.20987774044955496,
		"priceToEarningsRatioTTM": 32.889608822880916,
		"priceToEarningsGrowthRatioTTM": 9.104441715061135,
		"forwardPriceToEarningsGrowthRatioTTM": 9.104441715061135,
		"priceToBookRatioTTM": 47.370141231313106,
		"priceToSalesRatioTTM": 7.958949686678795,
		"priceToFreeCashFlowRatioTTM": 32.04339747098139,
		"priceToOperatingCashFlowRatioTTM": 29.201395167968677,
		"debtToAssetsRatioTTM": 0.28132292892744526,
		"debtToEquityRatioTTM": 1.4499985020521886,
		"debtToCapitalRatioTTM": 0.5918364851397372,
		"longTermDebtToCapitalRatioTTM": 0.557055084464615,
		"financialLeverageRatioTTM": 5.154213727193745,
		"workingCapitalTurnoverRatioTTM": -22.92267593397046,
		"operatingCashFlowRatioTTM": 0.750140
```

---

### 125. Financial Reports Dates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-reports-dates

**About:**

Financial Reports Dates API는 특정 종목의 재무 보고서 제출 날짜를 조회할 수 있는 엔드포인트입니다. 회계연도 및 분기별 보고서 날짜와 함께 JSON 및 XLSX 형식의 보고서 다운로드 링크를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-reports-dates?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2025,
		"period": "Q1",
		"linkXlsx": "https://financialmodelingprep.com/stable/financial-reports-json?symbol=AAPL&year=2025&period=Q1&apikey=YOUR_API_KEY",
		"linkJson": "https://financialmodelingprep.com/stable/financial-reports-xlsx?symbol=AAPL&year=2025&period=Q1&apikey=YOUR_API_KEY"
	}
]
```

---


### 126. Financial Reports Form 10-K JSON API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-reports-form-10-k-json

**Summary:**

FMP 연간 보고서 Form 10-K API를 통해 포괄적인 연간 보고서에 접근하세요. SEC에 제출된 기업의 재무 성과, 사업 운영, 위험 요소에 관한 상세 정보를 확인할 수 있습니다.

**About:**

FMP 연간 보고서 Form 10-K API는 투자자, 애널리스트, 연구자에게 미국 상장 기업이 증권거래위원회(SEC)에 의무적으로 제출하는 연간 보고서에 직접 접근할 수 있는 수단을 제공합니다. 이 API는 다음과 같은 용도에 매우 유용합니다:

In-Depth Financial Analysis: Form 10-K에 포함된 상세 재무제표와 데이터에 접근하여 기업의 재무 건전성과 지난 회계연도 성과를 평가합니다.
Understanding Business Operations: Form 10-K에 공시된 기업의 사업 전략, 주요 시장, 운영상 과제 등 운영 현황에 대한 인사이트를 얻습니다.
Assessing Risk Factors: Form 10-K의 위험 요소 섹션을 검토하여 기업이 직면한 잠재적 도전과 불확실성을 파악하고 투자 결정에 활용합니다.

FMP 연간 보고서 Form 10-K API는 이러한 포괄적인 보고서를 손쉽게 조회하고 분석할 수 있도록 하여, 기업의 재무 및 운영 현황을 완전히 파악할 수 있게 해줍니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-reports-json?symbol=AAPL&year=2022&period=FY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| year* | number | 2022 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"period": "FY",
		"year": "2022",
		"Cover Page": [
			{
				"Cover Page - USD ($) shares in Thousands, $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Oct. 14, 2022",
					"Mar. 25, 2022"
				]
			},
			{
				"Entity Information [Line Items]": [
					" ",
					" ",
					" "
				]
			}
		],
		"Auditor Information": [
			{
				"Auditor Information": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022"
				]
			},
			{
				"Auditor Information [Abstract]": [
					" "
				]
			}
		],
		"CONSOLIDATED STATEMENTS OF OPER": [
			{
				"CONSOLIDATED STATEMENTS OF OPERATIONS - USD ($) shares in Thousands, $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Sep. 25, 2021",
					"Sep. 26, 2020"
				]
			},
			{
				"Net sales": [
					394328,
					365817,
					274515
				]
			}
		],
		"CONSOLIDATED STATEMENTS OF COMP": [
			{
				"CONSOLIDATED STATEMENTS OF COMPREHENSIVE INCOME - USD ($) $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Sep. 25, 2021",
					"Sep. 26, 2020"
				]
			},
			{
				"Statement of Comprehensive Income [Abstract]": [
					" ",
					" ",
					" "
				]
			}
		],
		"CONSOLIDATED BALANCE SHEETS": [
			{
				"CONSOLIDATED BALANCE SHEETS - USD ($) $ in Millions": [
					"Sep. 24, 2022",
					"Sep. 25, 2021"
				]
			},
			{
				"Current assets:": [
					" ",
					"
```

---

### 127. Financial Reports Form 10-K XLSX API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-reports-form-10-k-xlsx

**Summary:**

Financial Reports Form 10-K XLSX API를 통해 상세한 10-K 보고서를 XLSX 형식으로 다운로드하세요. 스프레드시트 친화적인 형식으로 기업의 연간 재무 데이터에 손쉽게 접근하고 분석할 수 있습니다.

**About:**

Financial Reports Form 10-K XLSX API는 사용자가 10-K 재무 보고서를 Excel에서 열 수 있는 형식으로 다운로드할 수 있게 해줍니다. 이를 통해 다음이 가능합니다:

Detailed Financial Analysis: Excel의 내장 분석 도구를 활용하여 손익계산서, 대차대조표, 현금흐름표를 포함한 포괄적인 재무 데이터를 확인합니다.
Flexible Data Usage: 데이터를 사용자 맞춤으로 변환하고 추가 분석을 수행하여 재무 모델 구축이나 추세 추적에 활용합니다.
Efficient Reporting: 10-K 보고서 데이터를 기반으로 재무 요약, 피벗 테이블, 기타 시각화 자료를 작성합니다.
Historical Data Access: 이전 회계연도 보고서를 다운로드하여 상세한 과거 데이터 비교를 수행합니다.

이 API는 스프레드시트에서 재무 데이터를 손쉽게 다룰 수 있게 하여 분석 및 보고 워크플로우를 간소화합니다.

Example Use Case
재무 애널리스트는 Apple의 2022년 10-K 보고서를 XLSX 형식으로 다운로드하여 재무 모델에 데이터를 손쉽게 가져오고 회계연도의 추세를 분석할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-reports-xlsx?symbol=AAPL&year=2022&period=FY
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| year* | number | 2022 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"period": "FY",
		"year": "2022",
		"Cover Page": [
			{
				"Cover Page - USD ($) shares in Thousands, $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Oct. 14, 2022",
					"Mar. 25, 2022"
				]
			},
			{
				"Entity Information [Line Items]": [
					" ",
					" ",
					" "
				]
			}
		],
		"Auditor Information": [
			{
				"Auditor Information": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022"
				]
			},
			{
				"Auditor Information [Abstract]": [
					" "
				]
			}
		],
		"CONSOLIDATED STATEMENTS OF OPER": [
			{
				"CONSOLIDATED STATEMENTS OF OPERATIONS - USD ($) shares in Thousands, $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Sep. 25, 2021",
					"Sep. 26, 2020"
				]
			},
			{
				"Net sales": [
					394328,
					365817,
					274515
				]
			}
		],
		"CONSOLIDATED STATEMENTS OF COMP": [
			{
				"CONSOLIDATED STATEMENTS OF COMPREHENSIVE INCOME - USD ($) $ in Millions": [
					"12 Months Ended"
				]
			},
			{
				"items": [
					"Sep. 24, 2022",
					"Sep. 25, 2021",
					"Sep. 26, 2020"
				]
			},
			{
				"Statement of Comprehensive Income [Abstract]": [
					" ",
					" ",
					" "
				]
			}
		],
		"CONSOLIDATED BALANCE SHEETS": [
			{
				"CONSOLIDATED BALANCE SHEETS - USD ($) $ in Millions": [
					"Sep. 24, 2022",
					"Sep. 25, 2021"
				]
			},
			{
				"Current assets:": [
					" ",
					"
```

---

### 128. Financial Scores API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-scores

**Summary:**

Financial Health Scores API를 사용하여 기업의 재무 건전성을 평가하세요. 이 API는 알트만 Z-스코어 및 피오트로스키 스코어와 같은 핵심 지표를 제공하여 기업의 전반적인 재무 건전성과 안정성에 대한 인사이트를 제공합니다.

**About:**

Financial Health Scores API는 다양한 점수와 지표를 산출하여 기업의 재무 안정성을 상세하게 평가합니다. 이 API는 다음과 같은 용도에 적합합니다:

Bankruptcy Risk Analysis: 알트만 Z-스코어를 사용하여 기업이 재무적 어려움에 처할 가능성을 평가합니다.
Profitability and Efficiency Evaluation: 피오트로스키 스코어는 수익성과 운영 효율성을 측정하여 기업의 재무 건전성을 파악하는 데 도움을 줍니다.
Working Capital Management: 운전자본 변화를 추적하여 기업이 단기 자산과 부채를 어떻게 관리하는지 파악합니다.
Leverage and Capital Structure: 기업의 총부채와 시가총액 간의 관계를 평가하여 재무 레버리지를 분석합니다.

이 API는 기업의 재무 건전성을 평가하여 합리적인 투자 결정을 내려야 하는 투자자와 애널리스트에게 강력한 도구입니다.

Example Use Case
재무 애널리스트는 Financial Health Scores API를 사용하여 Apple의 알트만 Z-스코어와 피오트로스키 스코어를 확인한 후, 고객에게 안정적인 투자처로 추천하기 전에 이를 근거로 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-scores?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"altmanZScore": 9.322985825443649,
		"piotroskiScore": 8,
		"workingCapital": -11125000000,
		"totalAssets": 344085000000,
		"retainedEarnings": -11221000000,
		"ebit": 125675000000,
		"marketCap": 3259495258000,
		"totalLiabilities": 277327000000,
		"revenue": 395760000000
	}
]
```

---

### 129. Financial Scores Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/scores-bulk

**Summary:**

FMP Scores Bulk API를 통해 여러 종목의 다양한 핵심 재무 점수와 지표를 빠르게 조회할 수 있습니다. 이 점수들은 기업 성과, 재무 건전성, 운영 효율성에 대한 귀중한 인사이트를 제공합니다.

**About:**

Scores Bulk API는 포괄적인 재무 데이터를 제공하여 사용자가 다음과 같은 핵심 지표를 분석할 수 있게 합니다:

Altman Z-Score: 이 핵심 지급능력 지표를 사용하여 기업의 파산 가능성을 평가합니다.
Piotroski Score: 9가지 기준을 바탕으로 기업의 재무 건전성과 성과를 평가합니다.
Working Capital & Total Assets: 기업의 단기 재무 건전성과 자산 규모에 대한 인사이트를 얻습니다.
Retained Earnings and EBIT: 기업의 수익성과 이익잉여금을 파악합니다.
Market Capitalization & Liabilities: 기업 가치평가와 부채 의무를 비교하여 재무 안정성을 가늠합니다.

이 API는 여러 기업을 한꺼번에 평가하고 비교해야 하는 재무 애널리스트, 투자자, 기관을 위해 설계된 효율적인 대량 재무 데이터 조회 솔루션입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/scores-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"reportedCurrency": "CNY",
		"altmanZScore": "0.29153682196643543",
		"piotroskiScore": "5",
		"workingCapital": "746131000000",
		"totalAssets": "5777858000000",
		"retainedEarnings": "255621000000",
		"ebit": "32590000000",
		"marketCap": "236751980000",
		"totalLiabilities": "5271746000000",
		"revenue": "167996000000"
	}
]
```

---

### 130. Financial Statement Growth API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-statement-growth

**Summary:**

Financial Statement Growth API를 통해 손익계산서, 대차대조표, 현금흐름표의 핵심 항목별 성장률을 분석하세요. 시간 경과에 따른 변화를 추적하여 재무 성과의 추세를 파악할 수 있습니다.

**About:**

Financial Statement Growth API는 손익계산서, 대차대조표, 현금흐름표의 핵심 재무 지표에 대한 전년 대비 성장 현황을 제공합니다. 다음과 같은 목적을 가진 애널리스트와 투자자를 위해 설계되었습니다:

Assess Revenue Trends: 기업 매출이 시간이 지남에 따라 성장했는지 혹은 감소했는지를 파악하여 전반적인 사업 건전성을 확인합니다.
Evaluate Profitability Growth: 순이익, 영업이익, EBIT의 성장률을 추적하여 수익성을 평가합니다.
Monitor Asset & Debt Changes: 자산과 부채의 증감을 파악하여 재무 관리에 대한 인사이트를 얻습니다.
Examine Cash Flow Changes: 영업현금흐름과 잉여현금흐름의 성장률을 확인하여 유동성과 자본 효율성을 분석합니다.

이 API는 재무제표 전반에 걸친 장기 추세를 파악하는 데 도움을 주어 기업의 재무 성장에 대한 포괄적인 그림을 제공합니다.

Example Use Case
투자자는 Financial Statement Growth API를 사용하여 Apple의 매출, 순이익, 잉여현금흐름의 최근 수년간 성장 추세를 분석하고, 기업의 성과 흐름을 평가하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-growth?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"revenueGrowth": 0.020219940775141214,
		"grossProfitGrowth": 0.06819471705252206,
		"ebitgrowth": 0.07799581805933456,
		"operatingIncomeGrowth": 0.07799581805933456,
		"netIncomeGrowth": -0.033599670086086914,
		"epsgrowth": -0.008116883116883088,
		"epsdilutedGrowth": -0.008156606851549727,
		"weightedAverageSharesGrowth": -0.02543458616683152,
		"weightedAverageSharesDilutedGrowth": -0.02557791606880283,
		"dividendsPerShareGrowth": 0.040371570095532654,
		"operatingCashFlowGrowth": 0.06975566069312394,
		"receivablesGrowth": 0.08621792243994425,
		"inventoryGrowth": 0.15084504817564365,
		"assetGrowth": 0.035160515396374756,
		"bookValueperShareGrowth": -0.059693251557224776,
		"debtGrowth": -0.0401393489845888,
		"rdexpenseGrowth": 0.04863780712017383,
		"sgaexpensesGrowth": 0.04672709770575967,
		"freeCashFlowGrowth": 0.092615279562982,
		"tenYRevenueGrowthPerShare": 2.3937532854122625,
		"fiveYRevenueGrowthPerShare": 0.8093292228858464,
		"threeYRevenueGrowthPerShare": 0.163506592883552,
		"tenYOperatingCFGrowthPerShare": 2.1417809176982403,
		"fiveYOperatingCFGrowthPerShare": 1.051533221923415,
		"threeYOperatingCFGrowthPerShare": 0.23720294833900227,
		"tenYNetIncomeGrowthPerShare": 2.76381558093543,
		"fiveYNetIncomeGrowthPerShare": 1.0421744314966246,
		"threeYNetIncomeGrowthPerShare": 0.07761907162786884,
		"tenYShareholdersEquityGrowthPerShar
```

---


### 131. Financial Statement Symbols List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financial-symbols-list

**Summary:**

FMP 재무제표 심볼 목록 API를 통해 재무제표가 제공되는 기업들의 종합 목록에 접근하세요. 주요 글로벌 거래소에 상장된 기업들을 찾고, 손익계산서, 대차대조표, 현금흐름표를 포함한 최신 재무 데이터를 확인할 수 있습니다.

**About:**

FMP 재무제표 심볼 목록 API는 당사 API를 통해 재무제표를 이용할 수 있는 모든 기업의 완전한 목록을 제공합니다. 이 엔드포인트는 다음 용도에 필수적입니다:

Comprehensive Company Coverage: NYSE, NASDAQ 등 주요 거래소와 국제 거래소에 상장된 기업을 포함하여 재무제표가 제공되는 모든 기업을 확인합니다.
Access to Global Financial Data: 이 광범위한 심볼 목록을 통해 전 세계 기업의 재무제표에 접근하여 글로벌 인사이트를 얻습니다.
Up-to-Date Information: 정기적으로 업데이트되는 목록으로 상장 기업의 최신 재무제표에 항상 접근할 수 있습니다.

예시: 투자자는 재무제표 심볼 목록 API를 사용하여 관심 있는 기업의 티커 심볼을 찾고, 해당 기업의 재무제표에 접근하여 최신 데이터를 바탕으로 합리적인 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/financial-statement-symbol-list
```

**Sample Response:**

```json
[
	{
		"symbol": "6898.HK",
		"companyName": "China Aluminum Cans Holdings Limited",
		"tradingCurrency": "HKD",
		"reportingCurrency": "HKD"
	}
]
```

---

### 132. FMP Articles API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/fmp-articles

**Summary:**

FMP 아티클 API를 통해 Financial Modeling Prep의 최신 기사에 접근하세요. 헤드라인, 요약문, 게재 URL을 포함한 종합적인 업데이트를 확인할 수 있습니다.

**About:**

FMP 아티클 API는 Financial Modeling Prep이 발행한 최신 기사들의 큐레이션된 목록에 대한 접근을 제공합니다. 이 엔드포인트는 다음을 제공합니다:

Headlines: 다양한 금융 주제를 다루는 최신 헤드라인으로 최신 정보를 파악합니다.
Snippets: 각 기사의 핵심 내용을 간결한 요약문으로 빠르게 파악합니다.
Publication URLs: 제공된 URL을 통해 기사 전문에 접근하여 심층적으로 읽을 수 있습니다.

이 API는 Financial Modeling Prep의 최신 트렌드, 인사이트, 분석에 대한 최신 정보를 유지할 수 있도록 정기적으로 업데이트됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/fmp-articles?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 20 |

**Sample Response:**

```json
[
	{
		"title": "Merck Shares Plunge 8% as Weak Guidance Overshadows Strong Revenue Growth",
		"date": "2025-02-04 09:33:00",
		"content": "<p><a href='https://financialmodelingprep.com/financial-summary/MRK'>Merck & Co (NYSE:MRK)</a> saw its stock sink over 8% in pre-market today after delivering mixed fourth-quarter results, with earnings missing expectations, revenue exceeding forecasts, and full-year guidance coming in below analyst estimates.</p>\n<p>For Q4, the pharmaceutical giant reported adjusted earnings per share (EPS) of $1.72, falling short of the $1.81 consensus estimate. However, revenue climbed 7% year-over-year to $1...",
		"tickers": "NYSE:MRK",
		"image": "https://cdn.financialmodelingprep.com/images/fmp-1738679603793.jpg",
		"link": "https://financialmodelingprep.com/market-news/fmp-merck-shares-plunge-8-as-weak-guidance-overshadows-strong-revenue-growth",
		"author": "Davit Kirakosyan",
		"site": "Financial Modeling Prep"
	}
]
```

---

### 133. Forex Currency Pairs API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-list

**Summary:**

FMP 외환 통화쌍 API를 통해 외환 시장에서 거래되는 모든 통화쌍의 종합 목록에 접근하세요. 통화쌍의 성과를 분석하고 추적하여 합리적인 투자 결정을 내리세요.

**About:**

FMP 외환 통화쌍 API는 글로벌 외환 시장에서 거래되는 모든 통화쌍에 대한 상세 정보를 제공합니다. 이 API는 다음 용도에 필수적입니다:

Currency Pair Identification: 외환 시장에서 거래 가능한 다양한 통화쌍을 쉽게 식별합니다. 통화쌍은 기준 통화와 상대 통화로 구성되며, 쌍의 값은 기준 통화 1단위를 구매하기 위해 필요한 상대 통화의 양을 나타냅니다.
Performance Tracking: API를 사용하여 시간 경과에 따른 다양한 통화쌍의 성과를 추적합니다. 이 데이터는 시장 트렌드와 환율 움직임을 모니터링하려는 투자자와 트레이더에게 매우 중요합니다.
Informed Decision-Making: 외환 통화쌍 API가 제공하는 종합 데이터를 활용하여 통화 거래 시 충분한 정보에 기반한 결정을 내립니다. 통화쌍의 역학을 이해함으로써 시장 상황에 맞는 전략을 개발할 수 있습니다.

이 API는 최신 통화쌍과 시장 트렌드를 지속적으로 파악해야 하는 외환 트레이더, 투자자, 분석가에게 유용한 도구입니다.

Example Use Case
외환 거래 전략: 외환 트레이더는 외환 통화쌍 API를 사용하여 EUR/USD나 GBP/JPY와 같이 거래량이 많은 통화쌍을 식별할 수 있습니다. 이러한 쌍의 성과를 시간 경과에 따라 추적함으로써 트레이더는 시장 움직임을 활용하는 전략을 개발할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/forex-list
```

**Sample Response:**

```json
[
	{
		"symbol": "ARSMXN",
		"fromCurrency": "ARS",
		"toCurrency": "MXN",
		"fromName": "Argentine Peso",
		"toName": "Mexican Peso"
	}
]
```

---

### 134. Forex News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-news

**Summary:**

FMP 외환 뉴스 API를 통해 다양한 출처의 최신 외환 뉴스 기사를 확인하세요. 종합적인 시장 인사이트를 위한 헤드라인, 요약문, 게재 URL에 접근할 수 있습니다.

**About:**

외환 뉴스 API는 통화 시장에 대한 최신 보고서를 제공하여 다음 정보를 항상 파악할 수 있게 합니다:

Currency Market Movements: 통화쌍에 영향을 미치는 주요 이벤트와 거시경제 트렌드를 포함한 외환 시장 실시간 업데이트를 받습니다.
Currency Pair Analysis: EUR/USD, GBP/USD, JPY/CHF 등 특정 통화쌍의 움직임에 대한 최신 정보를 유지하여 시장 상황을 더 잘 이해합니다.
Market Sentiment Updates: 외환 관련 뉴스를 팔로우하여 외환 부문의 투자자 심리와 시장 역학을 파악합니다.

이 API는 끊임없이 변화하는 외환 시장을 지속적으로 파악해야 하는 트레이더, 분석가, 금융 전문가에게 필수적입니다.

Example Use Case
외환 트레이더가 외환 뉴스 API를 사용하여 통화쌍에 관한 최신 뉴스를 추적함으로써 신속하고 정보에 기반한 거래 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/forex-latest?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |

**Sample Response:**

```json
[
	{
		"symbol": "XAUUSD",
		"publishedDate": "2025-02-03 23:55:44",
		"publisher": "FX Street",
		"title": "United Arab Emirates Gold price today: Gold steadies, according to FXStreet data",
		"image": "https://images.financialmodelingprep.com/news/united-arab-emirates-gold-price-today-gold-steadies-according-20250203.jpg",
		"site": "fxstreet.com",
		"text": "Gold prices remained broadly unchanged in United Arab Emirates on Tuesday, according to data compiled by FXStreet.",
		"url": "https://www.fxstreet.com/news/united-arab-emirates-gold-price-today-gold-steadies-according-to-fxstreet-data-202502040455"
	}
]
```

---

### 135. Forex Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-quote

**Summary:**

외환 견적 API를 통해 통화쌍의 실시간 외환 시세에 접근하세요. 환율과 가격 변동에 대한 최신 정보를 조회하여 시장 움직임을 모니터링하는 데 활용하세요.

**About:**

FX 시세 API는 다양한 통화쌍에 대한 실시간 환율 데이터를 제공하여 트레이더와 금융 분석가에게 필수적인 인사이트를 제공합니다. 다음과 같은 방식으로 도움이 됩니다:

Live Forex Quotes: EUR/USD 등 다양한 외환쌍의 최신 환율 및 가격 업데이트를 실시간으로 받습니다.
Detailed Price Information: 현재 가격, 당일 최고/최저가, 연간 최고/최저가, 변동률 등 핵심 데이터에 접근합니다.
Monitor Market Movements: 시가 및 종가뿐만 아니라 50일 및 200일 이동평균을 추적하여 시장 트렌드에 대한 종합적인 시각을 확보합니다.

이 API는 합리적인 결정을 내리기 위해 정확하고 시의적절한 환율 데이터가 필요한 외환 트레이더와 금융 전문가에게 필수적입니다.

Example Use Case
외환 트레이더가 FX 시세 API를 사용하여 하루 동안 EUR/USD 환율을 모니터링합니다. 실시간 가격 변동과 변동률을 추적함으로써 트레이더는 거래 타이밍을 조율하고 시장 변동에 신속하게 대응할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |

**Sample Response:**

```json
[
	{
		"symbol": "EURUSD",
		"name": "EUR/USD",
		"price": 1.17598,
		"changePercentage": -0.14754,
		"change": -0.0017376,
		"volume": 184065,
		"dayLow": 1.17371,
		"dayHigh": 1.17911,
		"yearHigh": 1.18303,
		"yearLow": 1.01838,
		"marketCap": null,
		"priceAvg50": 1.15244,
		"priceAvg200": 1.08866,
		"exchange": "FOREX",
		"open": 1.17744,
		"previousClose": 1.17772,
		"timestamp": 1753374603
	}
]
```

---


### 136. Forex Short Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-quote-short

**Summary:**

Forex Quote Snapshot API를 통해 외환 통화쌍의 간결한 시세를 빠르게 조회하세요. 실시간 환율, 가격 변동, 거래량을 한눈에 파악할 수 있습니다.

**About:**

Forex Quote Snapshot API는 외환 데이터를 간략하게 확인하려는 사용자를 위해 설계되었습니다. 군더더기 없이 다양한 통화쌍의 빠른 시세를 제공하여, 빠른 의사결정이 필요한 트레이딩 환경에 적합합니다.

Real-Time Price Data: EUR/USD 등 외환 통화쌍의 현재 가격을 즉시 조회할 수 있습니다.
Brief Overview: 최신 가격 변동 및 거래량 등 핵심 데이터를 간결한 형식으로 확인할 수 있습니다.
Efficient Monitoring: 상세 정보 없이 빠른 업데이트가 필요한 트레이더 및 애널리스트에게 이상적입니다.

이 API는 외환 시장 움직임을 빠르게 점검하고 트레이더가 신속하게 반응할 수 있도록 도와줍니다.

Example Use Case
한 통화 트레이더가 Forex Quote Snapshot API를 사용하여 하루 종일 EUR/USD 통화쌍을 모니터링하고, 가격 변동 및 거래량을 빠르게 확인하여 신속한 매매 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote-short?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |

**Sample Response:**

```json
[
	{
		"symbol": "EURUSD",
		"price": 1.17598,
		"change": -0.0017376,
		"volume": 184065
	}
]
```

---

### 137. Form 13F Filings Dates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/form-13f-filings-dates

**Summary:**

Form 13F Filings Dates API를 통해 기관 투자자의 Form 13F 제출과 관련된 날짜를 조회할 수 있습니다. 이는 특정 시점의 기관 투자자 주식 보유 현황을 추적하는 데 매우 중요하며, 그들의 투자 전략에 대한 귀중한 인사이트를 제공합니다.

**About:**

Form 13F Filings Dates API는 기관 투자자가 SEC에 Form 13F 보고서를 제출하는 시기를 추적하려는 사용자에게 이상적입니다. 이 데이터는 기관의 주식 보유 현황과 투자 트렌드를 드러내어, 투자자와 애널리스트가 특정 분기에 주요 기관들이 어떤 종목에 투자하고 있는지 파악할 수 있도록 돕습니다.
이 API는 다음 용도에 적합합니다:

Investor Monitoring: 기관 투자자가 SEC에 주식 보유 현황을 제출하는 시기를 추적합니다.
Quarterly Analysis: 분기별 기관 보유 현황 변화를 검토합니다.
Historical Research: 연도별 제출 패턴을 분석하고 기관 보유 현황의 트렌드를 파악합니다.

이 API는 기관 보유 현황의 타이밍을 간편하게 추적할 수 있는 방법을 제공하며, 투자 분석 및 시장 트렌드 이해에 유용합니다.

Example Use Case
한 애널리스트가 Form 13F Filings Dates API를 사용하여 주요 기관 투자자의 제출 날짜를 확인하고, 분기별 포트폴리오 변화를 비교하여 기관의 행동 패턴을 바탕으로 합리적인 투자 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/dates?cik=0001067983
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001067983 |

**Sample Response:**

```json
[
	{
		"date": "2024-09-30",
		"year": 2024,
		"quarter": 3
	}
]
```

---

### 138. Full Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-historical-price-eod-full

**Summary:**

FMP Comprehensive Commodities Price API를 통해 상품(원자재)의 전체 일별 종가 히스토리컬 데이터를 조회하세요. 이 API를 통해 사용자는 장기 가격 트렌드, 패턴, 시장 움직임을 상세하게 분석할 수 있습니다.

**About:**

FMP Comprehensive Commodities Price API는 시가, 고가, 저가, 종가, 거래량, 가격 변동을 포함한 다양한 상품의 상세 히스토리컬 데이터를 제공합니다. 이 API는 시간에 따른 상품 성과를 평가하고 데이터 기반 의사결정을 내리기 위해 심층적인 시장 인사이트가 필요한 투자자, 애널리스트, 트레이더를 위해 설계되었습니다.

Detailed Historical Data: 시가, 종가, 고가, 저가, 거래량, 가격 변동을 포함한 일별 종가 히스토리컬 데이터를 조회합니다.
Trend Analysis: 장기 가격 트렌드 및 시장 패턴을 분석하여 상품의 변동성과 움직임을 더 잘 이해합니다.
Comprehensive View: 가격 움직임뿐만 아니라 거래량과 변동성까지 평가하여 시장 상황의 전체적인 그림을 파악합니다.

이 API는 상품 시장의 장기 트렌드와 패턴을 평가하려는 전문가에게 강력한 도구로, 히스토리컬 데이터를 바탕으로 미래 가격 움직임 예측 또는 투자 전략 수립에 도움을 줍니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/full?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "GCUSD",
		"date": "2025-07-24",
		"open": 3398.6,
		"high": 3401.1,
		"low": 3355.2,
		"close": 3373.8,
		"volume": 174758,
		"change": -24.8,
		"changePercent": -0.72971223,
		"vwap": 3376.7
	}
]
```

---

### 139. Full Commodities Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-commodities-quotes

**Summary:**

FMP Commodities Quotes API를 통해 상품(원자재)의 실시간 시세를 조회하세요. 원유, 금, 농산물 등 다양한 상품의 최신 가격, 변동, 거래량을 추적할 수 있습니다.

**About:**

FMP Commodities Quotes API는 다양한 상품의 최신 가격 정보를 제공합니다. 이 API는 다음 용도에 필수적인 도구입니다:

Tracking Key Commodities: 원유, 금, 천연가스, 농산물 등 주요 상품의 실시간 가격을 모니터링합니다.
Making Timely Investment Decisions: 가격 변동 및 거래량 정보를 통해 적시에 매매 또는 투자 결정을 내립니다.
Market Analysis: 실시간 데이터를 활용하여 상품 시장의 트렌드와 변동을 분석하고 시장 흐름에 앞서 나갑니다.

트레이더, 투자자, 애널리스트 누구든 이 API를 통해 상품 시장에 대한 핵심 데이터를 얻을 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-commodity-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "DCUSD",
		"price": 19.89,
		"change": 0.23,
		"volume": 442
	}
]
```

---

### 140. Full Cryptocurrency Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-quote

**Summary:**

FMP Full Cryptocurrency Quote API를 통해 모든 암호화폐의 실시간 시세를 조회하세요. 현재가, 고가, 저가, 시가를 포함한 포괄적인 가격 데이터를 제공합니다.

**About:**

Full Cryptocurrency Quote API는 전 세계 거래소에서 거래되는 모든 암호화폐의 실시간 시세를 제공합니다. 이 엔드포인트는 다음과 같은 상세 정보를 제공합니다:

Current Price: 특정 암호화폐의 최신 가격을 조회합니다.

High, Low, and Open Prices: 당일 최고가, 최저가, 시가를 확인합니다.

투자자는 Full Cryptocurrency Quote API를 다음과 같이 활용할 수 있습니다:

Monitor Real-Time Prices: 전 세계에서 거래되는 모든 암호화폐의 실시간 가격을 지속적으로 확인합니다.
Track Price Movements: 시간에 따른 암호화폐 가격 움직임을 추적하여 트렌드와 패턴을 파악합니다.
Identify Investment Opportunities: 포괄적인 가격 데이터를 활용하여 잠재적인 투자 기회를 발굴합니다.
Make Informed Trading Decisions: 최신의 정확한 암호화폐 가격 데이터를 기반으로 매매 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"name": "Bitcoin USD",
		"price": 118741.16,
		"changePercentage": -0.03193323,
		"change": -37.93,
		"volume": 75302985728,
		"dayLow": 117435.22,
		"dayHigh": 119535.45,
		"yearHigh": 123091.61,
		"yearLow": 49121.24,
		"marketCap": 2344693699320,
		"priceAvg50": 109824.32,
		"priceAvg200": 98161.086,
		"exchange": "CRYPTO",
		"open": 118779.09,
		"previousClose": 118779.09,
		"timestamp": 1753374602
	}
]
```

---


### 141. Full Cryptocurrency Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-cryptocurrency-quotes

**Summary:**

FMP Full Cryptocurrency Quotes API를 통해 실시간 암호화폐 시세를 조회하세요. 다양한 디지털 자산의 실시간 가격, 거래량, 가격 변동을 추적할 수 있습니다.

**About:**

FMP Full Cryptocurrency Quotes API는 최신 거래 가격, 거래량, 가격 변동 등 암호화폐에 대한 종합적인 실시간 데이터를 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

시장 가격 모니터링: 실시간 암호화폐 가격을 추적하여 정보에 기반한 거래 결정을 내리세요.
시장 동향 분석: 실시간 변동 및 거래량 데이터를 통해 디지털 자산 시장의 잠재적 기회를 파악하세요.
포트폴리오 관리: API를 활용하여 포트폴리오 내 특정 암호화폐의 성과를 추적하고 전략을 조정하세요.

이 API는 암호화폐 시장에 대한 정확하고 최신 정보를 원하는 트레이더, 투자자, 애널리스트에게 최적화되어 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-crypto-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "00USD",
		"price": 0.03071157,
		"change": -0.0026034,
		"volume": 169600
	}
]
```

---

### 142. Full Forex Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-forex-quotes

**Summary:**

FMP Batch Forex Quote API를 통해 여러 외환 통화쌍의 실시간 시세를 조회하세요. 단일 요청으로 다양한 외환 쌍의 실시간 가격 변동 및 업데이트를 확인할 수 있습니다.

**About:**

FMP Batch Forex Quote API는 여러 통화쌍의 실시간 환율을 한 번에 추적할 수 있도록 합니다. 이 API는 여러 외환 쌍을 동시에 모니터링해야 하는 사용자에게 이상적입니다. 주요 기능은 다음과 같습니다:

다중 통화쌍 추적: 한 번의 요청으로 여러 외환 쌍의 실시간 시세를 조회하여 시장 분석을 간소화하세요.
포괄적인 외환 데이터: 전 세계 다양한 통화의 최신 가격, 가격 변동, 거래량 데이터에 접근하세요.
효율적인 시장 모니터링: 빠르게 움직이는 외환 시장에서 여러 통화쌍을 동시에 모니터링하는 트레이더나 애널리스트에게 최적화되어 있습니다.

Batch Forex Quote API는 글로벌 외환 시장 트렌드를 추적하고 여러 통화쌍의 가격 변동에 대한 최신 정보를 유지하는 강력한 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-forex-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "AEDAUD",
		"price": 0.43575,
		"change": 0.0009547891,
		"volume": 344
	}
]
```

---

### 143. Full Index Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-index-quotes

**Summary:**

FMP Stock Market Index Quotes API를 통해 주요 주식 시장 지수의 실시간 움직임을 추적하세요. 글로벌 지수의 실시간 시세에 접근하고 성과 변화를 모니터링할 수 있습니다.

**About:**

FMP Stock Market Index Quotes API는 다양한 주식 시장 지수에 대한 실시간 데이터를 제공하여 전체 시장 성과에 대한 핵심 인사이트를 제공합니다. 주요 기능은 다음과 같습니다:

실시간 지수 데이터: S&P 500, 다우존스 등 주요 주식 시장 지수의 최신 시세에 접근하세요.
가격 변동 추적: 거래일 내내 지수 가격 변화 및 등락을 실시간으로 파악하세요.
글로벌 시장 커버리지: 글로벌 시장 전반의 지수 성과를 추적하여 투자자와 애널리스트가 시장 심리와 트렌드를 평가할 수 있도록 지원합니다.

이 API는 주요 주식 시장 지수의 움직임을 지속적으로 파악해야 하는 트레이더, 투자자, 금융 전문가에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-index-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "^DJBGIE",
		"price": 4277.52,
		"change": -15.7,
		"volume": 0
	}
]
```

---

### 144. Fund & ETF Disclosures by Date API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/disclosures-dates

**Summary:**

FMP Fund & ETF Disclosures by Date API를 통해 신고 날짜를 기준으로 뮤추얼 펀드와 ETF의 상세 공시 정보를 조회하세요. 최신 신고 내역을 최신 상태로 유지하고 규제 업데이트를 효과적으로 추적할 수 있습니다.

**About:**

FMP Fund & ETF Disclosures by Date API를 통해 사용자는 신고 날짜를 지정하여 뮤추얼 펀드 및 ETF 공시 정보에 신속하게 접근할 수 있습니다. 이 API는 다음과 같은 용도에 필수적입니다:

최신 신고 추적: 특정 신고 날짜를 기준으로 공시 정보를 조회하여 최신 뮤추얼 펀드 및 ETF 신고 내역을 파악하세요. 현재 규제 신고 현황을 최신 상태로 유지하려는 애널리스트, 투자자, 컴플라이언스 담당자에게 이상적입니다.
과거 데이터 조사: 과거 분기 또는 연도의 공시 정보를 조회할 수 있어, 과거 재무 조사, 성과 추적, 컴플라이언스 검증에 유용한 도구입니다.
신고 트렌드 모니터링: 날짜별 신고를 정기적으로 검토하여 시장 트렌드를 파악하고 최근 신고가 금융 시장에 미치는 영향을 이해할 수 있습니다.

예를 들어, 투자자가 2024년 2분기에 제출된 모든 공시 정보를 추적하고자 할 수 있습니다. Fund & ETF Disclosures by Date API를 사용하면 해당 신고 정보를 신속하게 조회하고 검토하여 펀드 전략이나 보유 종목의 중요한 변화를 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/funds/disclosure-dates?symbol=VWO
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | VWO |
| cik | string | 0000036405 |

**Sample Response:**

```json
[
	{
		"date": "2024-10-31",
		"year": 2024,
		"quarter": 4
	}
]
```

---

### 145. General News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/general-news

**Summary:**

FMP General News API를 통해 다양한 소스의 최신 일반 뉴스 기사에 접근하세요. 포괄적인 뉴스 커버리지를 위한 헤드라인, 요약문, 게시 URL을 제공합니다.

**About:**

FMP General News API는 광범위한 소스의 최신 일반 뉴스 기사에 접근할 수 있도록 합니다. 이 엔드포인트에는 다음이 포함됩니다:

Headlines: 최신 시사 뉴스 헤드라인을 통해 최신 정보를 유지하세요.
Snippets: 기사의 간략한 요약을 통해 핵심 내용을 빠르게 파악하세요.
Publication URLs: 제공된 URL을 통해 전체 기사에 접근하여 상세한 정보를 확인하세요.

이 API는 매일 업데이트되어 가장 최신 뉴스를 제공합니다. 관심 있는 날짜 범위를 입력하면 해당 기간 동안 게시된 모든 일반 뉴스 기사 목록이 반환됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/general-latest?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |

**Sample Response:**

```json
[
	{
		"symbol": null,
		"publishedDate": "2025-02-03 23:51:37",
		"publisher": "CNBC",
		"title": "Asia tech stocks rise after Trump pauses tariffs on China and Mexico",
		"image": "https://images.financialmodelingprep.com/news/asia-tech-stocks-rise-after-trump-pauses-tariffs-on-20250203.jpg",
		"site": "cnbc.com",
		"text": "Gains in Asian tech companies were broad-based, with stocks in Japan, South Korea and Hong Kong advancing. Semiconductor players Advantest and Lasertec led gains among Japanese tech stocks.",
		"url": "https://www.cnbc.com/2025/02/04/asia-tech-stocks-rise-after-trump-pauses-tariffs-on-china-and-mexico.html"
	}
]
```

---


### 146. Global Exchange Market Hours API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/exchange-market-hours

**Summary:**

Global Exchange Market Hours API를 사용하여 특정 주식 거래소의 거래 시간을 조회하세요. 전 세계 거래소의 개장 및 폐장 시간을 확인하여 거래 전략을 효과적으로 수립하세요.

**About:**

FMP Global Exchange Market Hours API는 전 세계 다양한 주식 거래소의 개장 및 폐장 시간에 관한 핵심 정보를 제공합니다. 이 API를 통해 NASDAQ, NYSE 등의 거래소가 언제 열려 있는지, 해당 시간대 정보와 현재 시장 개장 여부를 추적할 수 있습니다. 주요 기능은 다음과 같습니다:

Trading Hours by Exchange: 전 세계 특정 주식 거래소의 개장 및 폐장 시간을 조회합니다.
Real-Time Market Status: 현재 시장이 거래를 위해 개장되어 있는지 폐장되어 있는지 확인합니다.
Time Zone Support: 정확한 계획 수립을 위해 각 거래소의 현지 시간대로 시장 운영 시간을 확인합니다.
Global Exchange Coverage: NASDAQ, NYSE 등 주요 주식 거래소에 대한 정보를 조회합니다.

이 API는 서로 다른 지역에 걸친 거래 전략을 관리하기 위해 시장 운영 시간을 파악해야 하는 트레이더, 애널리스트, 투자자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/exchange-market-hours?exchange=NASDAQ
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| exchange* | string | NASDAQ |
| timestamp | string | 1769527402 |

**Sample Response:**

```json
[
	{
		"exchange": "NASDAQ",
		"name": "NASDAQ",
		"openingHour": "09:30 AM -04:00",
		"closingHour": "04:00 PM -04:00",
		"timezone": "America/New_York",
		"isMarketOpen": false
	}
]
```

---

### 147. Historical Cryptocurrency Full Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-historical-price-eod-full

**Summary:**

Full Historical Cryptocurrency Data API를 통해 암호화폐의 포괄적인 일별 종가(EOD) 데이터에 접근하세요. 장기 가격 추세, 시장 움직임, 거래량을 분석하여 전략적 의사결정에 활용하세요.

**About:**

Full Historical Cryptocurrency Data API는 다음을 포함한 광범위한 과거 데이터를 제공합니다:

End-of-Day (EOD) Prices: 암호화폐의 일별 시가, 고가, 저가, 종가(OHLC) 데이터를 조회합니다.
Comprehensive Market Data: 거래량, 가격 변동, VWAP(거래량 가중 평균 가격)에 접근하여 시장 동향에 대한 인사이트를 얻습니다.
Analyze Long-Term Trends: 과거 가격 데이터를 검토하여 장기 추세, 변동성, 시장 사이클을 추적하고 투자자와 애널리스트의 더 나은 의사결정을 지원합니다.

이 API는 시장 움직임을 평가하고 추세를 파악하며 전략적 계획을 지원하고자 하는 장기 투자자, 애널리스트, 기관에 필수적인 도구입니다.

Example Use Case
장기 암호화폐 투자자는 Full Historical Cryptocurrency Data API를 활용하여 지난 한 해 동안 비트코인의 시장 성과를 분석하고, 과거 가격 추세를 바탕으로 주요 저항선과 잠재적 매수 기회를 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/full?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"date": "2025-07-24",
		"open": 118779.09,
		"high": 119535.45,
		"low": 117435.22,
		"close": 118741.16,
		"volume": 75302985728,
		"change": -37.93,
		"changePercent": -0.03193323,
		"vwap": 118570.61
	}
]
```

---

### 148. Historical Cryptocurrency Light Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/cryptocurrency-historical-price-eod-light

**Summary:**

Historical Cryptocurrency Price Snapshot API를 통해 다양한 암호화폐의 과거 일별 종가 데이터에 접근하세요. 시간 흐름에 따른 가격 및 거래량 추세를 추적하여 시장 동향을 더 잘 이해하세요.

**About:**

Historical Cryptocurrency Price Snapshot API는 다음을 제공하여 시간 경과에 따른 암호화폐 성과에 대한 핵심 인사이트를 제공합니다:

End-of-Day Prices: 암호화폐의 과거 일별 종가를 조회하여 장기 시장 추세와 패턴을 분석합니다.
Trading Volume Data: 특정 기간 동안의 시장 활동을 평가하기 위한 거래량 데이터에 접근합니다.
Price Trend Analysis: 이 데이터를 활용하여 암호화폐의 가치가 어떻게 변화했는지 검토하고 정보에 기반한 투자 결정을 내리는 데 도움을 받습니다.

이 API는 기술적 분석을 수행하거나 시장이 시간에 따라 어떻게 변화했는지 모니터링하고자 하는 트레이더, 애널리스트, 투자자에게 필수적입니다.

Example Use Case
애널리스트는 Historical Cryptocurrency Price Snapshot API를 활용하여 과거 가격 움직임을 검토하고 미래 가격 흐름에 영향을 줄 수 있는 패턴을 식별함으로써 거래 전략을 백테스팅할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/light?symbol=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | BTCUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"date": "2025-07-24",
		"price": 118741.16,
		"volume": 75302985728
	}
]
```

---

### 149. Historical Dow Jones API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-dow-jones

**Summary:**

Historical Dow Jones API를 사용하여 다우존스 산업평균지수(DJIA)의 과거 데이터에 접근하세요. 지수 구성 종목의 변경 사항을 분석하고 다양한 시기에 걸친 성과를 연구하세요.

**About:**

FMP Historical Dow Jones API는 세계에서 가장 널리 알려진 주가 지수 중 하나인 다우존스 산업평균지수의 변경 이력에 대한 상세한 기록을 제공합니다. 이 API를 통해 지수에 편입되거나 제외된 기업들에 관한 정보와 변경 사유를 조회할 수 있습니다. 이 주요 시장 지표에 대한 역사적 분석을 수행하는 모든 사람에게 매우 유용한 도구입니다. 주요 기능은 다음과 같습니다:

Company Additions & Removals: 다우존스 지수에 편입되거나 제외된 기업들에 관한 상세 데이터를 관련 날짜와 함께 조회합니다.
Reasons for Changes: 시가총액 변화나 업종 재분류 등 기업이 편입되거나 제외된 이유를 파악합니다.
Historical Composition: 시간이 지남에 따라 다우존스의 구성이 어떻게 변화했는지, 그리고 이러한 변화가 전체 지수에 어떤 영향을 미쳤는지 분석합니다.
Detailed Company Data: 지수에 편입되거나 제외된 날짜를 포함하여 특정 기업의 종목 코드, 명칭 등 정보를 조회합니다.

이 API는 다우존스의 과거 변화를 탐구하고 그 변화를 이끈 요인들을 이해하고자 하는 투자자, 시장 애널리스트, 연구자에게 이상적입니다.

Example Use Case
시장 조사자는 Historical Dow Jones API를 활용하여 지난 10년간 지수가 어떻게 변화했는지 연구할 수 있습니다. 2024년 Amazon(AMZN) 편입 및 Walgreens Boots Alliance(WBA) 제외와 같은 변경 사례를 검토함으로써, 시가총액 변화와 업종 성과 변동이 시간에 따라 다우존스에 어떤 영향을 미쳤는지 더 잘 이해할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-dowjones-constituent
```

**Sample Response:**

```json
[
	{
		"dateAdded": "November 8, 2024",
		"addedSecurity": "Nvidia",
		"removedTicker": "INTC",
		"removedSecurity": "Intel Corporation",
		"date": "2024-11-07",
		"symbol": "NVDA",
		"reason": "Market capitalization change"
	}
]
```

---

### 150. Historical Forex Full Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-historical-price-eod-full

**Summary:**

Full Historical Forex Chart API를 통해 포괄적인 외환 과거 일별 종가 데이터에 접근하세요. 시가, 고가, 저가, 종가(OHLC), 거래량, 등락률을 포함한 통화쌍 움직임에 대한 심층적인 인사이트를 얻으세요.

**About:**

Full Historical Forex Chart API는 광범위한 통화쌍에 대한 방대한 과거 가격 데이터를 제공하여 트레이더와 애널리스트가 시장 추세를 더 깊이 이해할 수 있도록 합니다. 이 데이터에는 시가, 고가, 저가, 종가뿐만 아니라 거래량, VWAP(거래량 가중 평균 가격), 등락률이 포함됩니다. 이 API는 다음 용도에 이상적입니다:

Detailed Trend Analysis: 외환 시장의 장기 추세와 패턴을 분석하기 위해 포괄적인 과거 가격 데이터를 검토합니다.
Advanced Technical Analysis: OHLC 데이터를 활용하여 기술적 지표를 적용하고 잠재적 거래 신호를 식별합니다.
Strategy Backtesting: 과거 실제 시장 조건을 사용하여 거래 전략을 검증하고 최적화하기 위한 상세한 과거 데이터에 접근합니다.

이 API는 외환 시장 움직임을 이해하고 포괄적인 데이터로 전략을 정교화하고자 하는 트레이더, 애널리스트, 포트폴리오 매니저에게 필수적인 자원입니다.

Example Use Case
포트폴리오 매니저는 Full Historical Forex Chart API를 활용하여 지난 10년간 EUR/USD 통화쌍의 일별 시가, 고가, 저가, 종가를 분석합니다. 이러한 추세를 검토함으로써 통화 익스포저 관리를 위한 보다 정보에 기반한 전략을 수립합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/full?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "EURUSD",
		"date": "2025-07-24",
		"open": 1.17744,
		"high": 1.17911,
		"low": 1.17371,
		"close": 1.17639,
		"volume": 182290,
		"change": -0.00105,
		"changePercent": -0.08917652,
		"vwap": 1.18
	}
]
```

---

### 151. Historical Forex Light Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/forex-historical-price-eod-light

**Summary:**

Historical Forex Light Chart API를 통해 과거 외환 일별 종가 데이터에 접근하세요. 다양한 통화쌍의 장기 가격 추세를 추적하여 거래 및 분석 전략을 강화하세요.

**About:**

Historical Forex Light Chart API는 광범위한 통화쌍에 대한 일별 종가 외환 데이터를 제공합니다. 이 데이터는 다음과 같은 목적을 가진 트레이더와 애널리스트에게 매우 유용합니다:

Analyze Long-Term Trends: 과거 가격 데이터를 검토하여 미래 시장 움직임에 영향을 줄 수 있는 패턴과 추세를 식별합니다.
Backtest Trading Strategies: 장기간에 걸친 시장 상황을 시뮬레이션하여 과거 데이터를 통해 거래 전략을 검증합니다.
Compare Forex Pair Performance: 시간에 따른 다양한 통화쌍의 성과를 분석하여 보다 정보에 기반한 거래 결정을 내릴 수 있도록 지원합니다.

이 API는 시장 분석 및 전략 개발을 위한 정확한 과거 데이터가 필요한 외환 트레이더, 애널리스트, 투자자에게 필수적입니다.

Example Use Case
외환 트레이더가 Historical Forex Light Chart API를 활용하여 지난 5년간 EUR/USD 통화쌍의 일별 종가를 검토합니다. 이 데이터를 분석하여 주요 지지선 및 저항선을 식별하고 거래 전략을 정교화합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/light?symbol=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | EURUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "EURUSD",
		"date": "2025-07-24",
		"price": 1.17639,
		"volume": 182290
	}
]
```

---

### 152. Historical Index Full Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-historical-price-eod-full

**Summary:**

Detailed Historical Price Data API를 사용하여 주가 지수의 포괄적인 과거 일별 종가 데이터에 접근하세요. 이 API는 상세한 금융 분석을 위해 시가, 고가, 저가, 종가, 거래량 및 추가 지표를 포함한 종합적인 정보를 제공합니다.

**About:**

FMP Detailed Historical Price Data API는 주가 지수에 대한 완전한 일별 종가 데이터를 제공하여 심층 금융 분석에 강력한 도구가 됩니다. 시가, 고가, 저가, 종가를 포함한 다양한 가격 지표와 함께 거래량, 등락률, 거래량 가중 평균 가격(VWAP)을 제공합니다. 주요 기능은 다음과 같습니다:

Complete Price Data: 특정 날짜의 주가 지수에 대한 시가, 고가, 저가, 종가에 접근합니다.
Volume Information: 거래량을 추적하여 시장 활동과 유동성을 평가합니다.
Price Movement Insights: 일별 등락폭 및 등락률을 분석하여 시장 추세를 파악합니다.
Volume-Weighted Average Price (VWAP): 각 거래일의 VWAP 데이터를 통해 성과 벤치마킹과 거래 의사결정에 활용합니다.

이 API는 모델 구축, 백테스팅 수행, 시장 추세 분석을 위한 포괄적인 과거 가격 데이터가 필요한 금융 애널리스트, 퀀트, 트레이더에게 이상적입니다.

Example Use Case
알고리즘 거래 모델을 개발하는 퀀트 애널리스트는 S&P 500 지수(^GSPC)의 완전한 과거 가격 데이터가 필요합니다. Detailed Historical Price Data API를 활용하여 각 거래일의 시가, 고가, 저가, 종가와 함께 VWAP 및 거래량 데이터를 조회할 수 있습니다. 이 상세한 정보는 모델의 예측 성능과 백테스팅 결과를 정교화하는 데 도움이 됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/full?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "^VIX",
		"date": "2026-04-08",
		"open": 20.97,
		"high": 22.17,
		"low": 19.91,
		"close": 21.04,
		"volume": 0,
		"change": 0.07,
		"changePercent": 0.33381,
		"vwap": 21.0225
	}
]
```

---

### 153. Historical Index Light Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-historical-price-eod-light

**Summary:**

Historical Price Data API를 사용하여 주가 지수의 과거 일별 종가를 조회하세요. 날짜, 가격, 거래량 등 핵심 데이터를 제공하여 시간에 따른 가격 움직임의 상세한 분석을 지원합니다.

**About:**

FMP Historical Price Data API는 사용자가 주가 지수의 일별 종가 데이터에 접근할 수 있도록 하여 과거 성과에 대한 인사이트를 제공합니다. 이 데이터를 추적함으로써 애널리스트는 시장 추세, 변동성, 주가 지수의 움직임을 더 잘 이해할 수 있습니다. 주요 기능은 다음과 같습니다:

Comprehensive Price Data: 종가, 날짜, 거래량 데이터를 포함한 주요 주가 지수의 과거 가격을 조회합니다.
Supports Multiple Indexes: 전 세계 다양한 시장의 광범위한 주가 지수 데이터에 접근합니다.
Detailed Volume Information: 각 지수의 거래량을 추적하여 시장 활동 수준에 대한 인사이트를 얻습니다.
Historical Performance Analysis: 과거 가격 움직임을 분석하여 추세, 패턴 및 잠재적 투자 기회를 식별합니다.

이 API는 시간에 따른 주가 지수 성과를 평가하기 위한 정확한 과거 데이터가 필요한 금융 애널리스트, 투자자, 시장 연구자에게 특히 유용합니다.

Example Use Case
투자 애널리스트가 S&P 500 지수(^GSPC)의 과거 추세 분석을 개발하고 있습니다. Historical Price Data API를 활용하여 특정 날짜의 일별 종가를 조회하고, 시간에 따른 거래량과 가격 움직임을 분석하여 고객에게 보다 정보에 기반한 투자 결정을 위한 분석 결과를 제시합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/light?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "^VIX",
		"date": "2026-04-08",
		"price": 21.04,
		"volume": 0
	}
]
```

---

### 154. Historical Industry PE API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-industry-pe

**Summary:**

Historical Industry P/E API를 사용하여 산업별 과거 주가수익비율(P/E ratio)에 접근하세요. 다양한 산업 전반에 걸친 밸류에이션 추세를 추적하여 시장 심리와 밸류에이션이 시간에 따라 어떻게 변화했는지 파악하세요.

**About:**

FMP Historical Industry P/E API는 Biotechnology(바이오테크놀로지), Financial Services(금융 서비스), Consumer Goods(소비재) 등 다양한 산업의 주가수익비율(P/E ratio)에 대한 상세한 과거 데이터를 제공합니다. 이 API는 사용자가 시간에 따라 산업 밸류에이션이 어떻게 변화했는지 추적할 수 있도록 하여 장기 추세와 시장 변화에 대한 인사이트를 제공합니다. 주요 기능은 다음과 같습니다:

Industry-Specific P/E Data: 특정 산업의 과거 P/E ratio에 접근하여 밸류에이션이 시간에 따라 어떻게 변화했는지 추적합니다.
Exchange-Specific Analysis: NASDAQ, NYSE 등 다양한 거래소에 걸친 산업별 P/E ratio를 조회합니다.
Long-Term Valuation Trends: 과거 데이터를 분석하여 산업 내 밸류에이션 추세와 시장 심리의 변화를 식별합니다.
Cross-Industry Comparisons: 여러 산업 간 P/E ratio를 비교하여 어떤 섹터가 저평가 또는 고평가되어 있는지 파악합니다.

이 API는 장기 투자 전략을 수립하기 위해 산업별 밸류에이션 추세를 평가해야 하는 투자자, 시장 애널리스트, 포트폴리오 매니저에게 이상적입니다.

Example Use Case
금융 애널리스트가 Historical Industry P/E API를 사용하여 NASDAQ에서 Biotechnology 산업의 과거 P/E ratio를 검토합니다. P/E ratio가 시간에 따라 어떻게 변화했는지 추적함으로써, 해당 산업의 현재 밸류에이션이 장기 시장 추세를 반영하는지 판단하고 좋은 투자 기회인지 결정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-industry-pe?industry=Biotechnology
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| industry* | string | Biotechnology |
| exchange | string | NASDAQ |
| from | string | 2024-02-01 |
| to | string | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"industry": "Biotechnology",
		"exchange": "NASDAQ",
		"pe": 10.181600321811821
	}
]
```

---

### 155. Historical Industry Performance API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-industry-performance

**Summary:**

Historical Industry Performance API를 사용하여 산업별 과거 성과 데이터에 접근하세요. 다양한 주식 거래소에 걸쳐 산업들이 시간에 따라 어떻게 변화했는지 장기 추세를 추적하고 분석하세요.

**About:**

FMP Historical Industry Performance API는 Biotechnology(바이오테크놀로지), Technology(기술), Financial Services(금융 서비스) 등 다양한 산업의 성과에 대한 상세한 과거 데이터를 제공합니다. 이 API는 사용자가 시간에 따른 산업별 성과 지표를 추적할 수 있도록 하여 시장 내 장기 추세와 움직임에 대한 인사이트를 제공합니다. 주요 기능은 다음과 같습니다:

Industry-Level Historical Data: 시간에 따른 평균 등락률을 포함한 특정 산업의 성과 데이터에 접근합니다.
Exchange-Specific Performance: NASDAQ, NYSE 등 주요 주식 거래소에서 산업이 어떻게 성과를 보였는지 조회합니다.
Long-Term Trend Analysis: 과거 데이터를 분석하여 장기 산업 추세와 시장 변화를 식별합니다.
Cross-Industry Comparisons: 시간에 따른 다양한 산업의 성과를 비교하여 성장 분야와 쇠퇴 섹터를 식별합니다.

이 API는 장기 투자 전략을 수립하기 위해 산업 수준의 성과 추세를 추적해야 하는 시장 애널리스트, 포트폴리오 매니저, 투자자에게 이상적입니다.

Example Use Case
금융 애널리스트가 Historical Industry Performance API를 사용하여 NASDAQ에서 Biotechnology 산업의 과거 성과를 추적합니다. 평균 상승률 1.15%를 기록한 특정 날짜의 데이터를 검토함으로써 해당 산업이 시간에 따라 어떻게 성과를 냈는지 평가하고 자신의 투자 전략과 부합하는지 판단할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-industry-performance?industry=Biotechnology
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| industry* | string | Biotechnology |
| exchange | string | NASDAQ |
| from | string | 2024-02-01 |
| to | string | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"industry": "Biotechnology",
		"exchange": "NASDAQ",
		"averageChange": 1.1479066960358322
	}
]
```

---

### 156. Historical Market Cap API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-market-cap

**Summary:**

FMP Historical Market Capitalization API를 사용하여 기업의 과거 시가총액 데이터에 접근하세요. 이 API는 시간에 따른 시장 가치 변화를 추적하여 기업의 성장 또는 쇠퇴에 대한 장기 평가를 가능하게 합니다.

**About:**

FMP Historical Market Capitalization API는 사용자가 데이터베이스에 등록된 모든 기업의 과거 시가총액 데이터를 조회할 수 있도록 합니다. 주요 기능은 다음과 같습니다:

Track Long-Term Performance: 과거 시가총액 데이터를 조회하여 기업의 가치가 시간에 따라 어떻게 변화했는지 분석합니다.
Identify Trends: 과거 데이터를 활용하여 지속적인 성장, 쇠퇴, 또는 변동성이 높았던 시기 등의 추세를 파악합니다.
Informed Investment Decisions: 투자자는 이 데이터를 활용하여 기업의 장기 성과를 평가하고 더 정보에 기반한 투자 결정을 내릴 수 있습니다.

이 API는 시장에서 기업의 성장 궤적이나 과거 성과를 평가하고자 하는 애널리스트, 포트폴리오 매니저, 투자자에게 이상적입니다.

Example Use Case
Apple의 과거 성과를 평가하려는 투자자는 Historical Market Capitalization API를 사용하여 과거 시가총액 데이터를 조회할 수 있습니다. 이를 통해 Apple의 밸류에이션이 시간에 따라 어떻게 변화했는지 파악하고, 성장 또는 쇠퇴 시기를 식별하며 전반적인 시장 상황과 비교할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-market-capitalization?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2026-04-08",
		"marketCap": 3818298106199
	}
]
```

---

### 157. Historical Market Sector Performance API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-sector-performance

**Summary:**

Historical Market Sector Performance API를 사용하여 과거 섹터 성과 데이터에 접근하세요. 다양한 주식 거래소에 걸쳐 각 섹터가 시간에 따라 어떻게 성과를 냈는지 검토하세요.

**About:**

FMP Historical Market Sector Performance API는 Energy(에너지), Technology(기술), Healthcare(헬스케어) 등 시장 섹터의 성과에 대한 상세한 과거 데이터를 제공합니다. 이 API는 사용자가 시간에 따른 섹터별 추세를 추적하고 분석할 수 있도록 하여 장기적인 패턴과 시장 움직임을 식별하는 데 도움을 줍니다. 주요 기능은 다음과 같습니다:

Historical Sector Performance: 시간에 따른 다양한 섹터의 평균 등락률에 대한 과거 데이터에 접근합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 다양한 주식 거래소에서 섹터의 성과를 추적합니다.
Long-Term Market Trends: 장기간에 걸친 추세와 섹터 성과 데이터를 분석하여 장기 투자 전략에 활용할 수 있는 인사이트를 제공합니다.
Cross-Sector Analysis: 여러 섹터의 성과를 비교하여 시장의 다양한 영역이 어떻게 변화했는지 파악합니다.

이 API는 추세 분석, 섹터 로테이션 전략, 장기 계획 수립을 위해 과거 섹터 성과를 검토해야 하는 금융 연구원, 포트폴리오 매니저, 투자자에게 이상적입니다.

Example Use Case
투자자가 Historical Market Sector Performance API를 사용하여 NASDAQ에서 Energy 섹터의 과거 성과를 검토합니다. 평균 변화율 0.64%를 기록한 특정 날짜의 데이터를 분석함으로써 해당 섹터의 성과 추세를 추적하고 Energy 섹터의 미래 투자에 대한 더 정보에 기반한 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-sector-performance?sector=Energy
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | string | 2024-02-01 |
| exchange | string | NASDAQ |
| sector* | string | Energy |
| to | string | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"sector": "Energy",
		"exchange": "NASDAQ",
		"averageChange": 0.6397534025664513
	}
]
```

---

### 158. Historical Nasdaq API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-nasdaq

**Summary:**

Historical Nasdaq API를 사용하여 Nasdaq 지수의 과거 데이터에 접근하세요. 지수 구성 종목의 변경 사항을 분석하고 기업 편입 및 제외를 포함하여 지수가 시간에 따라 어떻게 변화해 왔는지 살펴보세요.

**About:**

FMP Historical Nasdaq API는 Nasdaq 지수의 변경 사항에 대한 상세한 과거 기록을 제공합니다. 여기에는 기업이 편입되거나 제외된 시점과 순위 재조정 또는 시가총액 변화와 같은 변경 사유가 포함됩니다. Nasdaq의 과거 성과와 구성을 추적하고자 하는 애널리스트와 투자자에게 필수적인 도구입니다. 주요 기능은 다음과 같습니다:

Company Additions & Removals: 관련 날짜와 함께 Nasdaq에 편입되거나 제외된 기업들의 과거 데이터에 접근합니다.
Reasons for Changes: 순위 재조정이나 시가총액 변화 등 지수 변경이 발생한 이유를 파악합니다.
Historical Analysis: 시간에 따른 Nasdaq 지수 구성의 변화와 그것이 전반적인 시장 성과에 미친 영향을 분석합니다.
Detailed Company Data: Nasdaq에 편입되거나 제외된 특정 기업의 종목 코드, 명칭, 섹터 등 정보를 조회합니다.

이 API는 Nasdaq 지수의 과거 변화와 그 변화를 이끈 요인들을 연구해야 하는 투자자, 애널리스트, 연구자에게 특히 유용합니다.

Example Use Case
시장 애널리스트가 Historical Nasdaq API를 활용하여 지난 5년간 Nasdaq 지수 구성의 변화를 연구합니다. 2024년 Arm Holdings(ARM) 편입 및 Sirius XM(SIRI) 제외와 같은 데이터를 검토함으로써, 업종 변화와 시장 역학이 지수의 전반적인 성과에 어떤 영향을 미쳤는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-nasdaq-constituent
```

**Sample Response:**

```json
[
	{
		"dateAdded": "January 20, 2026",
		"addedSecurity": "Walmart",
		"removedTicker": "AZN",
		"removedSecurity": "AstraZeneca",
		"date": "2026-01-19",
		"symbol": "WMT",
		"reason": "Walmart transferred its listing from NYSE to NASDAQ and replaced AstraZeneca in the index"
	}
]
```

---

### 159. Historical Ratings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-ratings

**Summary:**

FMP Historical Ratings API를 통해 시간에 따른 재무 성과 변화를 추적하세요. 이 API는 데이터베이스 내 주식 종목의 과거 재무 등급에 대한 접근을 제공하여 특정 날짜의 등급 및 주요 재무 지표 점수를 조회할 수 있습니다.

**About:**

FMP Historical Ratings API는 기업의 재무 건전성이 시간에 따라 어떻게 변화했는지 평가하고자 하는 애널리스트와 투자자에게 이상적입니다. 주요 기능은 다음과 같습니다:

Historical Ratings: 과거 날짜의 등급을 조회하여 기업의 재무 궤적을 추적합니다.
Overall Rating: 특정 날짜의 기업 재무 건전성을 요약하는 이해하기 쉬운 등급에 접근합니다.
Discounted Cash Flow (DCF) Score: 미래 현금 흐름 잠재력 대비 과거 밸류에이션을 평가합니다.
Return on Equity (ROE) Score: 주주 자본 대비 이익 창출에 관한 과거 성과를 추적합니다.
Return on Assets (ROA) Score: 시간에 따른 자산 활용도의 변화를 조회합니다.
Debt-to-Equity Score: 기업의 자본 구조 변화를 검토합니다.
Price-to-Earnings (P/E) Score: 이익 대비 과거 주가 밸류에이션을 모니터링합니다.
Price-to-Book (P/B) Score: 과거에 시장 가격이 장부 가치와 어떻게 비교되었는지 평가합니다.

이 API는 추세 분석을 수행하고 DCF(할인현금흐름), ROE(자기자본이익률), ROA(총자산이익률), 부채비율, P/E ratio, P/B ratio 등 다양한 재무 지표가 기업 등급에 어떤 영향을 미쳤는지 이해하는 데 이상적입니다. 전체 등급과 핵심 재무 비율에 대한 개별 점수가 포함됩니다.

Example Use Case
포트폴리오 매니저는 Historical Ratings API를 사용하여 기업의 ROE(자기자본이익률)와 부채비율이 지난 5년간 어떻게 변화했는지 분석하여 장기 성과 추세를 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ratings-historical?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 1 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-04",
		"rating": "A-",
		"overallScore": 4,
		"discountedCashFlowScore": 3,
		"returnOnEquityScore": 5,
		"returnOnAssetsScore": 5,
		"debtToEquityScore": 4,
		"priceToEarningsScore": 2,
		"priceToBookScore": 1
	}
]
```

---

### 160. Historical S&P 500 API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-sp-500

**Summary:**

Historical S&P 500 API를 사용하여 S&P 500 지수의 과거 데이터를 조회하세요. 시간에 따른 추세와 성과를 이해하기 위해 기업의 편입 및 제외를 포함한 지수의 과거 변경 사항을 분석하세요.

**About:**

FMP Historical S&P 500 API는 S&P 500 지수의 변경 사항에 대한 포괄적인 과거 데이터를 제공합니다. 여기에는 기업이 편입되거나 제외된 시점과 변경 사유가 포함됩니다. 이 주요 주가 지수의 과거 성과와 추세를 추적해야 하는 애널리스트, 포트폴리오 매니저, 연구자에게 필수적인 도구입니다. 주요 기능은 다음과 같습니다:

Additions & Removals: 관련 날짜 및 변경 사유와 함께 S&P 500에 편입되거나 제외된 기업들의 과거 기록에 접근합니다.
Market Capitalization Changes: 시가총액 변화로 인한 지수 구성 변경을 추적합니다.
Historical Index Insights: 시간에 따른 S&P 500의 구성 변화와 이러한 변화가 시장 성과에 미치는 영향을 분석합니다.
Company-Specific Data: 종목 코드 및 기업명을 포함하여 편입되거나 제외된 각 기업의 세부 정보를 조회합니다.

이 API는 S&P 500 지수의 변화가 장기 시장 추세에 미치는 영향을 분석하고자 하는 금융 애널리스트, 연구자, 포트폴리오 매니저에게 특히 유용합니다.

Example Use Case
금융 연구원이 Historical S&P 500 API를 사용하여 지난 10년간 지수 구성이 어떻게 변화했는지 연구합니다. Dell Technologies(DELL)가 Etsy(ETSY)를 대체하여 최근 편입된 사례와 같은 편입 및 제외 사례를 분석함으로써, 시가총액 변화와 업종 대표성의 이동이 전반적인 지수 성과에 어떤 영향을 미치는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-sp500-constituent
```

**Sample Response:**

```json
[
	{
		"dateAdded": "March 23, 2026",
		"addedSecurity": "EchoStar Corporation",
		"removedTicker": "PAYC",
		"removedSecurity": "Paycom Software",
		"date": "2026-03-23",
		"symbol": "SATS",
		"reason": "Market capitalization change."
	}
]
```

---
### 161. Historical Sector PE API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-sector-pe

**Summary:**

Historical Sector P/E API를 사용하여 다양한 섹터의 역사적 주가수익비율(P/E ratio)에 접근하세요. 섹터 밸류에이션이 시간에 따라 어떻게 변화해 왔는지 분석하여 장기 추세와 시장 변화를 파악할 수 있습니다.

**About:**

FMP Historical Sector P/E API는 Energy, Technology, Healthcare 등 다양한 섹터의 주가수익비율(P/E ratio) 과거 데이터를 상세히 제공합니다. 이 API를 통해 섹터 밸류에이션이 시간에 따라 어떻게 변화했는지 추적하고, 장기 추세 및 시장 심리 변화에 대한 인사이트를 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

Historical P/E Ratios by Sector: 다양한 섹터의 과거 P/E ratio에 접근하여 밸류에이션 추세를 추적합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 특정 거래소의 섹터 밸류에이션을 분석합니다.
Long-Term Analysis: 과거 데이터를 검토하여 섹터 추세와 밸류에이션의 변화를 파악합니다.
Cross-Sector Comparisons: 여러 섹터의 P/E ratio를 비교하여 상대적 밸류에이션과 시장 변화를 더 깊이 이해합니다.

이 API는 장기 투자 전략을 위해 섹터 수준의 밸류에이션 추세를 분석해야 하는 시장 분석가, 포트폴리오 매니저, 투자자에게 적합합니다.

Example Use Case
포트폴리오 매니저가 Historical Sector P/E API를 활용하여 NASDAQ의 Energy 섹터 과거 P/E ratio를 검토합니다. 시간에 따른 P/E ratio 변화를 분석함으로써 해당 섹터의 밸류에이션이 어떻게 변화해 왔는지 평가하고, 향후 투자에 대한 합리적인 의사결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-sector-pe?sector=Energy
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | string | 2024-02-01 |
| exchange | string | NASDAQ |
| sector* | string | Energy |
| to | string | 2024-03-01 |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"sector": "Energy",
		"exchange": "NASDAQ",
		"pe": 14.411400922841464
	}
]
```

---

### 162. Historical Stock Grades API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-grades

**Summary:**

FMP Historical Grades API를 통해 애널리스트 등급의 종합적인 기록에 접근하세요. 특정 주식 symbol에 대한 애널리스트 평가의 과거 변화를 추적할 수 있는 도구입니다.

**About:**

FMP Historical Grades API는 과거에 애널리스트들이 특정 주식을 어떻게 평가했는지 심층적으로 파악할 수 있게 해줍니다. 이 API는 다음과 같은 용도에 적합합니다:

Trend Analysis: 투자자는 과거 평가 데이터를 활용하여 특정 주식에 대한 시장 심리의 장기 추세를 파악하고, 향후 주가 움직임을 예측하는 데 도움을 받을 수 있습니다.
Investment Strategy Optimization: 시간에 따른 애널리스트 심리 변화를 추적하여, 애널리스트들이 점점 더 낙관적(bullish) 또는 비관적(bearish)으로 변해가는 흐름에 따라 투자 전략을 조정할 수 있습니다.
Benchmarking Performance: 주식의 과거 평가 등급과 실제 성과를 비교하여, 해당 주식이 기대에 얼마나 부응했는지 더 깊이 이해할 수 있습니다.
Market Sentiment Tracking: API를 활용하여 매수(buy), 보유(hold), 매도(sell) 등급이 어떻게 변화했는지 분석하고, 특정 주식에 대한 시장의 전반적인 신뢰도 또는 신중함의 흐름을 파악합니다.

이 API는 투자자에게 과거 맥락을 제공하여, 장기적인 재무 분석과 의사결정에 유용한 도구로 활용됩니다.

Example Use Case
포트폴리오 매니저는 Historical Grades API를 활용하여 특정 주식에 대한 애널리스트 심리 변화를 관찰하고, 진화하는 시장 전망을 바탕으로 투자 전략을 조정하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/grades-historical?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-01",
		"analystRatingsBuy": 8,
		"analystRatingsHold": 14,
		"analystRatingsSell": 2,
		"analystRatingsStrongSell": 2
	}
]
```

---

### 163. Holder Performance Summary API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/holder-performance-summary

**Summary:**

Holder Performance Summary API는 기관 투자자의 주식 보유 현황을 기반으로 한 성과 인사이트를 제공합니다. 이 데이터를 통해 기관 보유자의 성과, 포트폴리오 변화, 그리고 S&P 500 등 벤치마크 대비 성과를 추적할 수 있습니다.

**About:**

Holder Performance Summary API는 시장 가치 변화, 포트폴리오 회전율, 벤치마크 대비 상대적 성과 등 기관 보유자의 성과 지표를 확인할 수 있게 해줍니다. 이 API는 다음과 같은 용도에 적합합니다:

Institutional Investor Analysis: 주식 선택, 보유 변화, 시장 가치를 기반으로 기관 투자자의 성과를 추적합니다.
Portfolio Turnover Analysis: 기관이 얼마나 자주 증권을 매수 또는 매도하는지 파악하여 거래 전략에 대한 인사이트를 얻습니다.
Performance Benchmarking: 1년, 3년, 5년 등 다양한 기간에 걸쳐 기관의 성과를 S&P 500 및 기타 벤치마크와 비교합니다.

이 API는 기관 보유자의 시간에 따른 성과를 종합적으로 파악할 수 있게 해주어, 투자자와 분석가가 시장의 주요 플레이어를 추적하는 데 도움을 줍니다.

Example Use Case
투자 매니저는 Holder Performance Summary API를 활용하여 Berkshire Hathaway의 지난 5년간 성과를 분석하고, S&P 500과 비교하여 해당 투자 전략이 얼마나 효과적이었는지 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/holder-performance-summary?cik=0001067983&page=0
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001067983 |
| page | number | 0 |

**Sample Response:**

```json
[
	{
		"date": "2024-09-30",
		"cik": "0001067983",
		"investorName": "BERKSHIRE HATHAWAY INC",
		"portfolioSize": 40,
		"securitiesAdded": 3,
		"securitiesRemoved": 4,
		"marketValue": 266378900503,
		"previousMarketValue": 279969062343,
		"changeInMarketValue": -13590161840,
		"changeInMarketValuePercentage": -4.8542,
		"averageHoldingPeriod": 18,
		"averageHoldingPeriodTop10": 31,
		"averageHoldingPeriodTop20": 27,
		"turnover": 0.175,
		"turnoverAlternateSell": 13.9726,
		"turnoverAlternateBuy": 1.1974,
		"performance": 17707926874,
		"performancePercentage": 6.325,
		"lastPerformance": 38318168662,
		"changeInPerformance": -20610241788,
		"performance1year": 89877376224,
		"performancePercentage1year": 28.5368,
		"performance3year": 91730847239,
		"performancePercentage3year": 31.2597,
		"performance5year": 157058602844,
		"performancePercentage5year": 73.1617,
		"performanceSinceInception": 182067479115,
		"performanceSinceInceptionPercentage": 198.2138,
		"performanceRelativeToSP500Percentage": 6.325,
		"performance1yearRelativeToSP500Percentage": 28.5368,
		"performance3yearRelativeToSP500Percentage": 36.5632,
		"performance5yearRelativeToSP500Percentage": 36.1296,
		"performanceSinceInceptionRelativeToSP500Percentage": 37.0968
	}
]
```

---

### 164. Holders Industry Breakdown API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/holders-industry-breakdown

**Summary:**

Holders Industry Breakdown API는 기관 보유자들이 투자하고 있는 섹터 및 산업의 개요를 제공합니다. 이 API를 통해 기관 투자자들이 다양한 산업에 걸쳐 보유 자산을 어떻게 배분하는지 분석하고, 시간에 따른 투자 전략의 변화를 추적할 수 있습니다.

**About:**

Holders Industry Breakdown API는 기관 투자자들이 집중하고 있는 산업 데이터를 조회할 수 있게 해주며, 각 섹터에서 보유 비중과 그 비중이 시간에 따라 어떻게 변화하는지 확인할 수 있습니다. 이 API는 기관 투자자의 산업 배분에 대한 상세한 인사이트를 제공하여, 섹터 집중도와 전략을 쉽게 이해할 수 있도록 합니다.

Industry Focus Analysis: 주요 기관 보유자들이 어떤 산업에 가장 많이 투자하고 있는지 파악합니다.
Portfolio Diversification: 기관 투자자들의 포트폴리오가 다양한 섹터에 걸쳐 얼마나 분산되어 있는지 분석합니다.
Investment Trend Insights: 산업별 보유 비중의 변화를 추적하여 기관 투자 전략의 이동 흐름을 파악합니다.

이 API는 다양한 산업에 걸친 기관 투자 행태에 대한 인사이트를 원하는 투자자, 분석가, 포트폴리오 매니저에게 적합합니다.

Example Use Case
금융 분석가는 Holders Industry Breakdown API를 활용하여 Berkshire Hathaway의 섹터 집중도를 분석하고, 기술이나 헬스케어 등 특정 산업에 대한 익스포저를 늘리거나 줄이는 추세가 있는지 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/holder-industry-breakdown?cik=0001067983&year=2023&quarter=3
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0001067983 |
| year* | string | 2023 |
| quarter* | string | 3 |

**Sample Response:**

```json
[
	{
		"date": "2023-09-30",
		"cik": "0001067983",
		"investorName": "BERKSHIRE HATHAWAY INC",
		"industryTitle": "ELECTRONIC COMPUTERS",
		"weight": 49.7704,
		"lastWeight": 51.0035,
		"changeInWeight": -1.2332,
		"changeInWeightPercentage": -2.4178,
		"performance": -20838154294,
		"performancePercentage": -178.2938,
		"lastPerformance": 26615340304,
		"changeInPerformance": -47453494598
	}
]
```

---

### 165. Holidays By Exchange API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/holidays-by-exchange

**Summary:**

Holidays By Exchange API를 사용하여 특정 주식 거래소의 시장 휴장일 및 비거래일 목록을 조회하세요. NASDAQ, NYSE 등 거래소가 언제 휴장하는지 정확히 파악하여 거래 일정을 계획하세요.

**About:**

Holidays By Exchange API를 사용하여 특정 주식 거래소의 시장 휴장일 및 비거래일 목록을 조회하세요. NASDAQ, NYSE 등 거래소가 언제 휴장하는지 정확히 파악하여 거래 일정을 계획하세요.

**Endpoint:**

```
https://financialmodelingprep.com/stable/holidays-by-exchange?exchange=NASDAQ
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| exchange* | string | NASDAQ |
| from | date | 2025-04-27 |
| to | date | 2026-04-27 |

**Sample Response:**

```json
[
	{
		"exchange": "NASDAQ",
		"date": "2026-04-03",
		"name": "Good Friday",
		"isClosed": true,
		"adjOpenTime": null,
		"adjCloseTime": null
	}
]
```

---

### 166. Income Statement API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/income-statement

**Summary:**

Income Statements API를 통해 상장 기업의 상세한 손익계산서 데이터에 접근하세요. 최신 재무 데이터를 바탕으로 수익성을 추적하고, 경쟁사와 비교하며, 비즈니스 추세를 파악할 수 있습니다.

**About:**

FMP Income Statements API는 다양한 기업의 손익계산서 데이터에 대한 포괄적인 접근 경로를 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

Profitability Tracking: 시간에 따른 기업의 매출, 비용, 순이익을 모니터링합니다. 손익계산서(profit and loss statement라고도 함)는 특정 기간 동안 기업의 재무 성과를 상세히 보여줍니다.
Competitive Analysis: API를 활용하여 기업의 재무 성과를 경쟁사와 비교합니다. 기업 간 손익계산서를 분석하면 어떤 기업이 수익성과 효율성에서 앞서 있는지 파악할 수 있습니다.
Trend Identification: 여러 기간에 걸친 매출, 비용, 순이익의 변화를 살펴봄으로써 기업의 비즈니스 추세를 파악합니다. 이 데이터는 기업의 재무 건전성과 성장 전망을 이해하는 데 핵심적입니다.

Example
Financial Ratio Calculation: 투자자는 Income Statements API를 활용하여 주가수익비율(P/E ratio) 및 매출총이익률(gross margin)과 같은 핵심 재무 비율을 계산할 수 있습니다. 이러한 비율은 기업의 밸류에이션과 수익성을 평가하는 데 도움을 주어, 보다 합리적인 투자 의사결정을 가능하게 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"date": "2024-09-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2024-11-01",
		"acceptedDate": "2024-11-01 06:01:36",
		"fiscalYear": "2024",
		"period": "FY",
		"revenue": 391035000000,
		"costOfRevenue": 210352000000,
		"grossProfit": 180683000000,
		"researchAndDevelopmentExpenses": 31370000000,
		"generalAndAdministrativeExpenses": 0,
		"sellingAndMarketingExpenses": 0,
		"sellingGeneralAndAdministrativeExpenses": 26097000000,
		"otherExpenses": 0,
		"operatingExpenses": 57467000000,
		"costAndExpenses": 267819000000,
		"netInterestIncome": 0,
		"interestIncome": 0,
		"interestExpense": 0,
		"depreciationAndAmortization": 11445000000,
		"ebitda": 134661000000,
		"ebit": 123216000000,
		"nonOperatingIncomeExcludingInterest": 0,
		"operatingIncome": 123216000000,
		"totalOtherIncomeExpensesNet": 269000000,
		"incomeBeforeTax": 123485000000,
		"incomeTaxExpense": 29749000000,
		"netIncomeFromContinuingOperations": 93736000000,
		"netIncomeFromDiscontinuedOperations": 0,
		"otherAdjustmentsToNetIncome": 0,
		"netIncome": 93736000000,
		"netIncomeDeductions": 0,
		"bottomLineNetIncome": 93736000000,
		"eps": 6.11,
		"epsDiluted": 6.08,
		"weightedAverageShsOut": 15343783000,
		"weightedAverageShsOutDil": 15408095000
	}
]
```

---

### 167. Income Statement Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/income-statement-bulk

**Summary:**

Bulk Income Statement API를 통해 상세한 손익계산서 데이터를 대량으로 조회하세요. 이 API는 대규모 데이터 분석을 위해 설계되었으며, 매출, 매출총이익, 비용, 순이익 등 기업의 재무 성과에 대한 포괄적인 인사이트를 제공합니다.

**About:**

Bulk Income Statement API는 다음과 같은 작업이 필요한 사용자에게 적합합니다:

Analyze Financial Performance: 심층 재무 분석을 위해 대용량 데이터셋에 접근하며, 다양한 기업의 여러 손익계산서를 포함합니다.
Track Revenue and Profit Trends: 매출, 매출총이익, 영업이익, 순이익 데이터를 빠르게 조회하여 시간에 따른 기업의 수익성을 평가합니다.
Evaluate Expenses: 영업비용, 매출원가, 판매비와관리비(SG&A)를 검토하여 기업이 지출을 어디에 배분하는지 파악합니다.
Conduct Bulk Research: 상세한 산업 또는 섹터 비교를 위해 여러 기업의 손익계산서를 처리해야 하는 금융 분석가, 투자자, 연구자에게 적합합니다.

이 API는 표준화된 형식으로 재무 데이터를 제공하여 대규모 재무 분석을 손쉽게 수행할 수 있게 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"date": "2025-03-31",
		"symbol": "000001.SZ",
		"reportedCurrency": "CNY",
		"cik": "0000000000",
		"filingDate": "2025-03-31",
		"acceptedDate": "2025-03-31 00:00:00",
		"fiscalYear": "2025",
		"period": "Q1",
		"revenue": "33644000000",
		"costOfRevenue": "0",
		"grossProfit": "33644000000",
		"researchAndDevelopmentExpenses": "0",
		"generalAndAdministrativeExpenses": "9055000000",
		"sellingAndMarketingExpenses": "0",
		"sellingGeneralAndAdministrativeExpenses": "9055000000",
		"otherExpenses": "314000000",
		"operatingExpenses": "9369000000",
		"costAndExpenses": "9369000000",
		"netInterestIncome": "22788000000",
		"interestIncome": "44938000000",
		"interestExpense": "22150000000",
		"depreciationAndAmortization": "0",
		"ebitda": "16802000000",
		"ebit": "0",
		"nonOperatingIncomeExcludingInterest": "24275000000",
		"operatingIncome": "24275000000",
		"totalOtherIncomeExpensesNet": "-7392000000",
		"incomeBeforeTax": "16883000000",
		"incomeTaxExpense": "2787000000",
		"netIncomeFromContinuingOperations": "14096000000",
		"netIncomeFromDiscontinuedOperations": "0",
		"otherAdjustmentsToNetIncome": "0",
		"netIncome": "14096000000",
		"netIncomeDeductions": "0",
		"bottomLineNetIncome": "14096000000",
		"eps": "0.62",
		"epsDiluted": "0.62",
		"weightedAverageShsOut": "22735483871",
		"weightedAverageShsOutDil": "22735483871"
	}
]
```

---

### 168. Income Statement Growth API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/income-statement-growth

**Summary:**

Income Statement Growth API를 통해 핵심 재무 성장 지표를 추적하세요. 매출, 이익, 비용이 시간에 따라 어떻게 변화했는지 분석하여 기업의 재무 건전성과 운영 효율성에 대한 인사이트를 얻을 수 있습니다.

**About:**

Income Statement Growth API는 핵심 성장 데이터를 제공하여 다음과 같은 주요 손익계산서 항목의 전년 대비 변화를 추적할 수 있게 해줍니다:

Revenue Growth: 기업의 총 매출 변화를 모니터링하여 전반적인 비즈니스 성과를 가늠합니다.
Profit Growth: 매출총이익, 영업이익, 순이익의 변동을 평가하여 수익성 추세에 대한 인사이트를 얻습니다.
Expense Growth: 영업비용, 매출원가, 연구개발비 또는 이자비용 등 개별 항목의 성장률을 분석합니다.

이 API는 시간에 따른 기업의 재무 추세를 추적하고자 하는 투자자, 분석가, 금융 전문가에게 유용한 도구입니다.

Example Use Case
금융 분석가는 Income Statement Growth API를 활용하여 Apple의 지난 수년간 매출 및 순이익 추세를 평가하고, 기업이 꾸준한 성장을 이어가고 있는지 또는 수익성 하락을 겪고 있는지 파악할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement-growth?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"growthRevenue": 0.020219940775141214,
		"growthCostOfRevenue": -0.017675600199872046,
		"growthGrossProfit": 0.06819471705252206,
		"growthGrossProfitRatio": 0.04776303446712012,
		"growthResearchAndDevelopmentExpenses": 0.04863780712017383,
		"growthGeneralAndAdministrativeExpenses": 0,
		"growthSellingAndMarketingExpenses": 0,
		"growthOtherExpenses": -1,
		"growthOperatingExpenses": 0.04776924900176856,
		"growthCostAndExpenses": -0.004331112631234571,
		"growthInterestIncome": -1,
		"growthInterestExpense": -1,
		"growthDepreciationAndAmortization": -0.006424168764649709,
		"growthEBITDA": 0.07026704816404387,
		"growthOperatingIncome": 0.07799581805933456,
		"growthIncomeBeforeTax": 0.08571604417246959,
		"growthIncomeTaxExpense": 0.7770145152619318,
		"growthNetIncome": -0.033599670086086914,
		"growthEPS": -0.008116883116883088,
		"growthEPSDiluted": -0.008156606851549727,
		"growthWeightedAverageShsOut": -0.02543458616683152,
		"growthWeightedAverageShsOutDil": -0.02557791606880283,
		"growthEBIT": 0.0471407082579099,
		"growthNonOperatingIncomeExcludingInterest": 1,
		"growthNetInterestIncome": 1,
		"growthTotalOtherIncomeExpensesNet": 1.4761061946902654,
		"growthNetIncomeFromContinuingOperations": -0.033599670086086914,
		"growthOtherAdjustmentsToNetIncome": 0,
		"growthNetIncomeDeductions": 0
	}
]
```

---

### 169. Income Statement Growth Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/income-statement-growth-bulk

**Summary:**

Bulk Income Statement Growth API는 여러 기업에 걸친 손익계산서 성장 데이터에 접근할 수 있게 해줍니다. 매출, 순이익, 영업이익 등 핵심 재무 지표의 성장 추세를 시간에 따라 추적하고 분석하여 기업 성과 추세를 더 잘 이해할 수 있습니다.

**About:**

이 API는 다음과 같은 작업을 원하는 사용자에게 적합합니다:

Track Financial Growth: 매출, 순이익 등 기업의 손익계산서 수치가 시간에 따라 어떻게 성장하는지 파악합니다.
Analyze Trends: 비용, EBITDA, 주당순이익(EPS) 등 손익계산서 성장의 장기 추세에 대한 인사이트를 얻습니다.
Evaluate Performance: 여러 재무 지표에 걸친 기업의 성장률을 측정하여 시간에 따른 재무 건전성과 성과를 평가합니다.
Bulk Data Retrieval: 비교 분석이나 추세 예측을 위해 다수 기업의 손익계산서 성장 데이터를 빠르게 조회합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement-growth-bulk?year=2026&period=Q1
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2026 |
| period* | string | Q1Q2Q3Q4FY |

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"date": "2025-03-31",
		"fiscalYear": "2025",
		"period": "Q1",
		"reportedCurrency": "CNY",
		"growthRevenue": "-0.04159070191431176",
		"growthCostOfRevenue": "0",
		"growthGrossProfit": "-0.04159070191431176",
		"growthGrossProfitRatio": "0",
		"growthResearchAndDevelopmentExpenses": "0",
		"growthGeneralAndAdministrativeExpenses": "1.7466809598416757",
		"growthSellingAndMarketingExpenses": "0",
		"growthOtherExpenses": "-0.9860376183912135",
		"growthOperatingExpenses": "-0.095830920671685",
		"growthCostAndExpenses": "-0.095830920671685",
		"growthInterestIncome": "-0.003105727849505302",
		"growthInterestExpense": "-0.08421879522057303",
		"growthDepreciationAndAmortization": "0",
		"growthEBITDA": "0",
		"growthOperatingIncome": "-0.018874787810201278",
		"growthIncomeBeforeTax": "1.4139262224764084",
		"growthIncomeTaxExpense": "0.2582392776523702",
		"growthNetIncome": "1.9495710399665203",
		"growthEPS": "1.6956521739130435",
		"growthEPSDiluted": "1.6956521739130435",
		"growthWeightedAverageShsOut": "0.09825852256371011",
		"growthWeightedAverageShsOutDil": "0.09825852256371011",
		"growthEBIT": "1",
		"growthNonOperatingIncomeExcludingInterest": "-0.5659209985158163",
		"growthNetInterestIncome": "0.09080465272126753",
		"growthTotalOtherIncomeExpensesNet": "0.5835023664638269",
		"growthNetIncomeFromContinuingOperations": "1.9495710399665203",
		"growthOtherAdjustmentsToNetIncome": "0",
		"growthNetIncomeDeductions": "0"
	}
]
```

---

### 170. Income Statements TTM API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/income-statements-ttm

**About:**

Income Statements TTM(Trailing Twelve Months) API는 최근 12개월간의 누적 손익계산서 데이터를 제공합니다. 이를 통해 특정 회계 연도 구분 없이 가장 최근 12개월을 기준으로 기업의 재무 성과를 평가할 수 있으며, 매출, 비용, 순이익 등 핵심 재무 지표의 현재 상태를 파악하는 데 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/income-statement-ttm?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |

**Sample Response:**

```json
[
	{
		"date": "2024-12-28",
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"cik": "0000320193",
		"filingDate": "2025-01-31",
		"acceptedDate": "2025-01-31 06:01:27",
		"fiscalYear": "2025",
		"period": "Q1",
		"revenue": 395760000000,
		"costOfRevenue": 211657000000,
		"grossProfit": 184103000000,
		"researchAndDevelopmentExpenses": 31942000000,
		"generalAndAdministrativeExpenses": 0,
		"sellingAndMarketingExpenses": 0,
		"sellingGeneralAndAdministrativeExpenses": 26486000000,
		"otherExpenses": 0,
		"operatingExpenses": 58428000000,
		"costAndExpenses": 270085000000,
		"netInterestIncome": 0,
		"interestIncome": 0,
		"interestExpense": 0,
		"depreciationAndAmortization": 11677000000,
		"ebitda": 137352000000,
		"ebit": 125675000000,
		"nonOperatingIncomeExcludingInterest": 0,
		"operatingIncome": 125675000000,
		"totalOtherIncomeExpensesNet": 71000000,
		"incomeBeforeTax": 125746000000,
		"incomeTaxExpense": 29596000000,
		"netIncomeFromContinuingOperations": 96150000000,
		"netIncomeFromDiscontinuedOperations": 0,
		"otherAdjustmentsToNetIncome": 0,
		"netIncome": 96150000000,
		"netIncomeDeductions": 0,
		"bottomLineNetIncome": 96150000000,
		"eps": 6.31,
		"epsDiluted": 6.3,
		"weightedAverageShsOut": 15081724000,
		"weightedAverageShsOutDil": 15150865000
	}
]
```

---
### 171. Index Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-quote

**Summary:**

Stock Index Quote API를 통해 실시간 주가 지수 시세에 접근하세요. 전 세계 주요 주가 지수의 최신 가격 변동, 일중 고가 및 저가, 거래량 등 핵심 지표를 실시간으로 확인할 수 있습니다.

**About:**

Stock Index Quote API는 주가 지수의 실시간 성과 데이터를 제공하며, 현재 시장 상황에 대한 종합적인 시각을 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

Tracking Market Performance: S&P 500, NASDAQ 등 주요 주가 지수의 실시간 움직임을 모니터링하여 전반적인 시장 추세를 파악합니다.
Portfolio Management: 지수 데이터를 활용하여 더 넓은 시장 대비 포트폴리오의 건전성을 평가합니다.
Global Market Insights: 다양한 시장과 거래소의 지수 데이터에 접근하여 글로벌 시장을 한눈에 파악합니다.
Day Trading: 실시간 의사결정을 위해 일중 가격 움직임, 고가, 저가, 거래량을 지속적으로 추적합니다.

Example Use Case

트레이더가 Stock Index Quote API를 활용하여 S&P 500의 일중 성과를 실시간으로 추적하고, 시장 추세와 거래량을 바탕으로 합리적인 매매 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "^VIX",
		"name": "CBOE Volatility Index",
		"price": 16.37,
		"changePercentage": -5.37572,
		"change": -0.93,
		"volume": 0,
		"dayLow": 16.02,
		"dayHigh": 17.22,
		"yearHigh": 60.13,
		"yearLow": 12.7,
		"marketCap": 0,
		"priceAvg50": 16.5992,
		"priceAvg200": 19.3432,
		"exchange": "INDEX",
		"open": 17.02,
		"previousClose": 17.3,
		"timestamp": 1761336901
	}
]
```

---

### 172. Index Short Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/index-quote-short

**Summary:**

Stock Index Short Quote API를 통해 간결한 주가 지수 시세에 접근하세요. 이 API는 주가 지수의 현재 가격, 변동폭, 거래량을 스냅샷 형태로 제공하여 시장 움직임을 빠르게 파악하고자 하는 사용자에게 최적화되어 있습니다.

**About:**

Stock Index Short Quote API는 가격, 변동폭, 거래량 등 핵심 지표를 담은 간소화된 실시간 지수 데이터를 제공합니다. 불필요한 세부 사항 없이 지수의 현재 상태를 신속하게 파악해야 하는 트레이더, 투자자, 애널리스트에게 매우 유용한 도구입니다. 주요 기능은 다음과 같습니다:

Real-Time Index Data: 주가 지수의 현재 가격, 변동폭, 거래량을 실시간으로 확인합니다.
Simplified Data: 핵심 수치만을 필요로 하는 사용자를 위해 설계되어 명확하고 효율적인 시장 스냅샷을 제공합니다.
Wide Market Coverage: 다양한 글로벌 지수에 대한 단축 시세를 조회합니다.

이 API는 지수 성과를 빠르게 파악하여 시장 변화에 신속하게 대응하고자 하는 트레이더와 애널리스트에게 적합합니다.

Example Use Case

거래일 내내 S&P 500을 모니터링하는 트레이더가 Stock Index Short Quote API를 활용하여 실시간 가격 변동에 빠르게 접근하고, 복잡한 데이터를 분석하지 않고도 매수 또는 매도 여부를 결정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote-short?symbol=^VIX
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | ^VIX |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "^VIX",
		"price": 16.37,
		"change": -0.93,
		"volume": 0
	}
]
```

---

### 173. Industry Classification List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/industry-classification-list

**Summary:**

FMP Industry Classification List API를 통해 표준 산업 분류(SIC) 코드와 산업 명칭을 포함한 포괄적인 산업 분류 목록을 조회하세요.

**About:**

FMP Industry Classification List API는 SIC 코드와 해당 산업 명칭의 전체 디렉터리를 제공합니다. 이 API는 다음과 같은 용도에 필수적입니다:

Industry Research: SIC 코드와 함께 정리된 산업 목록에 접근하여 기업을 해당 산업 섹터에 따라 분류합니다.
Company Classification: 제조업부터 서비스업에 이르는 다양한 산업의 SIC 코드를 조회하여 기업을 주요 사업 활동별로 분류하고 분석합니다.
Standardized Data: 표준화된 SIC 코드와 공식 산업 명칭을 제공하므로 기업 조사 또는 분류 시 일관성을 보장합니다.

이 API는 산업 표준에 따라 기업을 분류하고자 하는 애널리스트, 연구자, 기업에 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/standard-industrial-classification-list
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| industryTitle | string | SERVICES |
| sicCode | string | 7371 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"office": "Office of Life Sciences",
		"sicCode": "100",
		"industryTitle": "AGRICULTURAL PRODUCTION-CROPS"
	}
]
```

---

### 174. Industry Classification Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/industry-classification-search

**Summary:**

FMP Industry Classification Search API를 통해 기업의 SIC 코드, 산업 명칭, 사업 정보 등 산업 분류 세부 내용을 검색하고 조회하세요.

**About:**

FMP Industry Classification Search API를 통해 사용자는 표준 산업 분류(SIC) 코드를 기반으로 기업 정보를 검색할 수 있습니다. 이 API가 제공하는 기능은 다음과 같습니다:

Company Lookup by Industry: 산업 분류별로 기업을 검색하여 SIC 코드, 산업 명칭, 기업 연락처 정보 등 상세 내용을 조회합니다.
Business Information Access: 사업장 주소와 전화번호를 포함한 포괄적인 기업 정보를 확인하여 기업을 산업별로 쉽게 식별하고 분류합니다.
SIC Code Matching: 이 API를 활용하여 기업과 해당 산업 섹터를 매칭하고, 산업별 리서치 및 분류 역량을 강화합니다.

이 API는 특정 산업 섹터와 연결된 기업 상세 정보가 필요한 기업, 투자자, 연구자에게 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/industry-classification-search
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol | string | AAPL |
| cik | string | 320193 |
| sicCode | string | 7371 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "APPLE INC.",
		"cik": "0000320193",
		"sicCode": "3571",
		"industryTitle": "ELECTRONIC COMPUTERS",
		"businessAddress": "['ONE APPLE PARK WAY', 'CUPERTINO CA 95014']",
		"phoneNumber": "(408) 996-1010"
	}
]
```

---

### 175. Industry Pe Snapshot API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/industry-pe-snapshot

**Summary:**

Industry P/E Snapshot API를 통해 다양한 산업의 주가수익비율(P/E ratio)을 확인하세요. 여러 산업의 밸류에이션 수준을 분석하여 각 산업이 수익 대비 어떻게 평가되고 있는지 파악합니다.

**About:**

FMP Industry P/E Snapshot API는 광고 대행사, 기술, 헬스케어 등 다양한 산업의 주가수익비율(P/E ratio)에 대한 상세 정보를 제공합니다. 이 API를 통해 NASDAQ, NYSE 등 주요 거래소에서 산업별 밸류에이션 수준을 비교하고, 어떤 산업이 고평가 또는 저평가되어 있는지 파악할 수 있습니다. 주요 기능은 다음과 같습니다:

P/E Ratios by Industry: 주요 거래소에서 각 산업의 최신 P/E ratio에 접근합니다.
Daily Updates: 산업별 P/E ratio의 일별 스냅샷을 통해 시간에 따른 밸류에이션 변화를 추적합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 거래소별로 산업이 어떻게 평가받고 있는지 분석합니다.
Cross-Industry Comparisons: 산업 간 P/E ratio를 비교하여 잠재적인 투자 기회나 리스크를 식별합니다.

이 API는 정보에 기반한 투자 결정을 내리기 위해 산업별 밸류에이션을 평가하고자 하는 투자자, 애널리스트, 금융 전문가에게 적합합니다.

Example Use Case

투자자가 Industry P/E Snapshot API를 활용하여 NASDAQ 내 특정 산업을 평가합니다. P/E ratio를 파악함으로써 해당 산업이 고평가되어 있는지 판단하고, 포트폴리오를 적절히 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/industry-pe-snapshot?date=2024-02-01
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date* | string | 2024-02-01 |
| exchange | string | NASDAQ |
| industry | string | Biotechnology |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"industry": "Advertising Agencies",
		"exchange": "NASDAQ",
		"pe": 71.09601665201151
	}
]
```

---

### 176. Industry Performance Snapshot API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/industry-performance-snapshot

**Summary:**

Industry Performance Snapshot API를 통해 산업별 상세 성과 데이터에 접근하세요. 다양한 거래소에 걸쳐 특정 산업의 추세, 움직임, 일별 성과 지표를 분석합니다.

**About:**

FMP Industry Performance Snapshot API는 주요 거래소에서 특정 산업이 어떻게 성과를 내고 있는지에 대한 일별 개요를 제공합니다. 광고 대행사, 헬스케어 장비, 기술 서비스 등 산업의 평균 등락률과 같은 핵심 데이터를 제공하여 특정 섹터 내 성과 추세를 추적하고 비교할 수 있습니다. 주요 기능은 다음과 같습니다:

Industry-Level Performance Data: 주요 거래소에서 특정 산업의 평균 등락률을 확인합니다.
Real-Time Market Insights: 일별 업데이트를 통해 산업 성과 추세와 움직임을 실시간으로 분석합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 다양한 거래소에서 각 산업의 성과를 비교합니다.
In-Depth Industry Comparisons: 특정 산업의 성과를 추적·분석하여 시장 추세를 이해하고 성장 기회를 발굴합니다.

이 API는 투자 전략 수립을 위해 개별 산업의 성과 역학을 파악해야 하는 시장 애널리스트, 포트폴리오 매니저, 투자자에게 이상적입니다.

Example Use Case

시장 애널리스트가 Industry Performance Snapshot API를 활용하여 특정 날짜의 광고 대행사 산업 성과를 분석한 결과, NASDAQ에서 평균 3.87% 상승했음을 확인합니다. 이 데이터를 바탕으로 섹터 특화 투자를 추천하고 광고 섹터의 성장 추세를 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/industry-performance-snapshot?date=2024-02-01
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date* | string | 2024-02-01 |
| exchange | string | NASDAQ |
| industry | string | Biotechnology |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"industry": "Advertising Agencies",
		"exchange": "NASDAQ",
		"averageChange": 3.8660194344955996
	}
]
```

---

### 177. Industry Performance Summary API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/industry-summary

**Summary:**

Industry Performance Summary API는 다양한 산업의 재무 성과 현황을 제공합니다. 특정 기간에 걸쳐 산업의 가치를 분석함으로써, 투자자와 애널리스트가 섹터 전체의 건전성을 파악하고 섹터 기반 투자에 대한 합리적인 결정을 내릴 수 있도록 지원합니다.

**About:**

Industry Performance Summary API를 통해 특정 산업의 재무 성과 요약 데이터를 조회할 수 있습니다. 이 API는 다음과 같은 용도에 이상적입니다:

Sector Analysis: 산업별 성과에 대한 인사이트를 확보하여 강세 또는 약세 섹터를 식별합니다.
Comparative Industry Health: 다양한 산업의 재무 건전성을 비교하여 더 나은 투자 기회를 제공할 수 있는 섹터를 평가합니다.
Macro-Level Market Insights: 산업 수준의 성과 데이터를 활용하여 광범위한 시장 추세와 경제 변화에 대한 합리적인 결정을 내립니다.

이 API는 섹터 성과에 대한 거시경제적 시각을 제공하며, 산업별 추세를 이해하고 시장 내 다양한 섹터의 재무 건전성을 비교하고자 하는 금융 애널리스트, 투자자, 경제학자에게 유용한 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/industry-summary?year=2023&quarter=3
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| year* | string | 2023 |
| quarter* | string | 3 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"industryTitle": "ABRASIVE, ASBESTOS & MISC NONMETALLIC MINERAL PRODS",
		"industryValue": 10979226300,
		"date": "2023-09-30"
	}
]
```

---

### 178. Insider Trade Statistics API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/insider-trade-statistics

**Summary:**

Insider Trade Statistics API를 통해 내부자 거래 활동을 분석하세요. 이 API는 특정 기업 또는 주식 심볼에 대한 내부자 거래의 총 매수, 매도, 추세 등 핵심 통계를 제공합니다.

**About:**

FMP Insider Trade Statistics API는 특정 주식 심볼에 대한 내부자 거래 활동의 포괄적인 통계 데이터를 제공합니다. 총 거래 건수, 취득 또는 처분된 주식 수, 취득 대 처분 비율 등을 포함합니다. 이러한 추세를 분석함으로써 기업 심리와 시장 행동에 대한 인사이트를 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

Transaction Breakdown: 특정 기업의 내부자 취득 및 처분에 대한 통계에 접근합니다.
Acquired vs. Disposed Ratio: 취득 주식 수와 처분 주식 수의 비율을 분석하여 내부자 심리를 파악합니다.
Quarterly Data: 분기별 내부자 거래 활동을 확인하여 시간에 따른 거래 패턴 변화를 추적합니다.
Total and Average Transactions: 총 매수 및 매도 건수와 평균 거래 규모에 대한 상세 통계를 확인합니다.

이 API는 합리적인 투자 결정을 위해 내부자 거래 활동의 패턴과 추세를 분석해야 하는 투자자, 애널리스트, 금융 연구자에게 이상적입니다.

Example Use Case

금융 애널리스트가 Insider Trade Statistics API를 활용하여 2024년 3분기 Apple(AAPL)의 내부자 거래 추세를 분석합니다. 처분 주식 수 대 취득 주식 수 비율과 총 매도 건수를 검토하여 내부자들이 회사의 미래에 대해 자신감을 보이고 있는지 평가합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/insider-trading/statistics?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"year": 2026,
		"quarter": 2,
		"acquiredTransactions": 3,
		"disposedTransactions": 20,
		"acquiredDisposedRatio": 0.15,
		"totalAcquired": 260210,
		"totalDisposed": 489420,
		"averageAcquired": 86736.6667,
		"averageDisposed": 24471,
		"totalPurchases": 0,
		"totalSales": 8
	}
]
```

---

### 179. Institutional Ownership Filings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-filings

**Summary:**

Institutional Ownership Filings API를 통해 기관 투자자의 소유권과 관련된 최신 SEC 공시를 실시간으로 파악하세요. 기관 투자자의 최신 보고서 및 공시를 추적하여 주요 보유 현황과 규정 제출 내역을 실시간으로 확인할 수 있습니다.

**About:**

Institutional Ownership Filings API는 기관 투자자의 최신 SEC 공시에 접근하여 Form 13F 제출과 같은 보고서에 대한 인사이트를 제공합니다. 특정 기업의 주식을 보유한 기관을 파악하고 중요한 소유권 변화를 모니터링하는 데 최적화되어 있습니다.
이 API는 다음과 같은 용도에 이상적입니다:

Tracking Institutional Ownership: 특정 기업의 주식을 보유한 기관에 대해 최신 정보를 유지합니다.
Monitoring Investor Activity: 대형 투자자의 매수 또는 매도 시점을 보여주는 공시에 접근합니다.
Research & Analysis: 투자 리서치와 추세 분석에 이 데이터를 활용하여 특정 기업에 대해 기관들이 강세 또는 약세 입장인지 파악합니다.
Compliance & Governance: 기업 활동이 규제 요건을 준수하는지 확인하기 위해 공시를 활용합니다.

이 API는 가장 최신의 기관 공시에 실시간으로 접근하여 중요한 투자자 동향을 파악할 수 있도록 지원합니다.

Example Use Case

투자 연구원이 Institutional Ownership Filings API를 활용하여 Apple 등 기업의 기관 소유권 변화를 모니터링하고, 주요 헤지펀드나 연기금이 지분을 늘리거나 줄이는 시점을 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"cik": "0001963967",
		"name": "CPA ASSET MANAGEMENT LLC",
		"date": "2024-12-31",
		"filingDate": "2025-02-04 00:00:00",
		"acceptedDate": "2025-02-04 17:28:36",
		"formType": "13F-HR",
		"link": "https://www.sec.gov/Archives/edgar/data/1963967/000196396725000001/0001963967-25-000001-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/1963967/000196396725000001/boc2024q413f.xml"
	}
]
```

---

### 180. IPOs Calendar API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/ipos-calendar

**Summary:**

FMP IPO Calendar API를 통해 예정된 모든 기업공개(IPO)의 포괄적인 목록에 접근하세요. IPO 일정, 기업명, 예상 공모가, 상장 거래소 등 핵심 정보와 함께 공모 시장에 새로 진입하는 기업들의 최신 현황을 파악합니다.

**About:**

FMP IPO Calendar API는 예정된 IPO를 추적하는 데 관심 있는 투자자와 시장 애널리스트에게 필수적인 정보를 제공합니다. 이 API를 통해 상장을 준비 중인 최신 기업들을 모니터링할 수 있으며, 다음과 같은 내용을 포함합니다:

Upcoming IPO Dates: 기업의 상장 예정일을 파악하여 신규 시장 진입자에 대한 명확한 일정을 확인합니다.
Company Information: 기업명과 상장 예정 거래소 등 IPO 계획에 대한 핵심 세부 정보를 조회합니다.
Expected Pricing and Shares: 예상 공모가 범위와 공모 주식 수(가용 시)를 확인하여 잠재적 투자 기회를 평가합니다.
Market Insights: IPO 캘린더를 활용하여 신흥 기업을 발굴하고 주식 시장의 신규 상장 활동 전반을 평가합니다.

이 API는 IPO를 활용하여 수익을 창출하고 신규 주식 상장과 관련된 시장 활동을 추적하고자 하는 투자자에게 유용한 도구입니다.

Example Use Case

벤처 캐피탈리스트가 IPO Calendar API를 활용하여 주식 시장에 새로 진입하는 기업들을 추적하고, 공모가 기대치를 평가하며 잠재적인 투자 기회를 발굴합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ipos-calendar
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "PEVC",
		"date": "2025-02-03",
		"daa": "2025-02-03T05:00:00.000Z",
		"company": "Pacer Funds Trust",
		"exchange": "NYSE",
		"actions": "Expected",
		"shares": null,
		"priceRange": null,
		"marketCap": null
	}
]
```

---
### 181. IPOs Disclosure API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/ipos-disclosure

**Summary:**

FMP IPO 공시 API를 통해 예정된 기업공개(IPO)에 대한 공시 서류의 포괄적인 목록에 접근하세요. 제출일, 효력 발생일, CIK 번호, 양식 유형 등 규제 서류에 대한 최신 정보를 SEC 공식 문서 직접 링크와 함께 확인할 수 있습니다.

**About:**

FMP IPO 공시 API는 상장을 준비 중인 기업의 규제 서류에 관한 시의적절하고 상세한 정보를 제공합니다. 이 API는 IPO 서류 제출 활동에 대한 인사이트가 필요한 애널리스트, 투자자, 규제 전문가에게 필수적인 도구입니다. 주요 기능은 다음과 같습니다:

Filing and Accepted Dates: 기업이 IPO 서류를 제출하는 시점과 해당 서류가 SEC에 접수되는 시점을 추적합니다.
Effectiveness Dates: IPO 서류가 공식적으로 효력을 발생하는 날짜를 파악하여 중요한 시점을 놓치지 않습니다.
Form Types and CIK Numbers: CIK 번호 및 양식 유형(예: S-1, CERT) 등 핵심 세부 정보에 접근하여 서류의 성격을 파악합니다.
Direct SEC Links: SEC 공식 문서에 직접 접근하여 각 서류의 세부 내용을 검토합니다.

이 API는 IPO 이면의 규제 절차를 모니터링하고, 공개 시장에 진입하는 기업들에 수반되는 공시 내용을 이해하려는 분들에게 필수적인 도구입니다.

Example Use Case
기관 투자자는 IPO 공시 API를 활용하여 예정된 IPO에 대한 규제 서류를 추적하고, 신규 시장 진입 기업에 대한 투자 결정을 내리기 전에 SEC 문서를 분석할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ipos-disclosure
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "SCHM",
		"filingDate": "2025-02-03",
		"acceptedDate": "2025-02-03",
		"effectivenessDate": "2025-02-03",
		"cik": "0001454889",
		"form": "CERT",
		"url": "https://www.sec.gov/Archives/edgar/data/1454889/000114336225000044/SCCR020325.pdf"
	}
]
```

---

### 182. IPOs Prospectus API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/ipos-prospectus

**Summary:**

FMP IPO 투자설명서 API를 통해 IPO 투자설명서에 대한 포괄적인 정보에 접근하세요. 공모가, 할인율, 수수료, 비용 차감 전 수익금 등 핵심 재무 세부 내용을 확인하세요. 또한 이 API는 SEC 공식 투자설명서 링크를 제공하여 투자자들이 공개 시장에 진입하는 기업에 대한 정보를 충분히 파악할 수 있도록 돕습니다.

**About:**

FMP IPO 투자설명서 API는 IPO 서류에 대한 상세한 인사이트를 제공하여 투자자, 애널리스트, 규제 전문가에게 필수적인 정보를 전달합니다. 이 API를 통해 사용자는 다음에 접근할 수 있습니다:

Public Offering Prices: 주당 공모가와 IPO를 통해 조달되는 총 금액을 확인합니다.
Discounts and Commissions: IPO 총 수익금에서 차감되는 수수료 및 커미션을 파악합니다.
Proceeds Before Expenses: 비용 차감 전 기업이 조달할 것으로 예상되는 순수익금을 확인합니다.
Filing and IPO Dates: 기업이 투자설명서를 제출하는 시점과 예정된 IPO 날짜를 추적합니다.
CIK and Form Type: CIK 번호 및 양식 유형(예: 424B4)을 포함한 핵심 규제 세부 정보를 확인합니다.
Direct SEC Links: SEC에 제출된 전체 IPO 투자설명서에 접근하여 공모에 관한 완전한 세부 내용을 검토합니다.

이 API는 투자 결정을 내리기 전에 IPO 재무 세부 내용을 분석하고자 하는 모든 분들에게 귀중한 도구입니다.

Example Use Case
투자 자문가는 IPO 투자설명서 API를 활용하여 기업의 IPO 재무 내역 및 투자설명서 서류를 검토하고, 공모 구조를 바탕으로 해당 IPO를 고객에게 추천할지 여부를 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ipos-prospectus
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "ATAK",
		"acceptedDate": "2025-02-03",
		"filingDate": "2025-02-03",
		"ipoDate": "2022-03-20",
		"cik": "0001883788",
		"pricePublicPerShare": 0.78,
		"pricePublicTotal": 4649936.72,
		"discountsAndCommissionsPerShare": 0.04,
		"discountsAndCommissionsTotal": 254909.67,
		"proceedsBeforeExpensesPerShare": 0.74,
		"proceedsBeforeExpensesTotal": 4395207.05,
		"form": "424B4",
		"url": "https://www.sec.gov/Archives/edgar/data/1883788/000149315225004604/form424b4.htm"
	}
]
```

---

### 183. Key Metrics API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/key-metrics

**Summary:**

FMP 재무 핵심 지표 API를 통해 기업의 필수 재무 지표에 접근하세요. 매출, 순이익, P/E 비율 등을 평가하여 성과를 분석하고 경쟁사와 비교하세요.

**About:**

FMP 재무 핵심 지표 API는 투자자, 애널리스트, 경영자가 기업의 재무 성과를 평가하는 데 도움이 되는 핵심 재무 데이터를 제공합니다. 이 endpoint는 다음을 제공합니다:

Revenue: 기업의 영업 활동에서 창출된 총 수익을 추적합니다.
Net Income: 모든 비용과 세금을 차감한 후 기업의 수익성을 파악합니다.
P/E Ratio (Price-to-Earnings Ratio): 이익 대비 기업 가치를 평가하여 주식의 고평가 또는 저평가 여부를 판단합니다.

이러한 재무 핵심성과지표(KPI)는 비즈니스 분석, 목표 추적, 경쟁 벤치마킹에 있어 귀중한 도구입니다. 이 지표들을 활용하면 다음이 가능합니다:

Assess Financial Performance: 기업의 재무 건전성과 운영 효율성에 대한 명확한 그림을 얻습니다.
Compare to Competitors: 기업의 성과를 경쟁사와 비교하여 강점, 약점, 시장 포지셔닝을 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/key-metrics?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |
| period | string | Q1Q2Q3Q4FYannualquarter |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2024-09-28",
		"fiscalYear": "2024",
		"period": "FY",
		"reportedCurrency": "USD",
		"marketCap": 3495160329570,
		"enterpriseValue": 3571846329570,
		"evToSales": 9.134339201273542,
		"evToOperatingCashFlow": 30.204866893043786,
		"evToFreeCashFlow": 32.82735788662494,
		"evToEBITDA": 26.524727497716487,
		"netDebtToEBITDA": 0.5694744580836323,
		"currentRatio": 0.8673125765340832,
		"incomeQuality": 1.2615643936161134,
		"grahamNumber": 22.587017267616833,
		"grahamNetNet": -12.352478525015636,
		"taxBurden": 0.7590881483581001,
		"interestBurden": 1.0021831580314244,
		"workingCapital": -23405000000,
		"investedCapital": 22275000000,
		"returnOnAssets": 0.25682503150857583,
		"operatingReturnOnAssets": 0.3434290787011036,
		"returnOnTangibleAssets": 0.25682503150857583,
		"returnOnEquity": 1.6459350307287095,
		"returnOnInvestedCapital": 0.4430708117427921,
		"returnOnCapitalEmployed": 0.6533607652660827,
		"earningsYield": 0.026818798327209237,
		"freeCashFlowYield": 0.03113076074921754,
		"capexToOperatingCashFlow": 0.07988736110406414,
		"capexToDepreciation": 0.8254259501965924,
		"capexToRevenue": 0.02415896275269477,
		"salesGeneralAndAdministrativeToRevenue": 0,
		"researchAndDevelopementToRevenue": 0.08022299794136074,
		"stockBasedCompensationToRevenue": 0.02988990755303234,
		"intangiblesToTotalAssets": 0,
		"averageReceivables": 63614000000,
		"averagePayables": 65785500000,
		"averageInventory": 6808500000,
		"daysOfSalesOut
```

---

### 184. Key Metrics TTM API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/key-metrics-ttm

**Summary:**

TTM 핵심 지표 API를 통해 최근 12개월(TTM) 핵심 성과 지표의 포괄적인 세트를 조회하세요. 기업의 수익성, 자본 효율성, 유동성에 관한 데이터에 접근하여 지난 1년간의 재무 건전성을 상세히 분석할 수 있습니다.

**About:**

TTM 핵심 지표 API는 최근 12개월 기간의 데이터를 포착하여 기업의 최근 성과에 대한 귀중한 인사이트를 제공합니다. 이 API는 다음 용도에 이상적입니다:

Profitability Assessment: 자산수익률(ROA) 및 이익수익률과 같은 지표를 통해 기업의 이익 창출 능력을 파악합니다.
Liquidity and Solvency Analysis: 유동비율 및 현금전환주기와 같은 비율로 기업이 단기 채무를 얼마나 효율적으로 관리하는지 평가합니다.
Capital Efficiency: 투하자본수익률(ROIC) 및 자기자본수익률(ROE)과 같은 지표로 기업의 자본 활용 효율성을 평가합니다.
Operational Performance: 운영 주기 및 재고자산회전일수(DIO)를 통해 기업의 운영 효율성에 대한 인사이트를 얻습니다.

이 API는 투자자, 애널리스트, 포트폴리오 매니저가 재무 성과 추세를 추적하고 기업의 수익 창출 효율성을 평가하는 데 도움을 줍니다.

Example Use Case
애널리스트는 TTM 핵심 지표 API를 활용하여 동일 업종 내 여러 기업의 잉여현금흐름 수익률을 비교함으로써, 보다 정보에 기반한 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/key-metrics-ttm?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"marketCap": 3149833928000,
		"enterpriseValueTTM": 3216333928000,
		"evToSalesTTM": 8.126980816656559,
		"evToOperatingCashFlowTTM": 29.70001965021146,
		"evToFreeCashFlowTTM": 32.71990486169747,
		"evToEBITDATTM": 23.41672438697653,
		"netDebtToEBITDATTM": 0.48415749315627005,
		"currentRatioTTM": 0.9229383853427077,
		"incomeQualityTTM": 1.1263026521060842,
		"grahamNumberTTM": 25.198029099282905,
		"grahamNetNetTTM": -11.64435843011051,
		"taxBurdenTTM": 0.7646366484818603,
		"interestBurdenTTM": 1.0005649492739208,
		"workingCapitalTTM": -11125000000,
		"investedCapitalTTM": 34944000000,
		"returnOnAssetsTTM": 0.27943676707790227,
		"operatingReturnOnAssetsTTM": 0.35448090090471257,
		"returnOnTangibleAssetsTTM": 0.27943676707790227,
		"returnOnEquityTTM": 1.4534598087751787,
		"returnOnInvestedCapitalTTM": 0.45208108089346594,
		"returnOnCapitalEmployedTTM": 0.6292559583416784,
		"earningsYieldTTM": 0.030404739849149914,
		"freeCashFlowYieldTTM": 0.03120767705439485,
		"capexToOperatingCashFlowTTM": 0.09229504866382256,
		"capexToDepreciationTTM": 0.855956153121521,
		"capexToRevenueTTM": 0.025255205174853447,
		"salesGeneralAndAdministrativeToRevenueTTM": 0,
		"researchAndDevelopementToRevenueTTM": 0.08071053163533455,
		"stockBasedCompensationToRevenueTTM": 0.030263290883363655,
		"intangiblesToTotalAssetsTTM": 0,
		"averageReceivablesTTM": 62774500000,
		"averagePayablesTTM": 65435000000,
		"averageInventoryTTM": 7098500000,
		"daysOfSalesO
```

---

### 185. Key Metrics TTM Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/key-metrics-ttm-bulk

**Summary:**

Key Metrics TTM Bulk API를 통해 데이터베이스에 등재된 모든 기업의 최근 12개월(TTM) 데이터를 조회하세요. 이 API는 각 기업의 최신 재무 보고서를 기반으로 핵심 재무 비율 및 지표를 제공하여 기업 성과와 재무 건전성에 대한 인사이트를 제공합니다.

**About:**

이 API는 다음에 대한 접근을 제공합니다:

Market and Enterprise Value Metrics: TTM 시가총액, 기업가치(EV), 그리고 EV 대비 매출, 영업현금흐름, 잉여현금흐름 등 다양한 가치 배수를 확인합니다.
Profitability and Return Ratios: 자산수익률(ROA), 자기자본수익률(ROE), 투하자본수익률(ROIC) 등 핵심 비율을 추적합니다.
Operational Efficiency Metrics: 현금전환주기, 매입채무회전일수, 매출채권회전일수, 재고자산회전일수 등의 지표에 접근하여 기업의 운영 효율성에 대한 인사이트를 얻습니다.
Liquidity and Leverage Ratios: 유동비율로 유동성을 모니터링하고, 순부채 대비 EBITDA 및 기타 관련 비율로 재무 레버리지를 평가합니다.
Cash Flow and Yield Metrics: 잉여현금흐름 수익률, 이익수익률, 매출 대비 설비투자비 비율 등 현금흐름 관련 지표를 평가하여 기업의 현금 창출 및 활용 능력을 파악합니다.

이 API는 광범위한 기업군에 걸쳐 핵심 재무 지표를 모니터링하고자 하는 애널리스트, 포트폴리오 매니저, 기관 투자자에게 특히 유용합니다. 이 API는 필터링이 불가능하며, 최신 재무 공시를 기반으로 가장 최근의 TTM 데이터를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/key-metrics-ttm-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"marketCap": "249171756000",
		"enterpriseValueTTM": "-496959244000",
		"evToSalesTTM": "-2.95816117050406",
		"evToOperatingCashFlowTTM": "-2.9831814247210167",
		"evToFreeCashFlowTTM": "-3.028355803098073",
		"evToEBITDATTM": "-14.656106051669223",
		"netDebtToEBITDATTM": "-22.004571192638906",
		"currentRatioTTM": "0",
		"incomeQualityTTM": "15.217593861331872",
		"grahamNumberTTM": "31.017865999534138",
		"grahamNetNetTTM": "-199.05514330278228",
		"taxBurdenTTM": "0.8225101702576465",
		"interestBurdenTTM": "1.4030970878917606",
		"workingCapitalTTM": "746131000000",
		"investedCapitalTTM": "772543000000",
		"returnOnAssetsTTM": "0.007558510437605078",
		"operatingReturnOnAssetsTTM": "0.013555578495362656",
		"returnOnTangibleAssetsTTM": "0.007576346366296015",
		"returnOnEquityTTM": "0.09082717681735725",
		"returnOnInvestedCapitalTTM": "0.011141314993384131",
		"returnOnCapitalEmployedTTM": "0.013545504233575834",
		"earningsYieldTTM": "0.14960077934639543",
		"freeCashFlowYieldTTM": "0.6585898925077207",
		"capexToOperatingCashFlowTTM": "0.014917130388325619",
		"capexToDepreciationTTM": "1.855862584017924",
		"capexToRevenueTTM": "0.014792018857591847",
		"salesGeneralAndAdministrativeToRevenueTTM": "0.10163337222314817",
		"researchAndDevelopementToRevenueTTM": "0",
		"stockBasedCompensationToRevenueTTM": "0",
		"intangiblesToTotalAssetsTTM": "0.002354159621091415",
		"averageReceivablesTTM": "0",
		"averagePayablesTTM": "0",
		"avera
```

---

### 186. Latest 8-K SEC Filings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/8k-latest

**Summary:**

FMP 최신 8-K SEC 공시 API를 통해 상장 기업들의 가장 최근 8-K 공시를 최신 상태로 확인하세요. 합병, 인수, 경영진 교체 및 시장에 영향을 미칠 수 있는 기타 중요 이벤트와 같은 주요 기업 이벤트에 실시간으로 접근할 수 있습니다.

**About:**

FMP 최신 8-K SEC 공시 API는 대중에게 공개되어야 하는 필수 기업 이벤트에 대한 시의적절한 업데이트를 제공합니다. 이러한 공시는 투자자와 애널리스트에게 다음을 포함한 중요한 인사이트를 제공합니다:

Real-Time Filings: SEC에 제출되는 즉시 최신 8-K 공시에 접근하여 주요 기업 동향을 신속히 파악합니다.
Material Events: 합병, 인수, 파산, 경영진 교체 등 중요한 기업 이벤트를 추적합니다.
Direct Filing Links: SEC 공시 문서에 직접 접근하여 기업의 완전한 세부 내용과 공시 내용을 확인합니다.

이 API는 시장을 움직이는 기업 이벤트에 대한 최신 정보를 유지해야 하는 투자자, 애널리스트, 전문가들에게 귀중한 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-8k?from=2024-01-01&to=2024-03-01&page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from* | string | 2024-01-01 |
| to* | string | 2024-03-01 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "BROS",
		"cik": "0001866581",
		"filingDate": "2024-03-01 00:00:00",
		"acceptedDate": "2024-02-29 21:43:41",
		"formType": "8-K",
		"hasFinancials": false,
		"link": "https://www.sec.gov/Archives/edgar/data/1866581/000162828024008098/0001628280-24-008098-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/1866581/000162828024008098/exhibit11-8xkfeb2024.htm"
	}
]
```

---

### 187. Latest Crowdfunding Campaigns API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-crowdfunding

**Summary:**

FMP 최신 크라우드펀딩 캠페인 API를 통해 가장 최근의 크라우드펀딩 캠페인을 확인하세요. 현재 자금을 조달 중인 기업과 프로젝트, 재무 세부 정보, 공모 조건 등의 최신 정보를 파악할 수 있습니다.

**About:**

FMP 최신 크라우드펀딩 캠페인 API는 발행사 명칭, 공모 유형, 재무 데이터 등 현재 진행 중인 크라우드펀딩 캠페인에 대한 상세한 정보를 제공합니다. 이 API는 최신 크라우드펀딩 활동을 추적하고자 하는 투자자, 애널리스트, 플랫폼 운영자에게 필수적입니다.

Track Crowdfunding Campaigns: 기업명, 펀딩 목표액, 공모 유형 등 크라우드펀딩 캠페인의 가장 최신 정보에 접근합니다.
Detailed Financial Information: 크라우드펀딩 캠페인을 진행 중인 각 기업의 총 자산, 현금성 자산, 부채, 순이익 등 핵심 재무 지표를 확인합니다.
Company Backgrounds: 직원 수 및 기타 관련 조직 데이터를 포함하여 기업의 법적 지위 및 관할 지역에 대한 인사이트를 얻습니다.

이 API는 새로운 크라우드펀딩 기회를 발굴하거나, 잠재 투자를 평가하거나, 크라우드펀딩 시장의 최신 트렌드를 파악하고자 하는 분들에게 유용한 도구입니다.

Example Use Case
투자자는 크라우드펀딩 캠페인 API를 활용하여 다양한 크라우드펀딩 캠페인의 재무 건전성과 공모 세부 내용을 검토함으로써, 잠재적 투자 기회를 평가하고 포트폴리오를 다각화하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/crowdfunding-offerings-latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"cik": "0001532978",
		"companyName": "Gumroad, Inc.",
		"date": "09-22-2011",
		"filingDate": "2026-04-08 00:00:00",
		"acceptedDate": "2026-04-08 16:54:45",
		"formType": "C-AR",
		"formSignification": "Annual Report",
		"nameOfIssuer": "Gumroad, Inc.",
		"legalStatusForm": "Corporation",
		"jurisdictionOrganization": "DE",
		"issuerStreet": "548 Market St, #41309",
		"issuerCity": "San Francisco",
		"issuerStateOrCountry": "CA",
		"issuerZipCode": "94104",
		"issuerWebsite": "https://gumroad.com/",
		"intermediaryCompanyName": null,
		"intermediaryCommissionCik": "0001532978",
		"intermediaryCommissionFileNumber": null,
		"compensationAmount": null,
		"financialInterest": null,
		"securityOfferedType": null,
		"securityOfferedOtherDescription": null,
		"numberOfSecurityOffered": 0,
		"offeringPrice": 0,
		"offeringAmount": 0,
		"overSubscriptionAccepted": "N",
		"overSubscriptionAllocationType": null,
		"maximumOfferingAmount": 0,
		"offeringDeadlineDate": null,
		"currentNumberOfEmployees": 2,
		"totalAssetMostRecentFiscalYear": 11948947.05,
		"totalAssetPriorFiscalYear": 16720734.62,
		"cashAndCashEquiValentMostRecentFiscalYear": 6153268.63,
		"cashAndCashEquiValentPriorFiscalYear": 13821885.61,
		"accountsReceivableMostRecentFiscalYear": 0,
		"accountsReceivablePriorFiscalYear": 0,
		"shortTermDebtMostRecentFiscalYear": 4191955.58,
		"shortTermDebtPriorFiscalYear": 4635820.52,
		"longTermDebtMostRecentFiscalYear": 0,
		"longTermDebtPriorFiscalYear": 0,
		"revenue
```

---

### 188. Latest Earning Transcripts API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-transcripts

**Summary:**

FMP 최신 실적 발표 컨퍼런스콜 기록 API를 통해 기업의 이용 가능한 실적 발표 기록에 접근하세요. 실적 발표 기록이 있는 기업 목록과 각 기업별 이용 가능한 기록 수를 조회할 수 있습니다.

**About:**

FMP 최신 실적 발표 컨퍼런스콜 기록 API는 다양한 기업의 실적 발표 기록 이용 가능 여부에 대한 필수 데이터를 제공합니다. 이 API는 시간 경과에 따른 실적 성과를 추적하려는 재무 애널리스트, 투자자, 연구자에게 이상적입니다.

Identify Available Transcripts: 실적 발표 기록이 있는 기업 목록에 신속히 접근하고, 각 기업별 이용 가능한 기록 수를 확인합니다.
Support Earnings Analysis: 기록 수를 활용하여 실적 발표 데이터를 심층 분석하고 기업 성과에 대한 인사이트를 얻습니다.
Track Historical Data: 여러 기록이 있는 기업을 발굴하여 분기별 또는 연도별 실적 발표 추세를 추적합니다.

Example Use Case
여러 분기에 걸쳐 기업의 실적 성과를 분석하려는 투자자는 실적 발표 기록 목록 API를 활용하여 다수의 실적 발표 기록이 있는 기업을 파악하고, 심층 재무 분석을 위한 관련 문서를 조회할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earning-call-transcript-latest
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| limit | number | 100 |
| page | number | 0 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "CSWC",
		"period": "Q3",
		"fiscalYear": 2025,
		"date": "2025-02-04"
	}
]
```

---

### 189. Latest Financial Statements API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-financial-statements

**About:**

최신 재무제표 API는 가장 최근에 제출된 재무제표 목록을 제공합니다. symbol, 회계연도, 분기(period), 재무제표 날짜, 데이터베이스 추가 날짜 등의 정보를 포함하여, 최신 공시 재무 데이터를 신속히 파악하고자 하는 투자자, 애널리스트, 데이터 팀에게 유용합니다.

Endpoint:

https://financialmodelingprep.com/stable/latest-financial-statements?page=0&limit=250

**Endpoint:**

```
https://financialmodelingprep.com/stable/latest-financial-statements?page=0&limit=250
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 250 |
| Endpoint: | https://financialmodelingprep.com/stable/latest-financial-statements?page=0&limit=250 | Latest Financial Statements API Parameters |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "FGFI",
		"calendarYear": 2024,
		"period": "Q4",
		"date": "2024-12-31",
		"dateAdded": "2025-03-13 17:03:59"
	}
]
```

---

### 190. Latest House Financial Disclosures API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/house-latest

**Summary:**

FMP 최신 하원의원 재정 공시 API를 통해 미국 하원의원들의 실시간 재정 공시에 접근하세요. 최근 거래 내역, 자산 보유 현황, 재무적 보유 내역을 추적하여 정치인들의 금융 활동에 대한 투명성을 강화할 수 있습니다.

**About:**

FMP 최신 하원의원 재정 공시 API는 미국 하원의원 및 그 가족의 거래, 매각, 재무 자산 보유에 관한 최신 정보를 제공합니다. 이 API를 통해 사용자는 다음이 가능합니다:

Monitor House Member Transactions: 미국 하원의원 및 그 가족의 거래 내역과 자산 보유 현황을 상세히 기술한 최신 재정 공시에 접근합니다.
Comprehensive Transaction Data: 자산 유형, 거래 금액, 날짜, 자본 이득 보고 여부 등 상세한 정보를 확인합니다.
Stay Informed: 선출된 공직자들의 투자 활동에 대한 인사이트를 얻고 보유 자산의 변화를 추적합니다.

이 API는 정부 대표자들의 재정 활동에 있어 투명성과 책임성을 추구하는 사용자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/house-latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "BBIO",
		"disclosureDate": "2026-04-08",
		"transactionDate": "2026-03-19",
		"firstName": "Gilbert",
		"lastName": "Cisneros",
		"office": "Gilbert Cisneros",
		"district": "CA31",
		"owner": "",
		"assetDescription": "BRIDGEBIO PHARMA INC",
		"assetType": "Stock",
		"type": "Purchase",
		"amount": "$1,001 - $15,000",
		"capitalGainsOver200USD": "False",
		"comment": "",
		"link": "https://disclosures-clerk.house.gov/public_disc/ptr-pdfs/2026/20034285.pdf"
	}
]
```

---
### 191. Latest Insider Trading API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-insider-trade

**Summary:**

Latest Insider Trading API를 사용하여 최신 내부자 거래 활동에 접근하세요. 회사 내부자들이 어떤 주식을 매수하거나 매도하는지 추적하고 거래 내역을 분석하세요.

**About:**

FMP Latest Insider Trading API는 내부자 거래 활동에 관한 최신 정보를 제공합니다. 이 API를 통해 이사 및 임원을 포함한 회사 내부자들의 최근 주식 매수 및 매도 내역을 추적할 수 있습니다. 거래 날짜, 유형, 금액에 관한 세부 정보를 통해 기업 행동과 잠재적 시장 트렌드에 대한 인사이트를 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

Recent Insider Transactions: 회사 내부자들의 가장 최근 주식 매수 또는 매도 내역에 접근합니다.
Transaction Details: 거래 유형, 거래된 주식 수, 가격에 관한 상세 정보를 조회합니다.
Insider Roles: 이사 또는 임원과 같이 거래에 관여한 인물들의 역할을 확인합니다.
Comprehensive Data: 신고 날짜, 거래 날짜, 소유 유형, 공식 신고 문서 링크 등 핵심 정보에 접근합니다.

이 API는 시장 심리나 잠재적 투자 기회를 평가하기 위해 내부자 거래 활동을 추적하고자 하는 투자자, 애널리스트, 금융 조사자에게 이상적입니다.

Example Use Case
헤지펀드 매니저는 Latest Insider Trading API를 활용하여 회사 이사들의 최근 주식 매수 내역을 모니터링합니다. Larry Glasscock(SPG 이사)의 매수를 분석함으로써, 내부자의 매수 행동이 회사의 미래 실적에 대한 자신감을 신호하는지 평가하고 그에 맞게 투자 전략을 조정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/insider-trading/latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date | date | 2026-01-27 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "LAB",
		"filingDate": "2026-04-08",
		"transactionDate": "2026-03-20",
		"reportingCik": "0001559779",
		"companyCik": "0001162194",
		"transactionType": "A-Award",
		"securitiesOwned": 6594083,
		"reportingName": "Egholm Michael",
		"typeOfOwner": "director, officer: President & CEO",
		"acquisitionOrDisposition": "A",
		"directOrIndirect": "D",
		"formType": "4",
		"securitiesTransacted": 1042373,
		"price": 0,
		"securityName": "Common Stock",
		"url": "https://www.sec.gov/Archives/edgar/data/1162194/000119312526148615/0001193125-26-148615-index.htm"
	}
]
```

---

### 192. Latest Mergers & Acquisitions API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-mergers-acquisitions

**Summary:**

FMP Latest Mergers and Acquisitions API를 통해 최신 인수합병(M&A)에 관한 실시간 데이터에 접근하세요. 이 API는 거래 날짜, 회사명, 추가 분석을 위한 공시 문서 링크 등 핵심 정보를 제공합니다.

**About:**

FMP Latest Mergers and Acquisitions API는 기업 인수합병에 관한 가장 최신 정보를 제공하여, 기업 인수 및 거래에 관한 핵심 데이터에 접근할 수 있게 합니다. 주요 기능은 다음과 같습니다:

Transaction Details: 인수 기업과 피인수 기업을 포함하여 관련 기업들에 대한 정보를 확인합니다.
Filing Information: 거래의 심층 분석을 위해 SEC의 공식 신고 문서에 접근합니다.
Timely Updates: 최신 M&A 데이터를 통해 시장 통합에 관한 인사이트를 제공받으며 최신 동향을 파악합니다.

이 API는 기업 활동을 추적하고 최신 M&A 트렌드를 기반으로 정보에 입각한 의사결정을 내리고자 하는 애널리스트, 투자자, 기업 전략가에게 이상적입니다.

Example Use Case
투자 애널리스트는 Latest Mergers and Acquisitions API를 활용하여 최근 인수 사례를 추적하고 관련 기업들에 미치는 영향을 평가할 수 있습니다. 이 데이터는 시장 통합, 경쟁 역학, 잠재적 투자 기회를 분석하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/mergers-acquisitions-latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "ALGT",
		"companyName": "Allegiant Travel CO",
		"cik": "0001362468",
		"targetedCompanyName": "Sun Country Airlines Holdings, Inc.",
		"targetedCik": "0001743907",
		"targetedSymbol": "SNCY",
		"transactionDate": "2026-03-27",
		"acceptedDate": "2026-03-27 17:15:41",
		"link": "https://www.sec.gov/Archives/edgar/data/1362468/000114036126011799/ny20065073x3_s4.htm"
	}
]
```

---

### 193. Latest SEC Filings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/financials-latest

**Summary:**

FMP Latest SEC Filings API를 사용하여 상장 기업들의 가장 최신 SEC 공시 문서를 확인하세요. 재무제표, 연간 보고서, 8-K, 10-K, 10-Q 양식을 포함한 핵심 규제 문서에 접근하세요.

**About:**

FMP Latest SEC Filings API는 공개 기업이 제출한 최신 SEC 공시 문서에 실시간으로 접근할 수 있게 합니다. 이 API는 기업의 재무 공시 및 중요 사건에 대해 최신 정보를 유지해야 하는 투자자, 애널리스트, 컴플라이언스 전문가에게 필수적입니다. 주요 기능은 다음과 같습니다:

Comprehensive Filing Access: 8-K, 10-K, 10-Q 및 SEC가 요구하는 기타 필수 문서를 포함한 최근 공시 문서를 조회합니다.
Real-Time Updates: SEC에 접수되는 즉시 최신 공시 문서를 확인하여 팔로우하는 기업들의 모든 중요 동향에 대해 최신 정보를 유지합니다.
Direct Filing Links: 기업 공시의 심층 검토 및 분석을 위해 SEC 공시 원문 문서에 빠르게 접근합니다.

이 API는 규제 공시 현황을 파악하고 공개 기업의 재무 및 운영 건전성을 이해하는 데 있어 없어서는 안 될 자원입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-financials?from=2024-01-01&to=2024-03-01&page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from* | string | 2024-01-01 |
| to* | string | 2024-03-01 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "MTZ",
		"cik": "0000015615",
		"filingDate": "2024-03-01 00:00:00",
		"acceptedDate": "2024-02-29 21:24:32",
		"formType": "8-K",
		"hasFinancials": true,
		"link": "https://www.sec.gov/Archives/edgar/data/15615/000119312524054015/0001193125-24-054015-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/15615/000119312524054015/d775448dex991.htm"
	}
]
```

---

### 194. Latest Senate Financial Disclosures API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/senate-latest

**Summary:**

FMP Latest Senate Financial Disclosures API를 통해 미국 상원의원들의 최신 재무 공시 정보에 접근하세요. 정부 재정 활동의 투명성 제고를 위해 최근 거래, 자산 보유 현황, 거래 세부 내역을 추적하세요.

**About:**

FMP Latest Senate Financial Disclosures API는 미국 상원의원들의 거래 및 자산 보유 현황에 관한 최신 정보를 제공합니다. 이 API를 통해 사용자는 다음을 수행할 수 있습니다:

Monitor Senate Member Transactions: 미국 상원의원 및 그 가족이 수행한 거래, 매도, 매수에 관한 공시 정보를 실시간으로 접근합니다.
Detailed Transaction Data: 자산 유형(주식, 채권, 부동산), 거래 날짜, 금액, 소유 유형을 포함한 거래 세부 정보를 조회합니다.
Stay Informed: 주요 정치 인사들의 재정 활동에 대한 최신 정보를 유지하기 위해 최근 공시를 팔로우합니다.

이 API는 정치 인사들의 재정 활동을 추적하고 그들의 투자 행동을 파악하고자 하는 사람들에게 필수적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/senate-latest?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "PEP",
		"disclosureDate": "2026-04-08",
		"transactionDate": "2026-03-30",
		"firstName": "Sheldon",
		"lastName": "Whitehouse",
		"office": "Sheldon Whitehouse",
		"district": "RI",
		"owner": "Spouse",
		"assetDescription": "PepsiCo Inc",
		"assetType": "Stock",
		"type": "Sale",
		"amount": "$1,001 - $15,000",
		"comment": "",
		"link": "https://efdsearch.senate.gov/search/view/ptr/853d0789-28db-4789-9654-a73cff7740d7/"
	}
]
```

---

### 195. Levered DCF API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/dcf-levered

**Summary:**

부채의 영향을 반영한 FMP Levered Discounted Cash Flow(DCF) API로 기업 가치를 분석하세요. 이 API는 부채 차감 후 기업 가치를 제공하여, 부채 의무를 고려한 기업의 실질 가치를 투자자가 더 정확하게 측정할 수 있도록 합니다.

**About:**

Levered DCF API는 기업 가치를 더 정밀하게 평가하고자 하는 투자자와 애널리스트를 위해 설계되었습니다. 부채를 반영함으로써 기업 가치에 대한 현실적인 추정치를 제공합니다. 주요 기능은 다음과 같습니다:

Post-Debt Valuation: 부채 부담을 고려한 기업의 명확한 가치를 제공하며, 이는 투자의 위험-수익 프로파일을 평가하는 데 매우 중요합니다.
DCF Value vs. Market Price: 할인된 현금 흐름 가치와 현재 주가를 비교하여 주식이 고평가 또는 저평가되어 있는지 평가합니다.
Informed Investment Decisions: Levered DCF 접근 방식을 통해 투자자는 재무적 의무가 기업 가치에 미치는 영향을 이해함으로써 더 나은 의사결정을 내릴 수 있습니다.

이 API는 심층적인 재무 분석을 수행하고 기업 가치평가에 대한 전체적인 시각을 확보하는 데 필수적입니다.

Example Use Case
Apple 주식 매수 여부를 검토하는 투자자는 Levered DCF API를 활용하여 회사의 DCF 가치와 현재 주가를 비교할 수 있습니다. DCF 가치가 시장 가격보다 현저히 낮다면, 투자자는 회사의 부채 의무를 고려하여 매수를 재고할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/levered-discounted-cash-flow?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2026-04-08",
		"dcf": 152.32738976131944,
		"Stock Price": 258.25
	}
]
```

---

### 196. Light Chart API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/commodities-historical-price-eod-light

**Summary:**

FMP Historical Commodities Price API를 통해 다양한 원자재의 과거 일별 종가 데이터에 접근하세요. 과거 가격 변동, 거래량, 추세를 분석하여 정보에 기반한 의사결정을 지원합니다.

**About:**

FMP Historical Commodities Price API는 광범위한 원자재에 대한 일별 종가 데이터에 접근할 수 있도록 합니다. 이 API는 원자재 시장에 대한 과거 분석을 수행하고, 가격 추세를 추적하며, 과거 데이터를 바탕으로 정보에 입각한 예측을 내리고자 하는 투자자, 트레이더, 애널리스트를 위해 설계되었습니다.

End-of-Day Pricing: 거래량 등 핵심 지표를 포함하여 원자재의 정확한 과거 가격을 조회함으로써 시간에 따른 시장 성과를 분석합니다.
Comprehensive Historical Data: 선택한 기간 동안의 원자재 가격 변동에 대한 상세한 기록에 접근합니다.
Trading Volume Insights: 가격 정보와 함께 제공되는 거래량 데이터로 각 원자재의 거래 활동을 평가합니다.

이 API는 연구, 리스크 관리, 전략적 거래 목적의 과거 원자재 데이터 분석이 필요한 금융 전문가에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/light?symbol=GCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | GCUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "GCUSD",
		"date": "2025-07-24",
		"price": 3373.8,
		"volume": 174758
	}
]
```

---

### 197. Market Risk Premium API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/market-risk-premium

**Summary:**

FMP Market Risk Premium API를 통해 특정 날짜의 시장 위험 프리미엄에 접근하세요. 이 핵심 금융 지표를 활용하여 무위험 투자 대비 주식 시장 투자에서 기대되는 추가 수익률을 평가하세요.

**About:**

FMP Market Risk Premium API는 금융 분석 및 투자 의사결정에서 핵심적인 척도인 시장 위험 프리미엄을 제공합니다. 이 지표는 주식 시장의 기대 수익률과 무위험 수익률 간의 차이를 나타내며, 다음과 같은 용도에 필수적입니다:

Investment Valuation: 시장 위험 프리미엄은 자기자본비용을 산출하고 투자 가치를 평가하는 데 있어 기본적인 구성 요소입니다. 프리미엄을 파악함으로써 투자자는 투자의 잠재적 수익이 위험을 감수할 만한지 평가할 수 있습니다.
Risk Assessment: 시장 위험 프리미엄을 이해하면 투자자가 무위험 수익률 대비 감수하는 위험 수준을 가늠하는 데 도움이 됩니다. 이는 자산 배분 및 포트폴리오 관리 의사결정에 반영될 수 있습니다.
Financial Modeling: 시장 위험 프리미엄은 투자의 기대 수익률을 추정하기 위해 자본자산가격결정모형(CAPM)과 같은 모델에서 자주 활용됩니다. 신뢰할 수 있는 재무 모델링을 위해서는 정확한 시장 위험 프리미엄 데이터가 필수적입니다.

Analyst Use Case
애널리스트는 Market Risk Premium API를 활용하여 주식 투자의 기대 수익률을 산출할 수 있습니다. 기대 시장 수익률에서 무위험 수익률을 차감함으로써 해당 투자가 관련 위험을 감수하기에 충분한 프리미엄을 제공하는지 판단할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/market-risk-premium
```

**Sample Response:**

```json
[
	{
		"country": "Zimbabwe",
		"continent": "Africa",
		"countryRiskPremium": 11.66,
		"totalEquityRiskPremium": 15.89
	}
]
```

---

### 198. Market Sector Performance Snapshot API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/sector-performance-snapshot

**Summary:**

Market Sector Performance Snapshot API를 통해 섹터 성과의 스냅샷을 확인하세요. 섹터별 평균 변동률을 기반으로 시장에서 다양한 업종이 어떻게 성과를 내고 있는지 분석하세요.

**About:**

FMP Market Sector Performance Snapshot API는 다양한 주식 거래소에 걸쳐 각 섹터의 성과에 대한 실시간 인사이트를 제공합니다. 이 API를 통해 기초 소재(Basic Materials), 기술(Technology), 헬스케어(Healthcare) 등 다양한 업종의 평균 성과를 추적하여 애널리스트와 투자자가 어느 시점에서든 시장의 각 부분이 어떻게 움직이는지 파악할 수 있습니다. 주요 기능은 다음과 같습니다:

Sector-Specific Performance Data: 각 섹터의 평균 등락률을 포함한 다양한 섹터의 성과 데이터에 접근합니다.
Exchange-Specific Analysis: NASDAQ, NYSE 등 특정 거래소별 섹터 성과를 분석합니다.
Daily Snapshots: 일별 섹터 성과 업데이트를 통해 실시간으로 트렌드와 시장 역학을 추적합니다.
Cross-Industry Comparisons: 다양한 섹터의 성과를 비교하여 시장의 주요 분야에서 성장 또는 하락을 파악합니다.

이 API는 정보에 입각한 투자 결정을 내리기 위해 섹터 수준의 성과를 추적해야 하는 금융 애널리스트, 포트폴리오 매니저, 트레이더에게 이상적입니다.

Example Use Case
포트폴리오 매니저는 Market Sector Performance Snapshot API를 활용하여 특정 날짜에 NASDAQ에서 각 섹터가 어떻게 성과를 냈는지 검토합니다. 기초 소재(Basic Materials) 섹터가 평균 -0.31% 하락했음을 확인하고, 섹터 배분을 조정하여 성과가 우수한 업종으로 포커스를 전환할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sector-performance-snapshot?date=2024-02-01
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date* | string | 2024-02-01 |
| exchange | string | NASDAQ |
| sector | string | Energy |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"sector": "Basic Materials",
		"exchange": "NASDAQ",
		"averageChange": -0.31481377464310634
	}
]
```

---

### 199. Mutual Fund & ETF Disclosure API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/latest-disclosures

**Summary:**

FMP Mutual Fund & ETF Disclosure API를 통해 뮤추얼 펀드 및 ETF의 최신 공시 정보에 접근하세요. 이 API는 뮤추얼 펀드 및 ETF에 대한 공시 문서 제출 현황, 보유 종목 변경 사항, 기타 중요한 공시 데이터에 대한 업데이트를 제공합니다.

**About:**

FMP Mutual Fund & ETF Disclosure API는 뮤추얼 펀드 및 ETF의 보유 종목과 전략 변경에 관한 최신 정보를 제공합니다. 이 API는 다음이 필요한 투자자, 애널리스트, 금융 전문가를 위해 설계되었습니다:

Track Fund Holdings: 뮤추얼 펀드 및 ETF가 공시한 최신 보유 종목을 파악하고, 보유 주식 수와 포트폴리오에서의 비중을 확인합니다.
Monitor Strategy Changes: 업데이트된 공시 문서를 검토하여 투자 포커스의 변화나 포트폴리오 리밸런싱을 나타낼 수 있는 펀드 전략 변화를 감지합니다.
Gain Insight into Major Funds: 최신 공시 문서에 접근하여 Vanguard나 BlackRock과 같은 주요 기관 투자자들의 투자 결정을 파악합니다.

예를 들어, 투자자는 이 API를 활용하여 Vanguard 뮤추얼 펀드의 최신 공시를 추적하고, 펀드가 특정 주식에 대한 포지션을 늘렸는지 줄였는지 분석하여 자신의 투자 전략을 수립하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/funds/disclosure-holders-latest?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"cik": "0000106444",
		"holder": "VANGUARD FIXED INCOME SECURITIES FUNDS",
		"shares": 67030000,
		"dateReported": "2024-07-31",
		"change": 0,
		"weightPercent": 0.03840197
	}
]
```

---

### 200. Mutual Fund & ETF Disclosure Name Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/disclosures-name-search

**Summary:**

Mutual Fund & ETF Disclosure Name Search API를 사용하여 이름으로 뮤추얼 펀드 및 ETF 공시 정보를 간편하게 검색하세요. 이 API를 통해 펀드 또는 ETF 이름을 기반으로 특정 보고서와 공시 문서를 찾고, CIK 번호, 법인 정보, 보고 파일 번호 등 핵심 세부 정보를 확인할 수 있습니다.

**About:**

Mutual Fund & ETF Disclosure Name Search API는 특정 펀드 이름으로 검색하여 뮤추얼 펀드 및 ETF의 공시 문서를 빠르게 찾을 수 있도록 도와줍니다. 펀드의 symbol, CIK, 클래스 정보, 보고 법인 주소 등 중요한 데이터를 반환합니다. 컴플라이언스, 조사, 또는 투자 의사결정을 위해 상세한 공시 정보가 필요한 투자자, 애널리스트, 연구자에게 이상적입니다.

Fund Name Search: 펀드 또는 법인 이름을 사용하여 뮤추얼 펀드 및 ETF의 공시 정보를 조회합니다.
Key Filing Details: CIK 번호, 시리즈 및 클래스 ID, 법인명, 보고 파일 번호 등 중요한 정보를 확인합니다.
Comprehensive Results: 검색한 펀드 또는 ETF 법인의 주소 세부 정보와 공시 문서 정보를 반환하여 관련 문서를 쉽게 찾을 수 있습니다.

이 API는 뮤추얼 펀드 및 ETF에 대한 실사(due diligence) 또는 조사를 수행하는 모든 사람에게 적합하며, 정밀하고 효율적인 공시 검색을 가능하게 합니다.

Example Use Case
금융 애널리스트는 Mutual Fund & ETF Disclosure Name Search API를 활용하여 뮤추얼 펀드 이름을 입력해 해당 펀드의 특정 공시 문서를 조회하고, 관련 규제 공시 및 보고서를 검토하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/funds/disclosure-holders-search?name=Federated Hermes Government Income Securities, Inc.
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | Federated Hermes Government Income Securities, Inc. |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "FGOAX",
		"cik": "0000355691",
		"classId": "C000024574",
		"seriesId": "S000009042",
		"entityName": "Federated Hermes Government Income Securities, Inc.",
		"entityOrgType": "30",
		"seriesName": "Federated Hermes Government Income Securities, Inc.",
		"className": "Class A Shares",
		"reportingFileNumber": "811-03266",
		"address": "4000 ERICSSON DRIVE",
		"city": "WARRENDALE",
		"zipCode": "15086-7561",
		"state": "PA"
	}
]
```

---
### 201. Mutual Fund Disclosures API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/mutual-fund-disclosures

**Summary:**

FMP Mutual Fund Disclosures API를 통해 뮤추얼 펀드의 포괄적인 공시 데이터에 접근하세요. 최근 공시 파일, 대차대조표, 재무 보고서를 분석하여 뮤추얼 펀드 포트폴리오에 대한 인사이트를 얻을 수 있습니다.

**About:**

FMP Mutual Fund Disclosures API는 뮤추얼 펀드 보유 자산 및 최근 공시 파일에 대한 상세한 정보를 제공하여 투자자와 금융 전문가가 다음을 수행할 수 있도록 합니다:

Track Fund Holdings: 뮤추얼 펀드 보유 자산의 가장 최신 공시를 검토하며, 자산 유형, 발행사 정보, 투자 국가 등이 포함됩니다. 이를 통해 다양한 뮤추얼 펀드의 포트폴리오 구성을 파악할 수 있습니다.
Analyze Recent Filings: 뮤추얼 펀드의 중요한 재무 보고서 및 공시 파일을 확보하며, 잔액 데이터, USD 기준 시장 가치, 총 포트폴리오 가치 대비 비율 등이 포함됩니다. 이러한 인사이트는 투자 분석 및 전략 수립에 도움이 됩니다.
Gain Transparency into Investments: API는 CUSIP, ISIN, 발행사 유형, 공정 가치 등급 등 핵심 세부 정보를 제공하여 뮤추얼 펀드 투자에 대한 완전한 투명성을 제공합니다.

예를 들어, 투자자는 이 API를 통해 Realty Income Corp 같은 뮤추얼 펀드의 보유 내역을 검토하고, 잔액, USD 환산 가치, 포트폴리오 배분 비율을 분석하여 정보에 기반한 투자 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/funds/disclosure?symbol=VWO&year=2023&quarter=4
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | VWO |
| year* | string | 2023 |
| quarter* | string | 4 |
| cik | string | 0000857489 |

**Sample Response:**

```json
[
	{
		"cik": "0000857489",
		"date": "2023-10-31",
		"acceptedDate": "2023-12-28 09:26:13",
		"symbol": "000089.SZ",
		"name": "Shenzhen Airport Co Ltd",
		"lei": "3003009W045RIKRBZI44",
		"title": "SHENZ AIRPORT-A",
		"cusip": "N/A",
		"isin": "CNE000000VK1",
		"balance": 2438784,
		"units": "NS",
		"cur_cd": "CNY",
		"valUsd": 2255873.6,
		"pctVal": 0.0023838966190458215,
		"payoffProfile": "Long",
		"assetCat": "EC",
		"issuerCat": "CORP",
		"invCountry": "CN",
		"isRestrictedSec": "N",
		"fairValLevel": "2",
		"isCashCollateral": "N",
		"isNonCashCollateral": "N",
		"isLoanByFund": "N"
	}
]
```

---

### 202. Mutual Fund Price Quotes API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/full-mutualfund-quotes

**Summary:**

FMP Mutual Fund Price Quotes API를 통해 뮤추얼 펀드의 실시간 시세에 접근하세요. 다양한 뮤추얼 펀드의 현재 가격, 성과 변동, 핵심 데이터를 추적할 수 있습니다.

**About:**

FMP Mutual Fund Price Quotes API는 뮤추얼 펀드에 대한 실시간 가격 정보와 성과 업데이트를 제공합니다. 투자자와 애널리스트는 이 API를 통해 다음을 수행할 수 있습니다:

Monitor Mutual Fund Performance: 뮤추얼 펀드의 최신 가격 움직임과 성과 변화를 지속적으로 파악합니다.
Track Investment Value: 가격 데이터를 활용하여 뮤추얼 펀드 투자의 가치를 실시간으로 평가합니다.
Analyze Trends: 여러 뮤추얼 펀드의 성과를 비교하여 정보에 기반한 투자 결정과 포트폴리오 조정을 수행합니다.

이 API는 뮤추얼 펀드 가격 및 성과 데이터를 지속적으로 파악하고자 하는 투자자에게 필수적인 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-mutualfund-quotes
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| short | boolean | true |

**Sample Response:**

```json
[
	{
		"symbol": "ARCFX",
		"price": 9.84,
		"change": 0.01,
		"volume": 0
	}
]
```

---

### 203. Nasdaq Index API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/nasdaq

**Summary:**

Nasdaq Index API를 통해 Nasdaq 지수의 포괄적인 데이터에 접근하세요. 이 대표적인 주식 거래소에 상장된 기업들의 실시간 움직임을 모니터링하고 과거 성과를 추적할 수 있습니다.

**About:**

FMP Nasdaq Index API는 Nasdaq 주식 거래소에 상장된 기업들에 대한 최신 정보를 제공합니다. 이 API는 회사명, symbol, 섹터, 하위 섹터, 본사 위치, 설립일 등 각 구성 종목에 대한 핵심 세부 정보를 제공합니다. 실시간 움직임 추적이든 과거 분석이든, 세계 최대 주식 거래소 중 하나의 데이터가 필요한 분들에게 필수 API입니다. 주요 기능은 다음과 같습니다:

Company Information: Nasdaq 상장 기업의 산업 분류 및 본사 위치를 포함한 상세 데이터에 접근합니다.
Real-Time Monitoring: Nasdaq 구성 종목에 대한 현재의 최신 정보를 추적합니다.
Historical Insights: 기업 설립일 및 산업 세그먼트에 관한 데이터를 분석하여 장기 추세를 파악합니다.
Sector and Sub-Sector Breakdown: 다양한 산업 및 섹터 전반에 걸친 기업 분포를 평가합니다.

이 API는 Nasdaq 상장 기업에 대한 실시간 인사이트와 과거 데이터가 필요한 트레이더, 포트폴리오 매니저, 애널리스트에게 유용한 자원입니다.

Example Use Case
기술 섹터를 모니터링하는 금융 애널리스트가 Nasdaq Index API를 활용하여 Apple Inc. (AAPL) 등 Nasdaq 상장 기업들의 실시간 성과를 추적합니다. 섹터별 데이터를 조회함으로써 시장 추세에 대한 정보에 기반한 결정을 내리고 기술 산업에서의 잠재적 투자 기회를 발굴합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/nasdaq-constituent
```

**Sample Response:**

```json
[
	{
		"symbol": "ADBE",
		"name": "Adobe Inc.",
		"sector": "Technology",
		"subSector": "Software - Infrastructure",
		"headQuarter": "San Jose, CA",
		"dateFirstAdded": null,
		"cik": "0000796343",
		"founded": "1982-12-01"
	}
]
```

---

### 204. Owner Earnings API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/owner-earnings

**Summary:**

Owner Earnings API를 통해 기업의 주주 이익(owner earnings)을 조회하세요. 이 API는 순이익을 조정하여 주주에게 실제로 귀속되는 현금을 보다 정확하게 산출합니다. 이 지표는 투자자 관점에서 기업의 수익성을 평가하는 데 매우 중요합니다.

**About:**

Owner Earnings API는 자본적 지출(Capex) 및 감가상각 등 핵심 요인을 반영하여 조정된 기업 현금흐름의 세부 내역을 제공합니다. 다음 용도에 적합합니다:

Investor Evaluation: 주주에게 실제로 귀속되는 현금을 산출하여 순이익을 넘어선 수익성을 보다 명확하게 파악합니다.
Valuation Analysis: 주주 이익을 활용하여 장기 투자 관점에서 기업 가치 평가 시 정보에 기반한 결정을 내립니다.
Capex Insight: 유지 및 성장 자본적 지출(Capex)에 대한 인사이트를 확보하여 기업 수익 중 재투자 비율을 평가합니다.
Owner Earnings Per Share: 주당 귀속 가치를 추적하여 해당 주식이 좋은 투자인지 판단하는 데 활용합니다.

이 API는 특히 장기 수익을 추구하는 가치 투자자에게 기업의 수익성과 현금흐름 잠재력을 포괄적으로 제공합니다.

Example Use Case
투자자가 Owner Earnings API를 활용하여 Apple의 실질 현금 수익을 평가한 후 추가 매수를 결정함으로써, 기업의 수익이 자신의 장기 투자 전략과 부합하는지 확인합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/owner-earnings?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 5 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"reportedCurrency": "USD",
		"fiscalYear": "2025",
		"period": "Q1",
		"date": "2024-12-28",
		"averagePPE": 0.13969,
		"maintenanceCapex": -2279964750,
		"ownersEarnings": 27655035250,
		"growthCapex": -660035250,
		"ownersEarningsPerShare": 1.83
	}
]
```

---

### 205. Positions Summary API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/positions-summary

**Summary:**

Positions Summary API는 특정 주식 symbol에 대한 기관 보유 현황의 포괄적인 스냅샷을 제공합니다. 해당 주식을 보유한 투자자 수, 보유 주식 수 변화, 총 투자 금액, 시간 경과에 따른 소유 비율 등 핵심 지표를 추적합니다.

**About:**

Positions Summary API를 통해 특정 주식에 대한 기관 포지션을 분석할 수 있습니다. 제공 데이터에는 해당 주식을 보유한 투자자 수, 보유 주식 수, 총 투자 금액, 일정 기간 동안의 변동 사항이 포함됩니다. 다음 용도에 적합합니다:

Tracking Institutional Investment Trends: 기관 투자자들이 시간 경과에 따라 특정 주식의 포지션을 어떻게 변경하는지 모니터링합니다.
Ownership Insights: 기관 투자자가 기업의 몇 퍼센트를 보유하고 있는지, 그리고 이 비율이 어떻게 변화하는지 파악합니다.
Call & Put Analysis: 풋/콜 비율(put/call ratio)에 대한 인사이트를 얻고 기관 포지션의 옵션 활동을 추적합니다.

이 API는 시장 내 기관 활동을 이해하고 주요 투자자들의 행동 패턴을 파악하는 데 이상적입니다. 특정 주식에 대한 기관 동향을 면밀히 추적하고자 하는 투자자, 애널리스트, 포트폴리오 매니저에게 필수적인 도구입니다.

Example Use Case
헤지펀드 매니저가 Positions Summary API를 활용하여 Apple (AAPL)에 대한 기관 소유 추세를 추적하고, 포지션을 늘리거나 줄이는 기관 수를 모니터링하여 전반적인 시장 심리를 평가합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/institutional-ownership/symbol-positions-summary?symbol=AAPL&year=2023&quarter=3
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| year* | string | 2023 |
| quarter* | string | 3 |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"date": "2023-09-30",
		"investorsHolding": 4805,
		"lastInvestorsHolding": 4749,
		"investorsHoldingChange": 56,
		"numberOf13Fshares": 9247670386,
		"lastNumberOf13Fshares": 9345671472,
		"numberOf13FsharesChange": -98001086,
		"totalInvested": 1613733330618,
		"lastTotalInvested": 1825154796061,
		"totalInvestedChange": -211421465443,
		"ownershipPercent": 59.2821,
		"lastOwnershipPercent": 59.5356,
		"ownershipPercentChange": -0.2535,
		"newPositions": 158,
		"lastNewPositions": 188,
		"newPositionsChange": -30,
		"increasedPositions": 1921,
		"lastIncreasedPositions": 1775,
		"increasedPositionsChange": 146,
		"closedPositions": 156,
		"lastClosedPositions": 122,
		"closedPositionsChange": 34,
		"reducedPositions": 2375,
		"lastReducedPositions": 2506,
		"reducedPositionsChange": -131,
		"totalCalls": 173528138,
		"lastTotalCalls": 198746782,
		"totalCallsChange": -25218644,
		"totalPuts": 192878290,
		"lastTotalPuts": 177007062,
		"totalPutsChange": 15871228,
		"putCallRatio": 1.1115,
		"lastPutCallRatio": 0.8906,
		"putCallRatioChange": 22.0894
	}
]
```

---

### 206. Press Releases API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/press-releases

**Summary:**

FMP Press Releases API를 통해 기업의 공식 보도자료에 접근하세요. 기업 발표, 실적 보고서, 인수합병 등에 대한 실시간 업데이트를 확인할 수 있습니다.

**About:**

Press Releases API는 기업의 공식 발표에 실시간으로 접근할 수 있도록 하여 투자자, 애널리스트, 비즈니스 전문가가 최신 동향을 파악할 수 있게 합니다. 이 API는 다음 용도에 매우 중요합니다:

Company Announcements: 기업으로부터 직접 실적 보고서, 신제품 출시, 인수합병 등의 소식을 신속하게 파악합니다.
Strategic Updates: 기업의 시장 지위에 영향을 미칠 수 있는 경영진 변경, 사업 구조 조정, 기타 중요한 기업 전략 변화를 추적합니다.
Market Impact Analysis: 기업 보도자료가 주가, 기업 가치, 시장 심리에 미치는 영향을 분석합니다.

이 API를 통해 가장 최신의 보도자료에 접근하여 기업의 최신 공시를 바탕으로 정보에 기반한 결정을 내릴 수 있습니다.

Example Use Case
금융 애널리스트가 Press Releases API를 활용하여 상장 기업들의 기업 발표를 모니터링하고, 투자 결정에 필요한 핵심 인사이트를 확보합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/press-releases-latest?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |

**Sample Response:**

```json
[
	{
		"symbol": "LNW",
		"publishedDate": "2025-02-03 23:32:00",
		"publisher": "PRNewsWire",
		"title": "Rosen Law Firm Encourages Light & Wonder, Inc. Investors to Inquire About Securities Class Action Investigation - LNW",
		"image": "https://images.financialmodelingprep.com/news/rosen-law-firm-encourages-light-wonder-inc-investors-to-20250203.jpg",
		"site": "prnewswire.com",
		"text": "NEW YORK , Feb. 3, 2025 /PRNewswire/ -- Why: Rosen Law Firm, a global investor rights law firm, continues to investigate potential securities claims on behalf of shareholders of Light & Wonder, Inc. (NASDAQ: LNW) resulting from allegations that Light & Wonder may have issued materially misleading business information to the investing public. So What: If you purchased Light & Wonder securities you may be entitled to compensation without payment of any out of pocket fees or costs through a contingency fee arrangement.",
		"url": "https://www.prnewswire.com/news-releases/rosen-law-firm-encourages-light--wonder-inc-investors-to-inquire-about-securities-class-action-investigation--lnw-302366877.html"
	}
]
```

---

### 207. Price Target Consensus API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/price-target-consensus

**Summary:**

FMP Price Target Consensus API를 통해 애널리스트들의 컨센서스 목표 주가에 접근하세요. 이 API는 주식에 대한 최고, 최저, 중앙값, 컨센서스 목표 주가를 제공하여 미래 주가에 대한 시장 기대치를 종합적으로 파악할 수 있게 합니다.

**About:**

FMP Price Target Consensus API는 애널리스트들의 목표 주가를 종합하여 주가 전망에 대한 핵심 인사이트를 제공합니다. 이를 통해 투자자들은 다음 지표를 기반으로 더 정보에 기반한 결정을 내릴 수 있습니다:

High Price Target: 애널리스트들이 예측한 최고 목표 주가를 확인합니다.
Low Price Target: 주식의 최저 예상 가격에 접근하여 하방 리스크에 대한 인사이트를 얻습니다.
Median Price Target: 애널리스트 예측의 중심 경향을 파악하기 위한 중앙값 목표 주가를 확인합니다.
Consensus Price Target: 애널리스트 전망치의 평균을 반영하는 전체 컨센서스 목표가를 조회합니다.

이 API는 가격 기대치에 대한 폭넓은 시각을 제공하여 전문가 예측을 바탕으로 주가 움직임의 잠재적 범위를 평가하는 데 도움을 줍니다.

Example Use Case
포트폴리오 매니저가 Price Target Consensus API를 활용하여 주식의 잠재적 상승 및 하락 가능성을 평가하고, 최고, 최저, 중앙값, 컨센서스 목표 주가를 사용하여 투자 결정을 위한 위험-보상 시나리오를 구성합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/price-target-consensus?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"targetHigh": 300,
		"targetLow": 200,
		"targetConsensus": 251.7,
		"targetMedian": 258
	}
]
```

---

### 208. Price Target Summary API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/price-target-summary

**Summary:**

FMP Price Target Summary API를 통해 주가에 대한 애널리스트들의 기대치를 파악하세요. 이 API는 다양한 기간에 걸친 애널리스트들의 평균 목표 주가에 접근하여 전문가 의견을 기반으로 미래 주가 성과를 평가하는 데 도움을 줍니다.

**About:**

FMP Price Target Summary API를 통해 개별 주식에 대한 애널리스트 목표 주가를 추적하고 분석할 수 있으며, 시장 심리를 파악하려는 투자자와 애널리스트에게 유용한 도구입니다. 주요 기능은 다음과 같습니다:

Average Price Targets: 지난 1개월, 분기, 연도, 전체 기간 등 다양한 구간에 걸친 애널리스트들의 평균 목표 주가에 접근합니다.
Price Target History: 시간에 따른 가격 기대치 변화를 추적하여 애널리스트 전망의 변화 흐름을 파악합니다.
Analyst Coverage: 특정 기간 동안 목표 주가를 제시한 애널리스트 수를 조회합니다.
Multiple Publishers: Benzinga, MarketWatch, Barrons 등 목표 주가 데이터를 제공하는 출처 및 발행사 목록을 확인합니다.

이 API를 통해 주식의 미래 가격 움직임에 대한 금융 애널리스트들의 컨센서스를 신속하게 평가할 수 있습니다.

Example Use Case
투자자가 Price Target Summary API를 활용하여 지난 분기와 연간 주식 평균 목표 주가를 비교함으로써, 시간 경과에 따라 애널리스트들의 전망이 강세로 바뀌었는지 약세로 바뀌었는지 판단합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/price-target-summary?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"lastMonthCount": 1,
		"lastMonthAvgPriceTarget": 200.75,
		"lastQuarterCount": 3,
		"lastQuarterAvgPriceTarget": 204.2,
		"lastYearCount": 48,
		"lastYearAvgPriceTarget": 232.99,
		"allTimeCount": 167,
		"allTimeAvgPriceTarget": 201.21,
		"publishers": "[\"Benzinga\",\"StreetInsider\",\"TheFly\",\"Pulse 2.0\",\"TipRanks Contributor\",\"MarketWatch\",\"Investing\",\"Barrons\",\"Investor's Business Daily\"]"
	}
]
```

---

### 209. Price Target Summary Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/price-target-summary-bulk

**Summary:**

Price Target Summary Bulk API는 여러 기간에 걸쳐 모든 상장 symbol의 목표 주가에 대한 포괄적인 개요를 제공합니다. 이 API를 통해 투자자와 애널리스트는 다양한 기간에 걸쳐 현재 주가와 목표 주가를 빠르게 비교할 수 있습니다.

**About:**

이 API를 통해 모든 기업의 목표 주가에 접근하여 다음과 같은 인사이트를 얻을 수 있습니다:

Price Targets Over Timeframes: 지난 1개월, 분기, 연도, 전체 기간에 대한 인사이트를 포함하여 symbol별 목표 주가 데이터를 조회합니다.
Average Price Target: 각 symbol에 대해 애널리스트와 시장 전문가들이 설정한 평균 목표 주가를 확인합니다.
Price Target Differences: 다양한 기간에 걸쳐 현재 주가와 목표 주가 간의 차이를 백분율로 분석합니다.
Publisher Data: 해당 목표 주가를 제공하는 출처 및 발행사를 확인하여 데이터의 맥락과 신뢰성을 파악합니다.

Price Target Summary Bulk API는 주가 전망 및 애널리스트 기대치에 대한 총체적인 시각이 필요한 기관 투자자, 애널리스트, 트레이더에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/price-target-summary-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "A",
		"lastMonthCount": "0",
		"lastMonthAvgPriceTarget": "0",
		"lastQuarterCount": "1",
		"lastQuarterAvgPriceTarget": "116",
		"lastYearCount": "6",
		"lastYearAvgPriceTarget": "142.17",
		"allTimeCount": "18",
		"allTimeAvgPriceTarget": "146.61",
		"publishers": "[\"\"TheFly\""
	}
]
```

---

### 210. Ratings Snapshot API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/ratings-snapshot

**Summary:**

FMP Ratings Snapshot API를 통해 기업의 재무 건전성과 성과를 신속하게 평가하세요. 이 API는 데이터베이스에 등록된 주식 symbol에 대한 포괄적인 재무 등급 스냅샷을 주요 재무 비율을 기반으로 제공합니다.

**About:**

FMP Ratings Snapshot API를 통해 사용자는 다음 항목을 제공함으로써 여러 차원에서 기업의 재무 성과를 평가할 수 있습니다:

Overall Rating: 기업의 재무 상태를 반영하는 종합 점수를 확인합니다.
Discounted Cash Flow (DCF) Score: 미래 현금흐름 잠재력 대비 기업 가치를 파악합니다.
Return on Equity (ROE) Score: 주주 자본 대비 이익 창출 효율성을 측정합니다.
Return on Assets (ROA) Score: 기업이 자산을 활용하여 수익을 창출하는 효과성을 평가합니다.
Debt-to-Equity Score: 부채와 자본을 비교하여 기업의 자본 구조와 리스크를 분석합니다.
Price-to-Earnings (P/E) Score: 수익 대비 주가를 평가하여 기업의 가치를 파악합니다.
Price-to-Book (P/B) Score: 기업의 시장 가격과 장부 가치를 비교하여 잠재적 투자 기회를 평가합니다.

이 API는 할인된 현금흐름(DCF), 자기자본이익률(ROE), 총자산이익률(ROA), 부채비율, 주가수익비율(P/E), 주가순자산비율(P/B) 등 핵심 지표에 대한 점수와 함께 전체 등급을 제공합니다. 핵심 지표를 기반으로 기업의 재무 건전성을 빠르고 종합적으로 파악해야 하는 투자자, 금융 애널리스트, 연구자에게 적합합니다.

Example Use Case
주식 애널리스트가 Ratings Snapshot API를 활용하여 자기자본이익률(ROE), 부채 수준, 밸류에이션 비율을 기준으로 여러 기업의 재무 건전성을 비교하고, 보다 정보에 기반한 투자 추천을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ratings-snapshot?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"rating": "A-",
		"overallScore": 4,
		"discountedCashFlowScore": 3,
		"returnOnEquityScore": 5,
		"returnOnAssetsScore": 5,
		"debtToEquityScore": 4,
		"priceToEarningsScore": 2,
		"priceToBookScore": 1
	}
]
```

---

### 211. Ratios TTM Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/ratios-ttm-bulk

**Summary:**

Ratios TTM Bulk API는 주식의 최근 12개월(TTM) 재무 비율을 효율적으로 조회할 수 있는 방법을 제공합니다. 가장 최근 재무 보고서를 기반으로 수익성, 유동성, 효율성, 레버리지, 밸류에이션 비율에 대한 상세한 인사이트를 제공합니다.

**About:**

이 API를 통해 다음과 같은 광범위한 재무 비율에 접근할 수 있습니다:

Profitability Ratios: 매출총이익률, 영업이익률, 순이익률 등을 포함하여, 기업이 사업 운영에서 얼마나 효과적으로 이익을 창출하는지 투자자가 평가할 수 있도록 돕습니다.
Liquidity Ratios: 유동비율, 당좌비율, 현금비율 등 기업이 단기 부채를 얼마나 잘 충당할 수 있는지 파악하기 위한 핵심 유동성 지표를 제공합니다.
Efficiency Ratios: 기업이 자산을 얼마나 효율적으로 활용하는지 평가하기 위한 매출채권회전율, 재고자산회전율, 총자산회전율 등의 지표를 제공합니다.
Leverage Ratios: 기업의 자본 구조와 재무 레버리지에 대한 통찰을 제공하는 부채 대 자산 비율, 부채 대 자기자본 비율, 부채 대 자본 비율을 포함합니다.
Valuation Ratios: 주가수익비율(P/E), 주가순자산비율(P/B), 주가매출비율(P/S) 등 투자자가 주식의 고평가 또는 저평가 여부를 판단하는 데 도움을 주는 비율을 제공합니다.
Cash Flow Ratios: 기업이 영업 활동 및 투자 대비 현금 흐름을 얼마나 잘 관리하는지 평가하기 위한 잉여현금흐름 수익률, 영업현금흐름 커버리지, 자본 지출 커버리지 비율을 제공합니다.

이 API는 투자 의사결정을 위해 여러 기업에 걸쳐 TTM 비율을 추적하고 비교해야 하는 재무 분석가, 기관 투자자, 포트폴리오 매니저에게 매우 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/ratios-ttm-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "000001.SZ",
		"grossProfitMarginTTM": "1.1622776732779352",
		"ebitMarginTTM": "0.22525536322293388",
		"ebitdaMarginTTM": "0.2018381390033096",
		"operatingProfitMarginTTM": "0.4658682349579752",
		"pretaxProfitMarginTTM": "0.3160551441700993",
		"continuousOperationsProfitMarginTTM": "0.25995857044215337",
		"netProfitMarginTTM": "0.25995857044215337",
		"bottomLineProfitMarginTTM": "0.25995857044215337",
		"receivablesTurnoverTTM": "0",
		"payablesTurnoverTTM": "0",
		"inventoryTurnoverTTM": "0",
		"fixedAssetTurnoverTTM": "13.114441842310695",
		"assetTurnoverTTM": "0.029075827062555015",
		"currentRatioTTM": "0",
		"quickRatioTTM": "0",
		"solvencyRatioTTM": "0.008534174446189174",
		"cashRatioTTM": "0",
		"priceToEarningsRatioTTM": "6.68445715569793",
		"priceToEarningsGrowthRatioTTM": "-3.6096068640768793",
		"forwardPriceToEarningsGrowthRatioTTM": "2.4481492401413427",
		"priceToBookRatioTTM": "0.576796465809228",
		"priceToSalesRatioTTM": "1.483200528584014",
		"priceToFreeCashFlowRatioTTM": "1.518395607609901",
		"priceToOperatingCashFlowRatioTTM": "1.7523793147342828",
		"debtToAssetsRatioTTM": "0",
		"debtToEquityRatioTTM": "0",
		"debtToCapitalRatioTTM": "0",
		"longTermDebtToCapitalRatioTTM": "0",
		"financialLeverageRatioTTM": "11.416164801466868",
		"workingCapitalTurnoverRatioTTM": "0.23544250931631752",
		"operatingCashFlowRatioTTM": "0",
		"operatingCashFlowSalesRatioTTM": "0.991612895545132",
		"freeCashFlowOperatingCashFlowRatioTTM": "0.
```

---

### 212. Relative Strength Index API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/relative-strength-index

**Summary:**

0에서 100 사이에서 움직이는 모멘텀 오실레이터로, 최근 가격 변동의 속도와 크기를 측정하여 과매수 및 과매도 상태를 감지합니다.

**About:**

RSI는 선택한 기간 동안의 평균 상승폭과 하락폭을 기반으로 계산되며, 70(과매수)과 30(과매도)이 고전적인 기준선으로 사용됩니다. 극단적 수치 외에도, 트레이더들은 가격과의 다이버전스, 추세 필터로서 50 부근의 중간선 교차, 그리고 시장 국면 변화를 확인하기 위한 지수 자체 범위의 변화를 주시합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/rsi?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"rsi": 57.094104905869884
	}
]
```

---

### 213. Revenue Geographic Segments API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/revenue-geographic-segments

**Summary:**

Revenue Geographic Segments API를 통해 지리적 지역별 상세 매출 내역에 접근하세요. 각 지역이 기업 전체 매출에 기여하는 비중을 분석하고 성장을 주도하는 핵심 시장을 파악하세요.

**About:**

Revenue Geographic Segments API를 통해 지역별로 세분화된 매출 데이터를 조회할 수 있어, 투자자와 분석가가 다양한 시장에서의 기업 성과를 이해하는 데 도움을 줍니다. 이 API는 다음 용도에 이상적입니다:

Regional Revenue Analysis: 지리적 지역별 매출 기여도를 분석하여 어느 지역이 성장을 이끌고 있는지 파악합니다.
Market Performance Insights: Americas, Europe, Greater China 등 주요 지역에서 기업이 얼마나 성과를 내고 있는지 분석합니다.
Global Strategy Planning: 기업 입장에서 지리적 매출 분포를 이해하면 지역별 전략을 수립하고 새로운 확장 기회를 발굴하는 데 도움이 됩니다.

이 API는 지역별 매출에 대한 세밀한 뷰를 제공하여 기업의 글로벌 재무 성과를 보다 쉽게 추적할 수 있게 합니다.

Example Use Case
투자자는 Revenue Geographic Segments API를 활용하여 Americas, Europe, Greater China 등 주요 지역에서 Apple의 성과를 추적하고, 신흥 시장이나 매출이 감소하는 지역을 파악하는 데 활용할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/revenue-geographic-segmentation?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| period | string | annualquarter |
| structure | string | flat |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| How is the revenue data segmented by region? | The revenue is segmented by geographic areas as reported by the company, which may include regions like the Americas, Europe, Greater China, and Japan. | What information does the Revenue Geographic Segments API provide? |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2024,
		"period": "FY",
		"reportedCurrency": null,
		"date": "2024-09-28",
		"data": {
			"Americas Segment": 167045000000,
			"Europe Segment": 101328000000,
			"Greater China Segment": 66952000000,
			"Japan Segment": 25052000000,
			"Rest of Asia Pacific": 30658000000
		}
	}
]
```

---

### 214. Revenue Product Segmentation API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/revenue-product-segmentation

**Summary:**

Revenue Product Segmentation API를 통해 제품 라인별 상세 매출 내역에 접근하세요. 어떤 제품이 기업의 수익을 이끄는지 파악하고, 개별 제품 세그먼트의 성과에 대한 인사이트를 얻으세요.

**About:**

Revenue Product Segmentation API는 기업의 매출을 제품별로 종합적으로 분류하여, 다양한 제품 카테고리 간 성과를 쉽게 분석할 수 있도록 합니다. 이 API는 다음 용도에 이상적입니다:

Product-Specific Revenue Analysis: 각 제품이 기업 전체 수익에 얼마나 기여하는지 파악합니다.
Strategic Insights: 특정 제품 세그먼트의 성장 또는 감소 추이를 분석하여 투자 결정이나 기업 전략 수립에 활용합니다.
Competitive Benchmarking: 동일 산업 내 다른 기업들과 제품 세그먼트 매출을 비교하여 시장 내 위치를 평가합니다.

이 API는 제품 수준의 매출에 대한 상세한 뷰를 제공하여, 성장 동력을 식별하고 특정 제품 라인의 재무 건전성을 추적하는 데 도움을 줍니다.

Example Use Case
투자자는 Revenue Product Segmentation API를 통해 Apple의 수익 중 iPhone 매출이 Mac이나 웨어러블 등 다른 제품 대비 얼마나 차지하는지 확인할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/revenue-product-segmentation?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| period | string | annualquarter |
| structure | string | flat |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"fiscalYear": 2024,
		"period": "FY",
		"reportedCurrency": null,
		"date": "2024-09-28",
		"data": {
			"Mac": 29984000000,
			"Service": 96169000000,
			"Wearables, Home and Accessories": 37005000000,
			"iPad": 26694000000,
			"iPhone": 201183000000
		}
	}
]
```

---

### 215. S&P 500 Index API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/sp-500

**Summary:**

S&P 500 Index API를 통해 S&P 500 지수에 대한 상세 데이터에 접근하세요. 이 주요 주식 시장 지수를 구성하는 기업들의 성과와 핵심 정보를 추적하세요.

**About:**

FMP S&P 500 Index API는 가장 널리 추종되는 주식 시장 지수 중 하나인 S&P 500에 편입된 기업들에 대한 종합적인 데이터를 제공합니다. 이 API는 각 구성 종목의 사명, symbol, 섹터, 서브섹터, 본사 위치 및 기타 관련 정보를 제공합니다. S&P 500의 현재 및 과거 성과 데이터가 필요한 투자자, 분석가, 연구자에게 이상적입니다. 주요 기능은 다음과 같습니다:

Company-Level Data: 섹터 및 서브섹터를 포함하여 S&P 500 내 각 기업에 대한 상세 정보에 접근합니다.
Historical Additions: 기업이 S&P 500에 처음 편입된 시점을 추적하여 시간에 따른 지수 구성 변화를 파악합니다.
Geographic Information: 각 기업의 본사 위치 정보를 제공하여 지수에 대한 지리적 관점을 제시합니다.
Industry and Sector Data: 섹터 및 서브섹터별 기업 분포를 분석하여 시장 성과에 대한 더 깊은 이해를 제공합니다.

이 API는 S&P 500과 구성 종목에 대한 최신 정보가 필요한 포트폴리오 매니저, 재무 분석가, 기관 투자자에게 이상적입니다.

Example Use Case
자산운용사가 자사 포트폴리오의 섹터 배분을 S&P 500과 비교 평가하고 있습니다. S&P 500 Index API를 활용하여 지수 내 각 기업의 섹터 및 서브섹터 데이터를 조회하고, 지수 구성에 더 근접하도록 자산 배분 전략을 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sp500-constituent
```

**Sample Response:**

```json
[
	{
		"symbol": "COHR",
		"name": "Coherent, Inc.",
		"sector": "Technology",
		"subSector": "Hardware, Equipment & Parts",
		"headQuarter": "Santa Clara, California",
		"dateFirstAdded": "2026-03-23",
		"cik": "0000820318",
		"founded": "2022-09-01"
	}
]
```

---

### 216. Search Cik API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-cik

**Summary:**

FMP CIK API를 통해 상장 기업의 중앙 인덱스 키(CIK)를 손쉽게 조회하세요. SEC 공시 및 규제 문서에 필요한 고유 식별자에 접근하여 컴플라이언스 및 재무 분석 프로세스를 간소화하세요.

**About:**

FMP CIK API는 특정 기업의 중앙 인덱스 키(CIK)를 신속하고 정확하게 조회해야 하는 금융 전문가, 컴플라이언스 담당자, 분석가에게 필수적인 도구입니다. CIK는 미국 증권거래위원회(SEC)가 기업 공시 서류를 추적하는 데 사용하는 고유 식별자로, 기업 공시 및 재무 데이터에 접근하는 데 핵심적인 역할을 합니다.

Key Features of the CIK API

Quick CIK Lookup: symbol 또는 회사명을 입력하여 기업의 CIK를 조회함으로써 SEC 공시 및 기타 규제 정보에 효율적으로 접근합니다.
Essential for Compliance: 규제 컴플라이언스 및 기업 지배구조 목적으로 SEC 공시에 정확하고 신속하게 접근할 수 있도록 합니다.
Comprehensive Market Coverage: NASDAQ, NYSE 등 주요 미국 증권 거래소에 상장된 기업들의 CIK를 검색합니다.

CIK API는 기업 공시 및 컴플라이언스 업무를 다루는 모든 사람에게 매우 유용하며, 필수적인 기업 식별자에 원활하게 접근할 수 있도록 합니다.

Example: Streamlined SEC Filings: 컴플라이언스 담당자가 CIK API를 활용하여 기업의 CIK 번호를 신속히 조회하고, 이를 통해 관련 SEC 공시 전체를 조회합니다. 이를 통해 규제 공시 및 재무제표를 효율적으로 모니터링할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-cik?cik=320193
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 320193 |
| limit | number | 50 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"companyName": "Apple Inc.",
		"cik": "0000320193",
		"exchangeFullName": "NASDAQ Global Select",
		"exchange": "NASDAQ",
		"currency": "USD"
	}
]
```

---

### 217. Search Crypto News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-crypto-news

**Summary:**

FMP Search Crypto News API를 통해 암호화폐 뉴스를 검색하세요. 코인 이름 또는 symbol을 입력하여 특정 코인 또는 토큰과 관련된 뉴스를 조회하세요.

**About:**

Search Crypto News API를 통해 코인 이름 또는 symbol을 입력하여 암호화폐 뉴스를 검색할 수 있습니다. 이 API는 다음 용도에 유용합니다:

Targeted Searches: 이름 또는 ticker symbol을 입력하여 특정 암호화폐 관련 뉴스를 신속하게 찾습니다.
Real-Time & Historical News: 디지털 자산의 시장 추세와 가격 동인을 추적하기 위해 현재 및 과거 뉴스를 모두 조회합니다.
Symbol-Based Lookups: Bitcoin (BTC) 또는 Ethereum (ETH) 등 관심 코인과 관련된 뉴스를 찾습니다.

이 API는 디지털 자산의 가치에 영향을 줄 수 있는 뉴스에 빠르게 접근해야 하는 암호화폐 투자자에게 이상적입니다.

Example Use Case
암호화폐 투자자가 Search Crypto News API를 활용하여 Ethereum 관련 뉴스를 검색함으로써, 거래 전 최근 시장 움직임을 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/crypto?symbols=BTCUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | BTCUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "BTCUSD",
		"publishedDate": "2025-02-03 23:32:19",
		"publisher": "Coingape",
		"title": "Crypto Prices Today Feb 4: BTC & Altcoins Recover Amid Pause On Trump's Tariffs",
		"image": "https://images.financialmodelingprep.com/news/crypto-prices-today-feb-4-btc-altcoins-recover-amid-20250203.webp",
		"site": "coingape.com",
		"text": "Crypto prices today have shown signs of recovery as U.S. President Donald Trump's newly announced import tariffs on Canada and Mexico were paused for 30 days. Bitcoin (BTC) price regained its value, hitting a $102K high amid broader market recovery.",
		"url": "https://coingape.com/crypto-prices-today-feb-4-btc-altcoins-recover-amid-pause-on-trumps-tariffs/"
	}
]
```

---

### 218. Search Forex News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-forex-news

**Summary:**

FMP Search Forex News API를 통해 외환 뉴스를 검색하세요. 특정 통화쌍의 symbol을 입력하여 집중적인 업데이트를 받으세요.

**About:**

Search Forex News API를 통해 EUR/USD 또는 GBP/USD 등의 통화쌍을 입력하여 외환 뉴스를 검색할 수 있습니다. 이 API는 다음 용도에 적합합니다:

Targeted News Search: 특정 통화쌍에 대한 뉴스를 손쉽게 찾아 외환 시장의 최신 동향을 추적합니다.
Historical News Access: 현재 및 과거 외환 뉴스를 모두 조회하여 장기 추세와 시장 움직임을 분석합니다.
Symbol-Based Retrieval: 특정 통화쌍 symbol을 입력하여 정보에 기반한 의사결정에 필요한 관련 뉴스를 조회합니다.

이 API는 특정 통화쌍과 관련된 뉴스에 빠르게 접근해야 하는 외환 트레이더에게 이상적입니다.

Example Use Case
통화 트레이더가 Search Forex News API를 활용하여 EUR/USD 관련 최신 뉴스를 검색함으로써, 거래 진입 전 최근 가격 변동의 원인을 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/forex?symbols=EURUSD
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | EURUSD |
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "EURUSD",
		"publishedDate": "2025-02-03 18:43:01",
		"publisher": "FX Street",
		"title": "EUR/USD trims losses but still sheds weight",
		"image": "https://images.financialmodelingprep.com/news/eurusd-trims-losses-but-still-sheds-weight-20250203.jpg",
		"site": "fxstreet.com",
		"text": "EUR/USD dropped sharply following fresh tariff threats from US President Donald Trump, impacting the markets. However, significant declines in global risk markets eased as the Trump administration offered 30-day concessions on impending tariffs for Canada and Mexico.",
		"url": "https://www.fxstreet.com/news/eur-usd-trims-losses-but-still-sheds-weight-202502032343"
	}
]
```

---

### 219. Search Insider Trades API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-insider-trades

**Summary:**

Search Insider Trades API를 통해 기업 또는 symbol별로 내부자 거래 활동을 검색하세요. 임원 및 이사를 포함한 기업 내부자가 수행한 특정 거래를 조회하세요.

**About:**

FMP Search Insider Trades API를 통해 기업 또는 주식 symbol을 기반으로 특정 내부자 거래 활동을 검색할 수 있습니다. 이 API는 거래 일자, 유형, 금액, 사내 직책 등 기업 내부자의 주식 거래에 대한 상세 정보를 제공합니다. 주요 기능은 다음과 같습니다:

Company-Specific Searches: 주식 symbol 또는 회사명을 입력하여 관련 거래를 조회하는 내부자 거래 활동 검색이 가능합니다.
Detailed Transaction Information: 거래 유형(매수 또는 매도), 거래 증권 수량, 가격 등 상세 데이터에 접근합니다.
Insider Roles: 거래에 참여한 내부자의 직책(이사 또는 임원 등)을 파악합니다.
Direct Links to Filings: 각 거래에는 보다 심층적인 분석과 검증을 위한 공식 SEC 공시 링크가 포함되어 있습니다.

이 API는 특정 기업 또는 개인의 내부자 거래 활동을 조사해야 하는 투자자, 재무 연구원, 분석가에게 적합합니다.

Example Use Case
투자 분석가가 Search Insider Trades API를 활용하여 주요 회계 책임자(Principal Accounting Officer)인 Chris Kondo의 Apple (AAPL) 주식 최근 매각을 조사합니다. 주당 $225에 8,706주를 매각한 거래에 대한 상세 정보를 조회함으로써, 분석가는 해당 기업의 재무 성과와 전략에 대한 시사점을 보다 면밀히 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/insider-trading/search?page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol | string | AAPL |
| page | number | 0 |
| limit | number | 100 |
| reportingCik | string | 0001496686 |
| companyCik | string | 0000320193 |
| transactionType | string | S-Sale |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "LAB",
		"filingDate": "2026-04-08",
		"transactionDate": "2026-04-06",
		"reportingCik": "0001559779",
		"companyCik": "0001162194",
		"transactionType": "M-Exempt",
		"securitiesOwned": 6790596,
		"reportingName": "Egholm Michael",
		"typeOfOwner": "director, officer: President & CEO",
		"acquisitionOrDisposition": "A",
		"directOrIndirect": "D",
		"formType": "4",
		"securitiesTransacted": 196513,
		"price": 0,
		"securityName": "Common Stock",
		"url": "https://www.sec.gov/Archives/edgar/data/1162194/000119312526148615/0001193125-26-148615-index.htm"
	}
]
```

---

### 220. Search Insider Trades by Reporting Name API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-reporting-name

**Summary:**

Search Insider Trades by Reporting Name API를 통해 보고자 이름으로 내부자 거래 활동을 검색하세요. 기업 내부자 거래에 관여한 특정 개인 또는 그룹의 거래 활동을 추적하세요.

**About:**

FMP Search Insider Trades by Reporting Name API를 통해 특정 개인 또는 그룹의 이름을 기반으로 내부자 거래 활동을 검색할 수 있습니다. 이 API는 내부자 거래와 관련된 보고 CIK(중앙 인덱스 키)와 개인 이름 등 핵심 정보를 제공하여, 고위 인사나 기업 임원의 거래 활동을 모니터링할 수 있습니다. 주요 기능은 다음과 같습니다:

Name-Specific Searches: 특정 개인 또는 단체의 이름을 입력하여 내부자 거래를 손쉽게 검색합니다.
Reporting CIK Information: 공시 전반에 걸쳐 내부자 활동을 더 심층적으로 추적하기 위한 보고 CIK를 조회합니다.
Track High-Profile Insiders: 잘 알려진 기업 임원, 이사 또는 기타 내부자의 거래를 모니터링합니다.
Direct Access to Relevant Data: 특정 개인의 내부자 거래 활동과 관련된 정보를 신속히 찾고, 더 상세한 데이터 링크를 확인합니다.

이 API는 특정 인물 또는 단체와 관련된 내부자 거래 활동을 추적하고자 하는 투자자, 분석가, 재무 연구원에게 이상적입니다.

Example Use Case
재무 분석가가 Search Insider Trades by Reporting Name API를 활용하여 Mark Zuckerberg의 내부자 거래 활동을 추적합니다. 보고 CIK와 관련 거래를 조회함으로써, 분석가는 Zuckerberg의 거래 행동을 모니터링하고 그의 행동이 Meta Platforms에 대한 시장 심리에 미치는 영향을 분석합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/insider-trading/reporting-name?name=Zuckerberg
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | Zuckerberg |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"reportingCik": "0001548760",
		"reportingName": "Zuckerberg Mark"
	}
]
```

---
### 221. Search Isin API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-isin

**Summary:**

FMP ISIN API를 사용하여 금융 증권의 국제 증권 식별 번호(ISIN)를 손쉽게 검색하고 조회하세요. ISIN과 연관된 회사명, 주식 symbol, 시가총액 등 핵심 정보를 확인할 수 있습니다.

**About:**

FMP ISIN API는 특정 ISIN(International Securities Identification Number)에 연결된 종합적인 금융 정보를 신속하게 조회할 수 있도록 해줍니다. 이 12자리 영숫자 코드는 전 세계 금융 증권을 고유하게 식별하며, 투자자, 트레이더, 금융 분석가에게 필수적인 도구입니다.

ISIN API의 주요 기능은 다음과 같습니다:

Accurate Identification: 특정 ISIN에 연결된 주식 symbol과 회사명을 신속하게 조회하여 글로벌 증권을 정확히 식별합니다.
Comprehensive Data: 회사명, 주식 symbol, ISIN, 시가총액 등 관련 금융 데이터를 조회합니다.
Global Coverage: ISIN API는 주식, 채권, 뮤추얼 펀드 등 다양한 국제 증권을 지원하며, 글로벌 시장 전반에 걸친 광범위한 검색 기능을 제공합니다.

이 API는 글로벌 투자 또는 리서치를 위해 ISIN을 기준으로 증권을 효율적으로 식별하고 분석해야 하는 금융 전문가에게 매우 유용한 리소스입니다.

Example: 투자자가 ISIN API를 사용하여 주식 symbol "AAPL"을 검색함으로써 Apple Inc.의 ISIN과 시가총액을 확인하고, 글로벌 투자 리서치를 간소화할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-isin?isin=US0378331005
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| isin* | string | US0378331005 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| What information does the ISIN API provide? | The API provides details such as the company name, stock symbol, ISIN, and market capitalization for financial securities. | Can the ISIN API be used for securities other than stocks? |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "Apple Inc.",
		"isin": "US0378331005",
		"marketCap": 3900351299800
	}
]
```

---

### 222. Search Mergers & Acquisitions API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-mergers-acquisitions

**Summary:**

FMP Search Mergers and Acquisitions API로 특정 인수합병(M&A) 데이터를 검색하세요. 인수 기업과 피인수 기업, 거래 날짜, 공식 SEC 공시 링크 등 M&A 활동에 관한 상세 정보를 조회할 수 있습니다.

**About:**

FMP Search Mergers and Acquisitions API는 회사명을 기준으로 인수합병을 검색하여 기업 활동에 대한 심층적인 이해를 제공합니다. 과거 및 진행 중인 거래에 대한 상세 데이터가 필요한 경우 유용하며, 다음 정보를 포함합니다:

Company-Specific M&A Data: 인수 기업 또는 피인수 기업으로서 특정 회사가 관여된 M&A 거래를 검색합니다.
Transaction Dates: 정확한 추적을 위해 거래의 정확한 날짜를 확인합니다.
Filing Links: 거래 조건 및 내용에 관한 상세 정보를 담은 공식 SEC 문서 링크를 제공합니다.

이 API는 비즈니스 또는 투자 결정에 필요한 종합적인 M&A 데이터를 원하는 금융 분석가, 리서처, 기업 전략가에게 최적화되어 있습니다.

Example Use Case
기업 전략가가 Search Mergers and Acquisitions API를 활용하여 경쟁사의 과거 인수 대상을 파악합니다. 이 정보는 경쟁 전략을 수립하거나 미래 사업 기회에 영향을 미칠 수 있는 산업 트렌드를 식별하는 데 도움이 됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/mergers-acquisitions-search?name=Apple
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| name* | string | Apple |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "PEGY",
		"companyName": "Pineapple Energy Inc.",
		"cik": "0000022701",
		"targetedCompanyName": "Communications Systems, Inc.",
		"targetedCik": "0000022701",
		"targetedSymbol": "JCS",
		"transactionDate": "2021-11-12",
		"acceptedDate": "2021-11-12 09:54:22",
		"link": "https://www.sec.gov/Archives/edgar/data/22701/000089710121000932/a211292_s-4.htm"
	}
]
```

---

### 223. Search Press Releases API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-press-releases

**Summary:**

FMP Search Press Releases API로 기업 보도자료를 검색하세요. 주식 symbol이나 회사명을 입력하여 특정 기업의 공지사항 및 업데이트를 찾을 수 있습니다.

**About:**

Search Press Releases API는 회사명 또는 주식 symbol을 기준으로 특정 보도자료를 검색하여 관련 공지사항에 빠르게 접근할 수 있도록 해줍니다. 이 API는 다음과 같은 경우에 필수적입니다:

Targeted Searches: 특정 회사의 정확한 보도자료를 찾기 위해 검색 범위를 좁힙니다.
Symbol-Based Retrieval: 주식 symbol을 활용하여 기업 공시를 정확히 찾아내며, 정밀한 데이터를 원하는 투자자와 분석가에게 이상적입니다.
Historical and Real-Time Access: 현재 및 과거 보도자료를 모두 조회하여 장기 추세 분석에 활용합니다.

이 API는 특정 보도자료에 빠르고 신뢰할 수 있는 접근이 필요한 전문가를 위해 설계되어 시간을 절약하고 정확한 데이터를 제공합니다.

Example Use Case
투자자가 Search Press Releases API를 사용하여 투자 결정을 내리기 전 특정 기업의 최신 실적 보고서를 찾습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/press-releases?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"publishedDate": "2025-01-30 16:30:00",
		"publisher": "Business Wire",
		"title": "Apple reports first quarter results",
		"image": "https://images.financialmodelingprep.com/news/apple-reports-first-quarter-results-20250130.jpg",
		"site": "businesswire.com",
		"text": "CUPERTINO, Calif.--(BUSINESS WIRE)--Apple today announced financial results for its fiscal 2025 first quarter ended December 28, 2024.",
		"url": "https://www.businesswire.com/news/home/20250130261281/en/Apple-reports-first-quarter-results/"
	}
]
```

---

### 224. Search Stock News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-stock-news

**Summary:**

FMP Search Stock News API로 주식 관련 뉴스를 검색하세요. ticker symbol이나 회사명을 입력하여 최신 동향을 추적하는 특정 주식 뉴스를 찾을 수 있습니다.

**About:**

Search Stock News API는 특정 회사명 또는 주식 symbol을 입력하여 주식 관련 뉴스를 검색할 수 있도록 해줍니다. 이 도구는 다음과 같은 경우에 이상적입니다:

Targeted News Searches: 특정 회사나 주식에 관한 뉴스를 찾기 위해 검색 범위를 좁힙니다.
Symbol-Based Lookup: 관련 ticker symbol을 입력하여 주식 뉴스를 신속하게 조회합니다.
Comprehensive News Retrieval: 현재 및 과거 뉴스 보도를 모두 확인하여 시간에 따른 주가 움직임의 전체적인 그림을 파악합니다.

이 API는 특정 주식에 영향을 미치는 뉴스에 빠르고 신뢰할 수 있는 접근이 필요한 투자자와 분석가를 위해 최적화되어 있습니다.

Example Use Case
트레이더가 Search Stock News API를 사용하여 매수를 고려 중인 주식에 관한 최근 뉴스 기사를 조회하고 합리적인 투자 결정을 내립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/stock?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"publishedDate": "2025-02-03 21:05:14",
		"publisher": "Zacks Investment Research",
		"title": "Apple & China Tariffs: A Closer Look",
		"image": "https://images.financialmodelingprep.com/news/apple-china-tariffs-a-closer-look-20250203.jpg",
		"site": "zacks.com",
		"text": "Tariffs have been the talk of the town over recent weeks, regularly overshadowing other important developments and causing volatility spikes.",
		"url": "https://www.zacks.com/stock/news/2408814/apple-china-tariffs-a-closer-look?cid=CS-STOCKNEWSAPI-FT-stocks_in_the_news-2408814"
	}
]
```

---

### 225. SEC Company Full Profile API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/sec-company-full-profile

**Summary:**

FMP SEC Company Full Profile API로 사업 설명, 임원 정보, 연락처, 재무 데이터 등 상세한 기업 프로필을 조회하세요.

**About:**

FMP SEC Company Full Profile API는 SEC에 등록된 기업에 관한 종합적인 데이터를 제공합니다. 이 API는 다음과 같은 경우에 이상적입니다:

Detailed Company Profiles: 기업의 사업 운영, SIC 코드, CEO, 회계연도, 임직원 수 등 심층 정보에 접근합니다.
Executive and Contact Information: 핵심 임원 정보와 사업장·우편 주소, 전화번호, 웹사이트 링크 등 연락처를 조회합니다.
Company Description and Operations: 기업의 제품, 서비스, 시장, 사업 부문 등 상세한 기업 설명을 제공하여 사업 운영 전반을 파악할 수 있습니다.
Financial and Regulatory Data: 회계연도 종료일, IPO 날짜, SEC 공시 링크 등 핵심 재무 데이터를 제공합니다.

이 API는 재무 분석, 경쟁사 리서치, 투자 의사결정을 위해 상세한 기업 프로필이 필요한 투자자, 분석가, 리서처에게 필수적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-profile?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| cik-A | string | 320193 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"registrantName": "Apple Inc.",
		"sicCode": "3571",
		"sicDescription": "Electronic Computers",
		"sicGroup": "Consumer Electronics",
		"isin": "US0378331005",
		"businessAddress": "ONE APPLE PARK WAY,CUPERTINO CA 95014,(408) 996-1010",
		"mailingAddress": "ONE APPLE PARK WAY,CUPERTINO CA 95014",
		"phoneNumber": "(408) 996-1010",
		"postalCode": "95014",
		"city": "Cupertino",
		"state": "CA",
		"country": "US",
		"description": "Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide...",
		"ceo": "Mr. Timothy D. Cook",
		"website": "https://www.apple.com",
		"exchange": "NASDAQ",
		"stateLocation": "CA",
		"stateOfIncorporation": "CA",
		"fiscalYearEnd": "09-28",
		"ipoDate": "1980-12-12",
		"employees": "164000",
		"secFilingsUrl": "https://www.sec.gov/cgi-bin/browse-edgar?CIK=0000320193",
		"taxIdentificationNumber": "94-2404110",
		"fiftyTwoWeekRange": "164.08 - 260.1",
		"isActive": true,
		"assetType": "stock",
		"openFigiComposite": "BBG000B9XRY4",
		"priceCurrency": "USD"
	}
]
```

---

### 226. SEC Filings By CIK API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-by-cik

**Summary:**

FMP SEC Filings By CIK API로 SEC 공시를 검색하세요. CIK(Central Index Key) 번호를 사용하여 특정 기업 또는 기관과 관련된 모든 공시를 추적하며 상세 규제 서류에 접근할 수 있습니다.

**About:**

FMP SEC Filings By CIK API는 CIK(Central Index Key) 번호를 기준으로 SEC 공시를 조회하여, 기업 또는 기관의 공식 제출 서류에 대한 종합적인 접근을 제공합니다. 이 API는 다음과 같은 목적에 적합합니다:

Entity-Specific Filings: 상장 기업, 뮤추얼 펀드, 기타 등록 기관을 고유하게 식별하는 특정 CIK 번호에 연결된 SEC 공시를 검색합니다.
Real-Time Filings: 8-K, 10-K, 10-Q 등 다양한 서식을 포함하여 해당 기관의 최신 SEC 제출 서류를 실시간으로 수신합니다.
Direct Links to Filings: 공식 SEC 공시 및 관련 문서·별첨 자료로의 직접 링크에 접근합니다.

이 API는 CIK 식별자를 기반으로 정확하고 최신의 공시가 필요한 금융 분석가, 투자자, 컴플라이언스 담당자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-search/cik?cik=0000320193&from=2024-01-01&to=2024-03-01&page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0000320193 |
| from* | string | 2024-01-01 |
| to* | string | 2024-03-01 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"filingDate": "2024-02-28 00:00:00",
		"acceptedDate": "2024-02-28 17:09:05",
		"formType": "8-K",
		"link": "https://www.sec.gov/Archives/edgar/data/320193/000114036124010155/0001140361-24-010155-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/320193/000114036124010155/ny20022580x1_image01.jpg"
	}
]
```

---

### 227. SEC Filings By Form Type API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-by-form-type

**Summary:**

FMP SEC Filings By Form Type API로 특정 서식 유형의 SEC 공시를 검색하세요. 10-K, 10-Q, 8-K 등 원하는 문서 유형으로 필터링하여 관련 공시를 조회할 수 있습니다.

**About:**

FMP SEC Filings By Form Type API는 문서의 서식 유형을 기준으로 SEC 공시를 필터링하여 조회할 수 있도록 해줍니다. 연간 보고서(10-K), 분기 실적(10-Q), 이벤트 관련 공시(8-K) 등 분석 또는 컴플라이언스에 필요한 정확한 서식에 간편하게 접근할 수 있습니다:

Targeted Filings Search: 서식 유형별로 SEC 공시를 검색하여 8-K, 10-K, 10-Q 등 특정 보고서를 조회합니다.
Direct Links to Documents: SEC에서 직접 전체 공시 및 관련 별첨 자료에 접근하여 기업 공시에 대한 완전한 가시성을 확보합니다.
Regulatory Compliance Monitoring: 이 API를 활용하여 컴플라이언스 이벤트, 인수합병, 재무 공시, 지배구조 업데이트 관련 공시를 모니터링합니다.

이 API는 컴플라이언스, 분석 또는 투자 결정을 위해 특정 유형의 공시에 빠르게 접근해야 하는 투자자, 분석가, 규제 전문가에게 필수적인 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-search/form-type?formType=8-K&from=2024-01-01&to=2024-03-01&page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| formType* | string | 8-K |
| from* | string | 2024-01-01 |
| to* | string | 2024-03-01 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "BROS",
		"cik": "0001866581",
		"filingDate": "2024-03-01 00:00:00",
		"acceptedDate": "2024-02-29 21:43:41",
		"formType": "8-K",
		"link": "https://www.sec.gov/Archives/edgar/data/1866581/000162828024008098/0001628280-24-008098-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/1866581/000162828024008098/exhibit11-8xkfeb2024.htm"
	}
]
```

---

### 228. SEC Filings By Name API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-by-name

**Summary:**

FMP SEC Filings By Name API를 사용하여 기업 또는 기관명으로 SEC 공시를 검색하세요. 이름을 기반으로 어떤 조직의 공식 공시 서류도 신속하게 조회할 수 있습니다.

**About:**

FMP SEC Filings By Name API는 기업 또는 기관명을 사용하여 SEC 공시를 검색하고 상세 규제 서류에 접근할 수 있도록 해줍니다. 이 API는 다음과 같은 경우에 필수적입니다:

Entity-Specific Search: 이름으로 검색하여 기업, 뮤추얼 펀드, 기타 기관의 SEC 공시를 찾습니다.
Comprehensive Filing Access: 8-K, 10-K, 10-Q 등 주요 공시에 접근하며, 특정 기업의 공시를 열람할 수 있습니다.
Company Information: SEC 공시와 함께 CIK 번호, 사업장 주소, 연락처 등 추가 정보를 제공합니다.

이 API는 기업 또는 기관명을 기준으로 공시를 찾아야 하는 투자자, 금융 분석가, 규제 컴플라이언스 담당자에게 이상적입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-company-search/name?company=Berkshire
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| company* | string | Berkshire |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "None",
		"name": "BERKSHIRE MULTIFAMILY VALUE FUND II LP",
		"cik": "0001418405",
		"sicCode": "",
		"industryTitle": "",
		"businessAddress": "c/o Berkshire Property Advisors LLC, Boston MA 02108",
		"phoneNumber": "(617) 646-2300"
	}
]
```

---

### 229. SEC Filings By Symbol API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-by-symbol

**Summary:**

FMP SEC Filings By Symbol API를 사용하여 기업 symbol로 SEC 공시를 검색하고 조회하세요. 상장 기업의 8-K, 10-K, 10-Q 보고서 등 규제 공시에 직접 접근할 수 있습니다.

**About:**

FMP SEC Filings By Symbol API는 특정 기업의 주식 symbol을 기반으로 SEC 공시를 검색하고 조회할 수 있도록 해줍니다. 이 API는 컴플라이언스 모니터링, 재무 분석, 투자 리서치에 필수적인 규제 문서를 제공합니다:

Company-Specific Filings: 주식 symbol만 입력하면 상장 기업의 상세 SEC 공시에 접근합니다.
Direct Document Links: 전체 SEC 공시 및 관련 별첨 자료로의 직접 링크를 제공하여 리서치의 완전한 투명성을 보장합니다.
Real-Time Data Updates: API가 실시간 업데이트를 제공하여 SEC에 의해 공개되는 즉시 최신 공시에 접근할 수 있습니다.

이 API는 특정 기업과 연관된 규제 공시를 모니터링하고 검토해야 하는 투자자, 분석가, 컴플라이언스 담당자에게 매우 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-search/symbol?symbol=AAPL&from=2024-01-01&to=2024-03-01&page=0&limit=100
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from* | string | 2024-01-01 |
| to* | string | 2024-03-01 |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"cik": "0000320193",
		"filingDate": "2024-02-28 00:00:00",
		"acceptedDate": "2024-02-28 17:09:05",
		"formType": "8-K",
		"link": "https://www.sec.gov/Archives/edgar/data/320193/000114036124010155/0001140361-24-010155-index.htm",
		"finalLink": "https://www.sec.gov/Archives/edgar/data/320193/000114036124010155/ny20022580x1_image01.jpg"
	}
]
```

---

### 230. SEC Filings Company Search By CIK API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/company-search-by-cik

**Summary:**

FMP SEC Filings Company Search By CIK API를 사용하여 CIK(Central Index Key)로 기업 정보를 손쉽게 찾으세요. 특정 CIK 번호에 연결된 핵심 기업 정보와 공시에 접근할 수 있습니다.

**About:**

FMP SEC Filings Company Search By CIK API는 기업의 고유 CIK(Central Index Key)를 기반으로 규제 공시 및 기업 정보를 검색할 수 있도록 해줍니다. 이 API는 다음과 같은 경우에 이상적입니다:

CIK-Based Search: 기업의 CIK 번호를 입력하여 기업 데이터를 조회하고 SEC 공시에 접근합니다.
Comprehensive Company Information: 회사명, CIK 번호, SIC 코드, 사업장 주소, 전화번호 등 상세 정보를 조회합니다.
Access to SEC Filings: 기업의 최신 SEC 공시에 즉시 접근하여 철저한 재무 리서치와 기업 추적이 가능합니다.

이 API는 CIK 번호를 사용하여 상세 기업 정보와 공시 이력을 수집해야 하는 투자자, 분석가, 컴플라이언스 전문가에게 특히 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-company-search/cik?cik=0000320193
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| cik* | string | 0000320193 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "APPLE INC.",
		"cik": "0000320193",
		"sicCode": "3571",
		"industryTitle": "ELECTRONIC COMPUTERS",
		"businessAddress": "ONE APPLE PARK WAY, CUPERTINO CA 95014",
		"phoneNumber": "(408) 996-1010"
	}
]
```

---
### 231. SEC Filings Company Search By Symbol API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/company-search-by-symbol

**Summary:**

FMP SEC Filings Company Search By Symbol API를 통해 주식 심볼로 기업 정보와 규제 신고 서류를 빠르게 조회하세요. 티커 심볼을 입력하여 핵심 기업 정보에 즉시 접근할 수 있습니다.

**About:**

FMP SEC Filings Company Search By Symbol API를 사용하면 주식 심볼만 입력해도 해당 기업의 SEC 신고 서류를 손쉽게 검색할 수 있습니다. 이 API는 다음과 같은 유용한 정보를 제공합니다:

Stock Symbol-Based Search: 기업의 티커 심볼을 입력하여 공식 SEC 신고 서류 및 기업 세부 정보를 조회합니다.
Detailed Company Information: 기업명, CIK 번호, 산업 분류(SIC 코드), 사업 주소 등 상세 기업 정보를 가져옵니다.
Filing Access: 핵심 SEC 신고 서류에 접근하여 포괄적인 규제 조사 및 기업 이벤트 추적을 수행합니다.

이 API는 주식 심볼을 이용해 기업별 SEC 신고 서류와 정보를 신속하게 조회해야 하는 투자자, 재무 애널리스트, 컴플라이언스 전문가에게 최적화되어 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sec-filings-company-search/symbol?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "APPLE INC.",
		"cik": "0000320193",
		"sicCode": "3571",
		"industryTitle": "ELECTRONIC COMPUTERS",
		"businessAddress": "ONE APPLE PARK WAY, CUPERTINO CA 95014",
		"phoneNumber": "(408) 996-1010"
	}
]
```

---

### 232. Sector Pe Snapshot API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/sector-pe-snapshot

**Summary:**

Sector P/E Snapshot API를 통해 다양한 섹터의 주가수익비율(P/E ratio)을 조회하세요. 섹터 간 밸류에이션 수준을 비교하여 시장 가치 평가를 더 잘 이해할 수 있습니다.

**About:**

FMP Sector P/E Snapshot API는 Basic Materials, Technology, Healthcare 등 다양한 시장 섹터의 주가수익비율(P/E ratio) 상세 데이터를 제공합니다. 이 API를 통해 섹터별 밸류에이션을 분석하여 각 섹터가 수익 대비 어떻게 평가받고 있는지 인사이트를 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

P/E Ratio by Sector: 다양한 섹터의 최신 P/E ratio를 조회하여 상대적 밸류에이션을 비교합니다.
Exchange-Specific Data: NASDAQ, NYSE 등 특정 거래소별 섹터 P/E ratio를 확인합니다.
Daily Updates: 섹터 P/E ratio의 일별 업데이트를 받아 시간에 따른 밸류에이션 수준 변화를 추적합니다.
Valuation Comparisons: 여러 섹터의 P/E ratio를 비교하여 잠재적으로 고평가 또는 저평가된 섹터를 파악합니다.

이 API는 투자 의사결정과 시장 분석을 위해 섹터 밸류에이션을 평가해야 하는 투자자, 애널리스트, 포트폴리오 매니저에게 이상적입니다.

Example Use Case
포트폴리오 매니저가 Sector P/E Snapshot API를 활용하여 NASDAQ 내 다양한 섹터의 P/E ratio를 비교합니다. Basic Materials 섹터의 P/E ratio가 15.69임을 확인하고, 이 섹터가 다른 섹터 대비 고평가 또는 저평가 상태인지 판단하여 포트폴리오를 적절히 조정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/sector-pe-snapshot?date=2024-02-01
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| date* | string | 2024-02-01 |
| exchange | string | NASDAQ |
| sector | string | Energy |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2024-02-01",
		"sector": "Basic Materials",
		"exchange": "NASDAQ",
		"pe": 15.687711758428254
	}
]
```

---

### 233. Senate Trading Activity API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/senate-trading

**Summary:**

FMP Senate Trading Activity API를 통해 미국 상원의원들의 거래 활동을 모니터링하세요. 거래 일자, 자산, 금액, 잠재적 이해충돌 등 상원의원이 수행한 거래에 관한 상세 정보에 접근할 수 있습니다.

**About:**

FMP Senate Trading Activity API는 2012년 STOCK Act에 따라 미국 상원의원들의 거래 활동에 관한 포괄적인 데이터를 제공합니다. 이 API는 다음 목적에 필수적입니다:

Transparency & Accountability: 미국 상원의원이 수행한 거래 목록을 날짜, 자산, 거래 금액, 주당 가격과 함께 상세히 조회합니다. 이러한 투명성은 책임성을 확보하고 선출직 공직자의 금융 활동에 대한 인사이트를 제공합니다.
Conflict of Interest Identification: 상원의원이 입법적 영향력을 가질 수 있는 기업이나 섹터에서 이루어진 거래를 분석하여 잠재적 이해충돌을 파악합니다. 이 정보는 윤리적 투자 관행을 추구하는 투자자에게 매우 중요합니다.
Informed Investment Decisions: 상원의원의 거래 활동을 추적하여 시장 트렌드에 대한 인사이트를 얻거나 중대한 시장 움직임을 시사할 수 있는 거래를 포착합니다. 상원의원의 거래 시점과 대상을 파악하면 시장 심리에 대한 독특한 관점을 얻을 수 있습니다.

이 API는 미국 상원의원의 금융 활동을 모니터링하고 정부의 투명성을 확보하고자 하는 투자자, 애널리스트, 그리고 모든 관심 있는 이들을 위한 강력한 도구입니다.

Example Use Case
Ethical Investing: 윤리적 투자에 중점을 둔 투자자는 Senate Trading Activity API를 활용하여 상원의원이 거래한 기업, 특히 이해충돌로 볼 수 있는 거래가 있는 기업에 대한 투자를 회피할 수 있습니다. 이를 통해 투자자는 자신의 포트폴리오를 윤리적 기준에 부합하도록 유지합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/senate-trades?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"disclosureDate": "2026-02-15",
		"transactionDate": "2026-01-15",
		"firstName": "John",
		"lastName": "Boozman",
		"office": "John Boozman",
		"district": "AR",
		"owner": "Joint",
		"assetDescription": "Apple Inc",
		"assetType": "Stock",
		"type": "Purchase",
		"amount": "$1,001 - $15,000",
		"capitalGainsOver200USD": "False",
		"comment": "--",
		"link": "https://efdsearch.senate.gov/search/view/ptr/135ebfe9-099e-4d58-ba46-f739b90d61da/"
	}
]
```

---

### 234. Simple Moving Average API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/simple-moving-average

**Summary:**

고정된 되돌아보기 구간에 걸친 자산 종가의 산술 평균으로, 단기 노이즈를 평활화하여 기저 추세를 드러냅니다.

**About:**

SMA(단순이동평균)는 요청된 timeframe에 대해 최근 N개 종가의 비가중 평균으로 계산됩니다. 트레이더들은 이를 활용하여 추세 방향을 파악하고, 동적 지지선 및 저항선을 설정하며, 가격이나 다른 길이의 SMA와의 교차 신호를 생성합니다. 모든 관측치에 동일한 가중치가 부여되므로, SMA는 EMA나 WMA 같은 가중 변형 지표보다 반응 속도가 느립니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/sma?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"sma": 253.754
	}
]
```

---

### 235. Standard Deviation API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/standard-deviation

**Summary:**

고정된 구간에 걸쳐 평균 주변의 가격 분산을 측정하는 롤링 지표로, 요청된 자산과 timeframe에 대한 변동성의 기본 척도로 활용됩니다.

**About:**

이 endpoint는 선택된 timeframe을 기준으로 지정된 기간 동안의 종가 표준편차를 계산합니다. 볼린저 밴드(Bollinger Bands), 포지션 사이징 모델, 리스크 필터 등 변동성 기반 도구의 기반이 되며, 변동성 국면 전환을 감지하거나 다른 지표를 정규화하는 데 직접 활용되기도 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/standarddeviation?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"standardDeviation": 3.716923997070693
	}
]
```

---

### 236. Stock Batch Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/batch-quote

**Summary:**

FMP Stock Batch Quote API를 통해 단일 요청으로 여러 종목의 실시간 주식 시세를 조회하세요. 현재 가격, 거래량, 복수 기업의 상세 데이터에 한 번에 접근하여 대규모 포트폴리오를 추적하거나 여러 종목을 동시에 모니터링하기가 한층 편리해집니다.

**About:**

FMP Stock Batch Quote API를 사용하면 하나의 간결한 요청으로 여러 종목의 시세를 가져올 수 있습니다. 이 API는 다음 용도에 이상적입니다:

Portfolio Monitoring: 여러 종목을 실시간으로 추적하며, 복수의 보유 종목을 동시에 모니터링해야 하는 투자자나 포트폴리오 매니저에게 최적입니다.
Data Efficiency: 여러 번의 API 호출 대신 단일 요청으로 복수 기업의 상세 주식 데이터를 가져와 복잡성을 줄입니다.
Comprehensive Stock Insights: 현재 가격, 거래량, 당일 고가/저가, 50일 및 200일 이동평균 등 각 종목의 상세 데이터에 접근합니다.

이 API는 여러 심볼에 대한 포괄적인 실시간 주식 데이터가 필요한 투자자, 트레이더, 애플리케이션을 위해 효율적인 데이터 조회를 보장합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-quote?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "Apple Inc.",
		"price": 232.8,
		"changePercentage": 2.1008,
		"change": 4.79,
		"volume": 44489128,
		"dayLow": 226.65,
		"dayHigh": 233.13,
		"yearHigh": 260.1,
		"yearLow": 164.08,
		"marketCap": 3500823120000,
		"priceAvg50": 240.2278,
		"priceAvg200": 219.98755,
		"exchange": "NASDAQ",
		"open": 227.2,
		"previousClose": 228.01,
		"timestamp": 1738702801
	}
]
```

---

### 237. Stock Batch Quote Short API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/batch-quote-short

**Summary:**

FMP Stock Batch Quote Short API를 통해 여러 종목의 실시간 간략 시세에 접근하세요. 하나의 간결한 요청으로 현재 가격, 등락, 거래량 등 핵심 주식 데이터의 스냅샷을 여러 기업에 대해 한 번에 조회할 수 있습니다.

**About:**

FMP Stock Batch Quote Short API는 한 번의 요청으로 여러 종목의 고수준 데이터를 빠르게 필요로 하는 사용자를 위해 설계되었습니다. 이 API는 다음 용도에 이상적입니다:

Quick Price Monitoring: 여러 종목의 현재 가격, 등락, 거래량 스냅샷을 한 번에 조회하여 시장 트렌드를 신속하게 파악합니다.
Portfolio Efficiency: 단일 요청으로 복수 보유 종목의 핵심 주식 데이터를 추적하며, 빠른 업데이트가 필요한 포트폴리오 매니저나 트레이더에게 최적입니다.
Streamlined Data Retrieval: 상세 데이터를 생략하고 가격, 등락, 거래량 등 기본 정보에만 집중하여 핵심 인사이트를 빠르고 효율적으로 얻습니다.

이 API는 단 하나의 간단한 요청으로 여러 기업의 핵심 주식 정보를 신속하고 효율적으로 모니터링할 수 있는 방법을 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/batch-quote-short?symbols=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbols* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"price": 232.8,
		"change": 4.79,
		"volume": 44489128
	}
]
```

---

### 238. Stock Chart Light API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-price-eod-light

**Summary:**

FMP Basic Stock Chart API를 통해 간소화된 주식 차트 데이터에 접근하세요. 이 API는 날짜, 가격, 거래량 등 필수 차트 정보를 제공하여 최소한의 데이터로 주식 성과를 추적하고 기본적인 가격 및 거래량 차트를 생성하는 데 이상적입니다.

**About:**

FMP Basic Stock Chart API는 복잡한 처리 없이 가격 움직임을 추적하고자 하는 사용자에게 간소화된 주식 차트 데이터 접근 방법을 제공합니다. 이 API는 다음을 제공합니다:

Date & Price Information: 특정 주식 심볼의 일별 가격 움직임을 손쉽게 추적합니다.
Volume Data: 각 날짜별 거래량 데이터를 포함하여 거래 활동 현황을 파악합니다.
Basic Charting Needs: 과거 성과 분석을 위한 단순 주가 및 거래량 차트 생성에 이상적입니다.

이 API는 상세한 기술적 지표 없이도 주식 데이터를 빠르고 간단하게 시각화하고자 하는 사용자와 개발자에게 최적입니다.

Example Use Case
금융 앱이 Basic Stock Chart API를 활용하여 주식의 일별 종가와 거래량을 보여주는 간단한 차트를 표시함으로써, 사용자가 시간 경과에 따른 성과를 빠르게 파악할 수 있도록 합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/light?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-04",
		"price": 232.8,
		"volume": 44489128
	}
]
```

---

### 239. Stock Grades API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/grades

**Summary:**

FMP Grades API를 통해 주요 애널리스트 및 금융 기관의 최신 주식 등급에 접근하세요. 특정 주식 심볼에 대한 등급 상향, 하향, 유지 등 등급 조치를 추적하여 전문가들이 기업을 어떻게 평가하는지에 대한 귀중한 인사이트를 얻으세요.

**About:**

FMP Grades API는 주요 금융 기관의 주식 평가 데이터를 다음과 같이 시의적절하게 제공합니다:

Grading Company: 주식 등급을 제공하는 기관을 확인합니다.
Previous Grade and New Grade: 이전 평가에서 최신 평가로의 등급 변화를 조회합니다.
Action Taken: 등급이 상향, 하향 또는 유지되었는지 여부를 파악합니다.
Date of Evaluation: 최신 등급 조치가 언제 이루어졌는지 확인합니다.

이 API는 투자자와 애널리스트가 재무 전문가들의 최신 시장 심리를 이해하고, 주식이 어떻게 등급 평가되는지를 바탕으로 더 나은 투자 결정을 내릴 수 있도록 돕습니다.

Example Use Case
투자자는 Grades API를 활용하여 포트폴리오 내 주식의 최신 등급을 추적하고, 금융 기관이 해당 기업의 현재 성과와 투자 잠재력을 어떻게 평가하는지 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/grades?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-01-31",
		"gradingCompany": "Morgan Stanley",
		"previousGrade": "Overweight",
		"newGrade": "Overweight",
		"action": "maintain"
	}
]
```

---

### 240. Stock Grades Summary API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/grades-summary

**Summary:**

FMP Grades Summary API를 통해 애널리스트 등급의 전체 현황을 빠르게 파악하세요. 이 API는 개별 주식 심볼에 대한 시장 심리의 통합 요약을 제공하며, Strong Buy, Buy, Hold, Sell, Strong Sell 등 총 등급 수를 포함합니다. 몇 가지 데이터 포인트만으로 해당 주식의 전반적인 컨센서스를 이해할 수 있습니다.

**About:**

FMP Grades Summary API는 애널리스트 등급의 명확한 분류를 제공하여 시장 심리를 파악하는 과정을 간소화합니다. 특히 다음 목적에 큰 가치를 발휘합니다:

Market Sentiment Assessment: 주식에 대한 전반적인 시장 의견이 매수, 보유, 매도 중 어느 쪽으로 기울어져 있는지 빠르게 파악합니다.
Investment Decision Support: 컨센서스 등급을 활용하여 얼마나 많은 애널리스트가 매수 또는 매도를 권장하는지 파악하고 투자 결정에 반영합니다.
Portfolio Monitoring: 포트폴리오 내 종목의 애널리스트 심리 변화를 검토하고 포지션을 적절히 조정하여 보유 종목을 관리합니다.
Streamlined Stock Analysis: 주식의 시장 내 위치에 대한 고수준 이해를 원하는 사용자에게, 요약된 데이터는 복잡한 등급 정보를 효율적으로 소화하는 방법을 제공합니다.

이 API는 투자자와 애널리스트가 시장이 특정 주식을 어떻게 바라보는지 한눈에 파악하여 정보에 기반한 결정을 내릴 수 있도록 돕습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/grades-consensus?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"strongBuy": 1,
		"buy": 29,
		"hold": 11,
		"sell": 4,
		"strongSell": 0,
		"consensus": "Buy"
	}
]
```

---
### 241. Stock Market Indexes List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/indexes-list

**Summary:**

FMP Stock Market Indexes List API를 통해 전 세계 거래소의 주식 시장 지수 목록을 포괄적으로 조회하세요. 이 API는 심볼, 이름, 거래소, 통화 등 각 지수의 핵심 정보를 제공하여 애널리스트와 투자자가 다양한 시장 벤치마크를 추적하는 데 도움을 줍니다.

**About:**

FMP Stock Market Indexes List API를 사용하면 전 세계 거래소의 주식 시장 지수 전체 디렉터리에 접근할 수 있습니다. 지수 심볼, 이름, 거래소, 통화에 관한 상세 정보를 제공하므로 다양한 지역과 섹터의 시장 성과를 추적하는 데 귀중한 리소스입니다. 주요 기능은 다음과 같습니다:

Comprehensive Index Coverage: NYSE, NASDAQ, TSX 등 주요 거래소의 광범위한 지수에 접근합니다.
Global Reach: 국제 시장의 지수 데이터를 제공하여 진정한 글로벌 관점을 확보합니다.
Basic Information on Each Index: 심볼, 전체 이름, 거래소 등 필수 세부 정보를 조회하여 필요한 지수를 식별합니다.
Currency Information: 각 지수가 표시된 통화를 파악하여 글로벌 투자자의 보다 정확한 분석을 지원합니다.

이 API는 여러 지역과 섹터에 걸쳐 시장 움직임을 모니터링해야 하는 투자자, 애널리스트, 포트폴리오 매니저에게 특히 유용합니다.

Example Use Case
글로벌 투자 전략을 구축하는 포트폴리오 매니저는 Stock Market Indexes List API를 활용하여 전 세계 거래소의 주요 지수 데이터를 조회할 수 있습니다. 다양한 지역의 관련 지수를 파악함으로써 시장 성과를 평가하고 자산 배분에 관한 정보에 기반한 결정을 내릴 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/index-list
```

**Sample Response:**

```json
[
    {
        "symbol": "^TTIN",
        "name": "S&P/TSX Capped Industrials Index",
        "exchange": "TSX",
        "currency": "CAD"
    }
]
```

---

### 242. Stock News API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/stock-news

**Summary:**

FMP Stock News Feed API를 통해 최신 주식 시장 뉴스를 확인하세요. 다양한 출처의 최신 기사에 대한 헤드라인, 요약, 게시 URL, 티커 심볼에 접근할 수 있습니다.

**About:**

Stock News API는 트레이더, 투자자, 금융 전문가가 다음과 같은 주식 시장 이벤트에 관한 최신 정보를 유지할 수 있도록 최신 데이터를 제공합니다:

Breaking Market News: 주가와 시장 움직임에 영향을 미칠 수 있는 최신 헤드라인에 접근합니다.
Company-Specific News: 실적 보고서, 제품 발표, 합병 등 개별 주식 관련 뉴스를 최신 상태로 유지합니다.
Market Trends and Analysis: 보다 나은 투자 결정을 위해 광범위한 시장 트렌드와 심리를 파악합니다.

이 API는 금융 전문가가 주식 시장 동향을 추적하고 정보에 기반한 결정을 내릴 수 있도록 시의적절한 뉴스를 제공하도록 설계되었습니다.

Example Use Case
포트폴리오 매니저는 Stock News API를 활용하여 주식 시장의 실시간 업데이트를 추적하고, 포트폴리오 내 주식 성과에 영향을 미칠 수 있는 뉴스를 즉시 파악합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/news/stock-latest?page=0&limit=20
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-28 |
| page | number | 0 |
| limit | number | 20 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "INSG",
        "publishedDate": "2025-02-03 23:53:40",
        "publisher": "Seeking Alpha",
        "title": "Q4 Earnings Release Looms For Inseego, But Don't Expect Miracles",
        "image": "https://images.financialmodelingprep.com/news/q4-earnings-release-looms-for-inseego-but-dont-expect-20250203.jpg",
        "site": "seekingalpha.com",
        "text": "Inseego's Q3 beat was largely due to a one-time debt restructuring gain, not sustainable earnings growth, raising concerns about future performance. The sale of its telematics business for $52 million allows INSG to focus on North America, but it remains to be seen if this was wise. Despite improved margins and reduced debt, Inseego's revenue growth is insufficient, and its high stock price remains unjustifiable for new investors.",
        "url": "https://seekingalpha.com/article/4754485-inseego-stock-q4-earnings-preview-monitor-growth-margins-closely"
    }
]
```

---

### 243. Stock Peer Comparison API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/peers

**Summary:**

FMP Stock Peer Comparison API를 통해 동일 섹터 및 시가총액 범위 내 기업을 파악하고 비교하세요. 같은 거래소에서 기업이 동종 기업 대비 어떻게 위치하는지에 대한 인사이트를 얻으세요.

**About:**

FMP Stock Peer Comparison API는 동일 거래소에서 거래되며, 같은 섹터에 속하고, 유사한 시가총액을 보유한 기업 목록을 선별하여 제공합니다. 이 API는 다음 목적에 필수적입니다:

Competitive Analysis: API를 활용하여 동종 기업 대비 기업 성과를 비교합니다. 이 비교를 통해 섹터 내에서 아웃퍼폼 또는 언더퍼폼하는 기업을 식별할 수 있습니다.
Sector-Specific Insights: 동일 섹터 및 시가총액 범위의 기업에 집중함으로써 상대적 성과 및 시장 내 위치를 보다 관련성 높고 정확하게 비교할 수 있습니다.
Investment Strategy: 이 정보를 활용하여 섹터 내 우수 기업을 발굴하거나 성장 잠재력이 있는 저평가 기업을 찾아 투자 전략을 정교화합니다.

이 API는 심층적인 경쟁 분석을 수행하고 기업의 동종 업체 대비 위치를 기반으로 정보에 기반한 결정을 내리고자 하는 투자자에게 유용한 리소스입니다.

Example Use Case
Performance Benchmarking: 투자자가 Stock Peer Comparison API를 활용하여 기술 기업의 매출 성장률과 주당순이익(EPS)을 동일 섹터 내 동종 기업과 비교합니다. 이를 통해 해당 기업이 분야 내 선두 기업인지 또는 경쟁사에 뒤처져 있는지를 판단할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/stock-peers?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "GOOGL",
        "companyName": "Alphabet Inc.",
        "price": 317.32,
        "mktCap": 3838620208180
    }
]
```

---

### 244. Stock Peers Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/peers-bulk

**Summary:**

Stock Peers Bulk API를 통해 데이터베이스 내 전체 주식의 동종 기업 목록을 신속하게 조회하세요. 이 데이터를 활용하여 동일 산업 또는 섹터 내 가장 유사한 경쟁사와 주식 성과를 손쉽게 비교할 수 있습니다.

**About:**

이 API는 투자자, 애널리스트, 포트폴리오 매니저가 다음 목적에 활용하도록 설계되었습니다:

Identify Competitors: 동일 산업에서 운영되거나 유사한 제품/서비스를 제공하는 동종 기업 목록을 조회합니다.
Benchmark Performance: 기업의 재무 성과 및 주식 지표를 동종 기업과 비교하여 상대적 강점 또는 약점을 평가합니다.
Strategic Analysis: 동종 기업 데이터를 활용하여 산업 수준의 분석을 수행하고 섹터 내 트렌드 또는 기회를 발굴합니다.
Investment Decisions: 매출 성장률, 수익성, 주가 성과 등 핵심 지표에서 기업이 경쟁사보다 두드러지는지 혹은 뒤처지는지를 평가합니다.

이 벌크 데이터 API는 단일 쿼리로 여러 주식의 동종 기업을 찾는 과정을 간소화하여 심층적인 시장 분석을 위한 유용한 도구가 됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/peers-bulk
```

**Sample Response:**

```json
[
    {
        "symbol": "000001.SZ",
        "peers": "600036.SS"
    }
]
```

---

### 245. Stock Price and Volume Data API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-price-eod-full

**Summary:**

FMP Comprehensive Stock Price and Volume Data API를 통해 특정 주식 심볼의 전체 가격 및 거래량 데이터에 접근하세요. 시가, 고가, 저가, 종가, 거래량, 가격 변동, 변동률, 거래량 가중 평균 가격(VWAP) 등 상세한 인사이트를 얻을 수 있습니다.

**About:**

FMP Comprehensive Stock Price and Volume Data API는 시간 경과에 따른 주식 성과에 관한 심층 데이터를 제공하여 애널리스트, 트레이더, 투자자에게 필수적인 도구입니다. 이 API를 통해 사용자는 다음을 활용할 수 있습니다:

Detailed Price Data: 각 거래일의 시가, 종가, 고가, 저가를 포함한 완전한 가격 정보에 접근합니다.
Trading Volume Insights: 일별 거래량 데이터를 조회하여 유동성과 시장 활동을 분석합니다.
Price Changes and Percentages: 절대 가격 변동과 변동률을 추적하여 가격 움직임을 평가합니다.
VWAP (Volume-Weighted Average Price): 거래량 기반 평균 가격인 VWAP를 조회하여 가격 추세와 시장 행태를 파악합니다.

이 API는 정보에 기반한 거래 및 투자 결정을 내리기 위해 상세하고 정확한 주식 가격 및 거래량 데이터가 필요한 사용자에게 최적입니다.

Example Use Case
재무 애널리스트가 Comprehensive Stock Price and Volume Data API를 활용하여 Apple의 일별 주식 성과를 모니터링하고, 가격 변동, VWAP, 거래량을 분석하여 트렌드를 파악하고 향후 가격 움직임을 예측합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/full?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "AAPL",
        "date": "2025-02-04",
        "open": 227.2,
        "high": 233.13,
        "low": 226.65,
        "close": 232.8,
        "volume": 44489128,
        "change": 5.6,
        "changePercent": 2.46479,
        "vwap": 230.86
    }
]
```

---

### 246. Stock Price Change API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/quote-change

**Summary:**

FMP Stock Price Change API를 통해 주가 변동을 실시간으로 추적하세요. 일별, 주별, 월별, 장기 등 다양한 기간에 걸친 등락폭과 변동률을 모니터링할 수 있습니다.

**About:**

FMP Stock Price Change API를 사용하면 다양한 시간대에 걸쳐 주식의 실시간 성과를 최신 상태로 유지할 수 있습니다. 이 API는 다음 목적에 필수적입니다:

Real-Time Monitoring: 1일, 5일, 1개월부터 최대 10년까지 다양한 시간 간격에 걸친 주가의 변동률 및 가격 변동을 추적합니다.
Investment Strategy: 데이터를 활용하여 주식 성과의 트렌드를 파악하고, 단기 및 장기 가격 움직임을 기반으로 정보에 기반한 결정을 내립니다.
Comparative Analysis: 여러 시간대에 걸친 가격 변동을 비교하여 시간 경과에 따른 주식 성과를 평가하고 포트폴리오 또는 전략을 적절히 조정합니다.

이 API는 전략과 결정을 수립하기 위해 상세한 주식 성과 데이터가 필요한 투자자, 트레이더, 애널리스트에게 유용한 리소스입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/stock-price-change?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "AAPL",
        "1D": 2.1008,
        "5D": -2.45946,
        "1M": -4.33925,
        "3M": 4.86014,
        "6M": 5.88556,
        "ytd": -4.53147,
        "1Y": 24.04092,
        "3Y": 35.04264,
        "5Y": 192.05871,
        "10Y": 678.8558,
        "max": 181279.04168
    }
]
```

---

### 247. Stock Quote API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/quote

**Summary:**

FMP Stock Quote API를 통해 실시간 주식 시세에 접근하세요. 개별 주식의 최신 가격, 등락, 거래량 데이터를 즉시 확인할 수 있습니다.

**About:**

FMP Stock Quote API는 개별 주식에 대한 상세한 실시간 주식 데이터를 제공하여 투자자, 트레이더, 재무 애널리스트에게 유용한 도구입니다. 이 API를 통해 다음을 수행할 수 있습니다:

Monitor Real-Time Prices: 최신 주가를 업데이트하여 정보에 기반한 거래 결정을 내립니다.
Analyze Stock Movements: 가격 변동, 거래량, 당일 고가/저가, 연간 고가/저가 등 핵심 데이터 포인트를 추적합니다.
Portfolio Tracking: 실시간 데이터를 활용하여 포트폴리오 내 주식 성과를 모니터링합니다.

개별 주식을 모니터링하거나 거래 전략을 구축하는 경우, 이 API는 가장 최신 정보를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "AAPL",
        "name": "Apple Inc.",
        "price": 232.8,
        "changePercentage": 2.1008,
        "change": 4.79,
        "volume": 44489128,
        "dayLow": 226.65,
        "dayHigh": 233.13,
        "yearHigh": 260.1,
        "yearLow": 164.08,
        "marketCap": 3500823120000,
        "priceAvg50": 240.2278,
        "priceAvg200": 219.98755,
        "exchange": "NASDAQ",
        "open": 227.2,
        "previousClose": 228.01,
        "timestamp": 1738702801
    }
]
```

---

### 248. Stock Quote Short API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/quote-short

**Summary:**

FMP Stock Quote Short API를 통해 실시간 주식 시세의 빠른 스냅샷을 조회하세요. 현재 가격, 등락, 거래량 등 핵심 주식 데이터에 즉시 접근하여 시장 인사이트를 빠르게 파악할 수 있습니다.

**About:**

FMP Stock Quote Short API는 빠르고 간결한 핵심 주식 정보 스냅샷을 원하는 사용자를 위해 설계되었습니다. 이 API는 다음 용도에 이상적입니다:

Quick Stock Monitoring: 최소한의 지연으로 현재 주가, 등락, 거래량 등 핵심 데이터를 조회하여 빠른 거래 결정을 지원합니다.
High-Frequency Trading: 빠른 업데이트가 필요한 트레이더는 이 API를 통해 간소화된 형식으로 시장을 앞서 나갈 수 있습니다.
Simplified Data Feed: 경량 데이터가 필요한 애플리케이션에 효율적이고 통합하기 쉬운 간결한 형식을 제공합니다.

이 API는 빠르고 정보에 기반한 거래 결정을 내리는 데 불필요한 데이터 포인트 없이 핵심 지표를 제공합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/quote-short?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "AAPL",
        "price": 232.8,
        "change": 4.79,
        "volume": 44489128
    }
]
```

---

### 249. Stock Rating Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/rating-bulk

**Summary:**

FMP Rating Bulk API를 통해 단일 요청으로 여러 주식의 포괄적인 등급 데이터를 조회하세요. 여러 기업의 전반적인 등급, DCF 권고안 등 핵심 재무 등급과 권고 사항을 한 번에 받아보세요.

**About:**

FMP Rating Bulk API는 전 세계 거래소의 주식에 대한 상세한 등급 정보를 제공합니다. 이 API는 다음 목적에 유용합니다:

Accessing Comprehensive Ratings: DCF, ROE, ROA, P/E 비율 등 다양한 재무 지표를 기반으로 한 등급을 조회합니다.
Bulk Data Requests: 단일 API 호출로 여러 주식의 등급 데이터를 조회하여 데이터 수집을 보다 효율적으로 수행합니다.
Supporting Investment Decisions: 포괄적인 재무 분석을 기반으로 개별 또는 대규모 주식에 대한 매수, 보유, 매도 결정을 안내하는 등급 데이터를 활용합니다.

이 API는 플랫폼이나 보고서에 대규모 등급 데이터를 통합하려는 투자자, 재무 애널리스트, 개발자에게 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/rating-bulk
```

**Sample Response:**

```json
[
    {
        "symbol": "000001.SZ",
        "date": "2025-07-09",
        "rating": "B+",
        "discountedCashFlowScore": "5",
        "returnOnEquityScore": "3",
        "returnOnAssetsScore": "2",
        "debtToEquityScore": "1",
        "priceToEarningsScore": "4",
        "priceToBookScore": "4"
    }
]
```

---

### 250. Stock Screener API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-company-screener

**Summary:**

FMP Stock Screener API를 통해 투자 전략에 부합하는 주식을 발굴하세요. 시가총액, 가격, 거래량, 베타, 섹터, 국가 등을 기준으로 주식을 필터링하여 최적의 투자 기회를 찾아보세요.

**About:**

FMP Company Stock Screener API는 투자자가 특정 투자 기준에 맞는 주식을 찾을 수 있도록 설계된 다목적 도구입니다. 이 API는 다음 목적에 필수적입니다:

Customizable Stock Searches: 시가총액, 가격, 거래량, 베타, 섹터, 국가 등 광범위한 기준으로 주식을 검색합니다. 투자 목표에 맞게 검색을 맞춤화할 수 있습니다.
Financial Criteria Filters: 수익성, 성장성, 밸류에이션 지표 등 재무 성과 지표를 기반으로 주식을 스크리닝하여 금융 전략에 맞는 주식을 찾습니다.
Investment Opportunities: Stock Screener API를 활용하여 관심 종목 목록을 구축하고, 새로운 투자 기회를 발굴하며, 심층적인 포트폴리오 분석을 수행합니다.

초보자든 경험 많은 투자자든, 이 API는 자신의 투자 방식에 부합하는 주식을 발굴하기 위한 유용한 리소스입니다.

Example Use Case
Building a Watchlist: 시가총액 100억 달러 이상의 기술주에 관심 있는 투자자가 Stock Screener API를 활용하여 잠재적 투자 기회를 필터링하고 관심 종목 목록을 생성합니다. 베타 및 거래량 등 다른 기준으로 목록을 더욱 세밀하게 조정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/company-screener
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| marketCapMoreThan | number | 1000000 |
| marketCapLowerThan | number | 10000000000000 |
| sector | string | Technology |
| industry | string | Consumer Electronics |
| betaMoreThan | number | 0.5 |
| betaLowerThan | number | 1.5 |
| priceMoreThan | number | 10 |
| priceLowerThan | number | 500 |
| dividendMoreThan | number | 0.5 |
| dividendLowerThan | number | 2 |
| volumeMoreThan | number | 1000 |
| volumeLowerThan | number | 100000000 |
| exchange | string | NASDAQ |
| country | string | US |
| isEtf | boolean | false |
| isFund | boolean | false |
| isActivelyTrading | boolean | true |
| limit | number | 1000 |
| includeAllShareClasses | boolean | false |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
    {
        "symbol": "WIMA",
        "companyName": "WisdomTree International Adaptive Moving Average Fund",
        "marketCap": null,
        "sector": "Financial Services",
        "industry": "Asset Management",
        "beta": null,
        "price": 41.0956,
        "lastAnnualDividend": null,
        "volume": 2979,
        "exchange": "NASDAQ Global Market",
        "exchangeShortName": "NASDAQ",
        "country": "US",
        "isEtf": false,
        "isFund": true,
        "isActivelyTrading": true
    }
]
```

---
### 251. Stock Split Details API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/splits-company

**Summary:**

FMP Stock Split Details API를 사용하여 특정 기업의 주식 분할에 대한 상세 정보에 접근하세요. 분할일과 분할 비율 등 핵심 데이터를 제공하여, 주식 분할 이후 회사 주식 구조 변화를 쉽게 파악할 수 있습니다.

**About:**

FMP Stock Split Details API는 기업의 주식 분할 이력에 대한 핵심 인사이트를 제공하도록 설계되었습니다. 이 API를 통해 사용자는 다음이 가능합니다:

Split Date Information: 기업의 주식 분할이 발생한 정확한 날짜에 접근하여 변경 시점을 파악합니다.
Split Ratio Details: 분자(numerator)와 분모(denominator)로 표현된 분할 비율을 조회하여 기존 주식 1주당 새로 발행되는 주식 수를 확인합니다.
Historical Reference: 주식 분할이 주가 및 시장 성과에 미치는 영향을 추적하고 분석합니다.

이 API는 주식 분할 이벤트를 모니터링하고, 주식 소유 구조와 시장 추세에 미치는 영향을 평가해야 하는 투자자 및 분석가에게 최적화되어 있습니다.

Example Use Case
애플(Apple)의 주식 분할 이력을 추적하고자 하는 투자자가 Stock Split Details API를 활용하여 과거 분할의 날짜 및 비율을 포함한 상세 데이터를 조회함으로써, 분할이 시간 경과에 따라 주가에 미친 영향을 평가할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/splits?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| Is your Splits calendar data split adjusted ? | Yes, we have historical data adjusted for splits and dividends. | How long does your data take to populate after a stock reports their earnings? |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2020-08-31",
		"numerator": 4,
		"denominator": 1
	}
]
```

---

### 252. Stock Splits Calendar API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/splits-calendar

**Summary:**

FMP Stock Splits Calendar API를 통해 예정된 주식 분할 일정을 미리 파악하세요. 여러 기업의 예정 분할일 및 분할 비율 등 핵심 데이터를 제공하여, 실제 발생 전에 주식 구조 변화를 추적할 수 있습니다.

**About:**

FMP Stock Splits Calendar API는 주식 분할 이벤트를 앞서 파악하고자 하는 투자자 및 분석가에게 적시 정보를 제공합니다. 이 API가 제공하는 내용은 다음과 같습니다:

Upcoming Split Dates: 향후 예정된 주식 분할 일정을 미리 확인하여 이벤트에 맞게 투자 계획을 수립합니다.
Split Ratios: 기존 주식(denominator) 1주당 새로 발행되는 주식(numerator) 수를 보여주는 상세 분할 비율에 접근합니다.
Market Insight: 이 데이터를 활용하여 예정된 분할이 주가, 유동성, 주주 가치에 미칠 영향을 평가합니다.

이 API는 시장 전반의 주식 분할 공지를 모니터링하여, 합리적인 투자 결정을 내리는 데 필요한 정보를 사용자에게 제공합니다.

Example Use Case
포트폴리오 매니저가 Stock Splits Calendar API를 활용하여 예정된 주식 분할 일정—예: 2024년 2월 29일 GBK.ST의 1대 100 분할—을 사전에 파악하고 전략을 적절히 조정할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/splits-calendar
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| page | number | 0 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| Is your Splits calendar data split adjusted ? | Yes, we have historical data adjusted for splits and dividends. | How long does your data take to populate after a stock reports their earnings? |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "EYEN",
		"date": "2025-02-03",
		"numerator": 1,
		"denominator": 80
	}
]
```

---

### 253. Stock Symbol Search API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/search-symbol

**Summary:**

FMP Stock Symbol Search API를 통해 모든 주식의 ticker symbol을 간편하게 검색하세요. 전 세계 여러 시장에서 symbol로 검색할 수 있습니다.

**About:**

FMP Stock Symbol Search API는 주식 ticker symbol을 빠르고 효율적으로 찾을 수 있도록 설계되었습니다. 미국 주식, 해외 주식, ETF 등 어떤 종목이든 빠르고 신뢰할 수 있는 결과를 제공합니다. 주요 기능은 다음과 같습니다:

Simple Search: 회사명 또는 ticker symbol을 입력하여 symbol, 회사명, 거래소, 통화 등 핵심 정보를 조회합니다.
Global Market Access: NASDAQ, NYSE 등 주요 증권거래소에서 종목을 검색합니다.
Accurate and Up-to-Date: API가 실시간 결과를 제공하여 항상 최신 ticker 정보를 활용할 수 있습니다.

Stock Symbol Search API는 다양한 시장에서 주식 symbol에 빠르게 접근해야 하는 트레이더, 투자자, 그리고 모든 사용자에게 적합합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/search-symbol?query=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| query* | string | AAPL |
| limit | number | 50 |
| exchange | string | NASDAQ |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"name": "Apple Inc.",
		"currency": "USD",
		"exchangeFullName": "NASDAQ Global Select",
		"exchange": "NASDAQ"
	}
]
```

---

### 254. Symbol Changes List API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/symbol-changes-list

**Summary:**

FMP Stock Symbol Changes API를 통해 최신 주식 symbol 변경 사항을 신속하게 파악하세요. 합병, 인수, 주식 분할, 사명 변경 등으로 인한 symbol 변경을 추적하여 정확한 거래 및 분석을 유지하세요.

**About:**

FMP Stock Symbol Changes API는 최근 주식 symbol 변경에 관한 포괄적인 데이터를 제공합니다. 이 API는 다음 용도에 필수적입니다:

Accurate Trading: symbol 변경은 합병, 인수, 주식 분할, 사명 변경 등 다양한 이유로 발생할 수 있습니다. 이러한 변경 사항을 최신 상태로 유지하면 거래 활동의 정확성과 오류 없는 실행을 보장합니다.
Portfolio Management: symbol 변경을 추적하여 투자 포트폴리오에 올바르고 현재의 주식 symbol이 반영되도록 함으로써 보유 종목의 불일치를 방지합니다.
Efficient Stock Tracking: API를 통해 최신 주식 symbol을 손쉽게 확인하여, 거래·조사·분석에 필요한 종목을 신속히 찾을 수 있습니다.

이 API는 금융 활동의 정확성을 유지하기 위해 symbol 변경을 지속적으로 추적해야 하는 트레이더, 투자자, 분석가에게 매우 유용한 도구입니다.

Example: Trading Accuracy: 트레이더가 기업 합병 후 symbol이 변경된 경우, Stock Symbol Changes API를 활용하여 트레이딩 플랫폼의 symbol을 최신 정보로 업데이트함으로써 오래된 정보로 인한 거래 오류 없이 정확하게 주문을 체결할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/symbol-change
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| invalid | string | false |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2025-02-03",
		"companyName": "XPLR Infrastructure, LP Common Units representing limited partner interests",
		"oldSymbol": "NEP",
		"newSymbol": "XIFR"
	}
]
```

---

### 255. Top Traded Stocks API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/most-active

**Summary:**

Top Traded Stocks API를 통해 가장 활발하게 거래되는 주식을 확인하세요. 시장에서 가장 높은 거래량을 기록 중인 기업을 식별하고, 거래 활동이 집중되는 종목을 추적합니다.

**About:**

FMP Top Traded Stocks API는 주요 증권거래소에서 거래량이 가장 높은 주식에 대한 실시간 데이터를 제공합니다. 이 API를 통해 트레이더와 투자자의 가장 큰 관심을 받고 있는 종목을 모니터링하고, 시장 활동과 유동성에 대한 귀중한 인사이트를 얻을 수 있습니다. 주요 기능은 다음과 같습니다:

Top Traded Stocks: 거래량을 기준으로 가장 활발하게 거래되는 주식 목록에 접근합니다.
Real-Time Volume Data: 각 주식의 거래량, 가격 변동, 등락률을 실시간으로 추적합니다.
Exchange-Specific Data: NASDAQ 또는 NYSE 등 특정 거래소에서 가장 활발하게 거래되는 주식을 모니터링합니다.
Company Information: 가장 많이 거래되는 기업의 회사명, symbol, 거래량 등 핵심 정보를 확인합니다.

이 API는 거래 또는 투자 전략 수립에 필요한 시장 내 거래 활동과 유동성을 추적해야 하는 트레이더, 분석가, 투자자에게 최적화되어 있습니다.

Example Use Case
데이 트레이더가 Top Traded Stocks API를 활용하여 NASDAQ에서 거래량이 가장 높은 종목을 파악하고, iSun, Inc. (ISUN)의 높은 거래량을 확인한 후 해당 주식의 모멘텀과 시장 관심도를 바탕으로 진입 여부를 결정합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/most-actives
```

**Sample Response:**

```json
[
	{
		"symbol": "LUCY",
		"price": 5.03,
		"name": "Innovative Eyewear, Inc.",
		"change": -0.01,
		"changesPercentage": -0.1984,
		"exchange": "NASDAQ"
	}
]
```

---

### 256. Transcripts Dates By Symbol API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/transcripts-dates-by-symbol

**Summary:**

FMP Transcripts Dates By Symbol API를 통해 특정 기업의 실적 발표 컨퍼런스 콜 transcript 날짜에 접근하세요. 회계연도 및 분기별 실적 발표 일정에 대한 종합적인 개요를 확인합니다.

**About:**

FMP Transcripts Dates By Symbol API는 특정 기업의 실적 발표 콜 transcript가 언제 제공되는지에 관한 정확한 정보를 사용자에게 제공합니다. 이 API는 다음을 포함하여 시간 경과에 따른 실적 논의 및 재무 인사이트를 추적하고자 하는 투자자, 분석가, 연구자에게 최적화되어 있습니다:

Earnings Call Availability by Quarter: 분기 및 회계연도별 transcript 날짜를 조회하여 기업 성과를 추적합니다.
Timely Access to Transcripts: 심층 분석을 위해 예정되거나 과거의 실적 발표 콜 transcript에 적시에 접근합니다.
Comprehensive Coverage: 더 나은 의사 결정을 위해 여러 분기에 걸친 실적 발표 콜 transcript를 식별하고 분석합니다.

이 API는 사용자가 실적 발표 일정을 파악하고, 특정 기간의 transcript를 통해 핵심 재무 인사이트에 접근하는 데 도움을 주도록 설계되었습니다.

Example Use Case
투자 회사가 Transcripts Dates By Symbol API를 활용하여 기업의 분기별 실적 발표 콜 일정을 파악하고, 상세한 성과 분석 및 전략적 계획 수립을 위해 해당 transcript에 접근합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/earning-call-transcript-dates?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"quarter": 1,
		"fiscalYear": 2025,
		"date": "2025-01-30"
	}
]
```

---

### 257. Treasury Rates API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/treasury-rates

**Summary:**

FMP Treasury Rates API를 통해 모든 만기의 최신 및 과거 미국 국채 금리에 접근하세요. 경제 전반의 금리 기준 지표를 추적합니다.

**About:**

Treasury Rates API는 모든 만기의 국채 금리에 대한 최신 및 과거 데이터를 제공합니다. 이 금리는 미국 정부가 채무에 지급하는 이자율을 나타내며, 경제 전반의 금리에 대한 핵심 기준 지표 역할을 합니다. 투자자는 이 API를 활용하여 다음이 가능합니다:

Track Treasury Rates Over Time: 국채 금리의 움직임을 모니터링하고, 기간에 따른 변화를 파악합니다.
Identify Interest Rate Trends: 금리 추세를 분석하여 광범위한 경제 상황에 대한 인사이트를 얻습니다.
Make Informed Investment Decisions: 현재 및 과거 금리 정보를 바탕으로 투자 전략을 수립하는 데 데이터를 활용합니다.

이 API는 국채 금리에 대한 정확하고 시의적절한 정보가 필요한 투자자, 분석가, 이코노미스트에게 없어서는 안 될 도구입니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/treasury-rates
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08",
		"month1": 3.67,
		"month2": 3.71,
		"month3": 3.69,
		"month6": 3.73,
		"year1": 3.69,
		"year2": 3.79,
		"year3": 3.78,
		"year5": 3.92,
		"year7": 4.1,
		"year10": 4.29,
		"year20": 4.87,
		"year30": 4.89
	}
]
```

---

### 258. Triple Exponential Moving Average API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/triple-exponential-moving-average

**Summary:**

3·EMA − 3·EMA(EMA) + EMA(EMA(EMA))로 정의되는, 지연(lag)이 더욱 감소된 이동평균으로, EMA 및 DEMA보다 가격에 더 밀착합니다.

**About:**

TEMA(Triple Exponential Moving Average)는 지수 필터의 평활화 이점을 대부분 유지하면서 DEMA보다 더 많은 지연을 상쇄하는 방식으로 세 개의 EMA를 중첩합니다. 빠른 추세 확인을 원하는 단기 추세 추종 트레이더에게 선호되지만, 더 날카로운 방향 전환으로 인해 변동성이 낮은 구간에서는 whipsaw(가격 급반전에 의한 손실)에 더 취약할 수 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/tema?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"tema": 257.8714144716564
	}
]
```

---

### 259. U.S. House Trades API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/house-trading

**Summary:**

FMP U.S. House Trades API를 통해 미국 하원의원과 그 가족이 수행한 금융 거래를 추적하세요. 주식 매도, 매수 및 기타 투자 활동에 대한 실시간 정보에 접근하여 이들의 재무적 의사 결정을 파악합니다.

**About:**

FMP U.S. House Trades API는 미국 하원의원과 그 배우자의 거래 활동에 대한 포괄적인 뷰를 제공합니다. 이 API는 주식 매도·매수, 소유 내역, 거래 금액 등 상세한 거래 데이터를 제공합니다. 사용자는 다음이 가능합니다:

Monitor Trading Activity: 미국 하원의원과 그 가족이 수행한 최신 주식 거래 내역을 실시간으로 파악합니다.
Understand Financial Moves: 상세한 거래 데이터를 통해 정부 관계자들의 재무적 의사 결정에 대한 인사이트를 얻습니다.
Transparency and Accountability: 미국 하원의원의 재무적 행동을 추적하여 정부의 투명성과 책임성을 높이는 데 데이터를 활용합니다.

이 API는 미국 하원의원의 재무적 움직임을 파악하고자 하는 정치 분석가, 언론인, 그리고 일반 대중에게 최적화되어 있습니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/house-trades?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| page | number | 0 |
| limit | number | 100 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"disclosureDate": "2026-04-08",
		"transactionDate": "2025-11-13",
		"firstName": "Ed",
		"lastName": "Case",
		"office": "Ed Case",
		"district": "HI01",
		"owner": "",
		"assetDescription": "Apple Inc",
		"assetType": "Stock",
		"type": "Purchase",
		"amount": "$1,001 - $15,000",
		"capitalGainsOver200USD": "False",
		"comment": "",
		"link": "https://disclosures-clerk.house.gov/public_disc/ptr-pdfs/2026/20034221.pdf"
	}
]
```

---

### 260. Unadjusted Stock Price API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/historical-price-eod-non-split-adjusted

**Summary:**

FMP Unadjusted Stock Price Chart API를 통해 주식 분할 조정이 적용되지 않은 주가 및 거래량 데이터에 접근하세요. 분할 관련 변경 없이 시가, 고가, 저가, 종가 및 거래량을 포함한 순수한 주가 성과 인사이트를 얻을 수 있습니다.

**About:**

FMP Unadjusted Stock Price Chart API는 주식 분할 조정이 적용되지 않은 과거 주가 데이터를 제공하여, 트레이더·분석가·투자자가 분할 관련 조정 없이 주가 성과를 조회할 수 있도록 합니다. 이는 주식 분할 전후 주가가 어떻게 움직였는지 명확하게 확인하고자 하는 사용자에게 유용합니다. 주요 기능은 다음과 같습니다:

Unadjusted Price Data: 주식 분할에 대한 어떠한 조정도 없는 과거 주가—시가, 고가, 저가, 종가—에 접근합니다.
Volume Data: 시장 활동 심층 분석을 위한 일별 거래량 데이터를 조회합니다.
Pre-Split Analysis: 분할 이벤트 이전 원본 형태의 주가 성과를 확인하여, 분할 전 추세를 보다 용이하게 분석합니다.
Clear Historical View: 주식 분할로 인한 데이터 왜곡을 피하고자 하는 투자자와 분석가를 위해, 수정되지 않은 명확한 데이터를 제공합니다. 이 API는 보다 정밀한 과거 분석을 위해 정확하고 분할 미반영 주가 데이터가 필요한 모든 사용자에게 적합합니다.

Example Use Case
애플(Apple) 주식의 분할 전후 성과를 분석하는 시장 조사자가 Unadjusted Stock Price Chart API를 활용하여 분할 관련 조정이 없는 순수 주가 데이터를 조회합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/historical-price-eod/non-split-adjusted?symbol=AAPL
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| from | date | 2026-01-27 |
| to | date | 2026-04-27 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"symbol": "AAPL",
		"date": "2025-02-04",
		"adjOpen": 227.2,
		"adjHigh": 233.13,
		"adjLow": 226.65,
		"adjClose": 232.8,
		"volume": 44489128
	}
]
```

---

### 261. Upgrades Downgrades Consensus Bulk API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/upgrades-downgrades-consensus-bulk

**Summary:**

Upgrades Downgrades Consensus Bulk API는 모든 symbol에 걸친 애널리스트 등급에 대한 종합적인 뷰를 제공합니다. 애널리스트의 등급 상향(upgrade), 등급 하향(downgrade), 컨센서스 투자의견 데이터를 일괄 조회하여 개별 주식에 대한 시장의 전망을 파악하세요.

**About:**

이 API를 통해 사용자는 다음에 접근할 수 있습니다:

Analyst Recommendations: 단일 요청으로 여러 주식에 대한 강력 매수(strong buy), 매수(buy), 보유(hold), 매도(sell), 강력 매도(strong sell) 등 상세 등급을 확인합니다.
Consensus Ratings: 애널리스트 투자의견을 기반으로 한 각 주식의 전체 컨센서스를 조회하여 전반적인 시장 심리를 평가합니다.
Upgrades and Downgrades Trends: 다양한 symbol에 걸친 최근 등급 상향 또는 하향 추세를 추적하여 잠재적인 투자 기회나 리스크를 식별합니다.
Market Insights: 전문가 분석 및 투자의견을 바탕으로 시장이 특정 주식의 미래 성과를 어떻게 전망하는지에 대한 귀중한 인사이트를 얻습니다.

이 API는 대량으로 주식 등급을 모니터링하여 최신 시장 트렌드와 애널리스트 의견을 기반으로 보다 합리적인 결정을 내리고자 하는 기관 투자자, 포트폴리오 매니저, 금융 분석가에게 특히 유용합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/upgrades-downgrades-consensus-bulk
```

**Sample Response:**

```json
[
	{
		"symbol": "",
		"strongBuy": "0",
		"buy": "1",
		"hold": "1",
		"sell": "0",
		"strongSell": "0",
		"consensus": "Buy"
	}
]
```

---

### 262. Weighted Moving Average API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/weighted-moving-average

**Summary:**

과거 가격에 선형적으로 감소하는 가중치를 부여하는 이동평균으로, EMA의 반응성과 결정론적 감쇠(deterministic decay)의 균형을 맞춥니다.

**About:**

길이 N의 WMA(Weighted Moving Average)에서 가장 최근 종가에는 N의 가중치가 부여되고, 그 이전 값에는 N-1이 부여되는 방식으로 진행되며, 그 합계를 N(N+1)/2로 나눕니다. 선형 감쇠는 SMA보다 최근 데이터를 더 강조하면서도 EMA보다 단순하고 예측 가능하게 유지됩니다. 이로 인해 WMA는 명확하고 한정된 가중 프로파일(bounded weighting profile)이 요구될 때 유용하게 활용됩니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/wma?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| How the FMP calculate the "AvgVol"? | The formula used to calculate  Volume-Weighted Average Price (VWAP) is:
vwap = ((high + low + close) / 3 * volume) / volume | What is the period used to calculate Volume-Weighted Average Price (VWAP)? |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"wma": 255.03400000000005
	}
]
```

---

### 263. Williams API

**Doc:** https://site.financialmodelingprep.com/developer/docs/stable/williams

**Summary:**

-100과 0 사이에서 진동하는 모멘텀 오실레이터로, 조회 기간(look-back window)의 최고가와 최저가 대비 현재 종가의 상대적 위치를 나타냅니다.

**About:**

Williams %R은 -20 이상을 과매수(overbought), -80 이하를 과매도(oversold)로 판단하며, Stochastic과 동일한 구조를 사용하되 고가와 저가만을 활용합니다. 특히 장기 추세 필터와 결합하여 역추세 신호를 방지할 때, 추세 시장에서의 단기 소진(exhaustion) 구간을 식별하는 데 적합합니다.

**Endpoint:**

```
https://financialmodelingprep.com/stable/technical-indicators/williams?symbol=AAPL&periodLength=10&timeframe=1day
```

**Parameters:**

| Name | Type | Example |
|------|------|---------|
| symbol* | string | AAPL |
| periodLength* | number | 10 |
| timeframe* | string | 1min5min15min30min1hour4hour1day |
| from | date | 2026-03-01 |
| to | date | 2026-06-01 |
| Get Started: Sign Up Today! | Begin your data journey by signing up and accessing our API endpoints. Get instant access to a vast array of financial data to power your applications and analyses. | Dive into Data: Free Plan Access |
| API | FMP | Stock Screener |

**Sample Response:**

```json
[
	{
		"date": "2026-04-08 00:00:00",
		"open": 258.45,
		"high": 259.75,
		"low": 256.53,
		"close": 258.9,
		"volume": 39655304,
		"williams": -19.579579579579825
	}
]
```

---
