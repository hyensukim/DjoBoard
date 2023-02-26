<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<fmt:setBundle basename="messages.common" />
<fmt:message var="title" key="mainTitle"/>

<layout:main siteTitle="${title}">

</layout:main>