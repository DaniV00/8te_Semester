package exercise1;

public class Dog extends Animal {
    String name;
    int age;

    public Dog (String name , int age){
     super(name,age);
     this.name = name;
     this.age= age;

    }

    @Override
public void print(){
        System.out.println("Ich bin ein Doggo, mein Name ist " + name
                + " und ich bin " + age + " Jahre alt.");

    }


}
