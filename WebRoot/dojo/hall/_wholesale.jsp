<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String applicationDataKey = "room" + request.getParameter("id");
	Map gameInformation = (Map) application
			.getAttribute(applicationDataKey);
	List wholesale = null;
	if (gameInformation != null) {
		wholesale = (List) gameInformation.get("wholesale");
		if (wholesale != null)
			out.print(wholesale.size());
	}
%>