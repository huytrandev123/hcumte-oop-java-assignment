package com.manageBooks.service;

import com.manageBooks.model.Book;
import com.manageBooks.model.BorrowSlip;
import com.manageBooks.model.Reader;
import com.manageBooks.model.ReaderType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<BorrowSlip> borrowSlips;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
        borrowSlips = new ArrayList<>();
    }

    // =========================
    // Add
    // =========================

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void addBorrowSlip(BorrowSlip slip) {
        borrowSlips.add(slip);
    }

    // =========================
    // Borrow Book
    // =========================

    public BorrowSlip borrowBook(
            String slipId,
            Reader reader,
            Book book,
            LocalDate borrowDate,
            LocalDate dueDate
    ) {

        // kiểm tra kho

        if (!book.isAvailable()) {
            return null;
        }

        // giới hạn thẻ

        int maxBooks = reader.getReaderType() == ReaderType.STUDENT ? 3 : 5;

        if (reader.getReaderBorrowBooksCount() >= maxBooks) {
            return null;
        }

        book.decreaseQty();

        reader.increaseBorrowedBooksCount();

        BorrowSlip slip = new BorrowSlip(slipId, reader, book, borrowDate, dueDate);

        borrowSlips.add(slip);

        return slip;
    }

    // =========================
    // Return Book
    // =========================

    public double returnBook(BorrowSlip slip, LocalDate returnDate) {

        slip.setReturnDate(returnDate);

        slip.getBook().increaseQty();

        slip.getReader().decreaseBorrowedBooksCount();

        return slip.calculateFine();
    }

    // =========================
    // Search by Title
    // =========================

    public List<Book> searchBookByTitle(
            String keyword
    ) {

        List<Book> result =
                new ArrayList<>();

        for (Book book : books) {

            if (book.getBookTitle()
                    .toLowerCase()
                    .contains(
                            keyword.toLowerCase()
                    )) {

                result.add(book);
            }
        }

        return result;
    }

    // =========================
    // Search by Author
    // =========================

    public List<Book> searchBookByAuthor(
            String keyword
    ) {

        List<Book> result =
                new ArrayList<>();

        for (Book book : books) {

            if (book.getBookAuthor()
                    .toLowerCase()
                    .contains(
                            keyword.toLowerCase()
                    )) {

                result.add(book);
            }
        }

        return result;
    }

    // =========================
    // Overdue Slips
    // =========================

    public List<BorrowSlip> getOverdueSlips(
            LocalDate currentDate
    ) {

        List<BorrowSlip> result =
                new ArrayList<>();

        for (BorrowSlip slip : borrowSlips) {

            if (slip.isOverdue(currentDate)) {
                result.add(slip);
            }
        }

        return result;
    }
}
