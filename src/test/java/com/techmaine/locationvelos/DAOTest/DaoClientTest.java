package com.techmaine.locationvelos.DAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.DAO.DaoClient;
import com.techmaine.locationvelos.DAO.interfaceDao.IDaoClient;
import com.techmaine.locationvelos.entity.Client;
import com.techmaine.locationvelos.util.ConnexionBDD;

public class DaoClientTest {

	Connection conn = null;
	IDaoClient iDaoClient = null;
	Client client = null;
	
	@Before
	public void connexion() {
		try {
			conn = ConnexionBDD.getConnectionTOBACKOFFICE();
			iDaoClient = new DaoClient(conn);
			client = new Client();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void daoClientAjoutClient() throws Exception {
		client.setIdClient((long) 1);
		client.setNomClient("nomClient");
		client.setPreClient("preClient");
		assertEquals(" egale ", 1, iDaoClient.ajoutClient(client));
	}

	@Test
	public void daoClientUpdateClient() throws Exception {
		client.setIdClient((long) 1);
		client.setNomClient("nomModifier");
		client.setPreClient("preModifier");
		assertEquals(" egale ", 1, iDaoClient.updateClient(client));
	}

	@Test
	public void daoClientFindByIdClient() throws Exception {
		assertNotNull(iDaoClient.findClientById((long) 1));
	}

	@Test
	public void daoClientFindAllClient() throws Exception {
		assertNotNull(iDaoClient.findAllClient());
	}

	@Test
	public void daoClientDeleteClient() throws Exception {
		assertEquals(" egale ", 1, iDaoClient.deleteClient((long) 1));
	}

}
