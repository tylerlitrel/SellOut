package com.sellout.addodger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;

public class Display extends View{
	Paint paint = new Paint();
	android.view.Display display;
	Rect r = new Rect();
	@SuppressLint("NewApi")
	public Display(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		paint.setColor(Color.WHITE);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
	
		r.set(size.x/2-25, size.y/2-25, size.x/2+25, size.y/2+25);
		
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawRect(r, paint);
		
		  //canvas.drawLine(display.getWidth(), display., 20, 20, paint);
          //canvas.drawLine(20, 0, 0, 20, paint);
	}
	
	
	public void drawRect(Rect r, Canvas canvas){
		this.r = r;
		canvas.drawRect(r,paint);
	}
	
	
	

	
}
