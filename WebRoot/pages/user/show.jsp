<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'show.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
</head>

<body>
<c:forEach items="${sessionScope.list_c }" var="c">
	<div>
		<ul>
			<li>
				<div>
					<a href="" target="_blank"> <img alt="" src="${c.images }">
					</a>
				</div>

				<div>
					<a href="" target="_blank"></a>
				</div>
				<div>
					<a href="" target="_blank"></a>
				</div>
			</li>
		</ul>
	</div>
</c:forEach>
</body>
</html>
