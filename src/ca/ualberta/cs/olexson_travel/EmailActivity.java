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
    	//doesn't work
    	
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
