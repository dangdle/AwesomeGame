package com.example.musicbuttons;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

	}
	/**
	 * creates the menu for this activity
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startButton01(View view) {
		startIntent(MainMusicScreenActivity.class);
	}
	
	public void exitButton(View view) {
		System.exit(0);
	}
	
	public void helpButton(View view) {
		startIntent(HelpMenuActivity.class);
	}
	
	public void startIntent(Class<? extends Activity> cls){
		Intent intent = new Intent(this, cls);
		startActivity(intent);
	}

}
