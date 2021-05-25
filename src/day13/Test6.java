package day13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test6 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	IUserService userService=(IUserService) application.getBean("userService");
	
	System.out.println(userService);
	
	userService.show1();
	
	userService.show2();
	
	userService.show3("");
	
	}
	
	
	

}
