<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<fmt:setBundle basename="messages.common" />
<fmt:message var="title" key="mypage.configTitle"/>

<layout:main siteTitle="${title}">
	<form name="configFrm" method="post" action="${action}" autocomplete="off" target="ifrmProcess">
		<dl>
			<dt><fmt:message key="userId"/></dt>
			<dd>
				<input type="text" name="userId" value="${sessionScope.member.userId}" disabled/>
				아이디는 변경할 수 없습니다
			</dd>
		</dl>
		<dl>
			<dt><fmt:message key="mypage.userPw"/></dt>
			<dd>
				<input type="text" name="userPw"/>
			</dd>
		</dl>
		<dl>
			<dt><fmt:message key="mypage.newUserPw"/></dt>
			<dd>
				<input type="text" name="newUserPw"/>
			</dd>
		</dl>
		<dl>
			<dt><fmt:message key="mypage.newUserPwRe"/></dt>
			<dd>
				<input type="text" name="newUserPwRe"/>
			</dd>
		</dl>
		<dl>
			<dt><fmt:message key="userNm"/></dt>
			<dd>
				<input type="text" name="userNm"/>
			</dd>
		</dl>
		<dl>
			<dt><fmt:message key="mobile"/></dt>
			<dd>
				<input type="text" name="mobile"/>
			</dd>
		</dl>
		
		<div class='btns'>
			<button type="reset">
				<fmt:message key="reset"/>
			</button>
			<button type="submit">
				<fmt:message key="mypage.config"/>
			</button>
		</div>
		
	</form>
</layout:main>