var PlayLayer = cc.Layer.extend({

	_mediator : null,
	init : function() {
		var selfPointer = this;

		this._super();
		var size = cc.Director.getInstance().getWinSize();
		this._mediator = Mediator.create(this);
		var yellowBackground = cc.LayerColor.create(cc.c4b(0, 0, 0, 255));
		this.addChild(yellowBackground, 0);
		this.setTouchEnabled(true);
		
		
		this.schedule(this.get, 1);
		
		
		return true;
	},

	mainLoop : function(dt) {
		var self = this;
		if (true == self._mediator._isGeted
				&& true == self._mediator._timer._isDone) {
			self._mediator.postTurnData();
		}
	},
	get : function(dt) {
		var self = this;
		if (false == self._mediator._isGeted) {
			self._mediator.getTurnDataAndGenForms();
		} else if (true == self._mediator._timer._isDone || true == self._mediator._postForm.isPosted) {
			self._mediator.postTurnData();
		}
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