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
			<li><a href="index">首页</a> <span class="divider">/</span></li>
			<li class="active">游戏大厅</li>
		</ul>
		<form class="form-search">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按房间标题进行搜索
			<div class="input-append">
				<input type="text" class="span2 search-query">
				<button type="submit" class="btn">Search</button>
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
									<td>${g.retailNumber+g.wholesaleNumber + g.producerNumber}</td>
								</tr>
								<tr>
									<td>实际人数</td>
									<td>
										<s:url id="urlRetailNumber" value="dojo/hall/_retail.jsp" >
											<s:param name="id" >${g.gameId}</s:param>
										</s:url>
										<sx:div updateFreq="1500" href="%{#urlRetailNumber}" errorText="信息加载中" ></sx:div>
									</td>
									<td>
										<s:url id="urlWholesaleNumber" value="dojo/hall/_wholesale.jsp" >
											<s:param name="id" >${g.gameId}</s:param>
										</s:url>
										<sx:div updateFreq="1500" href="%{#urlWholesaleNumber}" errorText="信息加载中" ></sx:div>
									</td>
									
									<td><s:url id="urlProducerNumber" value="dojo/hall/_producer.jsp" >
											<s:param name="id" >${g.gameId}</s:param>
										</s:url>
										<sx:div updateFreq="1500" href="%{#urlProducerNumber}" errorText="信息加载中" ></sx:div>
										</td>
										
									<td><s:url id="urlTotalNumber" value="dojo/hall/_total.jsp" >
											<s:param name="id" >${g.gameId}</s:param>
										</s:url>
										<sx:div updateFreq="1500" href="%{#urlTotalNumber}" errorText="信息加载中" ></sx:div>
									</td>
								</tr>
							</tbody>
						</table>
					
						<form action="game_wait!index">
						<input type="hidden" name="id" value=${g.gameId}>
						<button type="submit" class="btn btn-primary offset9">加入游戏</button>
						</form>
					</div>
				</s:iterator>
	</div>
				<div class="span3 offset1">

					<ul class="nav nav-tabs nav-stacked">
						<li><s:a action="user_register!registerIndex">创建游戏</s:a>
						</li>

						<li><s:a action="user_register!registerIndex">进行中的游戏</s:a>
						</li>
						<li class="active"><s:a href="">等待中的游戏</s:a>
						</li>
						<li><s:a href="">我创建的游戏</s:a>
						</li>
						<li><s:a action="user_register!registerIndex">进行中的游戏</s:a>
						</li>
					</ul>

				</div>
			</div>
		</div>
	</div>



</body>

</html>


