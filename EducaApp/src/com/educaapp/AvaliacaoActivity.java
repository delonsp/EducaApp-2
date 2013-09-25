package com.educaapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class AvaliacaoActivity extends Activity {


	private final List<String> selecionados = new ArrayList<String>();
	private Boolean[] arrayStatus; 
	private TextView txtTituloQuest;
	private Integer modulo = 0;
	private Button botaoAvaliar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Intent intent = getIntent();
		modulo = intent.getIntExtra("nomeModulo", 0);
		if (modulo != 0){
			setTitle(getString(R.string.title_activity_avaliacao) +" "+ getString(modulo));
		}
		

		setContentView(R.layout.questionario_padrao);
		Resources resources = getResources();
		ListView lsvPerguntas = (ListView) findViewById(R.id.lsvPerguntas);
		txtTituloQuest = (TextView) findViewById(R.id.txtTituloQuest);
		txtTituloQuest.setText(R.string.title_Avaliacao);
		botaoAvaliar = (Button) findViewById(R.id.btQuestionario);
		botaoAvaliar.setText(R.string.lbBtAvaliacao);
		
		
		
	
		final String[] perguntas = resources
				.getStringArray(R.array.arrayAvaliacao);
		
		//array com o status de cada pergunta 
		arrayStatus = new Boolean[perguntas.length];
		
		Arrays.fill(arrayStatus, false);
		
		
		//botão Questionário
		findViewById(R.id.btQuestionario).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[][] totPorPergunta = new int[3][1]; //TODO fazer função para instanciar automáticamente
				int iLinha = 0;
				int iColuna = 0;
				boolean suspeitar = false;
				
				
				
				
	
				 
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
				
				//lógica questionário
				if (totPorPergunta[0][0] >= 2 && totPorPergunta[1][0] >= 2 && totPorPergunta[2][0] >= 2){
					suspeitar = true;
				} 
				
				
				if (suspeitar){
					 AlertDialog.Builder builder = new AlertDialog.Builder(AvaliacaoActivity.this);
				        builder.setMessage(getString(R.string.txtAprovado))
				               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
				                   public void onClick(DialogInterface dialog, int id) {
				                       
				                   }
				               
				               });
				        
				        builder.show();
				}else{
					
					
					 AlertDialog.Builder builder = new AlertDialog.Builder(AvaliacaoActivity.this);
				        builder.setMessage(getString(R.string.txtReprovado))
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
