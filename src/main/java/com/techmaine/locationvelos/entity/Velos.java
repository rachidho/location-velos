/**
 * 
 */
package com.techmaine.locationvelos.entity;

/**
 * @author technomaker01
 *
 */
public class Velos {

	private Long idVelos;
	private String nom;
	private int nbrRout;
	private Long idClient;
	
	/**
	 * constructeur vide
	 */
	public Velos() {
	}
	
	/**
	 *  les getters et les setters
	 */
	public Long getIdVelos() {
		return idVelos;
	}
	public void setIdVelos(Long idVelos) {
		this.idVelos = idVelos;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbrRout() {
		return nbrRout;
	}
	public void setNbrRout(int nbrRout) {
		this.nbrRout = nbrRout;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

}
