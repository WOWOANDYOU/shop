<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>

</head>

<body>
	<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
		<table>
		<tr><td>账号：</td><td><input type="text" name="user_id" value="${RegisterCheckBean.user_id }"></td><td>${RegisterCheckBean.errors.user_id }</td></tr>
		<tr><td>密码：</td><td><input type="password" name="password" value="${RegisterCheckBean.password }"></td><td>${RegisterCheckBean.errors.password }</td></tr>
		<tr><td>确认密码：</td><td><input type="password" name="password2" value="${RegisterCheckBean.password2 }"></td><td>${RegisterCheckBean.errors.password2 }</td></tr>
		<tr><td>联系方式：</td><td><input type="text" name="phonenum" value="${RegisterCheckBean.phonenum }"></td><td>${RegisterCheckBean.errors.phonenum }</td></tr>
		<tr><td>身份证号：</td><td><input type="text" name="cardID" value="${RegisterCheckBean.cardID }"></td><td>${RegisterCheckBean.errors.cardID }</td></tr>
		<tr><td>昵称：</td><td><input type="text" name="nickname" value="${RegisterCheckBean.nickname }"></td><td>${RegisterCheckBean.errors.nickname}</td></tr>
		<tr><td>邮箱：</td><td><input type="text" name="email" value="${RegisterCheckBean.email }"></td><td>${RegisterCheckBean.errors.email }</td></tr>
		<tr><td>地址：</td><td><input type="text" name="address" value="${RegisterCheckBean.address }"></td><td>${RegisterCheckBean.errors.address }</td></tr>
		<tr><td>照片：</td><td><input type="text" name="image" value="${RegisterCheckBean.image }"></td><td>${RegisterCheckBean.errors.image}</td></tr>
		<tr><td><input type="submit" value="注册"></td><td><input type="reset" value="重置"></td></tr>
		</table>
	</form>
</body>
</html>
