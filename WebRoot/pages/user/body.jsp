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
<base href="<%=basePath%>">
<title>My JSP 'body.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/body.js">
	
</script>
</head>

<body>
	<div class="body">
		<div class="body_type">
			<form id="body_type_form" action="servlet/Partial_servelet"
				method="post">
				<table>
					<td><input id="body_type_selected" class="body_type_selected"
						type="text" name="body_type_selected" /></td>
					<c:choose>
						<c:when test="${empty sessionScope.body_type_b1}">
							<td><input id="body_type_b1" class="body_type_b1"
								type="button" onclick="type_change1()" value="衣    服"></td>
							<td><input id="body_type_b2" class="body_type_b2"
								type="button" onclick="type_change2()" value="书    本"></td>
							<td><input id="body_type_b3" class="body_type_b3"
								type="button" onclick="type_change3()" value="食    物"></td>
						</c:when>
						<c:otherwise>
							<td><input id="body_type_b1"
								class="${sessionScope.body_type_b1}" type="button"
								onclick="type_change1()" value="衣    服"></td>
							<td><input id="body_type_b2"
								class="${sessionScope.body_type_b2}" type="button"
								onclick="type_change2()" value="书    本"></td>
							<td><input id="body_type_b3"
								class="${sessionScope.body_type_b3}" type="button"
								onclick="type_change3()" value="食    物"></td>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
		</div>
		<div class="body_good">

			<c:if test="${sessionScope.body_list_c_flag}">
				<div class="body_good_more">
					<a href="servlet/Type_Show_servlet?type='Cloth'">更多</a>
				</div>
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="c" items="${sessionScope.body_list_c}" begin="0" end="7">
							<div class="body_good_total_c">
									<div>
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?cloth_id=${c.cloth_id}"
											target="_blank"> <img class="body_good_total_c_img" alt="商品图片" src="${pageContext.request.contextPath }/images/${c.images }">
										</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:400;width:190px;height:10px;">
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?cloth_id=${c.cloth_id}"
											target="_blank">${c.price}元</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:200;float:left;width:110px;height:190px;text-align:left">
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?cloth_id=${c.cloth_id}"
											target="_blank">${c.description}</a>
									</div>
							</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${sessionScope.body_list_b_flag}">
				<div class="body_good_more">
					<a href="servlet/Type_Show_servlet?type='Book'">更多</a>
				</div>
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="b" items="${sessionScope.body_list_b}" begin="0" end="7">
							<div class="body_good_total_b">
									<div>
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?book_id=${b.book_id}"
											target="_blank"> <img class="body_good_total_b_img" alt="商品图片" src="${pageContext.request.contextPath }/images/${b.images }">
										</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:400;width:190px;height:10px">
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?book_id=${b.book_id}"
											target="_blank">${b.price}元</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:200;float:left;width:110px;height:190px;text-align:left">
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?book_id=${b.book_id}"
											target="_blank">${b.description}</a>
									</div>
							</div>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${sessionScope.body_list_f_flag}">
				<div class="body_good_more">
					<a href="servlet/Type_Show_servlet?type='Food'">更多</a>
				</div>
				<br>
				<br>
				<br>
				<div class="body_good_total">
					<c:forEach var="f" items="${sessionScope.body_list_f}" begin="0" end="7"> 
							<div class="body_good_total_f" style="display:inline">
									<div>
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?food_id=${f.food_id}"
											target="_blank"> <img class="body_good_total_f_img" alt="商品图片" src="${pageContext.request.contextPath }/images/${f.images }">
										</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:400;width:190px;height:10px">
										<a
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?food_id=${f.food_id}"
											target="_blank">${f.price}元</a>
									</div>
									<div style="font-size:20;font-family:宋体;weight:200;float:left;width:110px;height:190px;text-align:left">
										<a style="color:black;"
											href="${pageContext.request.contextPath }/pages/user/Goods.jsp?food_id=${f.food_id}"
											target="_blank">${f.description}</a>
									</div>
							</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
