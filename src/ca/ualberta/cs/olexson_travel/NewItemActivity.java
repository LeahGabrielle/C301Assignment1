package ca.ualberta.cs.olexson_travel;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
//import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_item, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void addItemAction(View view) throws ParseException{
		Toast.makeText(this,"adding an Item",Toast.LENGTH_SHORT).show();
		ItemController c = new ItemController();
		//uses given info to create a new Item object
		EditText editname=(EditText) findViewById(R.id.itemname_editText);
		EditText editdescription=(EditText) findViewById(R.id.itemdescription_editText);
		EditText editcategory=(EditText) findViewById(R.id.categoryeditText);
		
		EditText editamount = (EditText) findViewById(R.id.amounteditText);
		EditText editcurrency = (EditText) findViewById(R.id.itemcurrencyeditText);
		EditText editdate = (EditText) findViewById(R.id.itemdate_editText);
		
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.CANADA);
		Date date = format.parse(editdate.getText().toString());
		
		BigDecimal amt = new BigDecimal(editamount.getText().toString());
		AmountCurrency amtcur = new AmountCurrency(amt, editcurrency.getText().toString());
		
		Item item = new Item(editname.getText().toString(),editdescription.getText().toString(),
				editcategory.getText().toString(), date, amtcur);
		c.addItem(item);
		//sets fields to empty so can put in another item
		editname.setText("");
		editdescription.setText("");
		editcategory.setText("");
		editamount.setText("");
		editcurrency.setText("");
		editdate.setText("");
	}
}
