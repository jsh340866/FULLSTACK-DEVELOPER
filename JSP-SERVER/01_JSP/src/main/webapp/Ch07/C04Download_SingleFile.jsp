<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.io.*" %>    
<%
	
	String dirPath = pageContext.getServletContext().getRealPath("/")+"Ch07\\files\\";
	System.out.println("REAL_PATH : " + dirPath);

	//INPUTSTREAM
	InputStream fin = new FileInputStream(dirPath+"file1.svg");

	//OUT객체의 스트림을 제거
	out.clear();					// response outStream을 닫고 버퍼 초기화
	out=pageContext.pushBody();		// 현재페이지의 Body에 out 연결
	
	//RESPONSE HEADER 설정()
	response.setHeader("Content-Type", "application/octet-stream;charset-utf-8");
	response.setHeader("Content-Disposition", "attachment; filenmae=file1.svg");
	
	//OUTPUTSTREAM
	ServletOutputStream bout = response.getOutputStream();
	
	byte [] buff = new byte[4096];
	while(true) {
		int data = fin.read(buff);
		if(data == -1)
			break;
		bout.write(buff,0,data);
		bout.flush();
	}
	bout.close();
	fin.close();
	
	
%>    