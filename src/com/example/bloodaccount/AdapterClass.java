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
	public AdapterClass(Context context,ArrayList<Student> objects) {
		super(context,R.layout.listiteam, objects);
		// TODO Auto-generated constructor stub
		this.con=(Activity)context;
		this.studentlist=objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v=convertView;
		ViewHolder holder=new ViewHolder();
		if(convertView==null)
		{
			LayoutInflater inflator=con.getLayoutInflater();
			v=inflator.inflate(R.layout.listiteam,parent,false);
			v.setLongClickable(true);
			holder.tvID=(TextView) v.findViewById(R.id.txtID);
			holder.tvName=(TextView) v.findViewById(R.id.txtName);
			holder.tvBatch=(TextView) v.findViewById(R.id.txtBatch);
			holder.tvDept=(TextView) v.findViewById(R.id.txtDept);
			holder.tvMob=(TextView) v.findViewById(R.id.txtMobile);
			holder.tvGroup=(TextView) v.findViewById(R.id.txtGroup);
			
			v.setTag(holder);
		}
		else{
				holder=(ViewHolder) v.getTag();
			}
			Student sdt=studentlist.get(position);
			//tvName.setText(sdt.getId());
			if(sdt!=null)
			{
		    holder.tvID.setText("A/C No : "+sdt.getId());
			holder.tvName.setText(sdt.getName());
			holder.tvBatch.setText(sdt.getBatch()+",");
			holder.tvDept.setText(sdt.getDept());
			holder.tvMob.setText(sdt.getMobile());
			holder.tvGroup.setText(sdt.getBgroup());
		
		}
		
		return v;
	}
	private static class ViewHolder
	{
		TextView tvID;
		TextView tvName;
		TextView tvBatch;
		TextView tvDept;
		TextView tvMob;
		TextView tvGroup;
	}
}


