package com.betacom.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.exceptions.AcademyException;
import com.betacom.singleton.SQLConfiguration;

public class SQLManager {
	public Connection getConnection() throws AcademyException{
		Connection con =  null;
		try {
			//load jdbc driver using reflection
			Class.forName(SQLConfiguration.getInstance().getProperty("driver"));
			//open connection with DB (url,usr,pwd)
			con = DriverManager.getConnection(
					SQLConfiguration.getInstance().getProperty("url"),
					SQLConfiguration.getInstance().getProperty("user"),
					SQLConfiguration.getInstance().getProperty("pwd")
					);
		}catch(Exception e){
			throw new AcademyException(e.getMessage());
		}
		return con;
	}
	
	// Table List
	
	public List<String> listOfTables(String dbName) throws AcademyException{
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = SQLConfiguration
									.getInstance()
									.getConnection()
									.getMetaData();
			ResultSet res = dbMD.getTables(dbName, null, null, null);
			//build del result
			while(res.next()) {
				lT.add(res.getString("TABLE_name"));
			}
		}catch(SQLException e) {
			throw new AcademyException(e.getMessage());
		}
		return lT;
	}
	
	// Query result parameter
	
	public List<Map<String,Object>> list(String query) throws AcademyException{
		try {
			//compilazione query e la prepara all'esecuzione
			PreparedStatement comand = SQLConfiguration
										.getInstance()
										.getConnection()
										.prepareStatement(query);
			System.out.println("After PreparedStatement");
			ResultSet res = comand.executeQuery();
			
			return resultSetToList(res);
		}catch(Exception e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	private List<Map<String,Object>> resultSetToList(ResultSet rs)throws SQLException{
		//retrieve resultset metadata
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount(); //num. colonne query
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		
		while(rs.next()) {
			Map<String,Object> row = new HashMap<String, Object>();
			for(int i=1; i<= columns; i++) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			rows.add(row);
		}
		return rows;
		
	}
}
