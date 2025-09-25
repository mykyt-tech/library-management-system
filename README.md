# Library Management System (Console)

A simple console-based Java application to manage books and library members.  
This project practices **Object-Oriented Programming (OOP)**, **Collections**, **Streams**, and **exception handling**.

---

## Features

- Add a new book (title, author, ISBN, available copies)
- Remove a book by ISBN
- Search books by title, author, or ISBN
- Borrow a book (decrease available copies)
- Return a book (increase available copies)
- Manage members and their borrowed books
- Filter and sort books using Java Streams

---

## Installation

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/mykyt-tech/library-management-system.git
cd library-management-system
```
Compile the Java files:
```bash
javac *.java
```
Run the application:
```bash
java LibraryApp
```

## Usage
### Menu Options
1. Add Book
    - Enter title, author, ISBN, and available copies.
2. Remove Book
    - Enter ISBN to remove a book from the library.
3. Search Book
    - Search by title, author, or ISBN.
4. Borrow Book
    - Enter ISBN and member ID.
    - Decreases available copies by 1 if available.
5. Return Book
    - Enter ISBN and member ID.
    - Increases available copies by 1.
6. List All Books
    - Displays all books with details: title, author, ISBN, and available copies.
7. Exit
    - Closes the program.

## Validation Rules
- ISBN must be unique for each book.
- Borrowing not allowed if no copies are available.
- Member IDs must be unique.
- Input must match expected types (numbers for copies, strings for text fields).

## Skills Gained
- Object-Oriented Programming (classes, objects, methods)
- Collections (ArrayList, HashMap) and Generics
- Java Streams for filtering and sorting data
- Exception handling and input validation
- Managing dynamic in-memory data

## Stretch Goals
- [ ] Track due dates and late fees for borrowed books
- [ ] Export book/member reports to CSV
- [ ] Save and load data between program runs