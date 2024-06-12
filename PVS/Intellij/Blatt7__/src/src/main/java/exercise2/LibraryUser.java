package src.main.java.exercise2;

public interface LibraryUser {
    String getName();
    String getId();
    AccessLevel getAccessLevel();

    enum AccessLevel {
        FULL, RESTRICTED, REGULAR, GUEST
    }
}

