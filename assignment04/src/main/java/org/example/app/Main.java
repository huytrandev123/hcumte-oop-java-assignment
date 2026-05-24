package org.example.app;

import org.example.model.Book;
import org.example.model.Lecturer;
import org.example.model.Student;
import org.example.service.Library;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        // Books
        Book b1 = new Book(
                "B001",
                "Java Core",
                "James Gosling",
                2020,
                10
        );

        Book b2 = new Book(
                "B002",
                "OOP Design",
                "Robert Martin",
                2022,
                5
        );

        library.addBook(b1);
        library.addBook(b2);

        // Readers
        Student s1 = new Student(
                "S001",
                "Nguyen Van A",
                "a@gmail.com",
                "SV123"
        );

        Student s2 = new Student(
                "S002",
                "Tran Van B",
                "b@gmail.com",
                "SV456"
        );

        Lecturer l1 = new Lecturer(
                "L001",
                "Le Van C",
                "c@gmail.com",
                "Information Technology"
        );

        library.addReader(s1);
        library.addReader(s2);
        library.addReader(l1);

        library.printBooks();

        System.out.println();

        library.printReaders();
    }
}
