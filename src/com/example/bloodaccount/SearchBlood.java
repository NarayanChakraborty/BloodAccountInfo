package com.example.bloodaccount;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nstu_bloodaccount.R;

public class SearchBlood extends Activity implements OnClickListener{

	EditText edttxt;
	Button searchbutton;
	DatabaseHelper dbhelpernew;
	ListView bloodlist;
	AdapterClass adapterclass;
	String number;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchblood);
		edttxt=(EditText) findViewById(R.id.edtalone);
		searchbutton=(Button) findViewById(R.id.srhbutton);
		bloodlist=(ListView) findViewById(R.id.listViewalone);
		dbhelpernew=DatabaseHelper.getInstance(getApplicationContext());
		searchbutton.setOnClickListener(this);
		
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId())
		{
		case R.id.srhbutton:
				{
				   String keyword=edttxt.getText().toString();
				   InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(edttxt.getWindowToken(),0);
					if(keyword.isEmpty())
					{
						Toast.makeText(getApplicationContext(), "Enter a Blood Group First",Toast.LENGTH_SHORT).show();
					}
					
				   if((keyword.equalsIgnoreCase("A+"))||(keyword.equalsIgnoreCase("A-"))||(keyword.equalsIgnoreCase("B+"))||(keyword.equalsIgnoreCase("B-"))||(keyword.equalsIgnoreCase("AB+"))||(keyword.equalsIgnoreCase("AB-"))
						   ||(keyword.equalsIgnoreCase("O+"))||(keyword.equalsIgnoreCase("O-")))
				   {
					 ArrayList<Student> al=dbhelpernew.searchStudent(keyword);
					    if(al!=null && al.size()>0)
					     {
					    	 adapterclass=new AdapterClass(this,al);
				             bloodlist.setAdapter(adapterclass);
				             registerForContextMenu(bloodlist);
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
				   
				   else{
					   Toast.makeText(getApplicationContext(), "It is not Blood Group",Toast.LENGTH_SHORT).show();
				   }
				}
				
				break;
		}
	}
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
            super.onCreateContextMenu(menu, v, menuInfo);
        	//TextView tv=(TextView) v.findViewById(R.id.txtMobile);
			//number=tv.getText().toString();
            AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
            number=adapterclass.getItem(info.position).getMobile();
            if(number.equals("Not Interested"))
            {
		    	LayoutInflater inflater = getLayoutInflater();
			   	 
				View layout = inflater.inflate(R.layout.toast,
				  (ViewGroup) findViewById(R.id.toastLayout));
 
				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.warning);
 
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


