package Programs.striverz.Arrays;

public class MaxConcecutiveOnes_485 {
    public static void main(String[] args) {

       int [] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    // optimal
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int freq = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                ++freq;
            }

            else{
                ans = Math.max(freq,ans);
                freq = 0;
            }
        }
        return (freq > ans) ? freq : ans;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currentOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                currentOnes++;
            }else {
                maxOnes = maxOnes < currentOnes ? currentOnes : maxOnes;
                currentOnes = 0;
            }
        }
        maxOnes = maxOnes < currentOnes ? currentOnes : maxOnes;
        return maxOnes;
    }
}
