package lab10;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class lab10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<alarm> alarms = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.print("""
                    [Alarm System]
                    1. Create new alarm
                    2. View all alarms
                    3. Quit
                    Enter option: """);

            int option = scan.nextInt();
            scan.nextLine();                // clear newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter alarm name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter alarm timer in seconds: ");
                    try {
                        int seconds = scan.nextInt();
                        scan.nextLine();    // clear newline
                        alarm a = new alarm(name, seconds);
                        alarms.add(a);
                        System.out.println(a);   // toString()
                        a.start();               // thread begins
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid timer: Timer must be a whole number.");
                        scan.nextLine();         // discard bad input
                    }
                }

                case 2 -> {
                    System.out.println("\nHere are all the alarms still running:");
                    for (alarm a : alarms)
                        if (a.isAlive())               // skip finished ones
                            System.out.println(a);
                    System.out.println();
                }

                case 3 -> {
                    System.out.println("Stopping all alarms...");
                    // Interrupt anything still alive
                    for (alarm a : alarms)
                        if (a.isAlive())
                            a.interrupt();

                    // Wait for each to finish so we know they're dead
                    for (alarm a : alarms)
                        try { a.join(); } catch (InterruptedException ignored) { }

                    System.out.println("All alarms have been stopped.");
                    System.out.println("Shutting off...");
                    running = false;
                }

                default -> System.out.println("Please choose 1, 2, or 3.");
            }
        }
        scan.close();
    }
}