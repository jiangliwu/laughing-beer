var Location = cc.Layer.extend({
	_roomId:null,
	_showLabel:null,
	_showString:null,
	init: function() {
		this._super();
		var screenSize = cc.Director.getInstance().getWinSize();

		this._showString = "您所在的房间号码为 : " +  getParameter("id") + " - "+ USER_INDENTIFY;
		this._showLabel = cc.LabelTTF.create(this._showString,"Microsoft Yahei", 14);
		this._showLabel.setPosition(cc.p(150,screenSize.height - 50));
		
		this.addChild(this._showLabel);
		
		return true;
	},


	// need ajax
	updateString: function() {
		this._roomId = getParameter("id");
		var identify = "";
		var linkAjax = "dojo/room/_room_get_indentify.jsp?id=" + getParameter("id");
		
		var self = this;
        $.ajax({
            type: "GET",
            url: linkAjax,		
            success: function(data) {
            	identify = data.split(",")[1];
                self._showLabel.setString(self._showString + self._roomId + " - " + identify);
                cc.log("your identify is = " + identify);
            }
        });
	}

});
 

Location.create = function() {
	var ret = new Location();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}