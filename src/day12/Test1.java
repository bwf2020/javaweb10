package day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import day10.Product;
import day9.Category;

public class Test1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws  Exception {


		
		
		String config="mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(config);
		
		SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory= sfb.build(in);
		
		//是程序跟数据库之间的一个会话
		SqlSession session= factory.openSession();
		
		
		/*User user= session.selectOne("day12.User.find1", 12);
		
		System.out.println(user.getName());
		
		
		
		System.out.println(user.getTelList());*/
		
		
		User user= session.selectOne("day12.User.find2", 12);
		System.out.println(user.getName());
		
		System.out.println(user.getTelList());
		
		
		session.commit();
		session.close();
		
		
		
		
	}

}
