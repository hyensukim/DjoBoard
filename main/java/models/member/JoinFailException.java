package models.member;

public class JoinFailException extends RuntimeException {
	public JoinFailException() {
		super("회원가입에 실패하였습니다.");
	}
	
	public JoinFailException(String message) {
		super(message);
	}
}
