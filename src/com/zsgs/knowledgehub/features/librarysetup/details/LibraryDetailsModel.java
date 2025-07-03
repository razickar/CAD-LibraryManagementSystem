package com.zsgs.knowledgehub.features.librarysetup.details;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.LibrarySetup;

class LibraryDetailsModel {

	private final LibraryDetailsView view;
	
	public LibraryDetailsModel(LibraryDetailsView view) {
		this.view = view;
	}

	
	 void fetchLibraryDetails() {
		 LibrarySetup libraryDetails = KnowledgeHubDb.getInstance().getLibrary();
			view.displayLibraryDetails(libraryDetails);	
		
	}

}
