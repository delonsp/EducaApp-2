package com.educaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MenuModulosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_modulos);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_modulos, menu);
		return true;
	}
	
	
	
	public void onClick(View v) {
	    int modulo = 0;
	    switch (v.getId()) {
	    case R.id.btModulo1:
	    	modulo = R.string.modulo1;
	        break;
	    case R.id.btModulo2:
	    	modulo = R.string.modulo2;
	        break;
	    case R.id.btModulo3:
	    	modulo = R.string.modulo3;
	        break;
	    case R.id.btModulo4:
	    	modulo = R.string.modulo4;
	        break;
	    }
	    
	    if (modulo != 0){
	    	Intent intent = new Intent(MenuModulosActivity.this,ModuloActivity.class);
	    	intent.putExtra("nomeModulo", modulo);
		    startActivity(intent);
	    }
	    
	}
	

}
