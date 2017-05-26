/**
 * 
 */
function type_change1() {
	var b1=document.getElementById("body_type_b1");
	var b2=document.getElementById("body_type_b2");
	var b3=document.getElementById("body_type_b3");
	b1.className="body_type_b1_action";
	b2.className="body_type_b2";
	b3.className="body_type_b3";
	document.getElementById("body_type_selected").value = "Cloth";
	document.getElementById("body_type_form").submit();
}
function type_change2() {
	var b1=document.getElementById("body_type_b1");
	var b2=document.getElementById("body_type_b2");
	var b3=document.getElementById("body_type_b3");
	b1.className="body_type_b1";
	b2.className="body_type_b2_action";
	b3.className="body_type_b3";
	document.getElementById("body_type_selected").value = "Book";
	document.getElementById("body_type_form").submit();
}
function type_change3() {
	var b1=document.getElementById("body_type_b1");
	var b2=document.getElementById("body_type_b2");
	var b3=document.getElementById("body_type_b3");
	b1.className="body_type_b1";
	b2.className="body_type_b2";
	b3.className="body_type_b3_action";
	document.getElementById("body_type_selected").value = "Food";
	document.getElementById("body_type_form").submit();
}
