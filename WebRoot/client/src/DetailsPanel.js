var DetailsPanel = cc.Layer
		.extend({
			values : null,
			labels : null,
			indentify_id : null,
			init : function() {
				this._super();
				var self = this;
				var screenSize = cc.Director.getInstance().getWinSize();
				self.values = new Array();
				self.labels = new Array();
				if (USER_INDENTIFY == "零售商")
					self.indentify_id = 0;
				else if (USER_INDENTIFY == "批发商")
					self.indentify_id = 1;
				else if (USER_INDENTIFY == "生产商")
					self.indentify_id = 2;
				else
					self.indentify_id = 3;

				
				self.genTables();
				self.updateInformationFromServer();
				return true;
			},
			updateInformationFromServer : function() {
				var self = this;
				var linkAjax = "dojo/room/_room_record_turns.jsp?id="
						+ getParameter("id") + "&key="
						+ indentifyRecord[self.indentify_id];
				$.ajax({
					type : "GET",
					url : linkAjax,
					success : function(data) {
						var ret = data.split(")))")[1].split(",");
						for ( var i = 0; i < ret.length; i++) {
							self.values[i].setString(ret[i]);
						}
					}
				});
			},
			genTables : function() {
				var self = this;
				var offset = 30;
				var screenSize = cc.Director.getInstance().getWinSize();
				var start = cc.p(screenSize.width * 2 / 3 + 80,
						screenSize.height - 80);
				if (self.indentify_id >= 3)
					return false;
				for ( var i = 0; i < tableLabels[self.indentify_id].length; i++) {
					self.labels[i] = cc.LabelTTF.create(
							tableLabels[self.indentify_id][i] + " :",
							"Microsoft Yahei", 14);
					self.values[i] = cc.LabelTTF.create("0",
							"Microsoft Yahei", 14);
					self.labels[i].setPosition(cc.p(start.x, start.y));
					self.values[i].setPosition(cc.p(start.x + 100, start.y));
					start.y -= offset;
					self.addChild(self.labels[i]);
					self.addChild(self.values[i]);
				}
			},
			fillTable : function(data) {

			}

		});

DetailsPanel.create = function() {
	var ret = new DetailsPanel();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}