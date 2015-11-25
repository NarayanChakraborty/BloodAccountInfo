package com.example.bloodaccount;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.nstu_bloodaccount.R;

public class AdapterClass extends ArrayAdapter<Student>{

	Activity con;
	ArrayList<Student> studentlist;
	public AdapterClass(Context context,
			ArrayList<Student> objects) {
		super(context,R.layout.listiteam, objects);
		// TODO Auto-generated constructor stub
		this.con=(Activity)context;
		this.studentlist=objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v=null;
		if(convertView==null)
		{
			LayoutInflater inflator=con.getLayoutInflater();
			v=inflator.inflate(R.layout.listiteam, null);
			
			TextView tvName=(TextView) v.findViewById(R.id.txtName);
			TextView tvBatch=(TextView) v.findViewById(R.id.txtBatch);
			TextView tvDept=(TextView) v.findViewById(R.id.txtDept);
			TextView tvMob=(TextView) v.findViewById(R.id.txtMobile);
			TextView tvGroup=(TextView) v.findViewById(R.id.txtGroup);
			
			Student sdt=studentlist.get(position);
			tvName.setText(sdt.getName());
			tvBatch.setText(sdt.getBatch());
			tvDept.setText(sdt.getDept());
			tvGroup.setText(sdt.getBgroup());
			tvMob.setText(sdt.getMobile());
		}
		else
			v=convertView;
		return v;
	}

	
}
