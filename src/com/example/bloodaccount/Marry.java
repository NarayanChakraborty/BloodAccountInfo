package com.example.bloodaccount;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nstu_bloodaccount.R;

public class Marry extends Activity implements OnClickListener{

	EditText et1,et2,name1,name2;
	ImageButton imb;
	RadioButton rb1,rb2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.marriage);
		et1=(EditText) findViewById(R.id.rh1);
		et2=(EditText) findViewById(R.id.rh2);
		name1=(EditText) findViewById(R.id.one);
		name2=(EditText) findViewById(R.id.two);
		rb1=(RadioButton) findViewById(R.id.radio0);
		rb2=(RadioButton) findViewById(R.id.radio1);
		imb=(ImageButton) findViewById(R.id.imageButton1);
		rb1.setOnClickListener(this);
		rb2.setOnClickListener(this);
		imb.setOnClickListener(this);
	    
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String s1="+";String s2="-";
		String a=name1.getText().toString();
		String b=name2.getText().toString();
		int sex=1;
		switch(arg0.getId())
		{
		 case R.id.radio0:
			 sex=1;
			 break;
		case R.id.radio1:
				sex=0;
				break;
		case R.id.imageButton1:
		{
			s1=et1.getText().toString();
			s2=et2.getText().toString();
			if(s1.equals("")||s2.equals("")||a.equals("")||b.equals(""))
			{
				
		          Toast.makeText(getApplicationContext(), "Please ensure that you have filled up all the field", Toast.LENGTH_LONG).show();
	                return;
			}
			else{
						
					if(sex==1)
					{
						if(s1.equals("+")&&(s2.equals("-")) )
						{
									// get your custom_toast.xml ayout
									LayoutInflater inflater = getLayoutInflater();
					 
									View layout = inflater.inflate(R.layout.toast,
									  (ViewGroup) findViewById(R.id.toastLayout));
					 
									// set a dummy image
									ImageView image = (ImageView) layout.findViewById(R.id.image);
									image.setImageResource(R.drawable.sorry);
					 
									// set a message
									TextView text = (TextView) layout.findViewById(R.id.text);
									text.setText("Hey "+a+"Your Marriage with "+b+" is Incompitable");
					 
									// Toast...
									Toast toast = new Toast(getApplicationContext());
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(layout);
									toast.show();
									}
								else if(s1.equals("")||s2.equals(""))
								{
									Toast.makeText(getApplicationContext(),"Insert Rh factor Field",Toast.LENGTH_LONG).show();
								}
								else
								{
				
									LayoutInflater inflater = getLayoutInflater();
									 
									View layout = inflater.inflate(R.layout.toast,
									  (ViewGroup) findViewById(R.id.toastLayout));
					 
									// set a dummy image
									ImageView image = (ImageView) layout.findViewById(R.id.image);
									image.setImageResource(R.drawable.happy);
					 
									// set a message
									TextView text = (TextView) layout.findViewById(R.id.text);
									text.setText("Hey "+a+"Your Marriage with "+b+" is compitable");
					 
									// Toast...
									Toast toast = new Toast(getApplicationContext());
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(layout);
									toast.show();	
								}
							}
							else
							{
								if(s2.equals("+")&&(s1.equals("-")) )
								{
									LayoutInflater inflater = getLayoutInflater();
									 
									View layout = inflater.inflate(R.layout.toast,
									  (ViewGroup) findViewById(R.id.toastLayout));
					 
									// set a dummy image
									ImageView image = (ImageView) layout.findViewById(R.id.image);
									image.setImageResource(R.drawable.sorry);
					 
									// set a message
									TextView text = (TextView) layout.findViewById(R.id.text);
									text.setText("Hey "+a+"Your Marriage with "+b+" is Incompitable");
					 
									// Toast...
									Toast toast = new Toast(getApplicationContext());
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(layout);
									toast.show();	
								}
								else
								{
									LayoutInflater inflater = getLayoutInflater();
									 
									View layout = inflater.inflate(R.layout.toast,
									  (ViewGroup) findViewById(R.id.toastLayout));
					 
									// set a dummy image
									ImageView image = (ImageView) layout.findViewById(R.id.image);
									image.setImageResource(R.drawable.happy);
					 
									// set a message
									TextView text = (TextView) layout.findViewById(R.id.text);
									text.setText("Hey "+a+"Your Marriage with "+b+" is compitable");
					 
									// Toast...
									Toast toast = new Toast(getApplicationContext());
									toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
									toast.setDuration(Toast.LENGTH_LONG);
									toast.setView(layout);
									toast.show();	
								}
				
							}
		      }
		}
	}
}
}