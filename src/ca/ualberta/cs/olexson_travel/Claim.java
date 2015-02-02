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
import java.util.ArrayList;
import java.util.Date;

public class Claim implements Serializable{
	
	private static final long serialVersionUID = -7556743916038416941L;
	public ArrayList<Item> items;
	public String name;
	public String description;
	public String status;
	private Date startDate;
	private Date endDate;
	
	public Claim(){
		super();
	}
	public Claim(String name, String description, String status, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.endDate = endDate;
		this.startDate = startDate;
	}	
	
	
	
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
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
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String emailString(){
		//formats all claim info into a string for emailing
		String body = new String();
		body= (this.name+"\n"+this.startDate.toString()+" - "+this.endDate.toString()
		+"\n"+this.description+"\n"+this.status+"\n");
		return body;
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
