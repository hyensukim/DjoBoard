package models.admin;

import java.time.LocalDateTime;

/**
 *  boardDTO
 * @author 김현수
 *
 */
public class BoardConfig {
	private String boardId;// 게시판 아이디
	private String boardNm;// 게시판 이름
	private boolean useConfig;// 게시판 사용유무(기본값 true)
	private boolean useEditor;//위지윅에디터 사용유무
	private boolean useComment; // 댓글 사용유무
	private String useAttach; // basic-파일, image-이미지 첨부 사용유무
	private int boardIndex; // 게시판 목록 상 노출 갯수
	private int boardPageIndex; // 게시판 목록 페이지 노출 갯수
	private String topHtml; // 게시판 목록 상단 베너
	private String bottomHtml; // 게시판 목록 하단 베너
	private LocalDateTime boardRegDt;// 게시판 등록일
	private LocalDateTime boardModDt;// 게시판 수정일
	
	public String getBoardId() {
		return boardId;
	}
	
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
	public String getBoardNm() {
		return boardNm;
	}
	
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	
	public boolean isUseConfig() {
		return useConfig;
	}
	
	public void setUseConfig(boolean useConfig) {
		this.useConfig = useConfig;
	}
	
	public boolean isUseEditor() {
		return useEditor;
	}
	
	public void setUseEditor(boolean useEditor) {
		this.useEditor = useEditor;
	}
	
	public boolean isUseComment() {
		return useComment;
	}
	
	public void setUseComment(boolean useComment) {
		this.useComment = useComment;
	}
	
	public String getUseAttach() {
		return useAttach;
	}
	
	public void setUseAttach(String useAttach) {
		this.useAttach = useAttach;
	}
	
	public int getBoardIndex() {
		return boardIndex;
	}
	
	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}
	
	public int getBoardPageIndex() {
		return boardPageIndex;
	}
	
	public void setBoardPageIndex(int boardPageIndex) {
		this.boardPageIndex = boardPageIndex;
	}
	
	public String getTopHtml() {
		return topHtml;
	}
	
	public void setTopHtml(String topHtml) {
		this.topHtml = topHtml;
	}
	
	public String getBottomHtml() {
		return bottomHtml;
	}
	
	public void setBottomHtml(String bottomHtml) {
		this.bottomHtml = bottomHtml;
	}
	
	public LocalDateTime getBoardRegDt() {
		return boardRegDt;
	}
	
	public void setBoardRegDt(LocalDateTime boardRegDt) {
		this.boardRegDt = boardRegDt;
	}
	
	public LocalDateTime getBoardModDt() {
		return boardModDt;
	}
	
	public void setBoardModDt(LocalDateTime boardModDt) {
		this.boardModDt = boardModDt;
	}
}
