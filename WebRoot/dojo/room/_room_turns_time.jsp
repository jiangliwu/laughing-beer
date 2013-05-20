<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
		Integer  time = null;
		if (gameInformation != null) {
			 time = (Integer)gameInformation.get("time");
		}
		if(time != null)
			out.println(","+ time + ",");
		else out.println(",null,");
	%>
</div>