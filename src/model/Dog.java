package model;

public class Dog extends Pet {

    private String trainingLevel;

    public Dog() {
        super();
    }

    public Dog(String name, String breed, int age, String gender, String color, boolean vaccinated, int ownerId, String trainingLevel) {
        super(name, breed, age, gender, color, vaccinated, ownerId);
        this.trainingLevel = trainingLevel;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    @Override
    public String toString() {
        return "Dog{" +
                super.toString().substring(5) +
                ", trainingLevel='" + trainingLevel + '\'' +
                '}';
    }
}