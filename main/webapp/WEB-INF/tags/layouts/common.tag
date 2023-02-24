<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="scriptless"%>
<%@tag trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="isAdmin" type="java.lang.Boolean" %>
<%@attribute name="siteTitle"  type="java.lang.String"%>
<c:url var="commonCss" value="${isAdmin==null? '/css/style.css' : '/css/admin/style.css' }"/>
<c:url var="commonJs" value="${isAdmin==null? '/js/common.js' : '/js/admin/common.js' }"/>

<!DOCTYPE html>
<html>
	<head>
		<c:if test="${!empty siteTitle}">
			<title>${siteTitle }</title>
		</c:if>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css"/>
		<link rel="stylesheet" type="text/css" href="${commonCss}"/>
		<c:if test="${!empty addCss }">
			<c:forEach var="cssFile" items="${addCss }">
				<link rel="stylesheet" type="text/css" href="<c:url value='/css/'/>${cssFile}.css"/>
			</c:forEach>
		</c:if>
		<script src="${commonJs}" ></script>
			<c:if test="${! empty addScript}">
				<c:forEach var="jsFile" items="${addScript} ">
					<script src="<c:url value='/js/'/>${jsFile}.js"></script>
				</c:forEach>
			</c:if>
	</head>
	<body>
		<header>
			<div>
				<jsp:invoke fragment="header"/> 
			</div>
		</header>
		<main>
			<jsp:doBody/>
		</main>
		<footer>
			<jsp:invoke fragment="footer"/>
		</footer>
		<iframe name="ifrmProcess" class="dn"></iframe>
	</body>
</html>