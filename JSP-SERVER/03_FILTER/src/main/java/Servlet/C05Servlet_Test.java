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

import DbUtils.AuthDTO;
import DbUtils.UserDAO;
import DbUtils.UserDTO;
import Type.ROLE;

@WebServlet("/login.do")
public class C05Servlet_Test extends HttpServlet{
	
	private UserDAO userDAO;
	HttpSession session;
	HttpServletRequest req;
	
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /login.do");
		
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
	}
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST /Login.do");
		

		
		AuthDTO authDTO = new AuthDTO();
		try {
			
			//01 파라미터 받기
//			String userid = req.getParameter("userid");
//			String password = req.getParameter("password");
			
			BeanUtils.populate(authDTO, req.getParameterMap());
			System.out.println("authDTO : " + authDTO);

			
			session = req.getSession();
			this.req = req;
			
			//02 데이터 유효성 검증(생략)
			if(!isValid(authDTO)) {
				//JOIN FORWARDING
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				return ;
			}
			
			//03 서비스 실행(Service Layer 로 이동)
			UserDTO userDTO = userDAO.select(authDTO.getUserid());
			
			if(userDTO==null){
				req.setAttribute("isAuth", false);
				req.setAttribute("userid", "⚠ 동일한 ID가 없습니다.");
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
				
				//메시지
				return ;
			}
			if(!authDTO.getPassword().equals(userDTO.getPassword())){
				req.setAttribute("isAuth", false);
				req.setAttribute("password", "⚠ PW가 일치하지 않습니다.");
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			
				return ;
			}
			//세션 인증저장
			session.setMaxInactiveInterval(60);
			session.setAttribute("isAuth", true);
			if(authDTO.getUserid().equals("admin")){
				session.setAttribute("role", ROLE.ROLE_ADMIN);	//2
			}else{
				session.setAttribute("role", ROLE.ROLE_USER);	//0
			}
			
			
			//04 뷰로 이동(내용 전달)
			resp.sendRedirect(req.getContextPath() + "/main.do");
			session.setAttribute("message", "✔ 로그인 완료!");
			
			
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
	
	private boolean isValid(AuthDTO authDTO) {
		
		boolean isOK = true;
		
		if(authDTO.getUserid() == null || authDTO.getUserid().isEmpty() ) {
			req.setAttribute("userid", "⚠ USERID를 입력하세요.");
			isOK = false;
		}
		if(authDTO.getPassword() == null || authDTO.getPassword().isEmpty() ) {
			req.setAttribute("password", "⚠ PASSWORD를 입력하세요.");
			isOK = false;
		}
		
		return isOK;
	}
	
	
	
}	