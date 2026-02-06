package com.betacom.process;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.services.ServicesQuery;
import com.betacom.singleton.SQLConfiguration;

public class ProcessSQL implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessSQL");
		try {
			SQLConfiguration.getInstance().getConnection();
			System.out.println("Connessione stabilita con il DB");
			new ServicesQuery().executeQuery();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}

}
