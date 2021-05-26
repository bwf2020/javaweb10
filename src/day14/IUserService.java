package day14;


public interface IUserService {

	
	public void reg(User user);
	
	
	public User getUser(String name,String sex);
	
	public User getUser(int id);
	
	public User getUser(String name);
	
}
