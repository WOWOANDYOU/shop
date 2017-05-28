var move=document.getElementById("move");
var main=document.getElementById("main");
var bigimg=document.getElementById("bigimg");
var img=new Image();
img.src="https://gd4.alicdn.com/imgextra/i4/888153106/TB2ro9opC0jpuFjy0FlXXc0bpXa_!!888153106.jpg_400x400.jpg";
var imgWidth=400;
var imgHeight=400;
var smallwh=imgWidth>imgHeight?imgHeight:imgWidth;//取宽和高中小的那个
main.style.backgroundImage="url("+img.src+")";
bigimg.style.backgroundImage="url("+img.src+")";


move.onmousemove=test;//鼠标移动事件

main.onmouseover=function(){//鼠标移入事件
move.style.display='block';
bigimg.style.width=((move.offsetWidth)*(smallwh/main.offsetWidth))+'px';
bigimg.style.height=((move.offsetHeight)*(smallwh/main.offsetHeight))+'px';
bigimg.style.display='block';
bigimg.style.float='left';
test(event);
}
function test(e){
var left=e.clientX-move.offsetWidth/2-main.offsetLeft;//move与main的左距离
var top=e.clientY-move.offsetHeight/2-main.offsetTop+document.body.scrollTop;
if(left<0){left=0;}//左边界
if(top<0){top=0;}//上边界
if(e.clientX+move.offsetWidth/2-main.offsetLeft>main.offsetWidth){left=main.offsetWidth-move.offsetWidth;}//右边界
if(e.clientY+move.offsetHeight/2-main.offsetTop+document.body.scrollTop>main.offsetHeight){top=main.offsetHeight-move.offsetHeight}//下边界
move.style.left=left+'px';
move.style.top=top+'px';
bigimg.style.backgroundPosition=(-left*smallwh/main.offsetWidth)+'px'+' '+(-top*smallwh/main.offsetHeight)+'px';
}

main.onmouseout=function(){//鼠标移出事件 
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