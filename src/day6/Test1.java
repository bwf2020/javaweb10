package day6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		//接受参数
		String account=req.getParameter("account");
		String pwd=req.getParameter("pwd");

		//调用业务层数据
		
		
		//封装属性数据
		req.setAttribute("account", account);
		
		//跳转页面
		req.getRequestDispatcher("test9.jsp").forward(req, resp);
		
	}

	
	
}
