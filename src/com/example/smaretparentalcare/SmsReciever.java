package com.example.smaretparentalcare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReciever extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
    	
        Intent in=new Intent(context,DetailActivity.class);
        context.startActivity(in);
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                // get sms objects
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus.length == 0) {
                    return;
                }
                // large message might be broken into many
                SmsMessage[] messages = new SmsMessage[pdus.length];
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    sb.append(messages[i].getMessageBody());
                }
                String sender = messages[0].getOriginatingAddress();
                String message = sb.toString();
     
                Log.d( "Working","Starting new Activit");
                Log.d("Working","Starting new Activit");
               
                context.getApplicationContext().startActivity(in);
                Log.d("Working","Starting new Activit");
                //Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                // prevent any other broadcast receivers from receiving broadcast
                 //abortBroadcast();
            }
        }
    }
}
