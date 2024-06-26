package main.java;

import main.java.exercise1.Animal;
import main.java.exercise1.Dog;
import main.java.exercise1.Penguin;
import main.java.exercise3.AdditionNode;
import main.java.exercise3.MultiplicationNode;
import main.java.exercise3.ValueNode;
import main.java.oop.util.Date;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        //Penguin peng = new Penguin("Ram",24,10);
        //Animal ram = new Animal("Ram",24);
        Dog dani = new Dog("Dani",24,true);
       // Dog ram = new Dog("Ram",25,false);
        //Penguin penwing = new Penguin("Dani",24,10);
       // Date dateinfo = new Date(2000,5,25);
        //System.out.println(dani.doesDogPee());
        System.out.println(dani.doesDogPee());

       // MultiplicationNode tree = new MultiplicationNode(new ValueNode(21),new AdditionNode(new ValueNode(1),new ValueNode(1)));

        //System.out.println(tree.evaluate());
        //System.out.println(tree.prettyprint());



    }
}
