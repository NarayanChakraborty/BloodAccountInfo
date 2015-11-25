package com.example.bloodaccount;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nstu_bloodaccount.R;

public class Account extends Activity implements OnClickListener{

	EditText name,group,batch,dept,mob,editrowid;
	Button view,update,edit,del,info;
	
	DatabaseHelper  dbhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account);
		name=(EditText) findViewById(R.id.edtName);
		group=(EditText)findViewById(R.id.edtGroup);
		batch=(EditText) findViewById(R.id.editBatch);
		dept=(EditText) findViewById(R.id.edtDept);
		mob=(EditText) findViewById(R.id.edtMobile);
		view=(Button) findViewById(R.id.view);
		update=(Button) findViewById(R.id.account);
		
		view.setOnClickListener(this);
		update.setOnClickListener(this);
	
	     editrowid=(EditText) findViewById(R.id.editRow);
	     edit=(Button) findViewById(R.id.editButton);
	     del=(Button) findViewById(R.id.deleteButton);
	     info=(Button) findViewById(R.id.infoButton);
	     
	     edit.setOnClickListener(this);
	     del.setOnClickListener(this);
	     info.setOnClickListener(this);
	     
		dbhelper=DatabaseHelper.getInstance(getApplicationContext());
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//boolean didItWork=true;
		switch(v.getId())
		{
		
			case R.id.account:
				{
				//try{
				String sName=name.getText().toString();
				InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(name.getWindowToken(),0);
				String sBatch=batch.getText().toString();
				InputMethodManager imm1=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm1.hideSoftInputFromWindow(batch.getWindowToken(),0);
				String sDept=dept.getText().toString();
				InputMethodManager imm2=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm2.hideSoftInputFromWindow(dept.getWindowToken(),0);
				String sGroup=group.getText().toString();
				InputMethodManager imm3=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm3.hideSoftInputFromWindow(group.getWindowToken(),0);
				String sMobile=mob.getText().toString();
				InputMethodManager imm4=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm4.hideSoftInputFromWindow(mob.getWindowToken(),0);
 
				if(sName.equals("")||sBatch.equals("")||sGroup.equals("")||sDept.equals(""))
				     {
						LayoutInflater inflater = getLayoutInflater();
						 
						View layout = inflater.inflate(R.layout.toast,
						  (ViewGroup) findViewById(R.id.toastLayout));
		 
						// set a dummy image
						ImageView image = (ImageView) layout.findViewById(R.id.image);
						image.setImageResource(R.drawable.warning);
		 
						// set a message
						TextView text = (TextView) layout.findViewById(R.id.text);
						text.setText("You cant leave any field \nblank except mobile no");
		 
						// Toast...
						Toast toast = new Toast(getApplicationContext());
						toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
						toast.setDuration(Toast.LENGTH_LONG);
						toast.setView(layout);
						toast.show();
				        return;
				     }
					else
					{
							if((sGroup.equalsIgnoreCase("A+"))||(sGroup.equalsIgnoreCase("A-"))||(sGroup.equalsIgnoreCase("B+"))||(sGroup.equalsIgnoreCase("B-"))||(sGroup.equalsIgnoreCase("AB+"))||(sGroup.equalsIgnoreCase("AB-"))
									   ||(sGroup.equalsIgnoreCase("O+"))||(sGroup.equalsIgnoreCase("O-")))
							{
							
							}
							else
							{
								Toast.makeText(getApplicationContext(), "Enter Valid Blood Group",Toast.LENGTH_SHORT).show();
								return;
							}
							
							if(!(sMobile.isEmpty())&& sMobile.length()!=11)
							{
								Toast.makeText(getApplicationContext(), "Enter Valid Mobile No",Toast.LENGTH_SHORT).show();
								return;
							}
			                 
							if(sMobile.isEmpty())
							{
								sMobile="Not Interested";
							}
							 
						Student student=new Student(sName,sBatch,sDept,sMobile,sGroup);
						Toast.makeText(getApplicationContext(),student.getString(),Toast.LENGTH_LONG).show();
						long inserted=dbhelper.insertStudent(student); 
							if(inserted>=0)
							{
								Toast.makeText(getApplicationContext(), "Account Creation SuccessFul",Toast.LENGTH_SHORT).show();
								//Student s=new Student(" "," "," "," "," ");
							}
							else
							{
								Toast.makeText(getApplicationContext(), "Account Creation UnSuccessFul",Toast.LENGTH_SHORT).show();
								//Student s=new Student(" "," "," "," "," ");
							}
						break;
					}
				}
			case R.id.view:
			{
				
				startActivity(new Intent(Account.this,SearchAll.class));
				break;
				
					}

			case R.id.infoButton:
				try
				{
				String s=editrowid.getText().toString();
				InputMethodManager imm5=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm5.hideSoftInputFromWindow(editrowid.getWindowToken(),0);
				if(s.isEmpty())
				{
					Toast.makeText(getApplicationContext(), "Enter A/C ID First", Toast.LENGTH_SHORT).show();
					break;
				}
				long l=Long.parseLong(s);
				String returnedName=dbhelper.getName(l);
				String returnedGroup=dbhelper.getGroup(l);
				String returnedBatch=dbhelper.getBatch(l);
				String returnedDept=dbhelper.getDept(l);
				String returnedMob=dbhelper.getMob(l);
				name.setText(returnedName);
				group.setText(returnedGroup);
				batch.setText(returnedBatch);
				dept.setText(returnedDept);
				mob.setText(returnedMob);
				  }
				catch(IndexOutOfBoundsException e)
				{
					Toast.makeText(getApplicationContext(), "Invalid Entry", Toast.LENGTH_SHORT).show();
			        return;
				}
				catch(Exception e)
		 	      {
			          String s=e.toString();
			          Dialog d=new Dialog(this);
		    		  d.setTitle("UnSuccessfull");
		    		  TextView tv=new TextView(this);
		    		  tv.setText(s);
		    		  d.setContentView(tv);
		    		  d.show();
		          }
				break;
			case R.id.editButton:
				try{
					String rowid=editrowid.getText().toString();
					InputMethodManager imm6=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm6.hideSoftInputFromWindow(editrowid.getWindowToken(),0);
					if(rowid.isEmpty())
					{
						Toast.makeText(getApplicationContext(), "Enter A/C ID First", Toast.LENGTH_SHORT).show();
						break;
					}
					String rname=name.getText().toString();
					InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(name.getWindowToken(),0);
					String rbatch=batch.getText().toString();
					InputMethodManager imm1=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm1.hideSoftInputFromWindow(batch.getWindowToken(),0);
					String rdept=dept.getText().toString();
					InputMethodManager imm2=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm2.hideSoftInputFromWindow(dept.getWindowToken(),0);
					String rgroup=group.getText().toString();
					InputMethodManager imm3=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm3.hideSoftInputFromWindow(group.getWindowToken(),0);
					String rmob=mob.getText().toString();
					InputMethodManager imm4=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm4.hideSoftInputFromWindow(mob.getWindowToken(),0);
					
				if(rname.equals("")||rgroup.equals("")||rbatch.equals("")||rdept.equals(""))
			     {
					LayoutInflater inflater = getLayoutInflater();
				 
				View layout = inflater.inflate(R.layout.toast,
				  (ViewGroup) findViewById(R.id.toastLayout));
 
				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.warning);
 
				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("You cant leave any field \nblank except mobile no");
 
				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
		        return;
			     }
				long lng=Long.parseLong(rowid);
				int value=dbhelper.updateEntry(lng,rname,rgroup, rbatch, rdept, rmob);
				dbhelper.close();
					if(value==1){
					Toast.makeText(getApplicationContext(), "Data Successfully Updated ", Toast.LENGTH_SHORT).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "Data Update Unsuccessful,\n Account is not valid", Toast.LENGTH_SHORT).show();
					}
				}
				catch(Exception e)
		 	      {
			          String s=e.toString();
			          Dialog d=new Dialog(this);
		    		  d.setTitle("UnSuccessful");
		    		  TextView tv=new TextView(this);
		    		  tv.setText(s);
		    		  d.setContentView(tv);
		    		  d.show();
		          }
				break;
			case R.id.deleteButton:
				try{
				String drowid=editrowid.getText().toString();
				if(drowid.isEmpty())
				{
					Toast.makeText(getApplicationContext(), "Enter A/C ID First", Toast.LENGTH_SHORT).show();
					break;
				}
				long dlng=Long.parseLong(drowid);
				int value1=dbhelper.deleteEntry(dlng);
				dbhelper.close();
						if(value1==1){
						Toast.makeText(getApplicationContext(), "Data Successfully Deleted", Toast.LENGTH_SHORT).show();
						}
						else{
							Toast.makeText(getApplicationContext(), "Data Deletion Unsuccessful ,\n Account is not valid", Toast.LENGTH_SHORT).show();
						}
				  }
				catch(Exception e)
		 	      {
			          String s=e.toString();
			          Dialog d=new Dialog(this);
		    		  d.setTitle("UnSuccessful");
		    		  TextView tv=new TextView(this);
		    		  tv.setText(s);
		    		  d.setContentView(tv);
		    		  d.show();
		          }
				break;
				}
	
		}
	}

