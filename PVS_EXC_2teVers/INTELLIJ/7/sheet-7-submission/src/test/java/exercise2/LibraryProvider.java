package exercise2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LibraryProvider {
    public static Library[] provideLibrary() {
        Set<Book> books = new HashSet<>();
        books.add(new ElectronicBook("MrLegitAuthor", "Top 3 Numbers", Collections.singletonList("Number 1: two, Number 2: 4, Number 3: three")));
        books.add(new ElectronicBook("Author2", "Test Book 4", Collections.singletonList("Test")));
        books.add(new ElectronicBook("Author1", "Test Book 2", Collections.singletonList("Test")));
        books.add(new ElectronicBook("Author1", "Test Book 1", Collections.singletonList("Test")));
        books.add(new ElectronicBook("Author1", "Test Book 3", Collections.singletonList("Test")));

        Set<LibraryUser> users = new HashSet<>();
        users.add(new LibraryMember("Lars", "42", LibraryUser.AccessLevel.FULL));
        users.add(new LibraryMember("Mr. Guy", "43", LibraryUser.AccessLevel.REGULAR));

        return new Library[] {
                new Library(users, books)
        };
    }
}
