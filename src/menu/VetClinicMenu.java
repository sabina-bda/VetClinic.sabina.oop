package menu;

import database.VetClinicDAO;
import model.Cat;
import model.Dog;
import java.util.Scanner;

public class VetClinicMenu {
    private final VetClinicDAO dao = new VetClinicDAO();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n===== VET CLINIC MENU =====");
            System.out.println("1. Add Dog");
            System.out.println("2. Add Cat");
            System.out.println("3. View All Pets");
            System.out.println("4. Update Pet Information");
            System.out.println("5. Delete Pet from Registry");
            System.out.println("0. Exit");
            System.out.println("===========================");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Name: "); String name = sc.next();
                    System.out.print("Age: "); int age = sc.nextInt();
                    System.out.print("Breed: "); String breed = sc.next();
                    dao.addDog(new Dog(id, name, age, breed));
                }
                case 2 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Name: "); String name = sc.next();
                    System.out.print("Age: "); int age = sc.nextInt();
                    dao.addCat(new Cat(id, name, age));
                }
                case 3 -> dao.viewAllPets();
                case 4 -> {
                    System.out.print("ID to update: "); int id = sc.nextInt();
                    System.out.print("New Name: "); String name = sc.next();
                    System.out.print("New Age: "); int age = sc.nextInt();
                    dao.updatePet(id, name, age);
                }
                case 5 -> {
                    System.out.print("ID to delete: "); int id = sc.nextInt();
                    dao.deletePet(id);
                }
            }
        }
    }
}