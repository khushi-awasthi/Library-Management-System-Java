package app;
import util.FileManager;
import java.util.Scanner;

import model.Book;
import service.LibraryService;
import service.LibraryServiceImpl;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library =
                new LibraryServiceImpl();

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.println("8. Add Student");
            System.out.println("9. View Students");
            System.out.println("10. Search Student");
            System.out.println("11. IssuesHistory");
            System.out.println("12. Available Books");
            System.out.println("13. Issued Books");
            System.out.println("14. Total Books");
            System.out.println("15. Total Students");
            System.out.println("16. Total Issue Records");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Book ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Category: ");
                        String category = sc.nextLine();

                        library.addBook(
                        new Book(id,title,author,category));

                        break;

                    case 2:

                        library.displayBooks();
                        break;
                    case 3:

                        System.out.print("Enter Book ID: ");

                        System.out.println(
                                library.searchBook(
                                        sc.nextInt()));

                        break;

                    case 4:

                        System.out.print(
                                "Book ID: ");

                        int bookId =
                                sc.nextInt();

                        System.out.print(
                                "Student ID: ");

                        int issueStudentId =
                                sc.nextInt();

                        library.issueBook(
                                bookId,
                                issueStudentId);

                        break;

                    case 5:

                        System.out.print("Book ID: ");
                        library.returnBook(
                                sc.nextInt());

                        break;

                    case 6:

                        System.out.print("Book ID: ");
                        library.removeBook(
                                sc.nextInt());

                        break;

                    case 7:

                        System.out.println(
                                "Thank You!");
                    

                        FileManager.saveBooks(
                                library.getBooks());

                        FileManager.saveStudents(
                                library.getStudents());

                        FileManager.saveIssueRecords(
                                library.getIssueRecords());

                        System.out.println(
                                "Books And Students Saved Successfully");

                        System.exit(0);
                    case 8:

                        System.out.print("Student ID: ");
                        int studentId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        library.addStudent(
                                new Student(
                                        studentId,
                                        name,
                                        course,
                                        email));

                        break;
                    case 9:

                        library.displayStudents();

                        break;
                    case 10:

                        System.out.print(
                                "Enter Student ID: ");

                        Student student =
                                library.searchStudent(
                                        sc.nextInt());

                        if(student == null) {

                            System.out.println(
                                    "Student Not Found");
                        }
                        else {

                            System.out.println(
                                    student);
                        }

                        break;
                    case 11:

                        library.displayIssueHistory();

                        break;
                    case 12:

                        library.displayAvailableBooks();

                        break;
                    case 13:

                        library.displayIssuedBooks();

                        break;
                    case 14:

                        library.displayStatistics();

                        break;
                    case 15:

                        library.displayStatistics();

                        break;
                    case 16:

                        library.displayStatistics();

                        break;

                    default:

                        System.out.println(
                                "Invalid Choice");
                }

            } catch (Exception e) {

                System.out.println(
                        e.getMessage());
            }
        }
    }
}