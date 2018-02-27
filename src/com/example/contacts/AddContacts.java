package com.example.contacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContacts extends Activity {
	
	private EditText txtName ;
	private EditText txtPhone ;
	private EditText txtEmail ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_contacts);
		
		txtName = (EditText) findViewById(R.id.editText1);
		txtPhone = (EditText) findViewById(R.id.editText2);
		/*Set Input Type as Phone Number*/
			//txtPhone.setInputType(InputType.TYPE_CLASS_PHONE); 
			/*Phone Number formatting*/
			txtPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		txtEmail = (EditText) findViewById(R.id.editText3);
		
		Button button = (Button) findViewById(R.id.btnAddContacts);
		
		// Capture button clicks
		 		button.setOnClickListener(new OnClickListener() {
		 			public void onClick(View arg0) {
		 				String name = txtName.getText().toString();
		 				String phone = txtPhone.getText().toString();
		 				
		 				String email = txtEmail.getText().toString();
		 				
		 				Contacts contact = new Contacts(name, phone, email);
		 				MainActivity.db.createContacts(contact);
		 				
		 				Log.i("Contact added ", "**********");
		        	    Toast.makeText(AddContacts.this, "Contact added successfully ",
		        	      Toast.LENGTH_LONG).show();
		 				// Start NewActivity.class
		 				Intent myIntent = new Intent(AddContacts.this,
		 						MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 				startActivity(myIntent);
		 				finish();
		 			}
		 		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_contacts, menu);
		return true;
	}

}
