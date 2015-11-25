package com.example.bloodaccount;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nstu_bloodaccount.R;

public class Marry extends Activity implements OnClickListener{

	EditText et1,et2,name1,name2;
	ImageButton imb;
	RadioGroup radioGroup;
	public static int m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.marriage);
		et1=(EditText) findViewById(R.id.rh1);
		et2=(EditText) findViewById(R.id.rh2);
		name1=(EditText) findViewById(R.id.one);
		name2=(EditText) findViewById(R.id.two);
		radioGroup= (RadioGroup) findViewById(R.id.radioGroup1);
		imb=(ImageButton) findViewById(R.id.imageButton1);
		imb.setOnClickListener(this);
	    
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String s1,s2;
		String a=name1.getText().toString();
		InputMethodManager imm1=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm1.hideSoftInputFromWindow(name1.getWindowToken(),0);
		String b=name2.getText().toString();
		InputMethodManager imm2=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm2.hideSoftInputFromWindow(name2.getWindowToken(),0);
		switch(arg0.getId())
		{
		case R.id.imageButton1:
		{
			s1=et1.getText().toString();
			InputMethodManager imm3=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm3.hideSoftInputFromWindow(et1.getWindowToken(),0);
			s2=et2.getText().toString();
			InputMethodManager imm4=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm4.hideSoftInputFromWindow(et2.getWindowToken(),0);
			if(s1.equals("")||s2.equals("")||a.equals("")||b.equals(""))
			{
				LayoutInflater inflater = getLayoutInflater();
				 
				View layout = inflater.inflate(R.layout.toast,
				  (ViewGroup) findViewById(R.id.toastLayout));
 
				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.warning);
 
				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("You cant leave any field blank");
 
				// Toast...
				Toast toast = new Toast(getApplicationContext());
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
		        return;
			}
			else{
				
						if((s1.equals("+")||s1.equals("-"))&&(s2.equals("+")||s2.equals("-")))
						{
								int checkedRadioButton = radioGroup.getCheckedRadioButtonId();;
								switch(checkedRadioButton)
								{
								case R.id.radio0:
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
													text.setText("Hey "+a+"!!! Sorry Your Marriage with "+b+" is Incompitable..." +
															"Your Second Child is in danger");
									 
													// Toast...
													Toast toast = new Toast(getApplicationContext());
													toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
													toast.setDuration(Toast.LENGTH_LONG);
													toast.setView(layout);
													toast.show();
													break;
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
													text.setText("Hey "+a+"!!! Good News, Your Marriage \nwith "+b+" is compitable");
									 
													// Toast...
													Toast toast = new Toast(getApplicationContext());
													toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
													toast.setDuration(Toast.LENGTH_LONG);
													toast.setView(layout);
													toast.show();
													break;
												}
									
											}
										
								   case  R.id.radio1:
								   {
												if((s1.equals("-"))&&(s2.equals("+")))
												{
													LayoutInflater inflater = getLayoutInflater();
													 
													View layout = inflater.inflate(R.layout.toast,
													  (ViewGroup) findViewById(R.id.toastLayout));
									 
													// set a dummy image
													ImageView image = (ImageView) layout.findViewById(R.id.image);
													image.setImageResource(R.drawable.sorry);
									 
													// set a message
													TextView text = (TextView) layout.findViewById(R.id.text);
													text.setText("Hey "+a+"!!! Sorry Your Marriage with "+b+" is Incompitable..." +
															"Your Second Child is in danger");
									 
													// Toast...
													Toast toast = new Toast(getApplicationContext());
													toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
													toast.setDuration(Toast.LENGTH_LONG);
													toast.setView(layout);
													toast.show();	
													break;
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
													text.setText("Hey "+a+"!!! Good News, Your Marriage \nwith "+b+" is compitable");
									 
													// Toast...
													Toast toast = new Toast(getApplicationContext());
													toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
													toast.setDuration(Toast.LENGTH_LONG);
													toast.setView(layout);
													toast.show();	
													break;
												}
								
											}
									
						      }
						}
						else
						{
							Toast.makeText(getApplicationContext(), "Enter Valid RH Factor (+/-)", Toast.LENGTH_LONG).show();
			                return;
						}
				}
	}
}
}
}