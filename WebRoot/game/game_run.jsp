<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Laughing-beer - 用户登陆</title>

<%@taglib uri="/struts-tags" prefix="s"%>
</head>
<body>

	<div class="container">
	
	
	<h3>正在进行的游戏</h3>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>游戏ID</th>
					<th>游戏标题</th>
					<th>游戏人数</th>
					<th>游戏轮数</th>
				
				</tr>
			</thead>
			<tbody>
				<s:iterator value="games" var="g">
					<tr>
						<td>${g.gameId}</td>
						<td>${g.gameTitle}</td>
						<td>${g.retailNumber + g.wholesaleNumber + g.producerNumber}</td>
						<td>${g.allTimes}</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>



</body>

</html>


