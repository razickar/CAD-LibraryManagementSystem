package com.zsgs.knowledgehub.repository.dto;

import java.time.LocalDate;


public class BorrowRecords {
    
	private String recordId;
    private String userId;       // Reference to user
    private String BookId;       // Reference to book
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fineAmount;
    private String feedback;     // Book feedback
    private int rating;          // 1-5 stars
    private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String BookName) {
		this.BookId = BookName;
	}
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate string) {
		this.borrowDate = string;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
    
}