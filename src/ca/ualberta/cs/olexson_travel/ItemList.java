package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

public class ItemList {
	ArrayList <Item> items;
	//add item to items
	//delete item from items

	public ItemList(ArrayList<Item> items) {
		super();
		this.items = items;
	}
	public ItemList(){
		super();
	}
	//add by date??
	public ArrayList <Item> addItem(Item item){
		this.items.add(item);
		return this.items;
	}
	public ArrayList<Item> deleteItem(Item item){
		this.items.remove(item);
		return this.items;
	}
}
