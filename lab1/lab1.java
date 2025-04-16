package lab1;
import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n(Budgeting System)");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.printf("Hello %s. Please enter your monthly salary: ", name);
        double salary = scan.nextDouble();
        double yearlySalary = salary * 12;

        System.out.println();
        System.out.print("What is the total amount of your loan? ");
        double loanPrincipal = scan.nextDouble();

        System.out.print("What is interest rate of your loan? ");
        double loanInterest = scan.nextDouble();
        loanInterest = loanInterest / 100;

        double newPrincipal = loanPrincipal * Math.pow((1 + (loanInterest / 12)), 12);

        System.out.println();
        System.out.printf("Your yearly salary is %.2f%n", yearlySalary);
        System.out.printf("In 12 months, your loan's principal will be %.2f%n", newPrincipal);
        System.out.println();

        System.out.print("At the end of the year, you will have paid off your debt: ");
        boolean paidOff = yearlySalary >= newPrincipal;
        System.out.println(paidOff);

        System.out.print("At the end of the year, you will still have some debt left: ");
        System.out.println(!paidOff);

        System.out.printf("At the end of the year, you will have $%.2f of your salary left.%n", (yearlySalary - newPrincipal));
        System.out.println();

        System.out.println("The government is offering loan relief for persons 25 and under, and for those 65 and over.");
        System.out.print("What is your age? ");
        int age = scan.nextInt();

        boolean eligibleForRelief = (age <= 25 || age >= 65);
        System.out.printf("The relief is $10000. You are eligible for the relief: %b%n", eligibleForRelief);

        boolean loanPaidOff = (yearlySalary >= newPrincipal) || eligibleForRelief;
        System.out.printf("With or without relief, you will be able to pay your loan in full: %b%n", loanPaidOff);
    }
}