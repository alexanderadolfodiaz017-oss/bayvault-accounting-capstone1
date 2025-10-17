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
                    "src/main/resources/Transaction.csv",
                    true // (Notes) true = keeps adding instead of deleting old data
            );

            //2.create a BufferedWriter(Notes)
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //3.write to the file(Notes)
            bufWriter.write(line);
            bufWriter.newLine(); // (Notes) added this so each entry goes to a new line

            //4.close the writer(Notes)
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("Error 404");
            e.printStackTrace();
        }
    }

    //5.clears all transactions by overwriting the file (Notes)
    public void clearTransactions() {
        try {
            // (Notes) false = erases everything inside the file
            FileWriter fileWriter = new FileWriter("src/main/resources/Transaction.csv", false);

            // (Notes) this writes nothing, basically refreshing the file
            fileWriter.write("");

            // (Notes) close when done
            fileWriter.close();

            System.out.println("All transactions cleared successfully!");
        } catch (IOException e) {
            System.out.println("Error 404 while clearing file.");
            e.printStackTrace();
        }
    }
}
