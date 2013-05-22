function Mediator() {

	this._location;
	this._timer;
	this._layer;
	this._isGeted;
	this.init = function(mainLayer) {
		this._size = cc.Director.getInstance().getWinSize();

		loadConfig();
		this._layer = mainLayer;

		this._location = Location.create();
		this._layer.addChild(this._location, 1);
		this._location.updateString();

		this._timer = TimerAndTurnsPanel.create();
		this._layer.addChild(this._timer, 1);
		// this._timer.schedule(this._timer.step);
		this._isGeted = false;
		//this.getTurnDataAndGenForms();

		return true;
	},
	
	
	this.postTurnData = function() {
		var self = this;
		var send = 1;
		var book = 2;
		var link = genPushUrl(getParameter("id"), send, book);
		$.ajax({
			type : "GET",
			url : link,
			success : function(data) {
				cc.log(data);
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
				cc.log(ret);
				if (ret == "no-event") {

				} else {
					self._timer.startCount();
					self._isGeted = true;
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
