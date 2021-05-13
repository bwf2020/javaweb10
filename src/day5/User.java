package day5;

import java.io.Serializable;

public class User implements Serializable{

	
	private int id;
	private String name3;
	
	private String myTel;
	
	private String mAddress;
	

	
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getMyTel() {
		return myTel;
	}
	public void setMyTel(String myTel) {
		this.myTel = myTel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name) {
		this.name3 = name;
	}
	
	
	
}
