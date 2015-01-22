package ca.ualberta.cs.olexson_travel;

import java.sql.Date;

public class Item {
	public String name;
	public String description;
	public String category;
	public Date date;
	
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
	
}
