package com.rajan.androidpong;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Gameview extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gameview, menu);
		return true;
	}
	public class GameView extends SurfaceView  implements SurfaceHolder.Callback
	 {
	    private GameThread _thread;

	    public GameView(Context context, AttributeSet attrs) {
	        super(context, attrs);

	    	//So we can listen for events...
	        SurfaceHolder holder = getHolder();
	        holder.addCallback(this);
	        setFocusable(true); 

	        //and instantiate the thread
	        _thread = new GameThread(holder, context, new Handler());
	    }  

	    @Override
	    public boolean onKeyDown(int keyCode, KeyEvent msg) {
	        return _thread.getGameState().keyPressed(keyCode, msg);
	    }

	    //Implemented as part of the SurfaceHolder.Callback interface
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			//Mandatory, just swallowing it for this example

		}

	    //Implemented as part of the SurfaceHolder.Callback interface
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			_thread.start();
		}

	    //Implemented as part of the SurfaceHolder.Callback interface
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
	        _thread.stop();
		}
	}

}
