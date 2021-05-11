package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test3 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		
		String name=req.getParameter("name");
		
		PrintWriter out=resp.getWriter();
		
		User user=new User();
		user.setId(1);
		user.setName(name);
		user.setSex("man");
		
		User user2=new User();
		user2.setId(2);
		user2.setName("lisi");
		user2.setSex("man");
		
		User user3=new User();
		user3.setId(3);
		user3.setName("wangwu");
		user3.setSex("man");
		
		List<User> users=new ArrayList<User>();
		users.add(user);
		users.add(user2);
		users.add(user3);
		//id=1,name=zhangsan,sex=man
		//{id:1,name:'zhangsna',sex:'man'}
		//{"sex":"man","name":"zhangsan","id":1}
		
	/*	JSONObject json=JSONObject.fromObject(user);
		System.out.println(json.toString());
		out.print(json.toString());*/
		
		JSONArray json=JSONArray.fromObject(users);
		out.print(json.toString());
		
		out.flush();
		
		out.close();
		
		
	}
	
	

}
