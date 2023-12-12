package Main;
import java.util.Scanner;

import Main.Equipment.Equipment;
import Main.Equipment.EquipmentManager;
import Main.User.User;
import Main.User.UserManager;

public class Main {
    public static void main(String[] args) {
        boolean isRun  = true;
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        // Create an EquipmentManager and add some equipment
        EquipmentManager equipmentManager = new EquipmentManager();
        equipmentManager.addEquipment(new Equipment("E001", "Football", 10, 20.0));
        equipmentManager.addEquipment(new Equipment("E002", "Basketball", 15, 25.0));
        equipmentManager.addEquipment(new Equipment("E003", "Volleyball", 25, 55.0));
        equipmentManager.addEquipment(new Equipment("E004", "Tenis", 35, 215.0));
        equipmentManager.addEquipment(new Equipment("E005", "Cricketball", 45, 125.0));
        UserManager userManager = new UserManager();
        while (isRun){

        // Create a UserManager and add a user
        userManager = database.initialze(userManager);
        // Get user input for making a reservation
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        while (intInp(username)||username.length()==0) {
            System.out.println("Enter a valid username");
            username = scanner.nextLine();
        }
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        User user;
        if(userManager==null){
            userManager =  new UserManager();
            userManager.addUser(new User("A" ,"a","a","a","a",1));
            user = userManager.authenticateUser("a","a");
        }else{
            user = userManager.authenticateUser(username, password);
        }

        // Authenticate user

        if (user != null) {
            // Display available equipment
            System.out.println("Available Equipment:");
            for (int i = 0; i < equipmentManager.getSize(); i++) {
                Equipment equipment = equipmentManager.getEquipmentList()[i];
                if (equipment != null) {
                    System.out.println(equipment.getEquipmentId() + " - " + equipment.getName());
                } else {
                    System.out.println("Encountered null equipment object.");
                }
            }

            // Get user input for making a reservation
            System.out.println("Enter equipment ID for reservation:");
            String equipmentId = scanner.nextLine();

            Equipment equipment = equipmentManager.findEquipmentById(equipmentId);

            if (equipment != null) { 
                System.out.println("Enter the number of hours for reservation:");
                int reservationHours = scanner.nextInt();
                System.out.println("Reservation made by: " + username);
                 equipment.updateQuantity(1);
                // Display equipment information after reservation
                System.out.println("Available Quantity after Reservation: " + equipment.getAvailableQuantity());
            } else {
                System.out.println("Equipment not found.");
            }
        } else {
            System.out.println("You are a new user");
            System.out.println("Available Equipment:");
            for (int i = 0; i < equipmentManager.getSize(); i++) {
                Equipment equipment = equipmentManager.getEquipmentList()[i];
                if (equipment != null) {
                    System.out.println(equipment.getEquipmentId() + " - " + equipment.getName());
                } else {
                    System.out.println("Encountered null equipment object.");
                }
            }

            // Get user input for making a reservation
            System.out.println("Enter equipment ID for reservation:");
            String equipmentId = scanner.nextLine();

            userManager = database.addUser(userManager, username, equipmentId, username, equipmentId, 0);
            user = userManager.authenticateUser(username, password);
            Equipment equipment = equipmentManager.findEquipmentById(equipmentId);
        
            if (equipment != null) { 
                System.out.println("Enter the number of hours for reservation:");
                int reservationHours;
                boolean is_valid= false;
                String i;
                i= scanner.nextLine();
                while (!is_valid) {                
                    try {
                            reservationHours = Integer.parseInt(i);
                            is_valid = true;
                        } catch (Exception e) {
                            System.out.println("Invalid input");
                            i= scanner.nextLine();
                        }
                }
                equipment.updateQuantity(1);
                System.out.println("Reservation made by: " + username);

                // Display equipment information after reservation
                System.out.println("Available Quantity after Reservation: " + equipment.getAvailableQuantity());
            } else {
                System.out.println("Equipment not found.");
            }
        }
        System.out.println("Enter 1 to continue or 0 to exit");
        String i = scanner.nextLine();
        int j ;
        if(intInp(i)){
             j= Integer.parseInt(i);
        }else{
            j=0;
        }
        if(j!=1){
            isRun = false;
        }
    }
    scanner.close();
    }
    static boolean intInp(String inp){
        try {
            Integer.parseInt(inp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
