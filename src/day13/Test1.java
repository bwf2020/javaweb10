package day13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	//从工厂中获取对象
	User u1= (User) application.getBean("user1");
	System.out.println(u1);
	
	System.out.println(u1.getDog());
	
/*	Dog dog1=(Dog) application.getBean("dog1");
	System.out.println(dog1);*/
	
	System.out.println("=========================");
	
	
/*	User u2= (User) application.getBean("user2");
	System.out.println(u2);
	System.out.println(u2.getDog());*/
	
	
	}
	
	
	

}
