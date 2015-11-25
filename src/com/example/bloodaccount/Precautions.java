 package com.example.bloodaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.example.nstu_bloodaccount.R;

public class Precautions extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.precautions);
		Button Marriage=(Button) findViewById(R.id.marriage);
		Marriage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			  //Intent intent=new Intent();
			  startActivity(new Intent(Precautions.this,Marry.class));
			}
		});
	}
}
