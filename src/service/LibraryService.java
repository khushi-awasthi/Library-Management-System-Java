package service;


import java.util.Map;

import exception.BookAlreadyIssuedException;
import exception.BookNotFoundException;
import model.Book;
import model.Student;
import java.util.List;
import model.IssueRecord;

public interface LibraryService {

    void addBook(Book book);

    void displayBooks();

    Book searchBook(int id)
            throws BookNotFoundException;

    void removeBook(int id)
            throws BookNotFoundException;

    void issueBook(int id)
            throws BookNotFoundException,
            BookAlreadyIssuedException;
    void addStudent(Student student);

    void displayStudents();
    void displayIssueHistory();
    void displayAvailableBooks();

    void displayIssuedBooks();

    void displayStatistics();
    void issueBook(int bookId, int studentId)
            throws BookNotFoundException,
            BookAlreadyIssuedException;
    Student searchStudent(int id);
    void returnBook(int id)
            throws BookNotFoundException;

    Map<Integer, Book> getBooks();
    Map<Integer, Student> getStudents();
    List<IssueRecord> getIssueRecords();
}