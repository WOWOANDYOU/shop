<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/CSS/index.css">
  </head>
  <frameset rows="5%,95%" frameborder="no">
	<frame src="header.jsp">
	<frame src="body.jsp">
	</frameset>
  <body>
  </body>
</html>
