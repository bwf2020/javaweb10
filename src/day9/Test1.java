package day9;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test1 {

	@SuppressWarnings("unchecked")
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

		
		//session.insert("save");
		
		//session.insert("save2","zhansan");
		
		Category c=new Category();
		c.setId(7);
		c.setName("lisi");
		
		//session.insert("save3",c);
		
		Map map=new HashMap();
		map.put("id", 10);
		map.put("name", "wangwu");
		
		//session.insert("save3",map);
		
		//session.insert("del",map);
		
		//session.insert("save4", map);
		
		//session.delete("del",map);
		
		//System.out.println(map.get("id"));
		
		session.delete("del2",11);
		
		session.commit();
		session.close();
		
		
		
		
	}

}
