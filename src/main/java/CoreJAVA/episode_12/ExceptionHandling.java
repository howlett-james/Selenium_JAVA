package CoreJAVA.episode_12;

public class ExceptionHandling {
    /*int a=10;
    static ExceptionHandling obj;*/
    public static void main(String[] args) {
        //uncaught exception
//        int i = 9/0;
//        System.out.println(i);

        //caught exception
        //Thread.sleep(2000);

//        ExceptionHandling obj = new ExceptionHandling();
//        obj = null;
//        System.out.println(obj.a);//throws NullPointerException

        //1. try-catch block;
        try {
            int i=9/0; //this code will throw an exception
        }catch (/*ArithmeticException*/ /*Throwable*/ Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Hey --  this / by zero error");
        }
        System.out.println("ABC");


    }
}