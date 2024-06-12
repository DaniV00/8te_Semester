package src.main.java.exercise2;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember implements LibraryUser {
    private final String name;
    private final String id;
    private final AccessLevel accessLevel;
    private final List<Book> borrowedBooks;

    public LibraryMember(String name, String id, AccessLevel accessLevel) {
        this.name = name;
        this.id = id;
        this.accessLevel = accessLevel;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
