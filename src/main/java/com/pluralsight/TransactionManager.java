package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TransactionManager {
    public void saveToFiles(String line){
        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("C:\\Users\\josel\\PluralSight\\GitHub\\bayvault-accounting-capstone1\\BayVaultTech\\src\\main\\resources\\Transaction.csv");
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
                bufWriter.write(line);
            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }
    }
}
