package lab11;

import java.util.Scanner;

public class lab11 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        boolean sent = true;
        int resp;
        blueRayCollection collection = new blueRayCollection();

        System.out.println("[BlueRay Disk Collection]");
        while (sent){
            System.out.print(
                    "1. Add to collection\n" + 
                    "2. See collection\n" + 
                    "3. Quit\n" + 
                    "Enter option: ");
            resp = scan.nextInt();
            System.out.println();
            scan.nextLine();

            switch (resp){

                case 1 -> {
                    try {
                        System.out.print("Enter disk title: ");
                        String title = scan.nextLine();
                    
                    
                    
                    System.out.print("Enter director name: ");
                    String director = scan.nextLine();

                    System.out.print("Enter year of release: ");
                    int year = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter price of disk: $");
                    double cost = scan.nextDouble();
                    scan.nextLine();

                    collection.addDisk(title,director,year,cost);

                    System.out.println("BlueRay Disk added to collection.\n");
                } catch (NumberFormatException e){
                    String message = e.getMessage();
                    //regex used . means any * means zero or more of the character in this case its 0-9 \\ used twice because java \d means any digit and .* means any of the characters after the digit basically just lets it accept a digit anywhere and this is a pass 
                      if (message != null && message.matches(".*\\d.*")) {
                        System.out.println("Error: Price must be a number!\n");
                    } else {
                        System.out.println("Error: Year of release must be a whole number!\n");
                    }
                }
            }
                case 2 -> {
                    String allDisks = collection.showAll();
                    if (allDisks.isEmpty()){
                        System.out.println("The collection is empty.\n");
                    } else {
                        System.out.println("Here's your current collection: ");
                        System.out.println(allDisks + "\n");
                    }
                }
                case 3 -> {
                    System.out.println("Shutting off...");
                    sent = false;
                }
             
                default -> System.out.print("Invalid option \n");
            }
        }
    }
}
