package com.betacom.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.betacom.objects.dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.SQLManager;

public class DipendentiDAO {
	private SQLManager db = new SQLManager();
	public List<dipendenti> findAll() throws Exception{
		String query = SQLConfiguration.getInstance().getQuery("query.dipendenti");
		System.out.println(query);
		
		List<Map<String,Object>> lD = db.list(query);
		/*
		 * Integer id_dipendente, String nome, String cognome, LocalDate data_assunzione, String telefono,
			String mansione, Double stipendio, Integer id_ufficio, String code
		 */
		/*
		System.out.println("Numero di righe: "+res.size());
		
		for (Map<String, Object> it : res) {
			System.out.println(it.get("nome")+ " "+ it.get("cognome"));
		}*/
		return lD.stream()
				.map(row -> new dipendenti(
						 (Integer)row.get("id_dipendente"), 
						 (String)row.get("nome"), 
						 (String)row.get("cognome"), 
						 null, //LocalDate
						 (String)row.get("telefono"), 
						 (String)row.get("mansione"), 
						 ((BigDecimal)row.get("stipendio")).doubleValue(), 
						 (Integer)row.get("id_ufficio"), 
						 (String)row.get("code")
						 )
					).collect(Collectors.toList());
	}
}
