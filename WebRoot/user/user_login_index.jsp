<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Laughing-beer - 用户登陆</title>

<%@taglib uri="/struts-tags" prefix="s"%>
</head>
<body>

	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index">首页</a> <span class="divider">/</span>
			</li>
			<li class="active">用户登陆</li>
		</ul>
		<hr class="soften">
		<div class="container-fluid">
			<div class="row-fluid">

				<div class="span3">
					<ul class="nav nav-tabs nav-stacked">
						<li><s:a action="user_register_index">用户注册</s:a>
						</li>
						<li class="active"><s:a href="">用户登陆</s:a>
						</li>
						<li><s:a href="">找回密码</s:a>
						</li>
					</ul>
				</div>

				<div class="span3 offset2">
					<hr class="soften">
					<s:form name="loginForm" action="user_login_process">
						<s:textfield label="用户名" name="username" />
						<s:password label="密码" name="password" />
						<s:checkbox label="记住密码" name="remember" />
						<s:submit value="登陆" cssClass="btn btn-primary" />
					</s:form>
				</div>
			</div>
		</div>

	</div>



</body>

</html>


