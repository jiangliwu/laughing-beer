<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
		Boolean  start = null;
		if (gameInformation != null) {
			 start = (Boolean)gameInformation.get("start");
		}
		if(start != null)
			out.println(","+ start + ",");
		else out.println(",null,");
	%>
</div>