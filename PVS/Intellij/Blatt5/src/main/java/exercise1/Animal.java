package main.java.exercise1;

public class Animal {
   private String name;
   private int age;

   public Animal(String name, int age) {
       this.name = name;
       this.age = age;
   }

   public String getName() {
       return name;
   }

   public int getAge() {
       return age;
   }

   public void print() {
      System.out.println("Ich bin ein Tier, mein Name ist " + name
            + " und ich bin " + age + " Jahre alt.");
  }
}