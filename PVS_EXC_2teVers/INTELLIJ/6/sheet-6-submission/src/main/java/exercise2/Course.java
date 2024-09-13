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
    }

    public void removeStudents (List<Student> students){
        students.forEach(s -> {
                Course course = new Course(this.courseId,this.courseName);
                if(course.getCourseId().equals(studentToCourse.get(s.getName()).getCourseId())){
                    studentToCourse.remove(s.getName(),studentToCourse.get(s.getName()));
                }
            });

    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}
