package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.util.ArrayList;

public class Claim implements Serializable{
	
	private static final long serialVersionUID = -7556743916038416941L;
	public ArrayList<ItemList> items;
	public String name;
	public String description;
	public String status;
	//private Date startDate;
	//private Date endDate;
	
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
	public String toString(){
		return getName();
	}
	public boolean equals(Object compareClaim) {
		if (compareClaim != null && compareClaim.getClass()==this.getClass()) {
			return this.equals((Claim)compareClaim);
		} else {
			return false;
		}
	}
	public boolean equals(Claim compareClaim) {
		if(compareClaim==null) {
			return false;
		}
		return getName().equals(compareClaim.getName());
	}
	public int hashCode() {
		return ("Claim:"+getName()).hashCode();
	}
}
