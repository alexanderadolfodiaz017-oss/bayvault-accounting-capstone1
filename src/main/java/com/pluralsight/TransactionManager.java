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
            bufWriter.newLine(); //4.adds each new transaction on a new line (Notes)
            bufWriter.flush();   //5.saves instantly while program is running (Notes)

            //6.close the writer(Notes)
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error 404");
            e.getStackTrace();
        }
    }

    //7.clears all transactions inside the CSV file (optional feature for resetting)(Notes)
    public void clearTransactions(){
        try {
            //8.this overwrites the file instead of adding to it (Notes)
            FileWriter fileWriter = new FileWriter(
                    "C:\\Users\\josel\\PluralSight\\GitHub\\bayvault-accounting-capstone1\\BayVaultTech\\src\\main\\resources\\Transaction.csv",
                    false
            );

            //9.clears the file by writing nothing to it (Notes)
            fileWriter.write("");
            fileWriter.close();
            System.out.println("All transactions cleared."); //10.tells user file is reset (Notes)
        }
        catch (IOException e) {
            System.out.println("Error 404 while clearing file");
            e.getStackTrace();
        }
    }
}