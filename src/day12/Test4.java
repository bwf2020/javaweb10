package day12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	
	//�ӹ����л�ȡ����
	User u1= (User) application.getBean("user1");
	System.out.println(u1);
	
	System.out.println(u1.getId());
	System.out.println(u1.getName());
	
	
	User u2= (User) application.getBean("user2");
	System.out.println(u2);
	
	System.out.println(u2.getId());
	System.out.println(u2.getName());
	
	
	System.out.println("======ֻ��ioc========");
	
	/*Car car=(Car) application.getBean("car");
	car.setName("����");
	
	FaDongJi f1=(FaDongJi) application.getBean("f1");
	LunZi l1=(LunZi) application.getBean("l1");
	
	car.setF1(f1);
	car.setL1(l1);
	
	System.out.println("������ǣ�"+car.getName()+"�������ͺţ�"+car.getF1().getName()+"ʹ�õ����ӣ�"+car.getL1().getName());
	
	
	
	Car car2=(Car) application.getBean("car");
	car2.setName("����");
	
	System.out.println("������ǣ�"+car.getName()+"�������ͺţ�"+car.getF1().getName()+"ʹ�õ����ӣ�"+car.getL1().getName());*/
	
	
	System.out.println("======����di========");
	
	Car car=(Car) application.getBean("car");
	car.setName("����");
	System.out.println("������ǣ�"+car.getName()+"�������ͺţ�"+car.getF1().getName()+"ʹ�õ����ӣ�"+car.getL1().getName());
	
	}
	
	
	

}
