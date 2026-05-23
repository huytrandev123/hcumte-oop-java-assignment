package com.manageBooks.model;

import java.time.LocalDate;

public class Librarian {
    private String librarianId;
    private String librarianName;

    public Librarian(String librarianId, String librarianName) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
    }

    // Getter

    public String getLibrarianId() {
        return librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    // Kiểm tra thẻ thư viện

    public boolean checkCard(Reader reader) {
        return reader != null;
    }

    // Kiểm tra sách còn trong kho

    public boolean checkBookAvailability(Book book) {
        return book.isAvailable();
    }

    // Tạo phiếu mượn

    public BorrowSlip createBorrowSlip(String borrowSlipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {

        if (!checkCard(reader)) {
            return null;
        }

        if (!checkBookAvailability(book)) {
            return null;
        }

        book.decreaseQty();

        return new BorrowSlip(borrowSlipId, reader, book, borrowDate, dueDate);
    }

    // Hiển thị thông tin thủ thư

    public String librarianInfo() {
        return "===== LIBRARIAN INFORMATION =====\n" +
                "ID   : " + librarianId + "\n" +
                "Name : " + librarianName;
    }
}
