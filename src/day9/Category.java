package day9;

import java.util.List;

import day10.Product;

public class Category {

	
	private Integer id;
	
	private String name;
	
	
	//������ϵ  һ�Զ�Ĺ�ϵ
	
	private List<Product> products;
	
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
