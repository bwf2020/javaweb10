package day3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name="bwf";
		
		req.setAttribute("name", "bwf_request");
		
		HttpSession session=req.getSession();
		session.setAttribute("name", "bwf_session");
		
		ServletContext context=this.getServletContext();
		context.setAttribute("name", "bwf_context");
		
		System.out.println("�ֲ�������"+name);
		System.out.println("3-5 req:"+req.getAttribute("name"));

		

		//�ڲ�ͬ�����й�������
		
		//req.getRequestDispatcher("test3-6").forward(req, resp);
		
		resp.sendRedirect("test3-6");
		
	}

	
	
	
	
	
}
