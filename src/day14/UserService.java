package day14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) {
		
	
		userMapper.save(user);
		
		System.out.println(1/0);
		
		System.out.println("±£´æ");
		

	}

}
