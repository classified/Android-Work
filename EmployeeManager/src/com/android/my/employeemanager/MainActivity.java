package com.android.my.employeemanager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button login, exit, reg;
	EditText user, pass;
	TextView process;
	Handler pbHandler = new Handler();
	private int mProgressStatus = 0;
	int fileSize = 0;
	static String usr ;
	static  String ps ;
	NewUser nUser;
	SQLiteDatabase db;
	SimpleCursorAdapter adapter;

	ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nUser=new NewUser(this);
		login = (Button) findViewById(R.id.btnLogin);
		exit = (Button) findViewById(R.id.btnExit);
		user = (EditText) findViewById(R.id.txtUname);
		pass = (EditText) findViewById(R.id.txtPass);
		process = (TextView) findViewById(R.id.loading);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
		reg = (Button) findViewById(R.id.reg);
		fetchdata();
		reg.setOnClickListener(this);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pb.setMax(100);
				pb.setProgress(0);
				pb.setVisibility(1);

				if (usr.equals(user.getText().toString())
						&& ps.equals(pass.getText().toString())) {
					new Thread(new Runnable() {
						public void run() {
							while (mProgressStatus < 100) {

								try {
									Thread.sleep(1000);
								} catch (Exception e) {

								}
								mProgressStatus = doWork();

								// Update the progress bar
								pbHandler.post(new Runnable() {
									public void run() {
										pb.setProgress(mProgressStatus);
										process.setText("Loading Completed ...."
												+ mProgressStatus + "%");
									}
								});
								if (mProgressStatus == 100) {
									Intent myIntent = new Intent(
											MainActivity.this, MainMenu.class);
									startActivity(myIntent);
								}
							}
						}

					}).start();
				} else {
					Toast.makeText(MainActivity.this,
							"UserName or Password is Wrong !",
							Toast.LENGTH_LONG).show();
					user.setText("");
					pass.setText("");
					pb.setVisibility(0);
				}

			}
		});
	
	}

	private void fetchdata() {
		// TODO Auto-generated method stub
		db = nUser.getReadableDatabase();
		Cursor c = db.query(NewUser.TABLE, null, null, null, null, null, null);
		usr=NewUser.C_USER;
		ps=NewUser.C_PASS;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private int doWork() {

		// TODO Auto-generated method stub
		while (fileSize <= 1000000) {

			fileSize++;

			if (fileSize == 100000) {
				return 10;
			} else if (fileSize == 200000) {
				return 20;
			} else if (fileSize == 300000) {
				return 30;
			} else if (fileSize == 400000) {
				return 40;
			} else if (fileSize == 500000) {
				return 50;
			} else if (fileSize == 600000) {
				return 60;
			} else if (fileSize == 700000) {
				return 70;
			} else if (fileSize == 800000) {
				return 80;
			} else if (fileSize == 900000) {
				return 90;
			}

		}

		return 100;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent ex=new Intent(MainActivity.this,Signup.class);
		startActivity(ex);
	}

}
