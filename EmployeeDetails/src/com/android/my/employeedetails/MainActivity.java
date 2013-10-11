package com.android.my.employeedetails;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText txtName, txtDesig, txtSalary;
	Button btnAdd;
	SimpleCursorAdapter adapter;
	DBHelper helper;
	SQLiteDatabase db;
	ListView disp;
	public boolean NetStatus = false;

	String uname, pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);

		helper = new DBHelper(this);
		txtName = (EditText) findViewById(R.id.txtName);
		txtDesig = (EditText) findViewById(R.id.txtGraduation);
		txtSalary = (EditText) findViewById(R.id.txtSalary);
		btnAdd = (Button) findViewById(R.id.button1);
		disp = (ListView) findViewById(R.id.dispID);
		fetchdata();
		btnAdd.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	private void fetchdata() {
		// TODO Auto-generated method stub
		db = helper.getReadableDatabase();
		Cursor c = db.query(DBHelper.TABLE, null, null, null, null, null, null);
		adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.rows, c,
				new String[] { DBHelper.C_NAME, DBHelper.C_SALARY,
						DBHelper.C_DESIGNATION }, new int[] { R.id.lblName,
						R.id.lblSalary, R.id.lblDesig });
		disp.setAdapter(adapter);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (uname.equals(null) && pass.equals(null)) {
			Intent myIntent=new Intent(MainActivity.this,LoginEmp.class);
			startActivity(myIntent);
		}

		if (arg0 == btnAdd) {
			ContentValues value = new ContentValues();
			value.put(DBHelper.C_NAME, txtName.getText().toString());
			value.put(DBHelper.C_DESIGNATION, txtDesig.getText().toString());
			value.put(DBHelper.C_SALARY, txtSalary.getText().toString());
			db = helper.getWritableDatabase();
			db.insert(DBHelper.TABLE, null, value);
			db.close();
			clearField();
			Toast.makeText(MainActivity.this, "RECORD UPDATED SUCCESSFULLY",
					Toast.LENGTH_LONG).show();

			fetchdata();
			NetStatus = isNetworkAvailable();
			if (NetStatus == true)
				Toast.makeText(MainActivity.this, "NETWORK ACCESS IS ENABLED",
						Toast.LENGTH_LONG).show();

		}

	}

	private void clearField() {
		// TODO Auto-generated method stub
		txtName.setText("");
		txtDesig.setText("");
		txtSalary.setText("");

	}

	public boolean isNetworkAvailable() {
		// Get Connectivity Manager class object from Systems Service
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		// Get Network Info from connectivity Manager
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();

		// if no network is available networkInfo will be null
		// otherwise check if we are connected
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
