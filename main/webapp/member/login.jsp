<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.common" />
<fmt:message var="siteTitle" key="member.logintitle" />
<c:url var="action" value="/member/login" />
<layout:main siteTitle="${siteTitle}">
	<h1>${siteTitle}</h1>
	<form method="post" action="${action}" target="ifrmProcess" autocomplete="off" >
		<dl>
			<dt>
				<fmt:message key="userId" />
			</dt>
			<dd>
				<input type="text" name="userId">
			</dd>		
		</dl>
		<dl>
			<dt>
				<fmt:message key="userPw" />
			</dt>
			<dd>
				<input type="password" name="userPw">
			</dd>	
		</dl>
		<div>
			<input type="checkbox" name="saveId" value="1" id="saveId">
			<label for="saveId">
				<fmt:message key="member.saveId" />
			</label>
		</div>
		<button type="submit">
			<fmt:message key="member.login" />
		</button>
	</form>	
</layout:main>
	
