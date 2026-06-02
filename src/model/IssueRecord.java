package model;

import java.time.LocalDate;

public class IssueRecord {

    private int bookId;
    private int studentId;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    // Used when issuing a new book
    public IssueRecord(int bookId,
                       int studentId) {

        this.bookId = bookId;
        this.studentId = studentId;

        this.issueDate = LocalDate.now();

        // Due after 7 days
        this.dueDate =
                issueDate.plusDays(7);
    }

    // Used when loading from issues.txt
    public IssueRecord(int bookId,
                       int studentId,
                       LocalDate issueDate) {

        this.bookId = bookId;
        this.studentId = studentId;

        this.issueDate = issueDate;

        // Recalculate due date
        this.dueDate =
                issueDate.plusDays(7);
    }

    public int getBookId() {
        return bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(
            LocalDate returnDate) {

        this.returnDate =
                returnDate;
    }

    @Override
    public String toString() {

        return "Book ID: "
                + bookId
                + " | Student ID: "
                + studentId
                + " | Issue Date: "
                + issueDate
                + " | Due Date: "
                + dueDate
                + " | Return Date: "
                + returnDate;
    }
}