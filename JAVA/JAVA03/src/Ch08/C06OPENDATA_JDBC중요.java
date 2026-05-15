package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class C06OPENDATA_JDBC중요 {

	public static void main(String[] args) {

		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/opendatadb";

		// JDBC참조변수
		Connection conn = null;			// DBMS의 특징 DB와 연결되는 객
		PreparedStatement pstmt = null; // SQL Qyery 전송용 객체
		ResultSet rs = null; 			// Select 결과물 담을 객체

		try {
			//
			Class.forName("com.mysql.cj.jdbc.Driver");		
			System.out.println("Driver Loading Success...");
			
			//
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED..."); 
			
			//
			pstmt = conn.prepareStatement("select * from tbl_charge");
			
			
			//sql를 dbms로 전달
			rs = pstmt.executeQuery();
			
			List<C06ChargeDto> list = new ArrayList<>();
			C06ChargeDto dto = null;
			
			
			while(rs.next()) {
				dto = new C06ChargeDto();
				dto.set순번(rs.getInt("순번"));
				dto.set행정구역(rs.getString("행정구역"));
				dto.set지사(rs.getString("지사"));
				dto.set시설명(rs.getString("시설명"));
				dto.set우편번호(rs.getInt("우편번호"));
				dto.set주소(rs.getString("주소"));
				
				list.add(dto);
			}
			list.forEach(System.out::println);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e2) {e2.printStackTrace();}
			try {pstmt.close();}catch(Exception e2) {e2.printStackTrace();}
			try {conn.close();}catch(Exception e2) {e2.printStackTrace();}
		}
		
	}

}
