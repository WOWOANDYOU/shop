<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/public/CSS/index.css">
</head>

<body>
	<div class="header">
		<ul class="header_ul">
			<li class="header_left"><c:choose>
					<c:when
						test="${empty sessionScope.login_result||sessionScope.login_result=='false'}">
						<div class="header_left_browser">
							<a class="header_left_browser_a" href="${pageContext.request.contextPath }/pages/user/login.jsp" target="_top">亲，请登录</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header_left_user">
							<a class="header_left_user_a"
								href="${pageContext.request.contextPath}/pages/user/UserInfo.jsp"
								target="_top">${sessionScope.nickname}</a>
						</div>
					</c:otherwise>
				</c:choose>
			<li class="header_right">
				<div class="header_right_order" style="display:inline">
					<a class="header_right_order_a"
						href="${pageContext.request.contextPath}/pages/user/Order.jsp?user_id=${user_id}"
						target="_top"> 我的订单</a>
				</div>
				<div class="header_right_merchant" style="display:inline">
					<a class="header_right_merchant_a"
						href="${pageContext.request.contextPath}/pages/shopkeeper/merchant.jsp?user_id=${user_id}"
						target="_top"> 卖家中心</a>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>
