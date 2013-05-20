<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
				
		Integer  turns = null;
		if (gameInformation != null) {
			 turns = (Integer)gameInformation.get("turns");
		}
		if(turns != null)
			out.println(","+ turns + ",");
		else out.println(",null,");
	%>
</div>