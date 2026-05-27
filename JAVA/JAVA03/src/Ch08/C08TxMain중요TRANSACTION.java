package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class C08TxMain중요TRANSACTION {

	public static void main(String[] args) {

		// DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/opendatadb";

		// JDBC참조변수
		Connection conn = null;			// DBMS의 특징 DB와 연결되는 객
		PreparedStatement pstmt = null; // SQL Qyery 전송용 객체
		ResultSet rs = null; 			// Select 결과물 담을 객체

		Savepoint sp1 = null;
		
		try {
			
			//
			Class.forName("com.mysql.cj.jdbc.Driver");		
			System.out.println("Driver Loading Success...");
			
			//
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED..."); 
			
			// TX START
			conn.setAutoCommit(false);
			
			//
			pstmt = conn.prepareStatement("insert into tbl_a values(1,'a')");
			pstmt.executeUpdate();
			
			sp1 = conn.setSavepoint("sp1");
			
			pstmt = conn.prepareStatement("insert into tbl_a values(2,'b')");
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbl_a values(3,'c')");
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbl_a values(3,'d')");
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbl_a values(5,'e')");
			pstmt.executeUpdate();
		
			//
			conn.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				if(sp1 != null) {
					conn.rollback(sp1);
				}
				else {
					conn.rollback();
				}
				conn.commit();
				
			}catch(Exception rollback) {rollback.printStackTrace();}
		} finally {
			try {pstmt.close();}catch(Exception e2) {e2.printStackTrace();}
			try {conn.close();}catch(Exception e2) {e2.printStackTrace();}
		}
	}
	
}
