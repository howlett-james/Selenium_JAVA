package CoreJAVA.episode_6;

public class ConstructorConcept {
    //JAVA having a Hidden constructor which is also called as Default constructor

    //Can we overload the Constructor?--- Yes, just like method overloading
    //Default
    //parameterized
    public ConstructorConcept(){
        System.out.println("Default Constructor");
    }
    public ConstructorConcept(int i){
        System.out.println("One Parameterized Constructor");
        System.out.println("The value of i " +i);
    }
    public ConstructorConcept(int i, int j){
        System.out.println("Two Parameterized Constructor");
        System.out.println("The value of i" +i);
        System.out.println("The value of j" +j);
    }

    public static void main(String[] args) {
        ConstructorConcept obj1 = new ConstructorConcept();
        ConstructorConcept obj2 = new ConstructorConcept(20);
        ConstructorConcept obj3 = new ConstructorConcept(21,8);
    }
}