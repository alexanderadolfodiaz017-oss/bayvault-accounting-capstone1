package com.pluralsight;
//LedgerScreen – Shows all, deposit, or payment records
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerScreen {
    public void showLedger() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> transaction = new ArrayList<>();

        try {
            //1.connect the FileReader to your CSV file(Notes)
            FileReader fileReader = new FileReader("src/main/resources/Transaction.csv");

            //2.use a BufferedReader to manage the input receives from user(Notes)
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            //3.read each line until there’s no more data(Notes)
            while ((input = bufReader.readLine()) != null && !input.trim().isEmpty()) {

                //4.Turn each line into a Transaction object(Notes)
                Transaction t = Transaction.parseTransaction(input);

                //5. Add it to the list(Notes)
                transaction.add(t);
            }

            //6.close the file when done(Notes)
            bufReader.close();

        } catch (IOException e) {
            //7.handle any reading errors(Notes)
            e.printStackTrace();
        }

        //below here the ledger menu starts
        boolean viewingLedger = true;//<----loop repeats everything inside it (the Ledger menu options) until viewingLedger becomes false.

        while (viewingLedger) {//<----- Keeps showing the Ledger menu until the user chooses to go back to Home

            System.out.println();
            System.out.println("Ledger Menu");
            System.out.println("A) All transactions");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                    System.out.println("All transactions (newest first)");
                    for (int i = transaction.size() - 1; i >= 0; i--) {
                        System.out.println(transaction.get(i).toCsvLine());
                    }
                    break;

                case "d":
                    System.out.println("Deposits only");
                    for (int i = transaction.size() - 1; i >= 0; i--) {
                        if (transaction.get(i).getAmount() > 0) {
                            System.out.println(transaction.get(i).toCsvLine());
                        }
                    }
                    break;

                case "p":
                    System.out.println("Payments only");
                    for (int i = transaction.size() - 1; i >= 0; i--) {
                        if (transaction.get(i).getAmount() < 0) {
                            System.out.println(transaction.get(i).toCsvLine());
                        }
                    }
                    break;

                case "r":
                    System.out.println("Opening Reports...");
                    //8.opens the ReportScreen when user presses R(Notes)
                    ReportScreen report = new ReportScreen();
                    report.showReports();
                    break;

                case "h":
                    System.out.println("Returning to home screen...");
                    viewingLedger = false;
                    HomeScreen home = new HomeScreen();
                    home.showMenu();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
