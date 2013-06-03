<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"%>
<html>
<head>
<title>Laughing-beer - 游戏中</title>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>

<body>

	<div class="container-fluid">


		<h3>零售商</h3>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>游戏轮数</th>
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
						<td><fmt:formatNumber value="${g.allNeed}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.allOwe}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.delayCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.receiveGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.totalReciveGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.totalUpOweGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.endGoods}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.storageCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.totalOrderGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.thisTimeProfit}"
								pattern="0.00" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<h3>批发商</h3>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>游戏轮数</th>
					<th>零售商订货量</th>
					<th>啤酒需求量</th>
					<th>实际销量</th>
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
						<td><fmt:formatNumber value="${g.allNeed}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.allOwe}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.delayCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.receiveGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.totalReciveGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.totalUpOweGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.endGoods}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.storageCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.totalOrderGoods}"
								pattern="0" /></td>
						<td><fmt:formatNumber value="${g.thisTimeProfit}"
								pattern="0.00" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>


		<h3>生产商</h3>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>游戏轮数</th>
					<th>批发商订货量</th>
					<th>啤酒需求量</th>
					<th>实际销量</th>
					<th>欠货量</th>
					<th>延期销售成本</th>
					<th>期初库存量</th>
					<th>生产线出货量</th>
					<th>期末库存量</th>
					<th>库存成本</th>
					<th>生产计划量 </th>
					<th>本期利润</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="producerRecords" var="g">
					<tr>
						<td>${g.times}</td>
						<td><fmt:formatNumber value="${g.thisTimeBuy}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.allNeed}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.actualSale}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.allOwe}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.delayCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.beginGoods}" pattern="0" />
						</td>
						<td><fmt:formatNumber value="${g.receiveGoods}" pattern="0" />
						</td>
						
						
						<td><fmt:formatNumber value="${g.endGoods}" pattern="0" /></td>
						<td><fmt:formatNumber value="${g.storageCost}" pattern="0.00" />
						</td>
						<td><fmt:formatNumber value="${g.orderGoods}" pattern="0" />
						</td>
						
						<td><fmt:formatNumber value="${g.thisTimeProfit}"
								pattern="0.00" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	</div>
</body>

</html>


