package lab8;

import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args){    
    Scanner scan = new Scanner(System.in);

    int selection;
    boolean sent = true;

    while(sent){
        System.out.print("[Time Calculator] \n" + //
                "1. Calculate difference in seconds \n" + //
                "2. Exit \n" + //
                "Enter your option: ");
        selection = scan.nextInt();
        scan.nextLine();

        switch(selection){

            case 1:
            System.out.println();
            try {
                System.out.print("\nEnter the start timestamp: ");
                String start = scan.nextLine();
                System.out.print("Enter the end timestamp: ");
                String end = scan.nextLine();

                int diff = differenceInSeconds(start, end);
                System.out.println("The difference between " + start + " and " + end + " is " + diff + " seconds");
                } catch (InvalidTimeException e) {
                    System.out.println(e.getMessage());

                } catch (NumberFormatException e) {
                    System.out.println("You must enter integers for the hours, minutes, and seconds");
                    
            break;
            }
            case 2:
                System.out.println("Shutting off...");
                sent = false;
            break;

            default:
                System.out.println();
                continue;
                
            }
        }
    }
    static int differenceInSeconds(String start, String end) throws InvalidTimeException{
        int startSec = convertToSeconds(start);
        int endSec = convertToSeconds(end);
        return endSec - startSec;
    
    
    }
    static int convertToSeconds (String timeStamp) throws InvalidTimeException {
        String[] parts = timeStamp.split(":");

            if (parts.length != 3){
                throw new InvalidTimeException("Timestamp must be in the format HH:MM:SS");
        }

        int hours;
        int minutes;
        int seconds;

        try {
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
            seconds = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidTimeException("You must enter integers for the hours, minutes, and seconds");
        }
            if (hours < 0){
                throw new InvalidTimeException("Hours must be greater than or equal to 0 ");
            }
            if (hours >= 24){
                throw new InvalidTimeException("Hours must be less than 24");
            }
            if (minutes < 0){
                throw new InvalidTimeException("Minutes must be greater than or equal to 0");
            }
            if (minutes >= 60){
                throw new InvalidTimeException("Minutes must be less than 60");
            }
            if (seconds < 0){
                throw new InvalidTimeException("Seconds must be greater than or equal to 0");
            }
            if (seconds >= 60){
                throw new InvalidTimeException("Seconds must be less than 60");
            }
    return (hours * 3600) + (minutes * 60) + seconds;


    }

} 
