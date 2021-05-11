package day2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet{
	
	private String encoding="";
	
	
	public Test1() {
		
		System.out.println("实例化对象");
		
		
	}
	
	

	
	public void init() throws ServletException {


			System.out.println("无参对象被初始化");
		
	}
	
	


	@Override
	public void init(ServletConfig config) throws ServletException {


		System.out.println("有参的初始化方法");
		System.out.println(config.getInitParameter("encoding"));
		this.encoding=config.getInitParameter("encoding");
		
	}




	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("service请求被调用了");
		
	    super.service(req, resp);

		
	}



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		System.out.println("test1的doget方法.......");
		
		doPost(req, resp);
		
	}
	
	




	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("默认编码："+req.getCharacterEncoding());
		req.setCharacterEncoding(this.encoding);
		System.out.println("修改后的编码："+req.getCharacterEncoding());
		
		resp.setCharacterEncoding(this.encoding);
		resp.setContentType("text/html;charset="+this.encoding);

		
		System.out.println("test1的dopost方法.......");
		
		//接受参数
				String p1=req.getParameter("a");
				System.out.println("参数1："+p1);
				
				String p2=req.getParameter("b");
				System.out.println("参数2："+p2);
				
				String[] aihao=req.getParameterValues("aihao");
				
				System.out.println("爱好："+Arrays.toString(aihao));
				
				Enumeration names=req.getParameterNames();
				
				System.out.println(names);
				
				while(names.hasMoreElements()) {
					
					
					System.out.println(names.nextElement());
					
				}
				
				System.out.println("=================");
				
				
				Map map= req.getParameterMap();
				
				System.out.println(map);
				
				Set<Entry<String, String[]>> set= map.entrySet();
				
				for (Entry<String, String[]> entry : set) {
					
					System.out.println("参数名字："+entry.getKey()+"  值："+Arrays.toString(entry.getValue()));
					
				}
				
				System.out.println("=================");
				
				Set names2= map.keySet();
				System.out.println(names2);
				
				for (Object n : names2) {
					System.out.println("参数名字："+n+" 值："+Arrays.toString((String[])map.get(n)));
				}
				
				
				System.out.println("======往页面上输出内容========");
				
				//resp.sendError(408, "自定义的错误信息");
				
				PrintWriter out= resp.getWriter();
				
				out.print("<html>");
				out.print("<head><link href='my.css' rel='stylesheet'/></head>");
				out.print("<body>");
				out.print("<div style='color:red'>"+req.getParameter("name")+"</div>");
				out.print("<span>i am span tag</span>");
				out.print("</body>");
				out.print("</html>");
		/*		out.flush();
				out.close();*/
				
				
				System.out.println("======页面重定向====");
				
				//resp.sendRedirect("test2");
				
				System.out.println("=====页面转发====");
				
				//req.getRequestDispatcher("test2").forward(req, resp);
				
				System.out.println("=====中文====");
				
				String str=req.getParameter("str");
				
				System.out.println(str);
				
				out.print(str);
				
				
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
