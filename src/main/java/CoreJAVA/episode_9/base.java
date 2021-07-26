package CoreJAVA.episode_9;

public class base extends Shape{
    base(){
        System.out.println("Base class constructor");
    }
    public static void main(String[] args) {
        /*Shape s =new base();
        s.drawing();
        s.fill();*/
        base b = new base();

    }
    @Override
    void drawing() {
        System.out.println("Base -- Drawing");
    }


}