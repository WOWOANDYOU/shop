
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'message.jsp' starting page</title>

  </head>
  
  <body>

  <center>
  	<h3 align="center"><font style="color:red">${message }</font></h3><br>
  	<a href="${pageContext.request.contextPath }${prepath}">返 回</a>
  </center>

  </body>
</html>
