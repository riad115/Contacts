package com.example.contacts;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomBaseAdapter extends BaseAdapter{
	
	 private static List<Contacts> searchList;
	 private LayoutInflater mInflater;
	 private final Context _context;
	 
	 public CustomBaseAdapter(Context context, List<Contacts> results) {
		    _context = context;
	        searchList = results;
	        mInflater = LayoutInflater.from(context);
	    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return searchList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return searchList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.view_row, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.custom1);
            holder.txtPhone = (TextView) convertView
                    .findViewById(R.id.custom2);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.custom3);
            holder.btnCall = (Button) convertView.findViewById(R.id.btnCall);
            holder.btnEmail = (Button) convertView.findViewById(R.id.btnMail);
 
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        holder.txtName.setText(searchList.get(position).getName());
        holder.txtPhone.setText(searchList.get(position)
                .getPhone());
        holder.txtEmail.setText(searchList.get(position).getEmail());
        
        holder.btnCall.setOnClickListener(new OnClickListener() {

        	   @Override
        	   public void onClick(View v) {
        	    // TODO Auto-generated method stub
        		   View parentRow = (View) v.getParent();
        			ListView listView = (ListView) parentRow.getParent();
        			final int position = listView.getPositionForView(parentRow);
        			Object o =  searchList.get(position);
    		        Contacts fullObject = (Contacts)o;
        	    Log.i("Call Button Clicked: ", "**********");
        	    Toast.makeText(_context, "Call button Clicked: "+fullObject.getPhone(),
        	      Toast.LENGTH_LONG).show();
        	    
        	    Intent intent = new Intent(Intent.ACTION_DIAL).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);;
        	    intent.setData(Uri.parse("tel:"+fullObject.getPhone()));
        	    _context.startActivity(intent);
        	   }
        	  });
        	  holder.btnEmail.setOnClickListener(new OnClickListener() {

        	   @Override
        	   public void onClick(View v) {
        	    // TODO Auto-generated method stub
        		   View parentRow = (View) v.getParent();
       			ListView listView = (ListView) parentRow.getParent();
       			final int position = listView.getPositionForView(parentRow);
       			Object o = searchList.get(position);
   		        Contacts fullObject = (Contacts)o;
        	    Log.i("Email Button Clicked: ", "**********");
        	    Toast.makeText(_context, "Email button Clicked: "+fullObject.getEmail(),
        	      Toast.LENGTH_LONG).show();
        	    String[] TO = {fullObject.getEmail().toString()};
        	    String[] CC = {};
        	    Intent emailIntent = new Intent(Intent.ACTION_SEND).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);;
        	      emailIntent.setData(Uri.parse("mailto:"));
        	      emailIntent.setType("message/rfc822");
        	      emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        	      emailIntent.putExtra(Intent.EXTRA_CC, CC);
        	      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        	      emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        	      _context.startActivity(Intent.createChooser(emailIntent,"Choose Application.."));
        	     
        	   }
        	  });

        	

 
        return convertView;
		
	}
	
	
	static class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        TextView txtEmail;
        Button btnCall;
        Button btnEmail;
    }

}
