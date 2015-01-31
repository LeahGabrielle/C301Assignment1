package ca.ualberta.cs.olexson_travel;

import java.io.Serializable;
import java.util.Date;


public class Item implements Serializable{

	private static final long serialVersionUID = 4276436818531151760L;
	
	private String name;
	private String description;
	private String category;
	private Date date;
	private AmountCurrency amountcurrency;
	
	public Item(String name, String description, String category, Date date, AmountCurrency amountcurrency) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.date = date;
		this.amountcurrency=amountcurrency;
	}
	public Item(){
		super();
	}
	public AmountCurrency getAmountcurrency() {
		return amountcurrency;
	}
	public void setAmountcurrency(AmountCurrency amountcurrency) {
		this.amountcurrency = amountcurrency;
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
	public String toString(){
		return getName();
	}
	public boolean equals(Object compareItem) {
		if (compareItem != null && compareItem.getClass()==this.getClass()) {
			return this.equals((Item)compareItem);
		} else {
			return false;
		}
	}
	public boolean equals(Item compareItem) {
		if(compareItem==null) {
			return false;
		}
		return getName().equals(compareItem.getName());
	}
	public int hashCode() {
		return ("Item:"+getName()).hashCode();
	}
	
}
