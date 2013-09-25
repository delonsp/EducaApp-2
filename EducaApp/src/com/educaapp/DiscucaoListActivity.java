package com.educaapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DiscucaoListActivity extends ListActivity implements OnItemClickListener {

	private String nomeUsuarioPergunta = null;
	private String dataPergunta = null;
	private String pergunta = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		nomeUsuarioPergunta = intent.getStringExtra("nomeUsuario");
		dataPergunta = intent.getStringExtra("data");
		pergunta = intent.getStringExtra("pergunta");
		
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
		
		AdapterDiscucao adapter = new AdapterDiscucao(this);
		
		adapter.add(new DiscucaoForum(nomeUsuarioPergunta, dataPergunta, "", 0, 0, pergunta));
		adapter.add(new DiscucaoForum("mariamf", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		adapter.add(new DiscucaoForum("joanasilva", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		adapter.add(new DiscucaoForum("pedrohenrique", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		adapter.add(new DiscucaoForum("debora_oliveira", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		adapter.add(new DiscucaoForum("fernandorf", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		adapter.add(new DiscucaoForum("thiagopereira", "24/09/2013", "", 5, 0, "O Lorem Ipsum � um texto modelo da ind�stria tipogr�fica e de impress�o. O Lorem Ipsum tem vindo a ser o texto padr�o usado por estas ind�strias desde o ano de 1500, quando uma misturou os caracteres de um texto para criar um esp�cime de livro. Este texto n�o s� sobreviveu 5 s�culos, mas tamb�m o salto para a tipografia electr�nica, mantendo-se essencialmente inalterada."));
		
		setListAdapter(adapter);
	}
	
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent=null;
		DiscucaoForum discucao = (DiscucaoForum) parent.getItemAtPosition(position);
		
	}



}
