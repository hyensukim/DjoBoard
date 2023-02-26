package models.member;

public class DuplicateMemberException extends RuntimeException{

	public DuplicateMemberException() {
		super("이미 가입된 회원입니다.");
	}
}
