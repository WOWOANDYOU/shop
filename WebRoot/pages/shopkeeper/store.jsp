<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp" %>
	<!-- 还没有在主页面 展示 商品 
		店主登录进店铺后 先查到自己店铺 的所有商品后 在转到 该页面
		顾客 搜店铺 或者 点击 该店铺的某一个商品进入 店铺 前 也是要在servlet 中 查到 该店铺的所有商品 然后 做展示  
		只不过 店主能对商品进行编辑 而 顾客却不能
		
		暂且 先把所有的 商品信息 存在一个 list  goodlist  里边 然后展现
		展示区 每四个 商品一行
		
		在前台页面中 顾客点击中 该店的商品 跳到 商品具体信息展示页面 点击进入店铺 那么就跳到 一个servlet(或者 店家 点击 进入我的店铺 同样先跳到 一个servlet中)
		在这个servlet 中 先检索出所有商品  由于 商品 有 食物 衣服 书籍 三类 所以 用 三个list 分类展示 到店铺首页
	-->
		<div id="show_goods_div_big">
			<%-- <c:forEach var="good" items="goodlist" varStatus="status">
				<div class="show_goods_div_in"></div>
				<c:if test="${status%4==0 }">
					<br>
				</c:if>
			</c:forEach> --%>
			
			<!-- <ul>
				
			</ul> -->
		
			<div id="show_goods_div">
				<c:forEach var="good" items="${goodlist }">
					<div class="show_goods_div_in">
						<div class="good_img"></div>
						<div class="good_descrition"></div>
						<div class="good_price_big">
							<div class="good_price"></div>
							<div class="good_manage">
								<div class="good_delete"></div>
								<div class="good_modify"></div>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- <div class="show_goods_div_in"></div>
				<div class="show_goods_div_in"></div>
				<div class="show_goods_div_in"></div> -->
			</div>
			
		</div>
				
   </div> <!--  </div>和 在 store_nav.jsp 的container div匹配 -->
  </body>
</html>
