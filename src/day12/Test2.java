package day12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	//�ӹ����л�ȡ����
	User u1= (User) application.getBean("user");
	System.out.println("�û�1��"+u1);
	/*u1.setId(1);
	u1.setName("����");*/

	
	IUserService userService=(IUserService) application.getBean("userService");
	userService.show();
	
	System.out.println("����1��"+userService);
	
	IUserService userService2=(IUserService) application.getBean("userService");
	
	System.out.println("����2��"+userService2);
	
	
	User u2= (User) application.getBean("user");//ֻҪ��ȡ�������µĶ���
	System.out.println("�û�2��"+u2);
/*	u2.setId(2);
	u2.setName("����");*/
	
	
	User u3= (User) application.getBean("user");//ֻҪ��ȡ�������µĶ���
	System.out.println("�û�3��"+u3);
	
	
	
	System.out.println(u1.getName());//������
	
	//����test3�ǵ���ģʽ
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
	
	System.out.println("=======�õ���=========");
	
	Dog dog1= application.getBean(Dog.class);
	System.out.println(dog1);
	
	
	Dog dog2= application.getBean(Dog.class);
	System.out.println(dog2);
	
	System.out.println("=====��ȡ�û�=========");
	
	User user1=(User) application.getBean("user1");
	System.out.println(user1);
	
	User user2=(User) application.getBean("user2");
	System.out.println(user2);
	
	
	System.out.println("=====��ȡ�û� name id����=========");
	User user3=(User) application.getBean("user3");
	System.out.println(user3);
	
/*	User user4=(User) application.getBean("/user4");
	System.out.println(user4);*/

	
	
	
	
	
	
	
	
	
	}

}
