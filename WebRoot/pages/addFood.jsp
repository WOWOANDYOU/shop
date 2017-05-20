<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="store_nav.jsp"%>

<div id="add_food_big">
	<div id="add_food_in">
		<div id="add_food_in_up">
			<div id="div_font_class">
				<font style="font-size:18px;color:#ff4400">请完善上架食品信息:</font>
			</div>
		</div>
		<div id="add_food_in_down">
			<form
				action="${pageContext.request.contextPath }/servlet/AddFoodServlet"
				method="post" onsubmit="return checkoutfilename()">
				<input type="hidden" value="${store.store_id }">
				<!-- 记住商品是属于哪家店铺的 所以添加商品前要 在session域存一个 store对象 -->
				<table border="0px">
					<tr>
						<!-- 光标离开 后触发js函数 onblur="isInput(this.value)" -->
						<th>商品名称：</th>
						<td><input type="text" name="foodname"></td>
						<td><span> <font style="color:red;">${errormap.foodname }</font>
						</span></td>
					</tr>
					<tr>
						<th>商品单价：</th>
						<td><input type="text" name="foodprice"></td>
						<td><span> <font style="color:red;">${errormap.foodprice }</font>
						</span></td>
					</tr>
					<tr>
						<th>商品库存：</th>
						<td><input type="text" name="foodtotalnum"></td>
						<td><span><font style="color:red;">${errormap.foodtotalnum }</font></span></td>
					</tr>
					<tr>
						<th>商品描述：</th>
						<td><textarea name="fooddescription" rows="5" cols="40"></textarea></td>
						<td><span><font style="color:red;">${errormap.fooddescription }</font></span></td>
					</tr>
					<tr>
						<th>商品图片：</th>
						<td><input type="file" name="foodpicture" id="foodpicture"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="添加"> <input type="reset" value="重置"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
<!-- <font style="font-size:18px;color:#ff4400">请完善上架食品信息:</font> -->
</div>
</body>
</html>
