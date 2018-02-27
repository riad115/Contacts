package com.example.contacts;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity {
	
	
	public static MySQLiteHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        db = new  MySQLiteHelper(getApplicationContext());
		
		// Locate the button in activity_main.xml
 		Button buttonAdd = (Button) findViewById(R.id.btnAdd);
  
 		// Capture button clicks
 		buttonAdd.setOnClickListener(new OnClickListener() {
 			public void onClick(View arg0) {
  
 				// Start NewActivity.class
 				Intent myIntent = new Intent(MainActivity.this,
 						AddContacts.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 				startActivity(myIntent);
 			}
 		});
 		
 		
 	// Locate the button in activity_main.xml
 		Button buttonSearch = (Button) findViewById(R.id.btnSearch);
  
 		// Capture button clicks
 		buttonSearch.setOnClickListener(new OnClickListener() {
 			public void onClick(View arg0) {
  
 				// Start NewActivity.class
 				Intent myIntent = new Intent(MainActivity.this,
 						Lookup.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 				startActivity(myIntent);
 			}
 		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
