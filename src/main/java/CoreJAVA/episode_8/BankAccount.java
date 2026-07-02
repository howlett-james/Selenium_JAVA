package CoreJAVA.episode_8;

public record BankAccount(String owner, String accountNumber, double balance)
implements Printable,Transferable{
    public BankAccount{
        if(owner == null || owner.isBlank()) throw new IllegalArgumentException("Owner name cannot be null or blank");
        if(balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        owner = owner.trim();
    }
    public static BankAccount open(String owner){
        String generatedNumber = "ACC" + System.currentTimeMillis();
        return new BankAccount(owner,generatedNumber,0.0);
    }

    public double balance(){
        return Math.round(balance*100)/100.0;
    }

    public boolean isOverdrawn(){
        return balance < 0;
    }

    public double balanceAfterTax(double taxRate){
        return balance() * (1-taxRate);
    }

    @Override
    public BankAccount deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        return new BankAccount(owner, accountNumber, balance + amount);
    }

    @Override
    public BankAccount withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new IllegalStateException("Insufficient funds");
        return new BankAccount(owner, accountNumber, balance - amount);
    }

    @Override
    public void print() {
        System.out.println("=== Bank Account ===");
        System.out.println("Owner   : " + owner);
        System.out.println("Account : " + accountNumber);
        System.out.println("Balance : ₹" + balance());
        System.out.println("Status  : " + (isOverdrawn() ? "OVERDRAWN" : "OK"));
    }
}