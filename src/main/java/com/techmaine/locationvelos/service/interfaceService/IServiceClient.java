package com.techmaine.locationvelos.service.interfaceService;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Client;

public interface IServiceClient {

	int ajouteClient(Client client) throws SQLException;

	int deleteClient(Long idClient) throws SQLException;

	int updateClient(Client client) throws SQLException;

	Client findClientById(Long idClient) throws SQLException;

	List<Client> findAllClient() throws SQLException;

}
