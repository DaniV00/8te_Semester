package de.uni_ulm.sp.oop.sose24.sheet10.exercise1.models;

public class Lad extends Person {

    public Lad(String name) {
        female = false;
        NAME = name;
    }

    @Override
    public String toString() {
        return "LAD { " + NAME + " }";
    }
}
