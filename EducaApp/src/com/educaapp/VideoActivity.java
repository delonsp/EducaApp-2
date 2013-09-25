package com.educaapp;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {
	
	
	private MediaController mediaController;
	private Integer modulo = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		Intent intent = getIntent();
		modulo = intent.getIntExtra("nomeModulo", 0);
		if (modulo != 0){
			setTitle(getResources().getString(R.string.title_activity_video) +" "+ getResources().getString(modulo));
		}
		
		
		String path=null;

	    switch (modulo) {
	    case R.string.modulo1:
	    	path = getResources().getString(R.string.videoDel);
	        break;
	    //case R.string.modulo2:
	    //	path = getResources().getString(R.string.videoAutismo);
	    //  break;
	    case R.string.modulo3:
	    	path = getResources().getString(R.string.videoDislexia);
	        break;
	    case R.string.modulo4:
	    	path = getResources().getString(R.string.videoTdah);
	        break;
	    }
		
	    


	    
	    if (path != null){
			Uri uri = Uri.parse(path);
			mediaController = new MediaController(this);
			VideoView videoView = (VideoView) findViewById(R.id.videoView1);
	        videoView.setOnPreparedListener(new OnPreparedListener() {

	            @Override
	            public void onPrepared(MediaPlayer mp) {
	                mediaController.show(0);
	            }
	        });
	       
	        videoView.setMediaController(mediaController);
	        videoView.setVideoURI(uri);
	        //videoView.start();		

	    }else{
	    	File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/EducaApp/videos/autismo.mp4");
			Intent intentView = new Intent(Intent.ACTION_VIEW);
			intentView.setDataAndType(Uri.fromFile(file),"video/*");
			intentView.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentView);
	    }
	    
		
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video, menu);
		
		
		return true;
	}

}
