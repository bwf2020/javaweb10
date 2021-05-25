package day13;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	
	
	public void before() {
		
		
		System.out.println("֮ǰ��ʲô");
		
	}
	
	
	
	public void after() {
		
		
		System.out.println("֮����ʲô");
		
	}
	
	
	public Object log(ProceedingJoinPoint joinPoint) {
		
		System.out.println("֮ǰ��ʲô");
		
		System.out.println(joinPoint);
		
		System.out.println(joinPoint.getTarget());
		
		try {
			Object rt= joinPoint.proceed();
			
			System.out.println("֮����ʲô");
			return rt;
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
