package lab10;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class lab101 {
    public static void main(String[] args){

        ArrayList<alarm2> alarms = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        Boolean sent = true;

        while(sent){
            System.out.print("[Alarm System] \n" + //
                    "1. Create new alarm \n" + //
                    "2. View all alarms \n" + //
                    "3. Quit \n" + //
                    "Enter option: ");
            int resp = scan.nextInt();
            scan.nextLine();

            switch (resp){
                case 1 -> {
                    System.out.print("Enter alarm name: ");
                    String respname = scan.nextLine();

                    System.out.print("Enter alarm timer in seconds: ");
                    try {
                    int resptime = scan.nextInt();
                    scan.nextLine();

                    alarm2 a = new alarm2(respname, resptime);
                    alarms.add(a);
                    System.out.println(a);
                    a.start();
                    } catch (InputMismatchException e){
                        System.out.println("Invaled timer: Timer must be a whole number.");
                        scan.nextLine();
                    }
                }
                case 2 -> {
                    for (alarm2 a : alarms){
                        if(a.isAlive()){
                            System.out.println(a);
                        }
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Stopping all alarms...");

                    for (alarm2 a : alarms) {
                        if(a.isAlive()){
                            a.interrupt();
                        }
                        
                    }
                    System.out.println("All alarms have been stoped.\nShutting off...");
                    sent = false;
                }

            }
        }
        scan.close();
    }
}
