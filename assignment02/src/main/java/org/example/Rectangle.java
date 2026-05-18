package org.example;

public class Rectangle {

    // Thuộc tính
    double width;
    double height;

    // Constructor không tham số
    // Hình vuông cạnh 1
    public Rectangle() {
        width = 1;
        height = 1;
    }

    // Constructor 1 tham số - side
    public Rectangle(double side) {
        width = side;
        height = side;
    }

    // Constructor 2 tham số - width, height
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Copy constructor
    public Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }

    // getArea() - Tính diện tích
    public double getArea() {
        return width * height;
    }

    // getPerimeter() - Tính chu vi
    public double getPerimeter() {
        return (width + height) * 2;
    }

    // isSquare() - Kiểm tra hình vuông
    public boolean isSquare() {
        return width == height;
    }

    // scale() - phóng to / thu nhỏ
    public void scale(double factor) {
        width = width * factor;
        height = height * factor;
    }

    // Hàm main để test
    public static void main(String[] args) {

        // Constructor không tham số
        Rectangle r1 = new Rectangle();

        // Constructor 1 tham số
        Rectangle r2 = new Rectangle(5);

        // Constructor 2 tham số
        Rectangle r3 = new Rectangle(4, 6);

        // Copy constructor
        Rectangle r4 = new Rectangle(r3);

        // Test r1
        System.out.println("=== Rectangle r1 ===");
        System.out.println("Diện tích: " + r1.getArea());
        System.out.println("Chu vi: " + r1.getPerimeter());
        System.out.println("Có phải hình vuông? " + r1.isSquare());

        System.out.println();

        // Test r2
        System.out.println("=== Rectangle r2 ===");
        System.out.println("Diện tích: " + r2.getArea());
        System.out.println("Chu vi: " + r2.getPerimeter());
        System.out.println("Có phải hình vuông? " + r2.isSquare());

        System.out.println();

        // Test r3
        System.out.println("=== Rectangle r3 ===");
        System.out.println("Diện tích: " + r3.getArea());
        System.out.println("Chu vi: " + r3.getPerimeter());
        System.out.println("Có phải hình vuông? " + r3.isSquare());

        System.out.println();

        // Test copy constructor
        System.out.println("=== Rectangle r4 (copy từ r3) ===");
        System.out.println("Diện tích: " + r4.getArea());
        System.out.println("Chu vi: " + r4.getPerimeter());

        System.out.println();

        // Test scale
        r3.scale(2);

        System.out.println("=== r3 sau khi scale x2 ===");
        System.out.println("Width: " + r3.width);
        System.out.println("Height: " + r3.height);
        System.out.println("Diện tích: " + r3.getArea());
    }
}