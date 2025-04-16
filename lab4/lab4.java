package lab4;

import java.util.Scanner;

public class lab4 {
    public static void main(String[] args){

        Boolean sent = true;

        //to make a selection in the main loop
        int resp;
        //to make a selction inside of the switch
        int resp2;

        Scanner scan = new Scanner(System.in);
        
        parkWallet pw = new parkWallet(100);

        while(sent){
            System.out.printf("[Theme Park Wallet Manager] \n" + //
                    "1. Add tickets \n" + //
                    "2. Set tickets \n" + //
                    "3. Buy prize \n" + //
                    "4. Set holiday \n" + //
                    "5. Quit \n" + //
                    "Your wallet has %d tickets %n" + //
                    "Enter option: ", pw.getTickets());
            resp = scan.nextInt();

            switch(resp){
                case 1:
                    System.out.print("Add how many tickets? ");
                    resp2 = scan.nextInt();
                    pw.addTickets(resp2);

                break;

                case 2:
                    System.out.print("Set ticket balance to: ");
                    resp2 = scan.nextInt();
                    pw.setTickets(resp2);

                break;

                case 3:
                if(parkWallet.getHoliday()){
                    System.out.print("1. T-shirt (75 tickets) \n" + //
                    "2. Sun hat (175 tickets) \n" + //
                    "3. Sneakers (300 tickets) \n" + //
                    "Buy which prize? ");
                    resp2 = scan.nextInt();
                } else{
                    System.out.print("1. T-shirt (150 tickets) \n" + //
                            "2. Sun hat (350 tickets) \n" + //
                            "3. Sneakers (600 tickets) \n" + //
                            "Buy which prize? ");
                    resp2 = scan.nextInt();
                }


                    

                    pw.buyPrize(resp2);
                break;

                case 4: 
                    pw.setHoliday();
                    System.out.printf("Holiday : %b%n", parkWallet.getHoliday());
                
                break;

                case 5:
                    System.out.println("Shutting off...");
                    sent = false;
            }

        }
    }
}
