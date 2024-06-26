package main.java.exercise2;

import java.util.HashMap;
import java.util.List;

public class Course {
    private final String courseId;
    private final String courseName;
    public HashMap<String, Course> hashCourse = new HashMap<>();



    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void addToStudents(List<Student> students) {
        for (Student student : students) {

            hashCourse.put(student.getId(),hashCourse.get(getCourseId()));

        }
        getHash();


    }

    public void removeStudents(List<Student> students) {
        for (Student student : students) {
            hashCourse.remove(student.getId(),hashCourse.get(courseId));
        }
    }

    public String getHash(){

        return hashCourse.keySet().toString();

    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
