package day13;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	
	
	public void before() {
		
		
		System.out.println("之前做什么");
		
	}
	
	
	
	public void after() {
		
		
		System.out.println("之后做什么");
		
	}
	
	
	public Object log(ProceedingJoinPoint joinPoint) {
		
		System.out.println("之前做什么");
		
		System.out.println(joinPoint);
		
		System.out.println(joinPoint.getTarget());
		
		try {
			Object rt= joinPoint.proceed();
			
			System.out.println("之后做什么");
			return rt;
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
