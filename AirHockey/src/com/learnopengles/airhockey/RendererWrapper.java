package com.learnopengles.airhockey;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class RendererWrapper implements Renderer {

	
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		//GameLibJNIWrapper.on_draw_frame();
	}

	

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		//GameLibJNIWrapper.on_surface_changed(width, height);

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		 //GameLibJNIWrapper.on_surface_created();
	}

	
}
