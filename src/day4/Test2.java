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
		
		
		
		System.out.println("������1��ʵ����");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	
		
		System.out.println("��ʼ������...................................");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//�жϹ�����������û�����������������û����Ŀ����Դ
		chain.doFilter(request, response);
		
		/*PrintWriter out= response.getWriter();
		out.print("-BWF-��Ϊ��");
		out.flush();
		out.close();*/
		
		System.out.println("��������...................................");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
