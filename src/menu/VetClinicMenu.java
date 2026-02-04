package menu;

import database.VetClinicDAO;
import model.Cat;
import model.Dog;
import model.Owner;
import model.Pet;

import java.util.List;
import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private final VetClinicDAO dao = new VetClinicDAO();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("Veterinary Clinic started!");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> viewAllPets();
                case 3 -> updatePet();
                case 4 -> deletePet();
                case 5 -> searchByName();
                case 6 -> searchByAgeRange();
                case 7 -> addOwner();
                case 8 -> viewAllOwners();
                case 9 -> viewPetById();
                case 10 -> searchPetsByOwnerId();
                case 0 -> {
                    System.out.println("\nGoodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("          VETERINARY CLINIC");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println(" 1   →   Add a pet");
        System.out.println(" 2   →   View all pets");
        System.out.println(" 3   →   Update pet");
        System.out.println(" 4   →   Delete pet");
        System.out.println(" 5   →   Search by name");
        System.out.println(" 6   →   Search by age range");
        System.out.println(" 7   →   Add a new owner");
        System.out.println(" 8   →   View all owners");
        System.out.println(" 9   →   View pet by ID");
        System.out.println("10   →   Search pets by owner ID");
        System.out.println(" 0   →   Exit");
        System.out.println("═══════════════════════════════════════════════");
        System.out.print("Enter your choice → ");
    }

    @Override
    public void run() {
        start();
    }

    private int getUserChoice() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    private void addPet() {
        System.out.println("\n=== Adding a new pet ===");

        System.out.print("Type (cat / dog): ");
        String type = scanner.nextLine().trim().toLowerCase();

        Pet pet;
        if ("cat".equals(type)) {
            pet = new Cat();
        } else if ("dog".equals(type)) {
            pet = new Dog();
        } else {
            System.out.println("Invalid type. Operation cancelled.");
            return;
        }

        System.out.print("Name: ");
        pet.setName(scanner.nextLine().trim());

        System.out.print("Breed: ");
        pet.setBreed(scanner.nextLine().trim());

        System.out.print("Age: ");
        pet.setAge(getUserChoice());

        System.out.print("Gender (male / female / unknown): ");
        pet.setGender(scanner.nextLine().trim());

        System.out.print("Color: ");
        pet.setColor(scanner.nextLine().trim());

        System.out.print("Vaccinated? (yes / no): ");
        String vac = scanner.nextLine().trim().toLowerCase();
        pet.setVaccinated("yes".equals(vac) || "y".equals(vac));

        System.out.print("Owner ID: ");
        pet.setOwnerId(getUserChoice());

        if (dao.addPet(pet)) {
            System.out.println("Pet added successfully! ID: " + pet.getPetId());
        } else {
            System.out.println("Failed to add pet.");
        }
    }

    private void viewAllPets() {
        List<Pet> pets = dao.getAllPets();
        if (pets.isEmpty()) {
            System.out.println("No pets registered yet.");
            return;
        }
        System.out.println("\nAll pets:");
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    private void updatePet() {
        System.out.print("Pet ID to update: ");
        int id = getUserChoice();

        Pet pet = dao.getPetById(id);
        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.println("Current pet: " + pet);

        System.out.print("New name (Enter to keep): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            pet.setName(name);
        }

        if (dao.updatePet(pet)) {
            System.out.println("Updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    private void deletePet() {
        System.out.print("Pet ID to delete: ");
        int id = getUserChoice();

        Pet pet = dao.getPetById(id);
        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.println("Delete this pet? " + pet);
        System.out.print("yes/no: ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(confirm) || "y".equals(confirm)) {
            if (dao.deletePet(id)) {
                System.out.println("Deleted successfully.");
            } else {
                System.out.println("Delete failed.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void searchByName() {
        System.out.print("Part of name: ");
        String fragment = scanner.nextLine().trim();

        List<Pet> found = dao.searchPetsByName(fragment);
        if (found.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            System.out.println("\nFound " + found.size() + " pets:");
            for (Pet p : found) {
                System.out.println(p);
            }
        }
    }

    private void searchByAgeRange() {
        System.out.print("Min age: ");
        int min = getUserChoice();

        System.out.print("Max age: ");
        int max = getUserChoice();

        List<Pet> found = dao.searchPetsByAge(min, max);
        if (found.isEmpty()) {
            System.out.println("No pets in this age range.");
        } else {
            System.out.println("\nFound " + found.size() + " pets:");
            for (Pet p : found) {
                System.out.println(p);
            }
        }
    }

    private void addOwner() {
        System.out.println("\n=== Adding a new owner ===");

        System.out.print("Full name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Address (optional, press Enter to skip): ");
        String address = scanner.nextLine().trim();

        System.out.print("Email (optional, press Enter to skip): ");
        String email = scanner.nextLine().trim();

        Owner owner = new Owner();
        owner.setFullName(fullName);
        owner.setPhone(phone);
        owner.setAddress(address.isEmpty() ? null : address);
        owner.setEmail(email.isEmpty() ? null : email);

        if (dao.addOwner(owner)) {
            System.out.println("Owner added successfully!");
            System.out.println("New owner ID: " + owner.getOwnerId());
            System.out.println("You can now use this ID when adding pets.");
        } else {
            System.out.println("Failed to add owner. Check console for details.");
        }
    }

    private void viewAllOwners() {
        List<Owner> owners = dao.getAllOwners();
        if (owners.isEmpty()) {
            System.out.println("No owners registered yet.");
            return;
        }

        System.out.println("\nAll owners in the clinic:");
        System.out.println("─────────────────────────────────────────────────");
        for (Owner o : owners) {
            System.out.printf("ID: %-4d | Name: %-20s | Phone: %s%n",
                    o.getOwnerId(), o.getFullName(), o.getPhone());
        }
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("Use any of these IDs when adding a pet.");
    }

    private void viewPetById() {
        System.out.print("Enter pet ID to view → ");
        int id = getUserChoice();

        Pet pet = dao.getPetById(id);
        if (pet == null) {
            System.out.println("Pet with ID " + id + " not found.");
        } else {
            System.out.println("\nPet details:");
            System.out.println(pet);
            System.out.println("Owner ID: " + pet.getOwnerId());
        }
    }

    private void searchPetsByOwnerId() {
        System.out.print("\nEnter owner ID to search pets → ");
        int ownerId = getUserChoice();

        List<Pet> pets = dao.getPetsByOwnerId(ownerId);
        if (pets.isEmpty()) {
            System.out.println("No pets found for owner ID " + ownerId);
        } else {
            System.out.println("\nPets for owner ID " + ownerId + ":");
            System.out.println("───────────────────────────────────────────────");
            for (Pet p : pets) {
                System.out.println(p);
            }
            System.out.println("───────────────────────────────────────────────");
        }
    }
}