package main.java.exercise2;

public class Librarian implements LibraryUser {
    private final String name;
    private final String id;
    private final AccessLevel accessLevel = AccessLevel.FULL;

    public Librarian(String name, String id) {
        this.name = name;
        this.id = id;
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
}
