package com.opengldemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.opengl.*;



public class MainActivity extends SurfaceView implements SurfaceHolder.Callback {
	


	SurfaceHolder mAndroidholder;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 Object mAndroidSurface = new MainActivity(this);
		setContentView(mAndroidSurface);
		}
		
	




	@SuppressWarnings("deprecation")
	public MainActivity(Context context) {
		super(context);
		mAndroidholder=getHolder();
		mAndroidholder.addCallback(this);
		mAndroidholder.setType(SurfaceHolder.SURFACE_TYPE_GPU);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	

}



