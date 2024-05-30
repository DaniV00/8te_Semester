package main.java.exercise1;

public class Dog extends Animal {

    boolean pees;

    public Dog(String name, int age,boolean pees){
        super(name, age);
        this.pees = pees;
    }

public boolean doesDogPee(){
        return pees;
}


}
