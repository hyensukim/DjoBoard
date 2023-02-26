<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<fmt:setBundle basename="messages.common" />
<fmt:message var="title" key="mypage.mypageTitle"/>

<layout:main siteTitle="${title}">

	<button type="button" onClick="location.href='<c:url value='/mypage/config' />'">수정하기</button>
</layout:main>