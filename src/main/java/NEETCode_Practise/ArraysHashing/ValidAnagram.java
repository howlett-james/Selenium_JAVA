package NEETCode_Practise.ArraysHashing;

import org.jspecify.annotations.NonNull;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(@NonNull String s, @NonNull String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toLowerCase().toCharArray();
        char[] tArray = t.toLowerCase().toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("racecar","carrace"));
        System.out.println(validAnagram.isAnagram("jar","jam"));
    }
}
