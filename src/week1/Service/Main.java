package week1.Service;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        pets.add(new Dog(1, "Rex", 5, "German Shepherd"));
        pets.add(new Cat(2, "Whiskers", 3));
        owners.add(new Owner("Sabina", "87071234567"));

        boolean running = true;
        while (running) {
            System.out.println("\n--- VET CLINIC MENU ---");
            System.out.println("1. Add Dog");
            System.out.println("2. Add Cat");
            System.out.println("3. View All Pets (Polymorphism)");
            System.out.println("4. View Only Dogs (instanceof)");
            System.out.println("5. Add Owner");
            System.out.println("6. View All Owners");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addDog(); break;
                case 2: addCat(); break;
                case 3: viewPets(); break;
                case 4: showOnlyDogs(); break;
                case 5: addOwner(); break;
                case 6: viewOwners(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid option!");
            }
        }
    }

    private static void addDog() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        System.out.print("Breed: "); String breed = scanner.nextLine();
        pets.add(new Dog(id, name, age, breed));
        System.out.println("Dog added! ✅");
    }

    private static void addCat() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Age: "); int age = scanner.nextInt(); scanner.nextLine();
        pets.add(new Cat(id, name, age));
        System.out.println("Cat added! ✅");
    }

    private static void viewPets() {
        System.out.println("\n--- All Pets in Clinic ---");
        for (Pet p : pets) {
            System.out.println(p);
            p.makeSound();
        }
    }

    private static void showOnlyDogs() {
        System.out.println("\n--- Dogs Only ---");
        for (Pet p : pets) {
            if (p instanceof Dog) {
                System.out.println(p);
            }
        }
    }

    private static void addOwner() {
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        owners.add(new Owner(name, phone));
    }

    private static void viewOwners() {
        for (Owner o : owners) System.out.println(o);
    }
}