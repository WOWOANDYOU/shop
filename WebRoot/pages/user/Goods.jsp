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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/good.js"></script>
</head>

<body>
	<iframe src="${pageContext.request.contextPath }/pages/user/header.jsp"
		scrolling="no" style="border:none;width:100%;height:18%;"> </iframe>
	<%-- <c:if test="${not empty sessionScope.Cloth }">
	${sessionScope.Cloth.clothname }
	<br>
	${sessionScope.Cloth.price }元
	</c:if> --%>
	<div class="Goods">
		<div class="Goods_good">
			<div class="Goods_good_i">
				<div class="Goods_good_i_cimg">
					<div class="Goods_good_move"></div>
				</div>
				<div class="Goods_good_i_bimg"></div>
				<c:forTokens items="${Cloth.images }" var="iv" delims=","
					varStatus="ivs" begin="0" end="4">
					<div class="Goods_good_simg${ivs.count }"
						style="position:relative;left:5px;margin:5px;float:left;width:74px;height:71px;border:1px solid red">
						<img alt="商品小图"
							src="${pageContext.request.contextPath }/images/${iv}"
							style="width:67px;height:67px;margin:auto;">
					</div>
				</c:forTokens>
			</div>
			<div class="Goods_good_type">
				<div class="Goods_good_type_title">${Cloth.description }</div>
				<div class="Goods_good_type_price">￥${Cloth.price }</div>
				<form action="购买servlet" method="post">
					<div class="Goods_good_type_c">
						<c:forTokens items="${Cloth.color }" delims="," var="cv"
							varStatus="cvs">
							<div class="Goods_good_type_c_color" onclick="color_selected(${cvs.count})">
							<input type="radio" id="Goods_good_type_c_color${cvs.count}" name="Goods_good_type_c_color" value="${cv}">${cv}
								</div>
						</c:forTokens>
					</div>
					<div class="Goods_good_type_v">
					<input id="Goods_good_type_v_selected" type="text" value="${Cloth.version }" style="display:none">
						<c:forTokens items="${Cloth.version }" delims="," var="vv"
							varStatus="vvs">
							<div class="Goods_good_type_v_version" onclick="version_selected(${vvs.count})">
								<input type="radio" id="Goods_good_type_v_version${vvs.count}" name="Goods_good_type_v_version" value="${vv}">${vv}
								</div>
						</c:forTokens>
					</div>
					<div class="Goods_good_type_num">
						<input class="Goods_good_type_num_b1" type="button" value="-"
							onclick=""> <input class="Goods_good_type_num_text"
							type="text" value="1"> <input
							class="Goods_good_type_num_b2" type="button" value="+">
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
