package com.example.smaretparentalcare;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlOpenHelper  extends SQLiteOpenHelper {

	  public static final int DATABASE_VERSION = 1;
	  public static final String DATABASE_NAME = "pcdb.db";
	public MySqlOpenHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(PContract.commands.ChildTable.CREATE_Child_TABLE);
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

}
