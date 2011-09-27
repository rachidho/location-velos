package com.techmaine.locationvelos.utilTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import com.techmaine.locationvelos.util.ConnexionBDD;


public class ConnexionBDDTest {
	private ConnexionBDD connexionBDD;
	
	@Before
	public void intialObjetConnexion(){
		connexionBDD = new ConnexionBDD();
	}
	
	@Test
	public void testname() throws Exception {
		 assertNotNull(ConnexionBDD.getConnectionTOBACKOFFICE());
	}
}
