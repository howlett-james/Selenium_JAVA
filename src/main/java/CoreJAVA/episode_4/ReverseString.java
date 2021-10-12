package CoreJAVA.episode_4;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hey There";
        char[] ch =str.toCharArray();
        StringBuilder rev= new StringBuilder();
        for(int i=ch.length-1;i>=0;i--){
            rev.append(ch[i]);
        }
        System.out.println(rev);
    }
}
