package org.example;

public class Book {
    // Khai báo biến
    String  title;
    String author;
    int year;
    double price;

    // Contructor by default
    public Book() {
        title = "Unknown";
        author = "Unknown";
        year = 2000;
        price = 0;
    }

    // Constructor 4 tham số
    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // Constructor nhận 3 tham số
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;
    }

    // displayInfo()
    public void displayInfo() {
        System.out.println(
                "Sách " + title + " - " + " Tác giả: " + author + " - " + " Năm: " + year + " - " + "Giá: " + price
        );
    }

    // applyDiscount()
    public void applyDiscount(double percent) {
        price = price - (price * percent/100);
    }

    // Main
    public static void main(String[] args) {
        // Object dùng constructor by default
        Book b1 = new Book();

        // Object dùng constructor có 4 tham số
        Book b2 = new Book(
                "Conan Detective",
                "Gosho Aoyama",
                1994,
                50000
        );

        // Object dùng constructor cho 3 tham số
        Book b3 = new Book(
            "Learn Java",
                "Huy Tran"
        );

        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();
    }
}
