package Circle;

public class Main {

    public static void main(String[] args) {

        Circle[] circles = new Circle[5];

        circles[0] = new Circle(1);
        circles[1] = new Circle(2);
        circles[2] = new Circle(3);
        circles[3] = new Circle(4);
        circles[4] = new Circle(5);

        double totalArea = 0;

        for (int i = 0; i < circles.length; i++) {

            System.out.println("Circle " + (i + 1));

            System.out.println("Radius: " + circles[i].radius);

            System.out.println("Area: " + circles[i].area());

            System.out.println("Circumference: " + circles[i].circumference());

            System.out.println("----------------");

            totalArea += circles[i].area();
        }

        System.out.println("Total Area = " + totalArea);
    }
}