package main.java;

import main.java.exercise2.*;
import main.java.exercise4.Flight;
import main.java.exercise4.FlightSchedule;
import main.java.exercise4.Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.*;
//import main.java.exercise2.Student;

public class Main {


    public static void main(String[] args) {

        /*Student dani = new Student("1","Dani",24);
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
        java.addToStudents(studentsOfPvS);*/
       // ram.leaveCourse(PvS);

       // System.out.println(String.valueOf(3));

       // System.out.println(ram.isEnrolled(PvS));   //Ram is NOT enrolled on PvS, because he got added on the list studentOfPvS BUT got removed with the ".leavecourse(Course)" method


        //TODO TEST FLIGHT DATA
        Passenger daniele = new Passenger("1","dani","dani@mail.com");
        Passenger ramm = new Passenger("2","ram","aram@mail.com");
        Passenger oscar = new Passenger("3","Oscar","oschi@mail.com");
        LocalDateTime departure = LocalDateTime.of(2021,1,1,5,0);
        LocalDateTime arrival = LocalDateTime.of(2021,1,3,10,0);
        FlightSchedule sched = new FlightSchedule();
        Flight bahamas = new Flight("1","Frankfurt","Bahamas",departure,arrival);
        Flight london = new Flight("2","Frankfurt","London",departure,arrival);
        sched.addFlight(bahamas);
        sched.addFlight(london);
        sched.makeReservation("1",daniele);
        sched.makeReservation("1",ramm);
       // sched.makeReservation("2",oscar);
        bahamas.boardFlight(daniele);
    //    System.out.println(bahamas.getMissingPassengers());
        System.out.println(sched.getPassengerRoutes());

        List<String> intlist = new ArrayList<>();
        intlist.add("1");
        intlist.add("2");

        System.out.println(intlist.toString());


        //System.out.println(bahamas.boardFlight(daniele));








    }

    public void example(List<Integer> integerList){



    }

    public void example(List<Integer> integerList,List<String> stringList){     //Initial method does not override, because the lists "integerList" and "stringList" have two different data types
                                                                                //NOTE: To override a method, the same data type should be used, in this case, a List of Integers


    }



}