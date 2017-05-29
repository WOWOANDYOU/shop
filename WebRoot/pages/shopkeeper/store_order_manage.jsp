<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="store_nav.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="add_store_big">
	<div id="add_store_in">
		<div id="add_store_in_in_2">
		<div id="box"> 
			<form action="${pageContext.request.contextPath }/servlet/InStoreSearchServlet?store_id=${store.store_id}" id="order_form">
			<input type="hidden" id="order_input_1" name="order_type">
				<div id="tab">
		            <ul id="ul">
		                <li class="list"><input onclick="allorder()" type="button" value="所有订单" class="order_button"></li>
		                <li><input onclick="beforeorder()" type="button" value="未处理订单" class="order_button"></li>
		                <li><input onclick="finishorder()" type="button" value="已处理订单" class="order_button"></li>
		            </ul>
		      	</div>
	      	</form>
	      	 <div id="hide">
	               <div>
	               		<table align="left">
	               			<tr>
	               				<th>订单编号</th><th>商品编号</th><th>顾客账号</th><th>购买数量</th><th>下单时间</th><th>下单状态</th><th>订单总额</th><th>订单管理</th>
	               			</tr>
	               		</table>
	               </div>
          	</div>
          </div>
		</div>
	</div>
</div>
</div>
</body>
</html>