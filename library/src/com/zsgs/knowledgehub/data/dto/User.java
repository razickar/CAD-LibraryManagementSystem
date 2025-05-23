package com.zsgs.knowledgehub.data.dto;

class User {
    String UserId;
    String FirstName;
    String LastName;
    String Email;
    String MobileNumber;
    String Address;
    String DOB;
    List<BorrowRecord> BorrowedBooks;
    List<Feedback> Feedbacks;
}
