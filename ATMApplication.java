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
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Current Balance: " + account.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. New Balance: " + account.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (account.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful. New Balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient funds.");
                }
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            atm.processOption(option);
        } while (option != 4);

        scanner.close();
    }
}
