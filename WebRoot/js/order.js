/**
 * 
 */
function state1(){
	document.getElementById("state1_t").style.display="block";
	document.getElementById("state2_t").style.display="none";
	document.getElementById("state3_t").style.display="none";
}
function state2(){
	document.getElementById("state1_t").style.display="none";
	document.getElementById("state2_t").style.display="block";
	document.getElementById("state3_t").style.display="none";
}
function state3(){
	document.getElementById("state1_t").style.display="none";
	document.getElementById("state2_t").style.display="none";
	document.getElementById("state3_t").style.display="block";
}