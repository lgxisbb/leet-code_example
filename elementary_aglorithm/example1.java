/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class example1{


    /**
     * leetCode 8 ms 大神答案
     */
    public int fristEffciencyAnswer(int []nums){
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]){
                nums[len++] = nums[i];               
            }
        }
        return len;
    }

    /**
     * 
     */
    public int removeDuplicates(int[] nums) {
        int len = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (i == 0) {
                n = j;
                len++;
            } else if (j > n) {
                n = j;
                nums[len] = n;
                len++;
            }
        }
        return len;
    }
}