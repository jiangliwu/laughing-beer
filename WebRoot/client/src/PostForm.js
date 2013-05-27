var PostForm = cc.Layer
		.extend({
			sendInput : null,
			orderInput : null,
			sendTitle : null,
			bookTitle: null,
			isPosted : null,
			init : function() {
				var self = this;
				var screenSize = cc.Director.getInstance().getWinSize();
				self.isPosted = false;
				self.addSendForm();
				self.addBookForm();

				var menuLabel = cc.LabelTTF.create("完成操作", "Microsoft Yahei",
						38);
				var p = cc.MenuItemLabel.create(menuLabel, self.post, self);
				var menu = cc.Menu.create(p);
				menu.setPosition(cc.p(screenSize.width / 3 + 100, 100));
				self.addChild(menu);
				return true;
			},
			post : function() {
				this.isPosted = true;
			},
			reset : function(command) {
				this.isPosted = false;
			},
			addSendForm : function() {
				var self = this;
				self.sendTitle = cc.LabelTTF.create("发货量" + " :",
						"Microsoft Yahei", 14);
				var screenSize = cc.Director.getInstance().getWinSize();
				self.sendTitle .setPosition(cc.p(100, screenSize.height / 2));
				self.addChild(self.sendTitle);

				self.sendInput = cc.EditBox.create(cc.size(100, 30));
				self.sendInput.setText("30");
				self.sendInput
						.setPosition(100 + 50, screenSize.height / 2 - 10);
				self.sendInput.setBgClr(new cc.Color3B(255, 0, 0));
				self.sendInput.setFontColor(new cc.Color3B(251, 250, 0));
				self.sendInput.setBorderClr(new cc.Color3B(55, 250, 120));
				self.sendInput.setFontSize(16);
				self.sendInput.setVisible(false);
				this.addChild(self.sendInput);
			},

			addBookForm : function() {

				var self = this;
				var title = "订货量";
				if (USER_INDENTIFY == "生产商")
					title = "生产计划量";
				self.bookTitle = cc.LabelTTF.create(title + " :",
						"Microsoft Yahei", 14);
				var screenSize = cc.Director.getInstance().getWinSize();
				self.bookTitle.setPosition(cc.p(100, screenSize.height / 2 - 50));
				self.addChild(self.bookTitle);

				self.orderInput = cc.EditBox.create(cc.size(100, 30));
				self.orderInput.setText("2");
				self.orderInput.setPosition(100 + 50,
						screenSize.height / 2 - 60);
				self.orderInput.setBgClr(new cc.Color3B(255, 0, 0));
				self.orderInput.setFontColor(new cc.Color3B(251, 250, 0));
				self.orderInput.setBorderClr(new cc.Color3B(55, 250, 120));
				self.orderInput.setFontSize(16);
				
				self.orderInput.setVisible(false);
				this.addChild(self.orderInput);
			},

			getSendCount : function() {

			},

			getOrderCount : function() {

			},
		});

PostForm.create = function() {
	var ret = new PostForm();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}