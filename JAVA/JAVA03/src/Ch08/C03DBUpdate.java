package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C03DBUpdate {

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
			pstmt = conn.prepareStatement("update tbl_a set name=? where no=?");
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			
			//sql를 dbms로 전달
			int result = pstmt.executeUpdate();
			System.out.println("result : " + result);
			
			//결과값으로 java에서 처리
			if(result > 0)
				System.out.println("UPDATE 성공");
			else
				System.out.println("UPDATE 실패");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();}catch(Exception e2) {e2.printStackTrace();}
			try {conn.close();}catch(Exception e2) {e2.printStackTrace();}
		}
		
	}

}
