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

public class ItemList implements Serializable{

	private static final long serialVersionUID = 3670169367651080280L;
	protected ArrayList <Item> items=null;

	protected transient ArrayList<Listener> listeners = null;
	
	public ItemList(ArrayList<Item> items) {
		super();
		this.items = items;
		listeners = new ArrayList<Listener>();
	}
	public ItemList(){
		super();
		listeners = new ArrayList<Listener>();
		items = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	//add an item to the list of items, not ordered by date
	public void addItem(Item item){
		this.items.add(item);
		notifyListeners();
		//return this.items;
	}
	//delete an item from the list of items
	public ArrayList<Item> deleteItem(Item item){
		this.items.remove(item);
		notifyListeners();
		return this.items;
	}
	private void notifyListeners() {
		for (Listener listener:getListeners()){
			listener.update();
		}
	}
	
	private ArrayList<Listener> getListeners(){
		if (listeners==null){
			listeners = new ArrayList<Listener>();
		}
		return listeners;
	}
	public void addListener(Listener l){
		getListeners().add(l);
	}
	
	public void removeListener(Listener l){
		getListeners().remove(l);
	}
	
}
