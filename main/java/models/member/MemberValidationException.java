package models.member;

public class MemberValidationException extends RuntimeException {
	public MemberValidationException() {
		super("잘못된 요청 데이터입니다.");
	}
	
	public MemberValidationException(String message) {
		super(message);
	}

}
