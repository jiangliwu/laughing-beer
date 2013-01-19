<!DOCTYPE title PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"
	import="com.opensymphony.xwork2.ActionContext,java.util.*"%>
<html>
<head>
<title>Laughing-beer - 用户注册</title>

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
						<li class="active"><s:a action="user_register!registerIndex">用户注册</s:a>
						</li>
						<li><a href="user/user_login.jsp">用户登录</a>
						</li>
						<li><s:a href="">找回密码</s:a>
						</li>
					</ul>
				</div>


				<div class="span8">
					<h3 class="offset2">注册用户</h3>

					</br> </br> <strong class="offset2">必填信息</strong>
					<hr class="soften offset2">
					<s:if test=" errors.size() !=0 ">
						<s:iterator value="errors">
							<div class="alert alert-error offset2">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<s:property value="value" />
							</div>
						</s:iterator>
					</s:if>
					<s:form cssClass="form-horizontal" action="user_register!register">

						<div class="control-group" id="username_input">
							<label class="control-label" for="username"> 用户名</label>
							<div class="controls">
								<s:textfield id="username" name="user.username"
									onblur="checkUsername(this,'username_input')" />
								<span class="help-inline" style="display:none"
									id="username_hint">请输入合法的用户名</span>
							</div>

						</div>
						<div class="control-group" id="password1_input">
							<label class="control-label" for="password"> 用户密码</label>
							<div class="controls">
								<s:password id="password" name="user.password"
									onblur="checkPassword1(this)" />
								<span class="help-inline" style="display:none"
									id="password1_hint">请输入合法的密码</span>
							</div>
						</div>

						<div class="control-group" id="password2_input">
							<label class="control-label" for="password2"> 确认密码</label>
							<div class="controls">
								<s:password id="password2" name="password2"
									onblur="checkPassword2(this)" />
								<span class="help-inline" style="display:none"
									id="password2_hint">两次密码不一致</span>
							</div>

						</div>
						<div class="control-group" id="">
							<label class="control-label" for="studentid">学生学号</label>
							<div class="controls">
								<s:textfield id="studentid" name="user.studentId" />

							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="studentid">性别</label>
							<div class="controls">
								<s:select list="{'男','女'}" headerKey="-1" headerValue="请选择你的性别"
									name="user.gender"></s:select>
							</div>
						</div>

						<div class="form-actions offset1">
							<button type="submit" class="btn btn-primary">注册</button>

						</div>

					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>


