package main.java.exercise2;

import java.util.HashMap;

public class Student {
    private final String id;
    private final String name;
    private HashMap <String, Course> hashCourse = new HashMap<>();

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
    }

    public String enrollCourse(Course course){
        hashCourse.put(this.id,course);
        String currentcourse = ""+ course.getCourseName();

        return "The student with id " + this.id + " and name "+ this.name + " has been enrolled into the course " + currentcourse ;
    }

    public boolean isEnrolled(){
        return hashCourse.containsKey(this.id);

    }

    public String leaveCourse(Course course){
        hashCourse.remove(this.id,course);
        String currentcourse = "" + course.getCourseName();

        return "The student with id " + this.id + " and name "+ this.name + " has left the course " + currentcourse ;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
