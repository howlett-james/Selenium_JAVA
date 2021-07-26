package CoreJAVA.episode_9;

public abstract class Shape{
    Shape(){
        System.out.println("Shape Class Constructor");
    }

    int color;
    abstract void drawing();
    public void fill(){
        System.out.println("Shape -- Fill");
    }
    //can't create the object of interface
}