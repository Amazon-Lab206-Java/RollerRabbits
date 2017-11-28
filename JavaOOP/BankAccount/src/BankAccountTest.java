public class BankAccountTest {
    public static void main(String[] args){
        BankAccount a= new BankAccount();
        a.depositMoney(200.45, true);
        BankAccount b= new BankAccount();
        b.depositMoney(104.39, false);
        a.withrawMoney(145, true);
        b.withrawMoney(103,false);
        a.checkBalance();
        b.checkBalance();
    }
}
