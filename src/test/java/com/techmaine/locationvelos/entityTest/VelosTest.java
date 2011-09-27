package com.techmaine.locationvelos.entityTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.entity.Velos;

public class VelosTest {
	private Velos velos;

	/**
	 * la methode s'execute automatiquement avant chaque l'execution de chaque
	 * methode de test
	 */
	@Before
	public void initalisationClient() throws Exception{
		velos = new Velos();
	}
	
	/**
	 * - initialisation de l'objet velos
	 * - modification des proprietes d'objet
	 * - les propriete de l'objet sont defirent de null
	 */
	@Test
	public void modificationDesProprieteDeLObjetClient() throws Exception{
		velos.setIdVelos((long) 1);
		velos.setNom("nom");
		velos.setNbrRout(2);
		velos.setIdClient((long) 1);
		assertNotNull(velos.getIdVelos());
		assertNotNull(velos.getNom());
		assertNotNull(velos.getNbrRout());
		assertNotNull(velos.getIdClient());
	}
}
