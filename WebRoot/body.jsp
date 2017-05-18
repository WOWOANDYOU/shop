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
    <title>My JSP 'body.jsp' starting page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/public/CSS/index.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/public/JS/body.js">
	</script>
  </head>
  
  <body>
	<div class="body">
		<div class="body_type">
		<form id="body_type_form" action="servlet/Partial_servelet" method="post">
		<table>
		<input id="body_type_selected" class="body_type_selected" type="text" name="body_type_selected">
		<td><input id="body_type_b1"  class="body_type_b1" onclick="type_change1()" type="button"  value="衣    服"></td>
		<td><input id="body_type_b2"  class="body_type_b2" onclick="type_change2()" type="button"  value="书    本"></td>
		<td><input id="body_type_b3"  class="body_type_b3" onclick="type_change3()" type="button"  value="食    物"></td>
		</table>
		</form>
		<c:if test="${sessionScope.body_list_f_flag}">
		<c:forEach var="a" items="${sessionScop.body_list_f}">
		${a. }
		</c:forEach>
		</c:if>
		</div>
		<div class="body_good">
		</div>
	</div>
  </body>
</html>
