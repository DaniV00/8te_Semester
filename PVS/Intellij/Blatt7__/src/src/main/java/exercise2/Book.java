package src.main.java.exercise2;

import java.util.List;

public interface Book {
    String getAuthor();
    String getTitle();
    List<String> getContents();
    double getRating();
    boolean isAvailable();
}
