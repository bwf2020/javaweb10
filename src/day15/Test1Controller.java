package day15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class Test1Controller implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {


		System.out.println("«Î«Û¡Àday15 test1");
		
		String name=arg0.getParameter("name");
		arg0.setAttribute("name", name.toUpperCase());
		
		
		arg0.getRequestDispatcher("index").forward(arg0, arg1);

	}

}
