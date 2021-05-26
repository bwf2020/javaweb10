package day14;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Test1Controller implements HttpRequestHandler{


	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {


		System.out.println("请求了...................");
		
		
		String name=arg0.getParameter("name");
		
		System.out.println("参数："+name);
		
		arg0.setAttribute("name", name.toUpperCase());
		arg0.getRequestDispatcher("index.jsp").forward(arg0, arg1);
		
		
	}

	
	

}
