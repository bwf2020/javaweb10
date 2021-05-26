package day14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public void reg(User user) {
		
	
		userMapper.save(user);
		
		//System.out.println(1/0);
		
		System.out.println("±£´æ");
		

	}

	@Override
	public User getUser(String name,String sex) {

		return userMapper.findBy(name, sex);
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userMapper.findByName(name);
	}

}
