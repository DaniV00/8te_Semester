package main.java;

import main.java.exercise2.*;
//import main.java.exercise2.Student;

public class Main {

    public static void main(String[] args) {

        Student dani = new Student("1","Dani",24);
        Student ram = new Student("2","Ram",25);
        Course PvS = new Course("01","PvS");
        System.out.println(dani.enrollCourse(PvS));
        System.out.println(ram.enrollCourse(PvS));
        System.out.println(dani.leaveCourse(PvS));
        System.out.println(ram.isEnrolled());

    }



}