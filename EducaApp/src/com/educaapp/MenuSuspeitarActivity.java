package com.educaapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuSuspeitarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_suspeitar);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_modulos, menu);
		return true;
	}
	
	
	public void onClick(View v) {
		Intent intent=null;
	    switch (v.getId()) {
	    case R.id.btModulo1:
	    	intent = new Intent(MenuSuspeitarActivity.this,QuestDelActivity.class);
	        break;
	    case R.id.btModulo2:
	    	intent = new Intent(MenuSuspeitarActivity.this,QuestAutismoActivity.class);
	    	break;
	    case R.id.btModulo3:
	    	intent = new Intent(MenuSuspeitarActivity.this,QuestDislexiaActivity.class);
	    	break;
	    case R.id.btModulo4:
	    	intent = new Intent(MenuSuspeitarActivity.this,QuestTdahHiperActivity.class);
	    	break;
	    }
	    
	    if (intent!=null){
	    	startActivity(intent);
	    }
		
	    
	}
	

}
