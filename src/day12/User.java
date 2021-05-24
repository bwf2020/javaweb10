package day12;

import java.util.List;

public class User {

	private int id;

	private String name;
	
	public User() {}
	
	public User(int id2,String name2) {
		
		this.id=id2;
		this.name=name2;
	}
	

	
	private List<Tel> telList;


	public List<Tel> getTelList() {
		return telList;
	}

	public void setTelList(List<Tel> telList) {
		this.telList = telList;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
