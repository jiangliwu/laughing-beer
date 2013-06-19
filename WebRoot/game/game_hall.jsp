<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"
	import="com.opensymphony.xwork2.ActionContext,java.util.*"%>
<html>
<head>
<title>Laughing-beer - 游戏大厅</title>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
</head>
<body>



	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index">首页</a> <span class="divider">/</span>
			</li>
			<li class="active">游戏大厅</li>
		</ul>
						
		<form class="form-search" action="game_wait!index">
			按房间号进入房间
			<div class="input-append">
				<input type="text" name="id" class="span2 search-query">
				<button type="submit" class="btn">点击进入</button>
			</div>
		</form>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span8">
					<s:iterator value="games" var="g">
						<div class="game-room">
							<div class="game-room-little">房间号:${g.gameId}</div>
							<p>房间标题 ： ${g.gameTitle}</p>
							<table class="table">
								<thead>
									<tr>
										<th>#</th>
										<th>零售商</th>
										<th>批发商</th>
										<th>生产商</th>
										<th>总人数</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>需求人数</td>
										<td>${g.retailNumber}</td>
										<td>${g.wholesaleNumber}</td>
										<td>${g.producerNumber}</td>
										<td>${g.retailNumber+g.wholesaleNumber +
											g.producerNumber}</td>
									</tr>

									<tr>
										<td>实际人数</td>
										<td>
											<div id="${g.gameId}person-0"></div></td>
										<td>
											<div id="${g.gameId}person-1"></div></td>
										<td>
											<div id="${g.gameId}person-2"></div></td>
										<td>
											<div id="${g.gameId}person-sum"></div></td>
									</tr>
								</tbody>
							</table>

							<div id="${g.gameId}room-id" style="display:none;">${g.gameId}</div>
							<script type="text/javascript">
								window
										.setInterval(
												function() {
													var roomid = document
															.getElementById("${g.gameId}room-id").innerHTML;
													var linkAjax = "dojo/hall/_total.jsp?id="
															+ roomid
															+ "&cache="
															+ new Date()
																	.getTime();
													$
															.ajax({
																type : "GET",
																url : linkAjax,
																success : function(
																		data) {
																	var numbers = data
																			.split(",");
																	var sum = 0;
																	for ( var i = 0; i < numbers.length; i++) {
																		sum += parseInt(numbers[i]);
																		var tag = "${g.gameId}person-"
																				+ i;
																		document
																				.getElementById(tag).innerHTML = numbers[i];
																	}
																	document
																			.getElementById("${g.gameId}person-sum").innerHTML = sum;
																}
															});
												}, 1000);
							</script>



							<form action="game_wait!index">
								<input type="hidden" name="id" value=${g.gameId}>
								<button type="submit" class="btn btn-primary offset9">加入游戏</button>
							</form>
						</div>
					</s:iterator>
				</div>
				<div class="span3 offset1">

					<ul class="nav nav-tabs nav-stacked">
						<li><s:a action="game_create!index">创建游戏</s:a></li>
						<li><s:a action="game_hall!runing">进行中的游戏</s:a></li>
						<li class="active"><s:a action="game_hall">等待中的游戏</s:a></li>
						<li><s:a action="game_hall!mygame">我参与的游戏</s:a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>



</body>

</html>


