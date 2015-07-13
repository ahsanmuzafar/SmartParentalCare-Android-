package com.example.smaretparentalcare;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ChildFirstScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("Setting Layout", "working");
		setContentView(R.layout.activity_child_first_screen);
		//TextView tv=(TextView)findViewById(R.id.textViewPMsg);
		Log.d("Getting content from bundle", "working");
		Bundle bundle = getIntent().getExtras();
		String message = bundle.getString("msg");
		Log.d("After Bundle", "working");
		//tv.setText(message);
		 
		
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_first_screen, menu);
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
