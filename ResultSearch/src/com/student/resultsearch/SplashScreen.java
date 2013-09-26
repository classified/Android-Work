package com.student.resultsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class SplashScreen extends Activity {

	 private static final int SPLASH_DURATION = 6000; // 6 seconds

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		// Starting Handler
		Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
        	 
            @Override
            public void run() {
 
                // make sure we close the splash screen so the user won't come back when it presses back key
 
                finish();
                 
                if (true) {
                    // start the home screen if the back button wasn't pressed already
                    Intent intent = new Intent(SplashScreen.this, Selection.class);
                    SplashScreen.this.startActivity(intent);
               }
                 
            }
 
        }, SPLASH_DURATION);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
