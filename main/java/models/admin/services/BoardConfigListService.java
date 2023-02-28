package models.admin.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import models.admin.BoardConfig;
import models.admin.BoardConfigDao;

public class BoardConfigListService {

	private BoardConfigDao boardConfigDao;
	
	public BoardConfigListService(BoardConfigDao boardConfigDao) {
		this.boardConfigDao = boardConfigDao;
	}
	
	public void getIndex(HttpServletRequest request){
		/**
		 * 게시판 설정 목록 확인 기능
		 * - 검색 조건이 없는 경우
		 * 1. 전체 목록 리스트에 담아서 조회.
		 * 
		 * - 검색조건이 있는 경우
		 * 1. 전체 목록에서 해당 조건에 맞는 레코드만 조회.
		 * 2. 유효성 검사
		 * 		- 해당 조건을 입력할것(아이디 또는 이름)
		 *  	- 없는 아이디 또는 이름인 경우 예외 발생.  
		 */
		
	}
}
