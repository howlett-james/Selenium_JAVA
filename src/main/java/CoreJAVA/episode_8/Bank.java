package CoreJAVA.episode_8;

import java.util.Scanner;

public class Bank {

    private final int accountNo =123456;
    private static int pinNo =1234;
    private static double balanceAmount =1200000;
    private static double amount ;
    Scanner scanner = new Scanner(System.in);

    public void withdrawAmount(){
        if (!checkCredentials()) {
            System.out.println("Invalid Credentials !");
        } else {
            amount=getWithdrawalAmount();
            if(amount <=balanceAmount){
                balanceAmount -= amount;
                System.out.println("Amount Withdrawal: "+amount);
                System.out.println("Balance Amount: " +balanceAmount);
            }else {
                System.out.println("Insufficient Balance !");
            }
        }
    }

    public void updatePin(){
        if (!checkCredentials()) {
            System.out.println("Invalid Credentials !");
        } else {
            System.out.println("Enter Your New Pin");
            pinNo = scanner.nextInt();
            System.out.println("Pin Changed Successfully !");
        }
    }

    public double depositCash(){
        if(checkCredentials()){
            System.out.println("Enter the Amount to Deposit:");
            amount = scanner.nextDouble();
            balanceAmount += amount;
        }else {
            System.out.println("Invalid Credentials");
        }
        return balanceAmount;
    }
    public boolean checkCredentials(){
        System.out.println("Enter Your Account Number: ");
        int accNo = scanner.nextInt();
        System.out.println("Enter Your Pin: ");
        int pin = scanner.nextInt();
        if(!(accNo == accountNo) && (pin == pinNo)){
            System.out.println("Invalid Credentials !");
        }
        return true;
    }
    public double getWithdrawalAmount(){
        System.out.println("Enter Withdrawal Amount: ");
        return scanner.nextDouble();
    }
}
