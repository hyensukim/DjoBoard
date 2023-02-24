package commons.DB;

public interface UpdateQuery {
	
	<T> int update(String mapper, T t);
}
