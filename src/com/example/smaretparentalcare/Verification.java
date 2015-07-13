package com.example.smaretparentalcare;

import java.util.Random;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Verification extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verification);
		
		char []arr=new char[62];
			for(int i=0;i<62;i++)
			{
				if(i<26)
					arr[i]=(char) (65+i);
				else if(i<36)
					arr[i]=(char) (48+i-26);
				else
					arr[i]=(char) (97+i-36);

			}


			int lengthOfPassword=8;
			Random randomno = new Random();
			  
		      String pass="";
		      for(int j=0;j<lengthOfPassword;j++)
		      {
		    	  pass=pass+  arr[randomno.nextInt(62)];
		      }
		
	       TextView t= (TextView)findViewById(R.id.genTextView);
	      t.setText(pass);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.verification, menu);
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
