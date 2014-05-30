package com.sellout.addodger;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLTriangleEx {

	private FloatBuffer vertBuff;
	private short[] pIndex = {0,1,2};
	private ShortBuffer pBuff;
	private float[] verticies = {
			  //(x,y)
				-1f,-1f, //point 0
				0f,1f, //point 1
				1f,-1f //point 3
		};
		
	public GLTriangleEx()
	{
		ByteBuffer bBuff = ByteBuffer.allocateDirect(verticies.length*4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();	
		vertBuff.put(verticies);
		vertBuff.position(0); //top of our triangle
		
		ByteBuffer pbBuff = ByteBuffer.allocateDirect(pIndex.length*2);
		pbBuff.order(ByteOrder.nativeOrder()); //garbage collector wont dump this now
		pBuff = pbBuff.asShortBuffer();
		pBuff.put(pIndex);
		pBuff.position(0);
	}
	public void draw(GL10 gl)
	{
		gl.glFrontFace(GL10.GL_CW); //clockwise, front will be facing us
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); //enable client state
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertBuff);
		gl.glDrawElements(GL10.GL_TRIANGLES, pIndex.length,GL10.GL_UNSIGNED_SHORT,pBuff);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY); //disable client state
	}
	

}
