package lab2;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);


        //sentinel value for the main loop
        boolean sent = true;
        //for the initial options
        int resp;

        //used for both the functions 1 and 2
        int num1;
        int num2;

        //  respW used for word input
        String respW;
        while (sent){
            //resetting them just incase
            num1 = 0;
            num2 = 0;
            respW = "";
            System.out.print("1. Count from a number to another \n" + //
                    "2. Determine largest number \n" + //
                    "3. Type in word \n" + //
                    "4. Quit \n" + //
                    "Enter option: ");
            resp = scan.nextInt();
            System.out.println();

            switch(resp){
                case 1: 
              
                    System.out.print("Enter the start point: ");
                    num1 = scan.nextInt();
                    System.out.print("Enter the end point: ");
                    num2 = scan.nextInt();


                    if(num1 == num2){
                        System.out.println("Start and end are the same!");
                    } else if (num1 < num2){
                        System.out.printf("Counting from %d%n", num1, "to dI%n", num2, "...");
                        for (int i = num1; i <= num2; i++){
                            System.out.println(i);
                        }
                    }
                    System.out.println("Done counting.\n");
                break;

                case 2:
                    System.out.println("This option will display the largest number entered. Enter 0 when \n" + //
                    "done.");
                    while(true){
                      
                        
                
                        System.out.printf("Enter a numer(current largest is %d): ", num2);
                        num1 = scan.nextInt();

                        if (num1 > num2){
                            num2 = num1;
                        }
                        if(num1 == 0){
                            System.out.printf("The Largest number entered was %d%n", num2);
                            break;
                            }

                        
                        }
                        System.out.println();

                    break;
                
                case 3:
                    System.out.print("Type in the word 'Computer: ");
                    respW = scan.next();
                    
                    while(true){
                        if (respW.equals("Computer")){
                            System.out.println("Correct!");
                            break;
                        } else {
                            System.out.print("Incorrect. you must type 'Computer : " );
                            respW = scan.next();
                        }
                    }
                    break;

                case 4:

                    System.out.println("Shutting off...");
                    sent = false;
                    break;
                    

            }   

        }
        
    }
}

