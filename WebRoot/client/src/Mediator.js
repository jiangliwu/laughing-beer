
function Mediator() {
	this._location;
	this._timer;
	this._layer;
	this.init = function(mainLayer) {
		this._size = cc.Director.getInstance().getWinSize();
		this._layer = mainLayer;

		this._location = Location.create();
		this._layer.addChild(this._location,1);
		this._location.updateString();


		this._timer = Timer.create();
		this._layer.addChild(this._timer,1);
		;

		return true;
	},

	this.getTime = function()			//初始化部分使用同步
	{
		var linkAjax = "dojo/room/_room_turns_time.jsp?id=" + getParameter("id");
        $.ajax({
            type: "GET",
            url: linkAjax,
            async:false,		
            success: function(data) {
                var value = data.split(",")[1];
                EVERY_TURNS_TIME = parseInt(value);
                cc.log("every turns time = " + EVERY_TURNS_TIME);
            }
        });
	},
	
	this.onMouseDown = function(event) {
		
	},
    this.onMouseDragged = function(event) {
        //this._map.mapDragged(event);
    },
    this.onMouseMoved = function(event) {

    },
    this.onMouseUp =  function(event) {
    	
    }
}

Mediator.create = function(mainLayer) {
	var ret = new Mediator();
	if (ret && ret.init(mainLayer)) return ret;
	return null;
}




