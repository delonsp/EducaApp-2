package com.educaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterPatologia extends ArrayAdapter<PatologiasForum>{

	private int resource;
	public AdapterPatologia(Context context) {
		super(context, R.layout.adapter_patologia);
		this.resource = R.layout.adapter_patologia;
	}
	
	//para cada item este método será chamado
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//position     -> posição na lista daquela view a ser renderizada
		//convertView  -> view convertida view final (na primeira vez a convertview é null)
		//parent	   -> view pai do layout que esta sendo montado
		
		PatologiasForum patologia = getItem(position);
		LinearLayout layout = null;
		
		if (convertView == null){
			//view sendo criado agora
			LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) layoutInflater.inflate(resource, null);
		} else {
			layout = (LinearLayout) convertView;
		}
		
		TextView nome = (TextView) layout.findViewById(R.id.textNomePatologia);
		
		
		nome.setText(patologia.getNome());
		
		
		return layout;
		
	}
	
	

}
