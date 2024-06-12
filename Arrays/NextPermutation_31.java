package Programs.striverz.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int [] nums = {2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(findNextPermutaion(nums)));
    }

    //LeetCode
    public static int [] findNextPermutaion(int [] nums){
        int n = nums.length;
        int idx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }
        if (idx == -1){
            reverse(nums,0,n - 1);
            return nums;
        }
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(nums,idx + 1,n - 1);
        return nums;
    }
    public static void reverse(int [] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //Coding Ninjas
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        // Write your code here.
        int n = A.size();

        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(A);
            return A;
        }

        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                int tmp = A.get(i);
                A.set(i, A.get(ind));
                A.set(ind, tmp);
                break;
            }
        }

        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;
    }

}
