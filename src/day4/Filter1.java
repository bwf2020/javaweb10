package day4;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter {

	
	public Filter1() {
		
		System.out.println("������1111111��ʵ����............................");
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		System.err.println("��ʼ����11111111111111111111");
		chain.doFilter(request, response);
		System.err.println("��������11111111111111111111");
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
