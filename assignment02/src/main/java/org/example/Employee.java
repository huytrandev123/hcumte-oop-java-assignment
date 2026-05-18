package org.example;

public class Employee {

    // Thuộc tính instance
    private int id;
    private String name;
    private double salary;

    // Thuộc tính static
    private static int employeeCount = 0;
    private static int nextId = 1000;

    public static String companyName = "TechCorp";

    private static double totalSalary = 0;

    // Constructor
    public Employee(String name, double salary) {

        // Tự động cấp ID
        this.id = nextId;
        nextId++;

        this.name = name;
        this.salary = salary;

        // Cập nhật dữ liệu chung
        employeeCount++;
        totalSalary += salary;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter cho name
    public void setName(String name) {
        this.name = name;
    }

    // Setter cho salary
    public void setSalary(double salary) {

        // Cập nhật lại totalSalary
        totalSalary -= this.salary;

        this.salary = salary;

        totalSalary += this.salary;
    }

    // Static method: số nhân viên
    public static int getEmployeeCount() {
        return employeeCount;
    }

    // Static method: tổng lương
    public static double getTotalSalary() {
        return totalSalary;
    }


    // Static method: lương trung bình
    public static double getAverageSalary() {

        if (employeeCount == 0) {
            return 0;
        }

        return totalSalary / employeeCount;
    }

    // Static method: đổi tên công ty
    public static void changeCompanyName(String newName) {
        companyName = newName;
    }

    // Tăng lương theo %
    public void raiseSalary(double percent) {

        if (percent > 0) {

            // Trừ lương cũ khỏi tổng
            totalSalary -= this.salary;

            // Tăng lương
            this.salary = this.salary +
                    (this.salary * percent / 100);

            // Cộng lương mới vào tổng
            totalSalary += this.salary;

            System.out.println("Tăng lương thành công!");
        } else {
            System.out.println("Phần trăm không hợp lệ!");
        }
    }

    // Hiển thị thông tin
    public void displayInfo() {

        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Lương: " + salary);
        System.out.println("Công ty: " + companyName);
    }

    // Main
    public static void main(String[] args) {

        // Tạo nhân viên
        Employee e1 = new Employee("Nguyen Van A", 1000);
        Employee e2 = new Employee("Tran Van B", 2000);
        Employee e3 = new Employee("Le Van C", 3000);

        // Hiển thị thông tin
        System.out.println("=== Nhân viên 1 ===");
        e1.displayInfo();

        System.out.println();

        System.out.println("=== Nhân viên 2 ===");
        e2.displayInfo();

        System.out.println();

        System.out.println("=== Nhân viên 3 ===");
        e3.displayInfo();

        System.out.println();

        // Kiểm tra ID
        System.out.println("ID e1: " + e1.getId());
        System.out.println("ID e2: " + e2.getId());
        System.out.println("ID e3: " + e3.getId());

        System.out.println();

        // Thống kê
        System.out.println("Tổng số nhân viên: "
                + Employee.getEmployeeCount());

        System.out.println("Tổng lương: "
                + Employee.getTotalSalary());

        System.out.println("Lương trung bình: "
                + Employee.getAverageSalary());

        System.out.println();

        // Đổi lương
        System.out.println("=== Đổi lương e1 ===");

        e1.setSalary(5000);

        System.out.println("Lương mới e1: "
                + e1.getSalary());

        System.out.println("Tổng lương mới: "
                + Employee.getTotalSalary());

        System.out.println();

        // Đổi tên công ty
        Employee.changeCompanyName("OpenAI Tech");

        System.out.println("=== Sau khi đổi tên công ty ===");

        e1.displayInfo();

        System.out.println();

        // Tăng lương theo %
        System.out.println("=== Tăng lương e2 ===");

        e2.raiseSalary(20);

        System.out.println("Lương mới e2: "
                + e2.getSalary());

        System.out.println("Tổng lương mới: "
                + Employee.getTotalSalary());

        System.out.println("Lương trung bình mới: "
                + Employee.getAverageSalary());
    }
}

    /*
    Nếu trong main không tạo object nào,
    Employee.getAverageSalary() vẫn chạy được.

    Vì đây là static method,
    nó thuộc về class Employee chứ không thuộc object.

    Có thể gọi trực tiếp:
    Employee.getAverageSalary()

    */
