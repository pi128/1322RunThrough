package lab11;
public class blueRayDisk {
    private String title;
    private String director;
    private Integer yearOfRelease;
    private Double cost;
    public blueRayDisk next = null;

   


public blueRayDisk (String title, String director, Integer yearOfRelease, double cost){
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.cost = cost;
        this.next = null;
    }
    public String toString(){
        return title + " - " + director + "(" + yearOfRelease + "): $" + cost; 
    }
}
