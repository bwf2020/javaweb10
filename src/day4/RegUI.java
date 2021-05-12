package day4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegUI extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		PrintWriter out=resp.getWriter();
		out.print("<html>");
		
		out.print("<body>");
		
		out.print("<form action='reg'>");
		out.print("<input name='account'/> <br/>");
		out.print("<input name='pwd' type='password'/> <br/>");
		out.print("<span style='color:red'>"+(req.getAttribute("error")==null?"":req.getAttribute("error"))+"</span><br/>");
		out.print("<input type='submit' value='зЂВс'>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
		
	}
	
	
	
	

}
