package com.techmaine.locationvelos.service.interfaceService;

import java.sql.SQLException;

import com.techmaine.locationvelos.entity.Client;

public interface IServiceClient {

	int ajouteClient(Client client) throws SQLException;

	int deleteClient(Long idClient) throws SQLException;

}
