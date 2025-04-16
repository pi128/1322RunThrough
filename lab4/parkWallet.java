package lab4;

public class parkWallet {
    private int tickets;
    static Boolean holiday = false;
    static int shirtPrice;
    static int sunHatPrice;
    static int sneakerPrice;




    public int getTickets(){
        return tickets;
    }
    
    public static Boolean getHoliday() {
        return holiday;
    }
    public void setHoliday() {
        holiday = !holiday;
    }
        
    public parkWallet(int tickets) {
        this.tickets = tickets;
    }

   
    public void addTickets(int tickets){
        if(tickets <= 0){
            System.out.println("Tickets must be +");
        } else {
            this.tickets = this.tickets + tickets;
        }
    }
    public void removeTickets(int price){
        this.tickets = this.tickets - price;
    }
    public void setTickets(int tickets){
        this.tickets = tickets;
    }
    public void buyPrize(int prizeS){
        shirtPrice = 150;
        sunHatPrice = 350;
        sneakerPrice = 600;

        if(parkWallet.getHoliday()){
            shirtPrice = shirtPrice/2;
            sunHatPrice = sunHatPrice/2;
            sneakerPrice = sneakerPrice/2;

        }

        switch (prizeS){
            case 1:
                if(getTickets() >= shirtPrice){
                    System.out.printf("Bought T-shirt for %d tickets%n", shirtPrice);
                    removeTickets(shirtPrice);

                } else {
                    System.out.println("Not enough tickets to but a T_shirt");
                }
            break;
            
            case 2:
                if(getTickets() >= sunHatPrice){
                    System.out.printf("Bought sun hat for %d tickets%n", sunHatPrice);
                    removeTickets(sunHatPrice);
                } else {
                    System.out.println("Not enough tickets to but a sun hat");

            }
            break;

            case 3:
                if(getTickets() >= sneakerPrice){
                    System.out.printf("Bought sneakers for %d tickets%n", sneakerPrice);
                    removeTickets(sneakerPrice);

                } else {
                    System.out.println("Not enough tickets to but sneakers");

            }

            break;
        }

    }

}