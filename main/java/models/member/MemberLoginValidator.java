package models.member;

import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

/**
 * 로그인 유효성 검사
 * @param memberDao
 */
public class MemberLoginValidator {
	
	private MemberDao memberDao;
	
	public MemberLoginValidator(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	/**
	 * (------- 유효성 검사 -------)
	 * 1. 필수 항목 체크(userId, userPw)
	 * 2. userId로 회원이 있는지 체크
	 * 3. 회원이 있다면 비밀번호 검증
	 */
	
	public  void check(Member member) {
		
		// 1. 필수항목 체크(userId, userPw) S  -------------------------
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		
		if(userId == null || userId.isBlank()) {
			throw new MemberValidationException("아이디를 입력하세요");
		}
		
		if(userPw == null || userPw.isBlank()) {
			throw new MemberValidationException("비밀번호를 입력하세요");
		}
		// -------------------------필수항목 체크(userId, userPw) E 
		
		
		// 2. userId로 회원이 있는지 체크 S  -------------------------
		Member member2 = memberDao.get(userId);
		if(member2 == null) {
			throw new LoginUserIncorrectException();
		}
		// -------------------------userId로 회원이 있는지 체크 E 
		
		
		// 3. 회원이 있다면 비밀번호 검증 S  -------------------------
		boolean matched = BCrypt.checkpw(userPw, member2.getUserPw());
		if (!matched) {
			throw new LoginUserIncorrectException();
		}
		// -------------------------회원이 있다면 비밀번호 검증 E 
		
		
		
 }

}
