package com.zsgs.knowledgehub.repository.dto;

import java.util.List;

public class User {
    public String UserId;
    public String FirstName;
    public String LastName;
    public String Email;
    public String MobileNumber;
    public String Address;
    public String DOB;
   // public List<BorrowRecord> BorrowedBooks;
    public List<Feedback> Feedbacks;
}
