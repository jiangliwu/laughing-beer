var Location = cc.Layer.extend({
	_roomId:null,
	_showLabel:null,
	_showString:null,
	init: function() {
		this._super();
		var screenSize = cc.Director.getInstance().getWinSize();

		this._showString = "您所在的房间号码为 : "
		this._showLabel = cc.LabelTTF.create(this._showString, "宋体", 12);
		//this._showLabel.setColor(new cc.Color3B(255,0,0));
		this._showLabel.setPosition(cc.p(100,screenSize.height - 20));
		
		this.addChild(this._showLabel);
		
		return true;
	},


	// need ajax
	updateString: function() {
		this._roomId = getParameter("id");
		var identify = "";
		var linkAjax = "dojo/room/_room_get_indentify.jsp?id=" + getParameter("id");
        $.ajax({
            type: "GET",
            url: linkAjax,
            async:false,		
            success: function(data) {
            	identify = data.split(",")[1];
                cc.log("your identify is = " + identify);
            }
        });
        
		this._showLabel.setString(this._showString + this._roomId + " - " + identify);
	}

});
 

Location.create = function() {
	var ret = new Location();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}