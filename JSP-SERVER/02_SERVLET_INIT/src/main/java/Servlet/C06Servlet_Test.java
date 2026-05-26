package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class C06Servlet_Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET /logout.do");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		
		// forward 방식
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);	
		
		
	}
	
}
