

<%@taglib uri="/struts-tags"  prefix="s"%>
  <body>
    <div class="container">
	<div class="hero-unit">
	<h1>欢迎您!</h1>
		<s:property value="user.username"/> 
		<a href="#">点击这里回来原来的页面</a>
	</div>
	</div>
  </body>