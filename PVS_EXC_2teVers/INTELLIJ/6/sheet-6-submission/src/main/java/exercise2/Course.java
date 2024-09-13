package exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Course {
    private final String courseId;
    private final String courseName;
    public HashMap <String,Course> studentToCourse = new HashMap();

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void addToStudents (List<Student> students){
        Course course = new Course(this.courseId,this.courseName);
        students.forEach(s -> {
            studentToCourse.put(s.getName(),course);
        });

        //System.out.println();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
