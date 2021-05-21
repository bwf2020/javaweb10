package day11;

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
		
		Orders o1= session.selectOne("com.bwf.Orders.find1", 1);
		
		System.out.println(o1);
		
		System.out.println(o1.getCode());
		
		System.out.println(o1.getOrdersItemList());
		
		System.out.println(o1.getOrdersItemList().get(0).getProduct().getName());
		
		
		for (OrdersItem oi : o1.getOrdersItemList()) {
			
			Product p=oi.getProduct();
			
			System.out.println(o1.getCode()+"-"+oi.getNum()+"-"+p.getName()+"-"+p.getPrice());
			
		}
		
		
		System.out.println("=============================");
		
		//添加订单和产品的关系
		/*Orders o2=session.selectOne("com.bwf.Orders.find1", 2);
		
		Product p2=session.selectOne("day10.Product.find2", 6);
		
		OrdersItem oi2=new OrdersItem();
		oi2.setOrders(o2);
		oi2.setProduct(p2);
		oi2.setNum(200);
		
		session.insert("day11.OrdersItem.add", oi2);
		*/
		
		Map map=new HashMap();
		map.put("oid", 2);
		map.put("pid", 6);
		map.put("num", 200);
		
		//session.insert("day11.OrdersItem.add2", map);
		
		Orders o3=new Orders();
		o3.setId(1);
		
		Product p3=new Product();
		p3.setId(3);
		
		OrdersItem oi3=new OrdersItem();
		oi3.setOrders(o3);
		oi3.setProduct(p3);
		
		session.delete("day11.OrdersItem.del", oi3);
		
		
		
		
		session.commit();
		session.close();
		
		
		
		
	}

}
