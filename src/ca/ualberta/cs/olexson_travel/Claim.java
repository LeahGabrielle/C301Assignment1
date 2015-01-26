package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

public class Claim {
	
	private ArrayList<ItemList> items;
	private String name;
	private String description;
	private String status;
	
	public Claim(){
		super();
	}
	public Claim(String name, String description, String status) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
	}	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
