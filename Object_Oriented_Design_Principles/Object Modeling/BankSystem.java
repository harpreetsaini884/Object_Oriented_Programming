import java.util.ArrayList;
import java.util.List;


class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, initialDeposit);
        customer.addAccount(newAccount);
        return newAccount;
    }

    public String getName() {
        return name;
    }
}


class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Balances for " + name + ":");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println("Account " + (i + 1) + " in " + accounts.get(i).getBank().getName() + " - Balance: $" + accounts.get(i).getBalance());
        }
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double initialDeposit) {
        this.bank = bank;
        this.balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}


public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Alice Smith");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.openAccount(customer1, 1000);
        bank.openAccount(customer1, 500);
        bank.openAccount(customer2, 1500);

        customer1.viewBalance();
        customer2.viewBalance();
    }
}
