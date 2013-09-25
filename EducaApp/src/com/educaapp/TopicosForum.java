package com.educaapp;

public class TopicosForum {
	private String nomeUsuario;
	private String tituloTopico;
	private int  qtVizualizacoes;
	private int qtRespostas;
	private String data;
	private String urlFoto;
	
	public TopicosForum(String nomeUsuario, String tituloTopico,
			int qtVizualizacoes, int qtRespostas, String data, String urlFoto) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.tituloTopico = tituloTopico;
		this.qtVizualizacoes = qtVizualizacoes;
		this.qtRespostas = qtRespostas;
		this.data = data;
		this.urlFoto = urlFoto;
	}
	
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public String getTituloTopico() {
		return tituloTopico;
	}



	public void setTituloTopico(String tituloTopico) {
		this.tituloTopico = tituloTopico;
	}



	public int getQtVizualizacoes() {
		return qtVizualizacoes;
	}



	public void setQtVizualizacoes(int qtVizualizacoes) {
		this.qtVizualizacoes = qtVizualizacoes;
	}



	public int getQtRespostas() {
		return qtRespostas;
	}



	public void setQtRespostas(int qtRespostas) {
		this.qtRespostas = qtRespostas;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getUrlFoto() {
		return urlFoto;
	}



	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}




	
	
	
}
