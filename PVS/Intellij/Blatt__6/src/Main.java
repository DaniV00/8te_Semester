public class Main {

    public int getMax(int [] arr ){
        int max = arr[0];
        for(int i =0; i< arr.length; i++){
            if(arr[i] > max){
                max = arr[i];

            }
            else{

            }
        }
        return max;
    }

    public void printdiamond(int n){


        for(int i =0; i< n; i++){



        }


    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main m = new Main();
        int [] arr = {111,22,3,22221312,52222};
        System.out.print(m.getMax(arr));


    }



}