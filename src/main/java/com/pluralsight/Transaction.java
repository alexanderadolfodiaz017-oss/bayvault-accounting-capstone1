package com.pluralsight;
//Transaction – Holds each transaction’s details
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // These are the details we need for each transaction

    private LocalDate date;

    private LocalTime time;

    private String description; // what it was for

    private String vendor; // who it was with

    private double amount; // how much money

    // This builds (creates) a new Transaction with all the details
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {

        this.date = date;

        this.time = time;

        this.description = description;

        this.vendor = vendor;// saves who it was with

        this.amount = amount;
    }

    // The (sets) let us change the values if needed
    // The (gets) let us read the values

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // This turns a transaction into a line of text for the CSV file
    public String toCsvLine() {

        //this is how the text is formatted in the CSV File
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }


    // This takes one line of text from the CSV and turns it back into a Transaction
    public static Transaction parseTransaction(String line) {


        String[] parts = line.split("\\|");
        LocalDate date = LocalDate.parse(parts[0]);
        LocalTime time = LocalTime.parse(parts[1]);
        String description = parts[2];
        String vendor = parts[3];
        double amount = Double.parseDouble(parts[4]);

        return new Transaction(date, time, description, vendor, amount);
    }
}
