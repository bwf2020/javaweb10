package day9;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {

	public static void main(String[] args) throws  Exception {


		
		
		String config="mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(config);
		
		SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory= sfb.build(in);
		
		//是程序跟数据库之间的一个会话
		SqlSession session= factory.openSession();
		
		System.out.println(session);
		
		//调用配置文件中的id
		List<Category> list= session.selectList("day9.Category.find");
		System.out.println(list);
		
		for (Category category : list) {
			System.out.println(category.getName());
		}

	}

}
