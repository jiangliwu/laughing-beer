<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
				
		List retail = null;
		List wholesale = null;
		List producer = null;
		Integer retailNumber = null;
		Integer wholesaleNumber = null;
		Integer producerNumber = null;
		String holder = null;
		Boolean  start = null;
		if (gameInformation != null) {
			 retail = (List) gameInformation.get("retail");
			 wholesale = (List) gameInformation.get("wholesale");
			 producer = (List) gameInformation.get("producer");

			 retailNumber = (Integer) gameInformation
					.get("retailNumber");
			 wholesaleNumber = (Integer) gameInformation
					.get("wholesaleNumber");
			 producerNumber = (Integer) gameInformation
					.get("producerNumber");

			 holder = (String) gameInformation.get("holder");
			 start = (Boolean)gameInformation.get("start");
		}
	%>

	<table class="table">
		<thead>
			<tr>
				<th>身份</th>
				<th>用户名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<%
			if (retail != null && wholesale != null && producer != null
					&& retailNumber != null && wholesaleNumber != null
					&& producerNumber != null && holder != null)
			{
			
			%>
			
			
			<!-- 零售商 -->
			<%
				for (int i = 0; i < retailNumber; i++) {
					if (retail.size() > i) {
			%>
			<tr>
				<td>零售商<%=i%></td>
				<td><%=retail.get(i)%></td>
				<td>
					<%
						if (retail.get(i).equals(session.getAttribute("username"))) {
									%>
									<form action="game_exit" namespace="/">
										<input  type="hidden" name="id" value="<%= request.getParameter("id") %>">
										<s:submit cssClass="btn btn-danger" value="退出房间"></s:submit>
									</form>
									<%
								} else {
									%>
									<s:form action="" namespace="/">
										<s:submit cssClass="btn btn-info" value="查看"></s:submit>
									</s:form>
									<%
								}
					%>
				</td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td>零售商<%=i%></td>
				<td>空闲</td>
				<td>
				
				<form action="game_switch" method="post">
					<input type="hidden" name="identify" value="retail">
					<input type="hidden" name="position" value="<%=i%>">
					<input type="hidden" name="key" value="<%=applicationDataKey%>">
					<input type="submit" class="btn btn-warning" value="移动到此"> 
				</form>
				</td>
			</tr>
			<%
				}
			}
			
			%>
			
			
			
			
			
			<!-- 批发商 -->
			
			
			<%
				for (int i = 0; i < wholesaleNumber; i++) {
					if (wholesale.size() > i) {
			%>
			<tr>
				<td>批发商<%=i%></td>
				<td><%=wholesale.get(i)%></td>
				<td>
					<%
						if (wholesale.get(i).equals(session.getAttribute("username"))) {
									%>
									<form action="game_exit" namespace="/">
										<input  type="hidden" name="id" value="<%= request.getParameter("id") %>">
										<s:submit cssClass="btn btn-danger" value="退出房间"></s:submit>
									<form>
									<%
								} else {
									%>
									<s:form action="" namespace="/">
										<s:submit cssClass="btn btn-info" value="查看"></s:submit>
									</s:form>
									<%
								}
					%>
				</td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td>批发商<%=i%></td>
				<td>空闲</td>
				<td>
				
				<form action="game_switch" method="post">
					<input type="hidden" name="identify" value="wholesale">
					<input type="hidden" name="position" value="<%=i%>">
					<input type="hidden" name="key" value="<%=applicationDataKey%>">
					<input type="submit" class="btn btn-warning" value="移动到此"> 
				</form>
				</td>
			</tr>
			<%
				}
			}
			
			%>
			
			
			
			
			
			<%
				for (int i = 0; i < producerNumber; i++) {
					if (producer.size() > i) {
			%>
			<tr>
				<td>生产商<%=i%></td>
				<td><%=producer.get(i)%></td>
				<td>
					<%
						if (producer.get(i).equals(session.getAttribute("username"))) {
									%>
									<form action="game_exit" namespace="/">
										<input  type="hidden" name="id" value="<%= request.getParameter("id") %>">
										<s:submit cssClass="btn btn-danger" value="退出房间"></s:submit>
									<form>
									<%
								} else {
									%>
									<s:form action="" namespace="/">
										<s:submit cssClass="btn btn-info" value="查看"></s:submit>
									</s:form>
									<%
								}
					%>
				</td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td>批发商<%=i%></td>
				<td>空闲</td>
				<td>
							
							
				<form action="game_switch" method="post">
					<input type="hidden" name="identify" value="producer">
					<input type="hidden" name="position" value="<%=i%>">
					<input type="hidden" name="key" value="<%=applicationDataKey%>">
					<input type="submit" class="btn btn-warning" value="移动到此"> 
				</form>
				</td>
			</tr>
			<%
				}
			}
			
			
			
			%>
		
		</tbody>
			
	</table>
	
	
	
	

	<%
	if(start)
	{
		%>		
		<%	
	}

		if (session.getAttribute("username").equals(holder)) {
		%>		
				<%
		if(retail.size() == retailNumber && wholesale.size() == wholesaleNumber && producer.size() == producerNumber)
		{
		%>
				<form action="game_start" method="post" id="startform" name="startform">
				<input  type="hidden" name="id" value="<%= request.getParameter("id") %>">
				<div class="form-actions">
					<button type="button" id="start-button" class="btn btn-primary offset3" onclick="go()">开始游戏</button>
				</div>
				<script type="text/javascript">
					function go()
					{
						window.location.href="game_start?id=" + <%=request.getParameter("id")%>;
					}
				</script>
				</form>
				
		<%
		}}
		else {
			%>
			
			
		<%} %>
	<%
		}
	%>
	

</div>