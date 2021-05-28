package day16;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.User;
import com.sun.org.apache.regexp.internal.recompile;

@Controller
@RequestMapping("/day16")
public class Test1Controller {
	
	
	@RequestMapping("test1")
	public String test1() {
		
		System.out.println("day16 test1..................");
		return "/index.jsp";
	}
	
	
	@RequestMapping("test2")
	public void test2(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("day16 test2..................");
		
		String name=req.getParameter("name");
		
		//直接输出信息
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.print("hello:"+name);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	@RequestMapping("test3")
	@ResponseBody
	public String test3(String name) {
		
		System.out.println("day16 test3..................");
		
		return "hello:"+name;
		
		
	}
	
	
	@RequestMapping("test4")
	@ResponseBody
	public User test4(String name) {
		
		System.out.println("day16 test4..................");
		
		User u=new User();
		u.setName(name);
		//{"name":"zhangsan"}
		return u;
		
		
	}
	
	
	@RequestMapping("test5")
	@ResponseBody
	public User test5(@RequestBody User user) {
		
		System.out.println("day16 test5..................");
		
		System.out.println("参数："+user.getName());
	
		return user;
		
		
	}



}
