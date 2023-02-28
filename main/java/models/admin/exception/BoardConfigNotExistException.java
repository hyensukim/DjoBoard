package models.admin.exception;

public class BoardConfigNotExistException extends RuntimeException {
	public BoardConfigNotExistException() {
		super("존재하지 않는 게시판 입니다.");
	}
}
