package CoreJAVA.episode_6;

public class Calculator {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b){
        return a/b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Addition " + calc.add(1,3));
        System.out.println("Subtraction "+ calc.sub(3,1));
        System.out.println("Multiplication "+ calc.multiply(3,3));
        System.out.println("Division "+calc.divide(30,3));
    }
}
