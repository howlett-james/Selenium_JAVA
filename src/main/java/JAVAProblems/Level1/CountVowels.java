package JAVAProblems.Level1;

public class CountVowels {
    public static void main(String[] args) {
        String str = "HELLO WORLD";
        char[] vowels = {'a','e','i','o','u'};
        int count =0;
        char[] chars = str.toLowerCase().toCharArray();
        for(int i =0;i<chars.length;i++){
            for(int j = 0; j<vowels.length;j++){
                if(chars[i]==vowels[j]){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
