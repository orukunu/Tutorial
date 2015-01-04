package com.example.tutorial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {

	MyBringBackSurface ourSurfaceView;
	float x, y;
	WakeLock wL;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		// WAKELOCK
		PowerManager pM = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "dsasd");

		super.onCreate(savedInstanceState);
		wL.acquire();
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.setOnTouchListener(this);
		x = 0;
		y = 0;
		setContentView(ourSurfaceView);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ourSurfaceView.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSurfaceView.pause();
		wL.release();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		return true;
	}

	public class MyBringBackSurface extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;

		public MyBringBackSurface(Context context) {
			// TODO Auto-generated constructor stub
			super(context);
			ourHolder = getHolder();

		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		public void run() {
			// TODO Auto-generated constructor stub
			while (isRunning) {
				if (!ourHolder.getSurface().isValid()) {
					continue;
				}
				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(02, 02, 150);
				if (x != 0 && y != 0) {
					Bitmap test = BitmapFactory.decodeResource(getResources(),
							R.drawable.greenball);
					canvas.drawBitmap(test, x - (test.getWidth() / 2), y
							- (test.getHeight() / 2), null);
				}
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}

	}

}
