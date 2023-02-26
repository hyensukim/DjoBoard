package commons.DB;

public interface UpdateQuery {

	<T> int update(T t, String mapper);
	
}

