package day3;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		Cookie[] cookies=req.getCookies();
		
		if(cookies!=null) {
		System.out.println(Arrays.toString(cookies));
		
		System.out.println("来自客户端的cookie:"+cookies[0].getName()+" 值："+cookies[0].getValue());
		}
		
		Cookie cookie=new Cookie("name", "bwf");
		cookie.setMaxAge(60);
		
		resp.addCookie(cookie);
		
		
		System.out.println("===============session=============");
		
		HttpSession session=req.getSession();
		System.out.println(session);
		System.out.println(session.isNew());
		System.out.println(session.getId());
		
		System.out.println(session.getMaxInactiveInterval());
		
		session.setMaxInactiveInterval(30);
		
		//使用session存储数据 重点

		
	}

	
	
	
}
