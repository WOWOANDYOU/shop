<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
  <head>
    
    
    <title>修改密码</title>
    
	
	

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/ChangePassword" method="post">
    <table>
    <tr><td>修改密码：</td><td><input type="password" name="password" value=${password }></td><td>${message }</td></tr>
    <tr><td>确认修改密码：</td><td><input type="password" name="password2" value=${password2 }></td></tr>
    <tr><td colspan="2"><input type="submit" value="提交"></tr>
			</table>
			</form>
		
  </body>
</html>
