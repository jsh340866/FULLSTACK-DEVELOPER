package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class C02Servlet_Test extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// 서블릿 최초 실행 메서드
		System.out.println("init invoke...2");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 요청시마다 동작하는 메서드
		System.out.println("service invoke...2");
	}

	@Override
	public void destroy() {
		// 내용 변경 감지시 동작하는 메서드
		System.out.println("destroy invoke...2");
	}

	
	
	
	
	
}
