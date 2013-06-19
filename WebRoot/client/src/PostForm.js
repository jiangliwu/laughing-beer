var PostForm = cc.Layer.extend({
	sendInput : null,
	orderInput : null,
	sendTitle : null,
	bookTitle : null,
	isPosted : null,
	commitButton : null,
	input:null,
	init : function() {
		var self = this;
		var screenSize = cc.Director.getInstance().getWinSize();
		self.isPosted = false;
		self.addSendForm();
		self.addBookForm();
		self.input = 
		this.commitButton = cc.MenuItemImage.create(
				"client/res/img/submit_button1.png",
				"client/res/img/submit_button2.png", self.post, self);
		var menu = cc.Menu.create(this.commitButton);
		menu.setPosition(cc.p(screenSize.width / 3 + 120, 180));
		self.addChild(menu);
		//cc.log("Add success!");
		return true;
	},
	post : function() {
		this.commitButton.setEnabled(false);
		this.isPosted = true;
	},
	reset : function(command) {
		
		this.isPosted = false;
		this.commitButton.setEnabled(true);
		this.orderInput.setText("0");
		this.sendInput.setText("0");
	},
	addSendForm : function() {
		var self = this;
		self.sendTitle = cc.LabelTTF
				.create("发货量" + " :", "Microsoft Yahei", 14);
		var screenSize = cc.Director.getInstance().getWinSize();
		self.sendTitle.setPosition(cc.p(100, screenSize.height / 2 + 30));
		self.addChild(self.sendTitle);

		self.sendInput = cc.EditBox.create(cc.size(150, 30));
		self.sendInput.setText("0");
		self.sendInput.setPosition(100 + 50, screenSize.height / 2 +20);
		self.sendInput.setBgClr(new cc.Color3B(0,0,0));
		self.sendInput.setFontColor(new cc.Color3B(250,250 ,250));
		//self.sendInput.setBorderClr(new cc.Color3B(55, 250, 120));
		self.sendInput.setFontSize(16);
	
		this.addChild(self.sendInput);
	},

	addBookForm : function() {

		var self = this;
		var title = "订货量";
		if (USER_INDENTIFY == "生产商")
			title = "生产计划量";
		self.bookTitle = cc.LabelTTF
				.create(title + " :", "Microsoft Yahei", 14);
		var screenSize = cc.Director.getInstance().getWinSize();
		self.bookTitle.setPosition(cc.p(100, screenSize.height / 2 -30));
		self.addChild(self.bookTitle);

		self.orderInput = cc.EditBox.create(cc.size(150, 30));
		self.orderInput.setText("0");
		self.orderInput.setPosition(100 + 50, screenSize.height / 2 - 40);
		self.orderInput.setBgClr(new cc.Color3B(0, 0, 0));
		self.orderInput.setFontColor(new cc.Color3B(251, 250, 250));
		//self.orderInput.setBorderClr(new cc.Color3B(55, 250, 120));
		self.orderInput.setFontSize(16);
		this.addChild(self.orderInput);
	},

	getSendCount : function() {
		return parseInt(this.sendInput.getText());
	},

	getOrderCount : function() {
		return parseInt(this.orderInput.getText());
	},
});

PostForm.create = function() {
	var ret = new PostForm();
	if (ret && ret.init()) {
		return ret;
	}
	return null;
}