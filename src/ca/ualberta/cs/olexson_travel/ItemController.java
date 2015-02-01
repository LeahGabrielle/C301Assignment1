package ca.ualberta.cs.olexson_travel;

import java.io.IOException;

public class ItemController {
	
	private static ItemList itemlist = null;
	//Warning: throws runTimeException
	static public ItemList getItemList() {
		if (itemlist ==null){
			try{
				itemlist = ItemManager.getManager().loadItemList();
				itemlist.addListener(new Listener() {
					@Override
					public void update(){
						saveItemList();
					}
				});
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException ("Could not deserialize ItemList from ItemManager");	
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Could not deserialize ItemList from ItemManager");
			}
		}
		return itemlist;
	}
	static public void saveItemList() {
		try {
			ItemManager.getManager().saveItemList(getItemList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Could not deserialize ItemList from ItemManager");
		}
	}

	public void addItem(Item item) {
		getItemList().addItem(item);
	}
}
