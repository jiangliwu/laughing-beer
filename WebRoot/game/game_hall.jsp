<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"
	import="com.opensymphony.xwork2.ActionContext,java.util.*"%>
<html>
<head>
<title>Laughing-beer - 游戏大厅</title>
<%@taglib uri="/struts-tags" prefix="s"%>
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



					<div class="game-room">
						<div class="game-room-little">房间号:61532</div>
						<p>房间标题 ： 啤酒游戏小组1</p>
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
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>3</td>
								</tr>
								<tr>
									<td>实际人数</td>
									<td>1</td>
									<td>1</td>
									<td>0</td>
									<td>2</td>
								</tr>
							</tbody>
						</table>
						<button type="submit" class="btn btn-primary offset9">加入游戏</button>
					</div>



					<div class="game-room">
						<div class="game-room-little">房间号:61532</div>
						<p>房间标题 ： 啤酒游戏小组1</p>
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
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>3</td>
								</tr>
								<tr>
									<td>实际人数</td>
									<td>1</td>
									<td>1</td>
									<td>0</td>
									<td>2</td>
								</tr>
							</tbody>
						</table>
						<button type="submit" class="btn btn-primary offset9">加入游戏</button>
					</div>
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


