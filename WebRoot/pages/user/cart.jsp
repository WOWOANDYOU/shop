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
<title>My JSP 'cart.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/cart.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/cart.js">
</script>
<script type="text/javascript">
function cart_ajax(obj,cart_id)
{
var xmlhttp;
var num=obj.value;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
/*  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    }*/
  }
xmlhttp.open("GET","${pageContext.request.contextPath}/cartupdate_servlet?num="+num+"&cart_id="+cart_id,true);
xmlhttp.send();
}
</script>
</head>
<body>
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
	<div class="cart">
		<div class="cart_allselect" style="width:1300px;border:3px solid #c0c0c0">
			<input type="checkbox">全选
		</div>
		<c:forEach items="${cartlist }" var="map">
		<div class="cart_single" style="width:1300px;height:100px;border:1px solid red;margin-top:8px;">
			<div class="cart_single_checkbox" style="float:left;width:100px;height:100px;border:1px solid red">
				<input type="checkbox" name="" style="float:left;margin-left:30px;margin-top:30px;">
			</div>
			<c:forTokens items="${map.images}" delims="," var="image" varStatus="mvs" begin="0" end="0">
			<div class="cart_single_img" style="float:left;width:150px;height:100px;border:1px solid green">
				<img alt="商品图片" src="${pageContext.request.contextPath }/images/${image}" style="width:150px;height:100px;">
			</div>
			</c:forTokens>
			<div class="cart_single_version" style="float:left;width:200px;height:100px;border:1px solid green">
			<div style="width:200px;height:20px;margin-top:50px;text-align:center;">
			${map.version }
			</div>
			</div>
			<div class="cart_single_num" style="float:left;width:200px;height:100px;border:1px solid black">
				<input class="cart_single_num_b1" type="button" value="-"
					onclick="dec_num(${mvs.count })"> 
				<input class="cart_single_num_text" id="cart_single_num_text${mvs.count }"
					name="cart_single_num_text" type="text" value="${map.quantity }"
					onkeydown="checkit()" onblur="checknum()" onchange="cart_ajax(this,${map.cart_id})"> 
				<input class="cart_single_num_b2" type="button" value="+"
					onclick="add_num(${mvs.count })">
			</div>
			<div class="cart_single_delete">
			<a id="cart_delete${map.cart_id}" href="${pageContext.request.contextPath }/cart_delete_servlet?cart_id=${map.cart_id}" style="display:none"></a>
			<div onclick="deleteit(${map.cart_id})" style="cursor:pointer;font-size:18px;margin:10px;text-align:right;">删除</div>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>
