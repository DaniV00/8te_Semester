package main.java.exercise1;

public class Penguin extends Animal{

    int cute = 0;
    public Penguin(String name, int age, int cuteness) {
        super(name, age);
        cute = cuteness;
    }



    @Override
    public void print(){
        String animal = "Penguin";
        System.out.println("Ich bin ein " + animal +  " , mein Name ist " + this.getName()
                + " und ich bin " + this.getAge() + " Jahre alt. Mein cuteness level liegt bei " + cute);

    }

}
