package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class C07OPENDATA_JDBC중요 {

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
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");

			//
			pstmt = conn.prepareStatement("select * from tbl_park");

			// sql를 dbms로 전달
			rs = pstmt.executeQuery();

			List<C07ParkingDto> list = new ArrayList<>();
			C07ParkingDto dto = null;

			while (rs.next()) {
				dto = new C07ParkingDto();
				dto.set위반구분(rs.getString("위반구분"));
				dto.set위반일시(rs.getString("위반일시"));
				dto.set위반장소(rs.getString("위반장소"));
				dto.set과태료부과일자(rs.getString("과태료부과일자"));
				dto.set데이터기준일자(rs.getString("데이터기준일자"));

				list.add(dto);
			}
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
