package com.pluralsight;
//HomeScreen – Main menu for user options
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeScreen {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        TransactionManager manager = new TransactionManager();  //This creates one “employee” (manager) that the HomeScreen can talk to.
        //Classes share info by making objects of each other and sending data through parentheses,
        // so they can work together like a team — one class asks, and the other class helps do the job.
        //Example:
        //Main <–––> HomeScreen <–––> TransactionManager

        boolean running = true;// as long as running is true,the menu keeps showing on repeat till it's false(notes)
        while (running) {

            System.out.println("===Welcome to Bay Vault Tech===");
            System.out.println("(the best banking app in the world!)");
            System.out.println("D.Add a deposit");
            System.out.println("P.Make a payment");
            System.out.println("L.Ledger Screen");
            System.out.println("C.Clear all transactions"); // (Notes) added this option to refresh the CSV file
            System.out.println("X.Exit");
            System.out.println("Make a selection below:");

            //String choice = scanner.nextLine();(Previous Code)
            //I changed it so it can let the user input either upper or lowercase letters(notes)
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {//<----these are all the choices that the user can choose.He can switch choices if he chooses too.(Notes)

                case "d":
                    System.out.println("deposit");

                    LocalDate date = LocalDate.now();
                    // date comes from the computer

                    LocalTime time = LocalTime.now();
                    // time comes from computer already

                    System.out.println("description");
                    //description come from the user(scanner)
                    String description = scanner.nextLine();

                    System.out.println("vendor");
                    //input comes from the User
                    String vendor = scanner.nextLine();

                    System.out.println("enter amount");
                    //Input comes from the User
                    double amount = Double.parseDouble(scanner.nextLine());

                    //My references:(listed below)
                    //public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
                    //page 22 workbook 3a start at "try" go to "first" curly brace to add
                    //date|time|description|vendor|amount

                    String transaction = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
                    manager.saveToFiles(transaction);
                    break;

                case "p":
                    System.out.println("payment");

                    LocalDate dateP = LocalDate.now();
                    // date comes from the computer

                    LocalTime timeP = LocalTime.now();
                    // time comes from computer already

                    System.out.println("description");
                    // description come from the user(scanner)
                    String descriptionP = scanner.nextLine();

                    System.out.println("vendor");
                    //Input comes from the User
                    String vendorP = scanner.nextLine();

                    System.out.println("enter amount");
                    //Input comes from the User
                    double amountP = Double.parseDouble(scanner.nextLine());

                    // (Notes) payments must be stored as a negative number to show correctly in the Ledger
                    amountP = -Math.abs(amountP);

                    //My references note:(listed below)
                    //public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
                    //page 22 workbook 3a start at "try" go to "first" curly brace to add
                    //date|time|description|vendor|amount

                    String transactionP = dateP + "|" + timeP + "|" + descriptionP + "|" + vendorP + "|" + amountP;
                    manager.saveToFiles(transactionP);
                    break;

                case "l":
                    System.out.println("ledger");
                    LedgerScreen ledger = new LedgerScreen();
                    ledger.showLedger();
                    break;

                case "c":
                    System.out.println("Clearing all transactions...");
                    manager.clearTransactions(); // (Notes) calls the clear method to refresh Transaction.csv
                    System.out.println("All transactions cleared successfully!");
                    break;

                case "x":
                    System.out.println("exit program");
                    running = false;//<---tells the program to stop the "While loop" when I exit the App
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

