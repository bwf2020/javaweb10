package day4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUI extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		PrintWriter out=resp.getWriter();
		out.print("<html>");
		
		out.print("<body>");
		
		out.print("显示用户详细信息");
	
		out.print("</body>");
		out.print("</html>");
		
		
	}
	
	
	
	

}
