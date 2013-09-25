package com.educaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterTopicos extends ArrayAdapter<TopicosForum>{

	private int resource;
	public AdapterTopicos(Context context) {
		super(context, R.layout.adapter_topico);
		this.resource = R.layout.adapter_topico;
	}
	
	//para cada item este método será chamado
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//position     -> posição na lista daquela view a ser renderizada
		//convertView  -> view convertida view final (na primeira vez a convertview é null)
		//parent	   -> view pai do layout que esta sendo montado
		
		TopicosForum topicoForum = getItem(position);
		LinearLayout layout = null;
		
		if (convertView == null){
			//view sendo criado agora
			LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) layoutInflater.inflate(resource, null);
		} else {
			layout = (LinearLayout) convertView;
		}
		
		TextView nomeUsuario = (TextView) layout.findViewById(R.id.textTopicoNomeUsuario);
		TextView tituloTopico = (TextView) layout.findViewById(R.id.textTopicoTitulo);
		TextView qtRespostas = (TextView) layout.findViewById(R.id.textTopicoRespostas);
		TextView vizualizacoes = (TextView) layout.findViewById(R.id.textTopicoVizualizacoes);
		TextView data = (TextView) layout.findViewById(R.id.textTopicoData);
		
		//TODO definir imagens 
		ImageView imgUsuario = (ImageView) layout.findViewById(R.id.imgDiscucaoUsuario);
		ImageView imgRespostas = (ImageView) layout.findViewById(R.id.imgDiscucaoLikes);
		ImageView imgVizualizacoes = (ImageView) layout.findViewById(R.id.imgDiscucaoDislike);
		ImageView imgData = (ImageView) layout.findViewById(R.id.imgDiscucaoData);
		
		
		nomeUsuario.setText(topicoForum.getNomeUsuario());
		tituloTopico.setText(topicoForum.getTituloTopico());
		qtRespostas.setText(String.valueOf(topicoForum.getQtRespostas()));
		vizualizacoes.setText(String.valueOf(topicoForum.getQtVizualizacoes()));
		data.setText(topicoForum.getData());
		
		return layout;
		
	}
	
	

}
