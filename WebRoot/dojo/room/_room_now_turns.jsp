<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
				
		Integer  now_turns = null;
		if (gameInformation != null) {
			 now_turns = (Integer)gameInformation.get("now_turns");
		}
		if(now_turns != null)
			out.println(","+ now_turns + ",");
		else out.println(",null,");
	%>
</div>