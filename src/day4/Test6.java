package day4;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Test6 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {


		System.out.println("�����Ķ��󱻴�����");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("�����Ķ���������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
