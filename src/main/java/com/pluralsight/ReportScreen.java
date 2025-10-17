package com.pluralsight;
//ReportScreen – Displays report options
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportScreen {

    public void showReports() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        try {
            //1.connect the FileReader to your CSV file(Notes)
            FileReader fileReader = new FileReader("src/main/resources/Transaction.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            //2.read each line and turn it into a Transaction(Notes)
            while ((input = bufReader.readLine()) != null && !input.trim().isEmpty()) {
                try {
                    Transaction t = Transaction.parseTransaction(input);
                    transactions.add(t);
                } catch (Exception e) {
                    System.out.println("Skipping bad line: " + input);
                }
            }
            bufReader.close();

        } catch (IOException e) {
            System.out.println("Error reading transactions file.");
            e.printStackTrace();
        }

        boolean viewingReports = true; // keeps the screen running until user chooses 0

        while (viewingReports) {

            // shows the report menu options
            System.out.println();
            System.out.println("== Reports Menu ==");
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
                    showMonthToDate(transactions);
                    break;
                case "2":
                    showPreviousMonth(transactions);
                    break;
                case "3":
                    showYearToDate(transactions);
                    break;
                case "4":
                    showPreviousYear(transactions);
                    break;
                case "5":
                    System.out.print("Enter vendor name: ");
                    String vendor = scanner.nextLine();
                    showByVendor(transactions, vendor);
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

    //3.shows only this month's transactions(Notes)
    private void showMonthToDate(ArrayList<Transaction> transactions) {
        LocalDate today = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == today.getMonth() && t.getDate().getYear() == today.getYear()) {
                System.out.println(t.toCsvLine());
            }
        }
    }

    //4.shows transactions from the previous month(Notes)
    private void showPreviousMonth(ArrayList<Transaction> transactions) {
        LocalDate today = LocalDate.now();
        LocalDate previousMonth = today.minusMonths(1);
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == previousMonth.getMonth() && t.getDate().getYear() == previousMonth.getYear()) {
                System.out.println(t.toCsvLine());
            }
        }
    }

    //5.shows all transactions from this year(Notes)
    private void showYearToDate(ArrayList<Transaction> transactions) {
        LocalDate today = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == today.getYear()) {
                System.out.println(t.toCsvLine());
            }
        }
    }

    //6.shows all transactions from last year(Notes)
    private void showPreviousYear(ArrayList<Transaction> transactions) {
        LocalDate lastYear = LocalDate.now().minusYears(1);
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == lastYear.getYear()) {
                System.out.println(t.toCsvLine());
            }
        }
    }

    //7.searches by vendor name(Notes)
    private void showByVendor(ArrayList<Transaction> transactions, String vendor) {
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println(t.toCsvLine());
            }
        }
    }
}