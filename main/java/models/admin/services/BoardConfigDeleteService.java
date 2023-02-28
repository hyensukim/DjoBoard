package models.admin.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ScriptLibrary;
import commons.exception.NotRequiredFieldException;
import commons.validator.CheckRequiredValidator;
import models.admin.BoardConfig;
import models.admin.BoardConfigDao;
import models.admin.exception.BoardConfigException;

public class BoardConfigDeleteService implements CheckRequiredValidator{
	
	private BoardConfigDao boardConfigDao = null;
	
	public BoardConfigDeleteService(BoardConfigDao boardConfigDao) {
		this.boardConfigDao  = boardConfigDao; 
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		/**
		 * 게시판 설정 삭제 기능 구현
		 * 0. 관리자로부터 아이디를 입력받는다.
		 * 1. 관리자가 아이디를 입력해야 한다.
		 * 2. 요청 데이터의 아이디를 DB에서 조회
		 * 3. 조회 성공시 재차 삭제 의사 묻는 메세지 출력.
		 * 4. ok 시 레코드 삭제-> DB 반영
		 * 
		 * 게시판 설정 삭제 기능 구현
		 * 1. 게시판 조회 기능 구현(개별 객체 조회)
		 * 2. 조회된 게시판에 삭제 버튼 추가
		 */
		
		String boardId = request.getParameter("boardId");
		
		//1. 아이디 필수 입력
		checkRequired(boardId, new NotRequiredFieldException("삭제할 게시판 아이디를 입력바랍니다."));
		
		//2~4 요청 아이디를 DB에서 조회 및 DB처리 || 예외발생
		BoardConfig config = boardConfigDao.getConfig(boardId);
		if( config != null ) { // 아이디가 있는경우 -> 삭제
			// 3번 기능 조건문 안 조건식으로 추가 -> 메세지는 ScriptLibrary에 추가
			ScriptLibrary.deleteConfirm(response);
			boardConfigDao.delete(boardId);
		}else {
			throw new BoardConfigException("게시판 설정 삭제에 실패했습니다."); // 예외 발생.
		}
	}// delete E
	
}
