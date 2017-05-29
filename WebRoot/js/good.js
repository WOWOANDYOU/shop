var move=document.getElementById("move");
var main=document.getElementById("main");
var bigimg=document.getElementById("bigimg");
var img=new Image();
img.src="https://gd4.alicdn.com/imgextra/i4/888153106/TB2ro9opC0jpuFjy0FlXXc0bpXa_!!888153106.jpg_400x400.jpg";
var imgWidth=400;
var imgHeight=400;
var smallwh=imgWidth>imgHeight?imgHeight:imgWidth;// 取宽和高中小的那个
main.style.backgroundImage="url("+img.src+")";
bigimg.style.backgroundImage="url("+img.src+")";


move.onmousemove=test;// 鼠标移动事件

main.onmouseover=function(){// 鼠标移入事件
move.style.display='block';
bigimg.style.width=((move.offsetWidth)*(smallwh/main.offsetWidth))+'px';
bigimg.style.height=((move.offsetHeight)*(smallwh/main.offsetHeight))+'px';
bigimg.style.display='block';
bigimg.style.float='left';
test(event);
}
function test(e){
var left=e.clientX-move.offsetWidth/2-main.offsetLeft;// move与main的左距离
var top=e.clientY-move.offsetHeight/2-main.offsetTop+document.body.scrollTop;
if(left<0){left=0;}// 左边界
if(top<0){top=0;}// 上边界
if(e.clientX+move.offsetWidth/2-main.offsetLeft>main.offsetWidth){left=main.offsetWidth-move.offsetWidth;}// 右边界
if(e.clientY+move.offsetHeight/2-main.offsetTop+document.body.scrollTop>main.offsetHeight){top=main.offsetHeight-move.offsetHeight}// 下边界
move.style.left=left+'px';
move.style.top=top+'px';
bigimg.style.backgroundPosition=(-left*smallwh/main.offsetWidth)+'px'+' '+(-top*smallwh/main.offsetHeight)+'px';
}

main.onmouseout=function(){// 鼠标移出事件
move.style.display='none';
bigimg.style.display='none';
}
function color_selected(str){
	var color=document.getElementById("Goods_good_type_c_color"+str);
	color.click();
}
function version_selected(str){
	var version=document.getElementById("Goods_good_type_v_version"+str);
	version.click();
}
function img_change(str1,str2){
	document.getElementById("Goods_good_i_cimg_img").src=str1;
	for(var id=0;id<5;id++){
		if(id!=str2){
			document.getElementById("Goods_good_simg"+id).className="Goods_good_simg";
		}else{
			document.getElementById("Goods_good_simg"+str2).className="Goods_good_simg_selected";
		}
	}
}
function checkit(){
	if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
	if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
	event.returnValue=false;
}
function add_num(){
	var num=document.getElementById("Goods_good_type_num_text");
	num.value=num.value*1+1;//类型默认字符串，必须*1转换为数值？
}
function dec_num(){
	var t=document.getElementById("Goods_good_type_num_text");
	if(t.value*1>1){
	t.value-=1;
	}
}
function checknum(){
	var tt=document.getElementById("Goods_good_type_num_text");
	if(tt.value==null||tt.value==""){
		tt.value+=1;
	}
}
function intoStore(){
	document.getElementById("Goods_shop_s_storename").click();
}