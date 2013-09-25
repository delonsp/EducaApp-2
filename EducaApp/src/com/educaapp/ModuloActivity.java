package com.educaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ModuloActivity extends Activity {
	
	private Integer modulo = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modulo);
		
		Intent intent = getIntent();
		modulo = intent.getIntExtra("nomeModulo", 0);
		if (modulo != 0){
			setTitle(getResources().getString(modulo));
		}
		
		
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modulo, menu);
		return true;
	}
	
	
	
	public void onClick(View v) {
		Boolean implementado = true; 
		Intent intent=null;
	    switch (v.getId()) {
	    case R.id.btArtigos:
	    	intent = new Intent(ModuloActivity.this,ArtigoActivity.class);
	        break;
	    case R.id.btVideos:
	    	intent = new Intent(ModuloActivity.this,VideoActivity.class);
	    	break;
	    case R.id.btAvaliacao:
	    	intent = new Intent(ModuloActivity.this,AvaliacaoActivity.class);
			if (modulo != 0){
				intent.putExtra("nomeModulo", modulo);
			}
	        break;
	    case R.id.btForum:
	    	intent = new Intent(ModuloActivity.this,ForumListActivity.class);
	        break;
	    }
	    
	    if (modulo != 0 && implementado){
	    	intent.putExtra("nomeModulo", modulo);
		    startActivity(intent);
	    }
	    
	}


}
