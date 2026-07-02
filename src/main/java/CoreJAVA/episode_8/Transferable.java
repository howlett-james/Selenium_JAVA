package CoreJAVA.episode_8;

public interface Transferable {
    BankAccount deposit(double amount);
    BankAccount withdraw(double amount);
}
