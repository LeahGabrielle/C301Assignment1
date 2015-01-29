package ca.ualberta.cs.olexson_travel;

import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_claim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_claim, menu);
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
	//adds claim to ClaimList
	public void addClaimAction(View view){
		Toast.makeText(this,"adding a claim",Toast.LENGTH_SHORT).show();
		ClaimListController c = new ClaimListController();
		EditText editname=(EditText) findViewById(R.id.claimname_editfillText);
		EditText editdescription=(EditText) findViewById(R.id.claimdescription_editText);
		EditText editstatus=(EditText) findViewById(R.id.status_editText);
		Claim claim=new Claim(editname.getText().toString(),editdescription.getText().toString(),editstatus.getText().toString());
		//ClaimList claimlist = new ClaimList();
		//claimlist.addClaim(claim);
		c.addClaim(claim);
		//Toast.makeText(this, claim.getName(), Toast.LENGTH_SHORT).show();
    	//Intent intent = new Intent(NewClaimActivity.this,MainActivity.class);
    	//startActivity(intent);
	}
}
