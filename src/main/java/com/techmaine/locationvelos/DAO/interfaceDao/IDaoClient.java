package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Client;

public interface IDaoClient {
	
	public int ajoutClient(Client client) throws SQLException;
	
	public int updateClient(Client client) throws SQLException;
	
	public int deleteClient(Long idClient) throws SQLException;
	
	public Client findClientById(Long idClient) throws SQLException;
	
	public List<Client> findAllClient() throws SQLException;

}
