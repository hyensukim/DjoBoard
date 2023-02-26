package commons.DB;

public interface DeleteQuery {
	
	<T> int delete(T t, String mapper);
}
