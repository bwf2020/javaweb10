package day10;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		
		
		Integer count=session.selectOne("com.bwf.A.find1");
		System.out.println(count);
		
		count=session.selectOne("com.bwf.B.find1");
		System.out.println(count);
		
		
		
		
		System.out.println("=========noe===========");
		
		Category c1= session.selectOne("day9.Category.findBy", "lisi");
		System.out.println(c1.getId());
		
		System.out.println("========list============");
		
		List<Category> list1=session.selectList("day9.Category.findByName", "");
		System.out.println(list1.size());
		
		for (Category category : list1) {
			if(category.getName().equals("zhangsan")) {
				
				
				System.out.println("通过list获取张三的id:"+category.getId());
				break;
				
			}
		}
		
		
		for (Category category : list1) {
			if(category.getName().equals("lisi")) {
				
				System.out.println("通过list获取李四的id:"+category.getId());
				break;
				
			}
		}
		
		
		
		System.out.println("=========map============");
		
		Map map= session.selectMap("day9.Category.findMap","name");
		System.out.println(map);
		
		Category c2= (Category) map.get("zhangsan");
		System.out.println("通过map获取张三的id:"+c2.getId());
		
		 c2= (Category) map.get("lisi");
		System.out.println("通过map获取李四的id:"+c2.getId());
		
		
		Category c3=session.selectOne("day9.Category.findBy2");
		
		System.out.println(c3);
		
		System.out.println(c3.getId());
		System.out.println(c3.getName());
		
		
		
		session.commit();
		session.close();
		
		
		
		
	}

}
