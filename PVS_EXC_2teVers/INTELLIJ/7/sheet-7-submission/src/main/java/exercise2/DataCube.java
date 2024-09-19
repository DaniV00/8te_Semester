package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataCube implements Book {
    private final List<ElectronicBook> books;

    public DataCube(List<ElectronicBook> books) {
        this.books = books;
    }

    @Override
    public String getAuthor() {
        return books.stream()
                .map(ElectronicBook::getAuthor)
                .collect(Collectors.joining("; "));
    }

    @Override
    public String getTitle() {
        return books.stream()
                .map(ElectronicBook::getTitle)
                .collect(Collectors.joining("; "));
    }

    @Override
    public List<String> getContents() {
        return books.stream()
                .map(ElectronicBook::getContents)
                .map(x -> String.join("; ", x))
                .toList();
    }

    @Override
    public double getRating() {
        return books.stream()
                .mapToDouble(ElectronicBook::getRating)
                .average()
                .orElse(0);
    }

    @Override
    public boolean isAvailable() {
        return books.stream()
                .allMatch(ElectronicBook::isAvailable);
    }

    @Override
    public void rateBook(BookRater rater) {
        books.forEach(b->rater.rate(b));
    }
}
