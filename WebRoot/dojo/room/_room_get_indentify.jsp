<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<div>

	<%
		String applicationDataKey = "room" + request.getParameter("id");
		Map gameInformation = (Map) application
				.getAttribute(applicationDataKey);
		String username = (String)session.getAttribute("username");
		if (gameInformation != null && username != null) {
			String indentify = "未知身份";

			List<String> retail = (List<String>) gameInformation
					.get("retail");
			List<String> wholesale = (List<String>) gameInformation
					.get("wholesale");
			List<String> producer = (List<String>) gameInformation
					.get("producer");

			if (retail != null) {
				Iterator<String> it = retail.iterator();
				while (it.hasNext()) {
					String name = it.next();
					if (name.equals(username))
						indentify = "零售商";
				}
			}
			if (wholesale != null) {
				Iterator<String> it = wholesale.iterator();
				while (it.hasNext()) {
					String name = it.next();
					if (name.equals(username))
						indentify = "批发商";
				}
			}
			if (producer != null) {
				Iterator<String> it = producer.iterator();
				while (it.hasNext()) {
					String name = it.next();
					if (name.equals(username))
						indentify = "生产商";
				}
			}

			out.print("," + indentify + ",");

		}
	%>
</div>