var DetailsPanel = cc.Layer.extend({
	values : null,
	labels : null,
	indentify_id : null,
	para_values : null,
	para_labels : null,
	init : function() {
		this._super();
		var self = this;
		var screenSize = cc.Director.getInstance().getWinSize();
		self.values = new Array();
		self.labels = new Array();
		self.para_values = new Array();
		self.para_labels = new Array();
		if (USER_INDENTIFY == "零售商")
			self.indentify_id = 0;
		else if (USER_INDENTIFY == "批发商")
			self.indentify_id = 1;
		else if (USER_INDENTIFY == "生产商")
			self.indentify_id = 2;
		else
			self.indentify_id = 3;

		self.genTables();
		self.updatePara();
		self.updateInformationFromServer();
		return true;
	},
	updateInformationFromServer : function() {
		var self = this;
		var linkAjax = "dojo/room/_room_record_turns.jsp?id="
				+ getParameter("id") + "&key="
				+ indentifyRecord[self.indentify_id] + "&cache=" + new Date();

		$.ajax({
			type : "GET",
			url : linkAjax,
			success : function(data) {
				var ret = data.split(")))")[1].split(",");
				//cc.log(ret);
				for ( var i = 0; i < ret.length; i++) {
					self.values[i].setString(parseFloat(ret[i]).toFixed(2));
				}
			}
		});
	},
	genTables : function() {
		var self = this;
		var offset = 30;
		var screenSize = cc.Director.getInstance().getWinSize();
		var start = cc
				.p(screenSize.width * 2 / 3 + 80, screenSize.height - 120);
		if (self.indentify_id >= 3)
			return false;

		// 游戏参数
		for ( var i = 0; i < para[self.indentify_id].length; i++) {
			self.para_labels[i] = cc.LabelTTF.create(para[self.indentify_id][i]
					+ " :", "Microsoft Yahei", 14);
			self.para_values[i] = cc.LabelTTF
					.create("0", "Microsoft Yahei", 14);
			self.para_labels[i].setPosition(cc.p(start.x, start.y));
			self.para_values[i].setPosition(cc.p(start.x + 100, start.y));
			start.y -= offset;
			self.addChild(self.para_labels[i]);
			self.addChild(self.para_values[i]);
		}
		
		start.y -= 50;
		// 游戏记录
		for ( var i = 0; i < tableLabels[self.indentify_id].length; i++) {
			self.labels[i] = cc.LabelTTF.create(
					tableLabels[self.indentify_id][i] + " :",
					"Microsoft Yahei", 14);
			self.values[i] = cc.LabelTTF.create("0", "Microsoft Yahei", 14);
			self.labels[i].setPosition(cc.p(start.x, start.y));
			self.values[i].setPosition(cc.p(start.x + 100, start.y));
			start.y -= offset;
			self.addChild(self.labels[i]);
			self.addChild(self.values[i]);
		}

	},

	updatePara : function() {
		var self = this;
		var linkAjax = "dojo/room/_room_record_turns.jsp?id="
				+ getParameter("id") + "&key="
				+ indentifyPara[self.indentify_id] + "&cache=" + new Date();

		$.ajax({
			type : "GET",
			url : linkAjax,
			success : function(data) {
				var ret = data.split(")))")[1].split(",");
				cc.log(ret);
				for ( var i = 0; i < ret.length; i++) {
					self.para_values[i]
							.setString(parseFloat(ret[i]).toFixed(2));
				}
			}
		});
	}

});

DetailsPanel.create = function() {
	var ret = new DetailsPanel();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}