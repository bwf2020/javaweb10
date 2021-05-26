package day4;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {

	
	public Filter2() {
		
		System.out.println("过滤器2222222被实例化............................");
		
	}
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


			System.err.println("开始过滤222222222222222222222222");
			chain.doFilter(request, response);
			System.err.println("结束过滤22222222222222222222222222");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
