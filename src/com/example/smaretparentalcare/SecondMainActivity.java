package com.example.smaretparentalcare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_main);
	
	
	Button editPrefs = (Button) findViewById(R.id.prefButton);
     
     
    
	Button showPrefs = (Button) findViewById(R.id.showButton);
	}
    public void onClickShow(View view) {
        Intent myIntent = new Intent(view.getContext(), ShowPrefs.class);
        startActivityForResult(myIntent, 0);
    }
    public void onClickEdit(View view) {
        Intent myIntent = new Intent(view.getContext(), SetPrefs.class);
        startActivityForResult(myIntent, 0);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_main, menu);
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
