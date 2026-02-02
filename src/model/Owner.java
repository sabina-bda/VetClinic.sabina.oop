package model;

public class Owner {
    private String fullName;
    private String phone;

    public Owner(String fullName, String phone) {
        setFullName(fullName);
        setPhone(phone);
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("fullName cannot be null or empty");
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty())
            throw new IllegalArgumentException("phone cannot be null or empty");
        this.phone = phone;
    }

    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "Owner: " + fullName + " | Contact: " + phone;
    }
}