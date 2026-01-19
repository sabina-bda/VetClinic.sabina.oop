package menu;

import model.*;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class VetClinicMenu implements Menu{
    private ArrayList<Pet> pets=new ArrayList<>();
    private ArrayList<Owner> owners=new ArrayList<>();
    private Scanner sc=new Scanner(System.in);

    public VetClinicMenu() {
        pets.add(new Dog(1, "Rex", 5, "German Shepheds"));
        pets.add(new Cat(2,"Tisha", 2));
        owners.add(new Owner("Sabina","877777777777"));
    }

    @Override
    public void displayMenu() {
        System.out.println("--- VET CLINIC ---");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. View Pets");
        System.out.println("0. Exit");
    }

    @Override
    public void run(){
        boolean running=true;
        while(running){
            displayMenu();
            try{
                int choice=Integer.parseInt(sc.nextLine());
                switch(choice){
                    case 1: addDog(); break;
                    case 2: addCat(); break;
                    case 3: viewPets(); break;
                    case 0: running=false; break;
                    default: throw new InvalidInputException("Invalid menu option");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number");
            } catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }catch (InvalidInputException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    private void addDog(){
        System.out.print("ID: ");
        int id=Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name=sc.nextLine();

        System.out.print("Age: ");
        int age=Integer.parseInt(sc.nextLine());

        System.out.print("Breed: ");
        String breed=sc.nextLine();

        pets.add(new Dog(id,name,age,breed));
        System.out.println("Dog added!");
    }

    private void addCat(){
        System.out.print("ID: ");
        int id=Integer.parseInt(sc.nextLine());

        System.out.print("Name: ");
        String name=sc.nextLine();

        System.out.print("Age: ");
        int age=Integer.parseInt(sc.nextLine());

        pets.add(new Cat(id, name, age));
        System.out.println("Cat added!");
    }

    private void viewPets(){
        for(Pet p:pets){
            System.out.println(p);
            p.makeSound();
        }
    }
}
