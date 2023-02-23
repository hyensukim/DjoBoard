<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%
	int status = response.getStatus();
	String message = null;
	switch(status){
	case HttpServletResponse.SC_BAD_REQUEST:
		message = "잘못된 요청입니다"; break;
	case HttpServletResponse.SC_NOT_FOUND:
		message="없는 페이지 입니다"; break;
	}

	if(message==null){
		pageContext.setAttribute("message", message);
	}
%>
<layout:main>
	${message }
</layout:main>