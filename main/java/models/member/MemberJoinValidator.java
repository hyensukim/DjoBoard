package models.member;

import commons.validator.MobileValidator;

public class MemberJoinValidator implements MobileValidator{
	
	private MemberDao memberDao;
	
	
	public MemberJoinValidator(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void check(Member member) {
		/**
		 * 데이터 검증 - 유효성 검사
		 * 		1. 필수항목 : userId, userPw, userPwRe, userNm
		 * 		2. 아이디 자리수는 6~20이하, 비밀번호는 8자리 이상
		 * 		3. 아이디 중복 여부 확인
		 * 		4. 비밀번호 확인(userPw, uerPwRe 일치)
		 * 		5. 휴대전화번호가 있으면 형식 체크
		 * 	    6. 약관 동의 여부 체크
		 */
		
		// 1. 필수항목 체크 S  -------------------------
		
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		String userPwRe = member.getUserPwRe();
		String userNm = member.getUserNm();
		String mobile = member.getMobile();
		mobile = mobile == null? null : mobile.replaceAll("\\D", "");
		member.setMobile(mobile);
		
		
		checkReqired(userId, new MemberValidationException("아이디를 입력하세요."));
		checkReqired(userPw, new MemberValidationException("비밀번호를 입력하세요."));
		checkReqired(userPwRe, new MemberValidationException("비밀번호를 확인하세요."));
		checkReqired(userNm, new MemberValidationException("회원명을 입력하세요."));
		
		// -------------------------필수항목 체크 E 
		
		
		// 2. 아이디 자리수는 6~20이하, 비밀번호는 8자리 이상 S -------------------------
		
		if(userId.length() < 6 || userId.length() > 20) {
			throw new MemberValidationException("아이디는 6자리 이상 20자리 이하 입력하세요.");
		}
		
		if(userPw.length() < 8 ) {
			throw new MemberValidationException("비밀번호는 8자리 이상 입력하세요.");
		}
		// ------------------------- 아이디 자리수는 6~20이하, 비밀번호는 8자리 이상 E
		
		
		// 3. 아이디 중복 여부 확인 S -------------------------
		
		if(memberDao.isExists(userId)) {
			throw new DuplicateMemberException();
		}
		// ------------------------- 아이디 중복 여부 확인E
		
		
		// 4. 비밀번호 확인(userPw, uerPwRe 일치) S -------------------------
		
		if(!userPw.equals(userPwRe)) {
			throw new MemberValidationException("비밀번호가 일치하지 않습니다.");
		}
		// ------------------------- 비밀번호 확인(userPw, uerPwRe 일치) E
		
		
		// 5. 휴대전화번호가 있으면 형식 체크(선택사항) S -------------------------
		
		if(mobile != null && !mobile.isBlank()) {
			boolean check = mobileCheck(mobile);
			if(!check) {
				throw new MemberValidationException("휴대전화번호 형식이 아닙니다.");
			}
		}
		//  ------------------------- 휴대전화번호가 있으면 형식 체크(선택사항) E
		
		
		//6. 약관 동의 여부 체크 S -------------------------
		if(!member.isAgree()) {
			throw new MemberValidationException("회원가입 약관에 동의해주세요.");
		}
		
	}
	
	private void checkReqired(String data, RuntimeException e) {
		if(data == null || data.isBlank()) {
			throw e;
		}
	}

}
