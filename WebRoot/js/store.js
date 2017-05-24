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
	/*var goodfilename = document.getElementById("images");*/
/*	var goodfilename = document.getElementsByName("images");*/
	/*elementList.*/
	/*goodfilename.gete*/
	/*var filename = goodfilename.value;
	if(!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif') || filename.endsWith('.jpeg'))){
		alert("只能上传 jpg jpeg gif 以及 png 的图片文件");
		return false;
	}
	return true;*/
	var goodfilename = document.getElementsByName("images");
	var filename;
	for(var i=0;i<goodfilename.length;i++){
		filename = goodfilename[i].value;
		if(!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif'))){
			alert("请上传图片(只能上传 jpg,gif,以及 png的图片文件)");
			return false;
		}
	}
	var submit = document.getElementById("submit");
	submit.disable = "disable";
	return true;
}

function fileadd(){
	var filediv = document.getElementById("addfile"); //拿到那个div
	var div2 = document.createElement("div");
	//生成input button等元素
	var input = document.createElement("input");
	input.type = "file";
	input.name = "images";
	input.id = "images";
	var btn = document.createElement("input");
	btn.type = "button";
	btn.value = "删除";
	
	div2.appendChild(input);
	div2.appendChild(btn);
	
	filediv.appendChild(div2);
	btn.onclick = function del(){
		this.parentNode.parentNode.removeChild(this.parentNode);
	}
}