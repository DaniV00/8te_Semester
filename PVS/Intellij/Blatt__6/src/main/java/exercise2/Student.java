package main.java.exercise2;

import java.util.HashMap;

public class Student {
    private final String id;
    private final String name;
    //Course course = new Course();

    public Student(String id, String name, int age) {
        //super(id,name);
        this.name=name;
        this.id = id;
    }

    public String enrollCourse(Course course){
        course.hashCourse.put(this.id,course);
        String currentcourse = ""+ course.getCourseName();

        return "The student with id " + this.id + " and name "+ this.name + " has been enrolled into the course " + currentcourse ;
    }

    public boolean isEnrolled(Course course){

        return course.hashCourse.containsKey(id);
    }

    public void leaveCourse(Course course){
        course.hashCourse.remove(id);
        //String currentcourse = "" + course.getCourseName();
        System.out.println("The student with id " + this.id + " and name "+ this.name + " has left the course " + course.hashCourse.get(id) );


        //return ;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
