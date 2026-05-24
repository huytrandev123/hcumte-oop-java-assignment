package org.example.service;

import org.example.model.Book;
import org.example.model.Reader;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void printBooks() {
        System.out.println("===== DANH SACH SACH =====");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printReaders() {
        System.out.println("===== DANH SACH DOC GIA =====");

        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}
