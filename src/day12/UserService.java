package day12;

public class UserService implements IUserService{


	@Override
	public void show() {


		System.out.println("��ʼ����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��Ҫ����1����.........");
		
		System.out.println("����");
		
	}

}
