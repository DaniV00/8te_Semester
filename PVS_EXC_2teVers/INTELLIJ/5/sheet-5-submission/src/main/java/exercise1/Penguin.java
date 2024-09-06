package exercise1;

public class Penguin extends Animal{
    String name;
    int age;
    int cuteness;

    public Penguin (String name , int age, int cuteness){
        super(name,age);
        this.name = name;
        this.age= age;
        this.cuteness = cuteness;

    }

    @Override
    public void print(){
        System.out.println("Ich bin ein Penguinos, mein Name ist " + name
                + " und ich bin " + age + " Jahre alt. Mein cuteness Level liegt bei "+ cuteness);

    }
}
