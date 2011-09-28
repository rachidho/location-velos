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
	public void setUp() {
		try {
			conn = ConnexionBDD.getConnectionTOBACKOFFICE();
			iDaoClient = new DaoClient(conn);
			client = new Client();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * - etant donne un DaoClient Mocki
	 * - quand je veux insere dans la base de donne un client
	 * - alors la valeur retourni et '1'
	 * @throws Exception
	 */
	@Test
	public void daoClientAjoutClientDansLaBaseDeDonneeLaValeurRetourniEt1() throws Exception {
		client.setIdClient((long) 1);
		client.setNomClient("nomClient");
		client.setPreClient("preClient");
		assertEquals(1, iDaoClient.ajoutClient(client));
	}

	/**
	 * - etant donnee un objet DaoClient Mocki
	 * - quand je veux modifier un client dans la base de donnee a partir de DAO en connaissan son id
	 * - alors la valeur retourni et '1'
	 * @throws Exception
	 */
	@Test
	public void daoClientModifierUnClientDansLaBaseDeDonneeEnConnaissanSonIdLaValeurRetourniEt1() throws Exception {
		client.setIdClient((long) 1);
		client.setNomClient("nomModifiertest");
		client.setPreClient("preModifierTest");
		assertEquals(1, iDaoClient.updateClient(client));
	}
	
	/**
	 * - etant donne un objet DaoClient Mocki
	 * - quand je veux chercher un client dans la base de donnee en connaissan son id
	 * - alors la valeur retourni et objst Client
	 * @throws Exception
	 */
	@Test
	public void daoClientChercheClientDansLaBaseDeDonneeEnConnaissanSkk() throws Exception {
		assertNotNull(iDaoClient.findClientById((long) 1));
	}

	/**
	 * - etant donnee un objet DaoMocki Mocki
	 * - quand je veux recupere la liste de tous les Clients enregistre dans la base de donnee
	 * - alors le resulta et une list des Clients
	 * @throws Exception
	 */
	@Test
	public void daoClientFindAllClient() throws Exception {
		assertNotNull(iDaoClient.findAllClient());
	}

	/**
	 * - etant donnee un DaoMocki Mocki
	 * - quand je veux suprimme un Client dans la base de donnee a partir du DOA en connaissan son id
	 * - alors le resulta retourni et '1'
	 */
	@Test
	public void daoClientDeleteClient() throws Exception {
		assertEquals(1, iDaoClient.deleteClient((long) 1));
	}

}
