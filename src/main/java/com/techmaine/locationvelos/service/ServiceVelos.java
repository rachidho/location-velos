package com.techmaine.locationvelos.service;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.DAO.interfaceDao.IDaoVelos;
import com.techmaine.locationvelos.entity.Velos;
import com.techmaine.locationvelos.service.interfaceService.IServiceVelos;

public class ServiceVelos implements IServiceVelos {

	private IDaoVelos iDaoVelos;
	
	/**
	 * constructeur initialise
	 * @param iDaoVelos
	 */
	public ServiceVelos(IDaoVelos iDaoVelos) {
		this.iDaoVelos = iDaoVelos;
	}

	/**
	 * methode permit d'enregistre les Velos
	 */
	public int ajoutVelos(Velos velos) throws SQLException {
		return iDaoVelos.ajoutVelos(velos);
	}

	/**
	 * methode permit de modifier les Velos
	 */
	public int updateVelos(Velos velos) throws SQLException {
		return iDaoVelos.updateVelos(velos);
	}

	/**
	 * methode permit de supprime les velos
	 */
	public int deleteVelos(Long idVelos) throws SQLException {
		return iDaoVelos.deleteVelos(idVelos);
	}

	public Velos findVelosById(Long idVelos) throws SQLException {
		return iDaoVelos.findVelosById(idVelos);
	}

	public List<Velos> findAllVelos() throws SQLException {
		return iDaoVelos.findAllVelos();
	}

}
