package day4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(urlPatterns="/*",initParams=@WebInitParam(name="t2",value="utf-8"))
public class Test2 implements Filter {
	
	
	
	public Test2() {
		
		
		
		System.out.println("过滤器1被实例化");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	
		
		System.out.println("开始过滤了...................................");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//判断过滤器链，有没有其他过滤器，如果没有则到目标资源
		chain.doFilter(request, response);
		
		/*PrintWriter out= response.getWriter();
		out.print("-BWF-博为峰");
		out.flush();
		out.close();*/
		
		System.out.println("结束过滤...................................");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
