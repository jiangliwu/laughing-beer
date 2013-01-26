<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div class="thumbnail">

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
		List message = null;
		if (gameInformation != null) {
			message = (List) gameInformation.get("message");
			if (message != null) {
				for (int i = 0; i < message.size(); i++) {
					out.print("<p>"+message.get(i) + "</p>");
				}
			}
		}
	%>
</div>