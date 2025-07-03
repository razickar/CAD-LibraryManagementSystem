package com.zsgs.knowledgehub.features.librarysetup;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;

class LibrarySetupModel {

	private final LibrarySetupView view;
	
	LibrarySetupModel(LibrarySetupView view) {
		this.view = view;
	}

	void init() {
		
		if(KnowledgeHubDb.getInstance().getLibrary() == null) {
			view.RegisterLibrarySetup();
		}
		else {
			
			view.onSuccessFullLibrarySetup();
		}
		
	}

	void saveLibrarySetup(LibrarySetup librarySetup) {
		
		KnowledgeHubDb.getInstance().setLibrary(librarySetup);
		view.onSuccessFullLibrarySetup();
		
	}
}
