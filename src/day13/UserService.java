package day13;

import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService{

	@Override
	public void show1() {


		System.out.println("调用show1");
		
	}

	@Override
	public void show2() {
		
		System.out.println("调用show2");
		
	}

	@Override
	public void show3(String name) {
		
		System.out.println("调用show3");
		
	}

	
	
	
	
}
