package lab10;

public class alarm extends Thread {
    private int timer;            // milliseconds still remaining
    private final String name;
    private final int id;
    private static int nextId = 1;

    public alarm(String name, int seconds) {
        this.id = nextId++;
        this.timer = seconds * 1_000;          // store as ms
        this.name = (name.isBlank()) ? "Alarm " + id : name;
    }

    @Override
    public void run() {
        try {
            while (timer > 0) {
                Thread.sleep(1_000);           // wait 1 second
                timer -= 1_000;

                if (timer == 10_000) {         // 10‑second warning
                    System.out.println(name + " will go off in 10 seconds.");
                }
            }
            System.out.println(name + " has gone off!");
        } catch (InterruptedException e) {
            System.out.println(name +
                " has been interrupted at " + (timer / 1_000) + " seconds.");
            // keep the interrupt status so callers know
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return name + " is currently at " + (timer / 1_000) + " seconds";
    }
}