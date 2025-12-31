package week1.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static ArrayList<VetService> services = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int choice;
        do{
            System.out.println("VET CLINIC SERVICE MANAGEMENT");
            System.out.println("1. Add General Service");
            System.out.println("2. Add Vaccination");
            System.out.println("3. Add Surgery");
            System.out.println("4. View all services");
            System.out.println("5. Perform all services");
            System.out.println("6. View High-Risk surgeries only");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: addGeneralService(); break;
                case 2: addVaccinationService();  break;
                case 3: addSurgeryService();  break;
                case 4: viewAllServices();  break;
                case 5: performAllServices();  break;
                case 6: viewHighRiskServices();   break;
                case 0: System.out.println("Exciting");  break;
                default: System.out.println("Invalid choice"); break;
            }
        } while(choice != 0);
    }

    private static void addGeneralService(){
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Duration: "); int duration = sc.nextInt();
        services.add(new VetService(name, price, duration, "General"));
    }

    private static void addVaccinationService(){
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Duration: "); int duration = sc.nextInt();
        sc.nextLine();
        System.out.print("Vaccination Type: "); String type = sc.nextLine();
        services.add(new VetService(name, price, duration, type));
    }

    private static void addSurgeryService(){
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Price: "); double price = sc.nextDouble();
        System.out.print("Duration: "); int duration = sc.nextInt();
        sc.nextLine();
        System.out.print("Complexity (Low/High): "); String complexity = sc.nextLine();
        services.add(new VetService(name, price, duration, complexity));
    }

    private static void viewAllServices(){
        System.out.println("LIST OF SERVICES");
        for (VetService s: services){
            System.out.println(s);
            if(s instanceof Surgery surg && surg.isHighRisk()){
                System.out.println("ATTENTION: High risk procedure!");
            }
        }
    }

    private static void performAllServices(){
        System.out.println("LIST OF SERVICES");
        for (VetService s: services){
            s.performService();
        }
    }

    private static void viewHighRiskServices(){
        System.out.println("CRITICAL SURGERY");
        for (VetService s: services){
            if(s instanceof Surgery){
                Surgery surg = (Surgery)s;
                if(surg.isHighRisk()){
                    System.out.println(surg.getServiceName()+" (Requires special monitoring");
                }
            }
        }
    }


}