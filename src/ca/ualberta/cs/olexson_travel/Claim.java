package ca.ualberta.cs.olexson_travel;

//import java.util.Collection;

public class Claim {
	
	//Claim has an ItemList inside.
	public String name;
	public String description;
	public String status;
	
	public Claim(){
		super();
	}
	public Claim( String name) {
		super();
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
