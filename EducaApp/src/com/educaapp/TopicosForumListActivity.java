package com.educaapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class TopicosForumListActivity extends ListActivity implements OnItemClickListener {

	private String patologia = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Intent intent = getIntent();
		patologia = intent.getStringExtra("patologia");
		if (patologia != null){
			setTitle(getString(R.string.lbForum) + " " + patologia);
		}else{
			Toast.makeText(this, "Patologia = 0", Toast.LENGTH_SHORT).show();
		}
		
		
		
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
		
		AdapterTopicos adapter = new AdapterTopicos(this);
		
		
		adapter.add(new TopicosForum("Fernanda", "Métodos eficientes de aprendizado", 10, 2, "23/09/2013", "url"));
		adapter.add(new TopicosForum("Juliana", "Comportamento agressivo", 50, 8, "22/09/2013", "url"));
		adapter.add(new TopicosForum("Pedro", "Dúvidas ", 100, 10, "23/09/2013", "url"));
		adapter.add(new TopicosForum("Carlos", "Como lidar com o comportamento de crianças acima de 3 anos ?", 38, 5, "21/09/2013", "url"));
		adapter.add(new TopicosForum("Silvia", "Como agir e diálogar ?", 150, 15, "20/09/2013", "url"));
		adapter.add(new TopicosForum("Silvia", "Inclusão", 200, 20, "19/08/2013", "url"));
		
		
		setListAdapter(adapter);
		
		
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = null;
		TopicosForum topico = (TopicosForum) parent.getItemAtPosition(position);
		Toast.makeText(this, topico.getTituloTopico(), Toast.LENGTH_LONG).show();
		
		intent = new Intent(TopicosForumListActivity.this,DiscucaoListActivity.class);
		intent.putExtra("nomeUsuario", topico.getNomeUsuario()); 
		intent.putExtra("data", topico.getData());
		intent.putExtra("pergunta", topico.getTituloTopico());
		startActivity(intent);
	}

}
