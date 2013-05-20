var Timer = cc.Layer
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
			init : function() {
				this._super();
				var screenSize = cc.Director.getInstance().getWinSize();
				this.SHOW_TIME_TAG = 5000;
				this._showString = "00:00:00";
				this._showTurnsString = "00/20";
				this._showTime = cc.LabelTTF.create(this._showString, "宋体", 38);
				this._showTime.setPosition(cc.p(screenSize.width / 3,
						screenSize.height - 60));
				this.addChild(this._showTime, 1, this.SHOW_TIME_TAG);
				this._time = 30;

				this._totalTurns = 20;
				this._nowTurns = 0;

				this._showTurns = cc.LabelTTF.create(this.getTurnsString(),
						"宋体", 16);
				this.addChild(this._showTurns);
				this._showTurns.setPosition(cc.p(screenSize.width / 3 + 150,
						screenSize.height - 68));
				this.updateTurns();
				this.updateNowTurns();
				this.schedule(this.step);

				return true;
			},

			// need ajax
			updateTurns : function() {
				this._totalTurns = 18;
				var linkAjax = "dojo/room/_room_total_turns.jsp?id="
						+ getParameter("id");
				var turns = 0;
				$.ajax({
					type : "GET",
					url : linkAjax,
					async : false,
					success : function(data) {
						var value = data.split(",")[1];
						turns = parseInt(value);
						cc.log("Total Turns = " + turns);
					}
				});
				this._totalTurns = turns;
				this._showTurns.setString(this.getTurnsString());
			},

			updateNowTurns : function() {
				var linkAjax = "dojo/room/_room_now_turns.jsp?id="
						+ getParameter("id");
				var nowTurns = 0;
				$.ajax({
					type : "GET",
					url : linkAjax,
					async : false,
					success : function(data) {
						var value = data.split(",")[1];
						nowTurns = parseInt(value);
						cc.log("Now Turns = " + nowTurns);
					}
				});
				this._nowTurns = nowTurns;
				this._showTurns.setString(this.getTurnsString());
			},

			getTurnsString : function() {
				this._showTurnsString = (this._nowTurns < 10 ? "0" : "")
						+ this._nowTurns;
				this._showTurnsString += "/"
						+ (this._totalTurns < 10 ? "0" : "") + this._totalTurns;
				return this._showTurnsString;
			},
			step : function(dt) {
				this._time -= dt;
				var t = this._time.toFixed(2);

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
				label.setString(this._showString);
			},
			getTime : function() {
				return parseInt(this._time);
			},

		});

Timer.create = function() {
	var ret = new Timer();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}