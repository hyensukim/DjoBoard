package models.member;

import javax.servlet.http.HttpServletRequest;
import org.mindrot.bcrypt.BCrypt;

import commons.validator.Validator;


public class MemberJoinService {
	private MemberDao memberDao;
	private Validator<Member> validator; 
	
	public MemberJoinService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setValidator(Validator<Member> validator) {
		this.validator = validator;
	}
	
	public void doJoin(HttpServletRequest request) { 
	/**
	 * 1. 데이터 검증 - 유효성 검사
	 * 		필수항목 : userId, userPw, userPwRe, userNm
	 * 		아이디 자리수는 6~20이하, 비밀번호는 8자리 이상
	 * 		아이디 중복 여부 확인
	 * 		비밀번호 확인(userPw, uerPwRe 일치)
	 * 		휴대전화번호가 있으면 형식 체크
	 * 
	 * 2. DB 처리
	 */
		Member member = new Member();
		member.setUserId(request.getParameter("userId"));
		member.setUserPw(request.getParameter("userPw"));
		member.setUserPwRe(request.getParameter("userPwRe"));
		member.setUserNm(request.getParameter("userNm"));
		member.setMobile(request.getParameter("mobile"));
		
		boolean agree = request.getParameter("agree") == null? false : true;
		member.setAgree(agree);
		
		
		if(validator != null) {
			validator.check(member);
		}
		
		//비번 암호화(BCrtpt 해시)
		String hash = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12));
		member.setUserPw(hash);
		boolean result = memberDao.register(member);
		if(!result){ //회원가입 실패
			throw new JoinFailException();
		}
		
	}

}
