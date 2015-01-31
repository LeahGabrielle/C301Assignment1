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
	
	//add by date??
	//add an item to the list of items
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
