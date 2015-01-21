package ca.ualberta.cs.olexson_travel;

import java.util.Collection;

public class Claim {
	
	public Collection <Item> items;
	public String name;
	public String description;
	public String status;
	
	public Claim(){
		super();
	}
	public Claim(Collection<Item> items, String name) {
		super();
		this.items = items;
		this.name = name;
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
