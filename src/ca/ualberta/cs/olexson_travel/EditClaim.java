package ca.ualberta.cs.olexson_travel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
//import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditClaim extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_claim);
		
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		int index = getIntent().getExtras().getInt("id");
		TextView claimName = (TextView) findViewById(R.id.editclaimnamefillText);
		String cName = ClaimListController.getClaimList().getClaims().get(index).getName();
		claimName.setText(cName);
		TextView claimStatus = (TextView) findViewById(R.id.editstatus_editText);
		String cStatus = ClaimListController.getClaimList().getClaims().get(index).getStatus();
		claimStatus.setText(cStatus);
		TextView claimD = (TextView) findViewById(R.id.editclaimdescription_editText);
		String cDescription = ClaimListController.getClaimList().getClaims().get(index).getDescription();
		claimD.setText(cDescription);
			
		TextView claimDate1 = (TextView) findViewById(R.id.editdaterange1editText);
		TextView claimDate2 = (TextView) findViewById(R.id.editdaterange2editText);
		Date start = ClaimListController.getClaimList().getClaims().get(index).getStartDate();
		Date end = ClaimListController.getClaimList().getClaims().get(index).getEndDate();
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.CANADA);
		String cStart = format.format(start);
		String cEnd = format.format(end);
		claimDate1.setText(cStart);
		claimDate2.setText(cEnd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}
	
	public void doneEditClaim(View view)throws ParseException{
		
		Toast.makeText(this,"editing claim",Toast.LENGTH_SHORT).show();
		ClaimListController c = new ClaimListController();
		
		
		//create new Claim Item with edited properties
		EditText editname=(EditText) findViewById(R.id.editclaimnamefillText);
		EditText editdescription=(EditText) findViewById(R.id.editclaimdescription_editText);
		EditText editstatus=(EditText) findViewById(R.id.editstatus_editText);
		EditText editstart = (EditText) findViewById(R.id.editdaterange1editText);
		EditText editend = (EditText) findViewById(R.id.editdaterange2editText);
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.CANADA);
		Date startdate = format.parse(editstart.getText().toString());
		Date enddate = format.parse(editend.getText().toString());
		
		Claim claim=new Claim(editname.getText().toString(),editdescription.getText().toString(),
				editstatus.getText().toString(), startdate, enddate);
		c.addClaim(claim);
		
		//delete unedited claim
		int index = getIntent().getExtras().getInt("id");
		ClaimListController.getClaimList().deleteClaim(ClaimListController.getClaimList().getClaims().get(index));
		
		editname.setText("");
		editdescription.setText("");
		editstatus.setText("");
		editstart.setText("");
		editend.setText("");
	}
}
