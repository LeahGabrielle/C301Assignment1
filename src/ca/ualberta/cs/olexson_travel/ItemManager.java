package ca.ualberta.cs.olexson_travel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

public class ItemManager {
	static final String prefFile = "ItemList";
	static final String clKey = "itemList";
	
	Context context;
	
	static private ItemManager itemManager = null;
	
	public static void initManager(Context context){
		if (itemManager == null) {
			if (context==null){
				throw new RuntimeException("missing context for itemmanager");
			}
			itemManager = new ItemManager(context);
		}
	}
	public static ItemManager getManager(){
		if (itemManager==null){
			throw new RuntimeException("Did not initialize Manager");
		}
		return itemManager;
	}
	public ItemManager(Context context){
		this.context = context;
	}
	public ItemList loadItemList() throws ClassNotFoundException, IOException {
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		String itemListData=settings.getString(clKey, "");
		if (itemListData.equals("")){
			return new ItemList();
		} else {
			return itemListFromString(itemListData);
		}
	}
	
	static public ItemList itemListFromString(String itemListData) throws ClassNotFoundException, IOException{
		ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(itemListData, Base64.DEFAULT));
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (ItemList)oi.readObject();
	}
	static public String itemListToString(ItemList il) throws IOException{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(il);
		oo.close();
		byte bytes[] = bo.toByteArray();
		return Base64.encodeToString(bytes, Base64.DEFAULT);
	}
	public void saveItemList(ItemList il) throws IOException{
		SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
		Editor editor = settings.edit();
		editor.putString(clKey, itemListToString(il));
		editor.commit();
	}
}
