# CAD-LibraryManagementSystem
Project :- Library Management System

Title :- Knowledge-Hub

Type :- B2B

Target audience :- [students, teachers, book lovers, researchers, casual readers, library members]

Budget :- currently time is budget.

Members :- 1.

Features :-

	-searching books by title, author, or genre
	-filtering by category 
	-borrowing books 
	-returning books 
	-digital book paakaa
	-login
	-user registration 
	-add to favorite
	-borrowing history
	-reviews and ratings 
	-notifications 
	-admin dashboard 
	-who enter (user or admin) access

Feasibility :-

	-registration
	-login
	-book search and filter
	-borrowing and return system
	-favorites
	-reviews and ratings
	-borrowing history
	-due date notifications
	-add ,remove ,etc by admin
	-role-based access
## DATA MODEL :

RegistrationInfo: Class
	●LibrarianId: Integer
	●FirstName: String
	●LastName: String
	●MobileNo: Long/String
	●EmailId: String
	●Password: String
	●ConfirmPassword: String
	●UserName: String
	●DOB: String
 
Login: Class
	●UserName: String
	●Password: String

Library: Class
	●ID: Integer
	●Name: String
	●Incharge: String
	●Capacity: Integer
	●StorageStructure: StorageStructure
	●Address: String
	●PhoneNo: Long/String
	●WifiPassword: String
	●EmailId: String
	●OpeningTime: Long
	●ClosingTime: Long
	●NoAvailableDays: Integer
StorageStructure: Class
	<Your Task>
Book: Class
	●Id: String
	●Name: String
	●Genre: String
	●Volume: Byte
	●PublishedYear: Integer
	●Author: String
	●NoOfCopy: Byte
	●AvailableCount: Byte
User: Class
	●UserId: String
	●FirstName: String
	●LastName: String
	●Email: String
	●MobileNumber: String
	●Address: String
	●DOB: String
	●BorrowedBooks: List<BorrowRecord>
	●Feedbacks: List<Feedback>
BorrowRecord: Class
	●RecordId: String
	●UserId: String
	●BookId: String
	●BorrowDate: Long
	●DueDate: Long
	●ReturnId: String
	●FineAmount: DoubleReturnDetails: Class
	●ReturnId: String
	●BorrowRecordId: String
	●ReturnDate: Long
	●Feedback: Feedback
	●FinePaid: Double
Feedback: Class
	●FeedbackId: String
	●UserId: String
	●BookId: String
	●Comments: String
	●Rating: Integer (1–5)
FinePayment: Class
	●PaymentId: String
	●RecordId: String
	●UserId: String
	●Amount: Double
	●PaymentDate: Long
	●PaymentMethod: String (e.g., "Card", "UPI", "Cash")
SearchFilter: Class
	●Name: String
	●Author: String
	●Genre: String
	●PublishedYearFrom: Integer
	●PublishedYearTo: Integer
	●AvailableOnly: Boolean
