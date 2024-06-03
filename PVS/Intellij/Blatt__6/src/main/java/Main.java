package main.java;

import main.java.exercise2.*;

import java.util.ArrayList;
import java.util.List;
//import main.java.exercise2.Student;

public class Main {

    public static void main(String[] args) {

        Student dani = new Student("1","Dani",24);
        Student ram = new Student("2","Ram",25);
        Student oscar = new Student("3","Oscar",26);
        Course PvS = new Course("01","PvS");
        Course java = new Course("02","Java");
        List<Student> studentsOfPvS = new ArrayList<Student>();
        List<Student> studentsOfJava = new ArrayList<Student>();
        studentsOfPvS.add(dani);
        studentsOfPvS.add(ram);
        studentsOfPvS.add(oscar);
        studentsOfJava.add(oscar);
        PvS.addToStudents(studentsOfPvS);
        java.addToStudents(studentsOfPvS);
        ram.leaveCourse(PvS);

        //System.out.println(ram.enrollCourse(PvS));

        System.out.println(ram.isEnrolled(PvS));   //Ram is NOT enrolled on PvS, because he got added on the list studentOfPvS BUT got removed with the ".leavecourse(Course)" method


    }



}