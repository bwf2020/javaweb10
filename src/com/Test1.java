package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{
	
	
	
	public Test1() {
		
		System.out.println("实例化对象");
		
		
	}
	
	

	
	public void init() throws ServletException {


			System.out.println("对象被初始化");
		
	}
	




	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("service请求被调用了");
		
	    super.service(req, resp);

		
	}



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		System.out.println("test1的doget方法.......");
		
	}




	public void destroy() {


		System.out.println("对象被销毁.........");
		
		
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	

}
