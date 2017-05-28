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
<title>My JSP 'Goods.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/good.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/good.js"></script>
</head>

<body>
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:20%;"> </iframe>
	<%-- <c:if test="${not empty sessionScope.Cloth }">
	${sessionScope.Cloth.clothname }
	<br>
	${sessionScope.Cloth.price }元
	</c:if> --%>
	<div class="Goods">
		<div class="Goods_good">
			<div class="Goods_good_i">
				<div class="Goods_good_i_cimg">
				<c:forTokens items="${Cloth.images }" var="icv" delims=","
					varStatus="icvs" begin="0" end="0">
				<img id="Goods_good_i_cimg_img" alt="商品中图" src="${pageContext.request.contextPath }/images/${icv}">
				</c:forTokens>
				</div>
				<div class="Goods_good_i_bimg"></div>
				<c:forTokens items="${Cloth.images }" var="isv" delims=","
					varStatus="isvs" begin="0" end="0">
					<div class="Goods_good_simg_selected" id="Goods_good_simg0">
						<img alt="商品小图${isvs.count }"
							src="${pageContext.request.contextPath }/images/${isv}"
							style="width:67px;height:67px;margin:auto;"onclick="img_change('${pageContext.request.contextPath }/images/${isv}',0)">
					</div>
				</c:forTokens>
				<c:forTokens items="${Cloth.images }" var="isv" delims=","
					varStatus="isvs" begin="1" end="4">
					<div class="Goods_good_simg" id="Goods_good_simg${isvs.count}">
						<img alt="商品小图${isvs.count }"
							src="${pageContext.request.contextPath }/images/${isv}"
							style="width:67px;height:67px;margin:auto;"onclick="img_change('${pageContext.request.contextPath }/images/${isv}','${isvs.count }')">
					</div>
				</c:forTokens>
			</div>
			<div class="Goods_good_type">
				<div class="Goods_good_type_title">${Cloth.description }</div>
				<div class="Goods_good_type_left">价格:</div><div class="Goods_good_type_price">￥${Cloth.price }</div>
				<div class="Goods_good_type_left">颜色:</div>
				<form action="购买servlet" method="post">
					<div class="Goods_good_type_c">
						<c:forTokens items="${Cloth.color }" delims="," var="cv"
							varStatus="cvs">
							<div class="Goods_good_type_c_color"
								onclick="color_selected(${cvs.count})">
								<input type="radio" id="Goods_good_type_c_color${cvs.count}"
									name="Goods_good_type_c_color" value="${cv}">${cv}
							</div>
						</c:forTokens>
					</div>
					<div class="Goods_good_type_left">套餐:</div>
					<div class="Goods_good_type_v">
						<c:forTokens items="${Cloth.version }" delims="," var="vv"
							varStatus="vvs">
							<div class="Goods_good_type_v_version"
								onclick="version_selected(${vvs.count})">
								<input type="radio" id="Goods_good_type_v_version${vvs.count}"
									name="Goods_good_type_v_version" value="${vv}">${vv}
							</div>
						</c:forTokens>
					</div>
					<div class="Goods_good_type_left">数量:</div>
					<div class="Goods_good_type_num">
						<input class="Goods_good_type_num_b1" type="button" value="-"
							onclick="dec_num()"> 
							<input class="Goods_good_type_num_text" id="Goods_good_type_num_text"
							type="text" value="1" onkeydown="checkit()"> 
							<input
							class="Goods_good_type_num_b2" type="button" value="+"
							onclick="add_num()">
					</div>
					<div class="Goods_good_type_pay">
						<input class="Goods_good_type_pay_b1" type="button" value="立即购买">
						<input class="Goods_good_type_pay_b2" type="button" value="加入购物车">
					</div>
				</form>
			</div>
		</div>
		<div class="Goods_shop" style="border:1px solid red"></div>
	</div>
</body>
</html>
