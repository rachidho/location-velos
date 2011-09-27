package com.techmaine.locationvelos.DAOTest;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.DAO.DaoVelos;
import com.techmaine.locationvelos.DAO.interfaceDao.IDaoVelos;
import com.techmaine.locationvelos.entity.Velos;
import com.techmaine.locationvelos.util.ConnexionBDD;

public class DaoVelosTest {

	Connection conn = null;
	IDaoVelos iDaoVelos = null;
	Velos velos = null;
	
	/**
	 * - la methode s"excute avant chaque methode de test
	 * - creation de la connexion a la base de donne
	 * - instantiation de la class DaoVelos
	 * - instantiation de la class Velos
	 */
	@Before
	public void connexion() {
		try {
			conn = ConnexionBDD.getConnectionTOBACKOFFICE();
			iDaoVelos = new DaoVelos(conn);
			velos = new Velos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void daoVelosAjoutVelos()
	{
		velos.setIdVelos((long) 1);
		velos.setNbrRout(2);
		velos.setNom("nom");
		velos.setIdClient((long) 1);
		assertEquals(" egal ",0,iDaoVelos.ajoutVelos(velos));
	}
	
	@Test
	public void daoVelosUpdateVelos()
	{
		velos.setIdVelos((long) 1);
		velos.setNbrRout(2);
		velos.setNom("nom");
		velos.setIdClient((long) 1);
		assertEquals(" egal ",0,iDaoVelos.ajoutVelos(velos));
	}
	
	@Test
	public void daoVelosDeleteVelos()
	{
		assertEquals(" egal ",0,iDaoVelos.deleteVelos((long) 1));
	}
	
	@Test
	public void daoVelosFindByIdVelos()
	{
		assertNotNull(iDaoVelos.findVelosById((long) 1));
	}
	
	@Test
	public void daoVelosFindAllVelos()
	{
		assertNotNull(iDaoVelos.findAllVelos());
	}
}
