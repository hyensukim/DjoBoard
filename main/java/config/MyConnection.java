package config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConnection {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"dev");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession(true);
	}
}// class E
