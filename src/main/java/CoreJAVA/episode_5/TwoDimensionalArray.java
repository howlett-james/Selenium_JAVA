package CoreJAVA.episode_5;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        String[][] x = new String[3][5];
        System.out.println("Row Size" +x.length);//get the value of ROW
        System.out.println("Column Size" +x[0].length); //get the value of COLUMN

        //First Row
        x[0][0] = "A";
        x[0][1] = "B";
        x[0][2] = "C";
        x[0][3] = "D";
        x[0][4] = "E";
        //Second Row
        x[1][0] = "F";
        x[1][1] = "G";
        x[1][2] = "H";
        x[1][3] = "I";
        x[1][4] = "J";
        //Third Row
        x[2][0] = "K";
        x[2][1] = "L";
        x[2][2] = "M";
        x[2][3] = "N";
        x[2][4] = "O";
        //Print all the values
        for(int i = 0;i<x.length;i++){ //i=1;0<3;i++=>i=2-->3
            for(int j = 0;j<x[0].length;j++){//j=1;0<5;j++=>j=0-->1
                System.out.println(x[i][j]+ " ");//x[2][4]
            }
//            System.out.println();
        }
    }
}
