package day13;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	public static void main(String[] args) {


		
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	Cat cat1= (Cat) application.getBean("cat1");
	System.out.println(cat1);
	
	System.out.println(Arrays.toString(cat1.getArrays()));
	
	System.out.println(cat1.getList());
	
	
	System.out.println(cat1.getMap());
	
	System.out.println(cat1.getA());
	
	System.out.println(Arrays.toString(cat1.getB()));
	
	System.out.println(cat1.getC());
	
	}
	
	
	

}
