package CoreJAVA.episode_3;

public class IfElseConcept {
    public static void main(String[] args) {
        int a =10;
        int b = 20;
        if(a>b){
            System.out.println("A is Greater than B");
        }else{
            System.out.println("B is Greater than A");
        }
        //Comparison Operator
        //< > <= >= == !=

        int c = 40;
        int d = 40;
        if(c==d){
            System.out.println("C and D are equal");
        }else{
            System.out.println("C and D are not equal");
        }

        //Write a logic to find out the highest number
        int x = 100;
        int y = 200;
        int z = 300;

        //nested if-else
        if(x>y & x>z){
            System.out.println("X is Greatest");
        }else if(y>z){
            System.out.println("Y is Greatest");
        }else{
            System.out.println("Z is Greatest");
        }
    }
}
