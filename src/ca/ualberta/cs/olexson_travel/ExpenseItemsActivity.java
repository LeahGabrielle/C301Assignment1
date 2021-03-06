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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ExpenseItemsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expense_items);
		//sets info about Item
		int index = getIntent().getExtras().getInt("id");
		TextView itemName = (TextView) findViewById(R.id.ItemstextView);
		String iName = ItemController.getItemList().getItems().get(index).getName();
		itemName.setText(iName);
		TextView itemCategory = (TextView) findViewById(R.id.item_categorytextView);
		String iCategory = ItemController.getItemList().getItems().get(index).getCategory();
		itemCategory.setText(iCategory);
		TextView itemDescription = (TextView) findViewById(R.id.descriptionitemtextView);
		String iDescription = ItemController.getItemList().getItems().get(index).getDescription();
		itemDescription.setText(iDescription);
		
		TextView itemDate = (TextView) findViewById(R.id.item_datetextView);
		Date idate = ItemController.getItemList().getItems().get(index).getDate();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.CANADA);
		String itemdate = format.format(idate);
		itemDate.setText(itemdate);
		
		TextView itemAmountCurrency = (TextView) findViewById(R.id.item_costcurrencytextView);
		String amount = ItemController.getItemList().getItems().get(index).getAmountcurrency().getAmount().toString();
		String currency = ItemController.getItemList().getItems().get(index).getAmountcurrency().getCurrency().toString();
		itemAmountCurrency.setText(amount+" "+currency);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense_items, menu);
		return true;
	}

}
