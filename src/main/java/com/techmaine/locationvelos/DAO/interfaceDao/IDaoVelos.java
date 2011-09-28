package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Velos;

public interface IDaoVelos {
	
	/**
	 * methode permet d'ajouter des velos
	 */
	public int ajoutVelos(Velos newVelos) throws SQLException;

	/**
	 * methode permit de modifier des velos
	 */
	public int updateVelos(Velos oldVelos) throws SQLException;

	/**
	 * methode permit de supprime des velo
	 */
	public int deleteVelos(Long idDeleteVelos) throws SQLException;

	/**
	 * mehode permit de recupere une velos a partir de son id
	 */
	public Velos findVelosById(Long idFindVelos) throws SQLException;

	/**
	 * methode permit de recupere la liste des velos enregistre dans la BDD
	 */
	public List<Velos> findAllVelos() throws SQLException;

}
