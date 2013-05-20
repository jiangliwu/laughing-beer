function GenGetUrl(room_id) {
	return "game_process?id=" + room_id + "&commandType=get";
}

function genPostUrl(room_id, sendCount = 0, bookCount = 0) {
	return "game_process?id=" + room_id + "&commandType=post&sendCount=" + sendCount + "&bookCount=" + bookCount;
}


function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]);
	return null;
}

