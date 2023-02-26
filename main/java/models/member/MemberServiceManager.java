package models.member;

/**
 * 회원 관련 서비스 객체 관리
 * @author veron
 *
 */
public class MemberServiceManager {
	private static MemberServiceManager instance = null;
	
	private MemberServiceManager() {}
	
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	/**
	 * 회원 가입 서비스
	 */
	
	public MemberJoinService getMemberJoinService() {
		MemberJoinService service =  new MemberJoinService(memberDao());
		service.setValidator(new MemberJoinValidator(memberDao()));
		
		return service;
	}
	
	
	/**
	 * 로그인 서비스
	 */
	public MemberLoginService getMemberLoginService() {
		
		MemberLoginValidator validator = new MemberLoginValidator(memberDao());
		return new MemberLoginService(memberDao(), validator);
	}
	
	public static MemberServiceManager getInstance() {
		if(instance == null) {
			instance = new MemberServiceManager();
		}
		return instance;
	}
	
	
}
