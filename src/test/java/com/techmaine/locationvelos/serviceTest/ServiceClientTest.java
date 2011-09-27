package com.techmaine.locationvelos.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.DAO.DaoClient;
import com.techmaine.locationvelos.DAO.interfaceDao.IDaoClient;
import com.techmaine.locationvelos.entity.Client;
import com.techmaine.locationvelos.service.ServiceClient;
import com.techmaine.locationvelos.service.interfaceService.IServiceClient;

public class ServiceClientTest {
	
	private IServiceClient iServiceClient;
	private Long idClientDelete;
	private Long idClient;
	
	//@Mock
	private IDaoClient iDaoClient;

	@Before
	public void setUp() throws SQLException {
		iDaoClient = mock(DaoClient.class);
		iServiceClient = new ServiceClient(iDaoClient);
	}
	
	/**
	 * - etant donnee un DaoClient Mocki
	 * - quant je veux insere dans la base de donnee un client
	 * - alors la valeur retourni si '1'
	 * @throws SQLException 
	 */
	@Test
	public void serviceAjouteUnClientDansLaBaseDDRetournLaValeur1() throws SQLException{
		when(iDaoClient.ajoutClient(null)).thenReturn(1);
		assertEquals(" egal ", 1, iServiceClient.ajouteClient(null));
	}
	
	/**
	 * - etant donne un DaoClient Mocki
	 * - quand je vaux modifier un client dans la base de donnee en connaissan sont id
	 * - alors la valeur retourn et '1'
	 * @throws SQLException 
	 */
	@Test
	public void serviceUpdateUnClientDansLaBaseDeDonneeConnaissanSonIdLaValeurRetourniEt1() throws SQLException{
		when(iDaoClient.deleteClient(idClient)).thenReturn(1);
		assertEquals(" egal ", 1, iServiceClient.deleteClient(idClient));
	}
	
	
	
	
	
	
	/**
	 * when(iDaoClient.updateClient(new Client())).thenReturn(1);
		when(iDaoClient.deleteClient(idClientDelete)).thenReturn(1);
		when(iDaoClient.findClientById(idClient)).thenReturn(new Client());
		when(iDaoClient.findAllClient()).thenReturn(new ArrayList<Client>());
	 */
	
}
