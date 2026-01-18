package model;

public class Dog extends Pet implements Adoptable {
    private String breed;

    public Dog(int id, String name, int age, String breed) {
        super(id, name, age);
        setBreed(breed);
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be null or empty");
        }
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

    @Override
    public void adopt() {
        System.out.println(name + " has been adopted!!");
    }
}