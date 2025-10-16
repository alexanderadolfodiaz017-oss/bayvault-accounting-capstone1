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

## Images of the Final Product  

**1. Home Screen**  
![1 Starting up the program(HomeScreen)](https://github.com/user-attachments/assets/07efb6d5-8235-456a-9195-8004a07b1124)

**2. Deposit (Part 1)**  
![2 Deposit(Part 1)](https://github.com/user-attachments/assets/7ab225d4-9993-4254-8a9d-5f260ee412f8)

**3. Deposit (Part 2)**  
![3 Deposit(Part 2)](https://github.com/user-attachments/assets/cb2e40e6-cb26-47ce-a0ea-3c859d496609)

**4. Payment (Part 1)**  
![4 Payment(Part 1)](https://github.com/user-attachments/assets/82aac495-a636-4f2a-82e8-f96d945fd2e3)

**5. Payment (Part 2)**  
![5 Payment(Part 2)](https://github.com/user-attachments/assets/f15ead5e-89e6-4a4c-a35d-beb311459321)

**6. Ledger Screen**  
![6 Ledger Screen](https://github.com/user-attachments/assets/af5f927e-683d-4a23-b0f8-2ab4d96565f1)







