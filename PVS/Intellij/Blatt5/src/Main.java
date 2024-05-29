public class Main {
    public static void main(String[] args) {
        char[] letters = new char[]{'a','u','b','d','f','s','k'};
        char to_find = 'k';
        for(int i=0; i <= letters.length; i++){
            if (letters[i] == to_find) {
                System.out.println("the letter you are searching for is " + to_find+ " and the position is " + i );
                break;

            }
            else{
            }
        }


    }


}