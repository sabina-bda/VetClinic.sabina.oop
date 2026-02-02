package model;

public class Cat extends Pet {

    private boolean indoor;

    public Cat() {
        super();
    }

    public Cat(String name, String breed, int age, String gender, String color, boolean vaccinated, int ownerId, boolean indoor) {
        super(name, breed, age, gender, color, vaccinated, ownerId);
        this.indoor = indoor;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    @Override
    public String toString() {
        return "Cat{" +
                super.toString().substring(5) +
                ", indoor=" + indoor +
                '}';
    }
}