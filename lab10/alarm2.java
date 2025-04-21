package lab10;
public class alarm2 extends Thread{
    private int timer;
    private final String name;
    private final int id;
    private static int nextId = 1;

    public alarm2 (String name, int seconds){
        this.id = nextId++;
        this.timer = seconds * 1_000;
        this.name  = name.isBlank()        // default label if blank
                 ? "Alarm " + id
                 : name;
    }


   
    @Override
    public void run(){
        try {
            while(timer > 0){
                Thread.sleep(1000);
                timer -= 1000;
                if (timer == 10_000){
                    System.out.println(name + " will go off in 10 seconds.");
                   }
            }
            System.out.println(name + " has gone off!");
        } catch (InterruptedException e) {
            System.out.println(name +" has been interrupted at " + (timer / 1000) + " seconds.");

            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString(){
        return name + " is currently at " + (timer / 1000) + " seconds.";
    }
}
