package Ch06;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class C11RestRequestResponseMain중요 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// 01 파라미터 지정
		String url = "https://www.daegufood.go.kr/kor/api/tasty.html";
		String mode = "json";
		String addr = "중구";
		url += "?"+"mode="+mode+"&addr="+addr;
		
		// 02 HTTP Request 구성
		HttpRequest request = 	HttpRequest
								.newBuilder()
								.uri(URI.create(url))
								.GET()
								.build();
		
		// 03 HTTP Request 요청 -> HTTP Response 받기
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = 
		httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(response.body());
		
		// 04 Response -> JAVA화(  1) ObjectMapper(JSON Type 유지) , 2) JAVA Class 변환 )
		
		// 04-01) ObjectMapper(JSON Type 유지)
		ObjectMapper mapper = new ObjectMapper();
//		JsonNode jsonNode = mapper.readTree(response.body());
//		System.out.println("status : " + jsonNode.get("status"));
//		System.out.println("total : " + jsonNode.get("total"));
//		JsonNode data = jsonNode.get("data");
//		for(int i=0;i<data.size();i++) {
//			JsonNode item = data.get(i);
//			System.out.println(item.get("BZ_NM"));
//		}	
		
		// 2) JAVA Class 변환
		Root responseObject = mapper.readValue(response.body(), Root.class);
		System.out.println("status : " + responseObject.status);
		System.out.println("total : " + responseObject.total);
		responseObject.data.forEach(System.out::println);
		
		ArrayList<Datum> list =  responseObject.data;
		
		
		
		

	}
	
	private static class Datum{
	    public String cnt;
	    @JsonProperty("OPENDATA_ID") 
	    public String oPENDATA_ID;
	    @JsonProperty("GNG_CS") 
	    public String gNG_CS;
	    @JsonProperty("FD_CS") 
	    public String fD_CS;
	    @JsonProperty("BZ_NM") 
	    public String bZ_NM;
	    @JsonProperty("TLNO") 
	    public String tLNO;
	    @JsonProperty("MBZ_HR") 
	    public String mBZ_HR;
	    @JsonProperty("SEAT_CNT") 
	    public String sEAT_CNT;
	    @JsonProperty("PKPL") 
	    public String pKPL;
	    @JsonProperty("HP") 
	    public String hP;
	    @JsonProperty("PSB_FRN") 
	    public String pSB_FRN;
	    @JsonProperty("BKN_YN") 
	    public String bKN_YN;
	    @JsonProperty("INFN_FCL") 
	    public String iNFN_FCL;
	    @JsonProperty("BRFT_YN") 
	    public String bRFT_YN;
	    @JsonProperty("DSSRT_YN") 
	    public String dSSRT_YN;
	    @JsonProperty("MNU") 
	    public String mNU;
	    @JsonProperty("SMPL_DESC") 
	    public String sMPL_DESC;
	    @JsonProperty("SBW") 
	    public String sBW;
	    @JsonProperty("BUS") 
	    public String bUS;
		@Override
		public String toString() {
			return "Datum [cnt=" + cnt + ", oPENDATA_ID=" + oPENDATA_ID + ", gNG_CS=" + gNG_CS + ", fD_CS=" + fD_CS
					+ ", bZ_NM=" + bZ_NM + ", tLNO=" + tLNO + ", mBZ_HR=" + mBZ_HR + ", sEAT_CNT=" + sEAT_CNT
					+ ", pKPL=" + pKPL + ", hP=" + hP + ", pSB_FRN=" + pSB_FRN + ", bKN_YN=" + bKN_YN + ", iNFN_FCL="
					+ iNFN_FCL + ", bRFT_YN=" + bRFT_YN + ", dSSRT_YN=" + dSSRT_YN + ", mNU=" + mNU + ", sMPL_DESC="
					+ sMPL_DESC + ", sBW=" + sBW + ", bUS=" + bUS + "]";
		}
	    
	    
	    
	}

	private static class Root{
	    public String status;
	    public String total;
	    public ArrayList<Datum> data;
	}
	
	
	

}
