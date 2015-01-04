package com.example.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{

	MediaPlayer song;
	
	@Override
	protected void onCreate(Bundle TravisLovesBacon) {
		// TODO Auto-generated method stub
		super.onCreate(TravisLovesBacon);
		setContentView(R.layout.splash);
		song = MediaPlayer.create(Splash.this, R.raw.intro);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		Boolean music = getPrefs.getBoolean("checkbox", true);
		
		if(music == true)
		song.start();
		
		
		
		Thread timer = new Thread(){
			
			@Override
			public void run(){
				try{
					sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMain = new Intent("com.example.tutorial.Menu");
					startActivity(openMain);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
	

}
