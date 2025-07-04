package com.zsgs.knowledgehub.features.borrowbooks;

import java.time.LocalDate;
import java.util.Optional;

import com.zsgs.knowledgehub.repository.db.KnowledgeHubDb;
import com.zsgs.knowledgehub.repository.dto.Book;
import com.zsgs.knowledgehub.repository.dto.BorrowRecords;
import com.zsgs.knowledgehub.repository.dto.User;

class BorrowBooksModel {

	private final BorrowBooksView view;
	
	public BorrowBooksModel(BorrowBooksView view) {
		this.view = view;
	}

	 void saveBorrowRecord(BorrowRecords borrowInfo) {
	
		 if(isValidInfo(borrowInfo)) {
			 borrowInfo.setBorrowDate(LocalDate.now());
			 borrowInfo.setDueDate(LocalDate.now().plusDays(10));
			 System.out.println("BorrowInfo User ID: " + borrowInfo.getUserId());
			 System.out.println("BorrowInfo Book ID: " + borrowInfo.getBookId());

			 Optional<User> isAvailableUser = KnowledgeHubDb.getInstance().isUserAvailable(borrowInfo.getUserId());
			 Optional<Book> isAvailableBook = KnowledgeHubDb.getInstance().isBookAvailable(borrowInfo.getBookId());
			 
			if(isAvailableBook.isPresent()) {
				Book book = isAvailableBook.get();
				if( isAvailableUser.isPresent() ) {
					 User user = isAvailableUser.get();
					byte availableCount =  book.getAvailableCount();
					book.setAvailableCount(availableCount--);
					 user.setBorrowedBooks(borrowInfo);
					 KnowledgeHubDb.getInstance().setBorrowRecords(borrowInfo);
				 }
				 else {
					 view.showMessage("User not found!!");
					 return;
				 }
			}
			else {
				view.showMessage("Book is noT Available");
				return;
			}
			
		 }
		 else {
			 view.showMessage("Invalid information ");
			 return;
		 }
		
	}

	private boolean isValidInfo(BorrowRecords borrowInfo) {
		 if (borrowInfo.getUserId() == null || borrowInfo.getUserId().trim().isEmpty()) {
		        view.showMessage("Invalid User ID.");
		        return false;
		    }

		    if (borrowInfo.getBookId() == null || borrowInfo.getBookId().trim().isEmpty()) {
		        view.showMessage("Invalid Book ID.");
		        return false;
		    }

		    if (borrowInfo.getBookName() == null || borrowInfo.getBookName().trim().isEmpty()) {
		        view.showMessage("Invalid Book Title.");
		        return false;
		    }		    
		    return true;  
	}

}
