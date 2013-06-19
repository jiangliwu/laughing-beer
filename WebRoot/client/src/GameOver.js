var GameOverLayer = cc.Layer
		.extend({
			position : null,
			count : null,
			informations : null,
			loading : null,
			showRecordMenu : null,
			init : function() {
				this._super();
				var self = this;
				var size = cc.Director.getInstance().getWinSize();

				this.sprite = cc.Sprite.create("client/res/img/bg.png");
				this.sprite.setAnchorPoint(cc.p(0.5, 0.5));
				this.sprite.setPosition(cc.p(size.width / 2, size.height / 2));
				this.addChild(this.sprite);

				this.position = cc.p(size.width / 2, size.height / 2 + 100);
				this.count = 0;
				this.informations = [ "写入游戏信息到数据库...", "更改用户状态...",
						"提取游戏记录...", "写入游戏记录到数据库...", "生成图表中...", "后期处理完成..." ];
				this.addProgressAction(this.position);

				this.loading = cc.LabelTTF.create("游戏后期处理中....",
						"Microsoft Yahei", 36);
				this.loading.setPosition(cc.p(this.position.x,
						this.position.y + 80));
				this.addChild(this.loading);

				this.showRecordMenu = cc.MenuItemImage.create(
						"client/res/img/show_record_button1.png",
						"client/res/img/show_record_button2.png", function() {
							window.location.href = "game_show_record?id="
									+ getParameter("id");
						}, this);
				this.showRecordMenu.setAnchorPoint(cc.p(0.5, 0.5));
				var menu = cc.Menu.create(this.showRecordMenu, null);
				menu.setPosition(cc.PointZero());
				this.addChild(menu, 1);

				this.showRecordMenu.setPosition(cc.p(self.position.x,
						self.position.y - self.informations.length * 40));
				this.showRecordMenu.setScale(0);
				return true;
			},

			addProgressAction : function(position) {
				var pro_bg = cc.Sprite.create("client/res/img/pro_bg.png");
				pro_bg.setAnchorPoint(cc.p(0.5, 0.5));
				pro_bg.setPosition(position);
				this.addChild(pro_bg);

				var s1 = cc.ProgressTo.create(2, 20);
				var s2 = cc.ProgressTo.create(1, 40);
				var s3 = cc.ProgressTo.create(2, 50);
				var s4 = cc.ProgressTo.create(5, 70);
				var s5 = cc.ProgressTo.create(5, 75);
				var s6 = cc.ProgressTo.create(2, 95);
				var s7 = cc.ProgressTo.create(1, 100);

				var left = cc.ProgressTimer.create(cc.Sprite
						.create("client/res/img/pro_m.png"));
				left.setType(cc.PROGRESS_TIMER_TYPE_BAR);

				left.setMidpoint(cc.p(0, 0));
				left.setBarChangeRate(cc.p(1, 0));
				this.addChild(left);
				left.setPosition(cc.p(position.x - 1, position.y + 2));

				var add = cc.CallFunc.create(this.addInformation, this);
				var anam = cc.CallFunc.create(this.addButtonAndModifyTitle,
						this);
				left.runAction(cc.Sequence.create(s1, add, s2, add, s3, add,
						s4, add, s5, add, s6, add, s7, anam));

			},
			addButtonAndModifyTitle : function() {
				this.loading.setString("游戏已结束！");
				var a1 = cc.ScaleTo.create(0.1, 1.5);
				var a2 = cc.ScaleTo.create(0.1, 1);
				this.showRecordMenu.runAction(cc.Sequence.create(a1, a2));
			},
			addInformation : function() {
				var self = this;
				var infor = cc.LabelTTF.create(self.informations[self.count],
						"Microsoft Yahei", 14);
				infor.setScale(0);
				var a1 = cc.ScaleTo.create(0.1, 1.5);
				var a2 = cc.ScaleTo.create(0.1, 1);
				infor.runAction(cc.Sequence.create(a1, a2));
				infor.setPosition(cc.p(self.position.x, self.position.y
						- self.count * 20 - 30));
				self.count++;
				self.addChild(infor, 2);
			}

		});

var GameOverScene = cc.Scene.extend({
	onEnter : function() {
		this._super();
		var layer = new GameOverLayer();
		layer.init();
		this.addChild(layer);
	}
});