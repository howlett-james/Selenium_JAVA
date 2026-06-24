package NEETCode_Practise.ArraysHashing;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3};
        ContainsDuplicate dc = new ContainsDuplicate();
        System.out.println(dc.hasDuplicate(nums));
    }
}
