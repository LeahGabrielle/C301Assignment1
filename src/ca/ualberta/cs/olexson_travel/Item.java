package ca.ualberta.cs.olexson_travel;

import java.sql.Date;

public class Item {
	private String name;
	private String description;
	private String category;
	private Date date;
	
	public Item(String name, String description, String category, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.date = date;
	}
	public Item(){
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
