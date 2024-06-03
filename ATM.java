import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}
public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000);
        System.out.println("this is task 4 of java internship of codsoft");
        System.out.println("Intial amount in each bank is $1000");
        while (true) {
            System.out.println("\nATM Options:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
