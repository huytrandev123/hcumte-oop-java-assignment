package Book;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("Java", "Huy Tran", 500000, true);
        Book b2 = new Book("Math 1", "Dat Nguyen", 320000, false);
        Book b3 = new Book("Physicsal", "Quoc Tran", 120000, false);

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