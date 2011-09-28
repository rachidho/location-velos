package com.techmaine.locationvelos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techmaine.locationvelos.DAO.interfaceDao.IDaoClient;
import com.techmaine.locationvelos.entity.Client;

public class DaoClient implements IDaoClient {

	Connection conn = null;
	private String createClient = "insert into client (idClient, nomClient, preClient) values (? ,? ,?)";
	private String updateClient = "update client set nomClient = ?, preClient = ? where idClient = ?";
	private String deleteClient = "delete from client where idClient = ?";
	private String findAllClient = "select * from client";
	private String findClientById = findAllClient + " where idClient = ?";

	/**
	 * construction initialise
	 * @param conn
	 */
	public DaoClient(Connection conn) {
		this.conn = conn;
	}

	/**
	 * methode qui enregistre les client
	 */
	public int ajoutClient(Client newClient) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(createClient);
		pstmt.setLong(1, newClient.getIdClient());
		pstmt.setString(2, newClient.getNomClient());
		pstmt.setString(3, newClient.getPreClient());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	/**
	 * methode qui modifier les client
	 */
	public int updateClient(Client oldClient) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(updateClient);
		pstmt.setString(1, oldClient.getNomClient());
		pstmt.setString(2, oldClient.getPreClient());
		pstmt.setLong(3, oldClient.getIdClient());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	/**
	 * methode qui supprime les clients
	 */
	public int deleteClient(Long idDeleteClient) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteClient);
		pstmt.setLong(1, idDeleteClient);
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	/**
	 * methode qui fait le recherche d'un client a partir de son id 
	 */
	public Client findClientById(Long idFindClient) throws SQLException {
		Client findClient = null;
		PreparedStatement pstmt = conn.prepareStatement(findClientById);
		pstmt.setLong(1, idFindClient);
		ResultSet rs = pstmt.executeQuery();
		findClient = getClientByIdResultSet(rs);
		pstmt.close();
		return findClient;
	}

	/**
	 * 	 methode permit de recupere la list des clients enregistre dans la BDD
	 */ 
	public List<Client> findAllClient() throws SQLException {
		List<Client> clientList = new ArrayList<Client>();
		PreparedStatement pstmt = conn.prepareStatement(findAllClient);
		ResultSet rs = pstmt.executeQuery();
		clientList = resultSetToListClient(rs);
		pstmt.close();
		return clientList;
	}

	/**
	 *  methode permet de passe les donne de resultSet vers objet Client
	 * @param rs
	 * @return un objet client
	 * @throws SQLException
	 */
	private Client getClientByIdResultSet(ResultSet rs) throws SQLException {
		Client findClient = new Client();
		while (rs.next()) {
			findClient.setIdClient(rs.getLong(1));
			findClient.setNomClient(rs.getString(2));
			findClient.setPreClient(rs.getString(3));
		}
		return findClient;
	}
	
	/**
	 *  methode permet de passe les donne de resultSet vers list<Client>
	 * @param rs
	 * @return liste des client
	 * @throws SQLException
	 */
	private List<Client> resultSetToListClient(ResultSet rs)
			throws SQLException {
		List<Client> clientList = new ArrayList<Client>();
		while (rs.next()) {
			Client client = new Client();
			client.setIdClient(rs.getLong(1));
			client.setNomClient(rs.getString(2));
			client.setPreClient(rs.getString(3));
			clientList.add(client);
		}
		return clientList;
	}

}
