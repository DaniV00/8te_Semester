package main.java.exercise2;

import java.util.List;

public class ElectronicBook implements Book {
    private final String author;
    private final String title;
    private final List<String> contents;
    private double rating;
    private boolean available;

    public ElectronicBook(String author, String title, List<String> contents) {
        this.author = author;
        this.title = title;
        this.contents = contents;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    @Override
    public double getRating() {
        return this.rating;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
