package com.manageBooks.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String borrowSlipId;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowSlip(String borrowSlipId, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.borrowSlipId = borrowSlipId;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    // Getter
    public String getBorrowSlipId() {
        return borrowSlipId;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Set time trả sách
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    // isOverdue()
    public boolean isOverdue(LocalDate currentDate) {

        if (returnDate == null) {
            return returnDate == null && currentDate.isAfter(dueDate);
        }

        return returnDate.isAfter(dueDate);
    }

    // getLateDays() : get số ngày trễ
    public long getLateDays() {

        if (returnDate == null ||
                !returnDate.isAfter(dueDate)) {
            return 0;
        }

        return ChronoUnit.DAYS.between(
                dueDate,
                returnDate
        );
    }

    // calculateFine(): tính tiền phạt

    public double calculateFine() {
        return getLateDays() * 5000;
    }

    // Log
    public String displayInfo() {
        return "===== BORROW SLIP =====\n" +
                "Slip ID     : " + borrowSlipId + "\n" +
                "Reader      : " + reader.getReaderName() + "\n" +
                "Book        : " + book.getBookTitle() + "\n" +
                "Borrow Date : " + borrowDate + "\n" +
                "Due Date    : " + dueDate + "\n" +
                "Return Date : " + returnDate;
    }
}
