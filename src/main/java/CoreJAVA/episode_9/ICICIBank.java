package CoreJAVA.episode_9;

public class ICICIBank implements USBank,RBIBank{

    @Override
    public void educationloan() {
        System.out.println("ICICI -- Education Loan");

    }

    @Override
    public void homeloan() {
        System.out.println("ICICI -- Home Loan");
    }

    @Override
    public void carloan() {
        System.out.println("ICICI -- Car Loan");
    }

    @Override
    public void credit() {
        System.out.println("ICICI -- Credit");
    }

    @Override
    public void debit() {
        System.out.println("ICICI -- Debit");
    }

    @Override
    public void trading() {
        System.out.println("ICICI -- Trading");
    }

    @Override
    public void transfermoney() {
        System.out.println("ICICI -- Transfer Money");
    }

    public void mutualFunds(){
        System.out.println("ICICI -- Mutual Fund");
    }

    public void insurance(){
        System.out.println("ICICI -- Insurance");
    }
}