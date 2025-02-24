class BankAccount {
    private static String bankName = "Cental Bank"; // Static variable shared across all accounts
    private static int totalAccounts = 0; // Static counter for total accounts
    private final int accountNumber; // Final variable that cannot be changed
    private String accountHolderName;
    private double balance;
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++; // Increment total accounts
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) { // Using instanceof
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: $" + balance);
        }
    }

    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }
}

// Main class to test the BankAccount class
public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, "Aman", 500000);
        BankAccount acc2 = new BankAccount(102, "Adarsh", 300000);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        BankAccount.getTotalAccounts();
    }
}
