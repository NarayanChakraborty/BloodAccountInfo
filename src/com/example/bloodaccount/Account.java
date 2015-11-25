package com.example.bloodaccount;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
		update=(Button) findViewById(R.id.update);
		
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
		
			case R.id.update:
				{
				//try{
				String sName=name.getText().toString();
				String sBatch=batch.getText().toString();
				String sDept=dept.getText().toString();
				String sGroup=group.getText().toString();
				String sMobile=mob.getText().toString();
				if(sName.equals("")||sBatch.equals("")||sGroup.equals("")||sDept.equals(""))
			     {
			                Toast.makeText(getApplicationContext(), "You Cannot leave any field Blank Except Mobile Number", Toast.LENGTH_LONG).show();
			                return;
			     }
				else
				{
					Student student=new Student(sName,sBatch,sDept,sMobile,sGroup);
					Toast.makeText(getApplicationContext(),student.getString(),Toast.LENGTH_LONG).show();
					long inserted=dbhelper.insertStudent(student); 
					if(inserted>=0)
					{
						Toast.makeText(getApplicationContext(), "Login SuccessFull",Toast.LENGTH_LONG).show();
						//Student s=new Student(" "," "," "," "," ");
					}
					else
					{
						Toast.makeText(getApplicationContext(), "Login UnSuccessFull",Toast.LENGTH_LONG).show();
						//Student s=new Student(" "," "," "," "," ");
					}
					break;
					}
				}
			case R.id.view:
			{
				
				ArrayList<Student> sd=dbhelper.getAllInformation();
			     if(sd!=null && sd.size()>0)
			     {
			    	 for(Student sm:sd)
			    	 {
			    		 Toast.makeText(getApplicationContext(), sm.toString(),Toast.LENGTH_SHORT).show();
			    	 }
			    } 
				  else if(sd.size()==0)
			     {
			    	 Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
			     }
			  
				break;
			}
			case R.id.infoButton:
				try
				{
				String s=editrowid.getText().toString();
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
				  }catch(Exception e)
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
				String rname=name.getText().toString();
				String rgroup=group.getText().toString();
				String rbatch=batch.getText().toString();
				String rdept=dept.getText().toString();
				String rmob=mob.getText().toString();
				String rowid=editrowid.getText().toString();
				long lng=Long.parseLong(rowid);
				dbhelper.updateEntry(lng,rname,rgroup, rbatch, rdept, rmob);
				dbhelper.close();
				  }catch(Exception e)
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
				long dlng=Long.parseLong(drowid);
				dbhelper.deleteEntry(dlng);
				dbhelper.close();
				  }catch(Exception e)
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

