package model;

public class Cat extends Pet implements Adoptable{
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

    @Override
    public void adopt(){
        System.out.println(name + " has been adopted!!");
    }
}