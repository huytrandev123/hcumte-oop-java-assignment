package Rectangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(2, 5);
        Rectangle rectangle2 = new Rectangle(5, 9);

        System.out.println("==== Rectangles ====");
        rectangle1.printInfo();
        rectangle2.printInfo();

    }
}