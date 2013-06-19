var Location = cc.Layer.extend({
	_roomId:null,
	_showLabel:null,
	_showString:null,
	init: function() {
		this._super();
		var screenSize = cc.Director.getInstance().getWinSize();
		var bg = cc.Sprite.create("client/res/img/location.png");
		bg.setAnchorPoint(cc.p(0.5, 0.5));
		bg.setPosition(cc.p(-150,screenSize.height - 50));
		this.addChild(bg);
		
		this._showString = "您的房间号码      " +  getParameter("id") + "          "+ USER_INDENTIFY;
		this._showLabel = cc.LabelTTF.create(this._showString,"Microsoft Yahei", 14);
		this._showLabel.setPosition(cc.p(130,23));
		var dest = cc.p(150,screenSize.height - 50);
		
		var a1 =  cc.EaseElasticIn.create(cc.MoveTo.create(0.4,cc.p(dest.x+100,dest.y)));
        var a2 =  cc.EaseElasticOut.create(cc.MoveTo.create(0.2,dest));
       
		bg.addChild(this._showLabel,1);
		bg.runAction(cc.Sequence.create(a1,a2));
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