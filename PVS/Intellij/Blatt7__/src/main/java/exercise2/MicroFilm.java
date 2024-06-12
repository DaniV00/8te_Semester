package main.java.exercise2;

import java.util.ArrayList;
import java.util.List;

public class MicroFilm implements Book {
    private final String author;
    private final String title;
    private final List<String> contents;
    private int durability;
    private double rating;
    private boolean available;

    public MicroFilm(String author, String title, List<String> contents, int durability) {
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.durability = durability;
    }

    public boolean isReadable() {
        return durability > 0;
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
        if (durability > 0) {
            durability--;
            if (durability == 0) {
                contents.clear();
            }
            return contents;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public boolean isAvailable() {
        return isReadable() && available;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
