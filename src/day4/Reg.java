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


		
		//ʵ��ҵ���߼�
		
		String account=req.getParameter("account");
		String pwd=req.getParameter("pwd");
		
		//����ע��
		if(this.account.equals("")) {
			System.out.println("�˺ţ�"+account+" ���룺"+pwd+" ���浽���ݿ���");
			this.account=account;
			req.getRequestDispatcher("userUI").forward(req, resp);
		}else {
			
			req.setAttribute("error", "���˺��Ѿ�����");
			req.getRequestDispatcher("reg.html").forward(req, resp);
		}
		
	}

	
	
	
	
}
