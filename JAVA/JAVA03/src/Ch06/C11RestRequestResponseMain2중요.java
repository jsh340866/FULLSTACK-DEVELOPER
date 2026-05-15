package Ch06;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class C11RestRequestResponseMain2중요 {

	public static void main(String[] args) throws IOException, InterruptedException {

		// https://www.data.go.kr/data/15059414/openapi.do

		// ObjectMapper - JSON
		// 01 파라미터 지정
		String url = "https://thegoodnight.daegu.go.kr/ajax/api/thegoodnight.html";
		String mode = "json";
		int item_count = 10;
		url += "?"+"mode="+mode+"&item_count="+item_count;
		System.out.println(url);
		// 02 HTTP Request 구성
		HttpRequest request = 	HttpRequest.newBuilder()
										   .uri(URI.create(url))
										   .GET()
										   .build();
		// 03 HTTP Request 요청 -> HTTP Response 받기
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = 
				httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
										  
		// 04 Response -> JAVA화( 1) ObjectMapper(JSON Type 유지) , 2) JAVA Class 변환 )
		// 04-01) ObjectMapper(JSON Type 유지)
		ObjectMapper mapper = new ObjectMapper();
//		JsonNode jsonNode = mapper.readTree(response.body());
//		System.out.println("status : " + jsonNode.get("status"));
//		System.out.println("total : " + jsonNode.get("total"));
//		JsonNode data = jsonNode.get("data");
//		for(int i=0;i<data.size();i++) {
//			JsonNode item = data.get(i);
//			System.out.println(item.get("shop"));
//		}	
		

		

		// 04-02) ObjectMapper - JAVA Class
		Root responseObject = mapper.readValue(response.body(), Root.class);
		System.out.println("status : " + responseObject.status);
		System.out.println("total : " + responseObject.total);
		responseObject.data.forEach(System.out::println);
		
		ArrayList<Datum> list =  responseObject.data;
		
	}
	
	private static class Datum{
	    public String num;
	    public String shop;
	    public String tel;
	    public String address;
	    public String offer;
	    public String facilities;
	    public String tag;
		@Override
		public String toString() {
			return "Datum [num=" + num + ", shop=" + shop + ", tel=" + tel + ", address=" + address + ", offer=" + offer
					+ ", facilities=" + facilities + ", tag=" + tag + "]";
		}
	    
	    
	}

	private static class Root{
	    public String status;
	    public String total;
	    public ArrayList<Datum> data;
	}
	
	
}
