package CoreJAVA.episode_8;

public class HSBCBank implements USBank, BrazilBank{ //achieved multiple Inheritance
    //"Is-a Relationship"


    //If a class is implementing any interface, then its mandatory to define/override all the methods of Interface
    //Overriding from USBank
    @Override
    public void credit() {
        System.out.println("HSBC -- Credit");
    }

    @Override
    public void debit() {
        System.out.println("HSBC -- Debit");
    }

    @Override
    public void transfermoney() {
        System.out.println("HSBC -- Transfer Money");
    }

    public void educationloan(){
        System.out.println("HSBC -- Education Loan");
    }

    public void CarLoan(){
        System.out.println("HSBC -- Car Loan");
    }

    @Override
    public void MutualFund() {
        System.out.println("Brazil Bank -- Mutual Fund");
    }
}
