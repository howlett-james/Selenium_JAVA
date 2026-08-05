package JAVAProblems.Level1;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello World";
        char[] chars = str.toCharArray();
        String revStr ="";
        for (int i = chars.length-1; i >= 0; i--) {
            revStr += chars[i];
        }
        System.out.println(revStr);
        System.out.println(new StringBuilder(str).reverse());
    }
}
