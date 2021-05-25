package day13;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class User {

	
	@Autowired
	private Dog dog;

	public Dog getDog() {
		return dog;
	}

	
	
}
