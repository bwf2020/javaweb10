package day7;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Test1 {

	public static void main(String[] args) {


		Jedis r=new Jedis();
		
		System.out.println(r.ping());
		
		//5÷÷¿‡–Õ
		
		Set keys= r.keys("*");
		
		System.out.println(keys);
		
		//r.set("c", "C");
		
		String a= r.get("a");
		System.out.println(a);
		
		
		/*r.hset("map", "name", "zhangsan");
		
		r.hset("map", "sex", "man");*/
		
		String name=r.hget("map", "name");
		System.out.println(name);
		
		
		//r.lpush("list", "zhangsan","lili","wangwu");
		
		List<String> list= r.lrange("list", 0, -1);
		System.out.println(list);
		
		
		
	}

}
