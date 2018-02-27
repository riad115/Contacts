package com.example.contacts;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper{
	
	//Database Version 
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "contactsDB";

    //Contacts table name 
    private static final String TABLE_CONTACTS = "contacts";

    //Contacts Table Columns names 
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL= "email";
    
    
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PHONE + " TEXT," + KEY_EMAIL + " TEXT" + ")";       
        db.execSQL(CREATE_CONTACTS_TABLE);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed 
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
		
	}
	
	public void createContacts(Contacts contacts){
	       //for logging
        Log.d("addContacts", contacts.toString()); 
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName()); // get name
        values.put(KEY_PHONE, contacts.getPhone()); // get phone
        values.put(KEY_EMAIL, contacts.getEmail()); // get phone
 
        // 3. insert
        db.insert(TABLE_CONTACTS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close(); 
	}
	
	
	public List<Contacts> getContactsByName(String name){
		List<Contacts> allContacts = new ArrayList<Contacts>();
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " tc WHERE tc." + KEY_NAME + " LIKE '" + name+ "%'" ;
        Log.d("Query by name", selectQuery);
         
         SQLiteDatabase db = this.getReadableDatabase();
         Cursor c = db.rawQuery(selectQuery, null);
         
         if (c.moveToFirst()) {          
             do{
            	 Contacts con = new Contacts();
            
                 con.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                 con.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                 con.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));         
                 con.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                 allContacts.add(con);
             }while(c.moveToNext());
         }
		return allContacts;
	}
	
	
	public List<Contacts> getContactsByPhone(String phone){
		List<Contacts> allContacts = new ArrayList<Contacts>();
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " tc WHERE tc." + KEY_PHONE + " LIKE '" + phone+ "%'" ;
        Log.d("Query by phone", selectQuery);
         
         SQLiteDatabase db = this.getReadableDatabase();
         Cursor c = db.rawQuery(selectQuery, null);
         
         if (c.moveToFirst()) {          
             do{
            	 Contacts con = new Contacts();
                 con.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                 con.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                 con.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));         
                 con.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                 allContacts.add(con);
             }while(c.moveToNext());
         }
		return allContacts;
	}
	
	
	public  List<Contacts> getContactsByEmail(String email){
		List<Contacts> allContacts = new ArrayList<Contacts>();
		
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS + " tc WHERE tc." + KEY_EMAIL + " LIKE '" + email+ "%'" ;
        Log.d("Query by email", selectQuery);
         
         SQLiteDatabase db = this.getReadableDatabase();
         Cursor c = db.rawQuery(selectQuery, null);
         
         if (c.moveToFirst()) {          
             do{
            	 
            	 Contacts con = new Contacts();
                 con.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                 con.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                 con.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));         
                 con.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                 allContacts.add(con);
             }while(c.moveToNext());
         }
		return allContacts;
	}
	
}
