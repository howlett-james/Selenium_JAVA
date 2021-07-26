package CoreJAVA.episode_6;

public class A {
    public A(){
        System.out.println("Parent Class");
    }
    public A(int i){
        System.out.println("Parent Class construct with value of i" +i);
    }
    public A(int i, int j){
        System.out.println("Parent class constructor with value of i" + i +" j" +j);
    }
}