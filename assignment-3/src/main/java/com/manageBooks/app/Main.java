package com.manageBooks.app;

import com.manageBooks.model.*;
import com.manageBooks.service.Library;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        // =========================
        // Readers
        // =========================

        Reader student = new Reader(
                "R001",
                "Tran Do Quang Huy",
                "huy@gmail.com",
                ReaderType.STUDENT,
                0
        );

        Reader teacher = new Reader(
                "R002",
                "Nguyen Van A",
                "teacher@gmail.com",
                ReaderType.TEACHER,
                0
        );

        library.addReader(student);
        library.addReader(teacher);

        // =========================
        // Books
        // =========================

        Book book1 = new Book(
                "B001",
                "Clean Code",
                "Robert Martin",
                2008,
                20,
                2
        );

        Book book2 = new Book(
                "B002",
                "Java Core",
                "Cay Horstmann",
                2020,
                10,
                3
        );

        Book book3 = new Book(
                "B003",
                "Spring Boot",
                "Craig Walls",
                2022,
                8,
                4
        );

        Book book4 = new Book(
                "B004",
                "Design Patterns",
                "GoF",
                1994,
                9,
                5
        );

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // =========================
        // Student borrow limit test
        // =========================

        System.out.println("===== STUDENT BORROW TEST =====");

        BorrowSlip s1 = library.borrowBook(
                "BS001",
                student,
                book1,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip s2 = library.borrowBook(
                "BS002",
                student,
                book2,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip s3 = library.borrowBook(
                "BS003",
                student,
                book3,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        // Cuốn thứ 4 -> denied

        BorrowSlip s4 = library.borrowBook(
                "BS004",
                student,
                book4,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        if (s4 == null) {
            System.out.println(
                    "Student reached maximum limit (3 books)"
            );
        }

        // =========================
        // Teacher borrow limit test
        // =========================

        System.out.println("\n===== TEACHER BORROW TEST =====");

        BorrowSlip t1 = library.borrowBook(
                "BT001",
                teacher,
                book1,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip t2 = library.borrowBook(
                "BT002",
                teacher,
                book2,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip t3 = library.borrowBook(
                "BT003",
                teacher,
                book3,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip t4 = library.borrowBook(
                "BT004",
                teacher,
                book4,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip t5 = library.borrowBook(
                "BT005",
                teacher,
                book1,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        BorrowSlip t6 = library.borrowBook(
                "BT006",
                teacher,
                book2,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        if (t6 == null) {
            System.out.println(
                    "Teacher reached maximum limit (5 books)"
            );
        }

        // =========================
        // Return Book + Fine
        // =========================

        System.out.println("\n===== RETURN BOOK =====");

        double fine = library.returnBook(
                s1,
                LocalDate.now().plusDays(10)
        );

        System.out.println(
                "Fine = " + fine + " VND"
        );

        // =========================
        // Search by Title
        // =========================

        System.out.println("\n===== SEARCH TITLE =====");

        List<Book> titleResult =
                library.searchBookByTitle("java");

        for (Book book : titleResult) {
            System.out.println(book.bookInfo());
        }

        // =========================
        // Search by Author
        // =========================

        System.out.println("\n===== SEARCH AUTHOR =====");

        List<Book> authorResult =
                library.searchBookByAuthor("martin");

        for (Book book : authorResult) {
            System.out.println(book.bookInfo());
        }

        // =========================
        // Overdue Borrow Slips
        // =========================

        System.out.println("\n===== OVERDUE SLIPS =====");

        List<BorrowSlip> overdueSlips =
                library.getOverdueSlips(
                        LocalDate.now().plusDays(20)
                );

        for (BorrowSlip slip : overdueSlips) {
            System.out.println(
                    slip.displayInfo()
            );
        }
    }
}