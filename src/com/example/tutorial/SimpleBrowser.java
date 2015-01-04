package com.example.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener {

	EditText url;
	WebView browser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simplebrowser);

		browser = (WebView) findViewById(R.id.wvBrowser);
		url = (EditText) findViewById(R.id.etURL);
		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button forward = (Button) findViewById(R.id.bForward);
		Button clearHistory = (Button) findViewById(R.id.bHistory);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		refresh.setOnClickListener(this);
		forward.setOnClickListener(this);
		clearHistory.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.bGo:
			String theWeb = url.getText().toString();
			browser.loadUrl("http://" + theWeb);
			break;
		case R.id.bBack:
			if(browser.canGoBack())
			browser.goBack();
			break;
		case R.id.bForward:
			if(browser.canGoForward())
			browser.goForward();	
			break;
		case R.id.bRefresh:
			browser.reload();
			break;
		case R.id.bHistory:
			browser.clearHistory();
			break;

		}

	}

}
