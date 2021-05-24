package day12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	//从工厂中获取对象
	User u1= (User) application.getBean("user");
	System.out.println("用户1："+u1);
	/*u1.setId(1);
	u1.setName("张三");*/

	
	IUserService userService=(IUserService) application.getBean("userService");
	userService.show();
	
	System.out.println("服务1："+userService);
	
	IUserService userService2=(IUserService) application.getBean("userService");
	
	System.out.println("服务2："+userService2);
	
	
	User u2= (User) application.getBean("user");//只要获取就生成新的对象
	System.out.println("用户2："+u2);
/*	u2.setId(2);
	u2.setName("李四");*/
	
	
	User u3= (User) application.getBean("user");//只要获取就生成新的对象
	System.out.println("用户3："+u3);
	
	
	
	System.out.println(u1.getName());//张三？
	
	//调用test3是单例模式
	/*Test3 t1=new Test3();
	Test3 t2=new Test3();
	Test3 t3=new Test3();
	
	System.out.println(t1);
	System.out.println(t2);
	System.out.println(t3);*/
	
	Test3 t1=Test3.getInstace();
	Test3 t2=Test3.getInstace();
	Test3 t3=Test3.getInstace();
	
	System.out.println(t1);
	System.out.println(t2);
	System.out.println(t3);
	
	System.out.println("=======得到狗=========");
	
	Dog dog1= application.getBean(Dog.class);
	System.out.println(dog1);
	
	
	Dog dog2= application.getBean(Dog.class);
	System.out.println(dog2);
	
	System.out.println("=====获取用户=========");
	
	User user1=(User) application.getBean("user1");
	System.out.println(user1);
	
	User user2=(User) application.getBean("user2");
	System.out.println(user2);
	
	
	System.out.println("=====获取用户 name id区别=========");
	User user3=(User) application.getBean("user3");
	System.out.println(user3);
	
/*	User user4=(User) application.getBean("/user4");
	System.out.println(user4);*/

	
	
	
	
	
	
	
	
	
	}

}
