package CoreJAVA.episode_8;

public class Main {
    public static void main(String[] args) {
        BankAccount account = BankAccount.open("James Howlett");
        account.print();

        BankAccount afterDeposit = account.deposit(5000.00);
        BankAccount afterWithdraw = afterDeposit.withdraw(1200.50);

        afterWithdraw.print();

        System.out.println("Balance after 10% tax: ₹" + afterWithdraw.balanceAfterTax(0.10));

        System.out.println("Original balance: ₹" + account.balance());

        try {
            BankAccount bad = new BankAccount("", "ACC999", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
