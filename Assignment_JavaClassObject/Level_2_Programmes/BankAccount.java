public class BankAccount {
    String AccountHolder;
    String AccountNumber;
    double Balance;
    BankAccount(String AccountHolder,String AccountNumber,double Balance){
        this.AccountHolder=AccountHolder;
        this.AccountNumber=AccountNumber;
        this.Balance=Balance;
    }
    void DepositingMoney(double amount){
        if(amount >0){
            Balance+=amount;
            System.out.println("Deposited Money->"+amount);
            System.out.println("Balance->"+Balance);
        }
        else{
            System.out.println("invalid deposited Amount. Add a positive value");
        }
    }
    void Withdrawing(double withAmount){
        if(withAmount>0 && withAmount<=Balance){
            Balance-=withAmount;
            System.out.println("Withdrawn Amount->"+withAmount);
            System.out.println("Balance->"+Balance);
        }
        else if(withAmount>Balance){
            System.out.println("Insufficient Balance! your balance is "+Balance);
        }
        else{
            System.out.println("enter some valid input");
        }
    }
    void Display(){
        System.out.println("AccountHolder->"+AccountHolder);
        System.out.println("Account Number->"+AccountNumber);
        System.out.println("Balance->"+Balance);
        // System.out.println("Depositing Money->"+DepositingMoney(););
    }
    public static void main(String[] args){
        BankAccount bk=new BankAccount("Harpreet", "2030101561037", 7668);
        bk.Display();
        bk.Withdrawing(500);
        bk.DepositingMoney(1000);

    }
}
