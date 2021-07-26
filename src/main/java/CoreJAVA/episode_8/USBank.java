package CoreJAVA.episode_8;

public interface USBank {
    int min_bal =100;
    public void credit();
    public void debit();
    public void transfermoney();

    //only method declaration
    //no method body -- only method prototype
    //in interface, can declare the variables, variables are by default static and final
    //no static method in Interface
    //can't create the object of interface
    //Interface is abstract in nature
}
