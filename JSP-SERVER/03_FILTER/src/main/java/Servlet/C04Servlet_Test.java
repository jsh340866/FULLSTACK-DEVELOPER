package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import DbUtils.UserDAO;
import DbUtils.UserDTO;

@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet{
	
	private UserDAO userDAO;
	HttpSession session;
	HttpServletRequest req;

	@Override
	public void init() throws ServletException {
		// 최초 실행때 한번
		userDAO = new UserDAO();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /join.do");
		
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST /join.do");
		

		
		UserDTO userDTO = new UserDTO();
		try {
			
			//01 파라미터 받기
//			String userid = req.getParameter("userid");
//			String password = req.getParameter("password");
			
			BeanUtils.populate(userDTO, req.getParameterMap());
			System.out.println("UserDTO : " + userDTO);

			
			session = req.getSession();
			this.req = req;
			
			//02 유효성 검증(생략)
			if(!isValid(userDTO)) {
				//JOIN FORWARDING
				req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
				return ;
			}
			
			//03 서비스 실행(Service Layer 로 이동)
			int result = userDAO.insert(userDTO);
			
			
			//04 뷰로 이동(내용 전달)
			if(result>0) {
				resp.sendRedirect( req.getContextPath() +"/login.do");
				session.setAttribute("message", "회원가입 성공!");
			}else {
				req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
				req.setAttribute("message", "회원가입 실패..");
			}
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
	}
	
	private boolean isValid(UserDTO userDTO) {
		
		boolean isOK = true;
		
		if(userDTO.getUserid() == null || userDTO.getUserid().isEmpty() ) {
			req.setAttribute("userid", "⚠ USERID를 입력하세요.");
			isOK = false;
		}
		if(userDTO.getPassword() == null || userDTO.getPassword().isEmpty() ) {
			req.setAttribute("password", "⚠ PASSWORD를 입력하세요.");
			isOK = false;
		}
		
		return isOK;
	}
	
	
}	