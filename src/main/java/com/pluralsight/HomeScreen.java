package com.pluralsight;

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



        System.out.println("Welcome to Bay Vault");
        System.out.println("(the best banking app in the world!)");
        System.out.println("D.Add a deposit");
        System.out.println("p.Make a payment");
        System.out.println("L.Ledger Screen");
        System.out.println("X.Exit");
        System.out.println("D.Make a selection below");



            //String choice = scanner.nextLine();(Previous Code)
            //I changed it so it can let the user input either upper or lowercase letters(notes)
            String choice = scanner.nextLine().toLowerCase();



            switch (choice) {//<----these are all the choices the user can choose.He can switch choices if he chooses too.(Notes)
                case "d":
                    System.out.println("deposit");
                    // date - computer
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    // time - computer
                    //description come from the user(scanner)
                    System.out.println("description");
                    String description = scanner.nextLine();
                    //User
                    System.out.println("vendor");
                    String vendor = scanner.nextLine();
                    //User
                    System.out.println("enter amount");
                    double amount = Double.parseDouble(scanner.nextLine());
                    //public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
                    //page 22 workbook 3a start at "try" go to "first" curly brace to add
                    //date|time|description|vendor|amount
                    String transaction = date + "\\|" + time + "\\|" + description + "\\|"  + vendor + "\\|"  + amount;
                    manager.saveToFiles(transaction);
                    break;
                case "p":
                    System.out.println("payment");
                    // date - computer
                    LocalDate dateP = LocalDate.now();
                    LocalTime timeP = LocalTime.now();
                    // time - computer
                    //description come from the user(scanner)
                    System.out.println("description");
                    String descriptionP = scanner.nextLine();
                    //User
                    System.out.println("vendor");
                    String vendorP = scanner.nextLine();
                    //User
                    System.out.println("enter amount");
                    double amountP = Double.parseDouble(scanner.nextLine());
                    //public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
                    //page 22 workbook 3a start at "try" go to "first" curly brace to add
                    //date|time|description|vendor|amount
                    String transactionP = dateP + "\\|" + timeP + "\\|" + descriptionP + "\\|"  + vendorP + "\\|"  + amountP;
                    manager.saveToFiles(transactionP);
                    break;
                case "l":
                    System.out.println("ledger");
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