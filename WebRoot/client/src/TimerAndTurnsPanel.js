var TimerAndTurnsPanel = cc.Layer
		.extend({
			_showTime : null,
			_showString : null,
			_time : null,
			_totalTurns : null,
			_nowTurns : null,
			_isWeekStart : null,
			SHOW_TIME_TAG : null,
			_showTurns : null,
			_showTurnsString : null,
			_isDone : null,
			_postedInformation : null,
			init : function() {
				this._super();
				var screenSize = cc.Director.getInstance().getWinSize();
				this.SHOW_TIME_TAG = 5000;
				this._showString = "00:00:00";
				this._showTurnsString = "00/20";
				this._showTime = cc.LabelBMFont.create(this._showString,konqa);				
				this._showTime.setScale(0.7);
				//this._showTime =cc.LabelTTF.create("","Microsoft Yahei", 36);
				this._showTime.setPosition(cc.p(screenSize.width / 3,
						screenSize.height - 120));
				this.addChild(this._showTime, 1, this.SHOW_TIME_TAG);
				this._time = EVERY_TURNS_TIME;

				this._totalTurns = 20;
				this._nowTurns = 0;
				
				this._postedInformation = cc.LabelTTF.create("","Microsoft Yahei", 36);
				this._postedInformation.setPosition(cc.p(screenSize.width / 3,
						screenSize.height - 120));
				this.addChild(this._postedInformation,1);
				
				this._showTurns = cc.LabelBMFont.create(this.getTurnsString(),
						futura);
				this._showTurns.setScale(0.4);
				
				this.addChild(this._showTurns);
				this._showTurns.setPosition(cc.p(screenSize.width / 3 + 150,
						screenSize.height - 128));
				this.updateTurns();
				this.updateNowTurns();
				return true;
			},
			
			showMessage : function(msg)
			{
				cc.log("msg = " +msg);
				this._showTime.setString("");
				this._postedInformation.setString(msg);
			},
			startCount : function() {
				this._isDone = false;
				this._time = EVERY_TURNS_TIME;
				this.schedule(this.step);
			},
			
			stopCount : function ()
			{
				this._isDone = true;
				this.unschedule(this.step);
			},
			step : function(dt) {
				this._time -= dt;
				var t = this._time.toFixed(2);
				if (t < 0.0001) {
					this.unschedule(this.step);
					this._isDone = true;
				}
				var s = parseInt(t);
				var m = 0;
				var secondString;
				if (s > 60) {
					m += parseInt(s / 60);
					s = s % 60;
				}
				secondString = (s < 10 ? "0" : "") + s;
				this._showString = (m < 10 ? "0" : "") + m;
				this._showString += ":" + secondString;
				t = parseInt(t * 100) % 100;
				this._showString += ":" + (t < 10 ? "0" : "") + t;

				var label = this.getChildByTag(this.SHOW_TIME_TAG);
				this._postedInformation.setString("");
				label.setString(this._showString);
			},

			getTime : function() {
				return parseInt(this._time);
			},
			// need ajax
			updateTurns : function() {
				this._totalTurns = 18;
				var linkAjax = "dojo/room/_room_total_turns.jsp?id="
						+ getParameter("id");
				var turns = 0;
				var self = this;
				$.ajax({
					type : "GET",
					url : linkAjax,
					// async : false,
					success : function(data) {
						self._totalTurns = data.split(",")[1];
						self._totalTurns = parseInt(self._totalTurns);
						self._showTurns.setString(self.getTurnsString());
						cc.log("Total Turns = " + self._totalTurns);
					}
				});
			},

			updateNowTurns : function() {
				var linkAjax = "dojo/room/_room_now_turns.jsp?id="
						+ getParameter("id");
				var self = this;
				$.ajax({
					type : "GET",
					url : linkAjax,
					async : false,
					success : function(data) {
						self._nowTurns = data.split(",")[1];
						self._nowTurns = parseInt(self._nowTurns);
						self._showTurns.setString(self.getTurnsString());
						cc.log("Now Turns = " + self._nowTurns);
					}
				});
			},

			getTurnsString : function() {
				this._showTurnsString = (this._nowTurns < 10 ? "0" : "")
						+ this._nowTurns;
				this._showTurnsString += "/"
						+ (this._totalTurns < 10 ? "0" : "") + this._totalTurns;
				return this._showTurnsString;
			},
			setTime : function(time) {
				this._time = time;
			},

		});

TimerAndTurnsPanel.create = function() {
	var ret = new TimerAndTurnsPanel();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}