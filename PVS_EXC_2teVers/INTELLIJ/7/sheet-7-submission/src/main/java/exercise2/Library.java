package exercise2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Library {
    private final Set<LibraryUser> users;
    private final Set<Book> books;

    public Library(Set<LibraryUser> users, Set<Book> books) {
        this.users = users;
        this.books = books;
    }

    public void applyRatings(BookRater rater) {
      books.stream().forEach(book -> rater.rate(book));
    }

    public List <Book> formatbooks(BookFormatter formatter) {

       books.stream().forEach(book -> formatter.format(book));

       return books.stream().toList();
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
