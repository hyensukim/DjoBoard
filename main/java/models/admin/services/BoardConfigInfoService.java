package models.admin.services;

import javax.servlet.http.HttpServletRequest;

import models.admin.BoardConfig;
import models.admin.BoardConfigDao;
import models.admin.exception.BoardConfigNotExistException;

public class BoardConfigInfoService {

	private BoardConfigDao boardConfigDao;
	
	public BoardConfigInfoService(BoardConfigDao boardConfigDao) {
		this.boardConfigDao = boardConfigDao;
	}
	
	/**
	 * 게시판 아이디로 설정 조회
	 * @param request
	 * @return
	 */
	public BoardConfig get(String boardId) {
	
		BoardConfig boardConfig = boardConfigDao.getConfig(boardId);
		if(boardConfig == null) {
			throw new BoardConfigNotExistException();
		}
		return boardConfig;
	}
}
