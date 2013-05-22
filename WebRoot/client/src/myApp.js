var PlayLayer = cc.Layer
		.extend({

			_mediator : null,
			init : function() {
				var selfPointer = this;

				this._super();
				var size = cc.Director.getInstance().getWinSize();
				this._mediator = Mediator.create(this);

				/*
				 * var linkAjax = "dojo/room/_room_is_start.jsp?id=" + 141;
				 * $.ajax({ type: "GET", url: linkAjax, success: function(data) {
				 * var value = data.split(",")[1]; cc.log(value); } });
				 * 
				 */

				cc.log("id = " + getParameter("id"));

				var colorLayer = cc.LayerColor.create(new cc.Color3B(255, 255,
						255), size.width, size.height);
				this.addChild(colorLayer, 0);
				this.setTouchEnabled(true);
				this.schedule(this.mainLoop);
				this.schedule(this.get, 0.5);
				this.adjustSizeForWindow();
				window.addEventListener("resize", function(event) {
					selfPointer.adjustSizeForWindow();
				});

				return true;
			},

			mainLoop : function(dt) {
				var self = this;
				if(self._mediator.)
			},
			get : function(dt) {
				var self = this;
				if (false == self._mediator._isGeted) {
					self._mediator.getTurnDataAndGenForms();
				}
			},

			adjustSizeForWindow : function() {
				var margin = document.documentElement.clientWidth
						- document.body.clientWidth;
				if (document.documentElement.clientWidth < cc.originalCanvasSize.width) {
					cc.canvas.width = cc.originalCanvasSize.width;
				} else {
					cc.canvas.width = document.documentElement.clientWidth
							- margin;
				}
				if (document.documentElement.clientHeight < cc.originalCanvasSize.height) {
					cc.canvas.height = cc.originalCanvasSize.height;
				} else {
					cc.canvas.height = document.documentElement.clientHeight
							- margin;
				}

				var xScale = cc.canvas.width / cc.originalCanvasSize.width;
				var yScale = cc.canvas.height / cc.originalCanvasSize.height;
				if (xScale > yScale) {
					xScale = yScale;
				}
				cc.canvas.width = cc.originalCanvasSize.width * xScale;
				cc.canvas.height = cc.originalCanvasSize.height * xScale;
				var parentDiv = document.getElementById("Cocos2dGameContainer");
				if (parentDiv) {
					parentDiv.style.width = cc.canvas.width + "px";
					parentDiv.style.height = cc.canvas.height + "px";
				}
				cc.renderContext.translate(0, cc.canvas.height);
				cc.renderContext.scale(xScale, xScale);
				cc.Director.getInstance().setContentScaleFactor(xScale);
			},

			onTouchesBegan : function(touches, event) {
				this.isMouseDown = true;
			},
			onTouchesMoved : function(touches, event) {
				if (this.isMouseDown) {
					if (touches) {
						// this.circle.setPosition(cc.p(touches[0].getLocation().x,
						// touches[0].getLocation().y));
					}
				}
			},
			onTouchesEnded : function(touches, event) {
				this.isMouseDown = false;
			},
			onTouchesCancelled : function(touches, event) {
				console.log("onTouchesCancelled");
			}
		});

var PlayScene = cc.Scene.extend({
	onEnter : function() {
		this._super();
		var layer = new PlayLayer();
		layer.init();
		this.addChild(layer);
	}
});