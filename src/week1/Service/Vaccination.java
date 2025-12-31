package week1.Service;

public class Vaccination extends VetService {
    private String vaccineType;

    public Vaccination(String serviceName, double basePrice, int durationMinutes, String vaccineType) {
        super(serviceName, basePrice, durationMinutes, "Vaccination");
        this.vaccineType = vaccineType;
    }

    @Override
    public void performService() {
        System.out.println("Administration of the vaccine "+vaccineType+" service for "+ serviceName);
    }

    @Override
    public double calculatePrice() {
        return basePrice+1500;
    }
    public String getVaccineType() {
        return vaccineType;
    }
}
