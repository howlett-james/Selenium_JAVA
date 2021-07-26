package CoreJAVA.episode_6;

public class MethodOverloading {
    public static void main(String[] args) {
        //Compile time Polymorphism
        MethodOverloading obj = new MethodOverloading();
        obj.sum();
        obj.sum(10);
        obj.sum(20,30);
    }
    public static void main(int i){

    }
    public static void main(int i, int j){

    }
    //can overload main method too
    //can't create a method inside a method

    //Method overloading --> when the method name is same with different arguments or input parameters within the same class
    public void sum(){
        System.out.println("SUM Method -- Zero param");
    }
    public void sum(int i){
        System.out.println("SUM Method -- One Param " + i);
    }
    public void sum(int j, int k) {
        System.out.println("SUM Method -- Two Param " +j +" , "+k);
    }
}
