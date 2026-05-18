package Rectangle;

public class Rectangle {
    private double width;
    private  double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than 0.");
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return this.width * this.height;
    }

    public double perimeter() {
        return (this.width + this.height) * 2;
    }

    public boolean isSquare() {
        return this.width == this.height;
    }

    public void printInfo() {
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("Area: " + this.area());
        System.out.println("Perimeter: " + this.perimeter());
        System.out.println("Type: " + (this.isSquare() ? "Square" : "Rectangle"));
        System.out.println("-------------------");
    }
}