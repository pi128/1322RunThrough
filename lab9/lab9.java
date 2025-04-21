package lab9;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab9 {
    
    static String diff(File f1, File f2){
        Scanner sc1 = null;
        Scanner sc2 = null;
        StringBuilder result = new StringBuilder();
        int lineNumber = 1;
       
        try{
            sc1 = new Scanner(f1);
            sc2 = new Scanner(f2);

            while(sc1.hasNextLine() && sc2.hasNextLine()){

                String line1 = sc1.nextLine();
                String line2 = sc2.nextLine();

                if(!line1.equals(line2)){

                result.append("Line " + lineNumber);
                result.append("< " + line1 + "\n");
                result.append("> " + line2 + "\n");

                    }
            lineNumber++;

             }
             if(sc1.hasNextLine() || sc2.hasNextLine()){
                result.append("Files have different number of lines");
             }

             if (result.length() == 0){
                return ("Files are identical.");
             }
             return result.toString();
        } catch (FileNotFoundException e) {

            if (!f1.exists()){
                return f1.getName() + " (The system cannot find the file specified)";
            }
            else if (!f2.exists()){
                return f2.getName() + "  (The system cannot find the file specified)";
            } else {
                // Fallback in case the file exists but cannot be opened for some other reason
                return e.getMessage();
        } 
        
    } finally {
        if(sc1 != null){
            sc1.close();
        }
        if(sc2 != null){
            sc2.close();
        }
    }
       
    
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       

        System.out.print("[Diff Detector] \n" + //
                "Enter the name of file 1: ");
            String fileName1 = scan.nextLine();  // Read full line input
            File resp1 = new File(fileName1);

        System.out.print("Enter the name of file 2: ");
        String fileName2 = scan.nextLine();
        File resp2 = new File(fileName2);


        String results = diff(resp1, resp2);
        
        System.out.println(results);
        System.out.print("Program Complete");

        
    }
    
}