package com.techmaine.locationvelos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techmaine.locationvelos.DAO.interfaceDao.IDaoVelos;
import com.techmaine.locationvelos.entity.Velos;

public class DaoVelos implements IDaoVelos {

	Connection conn = null;
	private String ajouteVelos = "insert into velos (idVelos, nom, nbrRout, idClient) values (?, ?, ?, ?)";
	private String updateVelos = "update velos set nom = ?, nbrRout = ? where idVelos = ?";
	private String deleteVelos = "delete from velos where idVelos = ?";
	private String findVelosById = "select * from velos where idVelos = ?";
	private String findAllVelos = "select * from velos";
	
	public DaoVelos(Connection conn) {
		this.conn = conn;
	}

	/**
	 * methode permet d'ajouter des velos
	 */
	public int ajoutVelos(Velos velos) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(ajouteVelos);
		pstmt.setLong(1, velos.getIdVelos());
		pstmt.setString(2, velos.getNom());
		pstmt.setInt(3, velos.getNbrRout());
		pstmt.setLong(4, velos.getIdClient());
		int intReturnByPstmt = pstmt.executeUpdate();
		return intReturnByPstmt;
	}

	/**
	 * methode permit de modifier des velos
	 */
	public int updateVelos(Velos velos) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(updateVelos);
		pstmt.setString(1, velos.getNom());
		pstmt.setInt(2, velos.getNbrRout());
		pstmt.setLong(3, velos.getIdVelos());
		int intReturnByPstmt = pstmt.executeUpdate();
		return intReturnByPstmt;
	}

	/**
	 * methode permit de supprime des velo
	 */
	public int deleteVelos(Long idVelos) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteVelos);
		pstmt.setLong(1, idVelos);
		int intReturnByPstmt = pstmt.executeUpdate();
		return intReturnByPstmt;
	}

	/**
	 * mehode permit de recupere une velos a partir de son id
	 */
	public Velos findVelosById(Long idVelos) throws SQLException {
		Velos velos = new Velos();
		PreparedStatement pstmt = conn.prepareStatement(findVelosById);
		pstmt.setLong(1, idVelos);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			velos.setIdVelos(rs.getLong(1));
			velos.setNom(rs.getString(2));
			velos.setNbrRout(rs.getInt(1));
			velos.setIdClient(rs.getLong(1));
		}
		return velos;
	}

	/**
	 * methode permit de recupere la liste des velos enregistre dans la BDD
	 */
	public List<Velos> findAllVelos() throws SQLException {
		List<Velos> velosList = new ArrayList<Velos>();
		PreparedStatement pstmt = conn.prepareStatement(findAllVelos);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Velos velos = new Velos();
			velos.setIdVelos(rs.getLong(1));
			velos.setNom(rs.getString(2));
			velos.setNbrRout(rs.getInt(1));
			velos.setIdClient(rs.getLong(1));
			velosList.add(velos);
		}
		return velosList;
	}

}
