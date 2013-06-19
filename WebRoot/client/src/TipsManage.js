/**
 * 提示信息管理类，作为单例的来用
 * 
 * @type {[type]}
 */
var TipsManage = cc.Layer.extend({
	_tipsNumber : null,
	_winSize : null,
	_tipx : null,
	_count : null,
	init : function() {
		this._super();
		this._tipsNumber = 0;
		this._winSize = cc.Director.getInstance().getWinSize();
		this._tipx = new Array();
		this._count = 6;
		for ( var i = 0; i < this._count; i++) {
			this._tipx[i] = cc.LabelTTF.create(" ", "Microsoft Yahei", 14);
			this._tipx[i].setPosition(cc.p(this._winSize.width * 0.5 - 50,
					100 - i * 15));
			this.addChild(this._tipx[i]);
		}
		return true;
	},
	addTip : function(information) {
		//cc.log(information);
		if (this._tipsNumber >= this._count) {
			this._tipsNumber = 0;
			for ( var i = 0; i < this._count; i++)
				this._tipx[i].setString(" ");
		}
		//cc.log(this._tipsNumber);
		this._tipx[this._tipsNumber].setString(information);
		this._tipx[this._tipsNumber].setScale(0.0);
		var action1 = cc.ScaleTo.create(0.1, 1.5);
		var action2 = cc.ScaleTo.create(0.1, 1);
		this._tipx[this._tipsNumber].runAction(cc.Sequence.create(action1, action2));
		this._tipsNumber++;
	}
});

TipsManage.create = function() {
	var ret = new TipsManage();
	if (ret && ret.init()) {
		return ret;
	}
	return ret;
}
