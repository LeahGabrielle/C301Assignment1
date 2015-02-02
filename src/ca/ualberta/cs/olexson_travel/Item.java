    //Copyright (C) 2015 Leah Olexson

    //This program is free software; you can redistribute it and/or modify
    //it under the terms of the GNU General Public License as published by
    //the Free Software Foundation; either version 2 of the License, or
    //(at your option) any later version.

    //This program is distributed in the hope that it will be useful,
    //but WITHOUT ANY WARRANTY; without even the implied warranty of
    //MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    //GNU General Public License for more details.

    //You should have received a copy of the GNU General Public License along
    //with this program; if not, write to the Free Software Foundation, Inc.,
    //51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
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
