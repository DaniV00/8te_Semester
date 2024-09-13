package exercise2;

public class Student {
    private final String id;
    private final String name;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
    }


    public void enrollInCourse(Course course){
        course.studentToCourse.put(name,course);
        System.out.println("The student "+ name + " has been subscribed to the course " + course.getCourseName());
    }

    public void leaveCourse(Course course){
        course.studentToCourse.remove(name);
        System.out.println("The student "+ name + " has been removed to the course " + course.getCourseName());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
