package models.admin.exception;

public class AdminAccessException extends RuntimeException {
	public  AdminAccessException() {
		super("관리자만 접근할 수 있는 페이지 입니다.");
	}
}
