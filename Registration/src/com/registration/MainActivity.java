package com.registration;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void submit(View v)
	{
		EditText ed=(EditText) findViewById(R.id.editText1);
		EditText ed1=(EditText) findViewById(R.id.editText2);
		EditText ed2=(EditText) findViewById(R.id.editText3);
		String uname="rajan";
		String Password="palaniya";
		String Email="razorpaul@gmail.com";
		String u=ed.getText().toString();
		String p=ed1.getText().toString();
		String e=ed2.getText().toString();
		if(uname.equals(u) && Password.equals(p))
		{
			final Intent i=new Intent(this,login.class);
			i.putExtra("name",u);
			i.putExtra("pass",p);
			i.putExtra("email",e);
			startActivity(i);
		}
		else
		{
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Fail...");
			alertDialog.setMessage("Username,Password,Email Should be Matched");
			alertDialog.setIcon(R.drawable.ic_launcher);
			alertDialog.show();
		}
	}
	public void clear(View v)
	{
		
		EditText ed=(EditText) findViewById(R.id.editText1);
		EditText ed1=(EditText) findViewById(R.id.editText2);
		EditText ed2=(EditText) findViewById(R.id.editText3);
		ed.setText("");
		ed1.setText("");
		ed2.setText("");
	}

}
