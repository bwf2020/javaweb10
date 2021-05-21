package day11;

import day10.Product;

public class OrdersItem {

	
	private int id;
	
	private int num;
	
	
	//建立和产品的关系
	private Product product;
	
	//建立和订单的关系
	private Orders orders;
	
	


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
	
}
