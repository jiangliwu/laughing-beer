<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String applicationDataKey = "room" + request.getParameter("id");
	Map gameInformation = (Map) application
			.getAttribute(applicationDataKey);
	List producer = null;
	if (gameInformation != null) {
		producer = (List) gameInformation.get("producer");
		if (producer != null)
			out.print(producer.size());
	}
%>