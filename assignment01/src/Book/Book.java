package Book;

public class Book {

    String title;
    String author;
    double price;
    boolean inStock;

    public Book(String title, String author, double price, boolean inStock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStock = inStock;
    }

    public void printInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("In Stock: " + inStock);
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }
}