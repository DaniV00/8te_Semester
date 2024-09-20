import exercise2.Book;
import exercise2.Library;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int sumOfIntegers(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static String concaten(List<String> listString) {

        return listString.stream().reduce("",String::concat);

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
        listString.add("O");


        //System.out.println(sumOfIntegers(list));
        System.out.println(concaten(listString));





    }
}
