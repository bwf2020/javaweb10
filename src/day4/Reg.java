package day4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reg extends HttpServlet {

	
	private String account="";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		//实现业务逻辑
		
		String account=req.getParameter("account");
		String pwd=req.getParameter("pwd");
		
		//进行注册
		if(this.account.equals("")) {
			System.out.println("账号："+account+" 密码："+pwd+" 保存到数据库中");
			this.account=account;
			req.getRequestDispatcher("userUI").forward(req, resp);
		}else {
			
			req.setAttribute("error", "此账号已经存在");
			req.getRequestDispatcher("reg.html").forward(req, resp);
		}
		
	}

	
	
	
	
}
