package util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import model.Book;
import model.Student;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import model.IssueRecord;

public class FileManager {

    private static final String BOOK_FILE =
            "books.txt";

    private static final String STUDENT_FILE =
            "students.txt";

    // ================= BOOK METHODS =================

    public static void saveBooks(
            Map<Integer, Book> books) {

        System.out.println(
                new File(BOOK_FILE)
                        .getAbsolutePath());

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(
                                     BOOK_FILE))) {

            for (Book book :
                    books.values()) {

                bw.write(
                        book.getId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getCategory() + "," +
                        book.isIssued());

                bw.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error Saving Books");
        }
    }
    

    public static Map<Integer, Book>
    loadBooks() {

        Map<Integer, Book> books =
                new HashMap<>();

        File file =
                new File(BOOK_FILE);

        if (!file.exists()) {

            return books;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     BOOK_FILE))) {

            String line;

            while ((line =
                    br.readLine())
                    != null) {

                String[] data =
                        line.split(",");

                int id =
                        Integer.parseInt(
                                data[0]);

                String title =
                        data[1];

                String author =
                        data[2];

                String category =
                        data[3];

                boolean issued =
                        Boolean.parseBoolean(
                                data[4]);

                Book book =
                        new Book(
                                id,
                                title,
                                author,
                                category);

                book.setIssued(
                        issued);

                books.put(
                        id,
                        book);
            }

        } catch (Exception e) {

            System.out.println(
                    "Error Loading Books");
        }

        return books;
    }

    // ================= STUDENT METHODS =================

    public static void saveStudents(
            Map<Integer, Student> students) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(
                                     STUDENT_FILE))) {

            for (Student student :
                    students.values()) {

                bw.write(
                        student.getStudentId()
                                + ","
                                + student.getName()
                                + ","
                                + student.getCourse()
                                + ","
                                + student.getEmail());

                bw.newLine();
            }

        } catch (Exception e) {

            System.out.println(
                    "Error Saving Students");
        }
    }
    public static void saveIssueRecords(
            List<IssueRecord> records) {

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter(
                                     "issues.txt"))) {

            for(IssueRecord record :
                    records) {

                bw.write(
                        record.getBookId()
                        + ","
                        + record.getStudentId()
                        + ","
                        + record.getIssueDate());

                bw.newLine();
            }

        } catch(Exception e) {

            System.out.println(
                    "Error Saving Issues");
        }
    }

    public static Map<Integer, Student>
    loadStudents() {

        Map<Integer, Student>
                students =
                new HashMap<>();

        File file =
                new File(
                        STUDENT_FILE);

        if (!file.exists()) {

            return students;
        }

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     STUDENT_FILE))) {

            String line;

            while ((line =
                    br.readLine())
                    != null) {

                String[] data =
                        line.split(",");

                int id =
                        Integer.parseInt(
                                data[0]);

                String name =
                        data[1];

                String course =
                        data[2];

                String email =
                        data[3];

                Student student =
                        new Student(
                                id,
                                name,
                                course,
                                email);

                students.put(
                        id,
                        student);
            }

        } catch (Exception e) {

            System.out.println(
                    "Error Loading Students");
        }

        return students;
    }
    public static List<IssueRecord>
    loadIssueRecords() {

        List<IssueRecord> records =
                new ArrayList<>();

        File file =
                new File("issues.txt");

        if(!file.exists()) {

            return records;
        }

        try(BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    file))) {

            String line;

            while((line =
                    br.readLine())
                    != null) {

                String[] data =
                        line.split(",");

                int bookId =
                        Integer.parseInt(
                                data[0]);

                int studentId =
                        Integer.parseInt(
                                data[1]);

                LocalDate issueDate =
                        LocalDate.parse(
                                data[2]);

                records.add(
                        new IssueRecord(
                                bookId,
                                studentId,
                                issueDate));
            }

        } catch(Exception e) {

            System.out.println(
                    "Error Loading Issues");
            e.printStackTrace();
        }

        return records;
    }
}