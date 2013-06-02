function Mediator() {

	this._location;
	this._timer;
	this._layer;
	this._isGeted;
	this._details;
	this._postForm;
	this._command;
	this.init = function(mainLayer) {
		this._size = cc.Director.getInstance().getWinSize();

		loadConfig();
		this._layer = mainLayer;

		this._location = Location.create();
		this._layer.addChild(this._location, 1);

		this._timer = TimerAndTurnsPanel.create();
		this._layer.addChild(this._timer, 1);
		
		this._details = DetailsPanel.create();
		this._layer.addChild(this._details,1);
		
		this._postForm = PostForm.create();
		this._layer.addChild(this._postForm,1);
		
		this._isGeted = false;
		this._command = "";
		return true;
	},

	this.postTurnData = function() {
		var self = this;
		var send = parseInt(Math.random()*100)%8;
		if(self._command.indexOf("send") < 0)
			send = 0;
		var book = parseInt(Math.random()*100)%10;
		var link = genPushUrl(getParameter("id"), send, book);
		cc.log("push links = " + link);
		$.ajax({
			type : "GET",
			url : link,
			success : function(data) {
				var ret = data.split("((((")[1];
				self._isGeted = false;
				self._timer.stopCount();
			}
		});
	},

	this.getTurnDataAndGenForms = function() {
		var self = this;
		var link = GenPullUrl(getParameter("id"));
		$.ajax({
			type : "GET",
			url : link,
			success : function(data) {
				var ret = data.split("((((")[1];
				if (ret == "no-event") {
					self._timer.showMessage("这周无事可做");
				} else if (ret == "wait") {
					self._timer.showMessage("等待下一周！");
				} else {
					self._timer.showMessage("");
					self._timer.startCount();
					self._isGeted = true;
					self._command = ret;
					self._timer.updateNowTurns();
					self._postForm.reset(ret);
				}
			}
		});
	}
}

Mediator.create = function(mainLayer) {
	var ret = new Mediator();
	if (ret && ret.init(mainLayer))
		return ret;
	return null;
}
