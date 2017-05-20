function changeTitle(storename) {
	document.title = storename; /* 页面加载就改变 页面的title */
}
function isselected(){
	var myselect = document.getElementById("category2");
	var index = myselect.selectedIndex;
	var values = myselect.options[index].value;
	if(values=="0"){
		alert("请选择商品类型");
		return false;
	}
	return true;
}
function isInput(value){
	if(value==''){
		alert("12");
		var span = document.getElementById("error_name");
		span.value = "请输入食品名称";
	}
}
function checkoutfilename(){
	var foodfilename = document.getElementById("foodpicture");
	var filename = foodfilename.value;
	if(!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif') || filename.endsWith('.jpeg'))){
		alert("只能上传 jpg jpeg gif 以及 png 的图片文件");
		return false;
	}
	return true;
}