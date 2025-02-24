public class BankAccount  {
        public String accountNumber;
        protected String accountHolder;
        private double balance;

        BankAccount(String accountNumber,String accountHolder,double balance){
            this.accountNumber=accountNumber;
            this.accountHolder=accountHolder;
            this.balance=balance;
        }
        public void setBalance(double balance){
            this.balance=balance;
        }
        public double getBalance(){
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
        public void display() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: " + balance);
        }
    
        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
    class SavingsAccount extends BankAccount{
        public  SavingsAccount(String accountNumber,String accountHolder,double balance){
            super(accountNumber,accountHolder,balance);

        }
        public void display(){
            super.display();
        }
    }
    public static void main(String[] args){
           BankAccount ba=new BankAccount("2030101561037", "Harpreet", 7658);
           ba.display();
           ba.withdraw(1234);
           ba.display();    
    }
}
