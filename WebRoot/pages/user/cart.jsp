<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/cart.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/cart.js">
</script> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'cart.jsp' starting page</title>

  </head>
  <body>
  <iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
  </body>
</html>
