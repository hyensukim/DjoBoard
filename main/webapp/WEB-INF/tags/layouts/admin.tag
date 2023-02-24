<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="scriptless"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="siteTitle"  %>
<c:url var="adminMain" value="/admin/main.jsp" />
<c:url var="boardList" value="/admin/board/index.jsp" />
<c:url var="boardConfig" value="/admin/board/config.jsp"/>
<fmt:setBundle basename="messages.common"/>
<layout:common siteTitle="${siteTitle }" isAdmin="true">
	<jsp:attribute name="header">
		<div class="admin_menu">
			<a href="${boardList}" class="menu${menuCode == 'boardList' ? ' on' : ''} }">
				<i class="xi-list"></i><fmt:message key="admin.board.index"/>
			</a>
			<a href="${boardConfig}" class="menu${menuCode == 'boardRegister' ? ' on' : ''}">
				<i class="xi-plus"></i><fmt:message key="admin.board.config"/>
			</a>
		</div>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<h2>copy@write...</h2>
	</jsp:attribute>
	<jsp:body>
		<jsp:doBody/>
	</jsp:body>
</layout:common>