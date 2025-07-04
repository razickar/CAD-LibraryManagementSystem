package com.zsgs.knowledgehub.repository.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String UserId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String MobileNumber;
    private String Address;
    private String DOB;
    private List<BorrowRecords> BorrowedBooks ;
    
    	public User() {
    		BorrowedBooks = new ArrayList<>();
    	}
    public List<BorrowRecords> getBorrowedBooks() {
		return BorrowedBooks;
	}
	public void setBorrowedBooks(BorrowRecords borrowedBooks) {
		this.BorrowedBooks.add(borrowedBooks);
	}
	private List<Feedback> Feedbacks;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}
}
