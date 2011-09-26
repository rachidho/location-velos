package com.techmaine.locationvelos.entity;

public class Client {
	
	private Long idClient;
	private String nomClient;
	private String preClient;
	
	// constructeur vide
	public Client() {
	}
	
	// les getters et les setters
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPreClient() {
		return preClient;
	}

	public void setPreClient(String preClient) {
		this.preClient = preClient;
	}

}
