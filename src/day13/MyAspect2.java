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
		
		
		System.out.println("之前做什么");
		
	}
	
	@After("pc()")
	public void after() {
		
		
		System.out.println("之后做什么");
		
	}
	
	
	
}
