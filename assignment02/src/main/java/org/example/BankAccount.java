package org.example;

public class BankAccount {

    // Thuộc tính private
    private String accountNumber;
    private String ownerName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String ownerName, double balance) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        // Validation số dư
        if (balance < 0) {
            System.out.println("Số dư không hợp lệ! Gán balance = 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter cho ownerName
    public void setOwnerName(String ownerName) {

        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Tên không hợp lệ!");
        }
    }

    // Nạp tiền
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp tiền thành công!");
        } else {
            System.out.println("Số tiền nạp phải > 0");
        }
    }

    // Rút tiền
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Số tiền rút phải > 0");
        } else if (amount > balance) {
            System.out.println("Không đủ số dư để rút!");
        } else {
            balance -= amount;
            System.out.println("Rút tiền thành công!");
        }
    }

    // Chuyển tiền
    public void transfer(BankAccount other, double amount) {

        if (amount <= 0) {
            System.out.println("Số tiền chuyển không hợp lệ!");
        } else if (amount > balance) {
            System.out.println("Không đủ tiền để chuyển!");
        } else {
            this.balance -= amount;
            other.balance += amount;

            System.out.println("Chuyển tiền thành công!");
        }
    }

    // Hiển thị thông tin
    public void displayInfo() {

        // Lấy 4 ký tự cuối
        String last4 = accountNumber.substring(accountNumber.length() - 4);

        System.out.println("Số tài khoản: ****" + last4);
        System.out.println("Chủ tài khoản: " + ownerName);
        System.out.println("Số dư: " + balance);
    }

    // Main test
    public static void main(String[] args) {

        // Tạo tài khoản
        BankAccount acc1 = new BankAccount(
                "123456789",
                "Nguyen Van A",
                5000
        );

        BankAccount acc2 = new BankAccount(
                "987654321",
                "Tran Van B",
                3000
        );

        // Hiển thị ban đầu
        System.out.println("=== Tài khoản 1 ===");
        acc1.displayInfo();

        System.out.println();

        // Nạp tiền
        acc1.deposit(2000);

        // Nạp lỗi
        acc1.deposit(-100);

        System.out.println();

        // Rút tiền
        acc1.withdraw(1000);

        // Rút lỗi
        acc1.withdraw(10000);

        System.out.println();

        // Chuyển tiền
        acc1.transfer(acc2, 2000);

        System.out.println();

        // Hiển thị sau chuyển
        System.out.println("=== Tài khoản 1 ===");
        acc1.displayInfo();

        System.out.println();

        System.out.println("=== Tài khoản 2 ===");
        acc2.displayInfo();

        System.out.println();

        // Test setter lỗi
        acc1.setOwnerName("");

    }
}

 /*
     Không viết setter cho accountNumber vì
      - STK của mỗi khách hàng có tính unique và cố định
      - Nếu cho phép dùng setter sẽ dễ gây sai dữ liệu và mất tính bảo mật.
 */