package com.techmaine.locationvelos.DAO;

import java.sql.Connection;
import java.util.List;

import com.techmaine.locationvelos.DAO.interfaceDao.IDaoVelos;
import com.techmaine.locationvelos.entity.Velos;

public class DaoVelos implements IDaoVelos {

	Connection conn = null;

	public DaoVelos(Connection conn) {
		this.conn = conn;
	}

	public int ajoutVelos(Velos velos) {
		return 0;
	}

	public int updateVelos(Velos velos) {
		return 0;
	}

	public int deleteVelos(Long idVelos) {
		return 0;
	}

	public Velos findVelosById(Long idVelos) {
		return null;
	}

	public List<Velos> findAllVelos() {
		return null;
	}

}
