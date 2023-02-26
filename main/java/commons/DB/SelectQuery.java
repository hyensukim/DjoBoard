package commons.DB;

import java.util.List;

public interface SelectQuery {
	
	<T, R>List<R>query(T t, String mapper); //목록조회
	<R>List<R>query(String mapper);
	
	<T, R>R queryOne(T t, String mapper); //단일조회
	<R>R queryOne(String mapper);
	
	<T>int count(T t, String mapper);
	
	
	
}
