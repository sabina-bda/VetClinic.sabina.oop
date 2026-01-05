package week1.Service;
public class Pet {
    private int id;
    protected String name;
    protected int age;

    public Pet(int id, String name, int age) {
        this.id = id;
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else this.name = "Unknown";
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else this.age = 0;
    }

    public void makeSound() {
        System.out.println("The pet makes a sound");
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }
}