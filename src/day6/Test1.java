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


		//���ܲ���
		String account=req.getParameter("account");
		String pwd=req.getParameter("pwd");

		//����ҵ�������
		
		
		//��װ��������
		req.setAttribute("account", account);
		
		//��תҳ��
		req.getRequestDispatcher("test9.jsp").forward(req, resp);
		
	}

	
	
}
