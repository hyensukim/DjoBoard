<%@ tag pageEncoding="UTF-8" %>
<%@ tag body-content="scriptless" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="siteTitle" %>

<fmt:setBundle basename="messages.common" />
<fmt:message var="title" key="homepageName"/>
<layout:common siteTitle="${title}">
<jsp:attribute name="header">
	<section id="site_top">
		<div class='left'>
			<a href="<c:url value='/' />">HOME</a>
		</div>
		
		<div class='title'>
			<a href="<c:url value="/"/>">
				${title}
			</a>
		</div>
		
		
		<div class='right'>
			<c:if test="${isLogin}">
				<fmt:message key="member.login.status">
					<fmt:param value="${sessionScope.member.userNm}" />
					<fmt:param value="${sessionScope.member.userId}" />
				</fmt:message>
				<a href="<c:url value='/mypage'/>">
					<fmt:message key="mypage.mypageTitle"/>	<!-- 내 프로필 url 삽입 -->
				</a>
				<a href="<c:url value='/member/logout' />">	<!-- 로그아웃 페이지 url 삽입 -->
					<fmt:message key="member.logout" />
				</a>
				<c:if test="${isAdmin}">
					<a href="<c:url value='/admin'/>"><i class='xi-cog'></i>게시판 관리</a> <!-- 관리자 페이지 url 삽입 -->
				</c:if>
			</c:if>
			<c:if test="${!isLogin}">
				<a href="<c:url value='/member/login' />">	<!-- 로그인 페이지 url 삽입 -->
					<fmt:message key="member.login" />
				</a>
				<a href="<c:url value='/member/join' />"> 	<!-- 회원가입 페이지 url 삽입 -->
					<fmt:message key="member.jointitle" />
				</a>
			</c:if>
		</div>
	</section>
	
	
	
</jsp:attribute>

<jsp:attribute name="footer">
	<h2>&copy;Copyright IT KOREA D조 </h2>
</jsp:attribute>

<jsp:body>
	<nav>
		<div class='layout_width'>
			<a href='#'>게시판 목록</a> <!-- 게시판 목록 페이지 경로 삽입 -->
		</div>
	</nav>
	<h1>${siteTitle}</h1>
	<jsp:doBody />
</jsp:body>

</layout:common>

