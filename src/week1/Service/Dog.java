package week1.Service;

public class Dog extends Pet {
    private String breed;

    public Dog(int id, String name, int age, String breed) {
        super(id, name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof! 🐕");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Dog | Breed: " + breed;
    }
}