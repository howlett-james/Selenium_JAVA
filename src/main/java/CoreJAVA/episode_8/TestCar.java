package CoreJAVA.episode_8;

public class TestCar {
    public static void main(String[] args) {

        //Dynamic Polymorphism -- run time polymorphism
        BMW b = new BMW();
        b.start();
        b.refuel();
        b.theftsafety();
        b.stop();

        Car c =  new Car();
        c.start();
        c.refuel();
        c.stop();

        //Up Casting
        Car c1 = new BMW();//Child class object can be referred by parent class reference variables
        c1.start();
        c1.refuel();
        c1.stop();

        BMW bmw = (BMW) new Car();//ClassCastException
        bmw.start();
        bmw.refuel();
        bmw.theftsafety();
        bmw.stop();


    }
}
