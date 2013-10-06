package com.my.android.customizabletoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	 // Widget GUI
    Button btnSuccess;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  // Button Widget Unit
        btnSuccess = (Button) findViewById(R.id.bntSuccess);
        btnSuccess.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	       if (v == btnSuccess) {
	    	   
	            // Inflate the Layout
	            LayoutInflater inflater = getLayoutInflater();
	            View layout = inflater.inflate(R.layout.custom_toast,
	                    (ViewGroup) findViewById(R.id.custom_toast_layout_id));
	 
	            // Create Custom Toast
	            Toast toast = new Toast(getApplicationContext());
	            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	            toast.setDuration(Toast.LENGTH_LONG);
	            toast.setView(layout);
	            toast.show();
	        }
	}

}
