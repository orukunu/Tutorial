package com.example.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		
		
		Intent i = new Intent("com.example.tutorial.ForResult");
		startActivityForResult(i, RESULT_OK);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		TextView tvResult = (TextView)findViewById(R.id.tvResultView);
		if (resultCode == RESULT_OK){
			Bundle basket = data.getExtras();
			tvResult.setText(basket.getString("result", "no data"));
			
		}
	}
	
	
	
	

}
