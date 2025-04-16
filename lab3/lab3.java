//Because all of my files are inside of folders I have to use package and the the folder name.
package lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class lab3 {
    public static void main(String[] args){
        //setting up the scanner
        Scanner scan = new Scanner(System.in);

        //initializing the array list
        ArrayList<String[]> phonebook = new ArrayList<>();

        //used for selection in thermain loop
        int resp;

        String name;
        String phone;
        //the list that then gets inserted to phonebook
     
        
        String respW;

        //sentinel value in the main loop
        boolean sent = true;

        //too keep the current iterations of people added
        //int i = 0;

        while(sent){
            System.out.print("[Phonebook] \n" + //
                    "1. Add contact \n" + //
                    "2. Remove contact \n" + //
                    "3. List contacts \n" + //
                    "4. Search contacts \n" + //
                    "5. Quit \n" + //
                    "Enter option: ");
                resp = scan.nextInt();
                scan.nextLine();

                name = "";
                phone = "";
                respW = "";

            switch(resp){
                
                case 1:
                    String[] info = new String[2];
                
                    System.out.print("Enter the contact's name: ");
                    name = scan.nextLine();
                    info[0] = name;
                
                    System.out.print("Enter the contact's phone number: ");
                    phone = scan.nextLine();
                    info[1] = phone;
                
                    phonebook.add(info);
                
                    System.out.println("Contact added.");
                break;
                
                case 2:
                    System.out.println("Enter contact to remove: ");
                    respW = scan.nextLine();

                    for(String[] entry : phonebook){
                        if(respW.equals(entry[0])){
                            phonebook.remove(entry);
                            System.out.println("Contact deleted");
                            break;
                        }
                        

                    }
                    System.out.println("No contact with that name.");
                    
                break;

                    
                case 3:
                    System.out.println("Listing all contacts...");
                    if (phonebook.isEmpty()){
                        System.out.print("The Phonebook is empty.");

                    } else {
                        for(String[] entry : phonebook){
                            System.out.printf("Name: %s | Phone: %s%n", entry[0],entry[1]);

                        }
                    }

                    System.out.println("Done Listing contacts.");

                break;

                case 4:
                    
                    System.out.print("Enter keyword to search: ");
                    respW = scan.nextLine();

                    System.out.print("Searching all contacts for keyword...");

                    for (String[] entry : phonebook){
                        if(entry[0].toLowerCase().contains(respW)){
                            System.out.printf("Name: %s", entry[0], " | Phone: %s", entry[1], "%n");
                        } else {
                            System.out.println("No contacts contained the keyword");

                        }
                    }
                break;

                case 5:
                    System.out.println("Shutting off...");
                    sent = false;
                break;

                default:
                    System.out.println("Please enter a valid input. ");
                    break;
            }
        
        }

    }
    
}
