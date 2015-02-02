package ca.ualberta.cs.olexson_travel;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
    	int position = getIntent().getExtras().getInt("id");
    	EditText emailbody = (EditText) findViewById(R.id.emailbodyeditText);
		String claiminfo = ClaimListController.getClaimList().getClaims().get(position).emailString();
		emailbody.setText(claiminfo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}

    public void emailfinal(View view){
    	
    	EditText email = (EditText) findViewById(R.id.emaileditText);
    	String sEmail = email.toString();
    	int position = getIntent().getExtras().getInt("id");
		String claiminfo = ClaimListController.getClaimList().getClaims().get(position).emailString();
    	//https://stackoverflow.com/questions/8284706/send-email-via-gmail February 1, 2015
		Intent send = new Intent(Intent.ACTION_SENDTO);
		String uriText = "mailto:" + Uri.encode(sEmail) + 
		          "?subject=" + Uri.encode("Claim Emailed") + 
		          "&body=" + Uri.encode(claiminfo);
		Uri uri = Uri.parse(uriText);

		send.setData(uri);
		startActivity(Intent.createChooser(send, "Send mail..."));
    }
    
    
}
