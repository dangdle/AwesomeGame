package com.example.musicbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class HelpMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_menu);

	}

	public void back(View view){
		finish();
	}

}
