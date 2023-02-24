<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="scriptless"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="siteTitle"  type="java.lang.String"%>

<!DOCTYPE html>
<html>
	<head>
		<c:if test="${!empty siteTitle}">
			<title>${siteTitle }</title>
		</c:if>
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>"/>
		<c:if test="${!empty addCss }">
			<c:forEach var="cssFile" items="${addCss }">
				<link rel="stylesheet" type="text/css" href="<c:url value='/css/'/>${cssFile}.css"/>
			</c:forEach>
		</c:if>
		<script src="<c:url value='/js/common.js'/> " ></script>
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