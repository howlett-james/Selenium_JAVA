package CoreJAVA.episode_8;

public class TestBank {
    public static void main(String[] args) {
        System.out.println("Minimum Balance"+USBank.min_bal);
        //USBank.min_bal =200; -- can't change
        HSBCBank hs= new HSBCBank();
        hs.credit();
        hs.debit();
        hs.transfermoney();
        hs.educationloan();
        hs.CarLoan();
        hs.MutualFund();

        //dynamic polymorphism
        //child class object can referred by parent Interface reference variable
        USBank us = new HSBCBank();
        us.credit();
        us.debit();
        us.transfermoney();


    }
}
