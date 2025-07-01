package com.zsgs.knowledgehub.repository.db;

import com.zsgs.knowledgehub.repository.dto.RegistrationInfo;

public class KnowledgeHubDb {
	
	private static KnowledgeHubDb sKnowledgwHubDb;
	private RegistrationInfo Registrationinfo;
	
	
	public RegistrationInfo getRegistrationInfo() {
		return Registrationinfo;
	}

	public void setRegistrationInfo(RegistrationInfo info) {
		this.Registrationinfo = info;
	}

	private KnowledgeHubDb() {
		
	}
	
	public static KnowledgeHubDb getInstance() {
		if(sKnowledgwHubDb == null) {
			sKnowledgwHubDb = new KnowledgeHubDb();
		}
		
		return sKnowledgwHubDb;
	}

	public boolean isValidCrediential(String userName, String password) {
		
		return sKnowledgwHubDb.getRegistrationInfo().getUserName().equals(userName) &&  sKnowledgwHubDb.getRegistrationInfo().getPassword().equals(password);
	}
	
	
	
}
