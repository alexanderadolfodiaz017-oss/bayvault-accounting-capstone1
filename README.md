# BayVault Tech - Accounting Ledger Application

## Author  
Alexander Diaz  
Year Up: Java Development Fundamentals  

---

## Description  
BayVault Tech is a Java console app that tracks deposits and payments for personal or business use.  
Each transaction is stored in `Transaction.csv` in this format:  
---

## Java Classes  
- **BayVaultTechApp** – Starts the program  
- **HomeScreen** – Main menu for user options  
- **Transaction** – Holds each transaction’s details  
- **TransactionManager** – Saves data to the CSV file  
- **LedgerScreen** – Shows all, deposit, or payment records  
- **ReportScreen** – Displays report options

---

## Interesting Code Example  
```java
Scanner scanner = new Scanner(System.in); 

System.out.println("Enter description: ");
String description = scanner.nextLine();

System.out.println("Enter vendor: ");
String vendor = scanner.nextLine();

System.out.println("Enter amount: ");
double amount = Double.parseDouble(scanner.nextLine());
