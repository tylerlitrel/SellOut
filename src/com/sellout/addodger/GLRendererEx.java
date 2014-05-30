package com.sellout.addodger;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

/*
 * Render the surface when we need to
 */
public class GLRendererEx implements Renderer{
	private  GLTriangleEx tri;
	
	public GLRendererEx()
	{
		tri = new GLTriangleEx();
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		// TODO Auto-generated method stub
		//gl.glClearColor(.8f, 0f, .2f, .5f);
		gl.glClearDepthf(1f);
		
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClearColor(.2f, .6f, .9f, .5f);
		gl.glDisable(GL10.GL_DITHER);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 0, -10, 0, 0,0, 0, 2, 0);
		tri.draw(gl);
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height); //bottom left of emulator 
		float ratio  = (float)width/height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio,ratio, -1, 1, 1, 25);
		
	}
	

}
