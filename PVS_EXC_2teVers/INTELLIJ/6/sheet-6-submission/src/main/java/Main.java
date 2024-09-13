import exercise2.Course;
import exercise2.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student dani = new Student("1","Dani",24);
        Student osch = new Student("1","Oschi",25);
        Student ram = new Student("1","Ram",27);
        Course PvS = new Course("01","PvS");
        Course Bio = new Course("02","Bio");
        dani.enrollInCourse(PvS);
        dani.leaveCourse(PvS);
        List listStud = new ArrayList();
        listStud.add(dani);
        listStud.add(osch);
        listStud.add(ram);
        PvS.addToStudents(listStud);
        System.out.println(PvS.studentToCourse.keySet());
        System.out.println(Bio.studentToCourse.keySet());

    }
}