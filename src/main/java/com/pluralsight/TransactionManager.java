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
            bufWriter.newLine(); // added this so each entry goes to a new line

            //4.close the writer(Notes)
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error 404");
            e.getStackTrace();
        }
    }
}
