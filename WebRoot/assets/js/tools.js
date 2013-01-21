function checkUsername(obj, obj_input_id) {
	var value = obj.value;

	if (value == "") {
		document.getElementById(obj_input_id).className = "control-group error";
		document.getElementById("username_hint").style.display = "";
		$("#username_hint").html("请输入合法的用户名");
	} else {
		document.getElementById(obj_input_id).className = "control-group success";
		document.getElementById("username_hint").style.display = "none";
	}
}

function checkPassword1(obj) {
	var value = obj.value;

	if (value == "") {
		document.getElementById("password1_input").className = "control-group error";
		document.getElementById("password1_hint").style.display = "";
	} else {
		document.getElementById("password1_input").className = "control-group success";
		document.getElementById("password1_hint").style.display = "none";
	}
}

function checkPassword2(obj) {
	var value1 = document.getElementById("password").value;
	var value2 = obj.value;
	if (value1 != value2) {
		document.getElementById("password2_input").className = "control-group error";
		document.getElementById("password2_hint").style.display = "";
	} else {
		document.getElementById("password2_input").className = "control-group success";
		document.getElementById("password2_hint").style.display = "none";
	}

}
