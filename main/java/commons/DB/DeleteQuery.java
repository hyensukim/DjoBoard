package commons.DB;

public interface DeleteQuery {
	
	<T> int delete(String mapper,T t);
}
