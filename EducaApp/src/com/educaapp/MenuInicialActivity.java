package com.educaapp;

import com.educaapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MenuInicialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_inicial);
		
		//onclick btSuspeitar
		findViewById(R.id.btSuspeitar).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuInicialActivity.this,MenuSuspeitarActivity .class);
				startActivity(intent);
			}
		});
		
		
		//onclick Dicas
		findViewById(R.id.btDicas).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MenuInicialActivity.this, "Não implementado", Toast.LENGTH_LONG).show();
			}
		});
		
		
		//onclick Módulos
		findViewById(R.id.btModulos).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuInicialActivity.this,MenuModulosActivity.class);
				startActivity(intent);
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            Toast.makeText(this, "Não implementado", Toast.LENGTH_LONG).show();
	            return true;
	        case R.id.action_help:
	        	Toast.makeText(this, "Não implementado", Toast.LENGTH_LONG).show();
	            return true;
	        case R.id.action_exit:
	        	Toast.makeText(this, "Não implementado", Toast.LENGTH_LONG).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}



