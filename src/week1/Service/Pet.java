package week1.Service;
public class Pet {
    private int id;
    private String name;
    private int age;
    private String type;
    private boolean insured;

    public Pet(int id, String name, int age, String type, boolean insured) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.insured = insured;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isInsured() { return insured; }
    public void setInsured(boolean insured) { this.insured = insured; }

    public boolean isAdult() { return age >= 1; }

    public String getPetCategory() { return insured ? "Insured Pet" : "Uninsured Pet"; }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", insured=" + insured +
                '}';
    }
}