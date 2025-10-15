package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

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


            switch (choice) {//these are all the choices the user can choose.He can switch choices if he chooses too.(Notes)
                case "d":
                    System.out.println("deposit");
                    // date - computer
                    // time - computer
                    //description come from the user(scanner)
                    //User
                    //User

                    //page 22 workbook 3a start at "try" go to "first" curly brace to add
                    break;
                case "p":
                    System.out.println("payment");
                    break;
                case "l":
                    System.out.println("ledger");
                    break;
                case "x":
                    System.out.println("exit program");
                    running = false;//tells the program to stop the "While loop" when I exit the App
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}