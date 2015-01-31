package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

public class ItemList {
	ArrayList <Item> items;
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
	//add by date??
	//add an item to the list of items
	public ArrayList <Item> addItem(Item item){
		this.items.add(item);
		notifyListeners();
		return this.items;
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
}
