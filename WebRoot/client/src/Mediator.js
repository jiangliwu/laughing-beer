function Mediator() {

	this._location;
	this._timer;
	this._layer;
	this._isGeted;
	this._details;
	this._postForm;
	this._command;
	this._tips;
	this.init = function(mainLayer) {
		this._size = cc.Director.getInstance().getWinSize();

		loadConfig();
		this._layer = mainLayer;
		this._tips = TipsManage.create();
		this._layer.addChild(this._tips);
		this._location = Location.create();
		this._layer.addChild(this._location, 1);

		this._timer = TimerAndTurnsPanel.create();
		this._layer.addChild(this._timer, 1);

		this._details = DetailsPanel.create();
		this._layer.addChild(this._details, 1);

		this._postForm = PostForm.create();
		this._layer.addChild(this._postForm, 1);

		this._isGeted = false;
		this._command = "";
		return true;
	},

	this.postTurnData = function() {
		// 取得需要提交的信息

		var self = this;
		var send, book;
		if (self._postForm.commitButton.isEnabled() == false) {
			send = self._postForm.getSendCount();
			book = self._postForm.getOrderCount();
		} else {
			send = (parseInt(Math.random() * 100) % 8 + 8) % 8;
			book = (parseInt(Math.random() * 100) % 10 + 10) % 10;
		}
		if (self._command.indexOf("send") < 0) {
			send = 0;
		}
		// cc.log(send + " " + book);
		$.ajax({
			type : "GET",
			url : genPushUrl(getParameter("id"), send, book),
			success : function(data) {
				var ret = data.split("((((")[1];
				self._isGeted = false;
				self._tips.addTip("第 "+self._timer._nowTurns+" 周周末 : 您的货物和订单已经发出!");
				self._timer.stopCount();
				self._details.updateInformationFromServer();
			}
		});
	},

	this.addTips = function(msg) {
		var self = this;
		if (msg == undefined)
			return;
		var op = msg.split("|")[0];
		var values = (msg.split("|")[1]).split(",");
		//cc.log(op + " " + values);
		var now = self._timer._nowTurns;
		if (op.indexOf("order") >= 0) {
			self._tips.addTip("第 "+now+" 周周初 : 您收到一笔订单，数量为" + values[0]);
		}
		if (op.indexOf("receive") > 0) {
			self._tips.addTip("第 "+now+" 周周初 : 您收到一笔货物，数量为" + values[1]);
		}
	},

	this.getTurnDataAndGenForms = function() {
		var self = this;
		var link = GenPullUrl(getParameter("id"));
		$
				.ajax({
					type : "GET",
					url : link,
					success : function(data) {
						var ret = data.split("((((")[1];
						if (self._timer._nowTurns >= self._timer._totalTurns) {
							cc.Director.getInstance().replaceScene(
									new GameOverScene());

						}
						if (ret == "gameOver") {
							window.location.href = "game_show_record?id="
									+ getParameter("id");
						} else if (ret == "no-event") {
							self._timer.showMessage("这周无事可做");
						} else if (ret == "wait") {
							self._timer.showMessage("等待下一周！");

						} else if (ret == undefined) {
							cc.log("pass");
						} else {
							self._details.updateInformationFromServer();
							self._timer.showMessage("");
							
							self._timer.startCount();
							self._isGeted = true;
							self._command = ret;
							self._timer.updateNowTurns();
							self.addTips(ret);
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
