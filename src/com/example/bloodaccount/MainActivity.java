package com.example.bloodaccount;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.nstu_bloodaccount.R;

public class MainActivity extends  Activity implements OnClickListener {

	Button b1,b2,b3,b4,b5,b6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    create();
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}

	private void create() {
		// TODO Auto-generated method stub
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		b4=(Button) findViewById(R.id.button4);
		b5=(Button) findViewById(R.id.button5);
		b6=(Button) findViewById(R.id.button6);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
		case R.id.button1:
			startActivity(new Intent(MainActivity.this,Blood.class));
			break;
		case R.id.button2:
			startActivity(new Intent(MainActivity.this,Bgroup.class));
			break;
		case R.id.button3:
			startActivity(new Intent(MainActivity.this,Precautions.class));
			break;
		case R.id.button4:
			startActivity(new Intent(MainActivity.this,Account.class));
			break;
		case R.id.button5:
			startActivity(new Intent(MainActivity.this,SearchBlood.class));
			break;
		case R.id.button6:
			startActivity(new Intent(MainActivity.this,AboutMe.class));
			break;
		}
	}
}
