package com.example.bloodaccount;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.nstu_bloodaccount.R;

public class SearchBlood extends Activity implements OnClickListener{

	EditText edttxt;
	Button searchbutton;
	DatabaseHelper dbhelpernew;
	ListView bloodlist;
	AdapterClass adapterclass;
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
		String keyword=edttxt.getText().toString();
		 ArrayList<Student> al=dbhelpernew.searchStudent(keyword);
		    if(al!=null && al.size()>0)
		     {
		    	 adapterclass=new AdapterClass(this,al);
	             bloodlist.setAdapter(adapterclass);
		     }
		
	}
}


