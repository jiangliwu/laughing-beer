<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setCharacterEncoding("utf-8");
%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta name="description"
	content="Struts2 Showcase for Apache Struts Project">
<meta name="author" content="The Apache Software Foundation">

<title><decorator:title default="laughing-beer" />
</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="<s:url value='assets/css/bootstrap.css' encode='false' includeParams='none'/>"
	rel="stylesheet" type="text/css" media="all">
<link
	href="<s:url value='assets/css/bootstrap-responsive.css' encode='false' includeParams='none'/>"
	rel="stylesheet" type="text/css" media="all">
<link
	href="<s:url value='assets/css/main.css' encode='false' includeParams='none'/>"
	rel="stylesheet" type="text/css" media="all" />

<script
	src="<s:url value='assets/js/jquery-1.8.2.min.js' encode='false' includeParams='none'/>"></script>
	<script
	src="<s:url value='assets/js/application.js' encode='false' includeParams='none'/>"></script>
	
<script
	src="<s:url value='assets/js/tools.js' encode='false' includeParams='none'/>"></script>
<script
	src="<s:url value='assets/js/bootstrap.min.js' encode='false' includeParams='none'/>"></script>
<script type="text/javascript">
	$(function() {
		$('.dropdown-toggle').dropdown();
		var alerts = $('ul.alert').wrap('<div />');
		alerts
				.prepend('<a class="close" data-dismiss="alert" href="#">&times;</a>');
		alerts.alert();
	});
</script>

<!-- Prettify -->
<link
	href="<s:url value='assets/css/prettify.css' encode='false' includeParams='none'/>"
	rel="stylesheet">
<script
	src="<s:url value='assets/js/prettify.js' encode='false' includeParams='none'/>"></script>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<sx:head />
<decorator:head />

</head>

<body id="page-home" onload="prettyPrint();">

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> </a>
				<s:a value="/index.html" cssClass="brand">Laughing-beer</s:a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><s:a value="/index">
								<i class="icon-home"></i> 主页</s:a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">游戏<b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><s:a action="game_hall" includeParams="none">游戏大厅</s:a>
								</li>
								<li><s:a action="game_create!index"
										 includeParams="none">创建游戏</s:a></li>
								<li><s:a action="index" namespace="/config-browser"
										includeParams="none">加入游戏</s:a>
								</li>
								<li><s:a value="/conversion/index.jsp">浏览我的记录</s:a>
								</li>
								<li><s:a value="/person/index.jsp">Person Manager ( by Conventions )</s:a>
								</li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">工具<b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><s:a action="actionChain1!input"
										namespace="/actionchaining" includeParams="none">模拟供应链</s:a></li>
								<li><s:a action="index" namespace="/config-browser"
										includeParams="none">供应链数据分析</s:a>
								</li>
								<li><s:a value="/conversion/index.jsp">浏览我的记录</s:a>
								</li>
								<li><s:a value="/person/index.jsp">Person Manager ( by Conventions )</s:a>
								</li>
							</ul></li>

						<li><a href="">关于</a>
						</li>
					</ul>


					<ul class="nav pull-right">
						<%
							if (request.getSession().getAttribute("username") == null) {
						%>
						<li><s:a action="user_register!registerIndex">用户注册</s:a>
						</li>
						<li><a href="user/user_login.jsp">登陆系统</a>
						</li>
						<%
							} else {
						%>
						<li><s:a action="user_edit">修改资料</s:a>
						</li>
						<li><s:a action="user_logout">退出系统(<%=request.getSession().getAttribute("username")%>)</s:a>
						</li>
						<%
							}
						%>
						<li class="dropdown last"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-book"></i> Wiki<b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="http://struts.apache.org/2.x/docs/home.html"><i
										class="icon-share"></i> 搜索条目</a>
								</li>
								<li><a href="http://struts.apache.org/2.x/docs/home.html"><i
										class="icon-share"></i> 所有条目</a>
								</li>
							</ul></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>


	<decorator:body />

	<hr>

	<div id="footer">
		<div class="container">
			<p class="muted credit">
				Copyright &copy; 2003-2013 <a
					href="http://www.localhost:8080/laughing-beer/"> 供应链 </a>
			</p>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
		</div>
	</div>
</body>
</html>
