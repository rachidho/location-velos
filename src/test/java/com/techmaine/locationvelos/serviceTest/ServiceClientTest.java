package com.techmaine.locationvelos.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.DAO.DaoClient;
import com.techmaine.locationvelos.DAO.interfaceDao.IDaoClient;
import com.techmaine.locationvelos.entity.Client;
import com.techmaine.locationvelos.service.ServiceClient;
import com.techmaine.locationvelos.service.interfaceService.IServiceClient;

public class ServiceClientTest {
	
	private IServiceClient iServiceClient;
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
		when(iDaoClient.updateClient(null)).thenReturn(1);
		assertEquals(" egal ", 1, iServiceClient.updateClient(null));
	}
	
	/**
	 * - etant donne un DaoClient Mocki
	 * - quand je vaux suprimme un client dans la base de donnee en connaissan son id
	 * - alors la valeur retourni et '1' 
	 * @throws SQLException 
	 */
	@Test
	public void sericeDeleteUnClientDansLaBaseDeDonneeConnaissanSonIdLaValeurRetourniEt1() throws SQLException{
		when(iDaoClient.deleteClient(idClient)).thenReturn(1);
		assertEquals(1, iServiceClient.deleteClient(idClient));
	}
	
	/**
	 * - etant donnee un DaoClient Mocki
	 * - quand je veux chercher un client dans la base de donnee en connaissan son id
	 * - alors la valeur retourni et 'objet client'
	 * @throws SQLException 
	 */
	@Test
	public void serviceChercherUnClientDansLaBaseDeDonneeConnaissanSonIdLaValeurRetourniEtUnObjetClient() throws SQLException{
		Client client = new Client();
		client.setIdClient((long) 1);
		client.setNomClient("nomClient");
		client.setPreClient("preClient");
		when(iDaoClient.findClientById(idClient)).thenReturn(client);
		assertEquals(client ,iServiceClient.findClientById(idClient));
	}
	
	/**
	 * - etant donne un DaoClient Mocki
	 * - quand je veux recupere la liste de tous les client enregistre dans la base de donnee
	 * - alors la valeur retourni et List<Client>
	 * @throws SQLException 
	 */
	@Test
	public void serviceRecuperLaListDeTousLesClientEnregistreDansLaBaseDeDonneeLaValeurRetourniUneCollectionDesclient() throws SQLException{
		List<Client> listClient = new ArrayList<Client>();
		Client client = new Client();
		client.setIdClient((long) 1);
		client.setNomClient("nomClient");
		client.setPreClient("preClient");
		listClient.add(client);
		when(iDaoClient.findAllClient()).thenReturn(listClient);
		assertEquals(listClient.size(), iServiceClient.findAllClient().size());
	}
}
