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
