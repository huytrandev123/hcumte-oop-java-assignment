package org.example;
import org.example.model.Category;
import org.example.model.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // Tạo category
        Category phone =
                new Category("Điện thoại");

        Category laptop =
                new Category("Laptop");

        // Tạo sản phẩm
        Product p1 = new Product();

        Product p2 =
                new Product("iPhone 15", 25000);

        Product p3 =
                new Product("MacBook", 40000, 5);

        Product p4 =
                new Product(
                        "Samsung S25",
                        22000,
                        10,
                        phone
                );

        // Hiển thị thông tin
        System.out.println("=== Product 1 ===");
        p1.displayInfo();

        System.out.println();

        System.out.println("=== Product 2 ===");
        p2.displayInfo();

        System.out.println();

        System.out.println("=== Product 3 ===");
        p3.displayInfo();

        System.out.println();

        System.out.println("=== Product 4 ===");
        p4.displayInfo();

        System.out.println();

        // Bán hàng
        p4.sell(2);

        // Nhập hàng
        p3.restock(10);

        // Giảm giá 1 sản phẩm
        p4.applyPromotion(10);

        System.out.println();

        // Mảng sản phẩm
        Product[] products =
                {p1, p2, p3, p4};

        // Giảm giá toàn bộ
        Product.applyGlobalPromotion(
                products,
                5
        );

        System.out.println();

        // Ngừng kinh doanh
        p2.discontinue();

        System.out.println();

        // In báo cáo
        System.out.println(
                Product.getStoreReport()
        );

        System.out.println();

        // Kiểm tra mã sản phẩm
        System.out.println(
                p1.getProductCode());

        System.out.println(
                p2.getProductCode());

        System.out.println(
                p3.getProductCode());

        System.out.println(
                p4.getProductCode());
    }
}