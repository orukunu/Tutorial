package com.example.tutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity", "TextPlay", "Camera", "Data", "GFX",
			"GFXSurface", "Tabs", "SimpleBrowser", "Flipper", "SharedPrefs",
			"InternalData", "ExternalData","Result"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// FULLSCREEN
		/*
		 * requestWindowFeature(Window.FEATURE_NO_TITLE);
		 * getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		 * WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 */
		// LISTADAPTER
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	// LIST ITEM CLICK LISTENER
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];

		// SIMPLE INTENT

		try {
			Class ourClass = Class.forName("com.example.tutorial." + cheese);
			Intent intent = new Intent(Menu.this, ourClass);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// OPTION MENU
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	// OpMENU ITEM SELECTED
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.tutorial.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.example.tutorial.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}

}
