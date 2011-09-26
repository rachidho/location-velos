package com.techmaine.locationvelos.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDataSource;

public class ConnexionBDD {

	static JDBCDataSource dataSource;
	
	// methode contient le parametre de la base de donne
	private static DataSource getApplicationDataSource(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		if(dataSource == null){
			dataSource = new JDBCDataSource();
			dataSource.setUrl("jdbc:hsqldb:file:D:\\outils_de_travail\\springsource\\workspace-sts\\location-velos\\data\\data");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		}
		return dataSource;
	}
	// methode cree la connexion a la base
	public static Connection getConnectionTOBACKOFFICE() throws SQLException {
		DataSource ds = getApplicationDataSource();		
		return ds.getConnection();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static Connection getConnectionTOBACKOFFICE() {
//		Connection conn = null;
//		//Statement st;
//
//		try {
//
//			Class.forName("org.hsqldb.jdbcDriver").newInstance();
//			String url = "jdbc:hsqldb:data/BACKOFFICE";
//			conn = DriverManager.getConnection(url, "sa", "");
//			//st = conn.createStatement();
//
//		} catch (SQLException e) {
//
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return conn;
//
//	}



}
