var EVERY_TURNS_TIME = 0;
var USER_INDENTIFY;
var tableLabels = new Array();
var para = new Array();
/*
 * tableLabels[0] = [ "本期购买量", "啤酒需求量", "实际销量", "欠货量", "延期销售成本", "期初库存量", "到货量",
 * "累计到货量", "批发商累计欠货量", "期末库存量", "库存成本", "订货量", "累计订货 ", "本期利润" ];
 * tableLabels[1] = [ "零售商订货量", "啤酒需求量", "实际发货量", "欠货量", "延期销售成本", "期初库存量",
 * "到货量", "累计到货量", "生产商累计欠货量", "期末库存量", "库存成本", "订货量", "累计订货 ", "本期利润" ];
 * tableLabels[2] = [ "批发商订货量", "啤酒需求量", "实际发货量", "欠货量", "延期销售成本", "初库存量",
 * "生产线出货量", "期末库存量", "库存成本", "生产计划量", "本期利润" ];
 */

para[0] = [ "零售价", "成本", "延迟销售成本", "库存成本", "订单手续费", "到货运输费" ];
para[1] = [ "批发价", "成本", "延迟销售成本", "库存成本", "订单手续费", "到货运输费" ];
para[2] = [ "批发价", "成本", "延迟销售成本", "库存成本", "生产线启动费" ];
tableLabels[0] = [ "本周购买", "累计欠货", "现存货物", "上级欠货", "本期利润", "全部利润" ];
tableLabels[1] = [ "本周订单", "累计欠货", "现存货物", "上级欠货", "本期利润", "全部利润" ];
tableLabels[2] = [ "本周订单", "累计欠货", "现存货物", "本期利润", "全部利润" ];

indentifyRecord = [ "retailRecord", "wholesaleRecord", "producerRecord" ];
indentifyPara = ["retailConfig","wholesaleConfig","producerConfig"];
function loadConfig() {

	var linkAjax = "dojo/room/_room_turns_time.jsp?id=" + getParameter("id");
	$.ajax({
		type : "GET",
		url : linkAjax,
		async : false,
		success : function(data) {
			var value = data.split(",")[1];
			EVERY_TURNS_TIME = parseInt(value);
			cc.log("every turns time = " + EVERY_TURNS_TIME);
		}
	});

	var linkAjax = "dojo/room/_room_get_indentify.jsp?id=" + getParameter("id");
	var self = this;
	$.ajax({
		type : "GET",
		url : linkAjax,
		async : false,
		success : function(data) {
			USER_INDENTIFY = data.split(",")[1];
			cc.log("USER_INDENTIFY = " + USER_INDENTIFY);
		}
	});
	return true;
}
