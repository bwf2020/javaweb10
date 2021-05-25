package day13;

import org.apache.ibatis.annotations.Insert;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect2 {
	
	@Pointcut("execution(* day13.UserService.*(..))")
	public void pc() {
		
		
	}

	@Before("pc()")
	public void before() {
		
		
		System.out.println("֮ǰ��ʲô");
		
	}
	
	@After("pc()")
	public void after() {
		
		
		System.out.println("֮����ʲô");
		
	}
	
	
	
}
