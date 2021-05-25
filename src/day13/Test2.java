package day13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	User user1= (User) application.getBean(User.class);
	System.out.println(user1);
	
	Dog dog1=(Dog) application.getBean(Dog.class);
	System.out.println(dog1);
	
	
	System.out.println(user1.getDog());
	
	}
	
	
	

}
