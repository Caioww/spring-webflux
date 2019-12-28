package com.apirest.springwebflux.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Playlist {
	
	private String id;
	private String nome;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Playlist(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

}
