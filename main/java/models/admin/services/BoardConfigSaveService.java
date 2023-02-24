package models.admin.services;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import commons.validator.Validator;
import models.admin.BoardConfig;
import models.admin.BoardConfigDao;
import models.admin.exception.BoardConfigException;

public class BoardConfigSaveService {
	private BoardConfigDao boardConfigDao = null;
	private Validator<BoardConfig> validator = null;
	
	//의존성 부여
	public BoardConfigSaveService(BoardConfigDao boardConfigDao, Validator<BoardConfig> validator) {
		this.boardConfigDao=boardConfigDao;
		this.validator = validator;
	}
	
	public void save(HttpServletRequest request) {
		
		/**
		 * boardConfig save 서비스 로직
		 * 0. 요청 데이터(파라미터) DTO에 담음.
		 * 1. 필수 데이터 입력 여부 확인
		 * 2.기본값 부여(디폴트값 입력) - 필수데이터 이외의 데이터.
		 * 3. DB 처리 
		 */
		
		BoardConfig boardConfig = new BoardConfig(); // DTO 생성
		
		//0. 파라미터 값 DTO에 담기 S
		boardConfig.setBoardId(request.getParameter("boardId"));

		boardConfig.setBoardNm(request.getParameter("boardNm"));
		
		 //my sql - tinyint : true = '1' false='0' null
		String useConfig = request.getParameter("useConfig");
		boardConfig.setUseConfig(useConfig == "0" || useConfig == null? false : true);
			
		String useEditor = request.getParameter("useEditor");
		boardConfig.setUseEditor(useEditor == "0" || useConfig == null? false : true);
		
		String useComment = request.getParameter("useComment");
		boardConfig.setUseComment(useComment =="0" || useComment==null? false : true);
		
		// 스트림 collect() 메서드 다시 공부
		String[] types = request.getParameterValues("useAttach");
		String type = null;
		if(types != null) {
			type = Arrays.stream(types).collect(Collectors.joining("||"));
		}
		boardConfig.setUseAttach(request.getParameter(type));
		
		//null이거나 비어있는 경우 0 , 아니면 문자열 -> 정수
		String boardIndex = request.getParameter("boardIndex");
		boardConfig.setBoardIndex(boardIndex ==null || boardIndex.isBlank() ?
				0: Integer.parseInt(boardIndex));
		
		String boardPageIndex = request.getParameter("boardPageIndex");
		boardConfig.setBoardPageIndex(boardPageIndex==null || boardPageIndex.isBlank()?
				0 : Integer.parseInt(boardPageIndex));
		// 0. 파라미터 값 DTO에 담기 E
		
		
		//1. 필수데이터 체크 - boardId, boardNm
		//2. 기본값 대입하기
		if(validator != null) {
			validator.check(boardConfig);
		}
		
		//3. DB처리
		boolean result =boardConfigDao.save(boardConfig);
		if(!result) {
			throw new BoardConfigException("설정 정보가 저장되지 않았습니다.");
		}
	}// save E
	
}
