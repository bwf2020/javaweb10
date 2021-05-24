package day12;

public class UserService implements IUserService{


	@Override
	public void show() {


		System.out.println("开始计算");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("需要消耗1分钟.........");
		
		System.out.println("结束");
		
	}

}
