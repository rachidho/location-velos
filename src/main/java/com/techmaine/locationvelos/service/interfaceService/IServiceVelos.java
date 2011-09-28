package com.techmaine.locationvelos.service.interfaceService;

import java.sql.SQLException;

import com.techmaine.locationvelos.entity.Velos;

public interface IServiceVelos {

	int ajoutVelos(Velos velos) throws SQLException ;

	int updateVelos(Velos velos) throws SQLException ;

	int deleteVelos(Long idVelos) throws SQLException ;

}
