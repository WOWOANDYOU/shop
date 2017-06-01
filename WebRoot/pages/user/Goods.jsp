<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



<html>
  <head>
   
    <title>My JSP 'index.jsp' starting page</title>
	
	
  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="${pageContext.request.contextPath }/pages/login.jsp">用户登录</a>
    <a href="${pageContext.request.contextPath }/pages/store_register.jsp">店铺注册</a>
    <a href="${pageContext.request.contextPath }/pages/information.jsp">个人资料</a>
    <a href="${pageContext.request.contextPath }/servlet/Cancel_Login">注销账号</a>
    <a href="${pageContext.request.contextPath }/servlet/MyStoreServlet">我的店铺</a>

  </body>
</html>
