package day10;

import java.util.List;

import day11.OrdersItem;
import day9.Category;

public class Product {

	
	
	private int id;
	private String name;
	private float price;
	
	
	//建立关系 多对一的关系
	private Category category;
	
	//建立关系
	private List<OrdersItem> ordersItemList;
	
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
