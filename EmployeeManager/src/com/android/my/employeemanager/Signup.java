package com.android.my.employeemanager;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Signup extends Activity  {
	
	EditText names,passwords;
	Button submit;
	NewUser ns;
	SQLiteDatabase db;
	SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		ns=new NewUser(this);
		submit=(Button)findViewById(R.id.button1);
		names=(EditText)findViewById(R.id.editText1);
		passwords=(EditText)findViewById(R.id.editText2);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v == submit) {
				ContentValues value = new ContentValues();
				value.put(NewUser.C_USER, names.getText().toString());
				value.put(NewUser.C_PASS, passwords.getText().toString());
				
				db = ns.getWritableDatabase();
				db.insert(NewUser.TABLE, null, value);
				db.close();
				clearField();
				Toast.makeText(Signup.this, "RECORD UPDATED SUCCESSFULLY",
						Toast.LENGTH_LONG).show();

				
				startAgain();

			}
			}

			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}



	private void clearField() {
		// TODO Auto-generated method stub
		names.setText("");
		passwords.setText("");
	}
	private void startAgain() {
		// TODO Auto-generated method stub
		Intent ip=new Intent(Signup.this,MainActivity.class);
		startActivity(ip);
	}

}
