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

public class Test3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws  Exception {


		
		
		String config="mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(config);
		
		SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory= sfb.build(in);
		
		//是程序跟数据库之间的一个会话
		SqlSession session= factory.openSession();
		
		Category c1= session.selectOne("day9.Category.findCP", 1);
	
		System.out.println(c1);
		
		System.out.println(c1.getId());
		System.out.println(c1.getName());

		System.out.println(c1.getProducts());
		
		
		System.out.println("==========多对一============");
		
		List<Product> list1= session.selectList("day10.Product.find1");
		
		System.out.println(list1);
		
		for (Product product : list1) {
			System.out.println(product.getName()+"类别："+product.getCategory().getName());
		}
		
		
		session.commit();
		session.close();
		
		
		
		
	}

}
