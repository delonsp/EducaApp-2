package com.educaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterDiscucao extends ArrayAdapter<DiscucaoForum>{ 
	
	private String teste;
	
	private int resource;
	public AdapterDiscucao(Context context) {
		super(context, R.layout.adapter_discucao);
		this.resource = R.layout.adapter_discucao;
		
	}
	
	//para cada item este método será chamado
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//position     -> posição na lista daquela view a ser renderizada
		//convertView  -> view convertida view final (na primeira vez a convertview é null)
		//parent	   -> view pai do layout que esta sendo montado
		
		DiscucaoForum discucaoForum = getItem(position);
		LinearLayout layout = null;
		
		if (convertView == null){
			//view sendo criado agora
			LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) layoutInflater.inflate(resource, null);
		} else {
			layout = (LinearLayout) convertView;
		}
		
		
		TextView nomeUsuario = (TextView) layout.findViewById(R.id.textDiscucaoNomeUsuario);
		TextView data = (TextView) layout.findViewById(R.id.textDiscucaoData);
		TextView qtLikes = (TextView) layout.findViewById(R.id.textDiscucaoLikes); 
		TextView qtDislikes = (TextView) layout.findViewById(R.id.textDiscucaoDislikes);
		TextView resposta = (TextView) layout.findViewById(R.id.textDiscucaoResposta);
		
		//TODO definir imagens 
		ImageView imgUsuario = (ImageView) layout.findViewById(R.id.imgDiscucaoUsuario);
		ImageView imgLikes = (ImageView) layout.findViewById(R.id.imgDiscucaoLikes);
		ImageView imgDislikes = (ImageView) layout.findViewById(R.id.imgDiscucaoDislike);
		ImageView imgData = (ImageView) layout.findViewById(R.id.imgDiscucaoData);
		
		
		nomeUsuario.setText(discucaoForum.getNomeUsuario());
		data.setText(discucaoForum.getData());
		qtLikes.setText(String.valueOf(discucaoForum.getQtLike()));
		qtDislikes.setText(String.valueOf(discucaoForum.getQtDislike()));
		resposta.setText(discucaoForum.getResposta());
		
		return layout;
		
	}
	
}
