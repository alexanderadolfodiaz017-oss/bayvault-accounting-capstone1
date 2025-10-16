package com.pluralsight;

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

            //2.use a BufferedReader to manage the input receives from user
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            //3.read each line until there’s no more data(Notes)
            while ((input = bufReader.readLine()) != null) {


                //4.Turn each line into a Transaction object(Notes)
                Transaction t = Transaction.parseTransaction(input);


                //5. Add it to the list(Notes)
                transaction.add(t);

                System.out.println(input);
            }

            //6.close the file when done(Notes)
            bufReader.close();

        } catch (IOException e) {
            //5.handle any reading errors(Notes)
            e.printStackTrace();

            //below here the ledger menu starts
            boolean viewingLedger = true;


        }
    }
}

