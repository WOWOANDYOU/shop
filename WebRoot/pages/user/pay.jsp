<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单支付</title>
    
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/index.css">
  </head>
  
  <body>
  	<div id="order_pay">
  		<div id="order_pay_up">
  			<h3><font style="color:#ff8000">订单支付</font></h3>
  		</div>
  		<div id="order_pay_down">
  			 <form action="${pageContext.request.contextPath }/servlet/PayRequestServlet" method="post">
	      		<table width="60%" align="center">
	      		<tr>  <!-- order_pay  支付的 order_pay  存在session 里边 -->
	      			<th>订单编号</th><td>${order_pay.order_id }</td>
	      		</tr>
	      		<tr>
	      			<th>订单总价</th><td>${order_pay.price }(￥元)</td>
	      		</tr>
	      		<tr>
	      			<th>商品数量</th><td>${order_pay.quantity }</td>
	      		</tr>
				<input type="hidden" name="orderid" value="${order.order_id }">
	    		<input type="hidden" name="money" value="0.01">  <!--  测试用 只能是 小额 -->
				<tr><td><br/></td></tr>
				<tr>
					<th>请您选择在线支付银行</th>
				</tr>
				<tr>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBCHINA-NET">招商银行</td>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="ICBC-NET">工商银行</td>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="ABC-NET">农业银行</td>
			
				</tr>
				<tr>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBC-NET">中国民生银行总行</td>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="BOCO-NET">交通银行</td>
				  <td class="bank_id"><INPUT TYPE="radio" NAME="pd_FrpId" value="CCB-NET">建设银行 </td>
				</tr>
				
				<tr><td><br/></td></tr>
				<tr>
				  <td><INPUT TYPE="submit" value="去支付"></td>  <td><INPUT TYPE="button" value="取消支付"></td>
				</tr>
	     	</table>
   		</form>
    </form>
  		</div>
  	</div>
   
  </body>
</html>