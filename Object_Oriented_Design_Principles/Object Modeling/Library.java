import java.util.ArrayList;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;  
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited INR " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew INR " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: INR " + balance);
    }
}


class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(String accountNumber) {
        BankAccount newAccount = new BankAccount(accountNumber);
        accounts.add(newAccount);
        System.out.println("Account with number " + accountNumber + " opened for " + name);
    }

    public void viewBalance() {
        if (accounts.isEmpty()) {
            System.out.println(name + " has no accounts.");
        } else {
            for (BankAccount account : accounts) {
                account.displayBalance();
            }
        }
    }

    public void depositToAccount(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void withdrawFromAccount(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }
}


class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void openAccountForCustomer(String customerName, String accountNumber) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            customer = new Customer(customerName);
            customers.add(customer);
        }
        customer.openAccount(accountNumber);
    }

    public void viewCustomerBalances(String customerName) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.viewBalance();
        } else {
            System.out.println("Customer not found.");
        }
    }

    Customer findCustomer(String name) {
            for (Customer customer : customers) {
                if (customer.getName().equals(name)) {
                    return customer;
                }
            }
            return null;
        }
    }
    
    
    public class Library {
        public static void main(String[] args) {
            
            Bank bank = new Bank("Tech Bank");
    
            
            bank.openAccountForCustomer("Alice", "1001");
            bank.openAccountForCustomer("Bob", "1002");
            
            
            bank.viewCustomerBalances("Alice"); 
            Customer alice = bank.findCustomer("Alice");
        alice.depositToAccount("1001", 5000);
        bank.viewCustomerBalances("Alice"); 

        bank.viewCustomerBalances("Bob");
        Customer bob = bank.findCustomer("Bob");
        bob.withdrawFromAccount("1002", 2000);
        bank.viewCustomerBalances("Bob"); 
    }
}
