package main.java.exercise3;

public record Point(int x, int y) {
    public double distanceSquared(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Other point cannot be null");
        }
        int diffX = this.x() - other.x();
        int diffY = this.y() - other.y();

        return diffX * diffX + diffY * diffY;
    }
}
