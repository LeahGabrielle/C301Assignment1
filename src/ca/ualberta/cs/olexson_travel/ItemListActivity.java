package ca.ualberta.cs.olexson_travel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ItemListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_list);
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
