package exercise2;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private final Set<LibraryUser> users;
    private final Set<Book> books;

    public Library(Set<LibraryUser> users, Set<Book> books) {
        this.users = users;
        this.books = books;
    }

    public void applyRatings(BookRater rater) {
        for (int i = 0; i < books.size(); i++) {
            rater.rate(books.stream().iterator().next());
        }
    }

    public void addUser(LibraryUser user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Set<LibraryUser> getUsers() {
        return new HashSet<>(users);
    }

    public Set<Book> getBooks() {
        return new HashSet<>(books);
    }
}
