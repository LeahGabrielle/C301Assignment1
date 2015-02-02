    // Claim Tracker App
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

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//centering text in xml
//http://stackoverflow.com/questions/432037/how-do-i-center-text-horizontally-and-vertically-in-a-textview-in-android Jan 30, 2015

public class MainActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ClaimListManager.initManager(this.getApplicationContext());
        
        ListView listview= (ListView)findViewById(R.id.claimlistView);
        ArrayList<Claim> claims= ClaimListController.getClaimList().getClaims();
        final ArrayList<Claim> list = new ArrayList<Claim>(claims);      
        final ArrayAdapter<Claim>claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(claimAdapter);
 

        ClaimListController.getClaimList().addListener(new Listener(){ 
        	@Override
        	public void update(){
        		list.clear();
        		ArrayList<Claim> claims = ClaimListController.getClaimList().getClaims();
        		list.addAll(claims);
        		claimAdapter.notifyDataSetChanged();
        	}
        });
        
        listview.setOnItemClickListener(new OnItemClickListener(){
        	@Override
        	public void onItemClick(AdapterView<?>parent,View view, int position, long id){
        		Intent intent= new Intent(MainActivity.this,ItemListActivity.class);
        		intent.putExtra("id",position);
        		startActivity(intent);
        	}
        });
        
        listview.setOnItemLongClickListener(new OnItemLongClickListener(){
        	@Override
        	public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
        		AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        		adb.setMessage("Delete "+list.get(position).toString()+"?");
        		adb.setCancelable(true);
        		final int finalPosition = position;
        		adb.setPositiveButton("Delete", new OnClickListener(){
        			@Override
        			public void onClick(DialogInterface dialog, int which){
        				Claim claim = list.get(finalPosition);
        				ClaimListController.getClaimList().deleteClaim(claim);
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
    	//takes to NewClaimActivity to create a new claim
    	Toast.makeText(this,"new claim",Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this,NewClaimActivity.class);
    	startActivity(intent);
    }
}
