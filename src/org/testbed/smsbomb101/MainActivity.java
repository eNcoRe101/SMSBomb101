package org.testbed.smsbomb101;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener 
{
	private static final String TAG = "SMSBomb101";
	private EditText message, phoneNumber, numberOfText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button sendButton = (Button)findViewById(R.id.sendButton);
		sendButton.setOnClickListener(this);
		message = (EditText)findViewById(R.id.messageSMS);
		phoneNumber = (EditText)findViewById(R.id.phoneNum);
		numberOfText = (EditText)findViewById(R.id.numSMS);
	}
	
	private String getPhoneNumber()
	{
		return phoneNumber.getText().toString();
	}
	
	private String getSMSMessage()
	{
		return message.getText().toString();
	}
	
	private int getNumberOfSMS()
	{
		return Integer.parseInt(numberOfText.getText().toString());
	}
	
	private void sendSMS()
	{
		SmsManager newSMS = SmsManager.getDefault();
		for(int currentSMS = 0; currentSMS < getNumberOfSMS(); currentSMS ++)
		{
			newSMS.sendTextMessage(getPhoneNumber(), null, getSMSMessage(), null, null);
		}
	}

	@Override
	public void onClick(View currentButton) 
	{
		sendSMS();
		Log.d(TAG, "Send button clicked");
	}

}
