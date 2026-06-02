package model;

public class Student {

    private int studentId;
    private String name;
    private String course;
    private String email;

    public Student(int studentId,
                   String name,
                   String course,
                   String email) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {

        return studentId
                + " | "
                + name
                + " | "
                + course
                + " | "
                + email;
    }
}