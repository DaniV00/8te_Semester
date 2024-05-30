package main.java.oop.util;


import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;


    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }



    public java.util.Date getTodayDate(){
        return  Calendar.getInstance().getTime();
    }

    public boolean isLeapYear(){

        if(year%4==0 && year%100!=0 || year%400==0){
        return true;
        }
        else{
            return false;

        }

        //implement Doomsday method, useful for calculating the day of the week of a date;

    }

}
