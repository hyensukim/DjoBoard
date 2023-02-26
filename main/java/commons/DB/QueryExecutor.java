package commons.DB;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;

public class QueryExecutor implements InsertQuery, UpdateQuery, DeleteQuery, SelectQuery {

	private SqlSession session = null;
		
	/**
	*  session 생성 메서드 정의 ->session 자원 재활용을 위해 null인 경우에만 생성하도록 
	*  조건문을 통해 제어.
	* @return
	*/
	private SqlSession getSession() {
		if(session == null) {
			session = MyConnection.getSession();
		}
		return session;
	}
	
	@Override
	public <T, R> List<R> queryList(String mapper, T t) {
		session = getSession();
		List<R> data = session.selectList(mapper, t); 
		return data;
	}

	@Override
	public <R> List<R> queryList(String mapper) {
		session = getSession();
		List<R> data = session.selectList(mapper); // SELECT * FROM boardConfig
		return data;
	}

	@Override
	public <T, R> R queryOne(String mapper, T t) {
		session = getSession();
		R data = session.selectOne(mapper,t);
		return data;
	}

	@Override
	public <R> R queryOne(String mapper) {
		session = getSession();
		R data = session.selectOne(mapper);
		return data;
	}
	
	@Override
	public <T> int count(String mapper,T t) {
		session = getSession();
		int cnt = session.selectOne(mapper, t);
		return cnt;
	}
	

	@Override
	public <T> int delete(String mapper, T t) {
		session = getSession();
		int cnt = session.delete(mapper, t);
		session.commit();
		return cnt;
		
	}

	@Override
	public <T> int update(String mapper, T t) {
		session = getSession();
		int cnt = session.update(mapper, t);
		session.commit();
		return cnt;
	}

	@Override
	public <T> int insert(String mapper, T t) {
		session = getSession();
		int cnt = session.insert(mapper, t);
		session.commit();
		return cnt;
	}

}// class E
