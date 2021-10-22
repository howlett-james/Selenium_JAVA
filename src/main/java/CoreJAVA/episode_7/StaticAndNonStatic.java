package CoreJAVA.episode_7;

public class StaticAndNonStatic {
    //global variables: the scope of global variables will be available across all the functions with some condition
    String name = "logan";
    static int age = 22;
    public static void main(String[] args) {
        //how to call static methods and var?
        //1. direct calling
        sum();
        //2. Calling by classname
        StaticAndNonStatic.sum();

        System.out.println(age);
        System.out.println(StaticAndNonStatic.age);

        //how to call a non static methods and var?
        StaticAndNonStatic obj = new StaticAndNonStatic();
        obj.sendMail();
        System.out.println(obj.name);

        //can I access static methods by suing object reference
        obj.sum();//warning will be given
    }
    public void sendMail(){
        System.out.println("Send mail method");
    }
    public static void sum(){
        System.out.println("Sum Method");
    }
}