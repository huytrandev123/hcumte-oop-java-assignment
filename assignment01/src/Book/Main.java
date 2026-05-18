package Book;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("Java", "Nguyen Van A", 100, true);
        Book b2 = new Book("OOP", "Tran Van B", 150, true);
        Book b3 = new Book("DSA", "Le Van C", 200, false);

        System.out.println("Before Discount");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();

        b1.applyDiscount(10);
        b2.applyDiscount(10);
        b3.applyDiscount(10);

        System.out.println("After Discount");
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();
    }
}