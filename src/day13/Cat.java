package day13;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Cat {

	
	@Value(value="100")
	private int a;
	
	@Value("#{{'zhangsan','lisi','wangwu'}}")
	private String[] b;
	
	@Value("${list}")
	private List c;
	
	
	public List getC() {
		return c;
	}

	public void setC(List c) {
		this.c = c;
	}

	private int[] arrays;
	
	private List list;
	
	private Map map;
	
	
	


	public String[] getB() {
		return b;
	}

	public void setB(String[] b) {
		this.b = b;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int[] getArrays() {
		return arrays;
	}

	public void setArrays(int[] arrays) {
		this.arrays = arrays;
	}
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	
	
	
}
