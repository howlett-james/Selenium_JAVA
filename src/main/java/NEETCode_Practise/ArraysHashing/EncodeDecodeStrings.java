package NEETCode_Practise.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        String encoded = "";
        for(String str : strs){
            encoded += str.length() + "#" + str;
        }
        return encoded;
    }
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i =0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int n = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1,j+n+1);
            result.add(word);
            i=j+n+1;
        }
        return result;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings eds = new EncodeDecodeStrings();
        System.out.println(eds.encode(new ArrayList<>(Arrays.asList("helloworld","java!!"))));
        System.out.println(eds.decode(eds.encode(new ArrayList<>(Arrays.asList("helloworld","java!!")))));
    }
}