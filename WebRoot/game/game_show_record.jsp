<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"%>
<html>
<head>
<title>Laughing-beer - 游戏记录</title>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script
	src="<s:url value='assets/js/flotr2.min.js' encode='false' includeParams='none'/>"></script>

<style type="text/css">
#chart {
	width: auto;
	height: 400px;
	margin: 30px 30px 30px 30px;
}
</style>
</head>

<body>


	<s:if test="retailRecords.size() == 0">
		<s:if test='game == null'>
			<div class="container">没有这个房间!</div>
		</s:if>
		<s:else>
			<script type="text/javascript">
				window.location.reload();
			</script>
		</s:else>
	</s:if>
	<s:else>

		<div class="container-fluid">

			<div id="chart"></div>

			<table class="table table-striped table-bordered table-condensed"
				id="data">
				<thead>
					<tr>
						<th>#</th>
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
							<s:param name="first" value="0"></s:param>
							<s:param name="last" value="retailRecords.size()-1"></s:param>
							<s:iterator>
								<th>${current}</th>
							</s:iterator>
						</s:bean>
					</tr>
				</thead>

				<tbody>

					<tr>
						<td>顾客需求</td>
						<s:iterator value="retailRecords" var="g">
							<td><fmt:formatNumber value="${g.thisTimeBuy}" pattern="0" />
							</td>
						</s:iterator>
					</tr>
					<tr>
						<td>零售订单</td>
						<s:iterator value="retailRecords" var="g">
							<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
							</td>
						</s:iterator>
					</tr>

					<tr>
						<td>批发订单</td>
						
						<s:iterator value="wholesaleRecords" var="g">
							<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
							</td>
						</s:iterator>
					</tr>
					<tr>
						<td>生产订单</td>
						<s:iterator value="producerRecords" var="g">
							<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
							</td>
						</s:iterator>
					</tr>
				</tbody>
			</table>
			<hr class="soften">
			<p>
				<a rel="tooltips" title="点击这里显示详细信息" href="#" id="show-record">点击这里显示详细信息</a>
			</p>
			<div id="detail-record" style="display:none">
				<div class="container-fluid">
					<h3>零售商</h3>

					<table
						class="table table-striped table-bordered table-condensed table-hover">
						<thead>
							<tr>
								<th>游戏周数</th>
								<th>本期购买量</th>
								<th>啤酒需求量</th>
								<th>实际销量</th>
								<th>欠货量</th>
								<th>延期销售成本</th>
								<th>期初库存量</th>
								<th>到货量</th>
								<th>累计到货量</th>
								<th>批发商累计欠货量</th>
								<th>期末库存量</th>
								<th>库存成本</th>
								<th>订货量</th>
								<th>累计订货</th>
								<th>本期利润</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator value="retailRecords" var="g">
								<tr>
									<td>${g.times}</td>
									<td><fmt:formatNumber value="${g.thisTimeBuy}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allNeed}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allOwe}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.delayCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.receiveGoods}"
											pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.totalReciveGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.totalUpOweGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.endGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.storageCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.totalOrderGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.thisTimeProfit}"
											pattern="0.00" /></td>
								</tr>
							</s:iterator>
							<tr>
								<td colspan="13"></td>
								<td>总利润</td>
								<td><fmt:formatNumber value="${retailAllProfit}"
										pattern="0.00" /></td>
							</tr>

						</tbody>
					</table>

					<h3>批发商</h3>
					
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>游戏周数</th>
								<th>零售商订货量</th>
								<th>啤酒需求量</th>
								<th>实际发货量</th>
								<th>欠货量</th>
								<th>延期销售成本</th>
								<th>期初库存量</th>
								<th>到货量</th>
								<th>累计到货量</th>
								<th>生产累计欠货量</th>
								<th>期末库存量</th>
								<th>库存成本</th>
								<th>订货量</th>
								<th>累计订货</th>
								<th>本期利润</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator value="wholesaleRecords" var="g">
								<tr>
									<td>${g.times}</td>
									<td><fmt:formatNumber value="${g.thisTimeBuy}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allNeed}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allOwe}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.delayCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.receiveGoods}"
											pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.totalReciveGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.totalUpOweGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.endGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.storageCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.totalOrderGoods}"
											pattern="0" /></td>
									<td><fmt:formatNumber value="${g.thisTimeProfit}"
											pattern="0.00" /></td>

								</tr>
							</s:iterator>
							<tr>
								<td colspan="13"></td>
								<td>总利润</td>
								<td><fmt:formatNumber value="${wholesaleAllProfit}"
										pattern="0.00" /></td>
							</tr>
						</tbody>
					</table>


					<h3>生产商</h3>
					<p>
						总利润 :
						<fmt:formatNumber value="${producerAllProfit}" pattern="0.00" />
					</p>
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th>游戏周数</th>
								<th>批发商订货量</th>
								<th>啤酒需求量</th>
								<th>实际发货量</th>
								<th>欠货量</th>
								<th>延期销售成本</th>
								<th>期初库存量</th>
								<th>生产线出货量</th>
								<th>期末库存量</th>
								<th>库存成本</th>
								<th>生产计划量</th>
								<th>本期利润</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator value="producerRecords" var="g">
								<tr>
									<td>${g.times}</td>
									<td><fmt:formatNumber value="${g.thisTimeBuy}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allNeed}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.allOwe}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.delayCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.receiveGoods}"
											pattern="0" />
									</td>


									<td><fmt:formatNumber value="${g.endGoods}" pattern="0" />
									</td>
									<td><fmt:formatNumber value="${g.storageCost}"
											pattern="0.00" />
									</td>
									<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
									</td>

									<td><fmt:formatNumber value="${g.thisTimeProfit}"
											pattern="0.00" /></td>

								</tr>
							</s:iterator>
							<tr>
								<td colspan="10"></td>
								<td>总利润</td>
								<td><fmt:formatNumber value="${producerAllProfit}"
										pattern="0.00" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<script type="text/javascript">
				function getTableValue(x, y) {
					return parseInt(document.getElementById("data").rows[x].cells[y].innerHTML);
				}
				function getSize() {
					return document.getElementById("data").rows[0].cells.length;
				}

				(function basic_axis(container) {

					var d1 = [], d2 = [], d3 = [], d4 = [], d5 = [ 0 ],

					ticks = [ [ 0 ], [ 5 ], 10, 15, 20, 25, 30 ], graph;

					for ( var i = 0; i < getSize() - 1; i++) {
						d1.push([ i, getTableValue(1, i + 1) ]);
						d2.push([ i, getTableValue(2, i + 1) ]);
						d3.push([ i, getTableValue(3, i + 1) ]);
						d4.push([ i, getTableValue(4, i + 1) ]);
					}

					function ticksFn(n) {
						return parseInt(n) + 1;
					}

					graph = Flotr.draw(container, [ {
						data : d1,
						label : '顾客需求',
						lines : {
							show : true
						},
						points : {
							show : true
						}
					}, {
						data : d2,
						label : '零售订单',
						lines : {
							show : true
						},
						points : {
							show : true
						}
					}, {
						data : d3,
						label : '批发订单',
						lines : {
							show : true
						},
						points : {
							show : true
						}
					}, {
						data : d4,
						label : '生产订单',
						lines : {
							show : true
						},
						points : {
							show : true
						}
					}

					], {
						mouse : {
							track : true,
							relative : true,
							position : 'ne',
							sensibility : 0.5,
							trackDecimals : 0,
							trackFormatter : function(o) {
								return 'x = ' + (parseInt(o.x)+1) + ', y = ' + o.y;
							}
						},

						xaxis : {
							noTicks : getSize() - 2,
							tickFormatter : ticksFn,
							min : 0,
							max : getSize() - 2,
							labelsAngle : 45,
							title : '轮数'
						},
						yaxis : {
							ticks : ticks,
							max : 35,
							title : '销量'
						},
						grid : {
							verticalLines : false,
							backgroundColor : {
								colors : [ [ 0, '#fff' ], [ 1, '#ccc' ] ],
								start : 'top',
								end : 'bottom'
							}
						},
						legend : {
							position : 'se'
						},
						title : '房间${game.gameId} - ${game.gameTitle}',
						subtitle : '各级供应链图表'
					});
				})(document.getElementById("chart"));
			</script>
		</div>
		</div>
	</s:else>
</body>
</html>