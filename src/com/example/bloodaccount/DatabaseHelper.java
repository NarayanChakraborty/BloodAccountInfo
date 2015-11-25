package com.example.bloodaccount;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
          
    public static DatabaseHelper sInstance; 
    
	public static final String KEY_ROWID="_id";
	public static final String KEY_NAME="student_name";
	public static final String KEY_BATCH="batch_name";
	public static final String KEY_DEPT="dept_name";
	public static final String KEY_GROUP="blood_group";
	public static final String KEY_MOBILE="mob_number";
	
	private static final String DATABASE_NAME="studentbloodinfo";
	private static final String DATABASE_TABLE="studentTable";
	private static final int DATABASE_VERSION=1;
	private DatabaseHelper(Context context) {
		super(context,DATABASE_NAME,null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
	public static DatabaseHelper getInstance(Context c)
	{
		if(sInstance==null)
		{
			sInstance=new DatabaseHelper(c);
		}
		return sInstance;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+DATABASE_TABLE+" (" +
	              KEY_ROWID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
				  KEY_NAME+" TEXT NOT NULL, " + 
	              KEY_BATCH+" TEXT NOT NULL, " +
	              KEY_DEPT+" TEXT NOT NULL, " + 
	              KEY_GROUP+" TEXT NOT NULL, " + 
	              KEY_MOBILE+" TEXT NOT NULL);"		
				);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public long insertStudent(Student s)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(KEY_NAME,s.getName());
		values.put(KEY_BATCH,s.getBatch());
		values.put(KEY_DEPT,s.getDept());
		values.put(KEY_GROUP,s.getBgroup());
		values.put(KEY_MOBILE,s.getMobile());
		long inserted=db.insertOrThrow(DATABASE_TABLE,null, values);
		db.close();
		return inserted;
	}
	public ArrayList<Student> searchStudent(String keyword)
	{
		ArrayList<Student> std=new ArrayList<Student>();
		SQLiteDatabase db=this.getReadableDatabase();
		//Cursor cr=db.query(DATABASE_TABLE, null,KEY_GROUP +" LIKE '%"+ KeyWord +"%'",null,null,null,null);
		Cursor cr=db.rawQuery(
				"select * from studentTable where blood_group LIKE '%"+ keyword + "%';"
				, null);
						
		if(cr!=null && cr.getCount()>0)
		{
		cr.moveToFirst();
		for(int i=0;i<cr.getCount();i++)
		  {
			
				int irow=cr.getInt(cr.getColumnIndex(KEY_ROWID));
				String iName=cr.getString(cr.getColumnIndex(KEY_NAME));
				String iBatch=cr.getString(cr.getColumnIndex(KEY_BATCH));
				String iDept=cr.getString(cr.getColumnIndex(KEY_DEPT));
				String iGroup=cr.getString(cr.getColumnIndex(KEY_GROUP));
				String iMob=cr.getString(cr.getColumnIndex(KEY_MOBILE));
				Student s=new Student(irow,iName,iBatch,iDept,iMob,iGroup);
			    std.add(s);
				cr.moveToNext();
		   }	
		}
		cr.close();
		db.close();
		return std;
	}
	public ArrayList<Student> getAllInformation()
	{
		ArrayList<Student> allinformation=new ArrayList<Student>();
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor c=db.query(DATABASE_TABLE,null,null,null,null,null,null);
		if(c!=null && c.getCount()>0)
		{
			c.moveToFirst();
		for(int i=0;i<c.getCount();i++)
		{
			
			int irow=c.getInt(c.getColumnIndex(KEY_ROWID));
			String iName=c.getString(c.getColumnIndex(KEY_NAME));
			String iBatch=c.getString(c.getColumnIndex(KEY_BATCH));
			String iDept=c.getString(c.getColumnIndex(KEY_DEPT));
			String iGroup=c.getString(c.getColumnIndex(KEY_GROUP));
			String iMob=c.getString(c.getColumnIndex(KEY_MOBILE));
			Student s=new Student(irow,iName,iBatch,iDept,iMob,iGroup);
			allinformation.add(s);
			c.moveToNext();
		}	
		}
		c.close();
		db.close();
		return allinformation;
	}

	public String getName(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{ KEY_ROWID,KEY_NAME,KEY_GROUP,KEY_BATCH,KEY_DEPT,KEY_MOBILE};
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		Cursor c=OurDatabase.query(DATABASE_TABLE, columns,KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null)
		{
			c.moveToFirst();
			String name=c.getString(1);
			return name;
		}
		c.close();
		OurDatabase.close();
		return null;
	}
	public String getGroup(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{ KEY_ROWID,KEY_NAME,KEY_GROUP,KEY_BATCH,KEY_DEPT,KEY_MOBILE};
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		Cursor c=OurDatabase.query(DATABASE_TABLE, columns,KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null)
		{
			c.moveToFirst();
			String group=c.getString(2);
			return group;
		}
		c.close();
		OurDatabase.close();
		return null;
	}
	public String getBatch(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{ KEY_ROWID,KEY_NAME,KEY_GROUP,KEY_BATCH,KEY_DEPT,KEY_MOBILE};
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		Cursor c=OurDatabase.query(DATABASE_TABLE, columns,KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null)
		{
			c.moveToFirst();
			String group=c.getString(3);
			return group;
		}
		c.close();
		OurDatabase.close();
		return null;
	}
	public String getDept(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{ KEY_ROWID,KEY_NAME,KEY_GROUP,KEY_BATCH,KEY_DEPT,KEY_MOBILE};
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		Cursor c=OurDatabase.query(DATABASE_TABLE, columns,KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null)
		{
			c.moveToFirst();
			String group=c.getString(4);
			return group;
		}
		c.close();
		OurDatabase.close();
		return null;
	}
	public String getMob(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns=new String[]{ KEY_ROWID,KEY_NAME,KEY_GROUP,KEY_BATCH,KEY_DEPT,KEY_MOBILE};
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		Cursor c=OurDatabase.query(DATABASE_TABLE, columns,KEY_ROWID+"="+l,null,null,null,null);
		if(c!=null)
		{
			c.moveToFirst();
			String group=c.getString(5);
			return group;
		}
		c.close();
		OurDatabase.close();
		return null;
	}
	public void updateEntry(long lng, String rname, String rgroup,String rbatch,String rdept,String rmob)throws SQLException {
		// TODO Auto-generated method stub
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME, rname);
		cv.put(KEY_GROUP, rgroup);
		cv.put(KEY_BATCH, rbatch);
		cv.put(KEY_DEPT, rdept);
		cv.put(KEY_MOBILE, rmob);
		OurDatabase.update(DATABASE_TABLE, cv, KEY_ROWID+"="+lng,null);
		OurDatabase.close();
		
	}
	public void deleteEntry(long dlng) throws SQLException{
		// TODO Auto-generated method stub
		SQLiteDatabase OurDatabase=this.getReadableDatabase();
		OurDatabase.delete(DATABASE_TABLE, KEY_ROWID+"="+dlng,null);
	}
}
