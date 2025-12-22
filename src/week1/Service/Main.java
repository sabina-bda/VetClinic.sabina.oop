package week1.Service;

import week1.Service.Pet;
import week1.Service.Owner;
import week1.Service.Vet;
import week1.Service.VetService;
import week1.Service.PetAppointment;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner(1, "Sabina", "+77072008133");
        Pet pet = new Pet(1, "Tisha", 1, "Cat", true);
        Vet vet = new Vet(1, "Dr. Alex", "Small Animals", 12);
        VetService checkup = new VetService("Check-Up", 2000);
        VetService vaccination = new VetService("Vaccination", 5000);

        PetAppointment appointment1 = new PetAppointment(1, pet, owner, vet, checkup, "2025-12-25");
        PetAppointment appointment2 = new PetAppointment(2, pet, owner, vet, vaccination, "2025-12-30");

        System.out.println(appointment1.getAppointmentSummary());
        System.out.println(appointment2.getAppointmentSummary());
        System.out.println(appointment1);
        System.out.println(appointment2);
    }
}