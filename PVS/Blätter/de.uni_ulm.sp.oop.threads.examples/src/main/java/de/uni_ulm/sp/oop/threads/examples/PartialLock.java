package de.uni_ulm.sp.oop.threads.examples;

/** Demo for different locks for different parts. */
public class PartialLock {
  protected double x = 0.0;
  protected double y = 0.0;
  protected double width = 0.0;
  protected double height = 0.0;

  // empty objects just for fine granular synchronization
  protected final Object locationlock = new Object();
  protected final Object dimensionlock = new Object();

  /** returns the x-pos by using the locationlock. */
  public double getX() {
    synchronized (locationlock) {
      return x;
    }
  }

  /** returns the y-pos by using the locationlock. */
  public double getY() {
    synchronized (locationlock) {
      return y;
    }
  }

  /** adjusts the location by using the locationlock. */
  public void adjustLocation(double offx, double offy) {
    synchronized (locationlock) {
      x += offx;
      y += offy;
    }
  }

  /** returns the width by using the dimensionlock. */
  public double width() {
    synchronized (dimensionlock) {
      return width;
    }
  }

  /** returns the height by using the dimensionlock. */
  public double height() {
    synchronized (dimensionlock) {
      return height;
    }
  }

  /** sets the dimension by using the dimensionlock. */
  public synchronized void adjustDimensions(double offwidth, double offheight) {
    synchronized (dimensionlock) {
      width += offwidth;
      height += offheight;
    }
  }

}
