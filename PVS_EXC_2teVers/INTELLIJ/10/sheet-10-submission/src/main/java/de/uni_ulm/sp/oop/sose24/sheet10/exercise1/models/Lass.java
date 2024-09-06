package de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models;

public class Lass extends Person {

    public Lass(String name) {
        female = true;
        NAME = name;
    }

    @Override
    public String toString() {
        return "LASS { " + NAME + " }";
    }
}
