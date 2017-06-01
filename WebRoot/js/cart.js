/**
 * 
 */
//数量输入框限制输入只能为整数
function checkit(){
	if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
	if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
	event.returnValue=false;
}
//数量增加按钮
function add_num(str){
	var num=document.getElementById("cart_single_num_text"+str);
	num.value=num.value*1+1;//类型默认字符串，必须*1转换为数值？
}
//数量减少按钮
function dec_num(str){
	var t=document.getElementById("cart_single_num_text"+str);
	if(t.value*1>1){
	t.value-=1;
	}
}
//数量输入框拾取焦点时检查，空时设为1
function checknum(){
	var tt=document.getElementById("cart_single_num_text");
	if(tt.value==null||tt.value==""){
		tt.value+=1;
	}
}
//删除购物项弹窗
function deleteit(str){
	if(confirm("确定删除该订单吗？")){
			document.getElementById("cart_delete"+str).click();
	}
}