package week1.Service;

public class PetAppointment {
    private int appointmentId;
    private Pet pet;
    private Owner owner;
    private Vet vet;
    private VetService service;
    private String date;

    public PetAppointment(int appointmentId, Pet pet, Owner owner, Vet vet, VetService service, String date) {
        this.appointmentId = appointmentId;
        this.pet = pet;
        this.owner = owner;
        this.vet = vet;
        this.service = service;
        this.date = date;
    }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public Vet getVet() { return vet; }
    public void setVet(Vet vet) { this.vet = vet; }

    public VetService getService() { return service; }
    public void setService(VetService service) { this.service = service; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getAppointmentSummary() {
        return pet.getName() + " (owner: " + owner.getName() + ") with Dr. " +
                vet.getName() + " for " + service.getName() + " on " + date;
    }

    @Override
    public String toString() {
        return "PetAppointment{" +
                "appointmentId=" + appointmentId +
                ", pet=" + pet +
                ", owner=" + owner +
                ", vet=" + vet +
                ", service=" + service +
                ", date='" + date + '\'' +
                '}';
    }
}