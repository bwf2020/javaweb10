package day13;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService{

	@Override
	public void show1() {


		System.out.println("����show1");
		
	}

	@Override
	public void show2() {
		
		System.out.println("����show2");
		
	}

	@Override
	public void show3(String name) {
		
		System.out.println("����show3");
		
	}

	
	
	
	
}
