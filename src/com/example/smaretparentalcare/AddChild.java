package com.example.smaretparentalcare;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class AddChild extends Activity {
	public int RESULT_LOAD_IMAGE=1;
	public String PicturePath=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_child);
		ImageView  v = (ImageView)findViewById(R.id.profileImage);
		v.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				final Dialog d=new Dialog(AddChild.this);
			
				d.setContentView(R.layout.addpicturedialog);
			
				d.setTitle("Add Picture");
				Button btn=(Button)d.findViewById(R.id.buttonOK);
				btn.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						d.dismiss();
					}
				});
				d.show();
				TextView t=(TextView)d.findViewById(R.id.textViewGallery);
				t.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
										    
					Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
					
					startActivityForResult(i,RESULT_LOAD_IMAGE);
					
					
				}}); 
				
			}
			
			
		});
		
		
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	         Uri selectedImage = data.getData();
	         String[] filePathColumn = { MediaStore.Images.Media.DATA };
	         Cursor cursor = getContentResolver().query(selectedImage,
	                 filePathColumn, null, null, null);
	         cursor.moveToFirst();
	         
	         
	         int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	          PicturePath = cursor.getString(columnIndex);
	         cursor.close();
	                      
	         ImageView imageView = (ImageView) findViewById(R.id.profileImage);
	         imageView.setImageBitmap(BitmapFactory.decodeFile(PicturePath));
	         Bitmap b=BitmapFactory.decodeFile(PicturePath);
	         saveToInternalSorage(b);
	         
	              
		 
	     }
		
		
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_accout, menu);
		return true;
	}
	private String saveToInternalSorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
         // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");
        
        FileOutputStream fos = null;
        try {           

            fos = new FileOutputStream(mypath);

       // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }
/*	private void loadImageFromStorage(String path)
	{

	    try {
	        File f=new File(path, "profile.jpg");
	        Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
	            ImageView img=(ImageView)findViewById(R.id.imageViewcheck);
	        img.setImageBitmap(b);
	    } 
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }

	}*/
	public void addChildFunc(View v)
	{
		
		

		EditText nam=(EditText)findViewById(R.id.editTextName);
		EditText no=(EditText)findViewById(R.id.editTextNumber);

		String name =nam.getText().toString();
		String number=no.getText().toString();
		String picpath=PicturePath;
		
		/*	SQLiteDatabase db = new MySqlOpenHelper(this).getWritableDatabase();
			ContentValues c=new ContentValues();
			c.put(PContract.tables.Child.COLUMN_NAME_CCONCTACT, no.getText().toString());
			c.put(PContract.tables.Child.COLUMN_NAME_NAME, name.getText().toString());
			c.put(PContract.tables.Child.COLUMN_NAME_PICPATH, PicturePath);
			db.insert(PContract.tables.Child.TABLE_NAME, null, c);
			Toast.makeText(this, "Child added to the database", Toast.LENGTH_LONG).show();*/
		
		Intent i = new Intent(this, Verification.class);
		i.putExtra("nameofChild", name);
		i.putExtra("numberofChild", number);
		i.putExtra("picpathofChild", picpath);

   	 
        
		String messageText = "Hi ,Do you want Ahsan as your parent reply yes or no";
        String sent = "SMS_SENT";
 
        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
            new Intent(sent), 0);
 
        //---when the SMS has been sent---
        registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                if(getResultCode() == Activity.RESULT_OK)
                {
                  Toast.makeText(getBaseContext(), "SMS sent",
                                Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "SMS could not sent",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }, new IntentFilter(sent));
 
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, messageText, sentPI, null);
		startActivity(i);
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
