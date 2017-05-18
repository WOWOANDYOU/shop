<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/store.css">

  </head>
  <body>
  	<div id="container">
  		<div id="store_nav_big">
	  		<div id="store_nav">
	  			<div id="store_nav_div">
	  				<ul id="nav_ul_1">
	  					<li>
	  						<div>
	  							<c:choose>
	  								<c:when test="${empty user}">
			  							<a href="跳转到登录页面">亲，请登录</a>
			  							<a href="注册页面">免费注册</a>
			  						</c:when>
			  						<c:otherwise>
		  								<a href="跳转到用户信息页面">${userLogin.nickname}</a>
		  							</c:otherwise>
	  							</c:choose>
	  						</div>
	  					</li>
	  				</ul>
	  				
	  				<ul id="nav_ul_2">
	  					<li>
	  						<div><a href="${pageContext.request.contextPath }/index.jsp">商城首页</a></div>
	  					</li>
						<li>
							<div class="li_down">
								<c:choose>
									<c:when test="${empty user}">
										<a href="${pageContext.request.contextPath }/pages/login.jsp">我的小号</a>
									</c:when>
									<c:otherwise>
											<a href="${pageContext.request.contextPath }/pages/showOrder.jsp">我的小号</a>
									</c:otherwise>
								</c:choose>
								<ul>
									<li class="li_hover">
										<c:choose>
											<c:when test="${empty user}">
												<a href="${pageContext.request.contextPath }/pages/login.jsp">已买宝贝</a>
											</c:when>
											<c:otherwise>
													<a href="${pageContext.request.contextPath }/pages/showOrder.jsp">已买宝贝</a>
											</c:otherwise>
										</c:choose>
									</li>
									
								</ul>
							</div>
						</li>
						<li>
	  						<div class="li_down">
	  							<c:choose>
									<c:when test="${empty user}">
										<a href="${pageContext.request.contextPath }/pages/login.jsp">购物车</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath }/pages/showCartGood.jsp">购物车</a>
									</c:otherwise>
								</c:choose>
	  						</div>
	  					</li>
						<li>
							<div id="store_div">
								<c:choose>
									<c:when test="${empty user}">
									<a href="${pageContext.request.contextPath }/pages/login.jsp">卖家中心</a>
									</c:when> 
									<c:when test="${not empty user && user.role == 1}">  <!-- 1表示 顾客 还没有开店 -->
										<a href="${pageContext.request.contextPath }/pages/Builestore.jsp">卖家中心</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.request.contextPath }/pages/store.jsp">卖家中心</a>
									</c:otherwise>
								</c:choose>
								
								<div id="store_nav_down">
									<c:choose>
											<c:when test="${empty user}">
												<a href="${pageContext.request.contextPath }/pages/login.jsp">免费开店</a><br>
											</c:when>
											<c:when test="${not empty user && user.role == 2}">  <!-- 判断其是否为店家 2表示 为店家 那么进入店铺 -->
												<a href="${pageContext.request.contextPath }/pages/store.jsp">免费开店</a>
											</c:when>
											<c:otherwise>
													<a href="${pageContext.request.contextPath }/pages/Builestore.jsp">免费开店</a>
											</c:otherwise>
										</c:choose>
										
										<c:choose>
											<c:when test="${empty user}">
												<a href="${pageContext.request.contextPath }/pages/login.jsp">已卖货品</a>
											</c:when>
											<c:when test="${not empty user && user.role == 2}">  <!-- 判断其是否为店家 2表示 为店家 那么进入店铺 -->
												<a href="${pageContext.request.contextPath }/pages/store.jsp">已卖货品</a>
											</c:when>
											<c:otherwise>
													<a href="${pageContext.request.contextPath }/pages/Builestore.jsp">已卖货品</a>
											</c:otherwise>
										</c:choose>
								</div>
							</div>
						</li>
	  				</ul>
	  			</div>
	  		</div>
	  		
	  		<div id="mid_find">
	  			<div id="in_mid_find">
	  				<div id="mid_up">
	  					<div id="mid_up_left">
	  						<a href="${pageContext.request.contextPath }/index.jsp"><img alt="logo" src="${pageContext.request.contextPath }/images/logo.jpg" width="105px" height="45px"/></a>
	  						<a href="#" class="a_store_class">&nbsp;&nbsp;<b>店铺</b></a>
	  					</div>
	  					<div id="mid_up_right_search">
	  						<div></div>
	  					</div>
	  				</div>
	  				<div id="mid_down">
	  					<p class="p_class">
	  						<span class="left_span">
	  							<span class="left_span"></span>
	  							<span class="left_span">店铺：</span>
	  							<span class="left_span">${user }</span>
	  							<span class="left_span">
 									<a href="${pageContext.request.contextPath }/pages/store.jsp">进入店铺</a>
	  							</span>
	  						</span>
	  						<span class="right_span"></span>
	  					</p>
	  				</div>
	  			</div>
	  		</div>
  		</div>



<%-- <c:if test="${empty user}">
 										<a href="${pageContext.request.contextPath }/pages/store.jsp">进入店铺</a>
 									</c:if>
 									<c:if test="${user.role==1 }">
 										<a href="${pageContext.request.contextPath }/pages/store.jsp">进入店铺</a>
 									</c:if>
 									<c:if test="${user.role==2 }">
 										<a href="${pageContext.request.contextPath }/pages/store.jsp">进入店铺</a>
 									</c:if>

 --%>