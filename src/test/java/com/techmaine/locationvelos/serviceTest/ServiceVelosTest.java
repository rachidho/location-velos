package com.techmaine.locationvelos.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atLeast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.techmaine.locationvelos.DAO.DaoVelos;
import com.techmaine.locationvelos.DAO.interfaceDao.IDaoVelos;
import com.techmaine.locationvelos.entity.Velos;
import com.techmaine.locationvelos.service.ServiceVelos;
import com.techmaine.locationvelos.service.interfaceService.IServiceVelos;


public class ServiceVelosTest {

	private Long idVelos;
	private Velos velos;
	private IDaoVelos iDaoVelos;
	private IServiceVelos iServiceVelos;
	
	/**
	 * creation de mock avant chaque execution de la methode @Test
	 */
	@Before
	public void setUP(){
		iDaoVelos = mock(DaoVelos.class);
		iServiceVelos = new ServiceVelos(iDaoVelos);
		velos = new Velos();
	}
	
	/**
	 * - etand donne un objet DaoVelos Mocki
	 * - quand je veux ajoute une velos a la base de donne a partire de service
	 * - alors le resulta retourni et '1'
	 */
	@Test
	public void serviceAjouterVelosDansLaBaseDeDonneeApartirDeServiceLaValeurRetourniEt1() throws Exception {
		when(iDaoVelos.ajoutVelos(velos)).thenReturn(1);
		doThrow(new SQLException()).when(iDaoVelos).ajoutVelos(velos);
		try{
			assertEquals(1, iServiceVelos.ajoutVelos(velos));
			fail();
		}catch(SQLException e){
			assertTrue(" leve exception ", true);
		}
		verify(iDaoVelos, times(1)).ajoutVelos(velos);
	}
	
	/**
	 * - etant donne un objet DaoVelos Mocki
	 * - quand je veux modifier une velos dans la base de donnee en connaissan son id
	 * - alors la valeur retourni et '1'
	 */
	@Test
	public void serviceModifierVelosDansLaBaseDeDonneeApartirDeSonIdLaValeurRetourniEt1() throws Exception {
		when(iDaoVelos.updateVelos(velos)).thenReturn(1);
		assertEquals(1, iServiceVelos.updateVelos(velos));
		verify(iDaoVelos, times(1)).updateVelos(velos);
	}
	
	/**
	 * - etant donnee un objet Mocki
	 * - quand je veux suprimme une Velos de la base de donnee a partir du service en connaissan son id
	 * - alors le resulta retourni et '1'
	 */
	@Test
	public void serviceSupprimeUneVelosDeLaBaseDeDonneeEnConnaissanSonIdLaValeurRetourniEt1() throws Exception {
		when(iDaoVelos.deleteVelos(idVelos)).thenReturn(1);
		assertEquals(1, iServiceVelos.deleteVelos(idVelos));
		verify(iDaoVelos, times(1)).deleteVelos(idVelos);
	}
	
	/**
	 * - etant donne un objet DaoVelos Mocki
	 * - quand je veux cherche une velos dans la bese de donnee en connaissan son id
	 * - alors le resulta et un objet Velos
	 * @throws SQLException 
	 */
	@Test
	public void serviceChercheUneVelosDansLaBaseDeDonneeConnaissanSonIdLaValeurRetourniEt1() throws Exception{
		Velos velos1 = new Velos();
		velos1.setIdVelos((long) 1);
		velos1.setNom("nom");
		velos1.setNbrRout(2);
		velos1.setIdClient((long) 1);
		
		when(iDaoVelos.findVelosById(idVelos)).thenReturn(velos1);
		assertNotNull(iServiceVelos.findVelosById(idVelos));
		assertEquals(velos1, iServiceVelos.findVelosById(idVelos));
		
		// plus 1
		verify(iDaoVelos, atLeast(1)).findVelosById(idVelos);
		// moins 
		verify(iDaoVelos, atMost(2)).findVelosById(idVelos);
		
	}
	
	/**
	 * - etant donnee un objet DaoVelos Mocki
	 * - quand je veux recupere une liste de tous les Velos enregistre dans la base de donnee
	 * - alors le resulte et un List des velos List<Velos> 
	 * @throws SQLException 
	 */
	@Test
	public void serviceRecupereLaListTousLesVelosEnregistreDansLaBaseDeDonneeLeResultaEtUneListDeVelos() throws Exception{
		List<Velos> listVelos = new ArrayList<Velos>();
		Velos velos1 = new Velos();
		velos1.setIdVelos((long) 1);
		velos1.setNom("nom");
		velos1.setNbrRout(2);
		listVelos.add(velos1);
		
		when(iDaoVelos.findAllVelos()).thenReturn(listVelos);
		assertNotNull(iServiceVelos.findAllVelos());
		verify(iDaoVelos, times(1)).findAllVelos();
	}
}
