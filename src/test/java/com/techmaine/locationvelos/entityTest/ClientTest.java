package com.techmaine.locationvelos.entityTest;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.entity.Client;

public class ClientTest {
	private Client client;

	/**
	 * la methode s'execute automatiquement avant chaque l'execution de chaque
	 * methode de test
	 */
	@Before
	public void initalisationClient() throws Exception{
		client = new Client();
	}
	
	/**
	 * - initialisation de l'objet client
	 * - modification des proprietes d'objet
	 * - les propriete de l'objet sont defirent de null
	 */
	@Test
	public void modificationDesProprieteDeLObjetClient() throws Exception{
		client.setIdClient((long) 1);
		client.setNomClient("nomClient");
		client.setPreClient("preClient");
		assertNotNull(client.getIdClient());
		assertNotNull(client.getNomClient());
		assertNotNull(client.getPreClient());
	}

}
