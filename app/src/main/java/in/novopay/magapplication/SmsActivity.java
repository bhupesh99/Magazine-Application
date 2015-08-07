package in.novopay.magapplication;

/**
 * Created by rohitshukla on 8/7/15.
 */


import android.app.Activity;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.view.Menu;


public class SmsActivity extends Activity {

    Button sendBtn;

    EditText txtphoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*sendBtn = (Button) findViewById(R.id.btnSendSMS);

        txtphoneNo = (EditText) findViewById(R.id.editText);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });*/

        sendSMSMessage(MainActivity.phoneNo);
    }

    protected void sendSMSMessage(String phoneNo) {
        Log.i("Send SMS", "");

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, "Application Working", null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


}









