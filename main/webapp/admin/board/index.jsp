<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<layout:admin>
	<div class="search_box">
		<form name="configSearch" method="get"  autocomplete="off"> 
			<table class="searchBoard">
				<tr>
				<th>검색창</th>
				<td>
					<select class="sopt" name="sopt">
						<option value="all">통합 검색</option>
						<option value="id">게시판 ID</option>
						<option value="name">게시판 이름</option>
					</select>
					<input type="text" name="skey" id="skey">
				</td>
			</tr>
			</table>
		</form>
		<div class="button">
			<button type="submit" > 검색하기 </button>
		</div>
	</div>
	<div class="content_box">
		
	
	
	</div>
</layout:admin>