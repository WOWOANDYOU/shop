<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

  </head>
  
  <body>
 	<div class="header2">
 	<ul>
 	<li class="header2_left" >
 	<a href="body.jsp">
 	<img alt="商城图标" src="${pageContext.request.contextPath}/images/taobao.jpg" style="width:145;height:48;text-align:center;">
 	</a>
 	</li>
 	<li>
 	<form action="servlet/select_servlet" method="post">
 	<fieldset style="width:675;height:40;border:0;background-color:#ff7624;">
 	<div><input class="header2_center_select" name="select" type="text" ></div>
 	<div><input class="header2_center_selectbutton"type="submit" value="搜 索"></div>
 	</fieldset>
 	</form>
 	</li>
 	</ul>
 	</div>
  </body>
</html>
