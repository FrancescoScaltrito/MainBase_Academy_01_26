package com.betacom.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.betacom.exceptions.AcademyException;
import com.betacom.utils.SQLManager;

public class SQLConfiguration {

	private static SQLConfiguration instance;
	private static Properties prop = new Properties();
	private static Properties queries = new Properties();
	private Connection con = null;
	
	private SQLConfiguration() {
		super();
	}

	public static SQLConfiguration getInstance() throws AcademyException {
		if(instance==null) {
			instance = new SQLConfiguration();
			loadConfiguration();
		}
		return instance;
	}
	
	private static void loadConfiguration() throws AcademyException{
		try {
			InputStream input = new FileInputStream("sql.properties");
			prop.load(input);
			InputStream sql = new FileInputStream("query.properties");
			queries.load(sql);
		}  catch(IOException e) {
			throw new AcademyException(e.getMessage());
		}
	}
	
	public String getProperty(String p) {
		return prop.getProperty(p);
	}
	
	public String getQuery(String p) {
		return queries.getProperty(p);
	}
	
	public Connection getConnection() throws AcademyException{
		if(con == null) {
			con = new SQLManager().getConnection();
		}
		return con;
	}
	
}
