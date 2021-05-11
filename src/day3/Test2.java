package day3;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {

		
		
		System.out.println(config.getInitParameter("a"));
		
		ServletContext context= config.getServletContext();
		
		System.out.println("test2 上下文，环境："+context.getInitParameter("a"));
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		System.out.println("3-2");
		
	
	
	}
	
	

}
