package commons.DB;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MyConnection;

public class QueryExecutor implements InsertQuery, UpdateQuery, DeleteQuery, SelectQuery {
	
	private SqlSession session = null;

	@Override
	public <T> int delete(T t, String mapper) {
		session = getSession();
		int cnt = t == null?session.delete(mapper):session.delete(mapper, t);
		session.commit();
		
		return cnt;
	}

	@Override
	public <T> int update(T t, String mapper) {
		session = getSession();
		int cnt = t == null?session.update(mapper):session.update(mapper, t);
		session.commit();
		
		return cnt;
	}

	@Override
	public <T> int insert(T t, String mapper) {
		session = getSession();
		int cnt = t == null?session.insert(mapper):session.insert(mapper, t);
		session.commit();
		
		return cnt;
	}

	
	@Override
	public <T, R> List<R> query(T t, String mapper) {
		session = getSession();
		List<R> list = session.selectList(mapper, t);
		
		return list;
	}

	@Override
	public <R> List<R> query(String mapper) {
		session = getSession();
		List<R> list = session.selectList(mapper);
		
		return list;
	}

	@Override
	public <T, R> R queryOne(T t, String mapper) {
		session = getSession();
		R data = session.selectOne(mapper, t);	
		
		return data;
	}

	@Override
	public <R> R queryOne(String mapper) {
		session = getSession();
		R data = session.selectOne(mapper);	
		
		return data;
	}


	public SqlSession getSession() {
		if(session == null) {
			session = MyConnection.getSession();
		}
		return session;
	}
	
	@Override
	public <T> int count(T t, String mapper) {
		session = getSession();
		int cnt = session.selectOne(mapper, t);
		
		return cnt;
	}
	
	
}
