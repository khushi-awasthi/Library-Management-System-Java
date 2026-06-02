# 📚 Library Management System (Java CLI)

## Overview

A console-based Library Management System developed in Java using Object-Oriented Programming (OOP) principles. The application helps manage books, students, book issuing/returning, issue history tracking, due dates, fine calculation, and report generation.

This project demonstrates the use of Java Collections Framework, File Handling, Exception Handling, and Streams API.

---

## 🚀 Features

### 📖 Book Management

* Add Book
* View Books
* Search Book
* Remove Book

### 👨‍🎓 Student Management

* Add Student
* View Students
* Search Student

### 🔄 Library Operations

* Issue Book
* Return Book
* Issue History Tracking

### ⏰ Advanced Features

* Due Date Calculation
* Fine Calculation for Late Returns
* Issue History Persistence
* Reports Dashboard

### 💾 Data Persistence

* Books stored in `books.txt`
* Students stored in `students.txt`
* Issue records stored in `issues.txt`

---

## 🛠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework

  * HashMap
  * ArrayList
* File Handling

  * BufferedReader
  * BufferedWriter
* Exception Handling
* Streams API
* Git & GitHub

---

## 📂 Project Structure

```text
src/
├── app/
│   └── Main.java
│
├── model/
│   ├── Book.java
│   ├── Student.java
│   └── IssueRecord.java
│
├── service/
│   ├── LibraryService.java
│   └── LibraryServiceImpl.java
│
├── exception/
│   ├── BookNotFoundException.java
│   └── BookAlreadyIssuedException.java
│
├── util/
│   └── FileManager.java
│
└── module-info.java
```

---

## 📊 Reports Available

* Available Books
* Issued Books
* Total Books
* Total Students
* Total Issue Records

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/khushi-awasthi/Library-Management-System-Java.git
```

2. Import the project into Eclipse IDE

3. Run:

```text
src/app/Main.java
```

4. Use the menu-driven interface to manage books and students.

---

## 📸 Sample Menu

```text
===== LIBRARY MENU =====

1. Add Book
2. View Books
3. Search Book
4. Issue Book
5. Return Book
6. Remove Book
7. Exit
8. Add Student
9. View Students
10. Search Student
11. Issues History
12. Available Books
13. Issued Books
14. Reports Dashboard
```

---

## 🔮 Future Enhancements

* JDBC + MySQL Integration
* Spring Boot REST API
* User Authentication
* Web-based Interface
* JUnit Testing
* Maven Build Support

---

## 👩‍💻 Author

**Khushi Awasthi**

MCA Student | Aspiring Java Full Stack Developer

GitHub: https://github.com/khushi-awasthi

```
```
