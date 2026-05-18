package org.example.model;

import org.example.util.ProductValidator;

public class Product {

    // Thuộc tính
    private String productCode;
    private String name;
    private double price;
    private int quantity;

    private Category category;

    // static
    private static int counter = 1;
    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    // Dùng để kiểm tra sản phẩm còn bán hay không
    private boolean discontinued = false;

    // Constructor mặc định
    public Product() {

        this.productCode =
                String.format("P-%04d", counter);

        counter++;
        totalProducts++;

        this.name = "Unknown";
        this.price = 0;
        this.quantity = 0;
    }

    // Constructor 2 tham số
    public Product(String name, double price) {

        this.productCode =
                String.format("P-%04d", counter);

        counter++;
        totalProducts++;

        setName(name);
        setPrice(price);

        this.quantity = 0;
    }

    // Constructor đầy đủ
    public Product(String name,
                   double price,
                   int quantity) {

        this.productCode =
                String.format("P-%04d", counter);

        counter++;
        totalProducts++;

        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    // Constructor có category
    public Product(String name,
                   double price,
                   int quantity,
                   Category category) {

        this.productCode =
                String.format("P-%04d", counter);

        counter++;
        totalProducts++;

        setName(name);
        setPrice(price);
        setQuantity(quantity);

        this.category = category;
    }

    // Getter
    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    // Setter
    public void setName(String name) {

        if (ProductValidator.isValidName(name)) {
            this.name = name;
        } else {
            System.out.println("Tên sản phẩm không hợp lệ!");
        }
    }

    public void setPrice(double price) {

        if (ProductValidator.isValidPrice(price)) {
            this.price = price;
        } else {
            System.out.println("Giá sản phẩm không hợp lệ!");
        }
    }

    public void setQuantity(int quantity) {

        if (ProductValidator.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            System.out.println("Số lượng không hợp lệ!");
        }
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Bán hàng
    public void sell(int amount) {

        if (discontinued) {
            System.out.println("Sản phẩm đã ngừng kinh doanh!");
            return;
        }

        if (amount > 0 && amount <= quantity) {

            quantity -= amount;

            totalRevenue += amount * price;

            System.out.println("Bán hàng thành công!");
        } else {
            System.out.println("Không đủ hàng hoặc số lượng sai!");
        }
    }

    // Nhập hàng
    public void restock(int amount) {

        if (amount > 0) {

            quantity += amount;

            System.out.println("Nhập hàng thành công!");
        } else {
            System.out.println("Số lượng nhập không hợp lệ!");
        }
    }

    // Giảm giá 1 sản phẩm
    public void applyPromotion(double discountPercent) {

        if (discountPercent > 0
                && discountPercent <= 100) {

            price = price -
                    (price * discountPercent / 100);

            System.out.println("Giảm giá thành công!");
        } else {
            System.out.println("Phần trăm giảm giá không hợp lệ!");
        }
    }

    // Giảm giá toàn bộ sản phẩm
    public static void applyGlobalPromotion(
            Product[] products,
            double discountPercent) {

        for (Product p : products) {

            if (p != null) {
                p.applyPromotion(discountPercent);
            }
        }
    }

    /*
    Khi sản phẩm bị discontinue,
    totalProducts KHÔNG giảm.

    Vì totalProducts đại diện cho:
    tổng số sản phẩm đã từng được tạo ra,
    không phải số sản phẩm còn kinh doanh.

    Điều này giúp giữ lịch sử dữ liệu ổn định.
    */

    // Ngừng kinh doanh
    public void discontinue() {

        discontinued = true;

        System.out.println(
                productCode + " đã ngừng kinh doanh.");
    }

    // Hiển thị thông tin
    public void displayInfo() {

        System.out.println("Mã SP: " + productCode);
        System.out.println("Tên SP: " + name);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng: " + quantity);

        if (category != null) {
            System.out.println("Danh mục: "
                    + category.getCategoryName());
        }

        System.out.println("Ngừng bán: "
                + discontinued);
    }

    // Static method
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static String getStoreReport() {

        return "===== BÁO CÁO CỬA HÀNG =====\n"
                + "Tổng sản phẩm: "
                + totalProducts
                + "\nTổng doanh thu: "
                + totalRevenue;
    }
}