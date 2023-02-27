<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true"%>
<%
	if(exception != null){
		exception.printStackTrace();
		pageContext.setAttribute("message",exception.getMessage());
	}
%>
<c:if test="${executeScript != null }">
	<script>
		alert('${message}');
		history.back();
	</script>
</c:if>
<c:if test="${executeScript == null }">
	<jsp:include page="_errorMessage.jsp"/>
</c:if>