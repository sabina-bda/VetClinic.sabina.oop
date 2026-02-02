package model;

public abstract class Pet {
    private int petId;
    private String name;
    private String breed;
    private int age;
    private String gender;
    private String color;
    private boolean vaccinated;
    private int ownerId;

    public Pet() {
    }

    public Pet(String name, String breed, int age, String gender, String color, boolean vaccinated, int ownerId) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.vaccinated = vaccinated;
        this.ownerId = ownerId;
    }

    // Геттеры и сеттеры (обязательно все!)
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + petId +
                ", name='" + name + '\'' +
                ", type=" + (this instanceof Cat ? "Cat" : "Dog") +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", vaccinated=" + vaccinated +
                ", ownerId=" + ownerId +
                '}';
    }
}