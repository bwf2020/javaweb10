package day3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		HttpSession session=req.getSession();
		ServletContext context=this.getServletContext();
		
		//System.out.println("局部变量："+name);
		System.out.println("3-6 req:"+req.getAttribute("name"));
		System.out.println("3-6 session:"+session.getAttribute("name"));
		System.out.println("3-6 context:"+context.getAttribute("name"));

		
		
		
	}

	
	
	
	
	
}
