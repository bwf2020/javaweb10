package day12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	//从工厂中获取对象
	User u1= (User) application.getBean("user1");
	System.out.println(u1);
	
	System.out.println(u1.getId());
	System.out.println(u1.getName());
	
	
	User u2= (User) application.getBean("user2");
	System.out.println(u2);
	
	System.out.println(u2.getId());
	System.out.println(u2.getName());
	
	
	System.out.println("======只有ioc========");
	
	/*Car car=(Car) application.getBean("car");
	car.setName("奔驰");
	
	FaDongJi f1=(FaDongJi) application.getBean("f1");
	LunZi l1=(LunZi) application.getBean("l1");
	
	car.setF1(f1);
	car.setL1(l1);
	
	System.out.println("你买的是："+car.getName()+"发动机型号："+car.getF1().getName()+"使用的轮子："+car.getL1().getName());
	
	
	
	Car car2=(Car) application.getBean("car");
	car2.setName("奔奔");
	
	System.out.println("你买的是："+car.getName()+"发动机型号："+car.getF1().getName()+"使用的轮子："+car.getL1().getName());*/
	
	
	System.out.println("======带有di========");
	
	Car car=(Car) application.getBean("car");
	car.setName("奔驰");
	System.out.println("你买的是："+car.getName()+"发动机型号："+car.getF1().getName()+"使用的轮子："+car.getL1().getName());
	
	}
	
	
	

}
