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

	public DaoClient(Connection conn) {
		this.conn = conn;
	}

	public int ajoutClient(Client client) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(createClient);
		pstmt.setLong(1, client.getIdClient());
		pstmt.setString(2, client.getNomClient());
		pstmt.setString(3, client.getPreClient());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	public int updateClient(Client client) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(updateClient);
		pstmt.setString(1, client.getNomClient());
		pstmt.setString(2, client.getPreClient());
		pstmt.setLong(3, client.getIdClient());
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	public int deleteClient(Long idClient) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(deleteClient);
		pstmt.setLong(1, idClient);
		int i = pstmt.executeUpdate();
		pstmt.close();
		return i;
	}

	public Client findClientById(Long idClient) throws SQLException {
		Client findClient = null;
		PreparedStatement pstmt = conn.prepareStatement(findClientById);
		pstmt.setLong(1, idClient);
		ResultSet rs = pstmt.executeQuery();
		findClient = getClientByIdResultSet(rs);
		pstmt.close();
		return findClient;
	}

	public List<Client> findAllClient() throws SQLException {
		List<Client> clientList = new ArrayList<Client>();
		PreparedStatement pstmt = conn.prepareStatement(findAllClient);
		ResultSet rs = pstmt.executeQuery();
		clientList = resultSetToListClient(rs);
		pstmt.close();
		return clientList;
	}

	// methode permet de passe les donne de resultSet vers objet Client
	private Client getClientByIdResultSet(ResultSet rs) throws SQLException {
		Client findClient = new Client();
		while (rs.next()) {
			findClient.setIdClient(rs.getLong(1));
			findClient.setNomClient(rs.getString(2));
			findClient.setPreClient(rs.getString(3));
		}
		return findClient;
	}
	// methode permet de passe les donne de resultSet vers list<Client>
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
