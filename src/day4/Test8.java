package day4;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Test8 implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("req对象被销毁");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {

System.out.println("req对象被创建");

	}

}
