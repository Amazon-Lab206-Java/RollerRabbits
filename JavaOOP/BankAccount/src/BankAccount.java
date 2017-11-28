import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;

    public static int numberOfAccounts=0;
    public static double amountofMoney=0;



    private String generateRandomAccountNumber(){
        Random generate= new Random();
        String tenRandomDigits = "";
        for (int i=0; i<10; i++) {
            tenRandomDigits.concat(String.valueOf(generate.nextInt(10)));
        }
        return tenRandomDigits;
    }

    public BankAccount() {
        accountNumber= generateRandomAccountNumber();
        numberOfAccounts+=1;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void depositMoney(double money, boolean isChecking){
        if (isChecking == true) {
            checkingBalance += money;
        } else {
            savingsBalance += money;
        }
        amountofMoney+=money;
    }
    public void withrawMoney(double money, boolean isChecking){
        if (isChecking==true){
            if (checkingBalance>=money){
                checkingBalance-=money;
            }else{
                throw new RuntimeException("You don't have enough money");
            }
        }else{
            if(savingsBalance>=money) {
                savingsBalance -= money;
            }else{
                throw new RuntimeException("You don't have enough money bum");
            }
        }
    }
    public void checkBalance(){
        System.out.println("Your checking account has: "+checkingBalance);
        System.out.println("Your savings account has: "+savingsBalance);
    }
}

