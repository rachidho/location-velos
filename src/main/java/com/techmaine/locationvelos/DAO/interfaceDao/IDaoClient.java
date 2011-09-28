package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Client;

public interface IDaoClient {
	
	/**
	 * methode qui enregistre les client
	 */
	public int ajoutClient(Client client) throws SQLException;
	
	/**
	 * methode qui modifier les client
	 */
	public int updateClient(Client client) throws SQLException;
	
	/**
	 * methode qui supprime les clients
	 */
	public int deleteClient(Long idClient) throws SQLException;
	
	/**
	 * methode qui fait le recherche d'un client a partir de son id 
	 */
	public Client findClientById(Long idClient) throws SQLException;
	
	/**
	 * 	 methode permit de recupere la list des clients enregistre dans la BDD
	 */ 
	public List<Client> findAllClient() throws SQLException;

}
