package day12;

public class UserService2 implements IUserService {

	@Override
	public void show() {


		System.out.println("��ʼ������");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ֻҪ1����......");
		
		System.out.println("����");

	}

}
