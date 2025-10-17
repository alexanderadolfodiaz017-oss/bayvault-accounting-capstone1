package com.pluralsight;
//TransactionManager – Saves data to the CSV file
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionManager {
    public void saveToFiles(String line){
        try {
            //1.create a FileWriter(Notes)
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\josel\\PluralSight\\GitHub\\bayvault-accounting-capstone1\\BayVaultTech\\src\\main\\resources\\Transaction.csv",
                    true
            );

            //2.create a BufferedWriter(Notes)
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //3.write to the file(Notes)
            bufWriter.write(line);
            bufWriter.newLine(); //4.adds a new line for each transaction (Notes)

            //5.flushes the data instantly (Notes)
            bufWriter.flush();

            //6.close the writer(Notes)
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error 404");
            e.getStackTrace();
        }
    }

    //7.clears all transactions from the file(Notes)
    public void clearTransactions() {
        try {
            //8.creates a FileWriter with "false" so it overwrites the file instead of adding new lines (Notes)
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\josel\\PluralSight\\GitHub\\bayvault-accounting-capstone1\\BayVaultTech\\src\\main\\resources\\Transaction.csv",
                    false
            );

            //9.writes an empty string which clears everything in the CSV file (Notes)
            fileWriter.write("");
            fileWriter.close();

            System.out.println("Transaction file cleared.");
        }
        catch (IOException e) {
            System.out.println("Error clearing transaction file");
            e.printStackTrace();
        }
    }
}