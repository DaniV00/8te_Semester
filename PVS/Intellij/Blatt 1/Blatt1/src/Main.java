public class Main {
    public static void main(String[] args) {
        switch(2) {
            case 0: System.out.print("A"); break;
            case 1:
            case 2: System.out.print("B");
            case 3: System.out.print("C");
            default: System.out.print("default");
        }
    }
}