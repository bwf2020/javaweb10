package day11;

import java.util.List;

public class Orders {

	
	private int id;
	private String code;
	
	
	//建立关系
	private List<OrdersItem> ordersItemList;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public List<OrdersItem> getOrdersItemList() {
		return ordersItemList;
	}


	public void setOrdersItemList(List<OrdersItem> ordersItemList) {
		this.ordersItemList = ordersItemList;
	}
	
	
	
	
	
	
	
	
}
