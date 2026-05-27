<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <style>
        *{box-sizing: border-box;}
        body{
            margin:0;
            padding:0;
        }
        
        input{
            height:100%;
            outline:none;
            border-radius: 0;
            border : 1px solid gray;
            padding-left:10px;    
        }
        
        input[type="text"],
        input[type="password"]
        {
            width:100%;
        }
        select {
            height:100%;
            outline:none;
            border-radius: 0;
            border : 1px solid gray;
            width:100%;
        }

        a{
            text-decoration: none;
            color:black;
        }

        .btn{
            min-width:80px;
            text-align: center;
            border:1px solid lightgray;
            height:100%;
            line-height:35px;
            font-size:0.8rem;
            opacity: 0.8;
        }
        .btn:hover{
            opacity: 1;
        }

        .btn-submit{
            width:100%;
            border:0;
            background-color: royalblue;
            color : white;
            font-size:1.1rem;
            height:40px;
        }

        form {
            width : 400px;
            border : 1px solid;
            margin : 50px auto;
            padding: 10px;
        }
        form>.row{
            margin-bottom: 10px;
            display:flex;
            justify-content: left;
            align-items: center;
            gap:5px;
            height:35px;
        }
        form h2{
            display:block;
            width : 100%;
            height:50px;
            text-align: center;
            font-size : 1.7rem;
            margin-top : 10px;
            margin-bottom:20px;
        }

        form>.row>label{
            display:block;
            min-width:100px;
            height:100%;
            line-height:35px;
        }
    </style>

</head>

<body>
    <!-- 
        form : 사용자로부터 특정정보를 받아 서버로 전달하는데 사용되는 태그
        action Attribute : 전달받는 서버 URI
        method Attribute : 서버로 요청하는 방식
            - GET        : 사용자 요청 정보를 Query String으로 전달(Default)
            - POST       : 사용자 요청 정보를 Request body(Payload) 로 전달
            - PUT        :
            - PATCH      : 
            - DELETE     : 
    -->

    <form action="${pageContext.request.contextPath}/Ch05/02/auth/Login.jsp" method="post">
        <div class="">
            <h2>로그인</h2>
        </div>
        <div class="row">
            <label>아이디</label>
            <input  name="userid"   type="text"  />
        </div>
        <div class="row">
            <label>비밀번호</label>
            <input name="password" type="password" />
        </div>
 	        <div class="row">
            <input id="email-recv" name="id_saved" type="checkbox" /> 
            <label for="email-recv">ID 저장</label>
        </div>
        <div class="row">
            <input id="sms-recv" name="pw_saved" type="checkbox" /> 
            <label for="sms-recv">PW 저장</label>
        </div>
        
        <div class="row">
            <input class="btn btn-submit"  type="submit" value="로그인" />
        </div>
        
        <hr/>
        	
	    <span style="font-size:.7rem;color:red;">
	    	 ${message}
	    </span>
	    
    </form>
    

	<%
		session.removeAttribute("isAuth");
		session.removeAttribute("message");
	%>
	
</body>

</html>



