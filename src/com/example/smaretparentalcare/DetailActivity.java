package com.example.smaretparentalcare;


import java.util.ArrayList;

 
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailActivity extends Activity {
	String  [] values = new String[] { 
			"Call", "SMS", "Apps", "Screen Usage" 
		};
	
	String  [] values1 = new String[] { 
	        "Call ", "SMS", "Apps", "Screen Block"  };
	ArrayList<String > myList=new ArrayList<String >();
    
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
//		int kidNumber = Integer.parseInt(  getIntent().getStringExtra(getResources().getString(R.string.child_number)).toString());

		
		final ListView lv = (ListView) findViewById(R.id.lvCustomReports);
	    
		
			for(int i=0;i<values.length;i++){
				myList.add(values[i]);
			}

			ArrayAdapter ad =new ArrayAdapter(this,android.R.layout.simple_list_item_1,myList);
			lv.setAdapter(ad);
				
		
		
		final ListView lv1 = (ListView) findViewById(R.id.lvCustomBlocks);
	    ArrayList<String > myList1=new ArrayList<String >();
	    
			for(int i=0;i<values1.length;i++){
				myList1.add(values1[i]);
			}    
			  
			ArrayAdapter ad1 =new ArrayAdapter(this,android.R.layout.simple_list_item_1,myList1);
			lv1.setAdapter( ad1);
			
	}
	
 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
