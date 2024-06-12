package Programs.striverz.Arrays.Hard;

import java.util.HashMap;

public class LargestSubArraySumWithZero {
    public static void main(String[] args) {
        int [] arr = {9, -3, 3, -1, 6, -5};
        System.out.println(largestSubArrSumZero(arr));
    }
    public static int largestSubArrSumZero (int [] arr){
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0){
                maxi = i + 1;
            }else {
                if (mpp.get(sum) != null){
                    maxi = Math.max(maxi,i - mpp.get(sum));
                }else {
                    mpp.put(sum,i);
                }
            }
        }
        return maxi;
    }
}
