package models.member;

import commons.DB.QueryExecutor;

public class MemberDao {
	
	private QueryExecutor qe;
	
	public MemberDao() {
		qe = new QueryExecutor();
	}
	
	/**
	 * 회원정보 DB 추가
	 * 
	 * @param {Member} member : 회원가입 정보
	 * @return {boolean} 성공/실패 여부 확인
	 */
	public boolean register(Member member) {
		int cnt = qe.insert(member, "MemberMapper.insert");
		
		return cnt > 0;
	}
	
	/**
	 * 회원정보 수정
	 * 
	 * @param {Member} member 
	 * @return {boolean} 성공/실패 여부 확인
	 */
	public boolean update(Member member) {
		int cnt = qe.update(member, "MemberMapper.update");
		
		return cnt > 0;
	}
	
	/**
	 * 회원정보 삭제
	 * 
	 * @param {Member} member : 회원가입 정보
	 * @return {boolean} 성공/실패 여부 확인
	 */
	public boolean delete(Member member) {
		int cnt = qe.delete(member, "MemberMapper.delete");
		
		return cnt > 0;
	}
	
	/**
	 * 회원정보 아이디로 조회
	 * 
	 * @param uesrId
	 * @return 
	 */
	public Member get(String userId) {
		Member params = new Member();
		params.setUserId(userId);
		
		Member member = qe.queryOne(params, "MemberMapper.member");
		
		return member;
	}
	
	/**
	 * 회원 등록 여부 확인
	 * @param userId
	 * @return
	 */
	public boolean isExists(String userId) {
		Member params = new Member();
		params.setUserId(userId);
		
		int cnt = qe.count(params, "MemberMapper.count");
		
		return cnt >0;
	}

}
