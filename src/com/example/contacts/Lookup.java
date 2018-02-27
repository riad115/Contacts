package com.example.contacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lookup extends Activity {
	
	private EditText txtName ;
	private EditText txtPhone ;
	private EditText txtEmail ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lookup);
		
		txtName = (EditText) findViewById(R.id.editText4);
		txtPhone = (EditText) findViewById(R.id.editText5);
		/*Set Input Type as Phone Number*/
			//txtPhone.setInputType(InputType.TYPE_CLASS_PHONE); 
			/*Phone Number formatting*/
			txtPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		txtEmail = (EditText) findViewById(R.id.editText6);
		
		
Button button = (Button) findViewById(R.id.btnSearchContacts);
		
		// Capture button clicks
		 		button.setOnClickListener(new OnClickListener() {
		 			public void onClick(View arg0) {
		 				String name = txtName.getText().toString();
		 				String phone = txtPhone.getText().toString();
		 				
		 				String email = txtEmail.getText().toString();
		 				
		 				//Contacts contact = new Contacts(name, phone, email);
		 				//MainActivity.db.createContacts(contact);
		 				
		 				if(name.length()!=0 && phone.length()==0 && email.length()==0){
		 				// Start NewActivity.class
			 				Intent myIntent = new Intent(Lookup.this,
			 						Results.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 				myIntent.putExtra("Name", name);
			 				myIntent.putExtra("Id", (int)1);
			 				startActivity(myIntent);
			 				//finish();
		 				}
		 				
		 				else if(phone.length()!=0 && name.length()==0 && email.length()==0){
		 				// Start NewActivity.class
			 				Intent myIntent = new Intent(Lookup.this,
			 						Results.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 				myIntent.putExtra("Phone", phone);
			 				myIntent.putExtra("Id", (int)2);
			 				startActivity(myIntent);
			 				//finish();
		 				}
		 				
		 				else if(email.length()!=0 && name.length()==0 && phone.length()==0){
		 				// Start NewActivity.class
			 				Intent myIntent = new Intent(Lookup.this,
			 						Results.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 				myIntent.putExtra("Email", email);
			 				myIntent.putExtra("Id", (int)3);
			 				startActivity(myIntent);
			 				//finish();
		 				}
		 				
		 				else{
		 					Toast.makeText(Lookup.this, "Enter one of the ",
		 			        	      Toast.LENGTH_LONG).show();
		 				}
		 				
		 			}
		 		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lookup, menu);
		return true;
	}

}
