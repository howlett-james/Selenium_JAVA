package CoreJAVA.episode_4;

public class Patterns {
    public static void main(String[] args) {
        int row=10;
        for(int i =1;i<row;i++) {//4<=10;i=3-->4
            for (int j = 1; j <= i; j++) {//4<=4;j=4-->5
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
