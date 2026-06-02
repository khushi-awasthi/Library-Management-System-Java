package service;
import util.FileManager;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import model.IssueRecord;
import exception.BookAlreadyIssuedException;
import exception.BookNotFoundException;
import model.Book;
import model.Student;

public class LibraryServiceImpl implements LibraryService {

	private Map<Integer, Book> books =
	        FileManager.loadBooks();
	private Map<Integer, Student> students =
	        FileManager.loadStudents();
	private List<IssueRecord> records =
	        FileManager.loadIssueRecords();
	
	@Override
	public List<IssueRecord>
	getIssueRecords() {

	    return records;
	}
    @Override
    public void addBook(Book book) {
        books.put(book.getId(),book);
        System.out.println("Book Added Successfully");
    }

    @Override
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available");
            return;
        }

        books.values()
        .forEach(System.out::println);
    }
    @Override
    public Book searchBook(int id)
            throws BookNotFoundException {

        return findBook(id);
    }

    @Override
    public void removeBook(int id)
            throws BookNotFoundException {

        Book book = findBook(id);

        books.remove(id);

        System.out.println("Book Removed Successfully");
    }

    @Override
    public void issueBook(int id)
            throws BookNotFoundException,
            BookAlreadyIssuedException {

        Book book = findBook(id);

        if (book.isIssued()) {

            throw new BookAlreadyIssuedException(
                    "Book Already Issued");
        }

        book.setIssued(true);

        records.add(
                new IssueRecord(
                        id,
                        0));

        System.out.println(
                "Book Issued Successfully");
    }
    @Override
    public void issueBook(int bookId,
                          int studentId)
            throws BookNotFoundException,
            BookAlreadyIssuedException {

        Book book =
                findBook(bookId);

        if(book.isIssued()) {

            throw new BookAlreadyIssuedException(
                    "Book Already Issued");
        }

        book.setIssued(true);

        records.add(
                new IssueRecord(
                        bookId,
                        studentId));

        System.out.println(
                "Book Issued Successfully");
    }

    @Override
    public void returnBook(int id)
            throws BookNotFoundException {

        Book book = findBook(id);

        book.setIssued(false);

        IssueRecord record =
                findIssueRecord(id);

        if(record != null) {

            record.setReturnDate(
                    java.time.LocalDate.now());

            long lateDays =
                    java.time.temporal
                    .ChronoUnit.DAYS
                    .between(
                            record.getDueDate(),
                            record.getReturnDate());

            if(lateDays > 0) {

                long fine =
                        lateDays * 10;

                System.out.println(
                        "Late By : "
                        + lateDays
                        + " Days");

                System.out.println(
                        "Fine : Rs."
                        + fine);
            }
        }

        System.out.println(
                "Book Returned Successfully");
    }
    @Override
    public Map<Integer, Book> getBooks() {
        return books;
    }
    @Override
    public void addStudent(Student student) {

        students.put(
                student.getStudentId(),
                student);

        System.out.println(
                "Student Added Successfully");
    }

    @Override
    public void displayStudents() {

        if(students.isEmpty()) {

            System.out.println(
                    "No Students Found");

            return;
        }

        students.values()
                .forEach(
                        System.out::println);
    }

    @Override
    public Student searchStudent(int id) {

        return students.get(id);
    }
    @Override
    public Map<Integer, Student> getStudents() {

        return students;
    }
    public void displayIssueHistory() {

        if(records.isEmpty()) {

            System.out.println(
                    "No Issue Records");

            return;
        }

        records.forEach(
                System.out::println);
    }
    private IssueRecord
    findIssueRecord(int bookId) {

        for(IssueRecord record :
                records) {

            if(record.getBookId()
                    == bookId) {

                return record;
            }
        }

        return null;
    }
    @Override
    public void displayAvailableBooks() {

        books.values()
             .stream()
             .filter(book ->
                     !book.isIssued())
             .forEach(
                     System.out::println);
    }
    @Override
    public void displayIssuedBooks() {

        books.values()
             .stream()
             .filter(Book::isIssued)
             .forEach(
                     System.out::println);
    }
    @Override
    public void displayStatistics() {

        System.out.println(
                "\n===== REPORT =====");

        System.out.println(
                "Total Books : "
                        + books.size());

        System.out.println(
                "Total Students : "
                        + students.size());

        System.out.println(
                "Total Issue Records : "
                        + records.size());

        long issuedBooks =
                books.values()
                     .stream()
                     .filter(
                             Book::isIssued)
                     .count();

        long availableBooks =
                books.values()
                     .stream()
                     .filter(book ->
                             !book.isIssued())
                     .count();

        System.out.println(
                "Issued Books : "
                        + issuedBooks);

        System.out.println(
                "Available Books : "
                        + availableBooks);
    }

    private Book findBook(int id)
            throws BookNotFoundException {

    	Book book = books.get(id);

    	if(book == null)
    	{
    	    throw new BookNotFoundException(
    	            "Book Not Found");
    	}

    	return book;
                
    }
    
}