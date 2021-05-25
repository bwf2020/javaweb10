package day13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler{

	
	
	private Object target;
	
	public Object getProxy(Object target) {
		
		this.target=target;
		
		Object proxy= Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		
		return proxy;
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		System.out.println("开始事务");
		System.out.println("之前做什么");

		
		Object rt =method.invoke(target);//唤醒目标中的真实的方法
		
		System.out.println("之后做什么");
		System.out.println("提交事务");

		
		return rt;
	}
	
	
}
