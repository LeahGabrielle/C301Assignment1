package ca.ualberta.cs.olexson_travel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_list);
		
        ItemManager.initManager(this.getApplicationContext());
        
        ListView listview= (ListView)findViewById(R.id.itemlistView);
        ArrayList<Item> items= ItemController.getItemList().getItems();
        final ArrayList<Item> list = new ArrayList<Item>(items);      
        final ArrayAdapter<Item>itemAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(itemAdapter);
		
        ItemController.getItemList().addListener(new Listener(){ 
        	@Override
        	public void update(){
        		list.clear();
        		ArrayList<Item> items = ItemController.getItemList().getItems();
        		list.addAll(items);
        		itemAdapter.notifyDataSetChanged();
        	}
        });
        
        listview.setOnItemClickListener(new OnItemClickListener(){
        	@Override
        	public void onItemClick(AdapterView<?>parent,View view, int position, long id){
        		Intent intent= new Intent(ItemListActivity.this,ExpenseItemsActivity.class);
        		intent.putExtra("id",position);
        		startActivity(intent);
        	}
        });
        
		int index = getIntent().getExtras().getInt("id");
		TextView claimName = (TextView) findViewById(R.id.claim_itemlisttextView);
		String cName = ClaimListController.getClaimList().getClaims().get(index).getName();
		claimName.setText(cName);
		TextView claimStatus = (TextView) findViewById(R.id.claimstatustextView);
		String cStatus = ClaimListController.getClaimList().getClaims().get(index).getStatus();
		claimStatus.setText(cStatus);
		TextView claimD = (TextView) findViewById(R.id.claimdescriptioninfotextView);
		String cDescription = ClaimListController.getClaimList().getClaims().get(index).getDescription();
		claimD.setText(cDescription);
		
		TextView claimDates = (TextView) findViewById(R.id.daterangeStringtextView);
		Date start = ClaimListController.getClaimList().getClaims().get(index).getStartDate();
		Date end = ClaimListController.getClaimList().getClaims().get(index).getEndDate();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.CANADA);
		String cStart = format.format(start);
		String cEnd = format.format(end);
		claimDates.setText(cStart+"-"+cEnd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.item_list, menu);
		return true;
	}
    public void newItem(View view){
    	Toast.makeText(this,"new Item",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(ItemListActivity.this,NewItemActivity.class);
    	startActivity(intent);
    }
}
