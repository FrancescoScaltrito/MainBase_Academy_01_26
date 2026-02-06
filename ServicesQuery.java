package com.betacom.services;

import java.util.List;
import java.util.Map;

import com.betacom.exceptions.AcademyException;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.SQLManager;

public class ServicesQuery {
	private SQLManager db = new SQLManager();
	
	public void executeQuery() throws Exception{
		listTable();
		getDipendenti();
	}
	
	private void listTable() throws AcademyException{
		List<String> lT = db.listOfTables("db_academy_01_2026");
		lT.forEach(t -> System.out.println(t));
	}
	
	private void getDipendenti() throws AcademyException{
		String query = SQLConfiguration.getInstance().getQuery("query.dipendenti");
		System.out.println(query);
		
		List<Map<String,Object>> res = db.list(query);
		System.out.println("Numero di righe: "+res.size());
		
		for (Map<String, Object> it : res) {
			System.out.println(it.get("nome")+ " "+ it.get("cognome"));
		}
	}
}
