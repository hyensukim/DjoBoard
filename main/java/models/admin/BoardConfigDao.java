package models.admin;

import java.util.List;

import commons.DB.QueryExecutor;

public class BoardConfigDao {
	private QueryExecutor qe = null;
	
	// 의존성 부여
	// BoardDao() 객체 생성해야 쿼리 실행 기능 사용가능.
	public BoardConfigDao(QueryExecutor qe) {
		this.qe = qe;
	}
	
	/**
	 * 게시판 설정 목록 조회
	 * return List<BoardConfig>
	 */
	public List<BoardConfig> getConfigs(BoardConfig boardConfig){
		List<BoardConfig> configs = qe.queryList("BoardConfigMapper.configs",boardConfig);
		return configs;
	}
	
	public List<BoardConfig> getConfigs(){
		List<BoardConfig> configs = qe.queryList("BoardConfigMapper.configs");
		return configs;
	}
	
	/**
	 * 게시판 설정 하나 조회
	 * return BoardConfig
	 */
	
	public BoardConfig getConfig(String boardId) {
		BoardConfig boardConfig = new BoardConfig();
		boardConfig.setBoardId(boardId);
		BoardConfig config = qe.queryOne("BoardConfigMapper.config", boardConfig);
		return config;
	}
	
	/**
	 * 게시판 설정 저장
	 * 		- 게시판 아이디로 DB 목록에서 조회
	 * 		- O -> update(수정)
	 * 		- X -> insert(생성)
	 */
	public boolean save(BoardConfig boardConfig) {
		int result = 0;
		int cnt = qe.count("BoardConfigMapper.count", boardConfig); // 1
		if( cnt >0) {
			result = qe.update("BoardConfigMapper.update", boardConfig);
		}else {
			result = qe.insert("BoardConfigMapper.insert", boardConfig);
		}
		return result > 0;
	}
	
	
	/**
	 * 게시판 설정 삭제
	 */
	public boolean delete(String boardId) {
		BoardConfig boardConfig = new BoardConfig();
		boardConfig.setBoardId(boardId);
		int cnt = qe.delete("BoardConfigMapper.delete", boardConfig);
		return cnt >0;
	}
}
