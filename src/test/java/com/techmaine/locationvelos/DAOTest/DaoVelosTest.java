package com.techmaine.locationvelos.DAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	/**
	 * - connexion a la base
	 * - initailisation de l'objet velos
	 * - modification de ces propriete
	 * - l'ajouter a la base de donnee retourn 1
	 * @throws SQLException 
	 */
	@Test
	public void daoVelosAjoutVelos() throws SQLException
	{
		velos.setIdVelos((long) 1);
		velos.setNbrRout(2);
		velos.setNom("nom");
		velos.setIdClient((long) 1);
		assertEquals(" egal ", 1,iDaoVelos.ajoutVelos(velos));
	}
	
	/**
	 * - connexion a la base
	 * - initiation de l'objet
	 * - modification des propriete, avec un idVelos qui existe deja dans la base
	 * - la modification de l'objet dans la base de donnee return 1
	 * @throws SQLException
	 */
	@Test
	public void daoVelosUpdateVelos() throws SQLException
	{
		velos.setIdVelos((long) 1);
		velos.setNbrRout(2);
		velos.setNom("nomTest");
		velos.setIdClient((long) 1);
		assertEquals(" egal ", 1,iDaoVelos.updateVelos(velos));
	}
	
	/**
	 * - connexion a la base
	 * - la recherche d'un velos dans la base de donnee, idVelos de l'objet doit existé dans la base
	 * - resulte un objet NotNull
	 * @throws SQLException
	 */
	@Test
	public void daoVelosFindByIdVelos() throws SQLException
	{
		assertNotNull(iDaoVelos.findVelosById((long) 1));
	}
	
	/**
	 * - connexion a la base de donnee
	 * - la recuperation de tous les velos enregistre dans la base de donnee
	 * - le resulta une collection NotNull
	 */
	@Test
	public void daoVelosFindAllVelos() throws SQLException
	{
		assertNotNull(iDaoVelos.findAllVelos());
	}
	
	/**
	 * - connexion a la base
	 * - supression d'un objet existe déja dans la base de donnee
	 * - la suppression vas retourn 1
	 * @throws SQLException
	 */
	@Test
	public void daoVelosDeleteVelos() throws SQLException
	{
		assertEquals(" egal ", 1,iDaoVelos.deleteVelos((long) 1));
	}
}
