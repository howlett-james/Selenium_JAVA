package CoreJAVA.episode_3;

public class StringConcat {
    public static void main(String[] args) {
        int a =100;
        int b=200;
        String x ="James";
        String y = "Howlett";

        System.out.println(a +""+b );
        System.out.println(a+b+x+y);
        System.out.println(x+y+(a+b));
        System.out.println(x+y+a+b);
    }
}
