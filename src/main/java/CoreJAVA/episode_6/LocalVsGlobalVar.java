package CoreJAVA.episode_6;

public class LocalVsGlobalVar {
    //Global Variable -- Class Variable
    String name = "Tom";
    int age = 25;


    public static void main(String[] args) {
        int i =10; //Local Variable for main method
        System.out.println(i);
        LocalVsGlobalVar obj = new LocalVsGlobalVar();
        System.out.println(obj.name);
        System.out.println(obj.age);
    }
    public void sum(){
        int i = 100;//local variable for sum method
        int j = 200;
    }
}