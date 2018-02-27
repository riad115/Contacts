package com.example.contacts;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Results extends Activity {
	private String name;
	private String phone;
	private String email;
	private int Id;
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		List<Contacts> contactResults = new ArrayList<Contacts>();
		
		//Intent i = getIntent();
		Bundle extras = getIntent().getExtras();
        // getting attached intent data
        Id = extras.getInt("Id");
        
        if(Id==1){
            name = extras.getString("Name");
            contactResults = MainActivity.db.getContactsByName(name);
        }
        
        else if(Id==2){
            phone = extras.getString("Phone");
            contactResults = MainActivity.db.getContactsByPhone(phone); 
        }
        
        else{
            email = extras.getString("Email");
            contactResults = MainActivity.db.getContactsByEmail(email);
        }
        
        for (Contacts con : contactResults) {
       	 Log.d("Name:"+con.getName(),"Phone:"+ con.getPhone()+"Email:"+con.getEmail());
       }
        
        list = (ListView)findViewById(R.id.listview);
        list.setItemsCanFocus(false);
        list.setAdapter(new CustomBaseAdapter(Results.this, contactResults));
        
        list.setOnItemClickListener(new OnItemClickListener() {

        	   @Override
        	   public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        	    Log.i("List View Clicked", "**********");
        	    Toast.makeText(Results.this,
        	      "List View Clicked:" + position, Toast.LENGTH_LONG)
        	      .show();
        	   }
        	  });

        	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
