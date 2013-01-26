<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String applicationDataKey = "room" + request.getParameter("id");
	Map gameInformation = (Map) application
			.getAttribute(applicationDataKey);
	List retail = null;
	if (gameInformation != null) {
		retail = (List) gameInformation.get("retail");
		if (retail != null)
			out.print(retail.size());
	}
%>