package lab11;
public class blueRayCollection {
    private blueRayDisk head;

    public blueRayCollection (){
        head = null;
    }

    public void addDisk (String title, String director, Integer yearOfRelease, double cost){
        blueRayDisk newDisk = new blueRayDisk(title, director, yearOfRelease, cost);

        if (head == null){
            blueRayDisk current = head;
            head = newDisk;

        } else {
            blueRayDisk current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newDisk;
        }        
    }
    public String showAll(){
        if (head == null){
            return "";
        }

        String result = "";
        blueRayDisk current = head;

        while(current != null){
            result = current.toString() + "\n";
            current = current.next;
        }
        return result.trim();

    }
}
