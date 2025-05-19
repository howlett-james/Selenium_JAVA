package CoreJAVA.episode_8;

import java.util.Scanner;

public class ATM {

    static Scanner scanner = new Scanner(System.in);
    static int option, accNo, pin, amount;
    public static void main(String[] args) {
        System.out.println("1. Withdrawal Amount");
        System.out.println("2. Change Pin");
        System.out.println("3. Deposit Amount");
        option = scanner.nextInt();
        Bank bank = new Bank();
        switch (option) {
            case 1:
                bank.withdrawAmount();
                break;
            case 2:
                bank.updatePin();
                break;
            case 3:
                System.out.println("Your Account Balance is: " +bank.depositCash());
                break;
        }
    }
}
