package com.educaapp;

public class PatologiasForum {
	private String nome;
	private int imagem;
	
	
	public PatologiasForum(String nome, int imagem) {
		super();
		this.nome = nome;
		this.imagem = imagem;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getImagem() {
		return imagem;
	}


	public void setImagem(int imagem) {
		this.imagem = imagem;
	}
	
	
}
