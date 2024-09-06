import exercise1.*;
import exercise3.AdditionNote;
import exercise3.ValueNode;

public class Main {

    public static void main(String[] args) {

/*        Dog dog = new Dog("Bibu",10);
        Cat catto =new Cat("Didu",20);
        Penguin pingu = new Penguin("Pingu",10,200);

        dog.print();
        catto.print();
        pingu.print();*/

        ValueNode treeL = new ValueNode(1);
        ValueNode treeR = new ValueNode(3);
        AdditionNote node = new AdditionNote(treeL, treeR);
        System.out.println(node.evaluate());








    }
}
