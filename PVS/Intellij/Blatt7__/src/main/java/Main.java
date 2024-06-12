package main.java;

import main.java.exercise3.ValuableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {


        List<Integer> intlist = new ArrayList<Integer>();
        intlist.add(1);
        intlist.add(2);
        intlist.add(7);
        intlist.add(4);
        //SUM INTEGERS IN A LIST
        int i = intlist.stream().mapToInt(Integer::intValue).sum();    //intlist.stream().mapToInt(Integer:intValue).sum(); SUMS INTEGERS IN A LIST -> list.stream().mapToInt(Integer:intValue).sum;
        System.out.println(i);
        //CONCATENATING STRINGS
        List<String> strlist = new ArrayList<String>();
        strlist.add("ciao");
        strlist.add("come");
        strlist.add("stai");
        strlist.add("bello");
        strlist.stream().forEach(System.out::print);                   //Concat Strings

        List<ValuableItem> valList = new ArrayList<ValuableItem>();
        valList.add(new ValuableItem("ferrari",100,"car"));
        valList.add(new ValuableItem("lamb",110,"car"));
        valList.add(new ValuableItem("apple",3,"fruit"));
        valList.add(new ValuableItem("banananananana",5,"fruit"));
        AtomicInteger lowPrice = new AtomicInteger(valList.get(1).price());
        valList.stream().forEach(valuableItem -> {
            int tempPrice = valuableItem.price();
            if(tempPrice < lowPrice.get()){
                lowPrice.set(tempPrice);
            }
        });
        System.out.println(lowPrice);



    }
}
