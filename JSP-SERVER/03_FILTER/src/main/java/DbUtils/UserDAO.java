package DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private static final String SQL_INSERT = "INSERT INTO tbl_user VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SQL_SELECT_ALL = "SELECT * " + "FROM tbl_user ORDER BY userid ASC";
	
	private static final String SQL_SELECT = "SELECT * " + "FROM tbl_user where userid = ?";

	private static final String SQL_UPDATE = "UPDATE tbl_user SET password=?, rePassword=?, username=?, zipcode=?, addr1=?, addr2=?, ph01=?, ph02=?, ph03=?, tel01=?, tel02=?, tel03=?, email01=?, email02=?, birthType=?, birthYear=?, birthMonth=?, birthDay=?, email_recv=?, sms_recv=? WHERE userid=? ";

	private static final String SQL_DELETE = "DELETE FROM tbl_user WHERE userid = ?";

	/**
	 * 메모 1건 등록.
	 *
	 * <p>
	 * 학생 TODO: try-with-resources 로 Connection / PreparedStatement 획득 → setString
	 * 으로 2개 파라미터 바인딩 → executeUpdate() 반환.
	 * </p>
	 */
	public int insert(UserDTO dto) throws SQLException {
//        // TODO: PreparedStatement 로 SQL_INSERT 실행
//        throw new UnsupportedOperationException("UserDTODAO.insert() — TODO: 구현하세요.");
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);) {
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getRePassword());
			pstmt.setString(4, dto.getUsername());
			pstmt.setString(5, dto.getZipcode());
			pstmt.setString(6, dto.getAddr1());
			pstmt.setString(7, dto.getAddr2());
			pstmt.setString(8, dto.getPh01());
			pstmt.setString(9, dto.getPh02());
			pstmt.setString(10, dto.getPh03());
			pstmt.setString(11, dto.getTel01());
			pstmt.setString(12, dto.getTel02());
			pstmt.setString(13, dto.getTel03());
			pstmt.setString(14, dto.getEmail01());
			pstmt.setString(15, dto.getEmail02());
			pstmt.setString(16, dto.getBirthType());
			pstmt.setString(17, dto.getBirthYear());
			pstmt.setString(18, dto.getBirthMonth());
			pstmt.setString(19, dto.getBirthDay());
			pstmt.setString(20, dto.getEmail_recv());
			pstmt.setString(21, dto.getSms_recv());
			return pstmt.executeUpdate();
		}
	}

	// TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public UserDTO select(String userid) throws SQLException {
		UserDTO dto = null;
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
				) {
				
			
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserid(rs.getString("userid"));
				dto.setPassword(rs.getString("password"));
			}
			return dto;	// null or UserDTO
		}	finally {
			
		}
	}

	/**
	 * 전체 메모 조회.
	 *
	 * <p>
	 * 학생 TODO: try-with-resources 로 Connection / PreparedStatement / ResultSet 획득 →
	 * rs.next() 루프 → UserDTO 객체 채워서 List 에 추가.
	 * </p>
	 */
	public List<UserDTO> selectAll() throws SQLException {
		// TODO: PreparedStatement 로 SQL_SELECT_ALL 실행 → ResultSet 순회 → UserDTO List 반환
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_ALL);
				ResultSet rs = pstmt.executeQuery();) {
			List<UserDTO> list = new ArrayList<>();
			UserDTO dto = null;
			while (rs.next()) {
				UserDTO m = new UserDTO();
				//
				list.add(m);
			}

			return list;
		}
	}

	/**
	 * 메모 1건 수정.
	 *
	 * <p>
	 * 학생 TODO: SQL_UPDATE 실행. 파라미터 3개: title, content, UserDTOId(WHERE).
	 * </p>
	 */
	public int update(UserDTO UserDTO) throws SQLException {
		// TODO: PreparedStatement 로 SQL_UPDATE 실행
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);) {
			//
			return pstmt.executeUpdate();
		}
	}

	/**
	 * 메모 1건 삭제.
	 *
	 * <p>
	 * 학생 TODO: SQL_DELETE 실행. setInt(1, UserDTOId).
	 * </p>
	 */
	public int delete(int UserDTOId) throws SQLException {
		// TODO: PreparedStatement 로 SQL_DELETE 실행
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);) {
			//
			return pstmt.executeUpdate();
		}
	}
}
