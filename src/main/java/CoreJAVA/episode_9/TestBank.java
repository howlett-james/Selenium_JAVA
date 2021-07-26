package CoreJAVA.episode_9;

public class TestBank {
    public static void main(String[] args) {
        ICICIBank obj = new ICICIBank();
        obj.educationloan();
        obj.homeloan();
        obj.carloan();
        obj.credit();
        obj.debit();
        obj.trading();
        obj.transfermoney();
        obj.mutualFunds();
        obj.insurance();
        System.out.println("Minimum Balance"+obj.min_bal);

        USBank us = new ICICIBank();
        us.credit();
        us.debit();
        us.trading();
        us.transfermoney();
    }
}
