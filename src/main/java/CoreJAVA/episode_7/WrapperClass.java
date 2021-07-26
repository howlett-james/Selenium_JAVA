package CoreJAVA.episode_7;

import org.apache.poi.hssf.model.InternalWorkbook;

public class WrapperClass {
    public static void main(String[] args) {

        String x="100";
        System.out.println(x+200);

        //data conversion String to int
        int i = Integer.parseInt(x);
        System.out.println(i+200);

        //Integer, Double, Boolean

        //String to double
        String y ="22.55";
        double d = Double.parseDouble(y);
        System.out.println(d+10);

        //String to Boolean
        String k = "true";
        Boolean b = Boolean.parseBoolean(k);
        System.out.println(b);

        //int to string
        int j = 200;
        System.out.println(j+200);
        String s = String.valueOf(j);
        System.out.println(s+20);

        String u ="100A";
        Integer.parseInt(u);//NumberFormatException
    }
}