import exercise2.Book;
import exercise2.Library;
import exercise3.ValuableItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static int sumOfIntegers(List<Integer> list) {

        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static String concaten(List<String> listString) {

        return listString.stream().reduce("", (s1, s2) -> s1 + s2);

    }

    public static Integer findMin (List<ValuableItem> listval){

        return listval.stream().min(Comparator.comparing(ValuableItem::price)).map(ValuableItem::price).orElse(null);

    }
    public static double findAvg (List<ValuableItem> listavg){

        return listavg.stream().mapToDouble(ValuableItem::price).average().getAsDouble();

    }

    public static double findMedian (List<Integer> listval){

        List<Integer> sortedlist = listval.stream().sorted().toList();

        if (sortedlist.size()/2==1){
            return sortedlist.get(sortedlist.size()/2);
        }
        else {
            return (sortedlist.get(sortedlist.size()/2-1) + sortedlist.get(sortedlist.size()/2))/2.0;
        }

    }


    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(7);
        list.add(10);
        list.add(90);

        List listString = new ArrayList();
        listString.add("C");
        listString.add("IA");
        listString.add("LEL");

        List<ValuableItem> items = List.of(
                new ValuableItem("aa",5,"apple"),
                new ValuableItem("Item2", 5,"nanas"));


        //System.out.println(sumOfIntegers(list));
        //System.out.println(concaten(listString));
        System.out.println((findMin(items)));
        System.out.println((findAvg(items)));
        System.out.println((findMedian(list)));






    }
}
