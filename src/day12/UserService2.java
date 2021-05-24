package day12;

public class UserService2 implements IUserService {

	@Override
	public void show() {


		System.out.println("开始计算了");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("只要1秒钟......");
		
		System.out.println("结束");

	}

}
