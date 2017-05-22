<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'header2.jsp' starting page</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/header2.js"></script>
</head>

<body>
	<div class="header2">
		<ul>
			<li class="header2_left"><a
				href="${pageContext.request.contextPath }/pages/user/index.jsp"
				target="_top"> <img alt="商城图标"
					src="${pageContext.request.contextPath}/images/taobao.jpg"
					style="width:145px;height:55px;text-align:center;">
			</a></li>
			<li>
				<div class="header2_center">
					<form id="select_form" action="servlet/FuzzySelect_servlet"
						target="view_body" method="post">
						<div class="header2_center_top">
							<div class="header2_center_top_Goods_selected"
								id="header2_center_top_Goods" onclick="Goodselect()"><input id="header2_center_top_Goods_radio" name="header2_center_top_type_radio" style="display: none" type="radio" checked>商品</div>
							<div class="header2_center_top_Shop" id="header2_center_top_Shop"
								onclick="Shopselect()"><input id="header2_center_top_Shop_radio" name="header2_center_top_type_radio" style="display: none" type="radio">店铺</div>
						</div>
						<div class="header2_center_buttom">
							<fieldset
								style="width:675;height:35;background-color:#ff7624;border:0px;">
								<div>
									<input class="header2_center_select" id="select_input"
										name="select" type="text">
								</div>
								<div>
									<input class="header2_center_selectbutton" type="submit"
										 value="搜 索">
								</div>
							</fieldset>
						</div>
					</form>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>
