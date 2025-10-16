package com.pluralsight;

import java.util.Scanner;

public class ReportScreen {

    public void showReports() {
        Scanner scanner = new Scanner(System.in);

        boolean viewingReports = true; // keeps the screen running until user chooses 0

        while (viewingReports) {

            // shows the report menu options
            System.out.println();
            System.out.println("Reports Menu");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back to Ledger");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Month To Date report coming soon.");
                    break;
                case "2":
                    System.out.println("Previous Month report coming soon.");
                    break;
                case "3":
                    System.out.println("Year To Date report coming soon.");
                    break;
                case "4":
                    System.out.println("Previous Year report coming soon.");
                    break;
                case "5":
                    System.out.println("Search by Vendor feature coming soon.");
                    break;
                case "0":
                    System.out.println("Returning to Ledger Screen...");
                    viewingReports = false; // ends the loop

                    LedgerScreen ledger = new LedgerScreen();
                    ledger.showLedger(); // goes back to ledger menu
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
