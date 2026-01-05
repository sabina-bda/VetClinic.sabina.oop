package week1.Service;

public class Owner {
    private String fullName;
    private String phone;

    public Owner(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Owner: " + fullName + " | Contact: " + phone;
    }
}