var EVERY_TURNS_TIME = 0;

function loadConfig() {

	var linkAjax = "dojo/room/_room_turns_time.jsp?id=" + getParameter("id");
	$.ajax({
		type : "GET",
		url : linkAjax,
		async : false,
		success : function(data) {
			var value = data.split(",")[1];
			EVERY_TURNS_TIME = parseInt(value);
			cc.log("every turns time = " + EVERY_TURNS_TIME);
		}
	});
	return true;
}
