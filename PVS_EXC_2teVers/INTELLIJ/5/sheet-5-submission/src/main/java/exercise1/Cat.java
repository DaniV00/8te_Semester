package exercise1;

public class Cat extends Animal {
    String name;
    int age;

    public Cat (String name , int age){
        super(name,age);
        this.name = name;
        this.age= age;

    }

    @Override
    public void print(){
        System.out.println("Ich bin ein Catto, mein Name ist " + name
                + " und ich bin " + age + " Jahre alt.");

    }
}
