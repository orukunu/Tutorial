package com.example.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ForResult extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forresult);

		
		final EditText etResult = (EditText)findViewById(R.id.etForResult);
		Button bOk = (Button)findViewById(R.id.bOkResult);
		
		bOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String result;
				result = etResult.getText().toString();
				Intent returnIntent = new Intent();
				Bundle orkun = new Bundle();
				orkun.putString("result",result);
				returnIntent.putExtras(orkun);
				setResult(RESULT_OK,returnIntent);
				finish();
				
			}
		});
		
		
	}
	
	

}
