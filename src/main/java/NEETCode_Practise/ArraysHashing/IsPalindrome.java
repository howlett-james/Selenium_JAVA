package NEETCode_Practise.ArraysHashing;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c :  s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stringBuilder.append(Character.toLowerCase(c));
            }
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        IsPalindrome obj = new IsPalindrome();
        System.out.println(obj.isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(obj.isPalindrome("tab a cat"));
    }
}
