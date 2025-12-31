package week1.Service;

public class VetService {
    protected String serviceName;
    protected double basePrice;
    protected int durationMinutes;
    protected String category;

    public VetService(String serviceName, double basePrice, int durationMinutes, String category) {
        this.serviceName = serviceName;
        this.basePrice = basePrice;
        this.durationMinutes = durationMinutes;
        this.category = category;
    }

    public void performService() {
        System.out.println("Performing Vet Service: "+ serviceName);
    }

    public double calculatePrice() {
        return basePrice;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return "["+category+"]"+serviceName+" | Price: "+calculatePrice()+"tg : Duration: "+durationMinutes+" minutes";
    }
}