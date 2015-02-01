package ca.ualberta.cs.olexson_travel;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
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
        		TextView claimamt = (TextView) findViewById(R.id.costcurrency_alltextView);
        		String actext = new String();
        		ArrayList<AmountCurrency> amount = new ArrayList<AmountCurrency>();
        		for (AmountCurrency amtcurfinal:amount){
        			actext = actext+"\n"+amtcurfinal.getAmount().toString()+" "+amtcurfinal.getCurrency().toString();
        		}
        		claimamt.setText(actext);
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
        
        listview.setOnItemLongClickListener(new OnItemLongClickListener(){
        	@Override
        	public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
        		AlertDialog.Builder adb = new AlertDialog.Builder(ItemListActivity.this);
        		adb.setMessage("Delete "+list.get(position).toString()+"?");
        		adb.setCancelable(true);
        		final int finalPosition = position;
        		adb.setPositiveButton("Delete", new OnClickListener(){
        			@Override
        			public void onClick(DialogInterface dialog, int which){
        				Item item = list.get(finalPosition);
        				ItemController.getItemList().deleteItem(item);
        			}
        		});
        		adb.setNegativeButton("Cancel",new OnClickListener(){
        			@Override
        			public void onClick(DialogInterface dialog, int which){
        			}
        		});
        		adb.show();
        		return false;
        	}
        });
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		
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
		
		
		//TODO fix list of AmountCurrencies
		ArrayList<Item> itemslist = ItemController.getItemList().getItems();
		ArrayList<AmountCurrency> amount = new ArrayList<AmountCurrency>();
		amount.clear();
		
		for (Item item:itemslist){
			amount.add(item.getAmountcurrency());
		}
		ArrayList<AmountCurrency> totals = new ArrayList<AmountCurrency>();
		totals.clear();
		
		int ind=0;
		for (int j=0;j<amount.size();j++){
			boolean state = false;
			for (int i=0;i<totals.size();i++){
				if (totals.get(i).getCurrency().equals(amount.get(j).getCurrency())){
					state=true;
					ind= i;
					break;
				}		
			}
			if (state==true){
				BigDecimal value = totals.get(ind).getAmount();
				BigDecimal value2 = amount.get(j).getAmount();
				BigDecimal value3 = value.add(value2);
				totals.add(new AmountCurrency(value3,totals.get(ind).getCurrency()));
				totals.remove(ind);

			}
			else{
				totals.add(amount.get(j));
			}
		}
		
		TextView claimamt = (TextView) findViewById(R.id.costcurrency_alltextView);
		String actext = new String();
		for (AmountCurrency amtcurfinal:totals){
			actext = actext+"\n"+amtcurfinal.getAmount().toString()+" "+amtcurfinal.getCurrency().toString();
		}
		claimamt.setText(actext);
		actext="";
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
    
    public void editClaim(View view){
    	
    	//TODO put in status condition
    	
    	Toast.makeText(this,"edit claim",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(ItemListActivity.this,EditClaim.class);
    	int index = getIntent().getExtras().getInt("id");
    	intent.putExtra("id", index);
    	startActivity(intent);
    }
//    public void email(View view){
//    	Intent emailIntent = new Intent(Intent.ACTION_SEND);
//    	
//    }
    
    
}
