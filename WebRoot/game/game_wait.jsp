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
			<li class="active"><div id="roomid">房间:${id}</div>
			</li>
		</ul>
		<div class="span7">
			<div id="user-list"></div>
		</div>

		<div class="span4">
			<div id="user-message"></div>
		</div>
	</div>
	
	<script type="text/javascript">
	window.setInterval(getTable,2000);
	window.setInterval(getMessage,2000);
	window.setInterval(getStartResult,2000);
	function getTable()
	{
		var id = <%= request.getParameter("id") %>;
		var linkAjax = "dojo/_room.jsp?id="+id+"&cache="+new Date().getTime();
		   $.ajax({
			   type:"GET", 
			   url:linkAjax,             
			   success:function(data){
			   		$("#user-list").html(decodeURI(data));
			   }
		   });
	}
	
	function getMessage()
	{
		var id = <%= request.getParameter("id") %>;
		var linkAjax = "dojo/_message.jsp?id="+id+"&cache="+new Date().getTime();
		   $.ajax({
			   type:"GET", 
			   url:linkAjax,             
			   success:function(data){
			   		$("#user-message").html(decodeURI(data));
			   }
		   });
	}
	function getStartResult()
	{		
		var id = <%= request.getParameter("id") %>;
		var linkGoto = "game_start?id="+id;
		var linkAjax =  "dojo/room/_room_is_start.jsp?id="+id+"&cache="+new Date().getTime();
		   $.ajax({
			   type:"GET", 
			   
			   
			   url:linkAjax,             
			   success:function(data){
			   		var returnValue = data.split(",")[1];
					if(returnValue == "true")
						window.location.href = linkGoto;
			   }
		   });
	}
	
	</script>

</body>

</html>


