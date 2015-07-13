package com.example.smaretparentalcare;
import android.provider.BaseColumns;
public abstract class PContract {
	public static abstract class tables {
			public static class Child implements BaseColumns {
				public static final String TABLE_NAME=" Child ";
				public static final String COLUMN_NAME_CCONCTACT=" CCONTACT";//contact number
				public static final String COLUMN_NAME_NAME=" Name";
				public static final String COLUMN_NAME_PICPATH=" PicPath";
						
			}
			
			public static class SMS_Record implements BaseColumns  {
				public static final String TABLE_NAME="SMS_Record";
				public static final String COLUMNS_NAME_CONTACT_NO="Contact_No"; // to whom sms is sent
				public static final String COLUMNS_NAME_SMS_COUNT="SMS_count";
				public static final String COLUMN_NAME_CCONCTACT="CCONTACT"; //as foreign key
				
				
			}
			public static class Call_Record implements BaseColumns  {
				public static final String TABLE_NAME="Call_Record";
				public static final String COLUMNS_NAME_CONTACT_NO="Contact_No"; // to whom the call is made
				public static final String COLUMNS_NAME_DURATION="Duration";
				public static final String COLUMNS_NAME_STIME="Stime";
				public static final String COLUMNS_NAME_ETIME="Etime";
				public static final String COLUMN_NAME_CCONCTACT="CCONTACT"; //as foreign key
				
				
				
			}
			public static class Screen_Record implements BaseColumns  {
				public static final String TABLE_NAME="Screen_Record";
				public static final String COLUMNS_NAME_DURATION="Duration";
				public static final String COLUMNS_NAME_DATE="Date";
				public static final String COLUMN_NAME_CCONCTACT="CCONTACT"; //as foreign key
				
			}
			public static class  APPs implements BaseColumns  {
				public static final String TABLE_NAME="APPs";
				public static final String COLUMNS_NAME_APP="APP";
				public static final String COLUMNS_NAME_DURATION="Duration";
				public static final String COLUMNS_NAME_DATE="Date";
				public static final String COLUMN_NAME_CCONCTACT="CCONTACT"; //as foreign key
				
			}
			
	}
	public static abstract class commands{
		private static final String TEXT_TYPE = " TEXT";
		private static final String INT_TYPE = " INTEGER";
		private static final String COMMA_SEP = ",";
		public abstract class ChildTable{			
			public static final String CREATE_Child_TABLE =
					"CREATE TABLE " + PContract.tables.Child.TABLE_NAME + " ( " +
							PContract.tables.Child.COLUMN_NAME_CCONCTACT+ " TEXT PRIMARY KEY UNIQUE ," +
							PContract.tables.Child.COLUMN_NAME_NAME + TEXT_TYPE +" UNIQUE "+ COMMA_SEP +
							PContract.tables.Child.COLUMN_NAME_PICPATH+ TEXT_TYPE +
							" )";
		}
		public abstract class Screen_RecordTable{
			public static final String CREATE_Screen_Record_TABLE =
					"CREATE TABLE " + PContract.tables.Screen_Record.TABLE_NAME + " ( " +
							PContract.tables.Screen_Record.COLUMNS_NAME_DATE+ TEXT_TYPE+" PRIMARY KEY UNIQUE" + COMMA_SEP +
							PContract.tables.Screen_Record.COLUMN_NAME_CCONCTACT+ " TEXT  ," +
							PContract.tables.Screen_Record.COLUMNS_NAME_DURATION + TEXT_TYPE + COMMA_SEP +
							" )";
		}
		public abstract class SMS_RecordTable{
			public static final String  CREATE_SMS_Record_TABLE  =
					"CREATE TABLE " + PContract.tables.SMS_Record.TABLE_NAME+ " ( " +
							PContract.tables.SMS_Record.COLUMNS_NAME_CONTACT_NO+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.SMS_Record.COLUMNS_NAME_SMS_COUNT+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.SMS_Record.COLUMN_NAME_CCONCTACT+ " TEXT  ," + 
							" )";
		}
		public abstract class Call_RecordTable{
			public static final String CREATE_Call_Record_TABLE =
					"CREATE TABLE " + PContract.tables.Call_Record.TABLE_NAME + " ( " +
							PContract.tables.Call_Record.COLUMNS_NAME_CONTACT_NO+ INT_TYPE+ " PRIMARY KEY," +
							PContract.tables.Call_Record.COLUMNS_NAME_DURATION+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.Call_Record.COLUMNS_NAME_ETIME+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.Call_Record.COLUMNS_NAME_STIME+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.Call_Record.COLUMN_NAME_CCONCTACT+ " TEXT  ," +
							" )";
		}
		public abstract class APPsRecoredTable{
			public static final String CREATE_APPs_RECORD_TABLE =
					"CREATE TABLE " + PContract.tables.APPs.TABLE_NAME + " ( " +
							PContract.tables.APPs.COLUMNS_NAME_APP+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.APPs.COLUMNS_NAME_DATE+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.APPs.COLUMNS_NAME_DURATION+ TEXT_TYPE + COMMA_SEP +
							PContract.tables.APPs.COLUMN_NAME_CCONCTACT+ " TEXT ," +
							"PRIMARY KEY(PContract.tables.APPs.COLUMNS_NAME_APP,PContract.tables.APPs.COLUMNS_NAME_DATE)"+
							
							" )";
		}
	}
}
		

	
	


