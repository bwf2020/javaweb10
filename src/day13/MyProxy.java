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
		
		
		System.out.println("��ʼ����");
		System.out.println("֮ǰ��ʲô");

		
		Object rt =method.invoke(target);//����Ŀ���е���ʵ�ķ���
		
		System.out.println("֮����ʲô");
		System.out.println("�ύ����");

		
		return rt;
	}
	
	
}
