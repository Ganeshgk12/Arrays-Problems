package Programs.striverz.Arrays;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
    public static void main (String [] args){
        int [] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k)); //Better
        System.out.println(subArraySumOptimal(nums,k)); //Optimal

    }

    //Optimal

    public static int subArraySumOptimal(int [] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum,0) + 1);
        }
        return count;
    }


    // Better Approach
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += nums[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }
}
