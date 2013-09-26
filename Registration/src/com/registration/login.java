package com.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class login extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		String uname,pass,email;
		Intent i=getIntent();
		uname=i.getStringExtra("name");
		pass=i.getStringExtra("pass");
		email=i.getStringExtra("email");
		TextView un=(TextView)findViewById(R.id.textView2);
		TextView pa=(TextView)findViewById(R.id.textView3);
		TextView em=(TextView)findViewById(R.id.textView4);
		un.setText(uname);
		pa.setText(pass);
		em.setText(email);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
