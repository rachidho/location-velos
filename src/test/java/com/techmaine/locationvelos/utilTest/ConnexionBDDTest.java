package com.techmaine.locationvelos.utilTest;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.util.ConnexionBDD;


public class ConnexionBDDTest {
	
	private ConnexionBDD connexionBDD;
	private Connection connexion;
	
	@Before
	public void intialObjetConnexion() throws SQLException{
		connexionBDD = new ConnexionBDD();
		connexion = ConnexionBDD.getConnectionTOBACKOFFICE();
	}
	
	/**
	 * - etant donne un objet instance
	 * - quand je veux verifier
	 * - alor le resulta et notNull
	 * @throws Exception
	 */
	@Test
	public void initaileObjet(){
		assertNotNull(connexionBDD);
		assertNotNull(connexion);
		assertNotNull(ConnexionBDD.getApplicationDataSource());
	}
	
}
