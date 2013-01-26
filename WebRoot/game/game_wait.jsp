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
			<li class="active">房间 : ${id}</li>
		</ul>
		
		<div class="span7">
			<s:url id="url" value="dojo/_room.jsp" >
				<s:param name="id" ><s:property value="id"/> </s:param>
			</s:url>
			<sx:div updateFreq="1500" href="%{#url}" errorText="信息加载中" ></sx:div>
		</div>
		
		<div class="span4">
			<s:url id="url2" value="dojo/_message.jsp" >
				<s:param name="id" ><s:property value="id"/> </s:param>
			</s:url>
			<sx:div updateFreq="1500" href="%{#url2}" errorText="信息加载中" ></sx:div>
		</div>
	</div>



</body>

</html>


