package com.techmaine.locationvelos.DAO.interfaceDao;

import java.sql.SQLException;
import java.util.List;

import com.techmaine.locationvelos.entity.Velos;

public interface IDaoVelos {
	
	public int ajoutVelos(Velos velos) throws SQLException;

	public int updateVelos(Velos velos) throws SQLException;

	public int deleteVelos(Long idVelos) throws SQLException;

	public Velos findVelosById(Long idVelos) throws SQLException;

	public List<Velos> findAllVelos() throws SQLException;

}
