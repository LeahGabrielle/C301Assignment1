package ca.ualberta.cs.olexson_travel;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	public ListView claimList;
	//private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ClaimListManager.initManager(this.getApplicationContext());
        
        ListView listview= (ListView)findViewById(R.id.claimlistView);
        ArrayList<Claim> claims= ClaimListController.getClaimList().getClaims();
        final ArrayList<Claim> list = new ArrayList<Claim>(claims);      
        //put names of claims as an arraylist of strings??
        final ArrayAdapter<Claim>claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(claimAdapter);

    }

    ClaimListController.getClaimList().addListener(new Listener(){ 
    	@Override
    	public void update(){
    		list.clear();
    		ArrayList<Claim> claims = ClaimListController.getClaimList().getClaims();
    		list.addAll(claims);
    		claimAdapter.notifyDataSetChanged();
    	}
    });
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void newClaim(View view){
    	Toast.makeText(this,"new claim",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,NewClaimActivity.class);
    	startActivity(intent);
    }
    /*
    public void onListItemClick(ListView listview, View view){
    	//nothing in list yet
    	Toast.makeText(this,"claim clicked",Toast.LENGTH_SHORT).show();
    } */
}
