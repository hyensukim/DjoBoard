<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<c:url var="action" value="/admin/board/config"/>
<layout:admin>
	<div class="config_tit">
		<c:if test="${empty boardConfig}">
			게시판 설정 등록
		</c:if>
		<c:if test="${!empty boardConfig}">
			[${boardConfig.boardId}(${boardConfig.boardNm})] 설정 수정
		</c:if>
	</div>
	
	<form name="saveConfig" method="post" action="${action}" target="ifrmProcess" autocomplete="off">
		<table class="table_cols">
		
			<tr>
				<th>게시판 아이디</th>
				<td>
					<c:if test="${boardConfig.boardId == null}">
						<input type="text" name="boardId" >
					</c:if>
					<c:if test="${boardConfig.boardId != null }">
						<!-- 게시판 아이디가 있는 경우 
								게시판 아이디명을 보여준다.
						-->
						<input type="hidden" name="boardId" value="${boardConfig.boardId }">
						${boardConfig.boardId}
					</c:if>
				</td>
			</tr>
			
			<tr>
				<th>게시판 이름</th>
				<td>
					<c:if test="${boardConfig.boardNm == null }">
						<input type="text" name="boardNm">
					</c:if>
					<c:if test="${boardConfig.boardNm != null }">
						<input type="hidden" name="boardNm" value="${boardConfig.boardNm }">
						${boardConfig.boardNm }
					</c:if>
				</td>
			</tr>
			
			<tr>
				<th>사용여부</th>
				<td>
					<input type="radio" name="useConfig" value="1"  id="useConfig_1" ${boardConfig != null && boardConfig.useConfig ==true? " checked" : ""}>
					<label for="useConfig_1">사용</label>
					<input type="radio" name="useConfig" value="0" id="useConfig_0" ${boardConfig != null && boardConfig.useConfig ==true? "" : " checked"} >
					<label for="useConfig_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>위지윅 에디터</th>
				<td>
					<input type="radio" name="useEditor" value="1" id="useEditor_1"${boardConfig != null && boardConfig.useEditor ==true? " checked" : ""}>
					<label for="useEditor_1">사용</label>
					<input type="radio" name="useEditor" value="0" id="useEditor_0" ${boardConfig != null && boardConfig.useEditor ==true? "" : "checked"}>
					<label for="useEditor_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>댓글 사용 여부</th>
				<td>
					<input type="radio" name="useComment" value="1" id="useComment_1"${boardConfig != null && boardConfig.useComment ==true? " checked" : ""}>
					<label for="useComment_1">사용</label>
					<input type="radio" name="useComment" value="0" id="useComment_0" ${boardConfig != null && boardConfig.useComment ==true? "" : "checked"}>
					<label for="useComment_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>파일 첨부</th>
				<td>
					<input type="checkbox" name="useAttach" value="basic" id="basic" ${boardConfig != null && boardConfig.useAttach.indexOf("basic") != -1 ? " checked" : ""}>
					<label >일반파일</label>
					<input type="checkbox" name="useAttach" value="image" id="image"${boardConfig != null && boardConfig.useAttach.indexOf("image") != -1 ? " checked" : ""}>
					<label>이미지파일</label>
				</td>
			</tr>
			
			<tr>
				<th>한페이지 게시글 갯수</th>
				<td>
					<input type="number" name="boardIndex" value="${boardConfig.boardIndex }"/>
				</td>
			</tr>
			<tr>
				<th>페이지 구간 갯수</th>
				<td>
					<input type="number" name="boardPageIndex" value="${boardConfig.boardPageIndex }"/>
				</td>
			</tr>
			<tr>
				<th>게시판 상단 베너</th>
				<td>
					<textarea name="topHtml">${boardConfig.topHtml }</textarea>
				</td>
			</tr>
			<tr>
				<th>게시판 하단 베너</th>
				<td>
					<textarea name="bottomHtml">${boardConfig.bottomHtml}</textarea>
				</td>
			</tr>
		</table>
		<div class="button">
			<button type="reset">다시입력</button>
			<button type="submit">등록하기</button>
		</div>
	</form>
</layout:admin>