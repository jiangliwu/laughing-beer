<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Laughing-beer - 我参与的游戏</title>

<%@taglib uri="/struts-tags" prefix="s"%>
</head>
<body>


	<div class="container">
	
	<h3>我参与的游戏</h3>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>游戏ID</th>
					<th>游戏标题</th>
					<th>游戏人数</th>
					<th>游戏轮数</th>
					<th>查看记录</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="games" var="g">
					<tr>
						<td>${g.gameId}</td>
						<td>${g.gameTitle}</td>
						<td>${g.retailNumber + g.wholesaleNumber + g.producerNumber}</td>
						<td>${g.allTimes}</td>
						<td><a href="game_show_record?id=${g.gameId}">查看记录</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	
	</div>



</body>

</html>


