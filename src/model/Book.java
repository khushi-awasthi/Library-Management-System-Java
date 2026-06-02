package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String category;
    private boolean issued;

    public Book(int id, String title,
                String author,
                String category) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }


    public String getCategory() {
        return category;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Title: " + title
                + " | Author: " + author
                + " | Category: " + category
                + " | Issued: " + issued;
    }
}