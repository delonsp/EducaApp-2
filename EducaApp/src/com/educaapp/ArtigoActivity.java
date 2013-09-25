package com.educaapp;

import java.io.File;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;

public class ArtigoActivity extends Activity {
	
	private Integer modulo = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_artigo);
		
		
		Intent intent = getIntent();
		modulo = intent.getIntExtra("nomeModulo", 0);
		if (modulo != 0){
			setTitle(getResources().getString(R.string.title_activity_video) +" "+ getResources().getString(modulo));
		}
		
		
		String path=null;

	    switch (modulo) {
	    case R.string.modulo1:
	    	path = getResources().getString(R.string.artigoDel);
	        break;
	    case R.string.modulo2:
	    	path = getResources().getString(R.string.artigoAutismo);
	      break;
	    case R.string.modulo3:
	    	path = getResources().getString(R.string.artigoDislexia);
	        break;
	    case R.string.modulo4:
	    	path = getResources().getString(R.string.artigoTdah);
	        break;
	    }
		
	    
	    
	    if (path != null){
			
			String path_name = Environment.getExternalStorageDirectory().getPath() + path;
			
			Intent intentView = new Intent();
			intentView.setComponent(new ComponentName("com.radaee.reader", "com.radaee.reader.PDFReaderAct"));
			intentView.putExtra("pdfname", path_name);
			intentView.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentView);

	    }
		
		
		/*
		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/EducaApp/artigos/autismo.pdf");
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file),"application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		
		startActivity(intent);
		*/
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.artigo, menu);
		return true;
	}

}
