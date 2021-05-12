package day4;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Test7 implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {


		System.out.println("session对象被创建");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session对象被销毁");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
