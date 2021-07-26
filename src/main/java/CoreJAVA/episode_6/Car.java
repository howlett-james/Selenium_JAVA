package CoreJAVA.episode_6;

public class Car {
    //class variable
    int mod, wheel;

    public static void main(String[] args) {
        //new Car(); -- this is the object of Car class
        //new keyword is used to create the object
        //a,b,c --> object reference variables

        Car a = new Car();
        Car b = new Car();
        Car c = new Car();

        a.mod = 2013;
        a.wheel = 4;

        b.mod =2014;
        b.wheel = 4;

        c.mod = 2015;
        c.wheel = 4;

        System.out.println(a.mod +""+a.wheel);
        System.out.println(b.mod+""+b.wheel);
        System.out.println(c.mod+""+c.wheel);

    }
}