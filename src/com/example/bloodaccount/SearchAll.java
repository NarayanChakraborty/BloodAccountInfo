package com.example.bloodaccount;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.example.nstu_bloodaccount.R;

public class SearchAll extends Activity{

	
	DatabaseHelper  dbhelper2;
	AdapterClass adapterclass2;
	ListView bloodlist2;
	String number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchall);
		
	     bloodlist2=(ListView) findViewById(R.id.listViewall);
	     dbhelper2=DatabaseHelper.getInstance(getApplicationContext());
	     
	     ArrayList<Student> al=dbhelper2.getAllInformation();
		    if(al!=null && al.size()>0)
		     {
		    	 adapterclass2=new AdapterClass(this,al);
	             bloodlist2.setAdapter(adapterclass2);
	             registerForContextMenu(bloodlist2);
	             
	          // get your custom_toast.xml ayout
					LayoutInflater inflater = getLayoutInflater();
	 
					View layout = inflater.inflate(R.layout.toast,
					  (ViewGroup) findViewById(R.id.toastLayout));
	 
					// set a dummy image
					ImageView image = (ImageView) layout.findViewById(R.id.image);
					image.setImageResource(R.drawable.cool);
	 
					// set a message
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Long Press To Call or SMS");
	 
					// Toast...
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();
		     }
		    else if(al.size()==0)
		    {
		    	LayoutInflater inflater = getLayoutInflater();
		   	 
				View layout = inflater.inflate(R.layout.toast,
				  (ViewGroup) findViewById(R.id.toastLayout));
 
				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.sorry);
 
				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("No Data Found");
 
				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
		    	
		    }
		
	
	}
	 public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
	    {
	            super.onCreateContextMenu(menu, v, menuInfo);
	        	//TextView tv=(TextView) v.findViewById(R.id.txtMobile);
				//number=tv.getText().toString();
	            AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
	            number=adapterclass2.getItem(info.position).getMobile();
	            if(number.equals("Not Interested"))
	            {
			    	LayoutInflater inflater = getLayoutInflater();
				   	 
					View layout = inflater.inflate(R.layout.toast,
					  (ViewGroup) findViewById(R.id.toastLayout));
	 
					// set a dummy image
					ImageView image = (ImageView) layout.findViewById(R.id.image);
					image.setImageResource(R.drawable.sorry);
	 
					// set a message
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("No Mobile Number Found," +
							"You Need to talk face to face");
	 
					// Toast...
					Toast toast = new Toast(getApplicationContext());
					toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					toast.setDuration(Toast.LENGTH_LONG);
					toast.setView(layout);
					toast.show();
					return;
	            }
	            menu.setHeaderTitle("Select The Action"); 
	            menu.add(0, v.getId(), 0, "Call"); 
	            menu.add(0, v.getId(), 0, "Send SMS");

	    }
	 public boolean onContextItemSelected(MenuItem item)
	    { 


	                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	               // TextView number;
	                //View va = findViewById(info.position);
	      
	                try
	                {
	                       //View n=va.findViewById(R.id.txtMobile);
	                       //String m=n.toString();
	                       // String mobile=number.getText().toString();
	        
	                        if(item.getTitle()=="Call")
	                        {
	        
	        
	                                Intent callIntent = new Intent(Intent.ACTION_CALL);
	                                callIntent.setData(Uri.parse("tel:"+number));
	                                startActivity(callIntent);

	                        } 
	                        else if(item.getTitle()=="Send SMS")
	                        {
	                                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
	                                smsIntent.setType("vnd.android-dir/mms-sms");
	                                smsIntent.putExtra("address",number);
	                                startActivity(smsIntent);
	            

	                        } 
	                        else
	                        {
	                        	return false;
	                        
	                        } 
	                        return true; 
	                }
	                catch(Exception e)
	                {
	                        return true;
	                }
	    } 
	   
	   

	} 
	
