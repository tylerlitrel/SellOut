package com.sellout.addodger;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity{

	Display drawView;
	private Handler h;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 h = new Handler();
//		handler frame = new Handler();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        drawView = new Display(this);
        drawView.setBackgroundColor(Color.BLUE);
       
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
       //             initGfx();
            }
}, 1000);
        
        
        setContentView(drawView);      
        
	}
	/*
	synchronized public void initGfx() {
    //    drawView.moveRectangle.resetStarField();
       // ((Button)findViewById(R.id.the_button)).setEnabled(true);
        //It's a good idea to remove any existing callbacks to keep
        //them from inadvertently stacking up.
    //    frame.removeCallbacks(frameUpdate);
    //    frame.postDelayed(frameUpdate, FRAME_RATE);
        
        synchronized public void onClick(View v) {
                 initGfx();
        }
        private Runnable frameUpdate = new Runnable() {
              @Override
              synchronized public void run() {
                      frame.removeCallbacks(frameUpdate);
                      //make any updates to on screen objects here
                      //then invoke the on draw by invalidating the canvas
                      ((GameBoard)findViewById(R.id.the_canvas)).invalidate();
                      frame.postDelayed(frameUpdate, FRAME_RATE);
              }
         };
  //  }
    }
    */

}
