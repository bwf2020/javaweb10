package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{
	
	
	
	public Test1() {
		
		System.out.println("ʵ��������");
		
		
	}
	
	

	
	public void init() throws ServletException {


			System.out.println("���󱻳�ʼ��");
		
	}
	




	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("service���󱻵�����");
		
	    super.service(req, resp);

		
	}



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		System.out.println("test1��doget����.......");
		
	}




	public void destroy() {


		System.out.println("��������.........");
		
		
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
