import java.util.*;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods for deposit and withdraw
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Abstract method to calculate interest (to be implemented by subclasses)
    public abstract double calculateInterest();

    // Getter methods for encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 4.0; // 4% annual interest rate

    // Constructor
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE / 100;  // Interest calculation for savings
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Application for Savings Account: " + amount);
        if (calculateLoanEligibility()) {
            System.out.println("Loan approved!");
        } else {
            System.out.println("Loan denied. Insufficient balance.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;  // Example: Eligibility if balance is more than 5000
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 2.0; // 2% annual interest rate

    // Constructor
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE / 100;  // Interest calculation for current
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan Application for Current Account: " + amount);
        if (calculateLoanEligibility()) {
            System.out.println("Loan approved!");
        } else {
            System.out.println("Loan denied. Insufficient balance.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 2000;  // Example: Eligibility if balance is more than 2000
    }
}

// Main class to test the system
public class BankingSystem {
    public static void main(String[] args) {
        // Create instances of bank accounts
        BankAccount savingsAccount = new SavingsAccount("SA123", "Alice", 6000);
        BankAccount currentAccount = new CurrentAccount("CA456", "Bob", 3000);

        // Create a list of bank accounts
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(currentAccount);

        // Process accounts: Deposit, Withdraw, and Calculate Interest
        savingsAccount.deposit(1000);
        currentAccount.deposit(500);
        savingsAccount.withdraw(500);
        currentAccount.withdraw(1000);

        // Display account details and calculate interest
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("Interest: " + account.calculateInterest());
            System.out.println();

            // Applying for loan for loanable accounts
            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                loanableAccount.applyForLoan(5000);  // Example loan amount
            }
        }
    }
}
