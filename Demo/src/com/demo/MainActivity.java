package com.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	protected boolean _active = true;
	protected int _splashTime = 3000; // time to display the splash screen in ms
	ProgressDialog progressBar;
	private int progressBarStatus = 0;
	private Handler progressBarHandler = new Handler();
	private long fileSize = 0;
	View v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar = new ProgressDialog(v.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Loading Files ...");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();

		//reset progress bar status
		progressBarStatus = 0;

		//reset filesize
		fileSize = 0;

		new Thread(new Runnable() {
		  public void run() {
			while (progressBarStatus < 100) {

			  // process some tasks
			  progressBarStatus = doSomeTasks();

			  // your computer is too fast, sleep 1 second
			  try {
				Thread.sleep(1000);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }

			  // Update the progress bar
			  progressBarHandler.post(new Runnable() {
				public void run() {
				  progressBar.setProgress(progressBarStatus);
				}
			  });
			}

			// ok, file is downloaded,
			if (progressBarStatus >= 100) {

				// sleep 2 seconds, so that you can see the 100%
				try {
					Thread.sleep(2000);
					startActivity(new Intent(MainActivity.this, second.class));
					finish();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// close the progress bar dialog
				progressBar.dismiss();
			}
		  }
	       });

           }

            

    

// file download simulator... a really simple
public int doSomeTasks() {

	while (fileSize <= 1000000) {

		fileSize++;

		if (fileSize == 100000) {
			return 10;
		} else if (fileSize == 200000) {
			return 20;
		} else if (fileSize == 300000) {
			return 30;
		}
		// ...add your own

	}

	return 100;

}

		/*Thread newThread = new Thread() {
			@Override
			public void run() {
				try {
					int wait = 0;
					while (_active && (wait < _splashTime)) {
						sleep(100);
						if (_active) {
							wait += 100;
						}
					}
				} catch (Exception e) {

				} finally {
					startActivity(new Intent(MainActivity.this, second.class));
					finish();
				}
			};
		};
		newThread.start();*/

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
