package week1.Service;

public class Surgery extends VetService {
    private String complexityLevel;

    public Surgery(String serviceName, double basePrice, int durationMinutes, String complexityLevel) {
        super(serviceName, basePrice, durationMinutes, "Surgery");
        this.complexityLevel = complexityLevel;
    }

    @Override
    public void performService(){
        System.out.println("Performing surgery ("+complexityLevel+"): "+serviceName+". A sterile operating room is necessary,");
    }

    @Override
    public double calculatePrice(){
        if(complexityLevel.equalsIgnoreCase("High")){
            return basePrice*1.2;
        }
        return basePrice;
    }

    public boolean isHighRisk(){
        return complexityLevel.equalsIgnoreCase("High");
    }
}
