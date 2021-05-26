package day14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {


		ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user=new User();
		user.setId(18);
		user.setName("bwf");
		
		
		IUserService userService=(IUserService) application.getBean("userService");

		System.out.println(userService);
		
		userService.reg(user);
		
		
		
	
		
	}

}
