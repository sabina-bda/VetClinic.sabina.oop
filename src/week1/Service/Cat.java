package week1.Service;

public class Cat extends Pet {
    public Cat(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! 🐈");
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Cat";
    }
}