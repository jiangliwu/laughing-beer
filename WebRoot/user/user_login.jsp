<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"
	import="com.opensymphony.xwork2.ActionContext,java.util.*"%>
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
						<li><s:a action="user_register!registerIndex">用户注册</s:a>
						</li>
						<li class="active"><s:a href="">用户登陆</s:a>
						</li>
						<li><s:a href="">找回密码</s:a>
						</li>
					</ul>
				</div>

				<div class="span8">
					<h3 class="offset3">用户登录</h3>
					<hr class="soften offset2">
					
					<s:if test=" errors.size() !=0 ">
						<s:iterator value="errors">
							<div class="alert alert-error offset2">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<s:property value="value" />
							</div>
						</s:iterator>
					</s:if>



					<s:form cssClass="form-horizontal" name="loginForm"
						action="user_login" namespace="/">
						<div class="control-group">
							<label class="control-label" for="username">用户名</label>
							<div class="controls">
								<s:textfield name="username" id="username"
									placeholder="请输入你的用户名" onblur=""></s:textfield>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="password">密码</label>
							<div class="controls">
								<s:textfield type="password" id="password" name="password"
									placeholder="请输入你的密码" onblur=""></s:textfield>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<label class="checkbox"> <s:checkbox name="remember" value="a">记住密码</s:checkbox>
									</label>
								<button type="submit" class="btn">登录</button>
							</div>
						</div>
					</s:form>


				</div>
			</div>
		</div>

	</div>



</body>

</html>


