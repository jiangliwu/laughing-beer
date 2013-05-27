function GenPullUrl(room_id) {
	return "game_process?id=" + room_id + "&commandType=get" + "&cache="
			+ new Date();
}

function genPushUrl(room_id, sendCount, bookCount) {
	return "game_process?id=" + room_id + "&commandType=post&sendCount="
			+ sendCount + "&bookCount=" + bookCount + "&cache=" + new Date();
}

function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
