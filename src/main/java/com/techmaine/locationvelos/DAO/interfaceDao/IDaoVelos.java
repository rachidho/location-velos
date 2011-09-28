package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Velos;

public interface IDaoVelos {
	
	/**
	 * methode permet d'ajouter des velos
	 */
	int ajoutVelos(Velos newVelos) throws SQLException;

	/**
	 * methode permit de modifier des velos
	 */
	int updateVelos(Velos oldVelos) throws SQLException;

	/**
	 * methode permit de supprime des velo
	 */
	int deleteVelos(Long idDeleteVelos) throws SQLException;

	/**
	 * mehode permit de recupere une velos a partir de son id
	 */
	Velos findVelosById(Long idFindVelos) throws SQLException;

	/**
	 * methode permit de recupere la liste des velos enregistre dans la BDD
	 */
	List<Velos> findAllVelos() throws SQLException;

}
