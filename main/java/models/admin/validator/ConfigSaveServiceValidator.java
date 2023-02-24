package models.admin.validator;

import commons.exception.NotRequiredFieldException;
import commons.validator.CheckRequiredValidator;
import commons.validator.Validator;
import models.admin.BoardConfig;

public class ConfigSaveServiceValidator implements Validator<BoardConfig>, CheckRequiredValidator{

	@Override
	public void check(BoardConfig boardConfig) { // 상위 인터페이스 미구현 메서드 구현
		/**
		 * 1. 필수데이터 체크 - boardNm, boardId
		 * 2. 기본값 부여
		 * 		- boardIndex : 20
		 * 		- boardPageIndex : 10
		 * 		
		 */
		
		// 1. 필수데이터 체크 S
		String boardId = boardConfig.getBoardId();
		String boardNm = boardConfig.getBoardNm();
		
		checkRequired(boardId, new NotRequiredFieldException("게시판 아이디를 입력바랍니다."));
		checkRequired(boardNm, new NotRequiredFieldException("게시판 이름을 입력바랍니다."));
		//1. 필수데이터 체크 E
		
		//2. 기본값 부여 S
		int index = boardConfig.getBoardIndex();
		if(index <= 0 || index >30) boardConfig.setBoardIndex(20);
		int pageIndex = boardConfig.getBoardPageIndex();
		if(pageIndex <0 || pageIndex >20) boardConfig.setBoardPageIndex(10);

	}

}
