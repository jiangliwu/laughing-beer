<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		String recordKey = request.getParameter("key");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);

		String ret = null;
		if (gameInformation != null) {
			ret = gameInformation.get(recordKey).toString();
		}
		if (ret != null)
			out.println(")))" + ret + ")))");
		else
			out.println(")))" + ret + ")))");
	%>
</div>