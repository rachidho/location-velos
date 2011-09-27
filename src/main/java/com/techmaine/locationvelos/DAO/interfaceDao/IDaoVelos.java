package com.techmaine.locationvelos.DAO.interfaceDao;

import java.util.List;

import com.techmaine.locationvelos.entity.Velos;

public interface IDaoVelos {
	
	public int ajoutVelos(Velos velos);

	public int updateVelos(Velos velos);

	public int deleteVelos(Long idVelos);

	public Velos findVelosById(Long idVelos);

	public List<Velos> findAllVelos();

}
