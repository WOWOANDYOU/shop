<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
  <head>
    
    
    <title>修改密码检验</title>
    
	
	

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/servlet/CheckChangePassword" method="post">
    <table>
    <tr><td>账号：</td><td><input type="text" name="user_id" value=${user_id }></td><td>${message }</td></tr>
			<tr>
				<td>联系电话：</td>
				<td><input type="text" name="phonenum" value="${phonenum }">
				</td>
			</tr>
			<tr>
				<td>email：</td>
				<td><input type="text" name="email" value="${email }"></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="检验"></tr>
    </table>
    </form>
  </body>
</html>
