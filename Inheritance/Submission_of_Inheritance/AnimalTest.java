import java.util.*;

// Superclass Animal
class Animal {
    private String name;
    private int age;
    
    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    // Getters and setters for name and age
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Subclass Dog
class Dog extends Animal {
    private String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age);  // Calling the constructor of the superclass (Animal)
        this.breed = breed;
    }

    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public String getBreed() {
        return breed;
    }
}

// Subclass Cat
class Cat extends Animal {
    // Constructor
    public Cat(String name, int age) {
        super(name, age);
    }

    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    // Constructor
    public Bird(String name, int age) {
        super(name, age);
    }

    // Overriding makeSound method
    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }
}

// Main class to test the hierarchy
public class AnimalTest {
    public static void main(String[] args) {
        // Create objects for Dog, Cat, and Bird
        Animal dog = new Dog("Buddy", 3, "Golden Retriever");
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        // Call makeSound on each object
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
