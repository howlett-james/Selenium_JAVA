package NEETCode_Practise.ArraysHashing;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        for(int i=0; i<nums.length;i++){
            result[i] = left;
            left =  left * nums[i];
        }
        System.out.println(Arrays.toString(result));
        int right = 1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*right;
            right = right * nums[i];
        }
        return result;
    }
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int product = 1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    product = product * nums[j];
                    
                }     
            }
            result[i] = product;
        }
        return result;
    }
    

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        System.out.println(Arrays.toString(pes.productExceptSelf(new int[]{1,2,4,6})));
        System.out.println(Arrays.toString(pes.productExceptSelf1(new int[]{1,2,4,6})));
    }    
}
