package com.techmaine.locationvelos.service;

import java.sql.Connection;
import java.sql.SQLException;

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
	public int deleteClient(Long idClient) throws SQLException {
		return iDaoClient.deleteClient(idClient);
	}
	
}
