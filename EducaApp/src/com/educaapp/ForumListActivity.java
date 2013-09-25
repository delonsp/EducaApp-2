package com.educaapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ForumListActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		ListView listView = getListView();
		listView.setOnItemClickListener(this);
		
		AdapterPatologia adapter = new AdapterPatologia(this);
		adapter.add(new PatologiasForum("TDAH", 1));
		adapter.add(new PatologiasForum("DEL", 2));
		adapter.add(new PatologiasForum("Autismo", 3));
		adapter.add(new PatologiasForum("Dislexia", 4));
		
		setListAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent=null;
		PatologiasForum patologia = (PatologiasForum) parent.getItemAtPosition(position);
		intent = new Intent(ForumListActivity.this,TopicosForumListActivity.class);
		intent.putExtra("patologia", patologia.getNome()); 
		startActivity(intent);
		
	}


}
