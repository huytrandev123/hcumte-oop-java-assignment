package com.manageBooks.model;

public class Book {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookYear;
    private int bookQty;
    private int bookBorrowCount;

    // Constructor
    public Book (String bookId, String bookTitle, String bookAuthor, int bookYear, int bookQty, int bookBorrowCount) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookQty = bookQty;
        this.bookBorrowCount = 0;
    }

    // Getter - Setter
    public String getBookId() {
        return bookId;
    }
    public void setBookId (String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }


    public int getBookQty() {
        return bookQty;
    }

    // getBorrowCount()
    public int getBorrowCount() {
        return bookBorrowCount;
    }




    // isAvailable()
    public boolean isAvailable() {
        return bookQty > 0;
    }

    // increaseQty
    public void increaseQty() {
        bookQty++;
    }

    // decreaseQty()
    public boolean decreaseQty() {
        if (bookQty > 0) {
            bookQty--;
            return true;
        }

        return false;
    }

    // increaseBorrowCount()
    public void increaseBorrowCount() {
        bookBorrowCount++;
    }

    // Log

    public String bookInfo() {
        return "===== BOOK INFORMATION =====\n" +
                "Book ID  : " + bookId + "\n" +
                "Name     : " + bookTitle + "\n" +
                "Author   : " + bookAuthor + "\n" +
                "Year     : " + bookYear + "\n" +
                "Quantity : " + bookQty + "\n";
    }

}
