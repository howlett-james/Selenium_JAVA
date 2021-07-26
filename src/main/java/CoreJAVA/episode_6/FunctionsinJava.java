package CoreJAVA.episode_6;

public class FunctionsinJava {
    int x;//class var
    int y;
    public static void main(String[] args) {
        FunctionsinJava obj = new FunctionsinJava();
        //one object will be created, obj is the reference variable, referring to this object
        //after creating the object, the copy of all non static methods will be give to this object

        obj.test();
        System.out.println(obj.pqr());
        System.out.println(obj.qa());
        System.out.println(obj.division(54654,44888));
        System.out.println(obj.multiplication(10,10));
        System.out.println(obj.multiplication(10.25,10.35));
        System.out.println(obj.multiplication(1.2,2.5));
        System.out.println(obj.multiplication(216545l,654498l));

    }
    //Non Static Methods
    //void -- doesn't have return value
    //return type -- void
    public void test(){     //no input, no output
        System.out.println("Test Method");
    }
    //return type -- int
    public int pqr(){       //no input, some output
        System.out.println("PQR Method");
        int a =10;
        int b =20;
        int c =a+b;
        return c;
    }
    //return type -- string
    public String qa(){     //no input, some output
        System.out.println("QA Method");
        return "Selenium";
    }
    //x,y - input parameters/arguments
    public double division(double x, double y){//double x & y -- local variable
        System.out.println("Division Method");
        double d = x/y;
        return d;
    }
    //Inside a class creating two methods with same name and same or different datatype parameters--method overloading

    public double multiplication(double x, double y){//local variable
        System.out.println("Multiplication Method --- double");
        double m=x*y;
        return m;
    }
    public int multiplication(int x, int  y){//method overloading
        System.out.println("Multiplication Method --Integer");
        int m=x*y;
        return m;
    }
    public float multiplication(float x, float y){
        System.out.println("Multiplication Method -- Float");
        float m = x*y;
        return m;
    }
    public long multiplication(long x,long y){
        System.out.println("Multiplication Method -- Long");
        long m=x*y;
        return m;
    }


}