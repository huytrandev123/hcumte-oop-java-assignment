package org.example.model;

public class Book {
    private String bookId;
    private String name;
    private String author;
    private int year;
    private int quantity;

    public Book(String bookId, String name, String author,
                int year, int quantity) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    // Getter
    public String getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", quantity=" + quantity +
                '}';
    }
}
