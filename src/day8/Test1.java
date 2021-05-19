package day8;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import redis.clients.jedis.Jedis;

public class Test1 {

	public static void main(String[] args) throws  Exception {

		
		User user=new User();
		user.setId(1);
		user.setName("zhangsan");
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ObjectOutputStream obj=new ObjectOutputStream(out);
		obj.writeObject(user);
		
		byte[] userData= out.toByteArray();
		
	

		Jedis jedis=new Jedis();
		
		//jedis.set("user".getBytes(), userData);
		
		
		byte[] userData2=jedis.get("user".getBytes());
		
		ByteArrayInputStream in=new ByteArrayInputStream(userData2);
		ObjectInputStream obj2=new ObjectInputStream(in);
		User user2= (User) obj2.readObject();
		
		System.out.println(user2.getId());
		
		System.out.println(user2.getName());
		
		
		

	}

}
