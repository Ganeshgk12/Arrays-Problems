package Programs.striverz.Arrays;

public class LongestSubArrayWithK {
    public static void main(String[] args) {
        int [] arr = {1,4,5,2,7,1,9,1,2};
        int k = 9;
        System.out.println(longestSubArray(arr,k));
    }
    public static int longestSubArray(int [] arr, int k){

        int n = arr.length;
        int left= 0;
        int right = 0;
        int maxLen = 0;
        int sum = arr[0];

        while (right < n){
            while (left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if (sum == k){
                maxLen = Math.max(maxLen,right - left + 1);
            }
            right++;

            if (right < n){
                sum += arr[right];
            }
        }
        return maxLen;
    }
}
