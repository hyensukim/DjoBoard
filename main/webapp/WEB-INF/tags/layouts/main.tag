<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="scriptless"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@attribute name="siteTitle" %>
<layout:common  siteTitle="${siteTitle }">
	<jsp:attribute name="header">
		<h1>헤더</h1>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<h2>copy@write...</h2>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody/>
	</jsp:body>
</layout:common>