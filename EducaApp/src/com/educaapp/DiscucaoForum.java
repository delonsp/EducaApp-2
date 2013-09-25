package com.educaapp;

public class DiscucaoForum {
	private String nomeUsuario;
	private String data;
	private String urlFoto;
	private int qtLike;
	private int qtDislike;
	private String resposta;
	
	
	
	public DiscucaoForum(String nomeUsuario, String data, String urlFoto,
			int qtLike, int qtDislike, String resposta) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.data = data;
		this.urlFoto = urlFoto;
		this.qtLike = qtLike;
		this.qtDislike = qtDislike;
		this.resposta = resposta;
	}
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
	public int getQtLike() {
		return qtLike;
	}
	public void setQtLike(int qtLike) {
		this.qtLike = qtLike;
	}
	public int getQtDislike() {
		return qtDislike;
	}
	public void setQtDislike(int qtDislike) {
		this.qtDislike = qtDislike;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	

}
