<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<c:url var="action" value="/admin/board/config"/>
<layout:admin>
	<div class="config_tit">
		게시판 설정 등록
	</div>
	<form name="saveConfig" method="post" action="${action}" target="ifrmProcess" autocomplete="off">
		<table class="table_cols">
			<tr>
				<th>게시판 아이디</th>
				<td>
					<input type="text" name="boardId">
				</td>
			</tr>
			
			<tr>
				<th>게시판 이름</th>
				<td>
					<input type="text" name="boardNm">
				</td>
			</tr>
			
			<tr>
				<th>사용여부</th>
				<td>
					<input type="radio" name="useConfig" value="1"  id="useConfig_1"checked>
					<label for="useConfig_1">사용</label>
					<input type="radio" name="useConfig" value="0" id="useConfig_0">
					<label for="useConfig_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>위지윅 에디터</th>
				<td>
					<input type="radio" name="useEditor" value="1" id="useEditor_1">
					<label for="useEditor_1">사용</label>
					<input type="radio" name="useEditor" value="0" id="useEditor_0" checked>
					<label for="useEditor_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>댓글 사용 여부</th>
				<td>
					<input type="radio" name="useComment" value="1" id="useComment_1">
					<label for="useComment_1">사용</label>
					<input type="radio" name="useComment" value="0" id="useComment_0" checked>
					<label for="useComment_0">미사용</label>
				</td>
			</tr>
			
			<tr>
				<th>파일 첨부</th>
				<td>
					<input type="checkbox" name="useAttach" value="basic" id="basic">
					<label >일반파일</label>
					<input type="checkbox" name="useAttach" value="basic" id="image">
					<label>이미지파일</label>
				</td>
			</tr>
			
			<tr>
				<th>한페이지 게시글 갯수</th>
				<td>
					<input type="number" name="boardIndex"/>
				</td>
			</tr>
			<tr>
				<th>페이지 구간 갯수</th>
				<td>
					<input type="number" name="boardPageIndex"/>
				</td>
			</tr>
			<tr>
				<th>게시판 상단 베너</th>
				<td>
					<textarea name="topHtml"></textarea>
				</td>
			</tr>
			<tr>
				<th>게시판 하단 베너</th>
					<td>
					<textarea name="bottomHtml"></textarea>
				</td>
			</tr>
		</table>
		<div class="button">
			<button type="reset">다시입력</button>
			<button type="submit">등록하기</button>
		</div>
	</form>
</layout:admin>