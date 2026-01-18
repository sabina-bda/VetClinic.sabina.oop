package model;
public abstract class Pet {
    private int id;
    protected String name;
    protected int age;

    public Pet(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be a positive integer");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name must not be empty");
        }
        this.name = name;
    }

    public void setAge(int age){
        if (age <= 0) {
            throw new IllegalArgumentException("age must be a positive integer");
        }
        this.age = age;
    }

    public abstract void makeSound();
}