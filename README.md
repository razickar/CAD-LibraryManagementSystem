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
Registration class:

	Username: String
	Password: String
	Email: String
	FullName: String
	Address: String
	PhoneNumber: String

Login class:

	Username: String
	Password: String

BookSearch class:

	Keyword: String
	Author: String
	Category: String
	PublicationYear: Integer
	IsAvailable: Boolean

Book class:

	BookId: Integer
	Title: String
	Author: String
	ISBN: String
	Category: String
	PublicationYear: Integer
	AvailableCopies: Integer

BorrowRecord class:

	BorrowId: Integer
	UserId: Integer
	BookId: Integer
	BorrowDate: Date
	DueDate: Date
	ReturnDate: Date
	IsReturned: Boolean

Favorite class:

	FavoriteId: Integer
	UserId: Integer
	BookId: Integer
	AddedDate: Date

Review class:

	ReviewId: Integer
	UserId: Integer
	BookId: Integer
	Rating: Integer
	Comment: String
	ReviewDate: Date

BorrowHistory class:

	UserId: Integer
	BookList: List<BorrowRecord>
	TotalBorrowed: Integer

Notification class:

	NotificationId: Integer
	UserId: Integer
	Message: String
	DueDate: Date
	IsRead: Boolean

AdminAction class:

	ActionId: Integer
	AdminId: Integer
	ActionType: String
	TargetId: Integer
	ActionDate: Date

User class:

	UserId: Integer
	Username: String
	Password: String
	Email: String
	Role: String
	IsActive: Boolean

