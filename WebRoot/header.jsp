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
  
  <body>
 	<div class="header">
 	<ul class="header_ul">
 	<li class="header_left">
 		<div class="header_left_browser">
 	  		<a class="header_left_browser_a" href="servlet/login_frameCtrlservlet">亲，请登录</a>
 	 	</div>
 		<div class="header_left_user">
 			<a class="header_left_user_a" href="${pageContext.request.contextPath}/UserInfo.jsp">${sessionScope.nickname}</a>
 		</div>
 	<li class="header_right">
 		<div class="header_right_order" style="display:inline">
 		<a class="header_right_order_a" href="${pageContext.request.contextPath}/Order.jsp?user_id=${user_id}">
 		我的订单</a>
 		</div>
 		<div class="header_right_merchant" style="display:inline">
 		<a class="header_right_merchant_a" href="${pageContext.request.contextPath}/merchant.jsp?user_id=${user_id}">
 		卖家中心</a>
 		</div>
 	</li>
 	</ul>
 	</div>
  </body>
</html>
