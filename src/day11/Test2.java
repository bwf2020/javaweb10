package day11;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import day10.Product;
import day9.Category;

public class Test2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws  Exception {


		
		
		String config="mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(config);
		
		SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory factory= sfb.build(in);
		
		//是程序跟数据库之间的一个会话
		SqlSession session= factory.openSession();
		
		
	/*	List<User2> list= session.selectList("day11.User2.findAll");
		System.out.println(list.size());
		
		
		Map map=new HashMap();
		map.put("name", "zhangsan");
		map.put("sex", "m");
		User2 u= session.selectOne("day11.User2.findByNameAndSex", map);
		System.out.println(u.getId());
		
		
		System.out.println("========================");
		
		list=session.selectList("day11.User2.findBy");
		System.out.println(list.size());
		
		
		Map map2=new HashMap();
		map2.put("name", "zhangsan");
		list=session.selectList("day11.User2.findBy",map2);
		System.out.println(list.size());
		
		
		Map map3=new HashMap();
		map3.put("sex", "m");
		list=session.selectList("day11.User2.findBy",map3);
		System.out.println(list.size());
		
		Map map4=new HashMap();
		map4.put("name", "zhangsan");
		map4.put("sex", "m");
		list=session.selectList("day11.User2.findBy",map4);
		System.out.println(list.size());
		
		
		System.out.println("========================");
		
		list=session.selectList("day11.User2.findBy2",map3);
		System.out.println(list.size());
		
		System.out.println("========================");
		
		
		Map map5=new HashMap();
		map5.put("id", 11);
		map5.put("name", "lisi");
		map5.put("sex", "w");
		session.update("day11.User2.update",map5);
		
		System.out.println("========================");
		list=session.selectList("day11.User2.findBy3",map5);
		System.out.println(list.size());*/
		
		
		System.out.println("========================");

		//int[] ids= {13,17,16};
		
		List ids=new ArrayList();
		ids.add(13);
		ids.add(17);
		
		/*Set ids=new HashSet();
		ids.add(13);
		ids.add(17);*/
		
		
		List list=session.selectList("day11.User2.findIn",ids);
		System.out.println(list.size());
		
		
		System.out.println("===========缓存=============");
		
	/*	User2 u=session.selectOne("day11.User2.findById2", 11);
		System.out.println(u.getName());
		
		
		//session.clearCache();
		
		session.commit();
		session.close();
		
		
		
		session= factory.openSession();
		
		User2 u2=session.selectOne("day11.User2.findById2", 11);
		System.out.println(u2.getName());
		

		*/
		session.commit();
		session.close();
		
		
		
	
		
		
		
		
	}

}
