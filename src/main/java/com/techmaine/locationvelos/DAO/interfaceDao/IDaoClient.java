package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Client;

public interface IDaoClient {
	
	/**
	 * methode qui enregistre les client
	 */
	int ajoutClient(Client newClient) throws SQLException;
	
	/**
	 * methode qui modifier les client
	 */
	int updateClient(Client oldClient) throws SQLException;
	
	/**
	 * methode qui supprime les clients
	 */
	int deleteClient(Long idDeleteClient) throws SQLException;
	
	/**
	 * methode qui fait le recherche d'un client a partir de son id 
	 */
	Client findClientById(Long idFindClient) throws SQLException;
	
	/**
	 * 	 methode permit de recupere la list des clients enregistre dans la BDD
	 */ 
	List<Client> findAllClient() throws SQLException;

}
