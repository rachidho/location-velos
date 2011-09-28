package com.techmaine.locationvelos.service;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.DAO.interfaceDao.IDaoClient;
import com.techmaine.locationvelos.entity.Client;
import com.techmaine.locationvelos.service.interfaceService.IServiceClient;

public class ServiceClient implements IServiceClient {
	
	private IDaoClient iDaoClient;
	
	public ServiceClient(IDaoClient iDaoClient){
		this.iDaoClient = iDaoClient;
	}

	/**
	 * methode permit d'ajoute un client
	 */
	public int ajouteClient(Client client) throws SQLException{
		return iDaoClient.ajoutClient(client);
	}

	/**
	 * methode permit de modifier un client
	 */
	public int updateClient(Client client) throws SQLException {
		return iDaoClient.updateClient(client);
	}
	
	/**
	 * methode permit de suprimme un client
	 */
	public int deleteClient(Long idClient) throws SQLException {
		return iDaoClient.deleteClient(idClient);
	}

	/**
	 * methode permit de recupere un client a partir de son id
	 */
	public Client findClientById(Long idClient) throws SQLException {
		return iDaoClient.findClientById(idClient);
	}

	/**
	 * methode permit de recupere la list des client enregistre dans la bese de donnee
	 * @throws SQLException 
	 */
	public List<Client> findAllClient() throws SQLException {
		return iDaoClient.findAllClient();
	}

	
}
