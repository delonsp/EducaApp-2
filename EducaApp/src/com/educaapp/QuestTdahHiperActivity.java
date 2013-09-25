package com.educaapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class QuestTdahHiperActivity extends Activity {

	private final List<String> selecionados = new ArrayList<String>();
	private Boolean[] arrayStatus; 
	private TextView txtTituloQuest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.questionario_padrao);
		Resources resources = getResources();
		ListView lsvPerguntas = (ListView) findViewById(R.id.lsvPerguntas);
		txtTituloQuest = (TextView) findViewById(R.id.txtTituloQuest);
		txtTituloQuest.setText(R.string.title_quest_tdah_hiper);
		
		
	
		final String[] perguntas = resources
				.getStringArray(R.array.arrayPerguntas);
		
		//array com o status de cada pergunta 
		arrayStatus = new Boolean[perguntas.length];
		
		Arrays.fill(arrayStatus, false);
		
		
		//botão Questionário
		findViewById(R.id.btQuestionario).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[][] totPorPergunta = new int[2][1]; 
				int iLinha = 0;
				int iColuna = 0;
				boolean suspeitar = false;
				String msg = "Há indicios para desconfiar de ";
				
				if (selecionados.size() >= 6){ //TODO faz parte da lógica do questionário
				
					//"limpa status"
					for(int i =0; i< arrayStatus.length;i++){
						if (arrayStatus[i] != null){
							arrayStatus[i] = false;							
						}
					}
				
					for (String item : selecionados){
						for(int i =0; i< perguntas.length;i++){
							if (perguntas[i].equals(item)){
								arrayStatus[i] = true;
							} 
						}
					}
				
				
				for(int i =0; i< arrayStatus.length;i++){
					if (arrayStatus[i]==null){
						if (i !=0){
							iLinha++;
						}						
					}else if (arrayStatus[i]==true){
						totPorPergunta[iLinha][iColuna] = totPorPergunta[iLinha][iColuna] + 1;
					}
					
				}
				
						
				}
				

				if (totPorPergunta[0][0] >= 6){
					msg = msg + "TDAH ";
					suspeitar = true;
				} 
				
				if (totPorPergunta[1][0] >= 6){
					if (suspeitar){
						msg = msg + "e ";
					}
					msg = msg + "Hiperatividade ";
					suspeitar = true;
				}
				
				if (suspeitar){
					
					 AlertDialog.Builder builder = new AlertDialog.Builder(QuestTdahHiperActivity.this);
				        builder.setMessage(msg)
				               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				                   public void onClick(DialogInterface dialog, int id) {
				                       
				                   }
				               
				               });
				        
				        builder.show();
				}else{
					
					 AlertDialog.Builder builder = new AlertDialog.Builder(QuestTdahHiperActivity.this);
				        builder.setMessage("Não há indicios para suspeita.")
				               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				                   public void onClick(DialogInterface dialog, int id) {
				                       
				                   }
				               
				               });
				        
				        builder.show();
				}
				
			}
		});

		// Adapter para implementar o layout customizado de cada item
		ArrayAdapter<String> lsvPerguntasAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1) {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				Log.i("EducaApp",String.valueOf(position));
				// Recuperando a pergunta selecionada de acordo com a sua
				// posição no ListView
				String strPerguntas = perguntas[position];

				// Se o ConvertView for diferente de null o layout já foi
				// "inflado"
				View v = convertView;

				if (v == null) {
					// "Inflando" o layout do item caso o isso ainda não tenha
					// sido feito
					LayoutInflater inflater = getLayoutInflater();
					v = (View) inflater.inflate(R.layout.item_pergunta, null);

				}

				CheckBox chk = (CheckBox) v.findViewById(R.id.chkEstados);

				// Definindo um "valor" para o checkbox
				chk.setTag(strPerguntas);

				// Definindo uma ação ao clicar no checkbox
				chk.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						CheckBox chk = (CheckBox) v;
						String perguntaSelecionada = (String) chk.getTag();
						if (chk.isChecked()) {
							if (!selecionados.contains(perguntaSelecionada))
								selecionados.add(perguntaSelecionada);
								//Toast.makeText(getApplicationContext(), selecionados.toString(), Toast.LENGTH_SHORT).show();
								
						} else {
							if (selecionados.contains(perguntaSelecionada))
								selecionados.remove(perguntaSelecionada);
								//Toast.makeText(getApplicationContext(), selecionados.toString(), Toast.LENGTH_SHORT).show();	
						}

					}

				});

				if (selecionados.contains(strPerguntas)) {
					chk.setChecked(true);
					
				} else {
					chk.setChecked(false);
				}

				// Preenche o TextView do layout com a pergunta
				TextView txv = (TextView) v.findViewById(R.id.txvEstados);
				// identifica pergunta
				
				if (strPerguntas.indexOf("#") == 0) {
					arrayStatus[position] = null;
					strPerguntas = strPerguntas.replaceAll("#", "");
					txv.setTextSize(20);
					chk.setVisibility(View.INVISIBLE);
				}else{
					txv.setTextSize(15);
					chk.setVisibility(View.VISIBLE);
					
				}
				
				txv.setText(strPerguntas);

				return v;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public int getCount() {
				return perguntas.length;
			}
		};
		
		
		lsvPerguntas.setAdapter(lsvPerguntasAdapter);
	}
	
	
	
	
}
