package day2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup=3,urlPatterns="/test3")
public class Test3 extends HttpServlet{

	
	
	public Test3() {
		
		
		System.out.println("test3 ����ʵ����");
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("test3  doget.....");
		
	}
	
	
	
	

}
